$(".user-arrow-down").on("click", function () {
    if ($(".dropdown").is(":hidden")) {
        $(".dropdown").show();
    } else {
        $(".dropdown").hide();
    }
})
$(".sort li").eq(0).on("click", function () {
    $(".sort li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(".sort li").eq(1).on("click", function () {
    $(".sort li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(".sort li").eq(2).on("click", function () {
    $(".sort li").removeClass("font-red");
    $(this).addClass("font-red");
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
$(".imgshow").attr("src","/operator/headimgshow?id="+id);
})
function defaultImg(img){
	img.src="/images/default_user.png";
}

$(function(){
	sessionStorage.setItem("namelike","");
	sessionStorage.setItem("orderby",0);
	sessionStorage.removeItem("state");
	sessionStorage.setItem("homepage",1);
	countorder();// 默认最后一页
	sessionStorage.setItem("nowpage",1);
	home_page()
    pageshow();
	
})
function countorder(){
	var likename = sessionStorage.getItem("namelike");
	var orderby = sessionStorage.getItem("orderby");
	$.ajax({
		type : "get",
		url : "/operator/countorder",
		dataType : "json",
		data:{
			likename:likename,
			orderby:orderby,
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
	var orderby = sessionStorage.getItem("orderby");
	console.log("模糊字段","(",likename,")","当前页","(",nowpage,")","搜索状态","(",orderby,")");
	$.ajax({
		type : "get",
		url : "/operator/topage",
		dataType : "json",
		data:{
			likename:likename,
			nowpage:nowpage,
			orderby:orderby,
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
		$(".productlist").html("");
		var txt = "";
		for(var i = 0;i< list.length;i++)
		{
			txt+=`
			<tr>
		        <td>${list[i].servProductname}</td>
		        <td>${list[i].servInstructions}</td>
		        <td>${list[i].servBumber}</td>
		        <td>${list[i].servProvidername}</td>
		        <td>¥${list[i].servPrice}</td>
		        `
				if(list[i].servRecommended==1)
		        {
		        	txt +=`<td><input class="checkbox" type="checkbox" checked="checked" onclick = "updatereco(${list[i].servProductid})"/></td>`
		        }else{
		        	txt +=`<td><input class="checkbox" type="checkbox" onclick = "updatereco(${list[i].servProductid})"/></td>`
		        }
				if(list[i].servNecessary==1)
				{
					txt +=`<td><input class="checkbox" type="checkbox" checked="checked" onclick = "updatenece(${list[i].servProductid})"/></td></tr>`
				}else{
					txt +=`<td><input class="checkbox" type="checkbox" onclick = "updatenece(${list[i].servProductid})"/></td></tr>`
				}
		}
		$(".productlist").append(txt);
//		<tr>
//        <td>社保补缴（三个月外）</td>
//        <td>社保补缴三个月外，单月的服务费，社保金额及滞纳金单独核算</td>
//        <td>8</td>
//        <td>云智汇咨询服务有限公司</td>
//        <td>¥500.00</td>
//        <td><input class="checkbox" type="checkbox" /></td>
//        <td><input class="checkbox" type="checkbox" /></td>
//    </tr>
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
$(function(){
	var a=0;
	$(".orderbyA").click(
			function(){
				var likename = sessionStorage.getItem("namelike");
				var np = sessionStorage.getItem("nowpage");
				a++;
				if(a%2 != 0){
					// 升序
					$("#uptoA").attr("class","fa fa-long-arrow-up fa-fw");
					sessionStorage.setItem("orderby", 0);//时间降序
				}
				else{
					// 降序
					$("#uptoA").attr("class","fa fa-long-arrow-down fa-fw");
					sessionStorage.setItem("orderby", 1);//时间升序
				}
				pageshow();
				ajaxget(likename,np);
			})
})
$(function(){
	var b=0;
	$(".orderbyB").click(
			function(){
				var likename = sessionStorage.getItem("namelike");
				var np = sessionStorage.getItem("nowpage");
				b++;
				if(b%2 != 0){
					// 升序
					$("#uptoB").attr("class","fa fa-long-arrow-up fa-fw");
					sessionStorage.setItem("orderby", 2);//销量降序
				}
				else{
					// 降序
					$("#uptoB").attr("class","fa fa-long-arrow-down fa-fw");
					sessionStorage.setItem("orderby", 3);//销量升序
				}	
				pageshow();
				ajaxget(likename,np);
			})
})
$(function(){
	var c=0;
	$(".orderbyC").click(
			function(){
				var likename = sessionStorage.getItem("namelike");
				var np = sessionStorage.getItem("nowpage");
				c++;
				if(c%2 != 0){
					// 升序
					$("#uptoC").attr("class","fa fa-long-arrow-up fa-fw");
					sessionStorage.setItem("orderby", 4);//价格降序
				}
				else{
					// 降序
					$("#uptoC").attr("class","fa fa-long-arrow-down fa-fw");
					sessionStorage.setItem("orderby", 5);//价格升序
				}	
				pageshow();
				ajaxget(likename,np);
			})
})