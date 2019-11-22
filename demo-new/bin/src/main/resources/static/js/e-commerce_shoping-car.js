$(function() {
	var user = sessionStorage.getItem("cusphone");
	var txt = "";
	txt += `<span >${user}</span>`;
	$("#user").append(txt);

})
$(cartline())

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

$(".content-nav li").on("click", function(event) {
	$(".content-nav a").removeClass("nav-active");
	$(event.target).addClass("nav-active");
})

function delete_pc(id)
{
	var pcid = id;
	var cuid = sessionStorage.getItem("cusid");
	$.ajax({
		type : "post",
		url : "/customer/cart_delete",
		dataType : "json",
		data : {
			pcid : pcid,
			cuid:cuid,
		},
		success : function(data) {
			console.log("成功", data);
			if(data.state == 1){
				alert("删除成功 ");
				cartlist();
			}else{
				alert("删除失败");
			}
		},
		error 	: function(data) {
			console.log("失败", data);
		},
		
	})
}

function sub(id){
	console.log(id);
	var e = window.event;
	var pcid = id;
	var cuid = sessionStorage.getItem("cusid");
	var num = null;
	console.log($(e.target).next().val()-1);
	if($(e.target).next().val()-1 <= 1)
	{
		num = 1
		$(e.target).next().val("1");
		alert("购买商品数量至少为1");
		return;
	}
	else{
		num = $(e.target).next().val()-1;
		
	}
	console.log(num);
	
	$.ajax({
		type : "post",
		url : "/customer/cart_sub",
		dataType : "json",
		data : {
			pcid : pcid,
			cuid : cuid,
			num : num,
		},
		success : function(data) {
			console.log("成功", data);
			if(data.state == 1){console.log($(e.target).next().val(num));
			cartlist();
			}else{
				cartline();
			}
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
	
	
}
function add(id){
	console.log(id);
	var e = window.event;
	var pcid = id;
	var cuid = sessionStorage.getItem("cusid");
	var num  = +$(e.target).prev().val()+1;
	console.log(num);
	$.ajax({
		type : "post",
		url : "/customer/cart_add",
		dataType : "json",
		data : {
			pcid : pcid,
			cuid : cuid,
			num : num,
		},
		success : function(data) {
			console.log("成功", data);
			if(data.state == 1){console.log($(e.target).prev().val(+$(e.target).prev().val()+1));
			cartline();
			}else{
				alert("更改失败");
			}
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
	
}


function change(id)
{	var e = window.event;
	console.log(id);
	var pcid = id;
	var cuid = sessionStorage.getItem("cusid");
	var num  = $(e.target).val();
	
	$.ajax({
		type : "post",
		url : "/customer/cart_change",
		dataType : "json",
		data : {
			pcid : pcid,
			cuid : cuid,
			num : num,
		},
		success : function(data) {
			console.log("成功", data);
			if(data.state == 1){
				cartline();
			}else{
				alert("更改失败");
			}
			
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
	console.log($(e.target).val());
}

function submit(){
	var id = sessionStorage.getItem("cusid");
	$.ajax({
		type : "post",
		url : "/customer/carttoorder",
		dataType : "json",
		data : {
			id : id,
		},
		success : function(data) {
			console.log("成功", data);
			if(data.state == 1){
				sessionStorage.setItem("topay",data.orderid);
				location.href="/toPage?url=e-commerce_settlement.html"}
			else {alert(data.waring);}
		},
		error : function(data) {
			console.log("失败", data);
		}
		
	})
}

function cartline(){
	var id = sessionStorage.getItem("cusid");
	$.ajax({
		type : "post",
		url : "/customer/cart",
		dataType : "json",
		data : {
			id : id,
		},
		success : function(data) {
			console.log("成功", data);var list = data.pvnamelist;
	var txt="";
	var allprice = 0.00;
	var count = 0;
	$(".cart_list").append().html("");
	$(".price").append().html("");
	$(".product_num").append().html("");
	for(var i = 0;i<list.length;i++)
	{
		
		txt+=`<p class="shop">店铺：${list[i]}</p> `
		var pv_pc = data[list[i]];
		for(var j = 0;j<pv_pc.length;j++)
			{
		var pc_line = data[pv_pc[j]];
		txt+=`
			<ul class="merchandise" value = "${pc_line[0].cartProductid}">
				<li> 
					<img src="" alt="图片"> 
				</li> 
				<li class = "pcid" >${pv_pc[j]}</li> 
				<li>¥${pc_line[0].cartPrice}</li>
				<li>
					<span onclick="sub('${pc_line[0].cartProductid}')">-</span> 
					<input value="${pc_line[0].cartNumber}"  onblur = "change('${pc_line[0].cartProductid}')"/> 
					<span onclick="add('${pc_line[0].cartProductid}')">+</span> 
				</li>
				<li> ¥${pc_line[0].cartNumber*pc_line[0].cartPrice} </li> 
				<li> 
					<span onclick="delete_pc('${pc_line[0].cartProductid}')">删除</span> 
				</li> 
			</ul>
			`
			allprice += pc_line[0].cartNumber*pc_line[0].cartPrice;
		count+=1;
		}
	}
	$(".cart_list").append(txt);
	var txt1 = "";
	txt1+=`
	<li>金额合计<span>¥${allprice}</span></li>
	<li>
		<a href="/toPage?url=e-commerce_product.html">继续购物</a> 
		<button onclick = "submit()">去结算</button>
	</li>
		`
	$(".price").append(txt1);
	var txt2 = "";
	txt2+=`全部商品（ ${count}）`
	$(".product_num").append(txt2);
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
}

