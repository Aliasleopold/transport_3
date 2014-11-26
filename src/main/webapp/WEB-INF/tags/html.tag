<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="transport"%>
<%@ attribute name="name_page" required="false" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="hasRoles" required="false" rtexprvalue="true" type="java.lang.String"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <fmt:message key="title" var="textTitle" /> 
    <title>${textTitle}</title>

    <c:url value="/index.html" var="index"/>
</head>
<body>
    <div id="header"> 
            <h1 class="site_title"><a href="${index}">${textTitle}</a></h1>
            <h2 class="section_title">${name_page}</h2>
    </div>
    <!-- end of header bar -->

    
        <div class="breadcrumbs_container">
            <div class="breadcrumbs"> 
                <a href="${index}"><fmt:message key="href.index"/></a>
                <div class="breadcrumb_divider"></div>
                <a class="current">${name_page}</a>
            </div>
        </div>
    </div>
    <!-- end of secondary bar -->
        <div class="footer">
        <hr />
            <p>
                <strong>Copyright &copy; transport a3.0</strong>
            </p>
        </div>
    </div>
    
        <c:if test="${isAccess}">
            <h4 class="alert_warning">
               <fmt:message key="forbidden.error" /> 
            </h4>
        </c:if>
        <div class="spacer"></div>
    </div>
</body>
</html>