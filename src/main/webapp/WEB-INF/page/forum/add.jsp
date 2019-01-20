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
    <form class="layui-form" action="${ctx}/forum/saveOrUpdate" method="post"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
        <div class="layui-form-item">
            <label class="layui-form-label">主题</label>
            <div class="layui-input-block">
                <input type="text" name="otitle" placeholder="请输入" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">文章</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" name="content" lay-verify="required" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="art">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
        <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
    </form>
</div>
<script>
    layui.use('form', function () {
        var form = layui.form;

        form.on("submit(art)", function (data) {
            return true;
        });
    });
</script>
</body>
</html>
