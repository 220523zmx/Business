$(function(){
	var pvname = sessionStorage.getItem("pvname");
	var pv ="";
	$(".pvname").html();
	pv+=`${pvname}`;
	$(".pvname").append(pv);
} )
$(function(){
var id = sessionStorage.getItem("serid");
$(".imgshow").attr("src","/service/headimgshow?id="+id);
})
$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(".order1").on("click", function(){
   /* $(".main-content").show();*/
    /*$("table").show();
    $(".main-pagination").show();
    $(".main-sercive").hide();*/
    $(".order1").addClass("border-red");
    $(".order2").removeClass("border-red");
    $(".main-top li").eq(3).text("正常用户");
})
$(".order2").on("click", function(){
   /* $(".main-content").hide();
    $("table").hide();
    $(".main-pagination").hide();
    $(".main-sercive").show();*/
    $(".order2").addClass("border-red");
    $(".order1").removeClass("border-red");
    $(".main-top li").eq(3).text("停用用户");
})
$(".order3").on("click", function(){
    $(".main-top li").eq(3).text("未通过用户");
})
function defaultImg(img){
	img.src="/images/default_user.png";
}

$(function(){
	sessionStorage.setItem("namelike","");
	sessionStorage.setItem("finish",0);
	sessionStorage.removeItem("state");
	sessionStorage.setItem("homepage",1);
	countorder();// 默认最后一页
	sessionStorage.setItem("nowpage",1);
	home_page()
    pageshow();
	
})
function countorder(){
	var serid = sessionStorage.getItem("serid");
	var likename = sessionStorage.getItem("namelike");
	var finish = sessionStorage.getItem("finish");
	$.ajax({
		type : "get",
		url : "/service/countorder",
		dataType : "json",
		data:{
			serid:serid,
			likename:likename,
			finish:finish,
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
	var serid = sessionStorage.getItem("serid");
	var likename = sessionStorage.getItem("namelike");
	var np = nowpage;
	sessionStorage.setItem("nowpage",nowpage);
	pageshow();
	ajaxget(serid,likename,np);//
	
}
function home_page()// 首页
{
	var serid = sessionStorage.getItem("serid");
	var likename = sessionStorage.getItem("namelike");
	var np = sessionStorage.getItem("homepage");//取首页
	sessionStorage.setItem("nowpage",sessionStorage.getItem("homepage"));//当页为首页
	ajaxget(serid,likename,np);//
	pageshow();
}
function previous_page()// 上一页
{
	var serid = sessionStorage.getItem("serid");
	var likename = sessionStorage.getItem("namelike");
	var np = +sessionStorage.getItem("nowpage");//取当前页
	var firstp= sessionStorage.getItem("homepage");//取首页
	if(np==firstp){//判断首页
		alert("当前页为首页");
		return 
	}
	sessionStorage.setItem("nowpage",np-1);//当前页上一页
	pageshow();
	ajaxget(serid,likename,np-1);//
	
}
function next_page()// 下一页
{
	var serid = sessionStorage.getItem("serid");
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
	ajaxget(serid,likename,np+1);//
	
}
function trailer_page()// 尾页
{
	var serid = sessionStorage.getItem("serid");
	var likename = sessionStorage.getItem("namelike");
	var np = sessionStorage.getItem("trailerpage");//取尾页
	sessionStorage.setItem("nowpage",sessionStorage.getItem("trailerpage"));//当前页为尾页
	pageshow();
	ajaxget(serid,likename,np);
	
}

function  ajaxget(serid,likename,nowpage){//分页模糊ajax.get请求
	sessionStorage.removeItem("state");
	var finish = sessionStorage.getItem("finish");
	console.log("服务商id","(",serid,")","模糊字段","(",likename,")","当前页","(",nowpage,")","搜索状态","(",finish,")");
	$.ajax({
		type : "get",
		url : "/service/topage",
		dataType : "json",
		data:{
			serid:serid,
			likename:likename,
			nowpage:nowpage,
			finish:finish,
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
	var list = data.orderlist;
	if(data.code!=0)
	{
		$(".orderlistshow").html("");
		var txt = "";
		for(var i = 0;i< list.length;i++)
		{
			txt+=`
			<tr>
				<td>
					${list[i].ordeId}
				</td>
				<td>
					${list[i].ordeProduct}
				</td>
				<td>
					${list[i].ordeCustomername}
				</td>
				<td>
					${data[list[i].ordeCustomername]}
				</td>
				<td>
					${list[i].ordeNum}
				</td>
				<td>
					¥ ${list[i].ordePrice*list[i].ordeNum}
				</td>
				<td>
					${datetime(list[i].ordeStarttime)}
				</td>
				<td>
					<span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>
				</td>
				</tr>`
		}
		$(".orderlistshow").append(txt);
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
	
	var serid = sessionStorage.getItem("serid");
	var likename = $(".likename").val();
	var np = "1";
	sessionStorage.setItem("namelike",likename);
	countorder();// 默认最后一页
	console.log("模糊字段","(",likename,")");
	ajaxget(serid,likename,np);//
	
	
})
$(".order1").on("click",function(){
	var serid = sessionStorage.getItem("serid");
	var likename = sessionStorage.getItem("namelike");
	var nowpage = +sessionStorage.getItem("nowpage");//取当前页
	sessionStorage.setItem("finish",0);
	countorder();
	ajaxget(serid,likename,nowpage);
})
$(".order2").on("click",function(){
	var serid = sessionStorage.getItem("serid");
	var likename = sessionStorage.getItem("namelike");
	var nowpage = +sessionStorage.getItem("nowpage");//取当前页
	sessionStorage.setItem("finish",1);
	countorder();
	ajaxget(serid,likename,nowpage);
})