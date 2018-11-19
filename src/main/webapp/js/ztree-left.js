$(function () {
    let setting = {
        check: {
            enable: false,
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
                name: "label"
            },
            simpleData: {
                enable: true,
                idKey: "ids",
                pIdKey: "parentid"
            }
        },
        callback: {
            beforeClick: function (treeId, treeNode) {
                let zTree = $.fn.zTree.getZTreeObj(treeId); // 外层ul容器的id
                if (treeNode.isParent) {
                    var nodes = zTree.getNodes();
                    for (let i = 0; i < nodes.length; i++) {
                        var ids = nodes[i].ids;
                        if (ids !== treeNode.ids && treeNode.level === nodes[i].level) {
                            zTree.expandNode(nodes[i], false, false, false);
                        }
                    }
                    zTree.expandNode(treeNode, null, false, true);
                } else {
                    zTree.checkNode(treeNode, !treeNode.checked, null, true);
                }
                return false;
            }
        }, view: {
            // addHoverDom: addHoverDom,
            // removeHoverDom: removeHoverDom,
            expandSpeed: "fast",
            dblClickExpand: false,
            showLine: false,
            selectedMulti: false
        }
    };
    $.fn.zTree.init($("#left_menu_demo"), setting);
});

function addHoverDom(treeId, treeNode) {
    var aObj = $("#" + treeNode.tId + "_a");
    if ($("#diyBtn_" + treeNode.id).length > 0)
        return;
    var editStr = "<span id='diyBtn_space_" + treeNode.id + "' >删除</span>"
        + "<button type='button' class='diyBtn1' id='diyBtn_" + treeNode.id
        + "' title='" + treeNode.name + "' onfocus='this.blur();'>修改</button>";
    aObj.append(editStr);
    var btn = $("#diyBtn_" + treeNode.id);
    if (btn) btn.bind("click", function () {
        alert("diy Button for " + treeNode.name);
    });
}

function removeHoverDom(treeId, treeNode) {
    $("#diyBtn_" + treeNode.id).unbind().remove();
    $("#diyBtn_space_" + treeNode.id).unbind().remove();
}

function addDiyDom(treeId, treeNode) {
    var aObj = $("#" + treeNode.tId + "_a");
    if ($("#diyBtn_" + treeNode.id).length > 0) return;
    var editStr = "<span id='diyBtn_space_" + treeNode.id + "' > </span>"
        + "<button type='button' class='diyBtn1' id='diyBtn_" + treeNode.id
        + "' title='" + treeNode.name + "' onfocus='this.blur();'></button>";
    aObj.append(editStr);
    var btn = $("#diyBtn_" + treeNode.id);
    if (btn) btn.bind("click", function () {
        alert("diy Button for " + treeNode.name);
    });
}