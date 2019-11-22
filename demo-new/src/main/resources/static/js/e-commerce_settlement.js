/*
$(".payment li").eq(1).on("click", function() {
	
})*/

$(function() {
	var cusid = sessionStorage.getItem("cusid");
	var orid = sessionStorage.getItem("topay");
	$.ajax({
			type : "post",
			url : "/customer/paylist",
			dataType : "json",
			data : {
				cusid : cusid,
				orid:orid,
			},
			success : function(data) {
				console.log("成功", data);
				var txt = "";
				var aprice= 0;
				var list = data.paylist;
				$(".orderpaylist").append().html("");
				$(".payprice").append().html("");
					 
				if(list.length!=0){txt = `<ul class="merchandise">
			            <li>
						 订单编号：<span class="font-aqua">${list[0].ordeId}</span>
			            </li>
			            <li>创建时间： ${datetime(list[0].ordeStarttime)}</li></ul>`
			            
			            
						 for(var i = 0;i<list.length;i++)
						{txt+=`<ul class="merchandise">
						<li>${list[i].ordeProduct}*${list[i].ordeNum}</li>
			            <li>该商品总额：¥${list[i].ordePrice*list[i].ordeNum}</li></ul>
			
			            `
						aprice+=list[i].ordePrice*list[i].ordeNum;}
			$(".orderpaylist").append(txt);
				}
			else{
				txt+=`暂无订单`
				$(".orderpaylist").append(txt);
			}
			var txt1= ""; 
			txt1+=`
			 <ul class="payment">
				<li>金额总计：<span>¥${aprice}</span></li>
	            <li onclick="pay()">支付</li>
	        </ul>`
	           
	        $(".payprice").append(txt1);
			
			},
			error : function(data) {
				console.log("失败", data);
			}
			
		})
		
	})


function pay()
{
	var payway= $("input[type='radio'][name='pay']:checked").val();
	var orid = sessionStorage.getItem("topay");
	var cusid = sessionStorage.getItem("cusid");
	if(payway!=null)
	{	
		$.ajax({
		type : "post",
		url : "/customer/payway",
		dataType : "json",
		data : {
			payway : payway,
			orid:orid,
			cusid:cusid,
		},
		success : function(data) {
			console.log("成功", data);
			
			sessionStorage.removeItem("topay");
			location.href = "/toPage?url=e-commerce_order.html";
		},
		error : function(data) {
			console.log("失败", data);
		}
		
	})
	}else{
		alert("未选择支付方式");
	}

}

function datetime(time) {
	var date = new Date(time);
	return date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
			+ date.getDate() + " " + date.getHours() + ":" + date.getMinutes()
			+ ":" + date.getSeconds();
}