
$(".vimg").on("click", function() {
	var timestamp = (new Date()).valueOf();
	$(this).attr("src", "code?timestamp=" + timestamp);
});
$(function() {
	var timestamp = (new Date()).valueOf();
	$(this).attr("src", "code?timestamp=" + timestamp);
});

$(".login-btn").on("click",function(){
	var phone = $(".cust_phone").val();
	var newpassword = $(".cust_password_new").val();
	var againpassword = $(".cust_password_again").val();
	var code = $(".code").val();
	console.log(phone, newpassword, againpassword,code);
	$.ajax({
		type : "post",
		url : "/customer/find",
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