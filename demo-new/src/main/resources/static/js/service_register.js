
$(".vimg").on("click", function() {
	var timestamp = (new Date()).valueOf();
	$(this).attr("src", "code?timestamp=" + timestamp);
});
$(function() {
	var timestamp = (new Date()).valueOf();
	$(this).attr("src", "code?timestamp=" + timestamp);
});

function ServiceRegister() {
	var phone = $(".serv_phone").val();
	var password = $(".serv_password").val();
	var code = $(".code").val();
	var provice = $("#provice").val();
	var city = $("#city").val();
	var area = $("#area").val();
	console.log(phone, password, code);
	$.ajax({
		type : "post",
		url : "/service/register",
		data : {
			phone 		: phone,
			password 	: password,
			code 		: code,
			provice		:provice,
			city		:city,
			area		:area,
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
}

$(function() {
	// 初始化省市区
	initAddress();
	// 更改省份后的操作
	$("select[name='province']").change(function() {
		$("#city").html("");
		$("#area").html("");
		var txt = "";
		txt += `<option value = "-1">-- 请选择县(区) --</option>`;
		$("#area").append(txt);
		var provCode = $("select[name='province']").val();
		console.log(provCode);
		getCity(provCode);
	});
	  // 更改城市后的操作 
	$("select[name='city']").change(function() { 
		$("#area").html("");
		var cityCode = $("select[name='city']").val(); 
		console.log(cityCode);
		getArea(cityCode); });
	
	$("select[name='area']").change(function() {
		var areaCode = $("select[name='area']").val();
		console.log(areaCode);
		
	});
	 
});

function initAddress() {
	$.ajax({
		type : "post",
		url : "/Address/init",
		dataType : "json",
		success : function(data) {
			console.log("成功", data);
			var provinceList = data.provinceList;
			var txt = "";
			
			for (var i = 0; i < provinceList.length; i++) {
				txt += `<option value = ${provinceList[i].code}>${provinceList[i].name}</option>`;
			}
			$("#province").append(txt);
		},
		error : function(data) {
			console.log("失败");
		}
})
}

// 获取对应城市列表（里面包括获取第一个城市的区县列表）
function getCity(provCode) {
	var provCode = provCode;
	$.ajax({
		type : "post",
		url : "/Address/city",
		dataType : "json",
		data : {
			provCode : provCode,
		},
		success : function(data) {
			console.log("成功", data);
			var citysList = data.citysList;
			var txt = "";
			var a = -1;
			txt+=`<option value = ${a}>-- 请选择市 --</option>`;
			for (var i = 0; i < citysList.length; i++) {
			txt += `<option value = ${citysList[i].code}>${citysList[i].name}</option>`;
			}
			$("#city").append(txt);
		},
		error : function(data) {
			console.log("失败");
		}
	})
}

function getArea(citysCode) {

	var citysCode = citysCode;
	$.ajax({
		type : "post",
		url : "/Address/area",
		dataType : "json",
		data : {
			citysCode : citysCode,
		},
		success : function(data) {
			console.log("成功", data);
			var areaList = data.areaList;
			var a = -1;
			var txt = "";
			txt+=`<option value = ${a}>-- 请选择县(区) --</option>`;
			for (var i = 0; i < areaList.length; i++) {
				txt += `<option value = ${areaList[i].code}>${areaList[i].name}</option>`;
			}
			$("#area").append(txt);
		},
		error : function(data) {
			console.log("失败");
		}
	})
}