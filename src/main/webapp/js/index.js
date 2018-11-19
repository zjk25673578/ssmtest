$(function () {

    $.post(_ctx + "/ztree/getSysmenuData2", function (data) {
        var a = convert(data);
        console.log(a);
    }, "json");

    $('.d-firstNav').click(function (e) {
        dropSwift($(this), '.d-firstDrop');
        e.stopPropagation();
    });
    $('.d-secondNav').click(function (e) {
        dropSwift($(this), '.d-secondDrop');
        e.stopPropagation();
    });
});

function dropSwift(dom, drop) {
    dom.next().slideToggle("fast");
    dom.parent().siblings().find('.fa-caret-right').removeClass('iconRotate');
    dom.parent().siblings().find(drop).slideUp("fast");
    let iconChevron = dom.find('.fa-caret-right');
    if (iconChevron.hasClass('iconRotate')) {
        iconChevron.removeClass('iconRotate');
    } else {
        iconChevron.addClass('iconRotate');
    }
}

function convert(rows) {
    function exists(rows, parentId) {
        for (let i = 0; i < rows.length; i++) {
            if (rows[i].id == parentId)
                return true;
        }
        return false;
    }

    let nodes = [];
    // get the top level nodes
    for (let i = 0; i < rows.length; i++) {
        let row = rows[i];
        if (!exists(rows, row.parentId)) {
            nodes.push({
                id: row.id,
                text: row.LABEL
            });
        }
    }

    let toDo = [];
    for (let i = 0; i < nodes.length; i++) {
        toDo.push(nodes[i]);
    }
    while (toDo.length) {
        let node = toDo.shift();	// the parent node
        // get the children nodes
        for (let i = 0; i < rows.length; i++) {
            let row = rows[i];
            if (row.parentId == node.id) {
                let child = {id: row.id, text: row.LABEL};
                if (node.children) {
                    node.children.push(child);
                } else {
                    node.children = [child];
                }
                toDo.push(child);
            }
        }
    }
    return nodes;
}