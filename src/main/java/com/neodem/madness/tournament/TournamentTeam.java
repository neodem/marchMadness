/* file 	: 	TournamentTeam.java
 * created 	:	Feb 19, 2006
 * modified :	
 */

package com.neodem.madness.tournament;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public interface TournamentTeam {
	public String getName();
	public void setName(String name);
	public int getSeed();
	public void setSeed(int seed);
	public String getConference();
    public void setConference(String conference);
}
