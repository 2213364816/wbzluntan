$(function(){
    $.post("/wbzluntan/getcuruser", null, function(data){
        if(data){
            $("#curname").html(data.username);
            $("#curid").val(data.userid);
        }
    },"json");
})
$(document).ready(function() {
    $("#myinfbtn").click(function() {
        window.location.href = "/wbzluntan/myinf.html";
    })
});
$(document).ready(function() {
    $("#exitbtn").click(function() {
        window.location.href = "/wbzluntan/mainf.html";
    })
});
//登录时间
$(function() {
    $.post("/wbzluntan/getcuruser", null, function(data) {

        if (data) {

            $("#curname").html(data.username);
            $("#curid").val(data.userid);

        }
    }, "json");

    $("#myinfbtn").click(function() {
        //获取时间
        var mydate = new Date();
        var str = "" + mydate.getFullYear() + "-";
        str += (mydate.getMonth() + 1) + "-";
        str += mydate.getDate()+" ";
        str += mydate.getHours()+":";
        str += mydate.getMinutes()+":";
        str += mydate.getSeconds();
        var username = $("#curid").val();
        $.post("/wbzluntan/addtm", "username=" + username + "&logintm=" + str),
            function(data) {

            }, "json"


    })

})