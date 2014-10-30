<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="rdlab"%>
<fmt:message key="href.home" var="vtitle"/>
<rdlab:html name_page="${vtitle}">

<h1>Businfo</h1>

<h4 class="alert_info">
      <fmt:message key="welcom" /> 
</h4>
            

<ul>
    <li>
        <c:url value="edit.html" var="url" />
        <a href="${url}"><fmt:message key="href.busTrips"/></a>
    </li>
    <li>

</rdlab:html>
