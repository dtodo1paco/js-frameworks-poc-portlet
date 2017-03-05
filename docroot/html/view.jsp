<%@include file="/html/init_jsp.jsp" %>

<portlet:defineObjects />

This is the <b>Javascript frameworks POC Portlet</b> portlet in View mode.

<liferay-portlet:renderURL var="reactURL">
	<liferay-portlet:param name="jspPage"
		value="/html/react/view.jsp" />
	<liferay-portlet:param name="backURL" value="<%=currentURL%>" />
	<liferay-portlet:param name="redirectURL" value="" />
</liferay-portlet:renderURL>
<ul>
<li>
<aui:a href="<%=reactURL%>" label="ReactJS POST example"></aui:a>
</li>
