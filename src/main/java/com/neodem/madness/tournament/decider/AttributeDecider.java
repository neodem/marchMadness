
package com.neodem.madness.tournament.decider;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.neodem.madness.db.beans.TeamInfo;
import com.neodem.madness.db.beans.Team;

/**
 * will randomly decide the winner
 * 
 * @author Vincent Fumo (neodem@gmail.com)
 * 
 */
public class AttributeDecider extends RandomDecider {
	private static Logger _log = LogManager.getLogger(AttributeDecider.class.getName());
	
	protected String attributeName;
	
	/**
	 * @param string 
	 * 
	 */
	public AttributeDecider(String name) {
		super();
		attributeName = name;
	}

	/* (non-Javadoc)
	 * @see com.neodem.madness.decider.DeciderSupport#decide(com.neodem.madness.beans.Team, com.neodem.madness.beans.Team)
	 */
	protected Team decide(Team tteamA, Team tteamB) {
		Team winner = super.decide(tteamA, tteamB);
		TeamInfo teamA = tteamA.getTeamInfo();
		TeamInfo teamB = tteamB.getTeamInfo();	
		
		int attA = teamA.getAttributeValue(attributeName);
		int attB = teamB.getAttributeValue(attributeName);
		
		if(attA > attB) {
			winner = tteamA;
		}
		else if(attB > attA) {
			winner = tteamB;
		}

		return winner;
	}

	
	/**
	 * @return Returns the attributeName.
	 */
	public String getAttributeName() {
		return attributeName;
	}

	
	/**
	 * @param attributeName The attributeName to set.
	 */
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

}
