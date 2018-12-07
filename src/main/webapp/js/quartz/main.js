layui.use(["laydate", "layer", "form"], function () {
    var laydate = layui.laydate,
        layer = layui.layer,
        form = layui.form,
        $ = layui.jquery;

    laydate.render({
        elem: "#date",
        type: "datetime"
    });

    form.on("submit(execute)", function (data) {
        $.post(_ctx + "/quartz0/executeQuartz", data.field, function (data) {
            if (data.success) {
                layer.msg(data.action);
            }
        }, "json");
        return false;
    });
});