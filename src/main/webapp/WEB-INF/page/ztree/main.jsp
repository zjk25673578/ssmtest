<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/lib/ztree/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="${ctx}/css/demo.css">
    <link rel="stylesheet" href="${ctx}/lib/layui/css/layui.css">
    <script src="${ctx}/js/jquery-3.2.1.min.js"></script>
    <script src="${ctx}/lib/layui/layui.js"></script>
    <script src="${ctx}/lib/ztree/jquery.ztree.all.js"></script>
    <script src="${ctx}/js/ztree.js"></script>
</head>
<body>
<div class="container">
    <div class="layui-container">
        <div class="layui-col-sm2">
            <label class="layui-form-label" for="mname">
                测试输入框:
            </label>
        </div>
        <input id="ids" type="text">
        <div class="layui-col-sm8">
            <input id="mname" class="layui-input" type="text">
        </div>
        <div class="layui-col-sm2">
            <a id="select" class="layui-btn">选择</a>
        </div>
    </div>
</div>
<div id="menuContent">
    <ul id="ztree-demo" class="ztree"></ul>
</div>
</body>
</html>
