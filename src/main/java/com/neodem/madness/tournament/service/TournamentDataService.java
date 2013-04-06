/* file 	: 	BracketDataService.java
 * created 	:	Feb 12, 2006
 * modified :	
 */

package com.neodem.madness.tournament.service;

import com.neodem.madness.core.Tournament;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public interface TournamentDataService {
	
	/** get all the first round games and fill them into the bracket
	 * 
	 * @param bracket
	 */
	public void fillTournamentFirstRound(Tournament tournament);
	
	/** save the bracket
	 * 
	 * @param bracket
	 */
	public void saveTournament(Tournament tournament);


}
