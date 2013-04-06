/* file 	: 	Conference.java
 * created 	:	Feb 19, 2006
 * modified :	
 */

package com.neodem.madness.db.beans;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class Conference extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	/**
	 * 
	 */
	public Conference() {
		super();
	}

	
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

}
