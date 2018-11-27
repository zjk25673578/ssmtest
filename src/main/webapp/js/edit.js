layui.use(['layedit', 'jquery'], function () {
    var layedit = layui.layedit, $ = layui.jquery;

    layedit.set({
        uploadImage: {
            url: 'upload' //接口url
        }
    });

    var index = layedit.build('demo'); //建立编辑器

    $("#getContent").click(function () {
        var content = layedit.getContent(index);
        console.log(content);
    });
});