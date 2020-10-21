$(function() {
    $("#regBtn").click(function() {
        var username = $("#username").val();
        if (!username) {
            alert("请输入用户名");
            $("#username").focus();
            return;
        }

        var email = $("#email").val();
        if (!email) {
            alert("请输入邮箱");
            $("#email").focus();
            return;
        }

        var userpwd = $("#userpwd").val();
        if (!userpwd) {
            alert("请输入密码");
            $("#userpwd").focus();
            return;
        }

        var conpwd = $("#conpwd").val();
        if (!conpwd) {
            alert("请确认密码！！！");
            $("#conpwd").focus();
            return;
        }

        $.post("/wbzluntan/reg2", $("[name]").serialize(), function(data) {
            if (data == "true") {
                alert("修改成功，请重新登录")
                window.location.href = "/wbzluntan/login.html";
            } else {
                alert("修改失败");
                $("#username").focus();
                $("#username").select();
            }
        }, "text");
    });
});
$(document).ready(function() {
    $("#backbtn").click(function() {
        window.location.href = "/wbzluntan/myinf.html";
    })
});