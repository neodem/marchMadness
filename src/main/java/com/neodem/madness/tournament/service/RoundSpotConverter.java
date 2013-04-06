/* file 	: 	RoundSpotConverter.java
 * created 	:	Feb 12, 2006
 * modified :	
 */

package com.neodem.madness.tournament.service;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public interface RoundSpotConverter {
	
	/** Assumes 4 counferences 
	 * 
	 * @param round
	 * @param spot
	 * @param totalRounds
	 * @return
	 */
	public int determineConference(int round, int spot, int totalRounds);
	
	/** in the first round, the seed determines the game, we handle this here
	 * 
	 * @param seed
	 * @return
	 */
	public int determineSpotInConference(int seed, int totalRounds);
	
	/** get total number of games for a tournament with a given
	 * number of rounds
	 * 
	 * @param totalRounds
	 * @return
	 */
	public int getTotalNumberOfGames(int totalRounds) ;
	
	/** get number of games in a given round for a given tournament
	 * size. 
	 * 
	 * @param roundNumber (0 based)
	 * @param totalRounds
	 * @return
	 */
	public int getNumberOfGamesForRound(int roundNumber, int totalRounds);
}
