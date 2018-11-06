<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>模块导航</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<h2>模块导航</h2>
<div class="myrow">
    <a href="${ctx}/appuser/showUsers">用户列表</a>
</div>
<div class="myrow">
    <a href="javascript:;">poi导出word</a>
</div>
<div class="myrow">
    <a href="javascript:;">poi导出excel</a>
</div>
<div class="myrow">
    <a href="javascript:;">freemarker导出word</a>
</div>
<div class="myrow">
    <a href="javascript:;">freemarker导出excel</a>
</div>
</body>
</html>
