/* file 	: 	Team.java
 * created 	:	Feb 19, 2006
 * modified :	
 */

package com.neodem.madness.db.beans;

import java.util.Iterator;
import java.util.Set;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 * 
 */
public class TeamInfo extends BaseVO {

	private String name;
	private String teamName;
	private String school;
	private String coach;
	private Set attributes;  //composed of TeamAttribute objects

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param attributeName
	 * @return
	 */
	public int getAttributeValue(String attributeName) {
		Iterator i = attributes.iterator();
		while (i.hasNext()) {
			TeamAttribute attribute = (TeamAttribute) i.next();
			String name = attribute.getName();
			if(name.equalsIgnoreCase(attributeName)) {
				Integer val = attribute.getValue();
				if(val != null) {
					return val.intValue();
				}
			}
		}
		return -1;
	}
		
	/**
	 * 
	 */
	public TeamInfo() {
		super();
	}

	/**
	 * @return Returns the coach.
	 */
	public String getCoach() {
		return coach;
	}

	/**
	 * @param coach
	 *            The coach to set.
	 */
	public void setCoach(String coach) {
		this.coach = coach;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the school.
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * @param school
	 *            The school to set.
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/**
	 * @return Returns the teamName.
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName
	 *            The teamName to set.
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	
	/**
	 * @return Returns the attributes.
	 */
	public Set getAttributes() {
		return attributes;
	}

	
	/**
	 * @param attributes The attributes to set.
	 */
	public void setAttributes(Set attributes) {
		this.attributes = attributes;
	}
}
