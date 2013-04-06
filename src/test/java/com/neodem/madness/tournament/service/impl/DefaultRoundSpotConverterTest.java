/* file 	: 	DefaultRoundSpotConverterTest.java
 * created 	:	Feb 12, 2006
 * modified :	
 */

package com.neodem.madness.tournament.service.impl;

import com.neodem.madness.tournament.service.impl.MarchMadnessRoundSpotConverter;

import junit.framework.TestCase;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class DefaultRoundSpotConverterTest extends TestCase {
	
	public void testGetNumberOfGamesForRound() {	
		// one round = 1 game
		assertEquals(1, service.getNumberOfGamesForRound(0,1));
		
		// 2 rounds = 2 + 1 games
		assertEquals(2, service.getNumberOfGamesForRound(0,2));
		assertEquals(1, service.getNumberOfGamesForRound(1,2));
		
		// 3 rounds = 4 + 2 + 1 games
		assertEquals(4, service.getNumberOfGamesForRound(0,3));	
		assertEquals(2, service.getNumberOfGamesForRound(1,3));
		assertEquals(1, service.getNumberOfGamesForRound(2,3));
		
		// 6 rounds (like the march madness)
		assertEquals(32, service.getNumberOfGamesForRound(0,6));
		assertEquals(16, service.getNumberOfGamesForRound(1,6));
		assertEquals(8, service.getNumberOfGamesForRound(2,6));		
		assertEquals(4, service.getNumberOfGamesForRound(3,6));
		assertEquals(2, service.getNumberOfGamesForRound(4,6));
		assertEquals(1, service.getNumberOfGamesForRound(5,6));
	}
	
	public void testGetTotalNumberOfGames() {
		assertEquals(1, service.getTotalNumberOfGames(1));
		assertEquals(3, service.getTotalNumberOfGames(2));
		assertEquals(7, service.getTotalNumberOfGames(3));
		assertEquals(63, service.getTotalNumberOfGames(6));
	}
	
	public void testGetConference() {
		// assume the bracket has south in the top left, this is conf 0
		// West is bottom left, this is 1
		// East is top right, this is 2
		// MidWest is bottom right, this is 3
		
		// assume 6 rounds and this is all for first round (#0)
		assertEquals(0, service.determineConference(0,0,6));
		assertEquals(0, service.determineConference(0,7,6));
		assertEquals(1, service.determineConference(0,8,6));
		assertEquals(1, service.determineConference(0,15,6));
		assertEquals(2, service.determineConference(0,16,6));
		assertEquals(2, service.determineConference(0,23,6));
		assertEquals(3, service.determineConference(0,24,6));
		assertEquals(3, service.determineConference(0,31,6));	
	}
	
	public void testGetFlatTree() {
		int[] array = service.getFlatTree(0);
		assertEquals(1, array.length);
		assertEquals(1, array[0]);
		
		array = service.getFlatTree(1);
		assertEquals(2, array.length);
		assertEquals(1, array[0]);
		assertEquals(2, array[1]);
		
		array = service.getFlatTree(4);
		assertEquals(16, array.length);
		assertEquals(1, array[0]);
		assertEquals(16, array[1]);
		assertEquals(9, array[2]);
		assertEquals(8, array[3]);
		assertEquals(5, array[4]);
		assertEquals(12, array[5]);
		assertEquals(13, array[6]);
		assertEquals(4, array[7]);
		assertEquals(3, array[8]);
		assertEquals(14, array[9]);
		assertEquals(11, array[10]);
		assertEquals(6, array[11]);
		assertEquals(7, array[12]);
		assertEquals(10, array[13]);
		assertEquals(15, array[14]);
		assertEquals(2, array[15]);
	}
	
	public void testDetermineSpotInConference() {
		// 16 seed in a 4 round conf should be pos 0
		assertEquals(0, service.determineSpotInConference(16,4));
		// so should the 1 seed
		assertEquals(0, service.determineSpotInConference(1,4));
		
		// 2 seed in a 4 round conf should be pos 7
		assertEquals(7, service.determineSpotInConference(2,4));
		// so should the 15 seed
		assertEquals(7, service.determineSpotInConference(15,4));
	}

	
	/////////////////////////////////////////////////////////////////
	
	private MarchMadnessRoundSpotConverter service;
	
	/**
	 * Constructor for FullIntegrationTest.
	 * @param name
	 */
	public DefaultRoundSpotConverterTest(String name) {
		super(name);
		service = new MarchMadnessRoundSpotConverter();
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
