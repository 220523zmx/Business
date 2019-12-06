var pagesize = 1;
var pagenum = 2;
var das=0;
$(".user-arrow-down").on("click", function() {
	if ($(".dropdown").is(":hidden")) {
		$(".dropdown").show();
	} else {
		$(".dropdown").hide();
	}
})
$(".order1").on("click", function() {
//	$(".main-content").show();
//	$("table").show();
//	$(".main-pagination").show();
//	$(".main-sercive").hide();
	$(".order1").addClass("border-red");
	$(".order2").removeClass("border-red");
	$(".main-top li").eq(3).text("正常用户");
	sessionStorage.setItem("findstate",1);
	FuzzySearch()
	//FuzzySearch();
})
$(".order2").on("click", function() {
//	$(".main-content").hide();
//	$("table").hide();
//	$(".main-pagination").hide();
//	$(".main-sercive").show();
	$(".order2").addClass("border-red");
	$(".order1").removeClass("border-red");
	$(".main-top li").eq(3).text("停用用户");
	sessionStorage.setItem("findstate",0);
	FuzzySearch()
	//FuzzySearch();
})

$(".fa").on("click", function() {
	pagesize = 1;
	FuzzySearch();
	
	
})


$(function(){
	sessionStorage.setItem("findstate",1);
	FuzzySearch();
})



$(".after").on("click", function() {
	console.log("after1"+pagesize);
	if(pagesize<das){	
		pagesize++;
		console.log("after"+pagesize);
		$(".page span").removeClass("main-pagination-page");
		$(".page span").eq(pagesize-1).addClass("main-pagination-page");
		FuzzySearcha();
	}else{
		alert("没有下一页了，亲!")
		return;
	}		
})
$(".before").on("click", function() {
	
	if(pagesize>1){	
	pagesize--;
	console.log("befor"+pagesize);
	
	$(".page span").removeClass("main-pagination-page");
	$(".page span").eq(pagesize-1).addClass("main-pagination-page");
	FuzzySearcha();
	}else{
		alert("没有上一页了，亲!")
		return;
	}		
})
$(".shou").on("click", function() {
	if(das==0){
	alert("没有查询到数据哈，亲!")
	}
	else{
		var name = $(".search").val();
		pagesize = 1;
		FuzzySearch();
	
		
		
	}
				
})
$(".wei").on("click", function() {
	$(".page span").removeClass("main-pagination-page");
	if(das==0){
	alert("没有查询到数据哈，亲!")
	}
	else{
		var name = $(".search").val();
		pagesize = das;
		$(".page span").eq(pagesize-1).addClass("main-pagination-page");
		FuzzySearcha();
		
		
		
		
	
	}
				
})


function FuzzySearch() {
	var name = $(".search").val();
	var findstate = sessionStorage.getItem("findstate");
	console.log("name为"+name);	
	$.ajax({
		type : "get",
		url : "./operator",
		data : {
			pagesize : pagesize,
			pagenum : pagenum,
			name : name,
			findstate:findstate,
		},
		dataType : "json",
		success : function(data) {
            
			
			var da=data.code;
			console.log("data.code=",data.code,"123")
			
			das=Math.ceil(data.codes/2);
			if(data.code.length == 0){
				
				alert("亲，没有搜索到数据哦");
				$(".ser").empty();
				if(das == 1 )
					{
					pagesize = 1;
					}
				FuzzySearcha();
					
					$(".page").empty();
					var tx="";
					
				    for(i=1;i<=das;i++){
				
				tx +=`<span class="border-red" id="${i}">${i}</span>`;
				
			   
				
			}
			$(".page").append(tx);
			$(".page span").eq(0).addClass("main-pagination-page");
			if(das == 0)
			{
				$(".page").empty();
				var tx="";
				
			    for(i=1;i<=das+1;i++){
			
			tx +=`<span class="border-red" id="${i}">${i}</span>`;
			
		   
			
		}
		$(".page").append(tx);
		$(".page span").eq(0).addClass("main-pagination-page");
			}	
				return;
			}
			else{
			
				$(".ser").empty();
				$(".page").empty();
				console.log("sdasdsad");
			var tx="";
			
		    for(i=1;i<=das;i++){
		
		tx +=`<span class="border-red" id="${i}">${i}</span>`;
	   
		
	}
	$(".page").append(tx);
	$(".page span").eq(0).addClass("main-pagination-page");
	
	console.log($(".main-pagination span"))
			
	showlist(da); 	}									
					
		},
		error : function(data) {
			console.log("失败", data);
		}
	})

}
function FuzzySearcha() {
	var name = $(".search").val();
	var findstate = sessionStorage.getItem("findstate");
	console.log("name为"+name);	
	$.ajax({
		type : "get",
		url : "./operator",
		data : {
			pagesize : pagesize,
			pagenum : pagenum,
			name : name,
			findstate:findstate,
		},
		dataType : "json",
		success : function(data) {
            
			$(".ser").empty();
			
			var da=data.code;
			console.log("dajhf"+da);
			das=Math.ceil(data.codes/2);
	console.log($(".main-pagination span"))
			showlist(da);
														
					
		},
		error : function(data) {
			console.log("失败", data);
		}
})}
function showlist(da){
	var txt="";
	for(i=0;i<da.length;i++){
	txt +=`  <tr>
                <td>${da[i].servProviderName}</td>
                <td>${da[i].servProviderRegion}</td>
                <td>${da[i].servProviderPhone}</td>
                <td>${da[i].servProviderIntroduction}</td>
                <td>
                    <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>`
        if(da[i].servProviderState == 0)
        	{
        	txt +=`<span class="handle-btn" onclick = "updateup('${da[i].servProviderId}')"><i class="fa fa-circle-o fa-fw" ></i>启用</span>`
        	}else{
        		txt +=`<span class="handle-btn" onclick = "updatedown('${da[i].servProviderId}')"><i class="fa fa-circle-o fa-fw" ></i>停用</span>`
        	}
		txt+=`
                </td>
            </tr>`
	}
		$(".ser").append(txt); 
}
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
function updateup(id){
	console.log(id);
	$.ajax({
		type : "get",
		url : "./updateup",
		data : {
			id:id,
		},
		dataType : "json",
		success : function(data) {
			console.log("成功", data);
			if(data.code!=0){
				FuzzySearch();
				alert(data.state);
			}else{
				alert(data.state);
			}
		},
		error : function(data) {
			console.log("失败", data);
		}
		})
	
}
function updatedown(id){
	console.log(id);
	$.ajax({
		type : "get",
		url : "./updatedown",
		data : {
			id:id,
		},
		dataType : "json",
		success : function(data) {
			console.log("成功", data);
			if(data.code!=0){
				FuzzySearch();
				alert(data.state);
			}else{
				alert(data.state);
			}
		},
		error : function(data) {
			console.log("失败", data);
		}
		})
}

