/* file 	: 	MarchMadnessBracketTest.java
 * created 	:	Feb 18, 2006
 * modified :	
 */

package com.neodem.madness.tournament.mm;

import com.neodem.madness.core.Game;
import com.neodem.madness.core.Round;
import com.neodem.madness.db.beans.Team;
import com.neodem.madness.testSupport.MadnessTestSupport;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 * 
 */
public class MarchMadnessBracketTest extends MadnessTestSupport {

	/*
	 * Test method for
	 * 'com.neodem.madness.common.bracket.MarchMadnessBracket.onSetup()'
	 */
	public void testOnSetup() {
		Game[] games = bracket.games;
		assertEquals(DEF_FR_GAMES, games.length);
	}

	/*
	 * Test method for
	 * 'com.neodem.madness.common.bracket.MarchMadnessBracket.placeTeamInFirstRoundGame(int,
	 * Team)'
	 */
	public void testPlaceTeamInFirstRoundGame() {
		String conference = "conference";
		Game[] games = bracket.games;
		assertNull(games[0]);

		Team[] teams = makeTeamSet(16, conference);
		bracket.placeTeamInFirstRoundGame(1, teams[0]);
		assertNotNull(games[0]);
		assertTrue(games[0].teamInGame(teams[0]));
		assertFalse(games[0].teamInGame(teams[15]));

		bracket.placeTeamInFirstRoundGame(16, teams[15]);
		assertNotNull(games[0]);
		assertTrue(games[0].teamInGame(teams[0]));
		assertTrue(games[0].teamInGame(teams[15]));
	}

	/*
	 * Test method for
	 * 'com.neodem.madness.common.bracket.MarchMadnessBracket.fillNextRound(int)'
	 */
	public void testFillRound() {
		String conference = "conference";

		// fill the first round
		Round[] rounds = bracket.getRounds();
		Round firstRound = rounds[0];
		assertEquals(0, firstRound.getGamesRegistered());

		Team[] teams = makeTeamSet(16, conference);
		for (int i = 0; i < teams.length; i++) {
			bracket.addFirstRoundTeam(teams[i]);
		}
		bracket.fillRound(0);

		assertEquals(8, firstRound.getGamesRegistered());

		// check seeding, game 0 should have 16 vs 1
		Game game0 = firstRound.getGame(0);
		assertNotNull(game0);
		assertTrue(game0.teamInGame(teams[0]));
		assertTrue(game0.teamInGame(teams[15]));

		Game game7 = firstRound.getGame(7);
		assertNotNull(game0);
		assertTrue(game7.teamInGame(teams[1]));
		assertTrue(game7.teamInGame(teams[14]));

		// determine artificial winners for all 8 games
		firstRound.getGame(0).setWinner(teams[0]);
		firstRound.getGame(1).setWinner(teams[1]);

		firstRound.getGame(2).setWinner(teams[2]);
		firstRound.getGame(3).setWinner(teams[3]);

		firstRound.getGame(4).setWinner(teams[4]);
		firstRound.getGame(5).setWinner(teams[5]);

		firstRound.getGame(6).setWinner(teams[6]);
		firstRound.getGame(7).setWinner(teams[7]);

		// fill second round
		bracket.fillRound(1);
		Round secondRound = rounds[1];
		assertEquals(4, secondRound.getGamesRegistered());

		// check seeding
		Game game20 = secondRound.getGame(0);
		assertNotNull(game0);
		assertTrue(game20.teamInGame(teams[0]));
		assertTrue(game20.teamInGame(teams[1]));

		Game game21 = secondRound.getGame(1);
		assertNotNull(game0);
		assertTrue(game21.teamInGame(teams[2]));
		assertTrue(game21.teamInGame(teams[3]));

		Game game22 = secondRound.getGame(2);
		assertNotNull(game0);
		assertTrue(game22.teamInGame(teams[4]));
		assertTrue(game22.teamInGame(teams[5]));

		Game game23 = secondRound.getGame(3);
		assertNotNull(game0);
		assertTrue(game23.teamInGame(teams[6]));
		assertTrue(game23.teamInGame(teams[7]));

	}

	/*
	 * Test method for
	 * 'com.neodem.madness.common.bracket.MarchMadnessBracket.fillFirstRound()'
	 */
	public void testFillFirstRound() {
		String conference = "conference";

		Round[] rounds = bracket.getRounds();
		Round firstRound = rounds[0];
		assertEquals(0, firstRound.getGamesRegistered());

		Team[] teams = makeTeamSet(16, conference);
		for (int i = 0; i < teams.length; i++) {
			bracket.addFirstRoundTeam(teams[i]);
		}
		bracket.fillFirstRound();
		assertEquals(8, firstRound.getGamesRegistered());

		// check seeding, game 0 should have 16 vs 1
		Game game0 = firstRound.getGame(0);
		assertNotNull(game0);
		assertTrue(game0.teamInGame(teams[0]));
		assertTrue(game0.teamInGame(teams[15]));

		Game game7 = firstRound.getGame(7);
		assertNotNull(game0);
		assertTrue(game7.teamInGame(teams[1]));
		assertTrue(game7.teamInGame(teams[14]));
	}

	// /////////////////////////////////////////////////////////////

	private static final int DEF_SIZE = 4;
	private static final int DEF_FR_GAMES = 8;
	private static final int DEF_TEAMS = 16;
	private MarchMadnessBracket bracket = null;

	/**
	 * Constructor for MarchMadnessBracketTest.
	 * 
	 * @param name
	 * @throws Exception
	 */
	public MarchMadnessBracketTest(String name) throws Exception {
		super(name);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		bracket = new MarchMadnessBracket(DEF_SIZE);
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		bracket = null;
	}
}
