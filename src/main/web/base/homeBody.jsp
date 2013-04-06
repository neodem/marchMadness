<%@ taglib uri="http://jakarta.apache.org/taglibs/fmt" prefix="fmt" %>
<%@ taglib uri="/tags/neodem" prefix="neodem" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<fmt:setBundle basename="resources.messages"/>
<TABLE WIDTH="95%" BORDER="0" CELLSPACING="0" CELLPADDING="5">
	<TR>
		<TD BGCOLOR="#ffffff" ALIGN="CENTER" VALIGN="MIDDLE" height="68">
			<span class="hugeBold"><neodem:greeting/></span>&nbsp;
			<span class="hugeAccentBold"><c:out value="${sessionUser.username}"/></span>,
		</TD>
	</TR>
	<tr><td><%@ include file="../common/messages.jsp" %></td></tr>
	<TR>
		<TD ALIGN="CENTER" class="large">
		
			Please make a selection from the menu
		</TD>
	</TR>
</TABLE>

