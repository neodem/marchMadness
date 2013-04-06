/* file 	: 	DefaultRoundSpotConverter.java
 * created 	:	Feb 12, 2006
 * modified :	
 */

package com.neodem.madness.tournament.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.neodem.madness.tournament.service.RoundSpotConverter;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 * 
 */
public class MarchMadnessRoundSpotConverter implements RoundSpotConverter {
	
	
	protected Map seedPositionArrays;

	/**
	 * 
	 */
	public MarchMadnessRoundSpotConverter() {
		super();
		seedPositionArrays = new HashMap();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neodem.madness.service.RoundSpotConverter#determineConference(int,
	 *      int, int)
	 */
	public int determineConference(int round, int spot, int totalRounds) {
		if (totalRounds <= 0) {
			throw new IllegalArgumentException("tournament must have 1 or more rounds");
		}
		int numberOfGames = getNumberOfGamesForRound(round, totalRounds);
		int confGames = numberOfGames / 4;

		int conference = spot / confGames;

		return conference;
	}

	/**
	 * @return
	 */
	public int getTotalNumberOfGames(int totalRounds) {
		int num = 0;
		for (int i = 0; i < totalRounds; i++) {
			num += getNumberOfGamesForRound(i, totalRounds);
		}
		return num;
	}

	public int getNumberOfGamesForRound(int roundNumber, int totalRounds) {
		return (int) Math.pow(2, totalRounds - roundNumber - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neodem.madness.service.RoundSpotConverter#determineSpotInConference(int,
	 *      int)
	 */
	public int determineSpotInConference(int seed, int totalRounds) {
		// get the correct array
		int[] array = getArray(totalRounds);

		int spot = -1;
		for (int i = 0; i < array.length; i++) {
			if (i % 2 == 0) spot++;
			if (seed == array[i]) {
				return spot;
			}
		}
		return spot;
	}

	/**
	 * get the correct stored array or make a new one
	 * 
	 * @param totalRounds
	 * @return
	 */
	protected int[] getArray(int totalRounds) {
		Integer key = new Integer(totalRounds);
		int[] array = (int[]) seedPositionArrays.get(key);

		if (array == null) {
			array = getFlatTree(totalRounds);
			seedPositionArrays.put(key, array);
		}

		return array;
	}

	/**
	 * reuturn the higher ranked seed for the game
	 * 
	 * @param seed
	 * @param gamesInRound
	 * @return
	 */
	protected int getTopSeed(int seed, int gamesInRound) {
		int halfGames = gamesInRound / 2;
		seed = getTopSeed(seed, gamesInRound);

		if (seed >= halfGames) {
			return seed;
		}

		return (gamesInRound + 1 - seed);
	}

	protected int[] getFlatTree(int level) {
		int[] array = new int[] { 1 };
		if (level == 0) return array;
		for (int i = 0; i < level; i++) {
			array = getArray(array, i + 1);
		}

		return array;
	}

	protected int[] getArray(int[] seedArray, int level) {
		int seedSize = seedArray.length;
		int size = (int) Math.pow(2, level);
		int[] newArray = new int[size];
		int j = 0;
		for (int i = 0; i < seedSize; i++) {
			int seed = seedArray[i];
			if (seed % 2 == 0) {
				newArray[j + 1] = seed;
				newArray[j] = ((int) Math.pow(2, level)) - seed + 1;
			} else {
				newArray[j] = seed;
				newArray[j + 1] = ((int) Math.pow(2, level)) - seed + 1;
			}

			j = j + 2;
		}

		return newArray;
	}

}
