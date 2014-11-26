<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" pre-fix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="transport"%>
<fmt:message key="title.transport" var="title_topic" />
<transport:html name_page="transport">
<form:form modelAttribute="busTrips" action="cfind.html" method="post">
	<form:hidden path="id" />
	<fieldset>
		<form:label path="idStopIn">
			<fmt:message key="idStopIn" />
		</form:label>
		<form:input path="idStopIn" />
	</fieldset>
	<fieldset>
		<form:label path="idStopTo">
			<fmt:message key="idStopTo" />
		</form:label>
		<form:input path="idStopTo" />
	</fieldset>
	<fieldset>
		<form:label path="time">
			<fmt:message key="time" />
		</form:label>
		<form:input path="time" />
	</fieldset>
	<fieldset>
		<form:label path="day_type">
			<fmt:message key="day_type" />
		</form:label>
		<form:input path="day_type" />
	</fieldset>
	<input type="submit" value="Найти">
</form:form>