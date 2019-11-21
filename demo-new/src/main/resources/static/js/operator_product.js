var check = false;
var pcid = "";
$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
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
	sessionStorage.setItem("likename","");
	sessionStorage.setItem("orderby",1);
	ajaxget();
	a=0;
})
function ajaxget(){
	var likename = sessionStorage.getItem("likename");
	var orderby = sessionStorage.getItem("orderby");
	console.log(likename,"-",orderby);
	$
	.ajax({
		type : "get",
		url : "/operator/product",
		dataType : "json",
		data : {
			likename:likename,
			orderby:orderby,
		},
		success : function(data) {
			console.log("成功", data);
			if(data.code==0)
			{
				alert(data.state);
			}else{
				productshow(data);	
			}
		},
		error : function(data) {
			console.log("失败");
		}
	})
}
function productshow(data){
	var list = data.productlist;
	console.log(list);
	var txt = "";
	$(".productshow").html("");
	for(var i=0;i<list.length;i++)
	{
		txt+=`
		<tr>
			<td><input name = "product" type="checkbox" class="checkbox servicepc" value = "${list[i].servProductid}"></td>
			<td>${list[i].servProductname}</td>
			<td>${list[i].servProvidername}</td>
			<td>¥${list[i].servPrice}.00元</td>
			<td>${list[i].servBumber}</td>
			`
		if(list[i].servState == 1)
		{
			txt+=`
				<td><span class="up-line-mark up-line-mark-red" >在线</span></td>
				<td><span class="handle-btn" onclick = "statedown(${list[i].servProductid})"><i class="fa fa-arrow-down fa-fw"></i>下线</span></td>
			</tr>`
		}else{
			txt+=`
				<td><span class="down-line-mark down-line-mark-orange">下线</span></td>
				<td>
					<span class="handle-btn"><i class="fa fa-edit fa-fw"></i>编辑</span>
					<span class="handle-btn" onclick = "productdelect(${list[i].servProductid})"><i class="fa fa-close fa-fw"></i>删除</span>
					<span class="handle-btn" onclick = "stateup(${list[i].servProductid})"><i class="fa fa-arrow-up fa-fw"></i>上线</span>
				</td>
			</tr>`
		}
	}
	$(".productshow").append(txt);
}
$(function(){
	var a=0;
	$(".orderby").click(
			function(){
				a++;
				if(a%2 != 0){
					// 升序
					$("#upto").attr("class","fa fa-long-arrow-up fa-fw");
					sessionStorage.setItem("orderby", 0);
				}
				else{
					// 降序
					$("#upto").attr("class","fa fa-long-arrow-down fa-fw");
					sessionStorage.setItem("orderby", 1);
				}	
				ajaxget();
			})
})

$(".fa-search").on("click",function(){
	var likename = $(".likename").val();
	sessionStorage.setItem("likename",likename);
	console.log(likename);
	ajaxget();
})

function statedown(pcid)
{//下线
	$
	.ajax({
		type : "post",
		url : "/operator/statedown",
		dataType : "json",
		data : {
			pcid:pcid,
		},
		success : function(data) {
			console.log("成功", data);
			if(data.code==0)
			{
				alert(data.state);
			}else{
				ajaxget();	
			}
		},
		error : function(data) {
			console.log("失败");
		}
	})
	}
function stateup(pcid){
	//上线	
	$
	.ajax({
		type : "post",
		url : "/operator/stateup",
		dataType : "json",
		data : {
			pcid:pcid,
		},
		success : function(data) {
			console.log("成功", data);
			if(data.code==0)
			{
				alert(data.state);
			}else{
				ajaxget();	
			}
		},
		error : function(data) {
			console.log("失败");
		}
	})
}
function productdelect(pcid){//删除
	$
	.ajax({
		type : "post",
		url : "/operator/productdelect",
		dataType : "json",
		data : {
			pcid:pcid,
		},
		success : function(data) {
			console.log("成功", data);
			if(data.code==0)
			{
				alert(data.state);
			}else{
				ajaxget();	
			}
		},
		error : function(data) {
			console.log("失败");
		}
	})
}
$(".checkall").on("change",function(){
	check = this.checked
	$(":checkbox[name = 'product']").attr("checked",check);
	var input = $(":checkbox[name = 'product']");
	var str = "";
	if(check){
		for(var i = 0;i<input.length;i++){
			if(input.length-1==i)
				{
				str += $(input[i]).val()
				}else{
					str+=$(input[i]).val()+",";
				}
		}
		console.log(str);
	}
	sessionStorage.setItem("str",str);
	
})
$(".up-line").on("click",function(){
	var input = $(":checkbox[name = 'product']");
	var arry = new Array();
	var j = 0;
	for(var i = 0;i<input.length;i++){
		if(input[i].checked == true){
			arry[j] =$(input[i]).val() ;
			j++;
		}
	}
	var str = "";
	for(var k = 0;k<j;k++){
			if(j-1==k)
			{
				str += arry[k]
			}else{
				str+=arry[k]+",";
			}
	}
	sessionStorage.setItem("str",str);
	console.log(str);
	loststateup();
})
$(".down-line").on("click",function(){
	var input = $(":checkbox[name = 'product']");
	var arry = new Array();
	var j = 0;
	for(var i = 0;i<input.length;i++){
		if(input[i].checked == true){
			arry[j] =$(input[i]).val() ;
			j++;
		}
	}
	var str = "";
	for(var k = 0;k<j;k++){
			if(j-1==k)
			{
				str += arry[k]
			}else{
				str+=arry[k]+",";
			}
	}
	sessionStorage.setItem("str",str);
	console.log(str);
	loststatedown();
})

function loststateup(){
	var str = sessionStorage.getItem("str");
	sessionStorage.setItem("str","");
	$
	.ajax({
		type : "post",
		url : "/operator/loststateup",
		dataType : "json",
		data : {
			str:str,
		},
		success : function(data) {
			console.log("成功", data);
			if(data.code==0)
			{
				alert(data.state);
			}else{
				ajaxget();
				
			}
			$(":checkbox[name = 'chehead']").get(0).checked = false;
			
		},
		error : function(data) {
			console.log("失败");
		}
	})
}
function loststatedown(){
	var str = sessionStorage.getItem("str");
	sessionStorage.setItem("str","");
	$
	.ajax({
		type : "post",
		url : "/operator/loststatedown",
		dataType : "json",
		data : {
			str:str,
		},
		success : function(data) {
			console.log("成功", data);
			if(data.code==0)
			{
				alert(data.state);
			}else{
				console.log("down",str);
				ajaxget();	
			}
			$(":checkbox[name = 'chehead']").get(0).checked = false;
			
		},
		error : function(data) {
			console.log("失败");
		}
	})
}
