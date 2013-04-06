package com.neodem.madness.core;

import com.neodem.madness.db.beans.Team;
import com.neodem.madness.tournament.decider.Decider;

/**
 * A simple holder for a given set of games. The round will hold the games in a
 * specific order determined by the "roundSpot". A compute() command can be
 * executed at which time, all of the games are computed. At that point a winner
 * can be determined for each game.
 * 
 * @author Vincent Fumo (neodem@gmail.com)
 * 
 */
public class Round {

	protected Game[] games;
	protected int numberOfGames;
	protected int roundNumber;
	protected int gamesRegistered;

	/**
	 * 
	 */
	public Round(int numberOfGames, int roundNumber) {
		games = new Game[numberOfGames];
		this.numberOfGames = numberOfGames;
		this.roundNumber = roundNumber;
		gamesRegistered = 0;
	}

	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("Round[");
		b.append(roundNumber);
		b.append("] - ");
		b.append(numberOfGames);
		b.append(" games");
		return b.toString();
	}

	public String getFullRound() {
		StringBuffer b = new StringBuffer();
		b.append("----------------------\n");
		b.append(this.toString());
		b.append("\n");
		b.append("----------------------\n");
		Game[] gameSet = getAllGames();
		int len = gameSet.length;
		if (len > 0) {
			for (int i = 0; i < len; i++) {
				Game game = gameSet[i];
				if(game != null) {
					b.append(gameSet[i].toString());
					b.append("\n");
				}
			}
		} else {
			b.append("<no games registered>\n");
		}

		return b.toString();
	}

	public Game[] getAllGames() {
		return games;
	}

	public void addGame(int roundSpot, Game game) {
		if(roundSpot > numberOfGames) return;
		if(roundSpot < 0) return;
		games[roundSpot] = game;
		gamesRegistered++;
	}

	/**
	 * @param roundSpot
	 * @return
	 */
	public Game getGame(int roundSpot) {
		if(roundSpot > numberOfGames) return null;
		if(roundSpot < 0) return null;
		return games[roundSpot];
	}

	public Team getWinner(int roundSpot) {
		if(roundSpot > numberOfGames) return null;
		if(roundSpot < 0) return null;
		Game game = getGame(roundSpot);
		if (game == null) return null;
		return game.getWinner();
	}

	public void computeRound(Decider decider) {
		if(decider == null) {
			throw new IllegalArgumentException("decider may not be null");
		}
		
		Game[] gameSet = getAllGames();
		int len = gameSet.length;
		if (len > 0) {
			for (int i = 0; i < len; i++) {
				decider.decide(gameSet[i]);
			}
		} 
	}

	
	/**
	 * @return Returns the games.
	 */
	public Game[] getGames() {
		return games;
	}

	
	/**
	 * @return Returns the numberOfGames.
	 */
	public int getNumberOfGames() {
		return numberOfGames;
	}

	
	/**
	 * @return Returns the roundNumber.
	 */
	public int getRoundNumber() {
		return roundNumber;
	}

	
	/**
	 * @return Returns the gamesRegistered.
	 */
	public int getGamesRegistered() {
		return gamesRegistered;
	}

}
