/* file 	: 	TeamListSessionBean.java
 * created 	:	Feb 24, 2006
 * modified :	
 */

package com.neodem.madness.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.neodem.madness.db.beans.Team;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class TeamListSessionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Collection teamList;
	


	/** add a whole array of teams to the teamList
	 * @param teams
	 */
	public void addTeamArray(Team[] teams) {
		if(teams == null || teams.length == 0) return;
		if(teamList == null) {
			teamList = new ArrayList();
		}
		for (int i = 0; i < teams.length; i++) {
			teamList.add(teams[i]);
		}
	}

	/**
	 * 
	 */
	public TeamListSessionBean() {
		super();
	}


	
	/**
	 * @return Returns the teamList.
	 */
	public Collection getTeamList() {
		return teamList;
	}


	
	/**
	 * @param teamList The teamList to set.
	 */
	public void setTeamList(Collection teamList) {
		this.teamList = teamList;
	}



}
