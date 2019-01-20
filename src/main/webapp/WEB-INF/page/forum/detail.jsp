<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/lib/layui/css/layui.css">
    <style>
        .btn-sub-reply{
            color: blue;
        }
    </style>
    <script src="${ctx}/lib/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-card">
            <div class="layui-card-header">${article.otitle}</div>
            <div class="layui-card-body">
                ${article.content}
            </div>
        </div>
    </div>
    <div class="layui-row">
        <form class="layui-form">
            <input type="hidden" id="articleId" name="articleId" value="${article.id}">
            <div class="layui-form-item">
                <label class="layui-form-label">当前用户</label>
                <div class="layui-input-inline">
                    <select name="username" lay-filter="username">
                        <c:forEach items="${userList}" var="user">
                            <option value="${user.ids}">${user.realname}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <a href="javascript:;" lay-submit lay-filter="reply" class="layui-btn">回复</a>
                </div>
            </div>
        </form>
    </div>
    <div class="layui-row" id="panel">
        <c:forEach items="${replyList}" var="reply">
            <div class="layui-col-md3">
                    ${reply.username}
                <c:if test="${not empty reply.realname}">
                    <font color="red"> 回复 </font>${reply.realname}
                </c:if>
            </div>
            <div class="layui-col-md3">
                回复时间:${reply.replyTime}
            </div>
            <div class="layui-col-md8">
                <span>${reply.content}</span>&nbsp;&nbsp;&nbsp;<a href="javascript:;" replyId="${reply.id}" class="btn-sub-reply">回复</a>
            </div>
            <div class="layui-col-md12">
                <hr class="layui-bg-green">
            </div>
        </c:forEach>
    </div>
</div>
<script id="demo" type="text/html">
    <input type="hidden" id="replyId" value="{{ d.replyId }}">
    <div class="layui-form-item">
        <label class="layui-form-label">回复内容</label>
        <div class="layui-input-block">
            <input type="text" id="content" class="layui-input">
        </div>
    </div>
</script>
<script>
    layui.use(['form', 'layer', 'laytpl', 'jquery'], function () {
        var form = layui.form,
            layer = layui.layer,
            laytpl = layui.laytpl,
            $ = layui.jquery;

        $.post(_ctx + "/appuser/setSession", {ids: 1}, function (d) {
            if (d.success) {
                layer.alert("当前登录用户修改为: " + d.realname, {
                    icon: 1
                });
            }
        }, "json");

        form.on('select(username)', function (data) {
            $.post(_ctx + "/appuser/setSession", {ids: data.value}, function (d) {
                if (d.success) {
                    layer.msg("当前登录用户修改为: " + d.realname);
                }
            }, "json");
        });

        form.on('submit(reply)', function (data) {
            laytpl(document.getElementById("demo").innerHTML).render({replyId: data.field.articleId}, function (html) {
                layer.open({
                    content: html
                    , btn: ['确定', 'cancel']
                    , yes: function (index, layero) {
                        submitReply(index);
                    }
                });
            });
            return false;
        });

        $("#panel").on("click", ".btn-sub-reply", function () {
            laytpl(document.getElementById("demo").innerHTML).render({replyId: $(this).attr("replyId")}, function (html) {
                layer.open({
                    content: html
                    , btn: ['确定', 'cancel']
                    , yes: function (index, layero) {
                        submitReply(index);
                    }
                });
            });
        });

        function submitReply(index) {
            var reply = {
                artId: $("#articleId").val(),
                replyId: $("#replyId").val(),
                content: $("#content").val()
            };
            $.post(_ctx + "/forum/saveReply", reply, function (d) {
                if (d.success) {
                    var html = '<div class="layui-col-md3">'
                        + d.reply.username + (d.reply.realname ? '<font color="red"> 回复 </font>' + d.reply.realname : '')
                        + '</div><div class="layui-col-md3">'
                        + '回复时间:'
                        + d.reply.replyTime
                        + '</div><div class="layui-col-md8"><span>' + d.reply.content + '</span>'
                        + '&nbsp;&nbsp;&nbsp;<a href="javascript:;" replyId="' + d.reply.id + '" class="btn-sub-reply">回复</a></div>'
                        + '<div class="layui-col-md12"><hr class="layui-bg-green"></div>';

                    $("#panel").append(html);
                    layer.close(index);
                }
            }, "json");
        }
    });
</script>
</body>
</html>
