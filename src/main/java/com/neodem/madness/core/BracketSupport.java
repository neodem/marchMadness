/* file 	: 	AbstractBracket.java
 * created 	:	Feb 16, 2006
 * modified :	
 */

package com.neodem.madness.core;

import com.neodem.common.utility.text.DisplayHelper;
import com.neodem.madness.db.beans.Team;
import com.neodem.madness.tournament.decider.Decider;

/** will manage a number of rounds (starting at the 0 round and working
 * in towards the numberOfRounds).
 * 
 * @author Vincent Fumo (neodem@gmail.com)
 * 
 */
public abstract class BracketSupport implements Bracket {

	protected String bracketName;
	protected Team winner;
	protected int numberOfFirstRoundTeams;
	protected int numberOfFirstRoundGames;
	protected int numberOfRounds;
	protected Round[] rounds;

	public BracketSupport(int numberOfRounds) {
		this.numberOfRounds = numberOfRounds;
		this.numberOfFirstRoundGames = getNumberOfFirstRoundGames();
		this.numberOfFirstRoundTeams = numberOfFirstRoundGames * 2;
		setupRounds();
		onSetup();
	}
	
	/**
	 * for overriding
	 */
	protected void onSetup() {
		
	}

	/**
	 * @param numberOfRounds
	 * @param name
	 */
	public BracketSupport(int numberOfRounds, String name) {
		this(numberOfRounds);
		this.bracketName = name;
	}

	/**
	 * 
	 */
	protected void setupRounds() {
		rounds = new Round[numberOfRounds];
		for (int i = 0; i < numberOfRounds; i++) {
			int numberOfGames = getNumberOfGamesForRound(i, numberOfRounds);
			rounds[i] = new Round(numberOfGames, i);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neodem.madness.common.bracket.Bracket#addFirstRoundTeam(com.neodem.madness.common.Team)
	 */
	public void addFirstRoundTeam(Team team) {
		if (team == null) return;
		int seed = team.getSeed();
		if (seed <= 0) return;
		if (seed > numberOfFirstRoundTeams) return;

		placeTeamInFirstRoundGame(seed, team);
	}

	/**
	 * @param seed
	 * @param team
	 */
	protected abstract void placeTeamInFirstRoundGame(int seed, Team team);
	

	// -------------------------------  computations
	
	public void compute(Decider decider) {
		
		// fill the next round with results from the
		// first round (or from the first round
		// game set), compute that round, repeat for
		// all rounds
		for (int i = 0; i < numberOfRounds; i++) {
			fillRound(i);
			rounds[i].computeRound(decider);
		}

		// winner is the winner of the last game
		winner = rounds[numberOfRounds - 1].getWinner(0);
	}
		
	/** if roundNumber is 0, this is the first round
	 * @param roundNumber
	 */
	protected abstract void fillRound(int roundNumber);

	//----------------------------- display functions
	
	public String toString() {
		StringBuffer b = new StringBuffer();
		
		if(bracketName != null) {
			b.append(bracketName);
			b.append(" bracket");
		}
		else {
			b.append("Bracket");
		}
		b.append(" with ");
		b.append(numberOfRounds);
		b.append(" rounds");
		if(winner != null) {
			b.append(" - winnner = ");
			b.append(winner);
		}
		
		return b.toString();
	}
	
	public String getDisplay() {
		StringBuffer b = new StringBuffer();
		String text = this.toString();
		int size = text.length() + 4;
		b.append(DisplayHelper.create3RowSurroundBox(text, "=", '|', size));

		for (int i = 0; i < numberOfRounds; i++) {
			b.append(rounds[i].getFullRound());
			b.append("\n");	
		}
		
		return b.toString();
	}
	
	
	//----------------------------------- helpers
	
	public static int getNumberOfGamesForRound(int roundNumber, int totalRounds) {
		return (int) Math.pow(2, totalRounds - roundNumber - 1);
	}

	/**
	 * 
	 */
	public int getNumberOfFirstRoundGames() {
		return getNumberOfGamesForRound(0, numberOfRounds);
	}

	
	//------------------------------------ accessors
	
	/**
	 * @return Returns the name.
	 */
	public String getBracketName() {
		return bracketName;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	public void setBracketName(String name) {
		this.bracketName = name;
	}

	/**
	 * @return Returns the winner.
	 */
	public Team getWinner() {
		return winner;
	}

	
	/**
	 * @return Returns the firstRoundTeams.
	 */
	public int getNumberOfFirstRoundTeams() {
		return numberOfFirstRoundTeams;
	}

	
	/**
	 * @return Returns the roundCount.
	 */
	public int getNumberOfRounds() {
		return numberOfRounds;
	}

	
	/**
	 * @return Returns the rounds.
	 */
	public Round[] getRounds() {
		return rounds;
	}

}
