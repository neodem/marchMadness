/* file 	: 	Tournament.java
 * created 	:	Feb 18, 2006
 * modified :	
 */

package com.neodem.madness.core;

import com.neodem.madness.db.beans.Team;
import com.neodem.madness.tournament.decider.Decider;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public interface Tournament {
	public void compute(Decider decider);
	public void addTeam(Team team);
}
