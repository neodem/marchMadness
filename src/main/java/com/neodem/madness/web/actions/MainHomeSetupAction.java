/* file 	: 	MainHomeSetupAction.java
 * created 	:	Feb 24, 2006
 * modified :	
 */

package com.neodem.madness.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.neodem.madness.db.MadnessDAO;
import com.neodem.madness.db.beans.Team;
import com.neodem.madness.web.beans.TeamListSessionBean;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 * 
 */
public class MainHomeSetupAction extends BaseMadnessAction {

	private static Log _log = LogFactory.getLog(MainHomeSetupAction.class.getName());
	protected MadnessDAO dao;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		_log.debug("execute()");

		_log.debug("create team list session bean");
		TeamListSessionBean teamListBean = new TeamListSessionBean();
		
		_log.debug("fill session bean");
		Team[] teams = dao.getAllTeams();
		teamListBean.addTeamArray(teams);

		_log.debug("get current session");
		HttpSession session = request.getSession(true);

		_log.debug("store session bean(s)");
		session.setAttribute(SESSION_TEAM_LIST_KEY, teamListBean);

		_log.debug("complete()");
		return mapping.findForward(FORWARD_SUCCESS);
	}
}