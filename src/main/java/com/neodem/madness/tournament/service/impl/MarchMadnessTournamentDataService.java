/* file 	: 	DefaultBracketDataService.java
 * created 	:	Feb 12, 2006
 * modified :	
 */

package com.neodem.madness.tournament.service.impl;

import com.neodem.madness.core.Tournament;
import com.neodem.madness.db.MadnessDAO;
import com.neodem.madness.db.beans.Team;
import com.neodem.madness.tournament.mm.MarchMadnessConstants;
import com.neodem.madness.tournament.service.TournamentDataService;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class MarchMadnessTournamentDataService implements TournamentDataService {

	private MadnessDAO madnessDAO;
	
	/**
	 * 
	 */
	public MarchMadnessTournamentDataService() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.neodem.madness.service.BracketDataService#fillBracketFirstRound(com.neodem.madness.Bracket)
	 */
	public void fillTournamentFirstRound(Tournament tournament) {
		fillConference(tournament, MarchMadnessConstants.EAST);
		fillConference(tournament, MarchMadnessConstants.WEST);
		fillConference(tournament, MarchMadnessConstants.SOUTH);
		fillConference(tournament, MarchMadnessConstants.MIDWEST);
	}
	
	protected void fillConference(Tournament tournament, String name) {
		Team[] teams = madnessDAO.getAllTeamsFromConferenceByConferenceName(name);
		if(teams == null) return;
		if(teams.length == 0) return;
		
		for (int i = 0; i < teams.length; i++) {
			tournament.addTeam(teams[i]);
		}
	}


	/* (non-Javadoc)
	 * @see com.neodem.madness.service.BracketDataService#saveBracket(com.neodem.madness.Bracket)
	 */
	public void saveTournament(Tournament tournament) {
		// save as a unique run in the database.. create
		// a new run, save all games
		
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * @return Returns the dao.
	 */
	public MadnessDAO getMadnessDAO() {
		return madnessDAO;
	}

	
	/**
	 * @param dao The dao to set.
	 */
	public void setMadnessDAO(MadnessDAO dao) {
		this.madnessDAO = dao;
	}
}
