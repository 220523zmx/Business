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
	$(".main-content").show();
	$("table").show();
	$(".main-pagination").show();
	$(".main-sercive").hide();
	$(".order1").addClass("border-red");
	$(".order2").removeClass("border-red");
	$(".main-top li").eq(3).text("正常用户");
})
$(".order2").on("click", function() {
	$(".main-content").hide();
	$("table").hide();
	$(".main-pagination").hide();
	$(".main-sercive").show();
	$(".order2").addClass("border-red");
	$(".order1").removeClass("border-red");
	$(".main-top li").eq(3).text("停用用户");
})

$(".fa").on("click", function() {
	
	FuzzySearch();
	
	
})


$(function(){
	FuzzySearch();
})



$(".after").on("click", function() {
	
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
	if(das==0){
	alert("没有查询到数据哈，亲!")
	}
	else{
		var name = $(".search").val();
		pagesize = das;
		FuzzySearch();
	}
				
})


function FuzzySearch() {
	var name = $(".search").val();
	console.log("name为"+name);	
	$.ajax({
		type : "get",
		url : "/operator",
		data : {
			pagesize : pagesize,
			pagenum : pagenum,
			name : name,
		},
		dataType : "json",
		success : function(data) {
            
			$(".ser").empty();
			$(".page").empty();
			var da=data.code;
			das=Math.ceil(data.codes/2);
			var tx="";
			
		    for(i=1;i<=das;i++){
		
		tx +=`<span class="border-red" id="${i}">${i}</span>`;
	   
		
	}
	$(".page").append(tx);
	console.log($(".main-pagination span"))
			
			var txt="";
			for(i=0;i<da.length;i++){
			txt +=`  <tr>
                        <td>${da[i].servProviderName}</td>
                        <td>${da[i].servProviderRegion}</td>
                        <td>${da[i].servProviderPhone}</td>
                        <td>${da[i].servProviderIntroduction}</td>
                        <td>
                            <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>
                            <span class="handle-btn"><i class="fa fa-circle-o fa-fw"></i>启用</span>
                        </td>
                    </tr>`
			}
				$(".ser").append(txt); 											
					
		},
		error : function(data) {
			console.log("失败", data);
		}
	})

}
function FuzzySearcha() {
	var name = $(".search").val();
	console.log("name为"+name);	
	$.ajax({
		type : "get",
		url : "/operator",
		data : {
			pagesize : pagesize,
			pagenum : pagenum,
			name : name,
		},
		dataType : "json",
		success : function(data) {
            
			$(".ser").empty();
			
			var da=data.code;
			das=Math.ceil(data.codes/2);
	console.log($(".main-pagination span"))
			
			var txt="";
			for(i=0;i<da.length;i++){
			txt +=`  <tr>
                        <td>${da[i].servProviderName}</td>
                        <td>${da[i].servProviderRegion}</td>
                        <td>${da[i].servProviderPhone}</td>
                        <td>${da[i].servProviderIntroduction}</td>
                        <td>
                            <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>
                            <span class="handle-btn"><i class="fa fa-circle-o fa-fw"></i>启用</span>
                        </td>
                    </tr>`
			}
				$(".ser").append(txt); 											
					
		},
		error : function(data) {
			console.log("失败", data);
		}
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
$(".imgshow").attr("src","/operator/headimgshow?id="+id);
})
function defaultImg(img){
	img.src="/images/default_user.png";

}
