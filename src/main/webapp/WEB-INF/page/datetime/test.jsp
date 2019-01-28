<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>时间日期参数接收测试</title>
    <link rel="stylesheet" href="${ctx}/lib/layui/css/layui.css">
    <script src="${ctx}/lib/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">
    <form class="layui-form" action="${ctx}/datetime/formDate" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">测试日期</label>
            <div class="layui-input-inline">
                <input type="text" id="dateParam" name="dateParam" placeholder="请选择日期时间"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDate">只传递一个日期参数(页面跳转)</button>
                <button class="layui-btn" lay-submit lay-filter="formDateAjax">只传递一个日期参数(ajax)</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
    <form class="layui-form" action="${ctx}/datetime/formMvc" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" placeholder="请输入姓名" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" placeholder="请输入密码"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">生日</label>
            <div class="layui-input-inline">
                <input type="text" id="birthday" name="birthday" placeholder="请选择生日"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">创建时间</label>
            <div class="layui-input-inline">
                <input type="text" id="createTime" name="createTime" placeholder="请选择创建时间"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">选择框</label>
            <div class="layui-input-block">
                <select name="city" lay-verify="required">
                    <option value=""></option>
                    <option value="0">北京</option>
                    <option value="1">上海</option>
                    <option value="2">广州</option>
                    <option value="3">深圳</option>
                    <option value="4">杭州</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">爱好</label>
            <div class="layui-input-inline" style="width: 280px;">
                <input type="checkbox" name="like" value="1" title="写作">
                <input type="checkbox" name="like" value="2" title="阅读" checked>
                <input type="checkbox" name="like" value="3" title="发呆">
            </div>
            <div class="layui-form-mid layui-word-aux">后台接收List集合</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">特长</label>
            <div class="layui-input-inline" style="width: 300px;">
                <input type="checkbox" name="advance" value="4" title="踢足球" checked>
                <input type="checkbox" name="advance" value="5" title="打篮球">
                <input type="checkbox" name="advance" value="6" title="唱歌">
            </div>
            <div class="layui-form-mid layui-word-aux">后台接收数组</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">开关</label>
            <div class="layui-input-block">
                <input type="checkbox" name="switsh" value="1" lay-skin="switch">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">单选框</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="1" title="男">
                <input type="radio" name="sex" value="0" title="女" checked>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">文本域</label>
            <div class="layui-input-block">
                <textarea name="desp" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formMvc">页面跳转提交</button>
                <button class="layui-btn" lay-submit lay-filter="formAjax">ajax提交</button>
                <button class="layui-btn" lay-submit lay-filter="formAjaxJson">ajax-json提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<script>
    layui.use(['form', 'laydate', 'layer'], function () {
        var form = layui.form,
            laydate = layui.laydate,
            layer = layui.layer,
            $ = layui.jquery;

        laydate.render({
            elem: '#birthday',
            type: 'datetime'
        });

        laydate.render({
            elem: '#createTime',
            type: 'datetime'
        });
        laydate.render({
            elem: '#dateParam',
            type: 'datetime'
        });

        // 只传递日期参数
        // 页面跳转
        form.on('submit(formDate)', function (data) {
            console.log(JSON.stringify(data.field));
            return true; // 返回true页面跳转
        });

        // ajax
        form.on('submit(formDateAjax)', function (data) {
            myAjax(_ctx + "/datetime/formDateAjax", {"dateParam": data.field.dateParam});
            return false; // 返回true页面跳转
        });


        // 实体类
        // 页面跳转提交表单数据
        form.on('submit(formMvc)', function (data) {
            console.log(JSON.stringify(data.field));
            return true; // 返回true页面跳转
        });

        // ajax的形式提交, 后台以实体类接收
        form.on('submit(formAjax)', function (data) {
            myAjax(_ctx + "/datetime/formAjax", data.field);
            return false;
        });

        // ajax的形式提交, 后台使用@RequestBody注解以实体类或者JSONObject的形式接收
        // layui的form表单传递复选框时只能按照官网文档上写的那样定义input控件中的name属性, 否则只能获取到最后一个值
        form.on('submit(formAjaxJson)', function (data) {
            console.log(data.field);

            data.field.advance = [];
            var advances = $("input[name='advance']:checked");
            console.log(advances.length);
            for (var i = 0; i < advances.length; i++) {
                data.field.advance.push(advances.eq(i).val());
            }

            data.field.like = [];
            var likes = $("input[name='like']:checked");
            console.log(likes.length);
            for (var j = 0; j < likes.length; j++) {
                data.field.like.push(likes.eq(j).val());
            }

            myAjax(_ctx + "/datetime/formAjaxJson", JSON.stringify(data.field), "application/json");
            return false;
        });

        function myAjax(url, data, contentType) {
            var options = {
                type: "post",
                url: url,
                data: data,
                dataType: "json",
                success: function (resultData) {
                    console.log(resultData);
                    var iconType = 0;
                    if (resultData.success) {
                        iconType = resultData.type;
                    } else {
                        iconType = 2;
                    }
                    layer.alert(resultData.action, {icon: iconType, time: 0});
                },
                error: function (m) {
                    layer.alert("程序异常: " + m.status, {icon: 5, time: 0});
                }
            };
            if (contentType) {
                options["contentType"] = contentType;
            }
            $.ajax(options);
        }
    });
</script>
</body>
</html>
