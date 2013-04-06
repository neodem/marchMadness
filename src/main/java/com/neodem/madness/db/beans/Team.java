/* file 	: 	Team.java
 * created 	:	Feb 19, 2006
 * modified :	
 */

package com.neodem.madness.db.beans;

import org.apache.commons.lang.builder.EqualsBuilder;

/** a team with conference and seed associations
 * 
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class Team extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Conference conference;
	private TeamInfo team;
	private int seed;
	
	
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append(seed);
		b.append(".");
		b.append(getName());
		return b.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	 public boolean equals(Object obj) {
		   return EqualsBuilder.reflectionEquals(this, obj);
	 }
		
	
	/**
	 * 
	 */
	public Team() {
		super();
	}


	
	/**
	 * @return Returns the conference.
	 */
	public Conference getConference() {
		return conference;
	}


	
	/**
	 * @param conference The conference to set.
	 */
	public void setConference(Conference conference) {
		this.conference = conference;
	}
	
	/**
	 * @return Returns the seed.
	 */
	public int getSeed() {
		return seed;
	}


	
	/**
	 * @param seed The seed to set.
	 */
	public void setSeed(int seed) {
		this.seed = seed;
	}


	
	/**
	 * @return Returns the team.
	 */
	public TeamInfo getTeamInfo() {
		return team;
	}


	
	/**
	 * @param team The team to set.
	 */
	public void setTeamInfo(TeamInfo team) {
		this.team = team;
	}



	/**
	 * @return
	 */
	public String getName() {
		if(team != null) {
			return team.getName();
		}
		return "";
		
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		if(team == null) {
			team = new TeamInfo();
		}
		
		team.setName(name);
		
	}

}
