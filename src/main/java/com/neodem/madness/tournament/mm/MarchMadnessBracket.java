package com.neodem.madness.tournament.mm;

import com.neodem.madness.core.BracketSupport;
import com.neodem.madness.core.Game;
import com.neodem.madness.db.beans.Team;
import com.neodem.madness.tournament.service.RoundSpotConverter;
import com.neodem.madness.tournament.service.impl.MarchMadnessRoundSpotConverter;

/**
 * Will use march madness rules to set up the games according to seeds. The
 * games will be set up so a higher seed always has the lowest seed to compete
 * against in any round (all determined from the initial seeding).
 * 
 * @author Vincent Fumo (neodem@gmail.com)
 * 
 */
public class MarchMadnessBracket extends BracketSupport {

	private RoundSpotConverter roundSpotConverter = new MarchMadnessRoundSpotConverter();

	/**
	 * to hold the first round games
	 */
	protected Game[] games;

	/**
	 * 
	 */
	public MarchMadnessBracket(int roundCount) {
		super(roundCount);
	}

	public MarchMadnessBracket(int roundCount, String name) {
		super(roundCount, name);
	}

	protected void onSetup() {
		games = new Game[numberOfFirstRoundGames];
	}

	/**
	 * @param seed
	 * @param team
	 */
	protected void placeTeamInFirstRoundGame(int seed, Team team) {
		if(seed <= 0) return;
		if(seed > numberOfFirstRoundTeams) return;
		
		// there are 2^roundCount/2 games to fill
		// the games will come randomly via this method
		// we need to have an array to hold all the games
		int gameNumber = roundSpotConverter.determineSpotInConference(seed, numberOfRounds);
		Game game = games[gameNumber];
		if (game == null) {
			game = new Game();
		}

		game.addTeam(team);
		games[gameNumber] = game;
	}

	/**
	 * will do a standard round: winner 0.0 --> play each other in 1.0 winner
	 * 0.1
	 * 
	 * winner 0.2 --> play each other in 1.1 winner 0.3
	 * 
	 * etc.
	 * 
	 * @param roundNumber
	 */
	protected void fillRound(int roundNumber) {
		if (roundNumber == 0) {
			fillFirstRound();
			return;
		}
		int games = getNumberOfGamesForRound(roundNumber, numberOfRounds);
		int gameNumber;
		int runs = games * 2;
		for (int i = 0; i < runs; i=i+2) {
			gameNumber = i/2;
			Team teamA = rounds[roundNumber - 1].getWinner(i);
			Team teamB = rounds[roundNumber - 1].getWinner(i + 1);
			rounds[roundNumber].addGame(gameNumber, new Game(teamA, teamB));
		}
	}

	/**
	 * 
	 */
	protected void fillFirstRound() {
		for (int i = 0; i < games.length; i++) {
			rounds[0].addGame(i, games[i]);
		}
	}

}
