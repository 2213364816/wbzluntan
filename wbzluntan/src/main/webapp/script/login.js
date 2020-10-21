$(document).ready(function(){
    $("#btn").click(function(){
        var username = $("#username").val();
        if(!username){
            alert("请输入用户名")
            return;
        }

        var email = $("#email").val();
        if(!email){
            alert("请输入邮箱")
            return;
        }

        var userpwd = $("#userpwd").val();
        if(!userpwd){
            alert("请输入密码")
            return;
        }
        $.post("/wbzluntan/login", $("[name]").serialize(), function (data) {
            if(data.userid) {
                alert("登录成功");
                window.location.href = "/wbzluntan/main.html";
            }
            else{
                alert("输入的用户名邮箱密码不正确，请重新输入")
            }
        }, "json");

    })

    $("#regbtn").click(function(){
        window.location.href = "/wbzluntan/register.html";
    })
});

// 密码的显示与隐藏
$(function() {
    $("#show").click(function(){
        if ($(this).is(":checked")== true){
            $("#userpwd").attr("type","text");
        }
        else{
        $("#userpwd").attr("type","password");
        }
  });
})

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