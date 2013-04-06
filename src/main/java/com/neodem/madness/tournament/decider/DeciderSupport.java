/* file 	: 	DeciderSupport.java
 * created 	:	Feb 18, 2006
 * modified :	
 */

package com.neodem.madness.tournament.decider;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.neodem.madness.core.Game;
import com.neodem.madness.db.beans.Team;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public abstract class DeciderSupport implements Decider {
	private static Logger _log = LogManager.getLogger(DeciderSupport.class.getName());

	/**
	 * 
	 */
	public DeciderSupport() {
		super();
	}
	
	public final Team decide(Game game) {
		if(game == null) return null;
		Team teamA = game.getTeamA();
		if(teamA == null) return null;
		Team teamB = game.getTeamB();
		if(teamB == null) return null;
		_log.debug("deciding : " + game);
		Team winner = decide(teamA, teamB);
		_log.debug("winner = " + winner);
		game.setWinner(winner);
		return winner;
	}

	/**
	 * @param teamA
	 * @param teamB
	 * @return
	 */
	protected abstract Team decide(Team teamA, Team teamB);
}
