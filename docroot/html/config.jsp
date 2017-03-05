<%@ include file="/html/init_jsp.jsp" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@ page import="javax.portlet.PortletPreferences"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL" />

<%
	PortletPreferences preferences = renderRequest.getPreferences();
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
%>

<aui:form action="<%=configurationActionURL%>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />

	<liferay-ui:error exception="<%= Exception.class %>" message="please-enter-valid-values" />
	
	<liferay-ui:panel-container extended="<%= Boolean.TRUE %>" id="resourcesPortletConfiguration" persistState="<%= true %>">
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="resourcesPortletGeneral" persistState="<%= true %>" 
			title="resourcesPortlet-configuration">
			<aui:fieldset>
				<liferay-ui:message key="help-field-values-comma-separated" />
				<!-- WISHLIST: una lista incrementable por js -->
<%
				String[] labels = {"one","two","three"};
				for (String lbl: labels) {
					String keyName = lbl + "_key";
					String keyValue = lbl + "_value";
%>
					<liferay-ui:message key="<%=lbl %>" /><br>
					<aui:input 
						label="<%=lbl %>" 
						name="<%=keyName %>" value="<%=keyValue  %>" wrapperCssClass="lfr-input-text-container" />
<%
				}
%>
			</aui:fieldset>
		</liferay-ui:panel>
	</liferay-ui:panel-container>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>