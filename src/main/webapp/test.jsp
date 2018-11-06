<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/8 0008
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>测试页面</title>
</head>
<body>
<%
    List<String> list = new ArrayList<>();
    request.setAttribute("list", list);
%>
<hr>
${list.size()}
</body>
</html>
