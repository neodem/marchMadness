/* file 	: 	Decider.java
 * created 	:	Feb 10, 2006
 * modified :	
 */

package com.neodem.madness.tournament.decider;

import com.neodem.madness.core.Game;
import com.neodem.madness.db.beans.Team;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 * 
 */
public interface Decider {

	/** decide the winner of a game. This method will decide the winner, set
	 * the winner in the game and return the winning team.
	 * 
	 * @param game (if null will return null)
	 * @return
	 */
	public Team decide(Game game);
}
