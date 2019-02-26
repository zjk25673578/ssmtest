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
    <a href="${ctx}/emp/main">员工管理</a>
</div>
<div class="myrow">
    <a href="${ctx}/appuser/showUsers">用户列表</a>
</div>
<div class="myrow">
    <a href="${ctx}/office/main">导出office测试</a>
</div>
<div class="myrow">
    <a href="${ctx}/charts/topage">echarts图表测试</a>
</div>
<div class="myrow">
    <a href="${ctx}/emp/main">员工表测试</a>
</div>
<div class="myrow">
    <a href="${ctx}/ztree/left/main">侧边栏</a>
</div>
<div class="myrow">
    <a href="${ctx}/tranc/test">spring声明式事务测试</a>
</div>
<div class="myrow">
    <a href="${ctx}/sms/sendMsg">短信测试</a>
</div>
<div class="myrow">
    <a href="${ctx}/ckplayer/main">layui视频播放</a>
</div>
<div class="myrow">
    <a href="${ctx}/quartz0/main">quartz测试</a>
</div>
<div class="myrow">
    <a href="${ctx}/forum/list">论坛回复测试</a>
</div>
<div class="myrow">
    <a href="${ctx}/datetime/test">日期类型参数接收测试</a>
</div>
</body>
</html>
