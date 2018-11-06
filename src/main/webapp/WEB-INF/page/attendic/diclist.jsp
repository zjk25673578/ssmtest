<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>字典管理</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<h2>字典管理</h2>
<a href="${ctx}/attendic/updateDicInfo?action=add">添加数据</a>
<a href="${ctx}/appuser/showUsers">返回用户列表</a>
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <td>编号</td>
        <td>假勤状态代码</td>
        <td>假勤状态名称</td>
        <td>操作</td>
    </tr>
    <c:choose>
        <c:when test="${list != null && fn:length(list) > 0}">
            <c:forEach items="${list}" var="dic">
                <tr>
                    <td>${dic.ids}</td>
                    <td>${dic.attencode}</td>
                    <td>${dic.attenname}</td>
                    <td>
                        <a href="${ctx}/attendic/updateDicInfo?ids=${dic.ids}">修改</a>
                        <a href="${ctx}/attendic/deleteDic?ids=${dic.ids}" onclick="return confirm('確定要刪除這條記錄嗎 ?');">刪除</a>
                    </td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="4">无数据</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>
