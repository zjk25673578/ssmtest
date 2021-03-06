$(function () {

    let $sideMenu = $('#side-menu');
    $.post(_ctx + "/ztree/getSysmenuData2", function (data) {
        var menuData = convert(data);
        let h = createMenu(menuData, 0);
        $sideMenu.html(h);
    }, "json");

    $sideMenu.on('click', '.d-firstNav', function (e) {
        dropSwift($(this), '.d-firstDrop');
        e.stopPropagation();
    });

    $sideMenu.on('click', '.d-secondNav', function (e) {
        dropSwift($(this), '.d-secondDrop');
        e.stopPropagation();
    });
});

let idxs = ["first", "", "", "", "", "", ""];
let classNames = ["d-firstNav s-firstNav", "d-secondNav s-secondNav", "s-thirdItem", "", "", "", "", "", ""];
let classNamesDrop = ["d-firstDrop s-firstDrop", "d-secondDrop s-secondDrop", "", "", "", "", "", ""];

/**
 * 将json对象转换成html元素
 * @param menuData 菜单数据源
 * @param flag 当前层级, 第一级为0
 * @param tempIdx 当前的索引, 用来记录子菜单的层级
 * @returns {string}
 */
function createMenu(menuData, flag, tempIdx) {
    let tempIndex = flag;
    let html = flag === 0 ? '' : '<ul class="' + classNamesDrop[tempIdx] + '">';
    let arrow = '<i class="fa fa-caret-right fr"></i>';
    for (let i = 0; i < menuData.length; i++) {
        let menu = menuData[i];
        let li = '<li class="' + idxs[flag] + '"><div class="' + classNames[flag] + '">';

        if (menu.children) {
            // li += arrow; // 如果有子菜单, 就拼一个下箭头1
            li += '<i class="' + menu.icon + '"></i>' +
                '<span>' + menu.text + '</span>' + arrow + '</div>';
            li += createMenu(menu.children, flag + 1, tempIndex);
            li += '</li>';
        } else {
            if (menu.url) {
                li += '<a href="' + menu.url + '"><i class="' + menu.icon + '"></i>' +
                    '<span>' + menu.text + '</span></a></div></li>';
            } else {
                li += '<i class="' + menu.icon + '"></i>' +
                    '<span>' + menu.text + '</span></div></li>';
            }
        }
        html += li;
    }
    html += flag === 0 ? '' : '</ul>';
    return html;
}

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
            if (rows[i].id === parentId) {
                return true;
            }
        }
        return false;
    }

    let nodes = [];
    // get the top level nodes
    for (let i = 0; i < rows.length; i++) {
        let row = rows[i];
        if (!exists(rows, row.parentid)) {
            nodes.push({
                id: row.id,
                text: row.label,
                icon: row.icon,
                url: row.url
            });
        }
    }

    let toDo = [];
    for (let i = 0; i < nodes.length; i++) {
        toDo.push(nodes[i]);
    }
    while (toDo.length) {
        // shift() 方法用于把数组的第一个元素从其中删除，并返回第一个元素的值。
        let node = toDo.shift();
        // get the children nodes
        for (let i = 0; i < rows.length; i++) {
            let row = rows[i];
            if (row.parentid === node.id) {
                let child = {
                    id: row.id,
                    text: row.label,
                    icon: row.icon,
                    url: row.url
                };
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