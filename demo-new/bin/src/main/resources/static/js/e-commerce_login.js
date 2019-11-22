$(".vimg").on("click", function() {
	var timestamp = (new Date()).valueOf();
	$(this).attr("src", "code?timestamp=" + timestamp);
});
$(function() {
	var timestamp = (new Date()).valueOf();
	$(this).attr("src", "code?timestamp=" + timestamp);
});


$(".login-btn").on("click", function() {
	var phone = $(".cust_phone").val();
	var password = $(".cust_password").val();
	var code = $(".code").val();
	console.log(phone, password, code);
	$.ajax({
		type : "post",
		url : "/customer/login",
		data : {
			phone : phone,
			password : password,
			code : code,
		},
		dataType : "json",
		success : function(data) {
			alert(data.state);
			if (data.status == 1) {

				console.log(data.id, data.phone);
				sessionStorage.setItem("cusphone", data.phone);
				sessionStorage.setItem("cusid", data.id);
				location.href = "/toPage?url=e-commerce_product.html";

			}
			console.log("成功", data);
		},
		error : function(data) {
			console.log("失败", data);
		}
	})

})
