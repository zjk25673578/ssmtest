layui.use(["layer", "jquery"], function () {

    var layer = layui.layer;

    $("#select").on("click", function () {
        loadZtree();
        layer.open({
            type: 1,
            area: "200px",
            offset: '200px',
            content: $("#menuContent"),
            btn: ["确定","取消"],
            yes: function() {

            }
        });
    });

});

function loadZtree() {
    var setting = {
        check: {
            enable: true,
            // chkboxType: {"Y": "", "N": ""}
        },
        async: {
            enable: true,
            url: _ctx + "/ztree/getSysmenuData",
            autoParam: ["id", "name=n", "level=lv"],
            otherParam: {"otherParam": "zTreeAsyncTest"}
            // dataFilter: filter
        },
        data: {
            key: {
/*                checked: "checked",
                children: "children",
                isParent: "isParent",
                isHidden: "isHidden",*/
                name: "label"/*,
                title: "label",
                url: "bbbbb"*/
            },
            simpleData: {
                enable: true,
                idKey: "ids",
                pIdKey: "parentid"
            }
        },
        callback: {
            beforeClick: function (treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("ztree-demo");
                zTree.checkNode(treeNode, !treeNode.checked, null, true);
                return false;
            },
            onCheck: function (e, treeId, treeNode) {
/*                console.log(e);
                console.log(treeId);
                console.log(treeNode);*/
/*                var zTree = $.fn.zTree.getZTreeObj("ztree-demo"),
                    nodes = zTree.getCheckedNodes(true),
                    v = "";
                for (var i = 0, l = nodes.length; i < l; i++) {
                    v += nodes[i].label + ",";
                }
                if (v.length > 0) v = v.substring(0, v.length - 1);
                var mname = $("#mname");
                mname.attr("value", v);*/
            }


        }
    };

    $.fn.zTree.init($("#ztree-demo"), setting);
}