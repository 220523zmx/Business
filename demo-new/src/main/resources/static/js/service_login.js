/*$(".login-btn").on("click", function(){
    location.href="/toPage?url=service_product.html"
})*/
$(function() {
	var timestamp = (new Date()).valueOf();
	$(this).attr("src", "code?timestamp=" + timestamp);
});
$(".vimg").on("click", function() {
	var timestamp = (new Date()).valueOf();
	$(this).attr("src", "code?timestamp=" + timestamp);
});

$(".login-btn").on("click", function(){
	var phone = $(".serv_phone").val();
	var password = $(".serv_password").val();
	var code = $(".code").val();
	console.log(phone, password, code);
	$.ajax({
		type : "post",
		url : "/service/login",
		data : {
			phone 		: phone,
			password 	: password,
			code 		: code,
		},
		dataType : "json",
		success : function(data) {
			alert(data.state);
			if(data.status==1)
			{
				console.log(data.id,data.phone);
				sessionStorage.setItem("serid",data.id);
				sessionStorage.setItem("serphone",data.phone);
				sessionStorage.setItem("pvname",data.pvname);
				location.href="/toPage?url=service_product.html";
			}
			console.log("成功", data);
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
    
})
