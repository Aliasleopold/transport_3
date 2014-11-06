<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="transport"%>
<fmt:message key="href.home" var="vtitle"/>
<transport:html name_page="${vtitle}">

<h1>Transport_3</h1>
<h4 class="alert_info">
      <fmt:message key="welcom" /> 
</h4>
<%-- 
<h4 class="alert_info">
      <fmt:message key="welcom" /> 
</h4>
            

<ul>
    <li>
        <c:url value="edit.html" var="url" />
        <a href="${url}"><fmt:message key="href.transport"/></a>
    </li>
    <li>
--%>
</transport:html>
