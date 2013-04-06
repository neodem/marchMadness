
package com.neodem.madness.db;

import com.neodem.madness.db.beans.Conference;
import com.neodem.madness.db.beans.Team;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public interface MadnessDAO {
	
	public Team[] getAllTeamsFromConferenceByConferenceName(String name);
	public Team[] getAllTeamsFromConference(Conference conference);
	public Team[] getAllTeams();

	/** get a conferenceVo from the conference name
	 * @param string
	 * @return
	 */
	public Conference getConferenceByName(String string);
	
}
