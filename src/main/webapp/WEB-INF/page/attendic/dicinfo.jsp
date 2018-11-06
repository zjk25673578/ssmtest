<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/8 0008
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<h2>${action eq 'add' ? '添加' : '修改'}字典数据</h2>
<form id="dicform" action="${ctx}/attendic/saveDic" method="post">
    <input type="hidden" name="ids" value="${dic.ids}" />
    <table>
        <tr>
            <td>状态代码</td>
            <td><input type="text" name="attencode" value="${dic.attencode}" /></td>
        </tr>
        <tr>
            <td>状态名称</td>
            <td><input type="text" name="attenname" value="${dic.attenname}" /></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td><a id="btn_submit" href="javascript:void(0);">保存</a></td>
            <td><a href="${ctx}/attendic/showDics">返回</a></td>
        </tr>
    </table>
</form>
<script src="${ctx}/js/dicinfo.js"></script>
</body>
</html>
