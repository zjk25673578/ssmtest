<%@ page import="com.hanqi.util.MyDate" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.hanqi.util.MyUtil" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
    <link rel="stylesheet" href="${ctx}/css/atteninfo.css">
</head>
<body id="body">
<input type="hidden" id="userid" value="${ids}" />
<div id="atten_menu" class="atten_menu">
    <ul>
        <c:forEach items="${dicList}" var="dic">
            <li class="atten-event" id="${dic.attencode}">${dic.attenname}</li>
        </c:forEach>
    </ul>
</div>
<span class="atten-title">
    <a href="${ctx}/attendance/showUserAttenInfo?ids=${ids}&month=${month - 1}">上一月</a>
    ${realname}的${month}月考勤记录
    <a href="${ctx}/attendance/showUserAttenInfo?ids=${ids}&month=${month + 1}">下一月</a>
</span>
<table border="1" cellspacing="0" cellpadding="0" width="80%" height="60%" align="center">
    <tr>
        <td>星期日</td>
        <td>星期一</td>
        <td>星期二</td>
        <td>星期三</td>
        <td>星期四</td>
        <td>星期五</td>
        <td>星期六</td>
    </tr>
    <%
        int row = (int) request.getAttribute("row");
        int col = (int) request.getAttribute("col");
        int firstweekday = (int) request.getAttribute("firstweekday");
        int day = 1;
        int maxDay = (int) request.getAttribute("maxDay");
        Map<String, Object> mapInfo = (Map<String, Object>) request.getAttribute("mapInfo");
        int year = MyDate.getCurrYear();
        int month = (int) request.getAttribute("month");
        boolean flag = false;
        for (int i = 1; i <= row; i++) {
            out.print("<tr>");
            for (int j = 1; j <= col; j++) { // 周几
                if (j == firstweekday) {
                    flag = true;
                }
                if (day > maxDay) {
                    flag = false;
                }
                if (flag) {
                    String sign = MyUtil.concat(year, month, day);
                    out.print("<td>" + day + "<a class='add_atten' sign='" + year + "-" + month + "-" + day + "' href='javascript:void(0);'>添加考勤</a><hr>" + (mapInfo.get(sign) == null ? "" : mapInfo.get(sign)) + "</td>");
                    day++;
                } else {
                    out.print("<td></td>");
                }
            }
            out.print("</tr>");
            if (day > maxDay) {
                break;
            }
        }
    %>
</table>
<span class="atten-back">
    <a href="${ctx}/appuser/showUsers">返回用户列表</a>
</span>
<script type="text/javascript" src="${ctx}/js/atteninfo.js"></script>
</body>
</html>
