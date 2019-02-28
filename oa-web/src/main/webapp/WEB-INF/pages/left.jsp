<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="common/taglib.jsp" %>
<html>
<head>
    <title>导航菜单</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script language="JavaScript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="JavaScript" src="${pageContext.request.contextPath}/script/menu.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/menu.css"/>
</head>
<body style="margin: 0">
<div id="Menu">
    <ul id="MenuUl">
        <c:forEach items="${topPrivilegeList}" var="topPrivilege">
            <li class="level${topPrivilege.privilegeLevel}">
                <div onClick="menuClick(this);" class="level1Style"><img
                        src="${pageContext.request.contextPath}/style/images/MenuIcon/FUNC20082.gif"
                        class="Icon"/> ${topPrivilege.privilegeName}
                </div>
                <ul style="display: none;" class="MenuLevel2">
                    <c:forEach items="${oaFun:findPrivilegeChildrenById(topPrivilege.privilegeId)}"
                               var="childPrivilege">
                        <li class="level${childPrivilege.privilegeId}">
                            <div class="level2Style"><img
                                    src="${pageContext.request.contextPath}/style/images/MenuIcon/menu_arrow_single.gif"/>
                                <a target="right"
                                   href="${pageContext.request.contextPath}${childPrivilege.privilegeUrl}">${childPrivilege.privilegeName}</a></div>
                        </li>
                    </c:forEach>
                </ul>
            </li>
        </c:forEach>

    </ul>
</div>
</body>
</html>
