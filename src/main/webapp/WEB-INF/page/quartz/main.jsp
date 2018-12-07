<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>quartz定时任务测试</title>
    <link rel="stylesheet" href="${ctx}/lib/layui/css/layui.css">
    <script src="${ctx}/lib/layui/layui.js"></script>
    <script src="${ctx}/js/quartz/main.js"></script>
</head>
<body>
<div class="layui-container">
    <form class="layui-form" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">复选框</label>
            <div class="layui-input-block">
                <input id="loop" type="checkbox" name="loop" value="1" title="循环执行">
            </div>
        </div>
        <label for="date" class="layui-form-label">
            时间节点
        </label>
        <div class="layui-input-inline">
            <input id="date" name="date" class="layui-input" type="text">
        </div>
        <a id="execute" lay-submit lay-filter="execute" class="layui-btn">执行</a>
    </form>
</div>
</body>
</html>
