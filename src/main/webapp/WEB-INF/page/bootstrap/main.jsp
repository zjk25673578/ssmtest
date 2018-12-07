<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>创建模态框（Modal）</h2>
    <!-- 按钮触发模态框 -->
    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button>
    <!-- 模态框（Modal） -->
    <div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="row">
                    <div class="col-sm-12 ibox-content-form">
                        <form class="form-horizontal" style="padding-top: 30px;" method="post" id="eForm">

                            <input type="hidden" id="companyId" value="${companyId}"/>

                            <div class="form-group">
                                <div class="col-sm-6">
                                    <label class="col-sm-3 control-label">联系人：</label>
                                    <div class="col-sm-7">
                                        <select class="form-control" onchange="selectLinkman(this.value)">
                                            <option value="">请选择</option>
                                        </select>
                                        <input type="hidden" id="linkman" value=""/>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <label class="col-sm-3 control-label">职务：</label>
                                    <div class="col-sm-7">
                                        <input type="text" id="post" class="form-control" placeholder="请输入职务"
                                               maxlength="32"
                                               disabled="disabled"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-6">
                                    <label class="col-sm-3 control-label">联系电话：</label>
                                    <div class="col-sm-7">
                                        <select class="form-control" id="mobile">
                                            <option value="">请选择</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <label class="col-sm-3 control-label">邮箱：</label>
                                    <div class="col-sm-7">
                                        <input type="text" id="email" class="form-control" placeholder="请输入邮箱"
                                               maxlength="64"
                                               disabled="disabled"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-6">
                                    <label class="col-sm-3 control-label">邮件详情：</label>
                                    <div class="col-sm-7">
                                        <select class="form-control" id="emailType">
                                            <option value="">请选择</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <label class="col-sm-3 control-label">下次联系时间：</label>
                                    <div class="col-sm-7">
                                        <input type="text" id="nextContactTime" class="form-control"
                                               placeholder="请输入下次联系时间"
                                               maxlength="32"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-6">
                                    <label class="col-sm-3 control-label">洽谈详情：</label>
                                    <div class="col-sm-7">
                            <textarea class="form-control" rows="" cols="" id="negotiateDetail"
                                      maxlength="256"></textarea>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
</body>
</html>
