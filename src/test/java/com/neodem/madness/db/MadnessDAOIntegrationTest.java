/* file 	: 	MadnessDAOIntegrationTest.java
 * created 	:	Feb 16, 2006
 * modified :	
 */

package com.neodem.madness.db;

import com.neodem.madness.db.beans.Conference;
import com.neodem.madness.db.beans.Team;
import com.neodem.madness.testSupport.BaseSpringTestCase;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class MadnessDAOIntegrationTest extends BaseSpringTestCase {

	public void testGetConferenceByName() {
		MadnessDAO dao = (MadnessDAO) applicationContext.getBean("madnessDAO");
		Conference conference = dao.getConferenceByName("south");
		assertNotNull(conference);
		assertEquals("south", conference.getName());
		assertEquals(new Long(1), conference.getId());
	}

	public void testGetAllTeamsFromConference() {
		MadnessDAO dao = (MadnessDAO) applicationContext.getBean("madnessDAO");
		Conference conference = new Conference();
		conference.setId(new Long(1));
		
		Team[] teams = dao.getAllTeamsFromConference(conference);
		assertNotNull(teams);
		assertEquals(16, teams.length);
	}
}
