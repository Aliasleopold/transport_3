<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="rdlab"%>

<fmt:message key="title.topics" var="title_topic" />
<rdlab:html name_page="Businfo" ">

<div class="module width_half">
    <form:form modelAttribute="bustrip" action="find.html" method="post">

        <div class="module_header">
            <c:choose>
                <c:when test="${empty topic.id}">
                    <h3>
                        <fmt:message key="title.add.topic" />
                    </h3>
                </c:when>
                <c:otherwise>
                    <h3>
                        <fmt:message key="title.edit.topic" />
                    </h3>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="module_content">
            <rdlab:errors model="bustrip"/>
            <form:hidden path="id"/>
            <fieldset>
                <form:label path="idStopIn"><fmt:message key="idStopIn" /></form:label> 
                <form:input path="idStopIn""/>
            </fieldset>
            <fieldset>
                <form:label path="idStopTo"><fmt:message key="idStopTo" /></form:label> 
                <form:input path="idStopTo"/>
            </fieldset>
            <fieldset>
                <form:label path="time"><fmt:message key="t" /></form:label> 
                <form:input path="t"/>
            </fieldset>
            <fieldset>
                <form:label path="day_type"><fmt:message key="day_type" /></form:label> 
                <form:input path="day_type"/>
            </fieldset>
        </div>

        <div class="module_footer">
            <div class="submit_link">
                <fmt:message key="btn.find" var="find" />
                <input type="submit" value="${find}">
            </div>
        </div>
    </form:form>
</div>

</rdlab:html>

