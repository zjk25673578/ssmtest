layui.use(["form", "layer", "laydate", "laytpl", "table", "element", "jquery"], function () {

    let form = layui.form,
        table = layui.table,
        layer = layui.layer,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        element = layui.element,
        $ = layui.$;

    /*    layer.msg("Hello World", {
            offset: "50%"
        });*/

    laydate.render({elem: "#start_hiredate"});
    laydate.render({elem: "#end_hiredate"});

    // 添加, 修改表单的数据模型
    let data = {
        empno: "",
        ename: "",
        sex: "",
        age: "",
        hiredate: "",
        sal: "",
        comm: ""
    };

    // 自定义表单验证规则
    let form_validation = {
        ename: function (value) {
            if (!value.length > 0) {
                layer.msg("员工姓名不能为空 !", {icon: 5});
                return false;
            }
            return true;
        },
        sex: function (value) {
            if (value == null || value == undefined || value == "") {
                layer.msg("请选择性别 !", {icon: 5});
                return false;
            }
            return true;
        },
        hiredate: function (value) {
            if (value == null || value == undefined || value == "") {
                layer.msg("请选择日期 !", {icon: 5});
                return false;
            }
            return true;
        }
    };

    // 定义页面中的方法
    let active = {
        // 查询数据
        search: function (field) {
            // search_form  form表单的id
            let key = JSON.stringify(field);

            table.reload("#emps_table", {
                where: {
                    key: key
                },
                method: "post"
                , page: {
                    curr: 1
                }
            });

            /*
            $.ajax({
                type: "POST",
                contentType: "application/json;charset=UTF-8", // 使用@RequestBody向后台传递字符串绑定数据模型的必须参数
                url: _ctx + '/emp/list',
                data: JSON.stringify(field),
                dataType: 'json',
                success: function (data) {
                    console.log(data);
                }
            });
            */
        },

        // 添加数据
        add: function () {
            saveOrUpdate(data, "添加员工信息");
        },

        // 修改数据
        update: function (obj) {
            let date = new Date(obj.data.hiredate);
            obj.data.hiredate = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
            saveOrUpdate(parseData(obj.data), "修改员工信息");
        },

        // 删除数据
        del: function (obj) {
            let row = obj.data;
            layer.confirm("确定删除 <font color='blue'>" + row.ename + " </font>吗 ?", function (index) {
                let empno = row.empno;
                $.post(_ctx + "/emp/deleteEmp", {empno: empno}, function (data) {
                    layer.close(index);
                    table.reload("#emps_table");
                    layer.msg(data.action);
                }, "json");
            });
        },

        // 批量删除数据
        del_multiple: function (obj) {
            let checkStatus = table.checkStatus(obj.config.id);
            let len = checkStatus.data.length;
            if (len > 0) {
                layer.alert("确定删除所选<font color='blue'> " + len + " </font>项 ?", {
                    btn: ["确定", "取消"],
                    btn1: function (index) {
                        let data = checkStatus.data;
                        let ids = "";
                        for (let i = 0; i < len; i++) {
                            ids += data[i].empno;
                            if (i != len - 1) {
                                ids += ",";
                            }
                        }
                        $.post(_ctx + "/emp/delMultipleEmp", {ids: ids}, function (data) {
                            layer.close(index);
                            table.reload("#emps_table");
                            layer.msg(data.action);
                        }, "json");
                    }
                });
            } else {
                layer.msg("Please Select The Data !", {icon: 5});
            }
        }
    };

    // 渲染表格
    table.render({
        elem: "#emps_table"
        , id: "#emps_table"
        , page: true //开启分页
        , toolbar: "#toolbarDemo"
        // , toolbar: false
        , url: _ctx + "/emp/list" //数据接口
        // , height: "full-100"
        , limit: 10
        , limits: [5, 10, 20]
        , cols: [[ //表头
            {type: "checkbox"}
            , {field: "empno", title: "员工编号"}
            , {field: "ename", title: "员工名称"}
            , {
                field: "sex", title: "性别", templet: function (d) {
                    let formatValue = "--";
                    if (d.sex == "1") {
                        formatValue = "男";
                    }
                    if (d.sex == "0") {
                        formatValue = "女";
                    }
                    return formatValue;
                }
            }
            , {field: "age", title: "年龄"}
            , {
                field: "hiredate", title: "入职日期", templet: function (d) {
                    let date = new Date(d.hiredate);
                    let dateinfo = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
                    return dateinfo;
                }
            }
            , {field: "sal", title: "工资"}
            , {field: "comm", title: "奖金"}
            , {field: "", title: "操作", toolbar: "#opera_btns"}
        ]]
    });

    // 监听表格左上方按钮的事件
    table.on("toolbar(emptable)", function (obj) {
        active[obj.event](obj);
    });

    // 监听表格右侧的工具栏
    table.on("tool(emptable)", function (obj) {
        active[obj.event](obj);
    });

    // 监听查询表单的提交事件
    form.on("submit(search_form_submit)", function (data) {
        active["search"](data.field);
        // button必须使用 lay-submit 属性
        // 这里返回 false 才管用 !
        return false;
    });

    var isOpen = false;
    $("#calendarBtn").on("click", function () {
        layer.open({
            title: false,
            type: 2,
            area: ["1000px", "550px"],
            //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            content: [_ctx + "/calendar/main", "no"],
            cancel: function(index, layero) {
                isOpen = false;
            }
        });
        isOpen = true;
    });

    function getLocalTime() {
        var date = new Date();
        $("#calendarBtn").html((date.getHours() < 10 ? "0" + date.getHours() : date.getHours())
            + ":"
            + (date.getMinutes() < 10 ? "0"
                + date.getMinutes() : date.getMinutes())
            + ":"
            + (date.getSeconds() < 10 ? "0"
                + date.getSeconds() : date.getSeconds()));
    }

    getLocalTime();
    setInterval(getLocalTime, 1000);

    var keyCode;
    var lock = false;
    $(window).keydown(function (event) {
        keyCode = event.keyCode;
        if (lock) {
            if (event.keyCode === keyCode && event.keyCode === 32) {
                if (!isOpen) {
                    layer.open({
                        title: false,
                        type: 2,
                        area: ["1000px", "550px"],
                        //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                        content: [_ctx + "/calendar/main", "no"],
                        cancel: function(index, layero) {
                            isOpen = false;
                        }
                    });
                    isOpen = true;
                }
            }
            lock = false;
        }
        lock = true;
        setTimeout(function() {
            keyCode = -1;
            lock = false;
        }, 300);
    });

    // 自定义两个按钮, 可以监听form的submit事件, 但是表单验证规则需要自己定义
    /*    form.on("submit(test_submit)", function (data) {
            console.log(data);
            return false;
        });*/

    /**
     * @param tpl 需要渲染的模板
     * @param title 对话框的标题
     * @param area 对话框的宽高
     * @param dates 需要渲染的日期框的id
     * @param callback 点击确定的回调函数
     * @returns {*} 当前打开的对话框的layui索引
     */
    function openDialog(tpl, title, area, dates, callback) {
        layer.open({
            type: 1,
            content: tpl,
            title: title,
            area: area,
            // shade: 0.2,
            offset: "25%",
            btn: ["保存", "取消"],
            yes: function (idx) {
                callback(idx);
            }
        });
        for (let i = 0; i < dates.length; i++) {
            laydate.render({
                elem: dates[i]
            });
        }
        return form.render();
    }

    /**
     * 格式化一下数据
     * layui表格中取出的行对象如果没有对应的值则设置为空字符串
     * @param updateData
     * @returns {*}
     */
    function parseData(updateData) {
        for (let p in data) {
            if (updateData[p] === undefined) {
                updateData[p] = "";
            }
        }
        return updateData;
    }

    /**
     * 表单验证
     * @param formObj
     * @returns {*}
     */
    function validateForm(formObj) {
        let temp = {};
        for (let attr in formObj) {
            temp[formObj[attr].name] = formObj[attr].value;
        }
        for (let attr in form_validation) {
            let r = form_validation[attr](temp[attr]);
            if (!r) {
                return false;
            }
        }
        return true;
    }

    /**
     * 添加或者修改的方法
     * @param data
     * @param title
     */
    function saveOrUpdate(data, title) {
        let tpl = document.getElementById("form_emp").innerHTML;
        laytpl(tpl).render(data, function (html) {
            console.log(data);
            openDialog(html, title, ["320px", "390px"], ["#hiredate"], function (idx) {
                let formdata = $("#form_data_emp").serializeArray();
                let result = validateForm(formdata); // 表单验证
                if (result) {
                    $.ajax({
                        url: _ctx + "/emp/saveOrUpdateEmp",
                        type: "post",
                        data: formdata,
                        dataType: "json",
                        success: function (data) {
                            // 关闭对话框, 这里模拟ajax延迟, 多次点击会多次提交的问题
                            setTimeout(function () {
                                layer.close(idx);
                            }, 500);
                            table.reload("#emps_table");
                            // layer.alert(data.action, {icon: data.type, time: 1000});
                        },
                        error: function () {
                            // layer.close(idx);
                            layer.msg("出现异常 !");
                        }
                    });
                }
            });
        });
    }
});