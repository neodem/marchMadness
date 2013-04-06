/* file 	: 	AbstractVOBase.java
 * created 	:	Feb 19, 2006
 * modified :	
 */

package com.neodem.madness.db.beans;

import java.io.Serializable;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public abstract class BaseVO implements Serializable {

	private Long id;

	
	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}

	
	/**
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
