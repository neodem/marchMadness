/* file 	: 	HibernateMadnessDAO.java
 * created 	:	Feb 19, 2006
 * modified :	
 */

package com.neodem.madness.db.hibernate;

import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate.HibernateCallback;
import org.springframework.orm.hibernate.HibernateTemplate;

import com.neodem.madness.db.MadnessDAO;
import com.neodem.madness.db.beans.Conference;
import com.neodem.madness.db.beans.Team;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class HibernateMadnessDAO extends HibernateBaseDAO implements MadnessDAO {
    protected static Log _log = LogFactory.getLog(HibernateMadnessDAO.class.getName());
 
	
	public Team[] getAllTeamsFromConferenceByConferenceName(String name) {
		Conference conference = getConferenceByName(name);
		return getAllTeamsFromConference(conference);
	}

	public Team[] getAllTeamsFromConference(Conference conference) {
		final Long id = conference.getId();
		
		HibernateTemplate ht = getHibernateTemplate();
		List result = (List) ht.execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query q = session.getNamedQuery("QueryGetAllInConference");
				q.setLong("conferenceID", id.longValue());
				return q.list();
			}
		});

		return (Team[]) result.toArray(new Team[result.size()]);
	}
	
	
	public Conference getConferenceByName(final String name) {

        HibernateTemplate ht = getHibernateTemplate();
        List conferences = (List)ht.execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query q = session.getNamedQuery("QueryGetAllConferencesByName");
                q.setString("name", name);
                return q.list();
            }
        });
        
        if((conferences == null) || (conferences.size() != 1)) return null;
        
        return (Conference)conferences.get(0);
    }

	/* (non-Javadoc)
	 * @see com.neodem.madness.db.MadnessDAO#getAllTeamsInDatabase()
	 */
	public Team[] getAllTeams() {
		List teams = findAll(Team.class);
		
		if(teams == null) {
			return null;
		}
		
		return (Team[]) teams.toArray(new Team[teams.size()]);
	}
	
}
