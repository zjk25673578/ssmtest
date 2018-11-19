<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>aaaaaaaa</title>
</head>
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
<link rel="stylesheet" href="${ctx}/css/left/left.css" />
<script type="text/javascript" src="${ctx}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${ctx}/js/index.js"></script>
<body>
<div class="s-side">
    <ul id="side-menu">
        <li class="s-firstItem first">
            <a href="#">
                <i class="fa fa-home"></i>
                <span>首页</span>
            </a>
        </li>
        <li class="first">
            <div class="d-firstNav s-firstNav clearfix">
                <i class="fa fa-bars"></i>
                <span>一级菜单</span>
                <i class="fa fa-caret-right fr "></i>
            </div>
            <ul class="d-firstDrop s-firstDrop">
                <li>
                    <div class="d-secondNav s-secondNav">
                        <i class="fa fa-minus-square-o"></i>
                        <span>二级菜单</span>
                        <i class="fa fa-caret-right fr"></i>
                    </div>
                    <ul class="d-secondDrop s-secondDrop">
                        <li class="s-thirdItem">
                            <a href="#">三级导航</a>
                        </li>
                        <li class="s-thirdItem">
                            <a href="#">三级导航</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <div class="d-secondNav s-secondNav">
                        <i class="fa fa-minus-square-o"></i>
                        <span>二级菜单</span>
                        <i class="fa fa-caret-right fr "></i>
                    </div>
                    <ul class="d-secondDrop s-secondDrop">
                        <li class="s-thirdItem">
                            <a href="#">三级导航</a>
                        </li>
                    </ul>
                </li>
                <li class="s-secondItem">
                    <a href="#">
                        <i class="fa fa-minus-square-o"></i>
                        <span>二级导航</span>
                    </a>
                </li>
            </ul>
        </li>
        <li class="first">
            <div class="d-firstNav s-firstNav">
                <i class="fa fa-bars"></i>
                <span>一级菜单</span>
                <i class="fa fa-caret-right fr"></i>
            </div>
            <ul class="d-firstDrop s-firstDrop">
                <li class="s-secondItem">
                    <i class="fa fa-minus-square-o"></i>
                    <a href="#">二级导航</a>
                </li>
                <li class="s-secondItem">
                    <i class="fa fa-minus-square-o"></i>
                    <a href="#">二级导航</a>
                </li>
            </ul>
        </li>
    </ul>
</div>
</body>
</html>
