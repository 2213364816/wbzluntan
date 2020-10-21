// $(function(){
//     // //判断用户名可不可用
//     // $("#username").blur(function(){
//     //     var username = $(this).val();
//     //     if(!username){
//     //         return;
//     //     }
//     //     $.post("/wbzluntan/checkname", $(this).serialize(), function(data){
//     //         if(data == "true"){
//     //             $("#msg").css("color","red").html("该名字不存在").fadeOut(3000);
//     //         }
//     //         else{
//     //             $("#msg").css("color","green").html("该名字存在").fadeOut(3000);
//     //         }
//     //     },"text");
//     // });

    
//     // //判断邮箱是否可用
//     // $("#email").blur(function(){
//     //     var email = $(this).val();
//     //     if(!email){
//     //         return;
//     //     }
//     //     $.post("/wbzluntan/checkemail", $(this).serialize(), function(data){
//     //         if(data == "true"){
//     //             $("#emsg").css("color","red").html("该邮箱不存在").fadeOut(3000);
//     //         }
//     //         else{
//     //             $("#emsg").css("color","green").html("该邮箱存在").fadeOut(3000);
//     //         }
//     //     },"text");
//     // })
// // 判断邮箱格式是否正确
//     $("#email").blur(function(){
//         var email = $(this).val();
//         if(!email){
//             return;
//         }
//         $.post("/wbzluntan/rightemail", $(this).serialize(), function(data){
//             if(data == "true"){
//                 $("#userpwd").focus();
//             }
//             else{
//                 alert("该邮箱格式不正确");
//                 $("#email").focus();
//             }
//         },"text");
//     })

//     // $("#sureshow").click(function(){
//     //     var username = $("#username").val();
//     //     if(!username){
//     //         alert("请输入用户名");
//     //         $("#username").focus();
//     //         return;
//     //     }

//     //     var email = $("#email").val();
//     //     if(!email){
//     //         alert("请输入邮箱");
//     //         $("#email").focus();
//     //         return;
//     //     }
//         // $.post("/wbzluntan/moduser", $("[name]").serialize(), function (data) {
//         //     if(data == "true"){
//         //         alert("验证成功。")
//         //         window.location.href = "/wbzluntan/login.html"; 
//         //     }
//         //     else{
//         //         alert("信息错误请重试！");
//         //         $("#username").focus();
//         //         $("#username").select();
//         //     }
//         // },"text");
//     // });
// })
// $(function(){


//     //给显示的按钮绑定点击事件
//     $("#searchBtnShow").click(function(){
//         $("#pageNum").val(1);
//         $("#searchBtn").click();
//     });
//     $("#searchBtn").click(function(){
//         //发送Ajax请求
//         $.post("/wbzluntan/searchuser",  $("[name]").serialize(), function(data){
//             if(data && data.size > 0){
//                 //添加总记录条数
//                 $("#total").html(data.total);
//                 //添加总页数
//                 $("#pages").html(data.pages);
//                 //添加当前页数
//                 $("#curpage").html(data.pageNum);
//                 $("#goRange").attr("max",data.pages);
//                 //添加记录
//                 $("#resulttable tr:gt(0)").remove();
//                 for(var i=0; i < data.list.length; i++){
//                     var userinfo = data.list[i];
//                     var oTr = $("<tr></tr>");
//                     //创建单元格，生成td元素，放入tr中。
//                     $("<td></td>").html(userinfo.userid).appendTo(oTr);
//                     $("<td></td>").html(userinfo.username).appendTo(oTr);
//                     $("<td></td>").html(userinfo.email).appendTo(oTr);
//                     $("<td></td>").html(userinfo.userpwd).appendTo(oTr);
//                     //动态生成删除按钮，如果是当前用户则不能删除。
//                     var oTd = $("<td></td>").appendTo(oTr);
//                         //添加修改按钮
//                         $("<input type='button' value='修改'>").click(function(){
//                             if($(this).val() == "修改"){
//                                 //如果当前按钮上的文字是“修改”。则点击后变成“确定” 
//                                 //将密码变为可编辑状态
//                                 var oTd4 = $(this).parent().parent().find("td:eq(3)");
//                                 var userpwd = oTd4.html();
//                                 oTd3.empty();
//                                 $("<input type='text'>").css("width","50px").val(userpwd).appendTo(oTd4);
//                                 //3.将“修改”按钮变为“确定”
//                                 $(this).val("确定");
//                             }else if($(this).val() == "确定"){
//                                 //如果当前按钮是确定                             
//                                 //验证密码是否填写
//                                 var oText4 = $(this).parent().parent().find("td:eq(3) input");
//                                 var userpwd = oText4.val();
//                                 if(!userpwd){
//                                     alert("请输入密码");
//                                     oText4.focus();
//                                     return;
//                                 }
//                                 //2. 发送ajax请求
                                
//                                 var userid = $(this).parent().parent().find("td:eq(0)").html();
//                                 var oBtn = $(this);
//                                 $.post("/wbzluntan/moduser", "userid="+userid+"&username="+username+"&email"+email+"&userpwd="+userpwd, function(data){
//                                     if(data == "true"){
//                                         //修改成功
             
//                                         //2. 将密码还原成不可编辑状态
//                                         var oTd4 = oBtn.parent().parent().find("td:eq(3)");
//                                         var oText4 = oTd4.find("input");    
//                                         var userpwd = oText4.val();
//                                         oTd4.empty();
//                                         oTd4.html(userpwd);
//                                         //3.把当前按钮变成修改按钮
//                                         oBtn.val("修改");
//                                         //4. 提示信息
//                                         alert("修改成功");
//                                     }
//                                     else{
//                                         //修改失败
//                                         alert("用户名已存在请重试");
//                                     }
//                                 },"text");
//                             }

//                         }).appendTo(oTd);
//                         //修改按钮添加结束
                    
//                     //将tr放入表格中
//                     oTr.appendTo("#resulttable");
//                 }
//                 $("#resultdiv").show();
//                 $("#pagectrl").show();
//                 //上一页和下一页的逻辑控制
//                 if(data.isFirstPage){
//                     $("#prePage").hide();
//                     $("#prePageSpan").show();
//                 }
//                 else{
//                     $("#prePage").show();
//                     $("#prePageSpan").hide();
//                 }
//                 if(data.isLastPage){
//                     $("#nextPage").hide();
//                     $("#nextPageSpan"),show();
//                 }
//                 else{
//                     $("#nextPage").show();
//                     $("#nextPageSpan").hide();
//                 }
//             }
//             else{
//                 $("#resultdiv").hide();
//                 $("#pagectrl").hide();
//                 alert("没有查到数据，")
//             }
//         }, "json");
//     });
// })
$(function(){

    
    $("#regBtn").click(function(){
        var username = $("#username").val();
        if(!username){
            alert("请输入已有用户名");
            $("#username").focus();
            return;
        }

        var email = $("#email").val();
        if(!email){
            alert("请输入您绑定的邮箱");
            $("#email").focus();
            return;
        }

        var userpwd = $("#userpwd").val();
        if(!userpwd){
            alert("请输入修改密码");
            $("#userpwd").focus();
            return;
        }

        // var conpwd = $("#conpwd").val();
        // if(!conpwd){
        //     alert("请确认密码！！！");
        //     $("#conpwd").focus();
        //     return;
        // }

        // if(userpwd!=conpwd){
        //     alert("两次密码不一致。");
        //     $("#conpwd").focus();
        //     return;
        // }

        $.post("/wbzluntan/forg", $("[name]").serialize(), function (data) {
            if(data == "true"){
                alert("忘记密码修改完成，请登录。")
                window.location.href = "/wbzluntan/login.html"; 
            }
            else{
                alert("修改失败，请重试");
                $("#username").focus();
                $("#username").select();
            }
        },"text");
    });
});
