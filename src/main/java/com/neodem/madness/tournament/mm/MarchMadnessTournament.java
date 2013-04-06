/* file 	: 	MarchMadness.java
 * created 	:	Feb 13, 2006
 * modified :	
 */

package com.neodem.madness.tournament.mm;

import java.util.HashMap;
import java.util.Map;

import com.neodem.common.utility.text.DisplayHelper;
import com.neodem.madness.core.Bracket;
import com.neodem.madness.core.Game;
import com.neodem.madness.core.Tournament;
import com.neodem.madness.db.beans.Team;
import com.neodem.madness.tournament.decider.Decider;


/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class MarchMadnessTournament implements Tournament, MarchMadnessConstants {
	
	private Map brackets;
	
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("March Madness Tournament");
		
		return b.toString();
	}
	
	public String getDisplay() {
		StringBuffer b = new StringBuffer();
		String text = this.toString();
		int size = text.length() + 20;
		b.append(DisplayHelper.create3RowSurroundBox(text, "=-", '|', size));
		b.append(getEastBracket().getDisplay());
		b.append(getWestBracket().getDisplay());
		b.append(getSouthBracket().getDisplay());
		b.append(getMidwestBracket().getDisplay());
		b.append(getFinalFourBracket().getDisplay());

		return b.toString();
	}

	/**
	 * 
	 */
	public MarchMadnessTournament() {
		super();
		brackets = new HashMap(5);
		brackets.put(EAST, new ConferenceBracket(EAST));
		brackets.put(WEST, new ConferenceBracket(WEST));
		brackets.put(SOUTH, new ConferenceBracket(SOUTH));
		brackets.put(MIDWEST, new ConferenceBracket(MIDWEST));
		brackets.put(FINALFOUR, new FinalFourBracket(FINALFOUR));		
	}
	
	/**
	 * 
	 */
	public void compute(Decider decider) {
		getEastBracket().compute(decider);
		getWestBracket().compute(decider);
		getSouthBracket().compute(decider);
		getMidwestBracket().compute(decider);
		
		moveFromBracketsToFF();
		
		getFinalFourBracket().compute(decider);
	}
	
	/** used to add a team to the tournamet, the seed must be set
	 * 
	 * @param team
	 */
	public void addTeam(Team team) {
		String conference = team.getConference().getName();
		Bracket bracket = getBracket(conference);
		bracket.addFirstRoundTeam(team);
	}

	/**
	 * 
	 */
	private void moveFromBracketsToFF() {
		Game gameA = new Game();
		gameA.addTeam(getEastBracket().getWinner());
		gameA.addTeam(getMidwestBracket().getWinner());
		getFinalFourBracket().setEastMidwestGame(gameA);
		
		Game gameB = new Game();
		gameB.addTeam(getSouthBracket().getWinner());
		gameB.addTeam(getWestBracket().getWinner());
		getFinalFourBracket().setSouthWestGame(gameB);
	}

	/**
	 * @return Returns the eastBracket.
	 */
	public MarchMadnessBracket getEastBracket() {
		return (MarchMadnessBracket) brackets.get(EAST);
	}

	
	/**
	 * @param eastBracket The eastBracket to set.
	 */
	public void setEastBracket(MarchMadnessBracket bracket) {
		brackets.put(EAST, bracket);
	}

	
	/**
	 * @return Returns the finalFourBracket.
	 */
	public FinalFourBracket getFinalFourBracket() {
		return (FinalFourBracket) brackets.get(FINALFOUR);
	}

	
	/**
	 * @param finalFourBracket The finalFourBracket to set.
	 */
	public void setFinalFourBracket(FinalFourBracket bracket) {
		brackets.put(FINALFOUR, bracket);
	}

	
	/**
	 * @return Returns the midwestBracket.
	 */
	public MarchMadnessBracket getMidwestBracket() {
		return (MarchMadnessBracket) brackets.get(MIDWEST);
	}

	
	/**
	 * @param midwestBracket The midwestBracket to set.
	 */
	public void setMidwestBracket(MarchMadnessBracket bracket) {
		brackets.put(MIDWEST, bracket);
	}

	
	/**
	 * @return Returns the southBracket.
	 */
	public MarchMadnessBracket getSouthBracket() {
		return (MarchMadnessBracket) brackets.get(SOUTH);
	}

	
	/**
	 * @param southBracket The southBracket to set.
	 */
	public void setSouthBracket(MarchMadnessBracket bracket) {
		brackets.put(SOUTH, bracket);
	}

	
	/**
	 * @return Returns the westBracket.
	 */
	public MarchMadnessBracket getWestBracket() {
		return (MarchMadnessBracket) brackets.get(WEST);
	}

	
	/**
	 * @param westBracket The westBracket to set.
	 */
	public void setWestBracket(MarchMadnessBracket bracket) {
		brackets.put(WEST, bracket);
	}


	/**
	 * @param east2
	 * @return
	 */
	public MarchMadnessBracket getBracket(String name) {
		return (MarchMadnessBracket) brackets.get(name);
	}

}
