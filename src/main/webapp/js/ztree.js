layui.use(["layer", "jquery"], function () {

    let layer = layui.layer;

    $("#select").on("click", function () {
        loadZtree($("#ids").val());
        layer.open({
            type: 1,
            area: "200px",
            offset: '200px',
            content: $("#menuContent"),
            btn: ["确定", "取消"],
            yes: function (index, layero) {
                let ids = [];
                let mnames = [];
                let ztree = $.fn.zTree.getZTreeObj("ztree-demo");
                let nodelist = ztree.getCheckedNodes(true);
                for (let i = 0; i < nodelist.length; i++) {
                    if (!nodelist[i].isParent) {
                        ids.push(nodelist[i].ids);
                        mnames.push(nodelist[i].label);
                    }
                }
                $("#mname").val(mnames.join(","));
                $("#ids").val(ids.join(","));
                console.log(layero);
                layer.close(index);
            }
        });
    });

});

function loadZtree(_ids) {
    let ids = _ids.split(",");
    let setting = {
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
                let zTree = $.fn.zTree.getZTreeObj("ztree-demo");
                if (treeNode.isParent) {
                    zTree.expandNode(treeNode, null, false, true);
                } else {
                    zTree.checkNode(treeNode, !treeNode.checked, null, true);
                }
                return false;
            }
        }, view: {
            expandSpeed: "fast",
            dblClickExpand: false
        }
    };

    $.fn.zTree.init($("#ztree-demo"), setting);
    let zTree = $.fn.zTree.getZTreeObj("ztree-demo");
    for (let i = 0; i <ids.length; i++) {
        // debugger;
        let treenode = zTree.getNodeByParam("id", ids[i]);
        if (treenode != null) {
            zTree.checkNode(treenode);
        }
    }

}