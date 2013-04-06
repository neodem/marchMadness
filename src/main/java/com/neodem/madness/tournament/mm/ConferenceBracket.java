/* file 	: 	ConferenceBracket.java
 * created 	:	Feb 17, 2006
 * modified :	
 */

package com.neodem.madness.tournament.mm;


/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class ConferenceBracket extends MarchMadnessBracket {

	/**
	 * @param roundCount
	 */
	public ConferenceBracket() {
		super(4);
	}

	/**
	 * @param roundCount
	 * @param name
	 */
	public ConferenceBracket(String name) {
		super(4, name);
	}

}
