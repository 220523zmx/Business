$(function() {
	var pvname = sessionStorage.getItem("pvname");
	var serid = sessionStorage.getItem("serid");
	console.log(serid);
	var pv = "";
	$(".pvname").html();
	pv += `${pvname}`;
	$(".pvname").append(pv);
	var txt1 = `<input  name="serid" type="hidden" value = "${serid}">`;
	$(".imgto").append(txt1);

})
$(function() {
	var id = sessionStorage.getItem("serid");
	$(".imgshow").attr("src", "/service/headimgshow?id=" + id);
})
$(".user-arrow-down").on("click", function() {
	if ($(".dropdown").is(":hidden")) {
		$(".dropdown").show();
	} else {
		$(".dropdown").hide();
	}
})
$(".order1").on("click", function() {
	$(".main-content").show();
	$("table").show();
	$(".main-pagination").show();
	$(".main-sercive").hide();
	$(".order1").addClass("border-red");
	$(".order2").removeClass("border-red");
	$(".main-top li").eq(3).text("正常用户");
})
$(".order2").on("click", function() {
	$(".main-content").hide();
	$("table").hide();
	$(".main-pagination").hide();
	$(".main-sercive").show();
	$(".order2").addClass("border-red");
	$(".order1").removeClass("border-red");
	$(".main-top li").eq(3).text("停用用户");
})
$(".order3").on("click", function() {
	$(".main-top li").eq(3).text("未通过用户");
})
/*$(".change-info").on("click", function(event) {
	
})*/
$(".save").on("click", function(event) {
	$(".masking").hide();
	console.log("保存");
})
$(".cancel").on("click", function(event) {
	$(".masking").hide();
	console.log("取消");
})
function defaultImg(img) {
	img.src = "/images/default_user.png";
}
$(function() {
	// 初始化省市区
	initAddress();
	var city="";
	var area="";
	city += `<option value = "-1">-- 请选择市 --</option>`;
	area += `<option value = "-1">-- 请选择县(区) --</option>`;
	// 更改省份后的操作
	$("select[name='province']").change(function() {
		$(".city").html("");
		$(".area").html("");
		$(".area").append(area);
		var provCode = $("select[name='province']").val();
		console.log(provCode);
		getCity(provCode);
	});
	// 更改城市后的操作
	$("select[name='city']").change(function() {
		$(".area").html("");
		var cityCode = $("select[name='city']").val();
		console.log(cityCode);
		getArea(cityCode);
	});

	$("select[name='area']").change(function() {
		var areaCode = $("select[name='area']").val();
		console.log(areaCode);

	});

});

function initAddress() {
	$
			.ajax({
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
					$(".province").append(txt);
				},
				error : function(data) {
					console.log("失败");
				}
			})
}

// 获取对应城市列表（里面包括获取第一个城市的区县列表）
function getCity(provCode) {
	var provCode = provCode;

	$
			.ajax({
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
					txt += `<option value = ${a}>-- 请选择市 --</option>`;
					for (var i = 0; i < citysList.length; i++) {
						txt += `<option value = ${citysList[i].code}>${citysList[i].name}</option>`;
						console.log(citysList[i].code);
					}
					$(".city").append(txt);
				},
				error : function(data) {
					console.log("失败");
				}
			})
}
$(".save").on("click", function() {

	var pvphone = $(".pvphone").val();
	var pvwechart = $(".pvwechart").val();
	var pvqq = $(".pvqq").val();
	var pvemail = $(".pvemail").val();
	var pvproname = $(".pvproname").val();
	var area = $(".area").val();
	var pvid = sessionStorage.getItem("serid");

	console.log(pvproname, pvphone, pvwechart, pvqq, pvemail,pvid);
	$.ajax({
		type : "post",
		url : "/service/information",
		dataType : "json",
		data : {
			pvproname : pvproname,
			pvphone : pvphone,
			pvwechart : pvwechart,
			pvqq : pvqq,
			pvemail : pvemail,
			pvid : pvid,
			area : area,

		},
		success : function(data) {
			console.log("成功", data);
			if (data.code == 1) {
				alert(data.status);
			} else {
				alert(data.status);
			}

		},
		error : function(data) {
			console.log("失败", data);
		}
	})

})

function getArea(citysCode) {

	var citysCode = citysCode;
	$
			.ajax({
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
					txt += `<option value = ${a}>-- 请选择县(区) --</option>`;
					for (var i = 0; i < areaList.length; i++) {
						txt += `<option value = ${areaList[i].code}>${areaList[i].name}</option>`;
					}
					$(".area").append(txt);
				},
				error : function(data) {
					console.log("失败");
				}
			})
}
$(function(){
	inforshow();
})
function inforshow()
{
	var pvid = sessionStorage.getItem("serid");
	$
	.ajax({
		type : "get",
		url : "/service/lineshow",
		dataType : "json",
		data : {
			pvid:pvid,
		},
		success : function(data) {
			console.log("成功", data);
			console.log(data.line);
			lineshow(data);
			
		},
		error : function(data) {
			console.log("失败",data);
		}
	})

}
function lineshow(data)
{
	var line = data.line;
	var txt ="";
	$(".store-info").html("");
	txt+=`
	<li>
		<span>服务商名称</span> 
		<span>${line.servProviderName}</span>
	</li>
	<li>
		<span>地区</span> 
		<span>${line.servProviderRegion}</span>
	</li>
	<li>
		<span>手机号</span> 
		<span>${line.servProviderPhone}</span>
	</li>
	<li>
		<span>微信</span> 
		<span>${line.servProviderWeichart}</span>
	</li>
	<li>
		<span>QQ</span> 
		<span>${line.servProviderQq}</span>
	</li>
	<li>
		<span>邮箱</span> 
		<span>${line.servProviderEmail}</span>
	</li>
	<li>
		<button class="change-info" onclick = "toupdate()">修改</button>
	</li>
	`
	$(".store-info").append(txt);
	
	
}
function toupdate()
{
	$(".masking").show();
}