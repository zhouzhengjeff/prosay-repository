<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="../common/taglib.jsp" %>
<html>
<head>
    <title>用户列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script language="javascript" src=".${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src=".${pageContext.request.contextPath}/script/pageCommon.js"
            charset="utf-8"></script>
    <script language="javascript" src=".${pageContext.request.contextPath}/script/PageUtils.js"
            charset="utf-8"></script>
    <%--<script language="javascript" src=".${pageContext.request.contextPath}/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src=".${pageContext.request.contextPath}/script/DataShowManager.js" charset="utf-8"></script>--%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css"/>
    <script type="text/javascript">
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">

        <!-- 表头-->
        <thead>
        <tr align=center valign=middle id=TableTitle>
            <td width="100">登录名</td>
            <td width="100">姓名</td>
            <td width="100">所属部门</td>
            <td width="200">角色</td>
            <td>备注</td>
            <td>相关操作</td>
        </tr>
        </thead>

        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
        <c:if test="${empty userList}">没有用户</c:if>
        <c:forEach items="${userList}" var="user">
            <tr class="TableDetail1 template">
                <td>${user.loginName}&nbsp;</td>
                <td>${user.userName}&nbsp;</td>
                <td>${oaFun:findDepartmentByUser(user).departmentName}&nbsp;</td>
                <td>${oaFun:findAllRoleNamesByUser(user)}&nbsp;</td>
                <td>${user.userRemark}&nbsp;</td>
                <td><a onClick="return delConfirm()" href="list.jsp">删除</a>
                    <a href="save.jsp">修改</a>
                    <a href="#" onClick="return window.confirm('您确定要初始化密码为1234吗？')">初始化密码</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="${pageContext.request.contextPath}/user/add"><img src="${pageContext.request.contextPath}/style/images/createNew.png"/></a>
        </div>
    </div>
</div>

</body>
</html>
