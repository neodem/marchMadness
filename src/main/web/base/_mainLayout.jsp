<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage="" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/fmt" prefix="fmt" %>
<fmt:setBundle basename="resources.messages"/>
<tiles:importAttribute scope="request"/>
<HTML>
<HEAD>
<TITLE><fmt:message key="${titleKey}"/></TITLE>
<html:base/>
<LINK REL="stylesheet" HREF="../common/style1.css" TYPE="text/css">
<script language="JavaScript" src="../common/common.js"></script>
</HEAD>
<BODY BACKGROUND="../images/design/stripes.gif">
<CENTER>
	<tiles:insert attribute="header"/>
	<TABLE WIDTH="825" BORDER="0" BGCOLOR="#8c9c84" CELLSPACING="8" CELLPADDING="3">
		<TR>
			<TD WIDTH="10%" ALIGN="CENTER" VALIGN="top" class="menuText"><tiles:insert attribute="menu"/></TD>
			<TD WIDTH="90%" BGCOLOR="#dddddd" ALIGN="CENTER" VALIGN="TOP">
				<BR>
				<tiles:insert attribute="body"/>
			</TD>
		</TR>
	</TABLE>
	<tiles:insert attribute="footer"/>
</CENTER>
</BODY>
</HTML>
