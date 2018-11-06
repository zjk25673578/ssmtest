var btns = document.getElementsByClassName("add_atten");

var atten_menu = document.getElementById("atten_menu");

for (var i = 0; i < btns.length; i++) {
    btns[i].onmouseover = function (e) {
        var x = e.clientX;
        var y = e.clientY;
        atten_menu.style.left = (x - 40) + "px";
        atten_menu.style.top = y + "px";
        atten_menu.style.display = "block";
        var sign = this.getAttribute("sign");
        atten_menu.setAttribute("sign", sign);
    };
}

document.getElementById("body").onclick = function () {
    document.getElementById("atten_menu").style.display = "none";
};

var attenEvents = document.getElementsByClassName("atten-event");

for (var i = 0; i < attenEvents.length; i++) {
    attenEvents[i].onclick = function (e) {
        var code = this.id; // 考勤代码
        // var name = this.innerHTML; // 考勤名称(没用)
        var sign = atten_menu.getAttribute("sign"); // 时间
        var userid = document.getElementById("userid").value;
        window.location.href = _ctx + "/attendance/insertUserAttenInfo?code=" + code + "&sign=" + sign + "&userid=" + userid;
    };
}