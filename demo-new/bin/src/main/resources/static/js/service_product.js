$(function(){
	var pvname = sessionStorage.getItem("pvname");
	var serid = sessionStorage.getItem("serid");
	var pv ="";
	$(".pvname").html();
	pv+=`${pvname}`;
	$(".pvname").append(pv);
	$(".serid").attr("value",serid);
	
} )

$(function(){
	findproduct();
})
function findproduct(){
	var serid = sessionStorage.getItem("serid");
	$
	.ajax({
		type : "get",
		url : "/service/prodctshow",
		dataType : "json",
		data : {
			serid:serid,
		},
		success : function(data) {
			console.log("成功", data);
			productlist(data);
			
		},
		error : function(data) {
			console.log("失败",data);
		}
})
}
function productlist(data)
{
	$(".productshow").html("");
	var list = data.productlist;
	var txt = "";
	for(var i =0;i<list.length;i++ )
		{
		txt+=`
		<tr>
			<td>${list[i].servProductname}</td>
			<td>${list[i].servInstructions}</td>
			<td>${list[i].servPrice}</td>`
			if(list[i].servState!=1)
				{
				txt+=`<td><span class="down-line-mark down-line-mark-orange">下线</span></td>
				<td>
        <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>编辑</span>
        <span class="handle-btn"><i class="fa fa-close fa-fw" onclick = "prodelete(${list[i].servProductid})"></i>删除</span>
        <span class="handle-btn"><i class="fa fa-arrow-up fa-fw" onclick = "stateup(${list[i].servProductid})"></i>上线</span>
    </td></tr>`
				}else{
					txt+=`<td><span class="up-line-mark up-line-mark-red" >在线</span></td>
                        <td><span class="handle-btn" onclick = "statedown(${list[i].servProductid})"><i class="fa fa-arrow-down fa-fw"></i>下线</span></td>`
				}
		}
	$(".productshow").append(txt);
	
}
	
	
$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})  
$(".pcprice").on("blur",function(){
	var e = window.event;
	var num  = $(e.target).val();
	if(num <=0)
		{
		$(e.target).val(0);
		alert("单价不能为0")
		}
})

$(".add-product-action").on("click", function(event){
    $(".masking").show();
})
$(".intsave").on("click", function(event){
    var pcname = $(".pcname").val();
    var pcintp = $(".pcintp").val();
    console.log(pcname,pcintp);
	if($(".pcprice").val()<=0)
    {
    	alert("单价不能为0");
    }
	if(pcname == null || pcname == undefined || pcname == '')
    	{
    	alert("请输入商品名");
    	}
	if(pcintp == null || pcintp == undefined || pcintp == '')
	{
	alert("请输入商品简介");
	}
})
$(".cancel").on("click", function(event){
    $(".masking").hide();
    console.log("取消");
})
function defaultImg(img){
	img.src="/images/default_user.png";
}
$(function() {
	var id = sessionStorage.getItem("serid");
	$(".imgshow").attr("src", "/service/headimgshow?id=" + id);
})
function randomString(len) {
	　　len = len || 32;
	　　var $chars = '0123456789';    
	　　var maxPos = $chars.length;
	　　var pwd = '';
	　　for (i = 0; i < len; i++) {
	　　　　pwd += $chars.charAt(Math.floor(Math.random() * maxPos));
	　　}
	　　return pwd;
	}


function prodelete(pcid)
{
	var pvid = sessionStorage.getItem("serid");
	$
	.ajax({
		type : "post",
		url : "/service/prodelete",
		dataType : "json",
		data : {
			pvid:pvid,
			pcid:pcid,
		},
		success : function(data) {
			console.log("成功", data);
			findproduct();
			
		},
		error : function(data) {
			console.log("失败",data);
		}
})}
function stateup(pcid)
{
	var pvid = sessionStorage.getItem("serid");
	$
	.ajax({
		type : "post",
		url : "/service/stateup",
		dataType : "json",
		data : {
			pvid:pvid,
			pcid:pcid,
		},
		success : function(data) {
			console.log("成功", data);
			findproduct();
			
		},
		error : function(data) {
			console.log("失败",data);
		}
}
	
	
)}
function statedown(pcid)
{
	var pvid = sessionStorage.getItem("serid");

	$
	.ajax({
		type : "post",
		url : "/service/statedown",
		dataType : "json",
		data : {
			pvid:pvid,
			pcid:pcid,
		},
		success : function(data) {
			console.log("成功", data);
			findproduct();
			
		},
		error : function(data) {
			console.log("失败",data);
		}
}

	)}



$(".fa-fw").on("click",function(){
	var pvid = sessionStorage.getItem("serid");
	var namelike = $(".likename").val();
	$
	.ajax({
		type : "post",
		url : "/service/productnamelike",
		dataType : "json",
		data : {
			pvid:pvid,
			namelike:namelike,
		},
		success : function(data) {
			console.log("成功", data);
			productlist(data);
			
		},
		error : function(data) {
			console.log("失败",data);
		}
}

	)
	
	
})
