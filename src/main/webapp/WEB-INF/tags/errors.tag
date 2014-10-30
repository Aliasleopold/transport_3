<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ attribute name="model" required="true" rtexprvalue="true" type="java.lang.String"%>

<spring:hasBindErrors name="${model}">
    <div class="errors">
        <form:errors path="*" >
            <ul>
                <c:forEach items="${messages}" var="message" varStatus="st">
                    <li>${st.index + 1}. ${message}</li>
                </c:forEach>
            </ul>
        </form:errors> 
    </div>         
</spring:hasBindErrors>