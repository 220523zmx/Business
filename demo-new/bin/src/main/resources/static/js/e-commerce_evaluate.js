$(function()
		{
			var user = sessionStorage.getItem("cusphone");
			var txt = "";
			txt += `<span >${user}</span>`;
			$("#user").append(txt);
			var id = sessionStorage.getItem("cusid");
			var txt2 =`

		        <p>${user}</p>`;
			$(".userinfo").append(txt2);
	
		})


$(".search-product").on("click", function(){
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function(){
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})

$(".banner a").on("click", function(event){
    $(".banner a").removeClass("border-b");
    $(event.target).addClass("border-b");
})

$(".user-action a").on("click", function(event){
    $(".user-action a").removeClass("bg-gray");
    $(event.target).addClass("bg-gray");
})
$(".content-nav li").on("click", function(event){
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})
$(".save").on("click", function(event){
    $(".masking").hide();
    var id = sessionStorage.getItem("cusid");
    var pcid = sessionStorage.getItem("orderid");
	var name = sessionStorage.getItem("pcname");
	var eva = $("#eva").val();
	console.log(eva);
	$.ajax({
		type : "post",
		url : "/customer/saveevaluate",
		data:{
			id:id,
			pcid:pcid,
			name:name,
			eva:eva,
		},
		dataType : "json",
		success : function(data) {
			console.log("成功", data);
			sessionStorage.setItem("state","1");
			alert(data.state);
			sessionStorage.removeItem("orderid");
			sessionStorage.removeItem("pcname");
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
})
$(".cancel").on("click", function(event){
    $(".masking").hide();
    console.log("取消");
    sessionStorage.removeItem("orderid");
	sessionStorage.removeItem("pcname");
})


$(function(){
	notevaluate();
	var a = sessionStorage.getItem("state");
	
})

function hasevaluate(){
	var id = sessionStorage.getItem("cusid");
	$.ajax({
		type : "post",
		url : "/customer/hasevaluate",
		data:{id:id},
		dataType : "json",
		success : function(data) {
			console.log("成功", data);
			orderevalist(data);
			// location.href = "/toPage?url=e-commerce_order.html";
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
	

}
function notevaluate(){
	var id = sessionStorage.getItem("cusid");
	$.ajax({
		type : "post",
		url : "/customer/notevaluate",
		data:{id:id,},
		dataType : "json",
		success : function(data) {
			console.log("成功", data);
			orderevalist(data);
			// location.href = "/toPage?url=e-commerce_order.html";
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
}

function orderevalist(data)
{
	var list = data.list;
	var txt = "";
	$(".list").append().html("");
	
	if(list!=null){
		for(var i = 0;i<list.length;i++)
		{
		txt+=`
		<div class = "article">
		<img src="/customer/evaimgshow?pcname=${list[i].ordeProduct}" alt="图片" />
        <ul class="article-info">
            <li>${list[i].ordeProduct}</li>
            <li>${data[list[i].ordeProduct]}</li>
            <li>${list[i].ordeProvidername}</li>
        </ul>
        <p>购买时间：${datetime(list[i].ordeStarttime)}</p>`
        if(list[i].ordeEvaluationstatus==0){
        txt+=	`<p class="evaluate_btn" onclick = "evaluat('${list[i].ordeProduct}','${list[i].ordeId}')">去评价</p>`
        }else
        {
        	txt+=`<p> ${list[i].ordeEvaluation}</p>`
        }
       txt+=`</div><hr color="#ccc" size="1">`
		
		}
	$(".list").append(txt);}
	else{
		alert(data.state);
	}
	
	
	/*
	 * <img src="" alt="图片" /> <ul class="article-info"> <li>代理记账（一年）</li>
	 * <li>适用于没有经营性业务的企业，代理记账服务</li> <li>云智汇咨询服务有限公司</li> </ul> <p>购买时间：2017-02-23
	 * 23:23:34</p> <p class="evaluate_btn">去评价</p>
	 */
}
function datetime(time) {
	var date = new Date(time);
	return date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
			+ date.getDate() + " " + date.getHours() + ":" + date.getMinutes()
			+ ":" + date.getSeconds();
}
function evaluat(pcname,orid)
{
	$(".masking").show();
	sessionStorage.setItem("orderid",orid);
	sessionStorage.setItem("pcname",pcname);
}
function defaultImg(img){
	img.src="/images/user-lg.png";
}

$(function(){
var id = sessionStorage.getItem("cusid");

$(".imgshow").attr("src","/customer/imgshow?id="+id);
})