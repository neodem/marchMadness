/* file 	: 	TeamAttribute.java
 * created 	:	Feb 22, 2006
 * modified :	
 */

package com.neodem.madness.db.beans;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class TeamAttribute {

	private TeamInfo team;
	private Attribute attribute;
	private Integer value;
	
	public String getName() {
		if(attribute != null) {
			return attribute.getName();
		}
		return null;
	}
	
	/**
	 * 
	 */
	public TeamAttribute() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @return Returns the attribute.
	 */
	public Attribute getAttribute() {
		return attribute;
	}

	
	/**
	 * @param attribute The attribute to set.
	 */
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	
	/**
	 * @return Returns the value.
	 */
	public Integer getValue() {
		return value;
	}

	
	/**
	 * @param value The value to set.
	 */
	public void setValue(Integer value) {
		this.value = value;
	}


	
	/**
	 * @return Returns the team.
	 */
	public TeamInfo getTeam() {
		return team;
	}


	
	/**
	 * @param team The team to set.
	 */
	public void setTeam(TeamInfo team) {
		this.team = team;
	}

}
