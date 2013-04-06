/* file 	: 	FinalFourBracket.java
 * created 	:	Feb 17, 2006
 * modified :	
 */

package com.neodem.madness.tournament.mm;

import com.neodem.madness.core.Game;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class FinalFourBracket extends MarchMadnessBracket {

	/**
	 * @param roundCount
	 */
	public FinalFourBracket() {
		super(2);
	}

	/**
	 * @param roundCount
	 * @param name
	 */
	public FinalFourBracket(String name) {
		super(2, name);
	}
	
	public void setSouthWestGame(Game game) {
		placeTeamInFirstRoundGame(1,game.getTeamA());
		placeTeamInFirstRoundGame(4,game.getTeamB());
	}

	public void setEastMidwestGame(Game game) {
		placeTeamInFirstRoundGame(2,game.getTeamA());
		placeTeamInFirstRoundGame(3,game.getTeamB());
	}	
}
