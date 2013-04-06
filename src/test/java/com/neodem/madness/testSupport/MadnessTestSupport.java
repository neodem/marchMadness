/* file 	: 	BracketTestSuppor.java
 * created 	:	Feb 17, 2006
 * modified :	
 */

package com.neodem.madness.testSupport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jmock.MockObjectTestCase;

import com.neodem.madness.db.beans.Conference;
import com.neodem.madness.db.beans.Team;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public abstract class MadnessTestSupport extends MockObjectTestCase {
	/**
	 * @param name
	 */
	public MadnessTestSupport(String name) {
		super(name);
	}
	
	protected Team makeTeamVO(int seed) {
		String name = "team" + seed;
		Team team = new Team();
		team.setName(name);
		team.setSeed(seed);
		
		return team;
	}
	
	protected Team[] makeTeamSet(int size, String conferenceName) {
		if(size <= 0) return null;
		Conference conference = new Conference();
		conference.setName(conferenceName);
		Team[] teams = new Team[size];
		for(int i=0;i<size;i++) {
			teams[i] = makeTeamVO(i+1);
			teams[i].setConference(conference);
		}
		
		return teams;
	}
	
	protected Collection makeTeamVOCollection(int size) {
		List teamSet = new ArrayList(size);
		for(int i=0;i<size;i++) {
			teamSet.add(makeTeamVO(i+1));
		}
		
		return teamSet;
	}
}
