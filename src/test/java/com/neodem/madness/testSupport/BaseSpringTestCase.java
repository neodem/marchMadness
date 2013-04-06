/* file 	: 	BaseSpringTestCase.java
 * created 	:	Feb 16, 2006
 * modified :	
 */

package com.neodem.madness.testSupport;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class BaseSpringTestCase extends AbstractDependencyInjectionSpringContextTests {
	/* (non-Javadoc)
	 * @see org.springframework.test.AbstractDependencyInjectionSpringContextTests#getConfigLocations()
	 */
	protected String[] getConfigLocations() {
		return new String[] {"resources/testContext.xml"};
	}
}
