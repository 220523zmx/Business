
$(".vimg").on("click", function() {
	var timestamp = (new Date()).valueOf();
	$(this).attr("src", "code?timestamp=" + timestamp);
});
$(function() {
	var timestamp = (new Date()).valueOf();
	$(this).attr("src", "code?timestamp=" + timestamp);
});

$(".login-btn").on("click",function(){
	var phone = $(".serv_phone").val();
	var newpassword = $(".serv_password_new").val();
	var againpassword = $(".serv_password_again").val();
	var code = $(".code").val();
	console.log(phone, newpassword, againpassword,code);
	$.ajax({
		type : "post",
		url : "/service/find",
		data : {
			phone 			: phone,
			newpassword 	: newpassword,
			againpassword 	: againpassword,
			code			:code,
			
		},
		dataType : "json",
		success : function(data) {
			alert(data.state);
			console.log("成功", data);
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
});