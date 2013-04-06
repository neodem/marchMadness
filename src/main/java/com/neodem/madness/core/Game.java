/* file 	: 	Game.java
 * created 	:	Feb 10, 2006
 * modified :	
 */

package com.neodem.madness.core;

import com.neodem.madness.db.beans.Team;


/**
 * used in the brackets, and for historical info
 * 
 * @author Vincent Fumo (neodem@gmail.com)
 * 
 */
public class Game {

	private Team teamA;
	private Team teamB;
	private Team winner;

	private int scoreA;
	private int scoreB;

	/**
	 * 
	 */
	public Game() {
		super();
		winner = null;
	}

	public Game(Team teamA, Team teamB) {
		super();
		this.teamA = teamA;
		this.teamB = teamB;
	}

	public String toString() {
		StringBuffer b = new StringBuffer();
		if (teamA == null) {
			b.append("<null>");
		} else {
			b.append(teamA.toString());
		}
		b.append(" v ");
		if (teamB == null) {
			b.append("<null>");
		} else {
			b.append(teamB.toString());
		}
		if (winner != null) {
			b.append(" | won by : ");
			b.append(winner.toString());
		}

		return b.toString();
	}
	

	/** add a team (if a spot is available)
	 * @param team
	 */
	public void addTeam(Team team) {
		if(teamA == null) {
			teamA = team;
		}
		else if(teamB == null){
			teamB = team;
		}
	}

	/**
	 * @param shortName
	 * @return
	 */
	public boolean teamInGame(String shortName) {
		if(teamA != null) {
			if(shortName.equals(teamA.getName())) return true;
		}
		if(teamB != null) {
			if(shortName.equals(teamB.getName())) return true;
		}
		return false;
	}
	
	/**
	 * @param shortName
	 * @return
	 */
	public boolean teamInGame(Team team) {
		if(teamA != null) {
			if(team.equals(teamA)) return true;
		}
		if(teamB != null) {
			if(team.equals(teamB)) return true;
		}
		return false;
	}

	/**
	 * @return Returns the away.
	 */
	public Team getTeamB() {
		return teamB;
	}

	/**
	 * @param away
	 *            The away to set.
	 */
	public void setTeamB(Team away) {
		this.teamB = away;
	}

	/**
	 * @return Returns the awayScore.
	 */
	public int getScoreB() {
		return scoreB;
	}

	/**
	 * @param awayScore
	 *            The awayScore to set.
	 */
	public void setScoreB(int awayScore) {
		this.scoreB = awayScore;
	}

	/**
	 * @return Returns the home.
	 */
	public Team getTeamA() {
		return teamA;
	}

	/**
	 * @param home
	 *            The home to set.
	 */
	public void setTeamA(Team home) {
		this.teamA = home;
	}

	/**
	 * @return Returns the homeScore.
	 */
	public int getScoreA() {
		return scoreA;
	}

	/**
	 * @param homeScore
	 *            The homeScore to set.
	 */
	public void setScoreA(int homeScore) {
		this.scoreA = homeScore;
	}

	/**
	 * @return Returns the winner.
	 */
	public Team getWinner() {
		return winner;
	}

	/**
	 * @param winner
	 *            The winner to set.
	 */
	public void setWinner(Team winner) {
		this.winner = winner;
	}

}
