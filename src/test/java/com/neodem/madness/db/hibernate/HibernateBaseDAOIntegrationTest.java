/* file 	: 	MadnessDAOIntegrationTest.java
 * created 	:	Feb 16, 2006
 * modified :	
 */

package com.neodem.madness.db.hibernate;

import java.util.Set;

import com.neodem.madness.db.BaseDAO;
import com.neodem.madness.db.beans.TeamInfo;
import com.neodem.madness.db.beans.TeamAttribute;
import com.neodem.madness.db.beans.Team;
import com.neodem.madness.testSupport.BaseSpringTestCase;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class HibernateBaseDAOIntegrationTest extends BaseSpringTestCase {

	public void testTeamMapping() {
		BaseDAO dao = (BaseDAO) applicationContext.getBean("baseDAO");
		
		TeamInfo duke = (TeamInfo) dao.findByID(TeamInfo.class, new Long(1));
		assertNotNull(duke);
		
		assertEquals("Duke", duke.getName());
		
		Set attributes = duke.getAttributes();
		assertNotNull(attributes);
		
		assertEquals(1, attributes.size());
		
		Object o = attributes.iterator().next();
		assertTrue(o instanceof TeamAttribute);
		TeamAttribute attribute = (TeamAttribute) o;
		
		assertNotNull(attribute);
		assertEquals("Defense", attribute.getAttribute().getName());
		assertEquals(new Integer(100), attribute.getValue());
	}
	
	public void testTournamentTeamMapping() {
		BaseDAO dao = (BaseDAO) applicationContext.getBean("baseDAO");
		
		Team duke = (Team) dao.findByID(Team.class, new Long(1));
		assertNotNull(duke);
		
		assertEquals("Duke", duke.getName());
		
		Set attributes = duke.getTeamInfo().getAttributes();
		assertNotNull(attributes);
		
		assertEquals(1, attributes.size());
		
		Object o = attributes.iterator().next();
		assertTrue(o instanceof TeamAttribute);
		TeamAttribute attribute = (TeamAttribute) o;
		
		assertNotNull(attribute);
		assertEquals("Defense", attribute.getAttribute().getName());
		assertEquals(new Integer(100), attribute.getValue());
	}
}
