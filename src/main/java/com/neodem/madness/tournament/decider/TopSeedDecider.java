/* file 	: 	TopSeedDecider.java
 * created 	:	Feb 18, 2006
 * modified :	
 */

package com.neodem.madness.tournament.decider;

import com.neodem.madness.db.beans.Team;


/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class TopSeedDecider extends RandomDecider {

	/**
	 * 
	 */
	public TopSeedDecider() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.neodem.madness.decider.DeciderSupport#decide(com.neodem.madness.beans.Team, com.neodem.madness.beans.Team)
	 */
	protected Team decide(Team teamA, Team teamB) {
		Team randomWinner = super.decide(teamA, teamB);
		int seedA = teamA.getSeed();
		int seedB = teamB.getSeed();
		
		if(seedA > seedB) {
			return teamB;
		}
		if(seedB > seedA) {
			return teamA;
		}
		
		return randomWinner;
	}

}
