<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%-- Error Messages --%>
<logic:messagesPresent>
  <div class="error">
    <UL>
      <html:messages id="msg" message="false">
        <LI>
        <bean:write name="msg" />
        </LI>
      </html:messages>
    </UL>
  </div>
</logic:messagesPresent>
<%-- Success Messages --%>
<logic:messagesPresent message="true">
  <div class="message">
    <UL>
      <html:messages id="msg" message="true">
        <LI>
        <bean:write name="msg" />
        </LI>
      </html:messages>
    </UL>
  </div>
</logic:messagesPresent>
