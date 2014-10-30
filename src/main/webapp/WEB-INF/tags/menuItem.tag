<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="rdlab"%>
<%@ attribute name="url" required="true" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="classImg" required="false" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="itemTextKey" required="true" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="roles" required="true" rtexprvalue="true" type="java.lang.String"%>
<rdlab:access roles="${roles}">
    <c:url value="${url}" var="item" />
    <li class="${classImg}"><a href="${item}"><fmt:message key="${itemTextKey}"/></a></li>
</rdlab:access>