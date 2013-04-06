/* file 	: 	RandomDecider.java
 * created 	:	Feb 10, 2006
 * modified :	
 */

package com.neodem.madness.tournament.decider;

import java.util.Date;
import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.neodem.madness.db.beans.Team;

/**
 * will randomly decide the winner
 * 
 * @author Vincent Fumo (neodem@gmail.com)
 * 
 */
public class RandomDecider extends DeciderSupport {
	private static Logger _log = LogManager.getLogger(RandomDecider.class.getName());
	protected Random rand;
	
	/**
	 * 
	 */
	public RandomDecider() {
		super();
		Date now = new Date();
		rand = new Random(now.getTime());
	}

	/* (non-Javadoc)
	 * @see com.neodem.madness.decider.DeciderSupport#decide(com.neodem.madness.beans.Team, com.neodem.madness.beans.Team)
	 */
	protected Team decide(Team teamA, Team teamB) {
		boolean homeWins = rand.nextBoolean();

		Team winner = teamA;
		if (homeWins) {
			winner = teamB;
		} 
		return winner;
	}

}
