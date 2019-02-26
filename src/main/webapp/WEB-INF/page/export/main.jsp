<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>导出office</title>
    <link rel="stylesheet" href="${ctx}/lib/layui/css/layui.css">
    <script src="${ctx}/lib/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">
    <div class="layui-row" style="margin-top: 50px">
        <div class="layui-form-item">
            <a class="layui-btn layui-btn-normal" href="${ctx}/office/exportRichText">导出html到word(poi导出doc, 采用Word打开html文件的形式, 不太规范)</a>
            <a href="${ctx}/office/test" target="_blank">查看html页面内容</a>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-form-item">
            <a class="layui-btn layui-btn-normal" href="${ctx}/office/poiword">poi导出Word(导出固定的Word格式)</a>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-form-item">
            <a class="layui-btn layui-btn-normal" href="javascript:;">导出html到word(富文本)</a>
        </div>
    </div>
</div>
</body>
</html>
