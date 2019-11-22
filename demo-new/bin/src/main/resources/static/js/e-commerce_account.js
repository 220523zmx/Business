$(function() {
	var user = sessionStorage.getItem("cusphone");
	
	var txt = "";
	txt += `<span >${user}</span>`;
	$("#user").append(txt);
	var txt1 =`<input  name="id" type="hidden" value = "${user}">`;
	$(".imgto").append(txt1);
	var id = sessionStorage.getItem("cusid");
	var txt2 =`

        <p>${user}</p>`;
	$(".userinfo").append(txt2);
	
	
})

$(".search-product").on("click", function() {
	$(".search-product").addClass("font-aqua");
	$(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function() {
	$(".search-service").addClass("font-aqua");
	$(".search-product").removeClass("font-aqua");
})

$(".banner a").on("click", function(event) {
	$(".banner a").removeClass("border-b");
	$(event.target).addClass("border-b");
})

$(".user-action a").on("click", function(event) {
	$(".user-action a").removeClass("bg-gray");
	$(event.target).addClass("bg-gray");
})
$(".content-nav li").on("click", function(event) {
	$(".content-nav li").removeClass("nav-active");
	$(event.target).addClass("nav-active");
})

$(".content-banner li").eq(0).on("click", function(event) {
	$(".content-banner li").removeClass("border-b1");
	$(event.target).addClass("border-b1");
	$(".change-password").hide();
	$(".account-info").show();
})
$(".content-banner li").eq(1).on("click", function(event) {
	$(".content-banner li").removeClass("border-b1");
	$(event.target).addClass("border-b1");
	$(".change-password").show();
	$(".account-info").hide();
})

$(".cust_name").change(function() {

	var str = $(".cust_name").val();
	var reg = /^[\u4E00-\u9FA5]+$/;
	if (!reg.test(str)) {
		alert("姓名中含有非法字符");

	}

})
$(".password").on("click", function() {
	var oldpassword = $(".cust_password_old").val();
	var newpassword = $(".cust_password_new").val();
	var againpassword = $(".cust_password_again").val();
	var phone = sessionStorage.getItem("cusphone");
	console.log(oldpassword, newpassword, againpassword, phone);
	$.ajax({
		type : "post",
		url : "/customer/password",
		data : {
			oldpassword : oldpassword,
			newpassword : newpassword,
			againpassword : againpassword,
			phone : phone,
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

})
$(".information").on("click", function() {
	var sex = $('input[name="sex"]:checked').val();
	var name = $(".cust_name").val();
	var email = $(".cust_email").val();
	var phone = sessionStorage.getItem("cusphone");
	console.log(sex, name, email, phone);
	$.ajax({
		type : "post",
		url : "/customer/information",
		data : {
			sex : sex,
			name : name,
			email : email,
			phone : phone,
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
})
function defaultImg(img){
		img.src="/images/user-lg.png";
	}

$(function(){
	var id = sessionStorage.getItem("cusid");
	
$(".imgshow").attr("src","/customer/imgshow?id="+id);
})