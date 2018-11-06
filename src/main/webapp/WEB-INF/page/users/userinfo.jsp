<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/8 0008
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>用戶信息</title>
    <meta charset="utf-8">
    <%@include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<h2>${action eq 'add' ? '添加' : '修改'}用户信息</h2>
<form id="userform" action="${ctx}/appuser/saveUser" method="post">
    <input type="hidden" name="ids" value="${appuser.ids}" />
    <table cellpadding="0" cellspacing="0" border="0">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" value="${appuser.username}" /></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="realname" value="${appuser.realname}" /></td>
        </tr>
        <tr>
            <td>创建日期</td>
            <td><input type="text" name="createTime" value="<fmt:formatDate value="${appuser.createTime}" type="date" dateStyle="default" />" /></td>
        </tr>
        <tr>
            <td><a id="btn_submit" href="javascript:void(0);">保存</a></td>
            <td><a href="${ctx}/appuser/showUsers">返回</a></td>
        </tr>
    </table>
</form>
<script src="${ctx}/js/userinfo.js"></script>
</body>
</html>
