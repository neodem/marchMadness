/* file 	: 	BracketSupportTest.java
 * created 	:	Feb 18, 2006
 * modified :	
 */

package com.neodem.madness.core;

import junit.framework.TestCase;

import com.neodem.madness.db.beans.Team;
import com.neodem.madness.tournament.decider.RandomDecider;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 * 
 */
public class BracketSupportTest extends TestCase {

	public void testConstructorInt() {
		BracketSupport bracket = makeBracket(DEF_SIZE);
		assertEquals(DEF_SIZE, bracket.getNumberOfRounds());
		assertEquals(DEF_GAMES, bracket.getNumberOfFirstRoundGames());
		assertEquals(DEF_TEAMS, bracket.getNumberOfFirstRoundTeams());
	}

	/*
	 * Test method for
	 * 'com.neodem.madness.common.bracket.BracketSupport.setupRounds()'
	 */
	public void testSetupRounds() {
		BracketSupport bracket = makeBracket(DEF_SIZE);
		Round[] rounds = bracket.getRounds();
		assertEquals(DEF_SIZE, rounds.length);
		Round round = rounds[0];
		assertEquals(0, round.getRoundNumber());
		assertEquals(DEF_GAMES, round.getNumberOfGames());
		round = rounds[1];
		assertEquals(1, round.getRoundNumber());
		assertEquals(DEF_GAMES / 2, round.getNumberOfGames());
	}

	/*
	 * Test method for
	 * 'com.neodem.madness.common.bracket.BracketSupport.addFirstRoundTeam(Team)'
	 */
	public void testAddFirstRoundTeam() {
		MockBracketSupport bracket = makeBracket(DEF_SIZE);
		Team testTeam = null;
		bracket.addFirstRoundTeam(testTeam);
		assertFalse(bracket.placeTeamInFirstRoundGameCalled);
		
		testTeam = new Team();
		testTeam.setName("testTeam");
		testTeam.setSeed(DEF_TEAMS +1);
		bracket.addFirstRoundTeam(testTeam);
		assertFalse(bracket.placeTeamInFirstRoundGameCalled);
		
		testTeam.setSeed(0);
		bracket.addFirstRoundTeam(testTeam);
		assertFalse(bracket.placeTeamInFirstRoundGameCalled);
		
		testTeam.setSeed(DEF_TEAMS-1);
		bracket.addFirstRoundTeam(testTeam);
		assertTrue(bracket.placeTeamInFirstRoundGameCalled);
	}
	
	public void testCompute() {
		MockBracketSupport bracket = makeBracket(DEF_SIZE);
		bracket.compute(new RandomDecider());
		assertEquals(DEF_SIZE, bracket.fillNextRoundCount);
	}

	/*
	 * Test method for
	 * 'com.neodem.madness.common.bracket.BracketSupport.getNumberOfGamesForRound(int,
	 * int)'
	 */
	public void testGetNumberOfGamesForRound() {
		assertEquals(2, BracketSupport.getNumberOfGamesForRound(0,2));
		assertEquals(1, BracketSupport.getNumberOfGamesForRound(1,2));
		assertEquals(8, BracketSupport.getNumberOfGamesForRound(0,4));
	}

	/*
	 * Test method for
	 * 'com.neodem.madness.common.bracket.BracketSupport.getNumberOfFirstRoundGames()'
	 */
	public void testGetNumberOfFirstRoundGames() {
		BracketSupport bracket = makeBracket(DEF_SIZE);
		assertEquals(DEF_GAMES, bracket.getNumberOfFirstRoundGames());
		
		bracket = makeBracket(4);
		assertEquals(8, bracket.getNumberOfFirstRoundGames());
	}

	///////////////////////////////////////////////////////////////

	private static final int DEF_SIZE = 2;
	private static final int DEF_GAMES = 2;
	private static final int DEF_TEAMS = 4;

	/**
	 * Constructor for FullIntegrationTest.
	 * 
	 * @param name
	 * @throws Exception
	 */
	public BracketSupportTest(String name) throws Exception {
		super(name);
	}

	protected MockBracketSupport makeBracket(int size) {
		return new MockBracketSupport(size);
	}

	protected class MockBracketSupport extends BracketSupport {

		public boolean placeTeamInFirstRoundGameCalled = false;
		public int fillNextRoundCount = 0;
		
		/**
		 * @param size
		 */
		public MockBracketSupport(int size) {
			super(size);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.neodem.madness.common.bracket.BracketSupport#placeTeamInFirstRoundGame(int,
		 *      com.neodem.madness.beans.Team)
		 */
		protected void placeTeamInFirstRoundGame(int seed, Team team) {
			placeTeamInFirstRoundGameCalled = true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.neodem.madness.common.bracket.BracketSupport#fillNextRound(int)
		 */
		protected void fillRound(int roundNumber) {
			fillNextRoundCount++;
		}

	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
