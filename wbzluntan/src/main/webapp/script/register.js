$(function(){
    //判断用户名可不可用
    $("#username").blur(function(){
        var username = $(this).val();
        if(!username){
            return;
        }
        $.post("/wbzluntan/checkname", $(this).serialize(), function(data){
            if(data == "true"){
                $("#msg").css("color","green").html("该名字可用").fadeOut(3000);
            }
            else{
                $("#msg").css("color","red").html("该名字不可用").fadeOut(3000);
            }
        },"text");
    });

    
    //判断邮箱是否可用
    $("#email").blur(function(){
        var email = $(this).val();
        if(!email){
            return;
        }
        $.post("/wbzluntan/checkemail", $(this).serialize(), function(data){
            if(data == "true"){
                $("#emsg").css("color","green").html("该邮箱可用").fadeOut(3000);
            }
            else{
                $("#emsg").css("color","red").html("该邮箱已存在").fadeOut(3000);
            }
        },"text");
    })
// 判断邮箱格式是否正确
    $("#email").blur(function(){
        var email = $(this).val();
        if(!email){
            return;
        }
        $.post("/wbzluntan/rightemail", $(this).serialize(), function(data){
            if(data == "true"){
                $("#userpwd").focus();
            }
            else{
                alert("该邮箱格式不正确");
                $("#email").focus();
            }
        },"text");
    })

    $("#regBtn").click(function(){
        var username = $("#username").val();
        if(!username){
            alert("请输入用户名");
            $("#username").focus();
            return;
        }

        var email = $("#email").val();
        if(!email){
            alert("请输入邮箱");
            $("#email").focus();
            return;
        }

        var userpwd = $("#userpwd").val();
        if(!userpwd){
            alert("请输入密码");
            $("#userpwd").focus();
            return;
        }

        var conpwd = $("#conpwd").val();
        if(!conpwd){
            alert("请确认密码！！！");
            $("#conpwd").focus();
            return;
        }

        if(userpwd!=conpwd){
            alert("两次密码不一致。");
            $("#conpwd").focus();
            return;
        }

        $.post("/wbzluntan/reg", $("[name]").serialize(), function (data) {
            if(data == "true"){
                alert("恭喜您，已经成为我们的一员，请登录。")
                window.location.href = "/wbzluntan/login.html"; 
            }
            else{
                alert("注册信息错误请重试！");
                $("#username").focus();
                $("#username").select();
            }
        },"text");
    });
});

// 大小写锁定
$(function(){
	
	$(window).keydown(function(event){
		console.log(event.keyCode);
		var isLock=$("#islock").val()*1;
		if(event.keyCode==20&&isLock%2==1){
			$("#islock").val(isLock+1);
			$("#showlock").css("color","red").show();
		}else {
			$("#islock").val(isLock+1);
			$("#showlock").css("color","red").hide();
		} 
    })
})