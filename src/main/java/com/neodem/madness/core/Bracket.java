/* file 	: 	Bracket.java
 * created 	:	Feb 16, 2006
 * modified :	
 */

package com.neodem.madness.core;


import com.neodem.madness.db.beans.Team;

import com.neodem.madness.tournament.decider.Decider;

/** A given brakcet can hold a set number of teams (depending on the number of rounds)
 * the number of teams is 2^numberOfRounds. A Bracket will order the teams in the first
 * round using a given method based on their seed.
 * 
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public interface Bracket {
	/** seed information is encapsulated in the team
	 * 
	 * @param team
	 */
	public void addFirstRoundTeam(Team team);
	public void compute(Decider decider);
	public Team getWinner();
	public String getDisplay();
	public Round[] getRounds();
}
