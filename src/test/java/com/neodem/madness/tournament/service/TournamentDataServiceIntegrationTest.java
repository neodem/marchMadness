/* file 	: 	TournamentDataServiceIntegrationTest.java
 * created 	:	Feb 16, 2006
 * modified :	
 */

package com.neodem.madness.tournament.service;

import com.neodem.madness.testSupport.BaseSpringTestCase;
import com.neodem.madness.tournament.decider.Decider;
import com.neodem.madness.tournament.mm.MarchMadnessTournament;
import com.neodem.madness.tournament.service.TournamentDataService;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 * 
 */
public class TournamentDataServiceIntegrationTest extends BaseSpringTestCase {

	public void testFillBracket() {
		TournamentDataService service = (TournamentDataService) applicationContext.getBean("tournamentDataService");
		Decider decider = (Decider) applicationContext.getBean("randomDecider");
		
		MarchMadnessTournament tournament = new MarchMadnessTournament();

		service.fillTournamentFirstRound(tournament);
		System.out.println(tournament.getDisplay());	
		
		tournament.compute(decider);
		System.out.println(tournament.getDisplay());
	}

}
