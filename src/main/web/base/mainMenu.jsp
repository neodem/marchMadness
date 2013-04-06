<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/fmt" prefix="fmt" %>
<%@ taglib uri="/tags/neodem" prefix="neodem" %>
<fmt:setBundle basename="resources.messages"/>

<c:if test="${skip != 'eRecipe'}">
<neodem:statusLink href="../recipe.do?method=edit" statusKey="recipe.global.menu.status.eRecipe" styleClass="bodyWhite">
<fmt:message key="recipe.global.menu.label.eRecipe"/>
</neodem:statusLink>
<br>
</c:if>

<c:if test="${skip != 'search'}">
<neodem:statusLink action="/search" statusKey="recipe.global.menu.status.search" styleClass="bodyWhite">
<fmt:message key="recipe.global.menu.label.search"/>
</neodem:statusLink>
<br>
</c:if>

<HR COLOR="#FFFFFF" WIDTH="140">

<c:if test="${skip != 'eIngredient'}">
<neodem:statusLink href="../ingredient.do?method=edit" statusKey="recipe.global.menu.status.eIngredient" styleClass="bodyWhite">
<fmt:message key="recipe.global.menu.label.eIngredient"/>
</neodem:statusLink>
<br>
</c:if>

<c:if test="${skip != 'sIngredient'}">
<neodem:statusLink action="/searchIngredient" statusKey="recipe.global.menu.label.search.ingredients" styleClass="bodyWhite">
<fmt:message key="recipe.global.menu.label.search.ingredients"/>
</neodem:statusLink>
<br>
</c:if>

<c:if test="${skip != 'unit'}">
<HR COLOR="#FFFFFF" WIDTH="140">
<neodem:statusLink href="../unit.do?method=show" statusKey="recipe.global.menu.status.unit" styleClass="bodyWhite">
<fmt:message key="recipe.global.menu.label.unit"/>
</neodem:statusLink>
<br>
</c:if>

<HR COLOR="#FFFFFF" WIDTH="140">
<c:if test="${skip != 'home'}">
<neodem:statusLink action="/home" statusKey="recipe.global.menu.status.home" styleClass="bodyWhite">
<fmt:message key="recipe.global.menu.label.home"/>
</neodem:statusLink>
<br>
</c:if>

<c:if test="${skip != 'logout'}">
<neodem:statusLink action="/logout" statusKey="recipe.global.menu.status.logout" styleClass="bodyWhite">
<fmt:message key="recipe.global.menu.label.logout"/>
</neodem:statusLink>
<br>
</c:if>
<BR>
