<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户列表</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<div class="myrow">
    <a href="${ctx}/appuser/userinfo?action=add">添加用戶</a>
    <a href="${ctx}/attendic/showDics">字典管理</a>
    <a href="${ctx}">返回导航</a>
</div>
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <td>编号</td>
        <td>用户名</td>
        <td>姓名</td>
        <td>创建日期</td>
        <td>状态</td>
        <td>操作</td>
    </tr>
    <c:choose>
        <c:when test="${users != null && fn:length(users) > 0}">
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.ids}</td>
                    <td>${user.username}</td>
                    <td>${user.realname}</td>
                    <td>
                        <fmt:formatDate value="${user.createTime}" type="date" dateStyle="long"/>
                    </td>
                    <td>
                        <c:if test="${user.status eq 1}">
                            <c:out value="启用"></c:out>
                        </c:if>
                        <c:if test="${user.status eq 0}">
                            <c:out value="禁用"></c:out>
                        </c:if>
                    </td>
                    <td>
                        <a href="${ctx}/attendance/showUserAttenInfo?ids=${user.ids}&month=${currMonth}">查看考勤信息</a>
                        <c:if test="${user.status eq 1}">
                            <a href="${ctx}/appuser/updateUserStatus?ids=${user.ids}&status=0">禁用</a>
                        </c:if>
                        <c:if test="${user.status eq 0}">
                            <a href="${ctx}/appuser/updateUserStatus?ids=${user.ids}&status=1">启用</a>
                        </c:if>
                        <a href="${ctx}/appuser/updateUserInfo?ids=${user.ids}">修改</a>
                        <a href="${ctx}/appuser/deleteUser?ids=${user.ids}"
                           onclick="return confirm('確定要刪除這條記錄嗎 ?');">刪除</a>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="6">无数据</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>
<div class="myrow">${message}</div>
</body>
</html>
