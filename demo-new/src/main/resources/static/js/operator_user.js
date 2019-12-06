$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(".business-order").on("click", function(){
//    $(".main-content").show();
//    $("table").show();
//    $(".main-pagination").show();
//    $(".main-sercive").hide();
	$(".business-order").addClass("border-red");
    $(".service-order").removeClass("border-red");
    $(".main-top li").eq(3).text("注册用户");
	sessionStorage.setItem("from","a");
	var likename = sessionStorage.getItem("likename");
	var np = sessionStorage.getItem("nowpage");
	countorder();
	pageshow();
	ajaxget(likename,np);
    
    
})
$(".service-order").on("click", function(){
//    $(".main-content").hide();
//    $("table").hide();
//    $(".main-pagination").hide();
//    $(".main-sercive").show();
    $(".service-order").addClass("border-red");
    $(".business-order").removeClass("border-red");
    $(".main-top li").eq(3).text("服务商用户");
    sessionStorage.setItem("from","b");
    var likename = sessionStorage.getItem("likename");
	var np = sessionStorage.getItem("nowpage");
	countorder();
	pageshow();
	ajaxget(likename,np);
})

$(function(){
	var opename = sessionStorage.getItem("opename");
	var ope ="";
	$(".opename").html();
	ope+=`${opename}`;
	$(".opename").append(ope);
} )
$(function(){
var id = sessionStorage.getItem("opeid");
$(".imgshow").attr("src","./operator/headimgshow?id="+id);
})
function defaultImg(img){
	img.src="./images/default_user.png";
}
$(".oper-quit").on("click", function() {
	sessionStorage.clear();
    location.href="./toPage?url=index.html"
})
    ////////////
$(function(){
	sessionStorage.setItem("namelike","");
	sessionStorage.removeItem("state");
	sessionStorage.setItem("from","a");
	sessionStorage.setItem("homepage",1);
	countorder();// 默认最后一页
	sessionStorage.setItem("nowpage",1);
	home_page();
    pageshow();
	
})
function countorder(){
	var likename = sessionStorage.getItem("namelike");
	var from = sessionStorage.getItem("from");
	$.ajax({
		type : "get",
		url : "./operator/countusers",
		dataType : "json",
		data:{
			likename:likename,
			from:from,
		},
		success : function(data) {
			console.log("成功", data);
			var c = +data.trailerpage;
			console.log("尾页","trailerpage",c+1);
			if(c==0)
				{
				 sessionStorage.setItem("state","搜索结果空");
				 sessionStorage.setItem("trailerpage",1);
				}else{sessionStorage.setItem("trailerpage",c);}
			pageshow();
			
		},
		error : function(data) {
			console.log("失败");
		}
	})
	
	
}
function pageshow()// 页块
{
	var page ="";
	var firstp= sessionStorage.getItem("homepage");
	var lastp= sessionStorage.getItem("trailerpage");
	var np = +sessionStorage.getItem("nowpage");
	$(".main-pagination").html("");
	page+=`<span class="home" onclick = "home_page()">首页</span>
                <span class="previous" onclick = "previous_page()">上一页</span>`
		for(var i = (np-1);i<=(np+1);i++){
			if(i>=firstp&&i<=lastp)
				{
				if(i==np)
					{
          		  		page+=`<span class="main-pagination-page" onclick = "topage(${i})">${i}</span>`
					}else
					{
						page+=`<span onclick = "topage(${i})">${i}</span>`
					}
				
				}
		}
    page+= `<span class="next" onclick = "next_page()">下一页</span>
                <span class="trailer" onclick = "trailer_page()">尾页</span>`
	$(".main-pagination").append(page);

}
function topage(nowpage)// 页数跳转
{
	var likename = sessionStorage.getItem("namelike");
	var np = nowpage;
	sessionStorage.setItem("nowpage",nowpage);
	pageshow();
	ajaxget(likename,np);//
	
}
function home_page()// 首页
{
	var likename = sessionStorage.getItem("namelike");
	var np = sessionStorage.getItem("homepage");//取首页
	sessionStorage.setItem("nowpage",sessionStorage.getItem("homepage"));//当页为首页
	ajaxget(likename,np);//
	pageshow();
}
function previous_page()// 上一页
{
	var likename = sessionStorage.getItem("namelike");
	var np = +sessionStorage.getItem("nowpage");//取当前页
	var firstp= sessionStorage.getItem("homepage");//取首页
	if(np==firstp){//判断首页
		alert("当前页为首页");
		return 
	}
	sessionStorage.setItem("nowpage",np-1);//当前页上一页
	pageshow();
	ajaxget(likename,np-1);//
	
}
function next_page()// 下一页
{
	var likename = sessionStorage.getItem("namelike");
	var np = +sessionStorage.getItem("nowpage");//取当前页
	var lastp= sessionStorage.getItem("trailerpage");//去取尾页
	if(np == lastp)//判断尾页
	{
		alert("当前页为尾页");
		return 
	}
	sessionStorage.setItem("nowpage",np+1);//当前页下一页
	pageshow();
	ajaxget(likename,np+1);//
	
}
function trailer_page()// 尾页
{
	var likename = sessionStorage.getItem("namelike");
	var np = sessionStorage.getItem("trailerpage");//取尾页
	sessionStorage.setItem("nowpage",sessionStorage.getItem("trailerpage"));//当前页为尾页
	pageshow();
	ajaxget(likename,np);
	
}

function  ajaxget(likename,nowpage){//分页模糊ajax.get请求
	sessionStorage.removeItem("state");
	var from = sessionStorage.getItem("from");
	console.log("模糊字段","(",likename,")","当前页","(",nowpage,")","搜索状态","(",from,")");
	$.ajax({
		type : "get",
		url : "./operator/usertopage",
		dataType : "json",
		data:{
			likename:likename,
			nowpage:nowpage,
			from:from,
		},
		success : function(data) {
			console.log("成功", data);
			orderlistshow(data);
		},
		error : function(data) {
			console.log("失败");
		}
	})
}
function orderlistshow(data)
{
	var list = data.productlist;
	if(data.code!=0)
	{
		if(data.from == 2){
			$("tbody").html("")
			  
			  var txt ="";
			  for(var i=0;i<list.length;i++){
				  txt +=`<tr>
				       <td>${list[i].servProviderId}</td>
				       <td>${list[i].servProviderName}</td>
				       <td>${list[i].servProviderPhone}</td>
				       <td>${list[i].servProviderEmail}</td>
				       <td>${list[i].servProviderStarttime}</td>
				       <td>${list[i].servProviderState}</td>
				       <td><button onclick="delUser('${list[i].servProviderId}')">删除</button></td>
				  </tr>`;
			  }
			  $("tbody").append(txt);
		}else{
			$("tbody").html("")
			  
			  var txt ="";
			  for(var i=0;i<list.length;i++){
				  txt +=`<tr>
				       <td>${list[i].custId}</td>
				       <td>${list[i].custName}</td>
				       <td>${list[i].custPhone}</td>
				       <td>${list[i].custEmail}</td>
				       <td>${datetime(list[i].custStarttime)}</td>
				       <td>${list[i].custNumber}</td>
				       <td><button onclick="delUser('${list[i].custId}')">删除</button></td>
				  </tr>`;
			  }
			  $("tbody").append(txt);
		}
	}else{
		alert(data.state);
	}
}
function datetime(time) {
	var date = new Date(time);
	return date.getFullYear() + "-" + (date.getMonth()+1) + "-"
			+ date.getDate() + " " + date.getHours() + ":" + date.getMinutes()
			+ ":" + date.getSeconds();
}

$(".fa-search").on("click",function(){//点击搜索存模糊字段
	
	var likename = $(".likename").val();
	var np = "1";
	sessionStorage.setItem("namelike",likename);
	countorder();// 默认最后一页
	console.log("模糊字段","(",likename,")");
	ajaxget(likename,np);//
	
	
})

function delUser(id){
	var from = sessionStorage.getItem("from");
	$.ajax({
		type : "get",
		url : "./operator/userdelect",
		dataType : "json",
		data:{
			id:id,
			from:from,
		},
		success : function(data) {
			console.log("成功", data);
			alert(data.status);
		},
		error : function(data) {
			console.log("失败");
		}
	})
	
}
function datetime(time) {
	var date = new Date(time);
	return date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
			+ date.getDate() + " " + date.getHours() + ":" + date.getMinutes()
			+ ":" + date.getSeconds();
}
	   

	    
