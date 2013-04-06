/* file 	: 	DefaultTournamentDataServiceTest.java
 * created 	:	Feb 14, 2006
 * modified :	
 */

package com.neodem.madness.tournament.service.impl;

import java.util.Collection;

import org.jmock.Mock;

import com.neodem.madness.core.Tournament;
import com.neodem.madness.db.MadnessDAO;
import com.neodem.madness.db.beans.Conference;
import com.neodem.madness.testSupport.MadnessTestSupport;
import com.neodem.madness.tournament.mm.MarchMadnessTournament;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class MarchMadnessTournamentDataServiceTest extends MadnessTestSupport {
	
	public void testFillConfernece() {
		String confName = MarchMadnessTournament.EAST;
		Conference conferenceVO = new Conference();		
		mockMadnessDAO.expects(once()).method("getConferenceByName").with(eq(confName))
	            .will(returnValue(conferenceVO));
		
		Collection teamSet = makeTeamVOCollection(16);
		mockMadnessDAO.expects(once()).method("getAllTeamsFromConference").with(eq(conferenceVO)).will(returnValue(teamSet));
		
		mockTournament.expects(atLeastOnce()).method("addTeam").with(ANYTHING);
		
		service.fillConference(testTournament, confName);
		
	}

	
	/////////////////////////////////////////////////////////////////
	
	private MarchMadnessTournamentDataService service;	
	private Tournament testTournament;
	private Mock mockMadnessDAO;
	private Mock mockTournament;

	/**
	 * Constructor for FullIntegrationTest.
	 * @param name
	 */
	public MarchMadnessTournamentDataServiceTest(String name) {
		super(name);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		service = new MarchMadnessTournamentDataService();
		
		mockTournament = mock(Tournament.class);	
		testTournament = (Tournament)mockTournament.proxy();
		
		mockMadnessDAO = mock(MadnessDAO.class);
		service.setMadnessDAO((MadnessDAO) mockMadnessDAO.proxy());
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		mockMadnessDAO = null;
		service = null;
	}
}
