<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui视频播放组件</title>
    <link rel="stylesheet" href="${ctx}/lib/layui/css/layui.css">
    <script src="${ctx}/lib/layui/layui.js"></script>
    <script src="${ctx}/js/player.js"></script>
</head>
<body>
<div class="layui-container">
    <div class="layui-form-item">
        <div class="video" id="video1" data-url="http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4"
             style="width: 100%;height: 400px;"></div>
    </div>
    <div class="layui-form-item">
        <div class="video" id="video2" data-url="http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4"
             style="width: 100%;height: 400px;"></div>
    </div>
    <div class="layui-form-item">
        <video width="100%" height="400" controls>
            <source src="http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4" type="video/mp4">
            <object data="http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4" width="320" height="240">
                <embed src="http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4" width="320" height="240">
            </object>
        </video>
    </div>
</div>
</body>
</html>
