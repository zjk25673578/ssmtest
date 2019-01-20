<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/lib/layui/css/layui.css">
    <script src="${ctx}/lib/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">
    <div class="layui-row">
        <a href="${ctx}/forum/add" class="layui-btn">添加主题</a>
    </div>
    <div class="layui-row layui-col-space20">
        <c:forEach items="${articleList}" var="article">
            <div class="layui-col-md12">
                <a href="${ctx}/forum/detail/${article.id}">${article.otitle}</a>
                <a href="${ctx}/forum/delete/${article.id}" class="layui-btn layui-btn-xs layui-btn-danger">删除</a>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
