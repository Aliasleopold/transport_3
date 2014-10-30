<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="rdlab"%>

<fmt:message key="title.topics" var="title_topic" />
<rdlab:html name_page="${title_topic}"  hasRoles="user">

    <div class="module width_full"> 
        <form action="edit.html" method="post">
            <div class="module_header">
                <h3 class="tabs_involved">${title_topic}</h3>
                <c:if test="${isAccess}">
                    <div class="submit_link">
                        <fmt:message key="href.add.topic" var="btn_add"/>
                        <input type="submit" value="${btn_add}"/>
                    </div>
                </c:if>
            </div>
        </form>

        <div class="tab_container">
            <div id="tab1" class="tab_content">
                <table class="tablesorter" cellspacing="0">
                    <thead>
                        <tr>
                            <th class="thNumDel"><fmt:message key="table.number"/></th>
                            <th><fmt:message key="table.name"/></th>
                            <th class="thNumDel"><fmt:message key="table.hour"/></th>
                            <th class="thStatus"><fmt:message key="status" /></th>
                             
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${bustrips}" var="topic" varStatus="st">
                            <tr>
                                <td>${st.index + 1}</td>
                                <td>
                                <a href="edit.html?id=${topic.id}">${topic.name}</a>
                                </td>
                                <td>
                                    ${topic.hours}
                                </td>
                                <td>
                                    <fmt:message key="status.${topic.status_id}"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    
            <div class="module_footer">
                 <div class="submit_link">
                 <fmt:message key="btn.delete" var="btn_delete"/>
                    <input type="submit" value ="${btn_delete}" onclick="return confirm('<fmt:message key="del.topics"/>?')">
                 </div>
            </div>
        </c:if>
        </form>
    </div>
</rdlab:html>
