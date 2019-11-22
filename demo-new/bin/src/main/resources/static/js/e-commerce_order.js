$(function() {
	var user = sessionStorage.getItem("cusphone");
	var txt = "";
	txt += `<span >${user}</span>`;
	$("#user").append(txt);
	var id = sessionStorage.getItem("cusid");
	var txt2 =`

        <p>${user}</p>`;
	$(".userinfo").append(txt2);
	sessionStorage.removeItem("starttime");
	sessionStorage.removeItem("endtime");
})

 
$(function() {
	var id = sessionStorage.getItem("cusid");
	$.ajax({
				type : "post",
				url : "/customer/order",
				dataType : "json",
				data : {
					id : id,
				},
				success : function(data) {
					console.log("成功", data);
					orderlist(data);
				},
				error : function(data) {
					console.log("失败", data);
				}
			})

})
function orderlist(data){
	var txt = "";
	var list = data.orderid;
	$(".orderinformation").append().html("");
	for (var i = 0; i < list.length; i++) {
		var line = data[list[i]];
		txt += `
		<div class="order-num">
			订单号: ${list[i]}下单时间： ${datetime(line[0].ordeStarttime)}
		</div>
			`
		for (var j = 0; j < line.length; j++) {
			txt +=`
			<ul class="order-details"> 
				<li> 
					<img src="/customer/ordimgshow?pcname=${line[j].ordeProduct}" alt="图片" />
					<ul> 
						<li>${line[j].ordeProvidername}</li> 
						<li>${line[j].ordeProduct}</li>
					</ul> 
					<p>¥${line[j].ordePrice}</p> 
					<p>${line[j].ordeNum}</p>
				</li> 
				<li class="font-aqua">¥${line[j].ordePrice*line[j].ordeNum}</li>`
			if (line[j].ordeState == 0) {
				txt+=`
					<li class="font-aqua">等待买家付款</li> 
					<li> 
						<p onclick="pay(${list[i]})">付款</p>
						<span onclick = "deleteorderline('${list[i]}','${line[j].ordeProduct}')">删除订单</span> 
					</li>
				</ul>
				
				<hr color="#ededed" size="1">`
			} else {
				txt+=`
					<li class="font-aqua">已付款</li> 
					<li>交易完成</li> 
				</ul>
				<hr color="#ededed" size="1">`

			}
		}
	}

	$(".orderinformation").append(txt);
}
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

function datetime(time) {
	var date = new Date(time);
	return date.getFullYear() + "-" + (date.getMonth()+1) + "-"
			+ date.getDate() + " " + date.getHours() + ":" + date.getMinutes()
			+ ":" + date.getSeconds();
}
function deleteorderline(orderid,pcname)
{
	var orderid= orderid;
	var pcname = pcname;
	$.ajax({
		type : "post",
		url : "/customer/deletepc",
		dataType : "json",
		data : {
			orderid : orderid,
			pcname:pcname,
		},
		success : function(data) {
			console.log("成功", data);
			location.href = "/toPage?url=e-commerce_order.html";
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
}
function pay(id)
{
	sessionStorage.setItem("topay",id);
	location.href = "/toPage?url=e-commerce_settlement.html";
}
function defaultImg(img){
	img.src="/images/user-lg.png";
}

$(function(){
var id = sessionStorage.getItem("cusid");
$(".imgshow").attr("src","/customer/imgshow?id="+id);
})

$(".findlikeid").on("click",function()
{
	var orid = $(".likeid").val();
	var cuid = sessionStorage.getItem("cusid");
	var starttime 	= sessionStorage.getItem("starttime");
	var endtime 	= sessionStorage.getItem("endtime");
	console.log(orid,cuid);
	$.ajax({
		type : "post",
		url : "/customer/ord_like",
		dataType : "json",
		data : {
			orid : orid,
			cuid:cuid,
			starttime:starttime,
			endtime:endtime,
		},
		success : function(data) {
			console.log("成功", data);
			if(data.state==1){
				orderlist(data);
			}else{
			
			alert(data.status);
			}
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
	
	
})
$(function()
{
	$("input[name='starttime']").change(function() {
		var  dateTime  = new Date($(".starttime").val());
		dateTime = new Date(dateTime.valueOf() - 480* 60 * 1000);
		console.log(dateTime);
		sessionStorage.setItem("starttime",dateTime);
		findbytime();
	});
	$("input[name='endtime']").change(function() {
		var  dateTime  = new Date($(".endtime").val());
		dateTime = new Date(dateTime.valueOf() - 480* 60 * 1000);
		console.log(dateTime);
		sessionStorage.setItem("endtime",dateTime);
	 findbytime();
	});
})
function findbytime()
{
	var cuid = sessionStorage.getItem("cusid");
	var starttime 	= sessionStorage.getItem("starttime");
	var endtime 	= sessionStorage.getItem("endtime");
	$.ajax({
		type : "post",
		url : "/customer/ord_time",
		dataType : "json",
		data : {
			starttime : starttime,
			endtime:endtime,	
			cuid:cuid,
			},
		success : function(data) {
			console.log("成功", data);
			if(data.state==1){
				orderlist(data);
			}else{
			
			alert(data.status);
			}
			
		},
		error : function(data) {
			console.log("失败", data);
			
		}
	})
}
