$(function(){
    $.post("/wbzluntan/getcuruser", null, function(data){
        if(data){
            $("#curname").html(data.username);
            $("#curid").val(data.userid);
        }
    },"json");
})