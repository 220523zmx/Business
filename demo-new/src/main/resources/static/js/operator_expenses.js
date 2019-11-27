var time=2;
var pagesize=1;
var pagenum=2;
$(".user-arrow-down").on("click", function () {
    if ($(".dropdown").is(":hidden")) {
        $(".dropdown").show();
    } else {
        $(".dropdown").hide();
    }
})
$(".business-order").on("click", function () {
    $(".main-content").show();
    $("table").show();
    $(".main-pagination").show();
    $(".main-sercive").hide();
    $(".business-order").addClass("border-red");
    $(".service-order").removeClass("border-red");
    $(".main-top li").eq(3).text("支付中心");
})
$(".service-order").on("click", function () {
    $(".main-content").hide();
    $("table").hide();
    $(".main-pagination").hide();
    $(".main-sercive").show();
    $(".service-order").addClass("border-red");
    $(".business-order").removeClass("border-red");
    $(".main-top li").eq(3).text("结算中心");
})
$(".search li").eq(0).on("click", function () {
    $(".search li").removeClass("font-red");
    $(this).addClass("font-red");
    $(".page").empty();
    time=0;
    FuzzySearchA();
    
    
})
$(".search li").eq(1).on("click", function () {
    $(".search li").removeClass("font-red");
    $(this).addClass("font-red");
    $(".page").empty();
    time=1;
    FuzzySearchA();
})
$(".search li").eq(2).on("click", function () {
    $(".search li").removeClass("font-red");
    $(this).addClass("font-red");
    $(".page").empty();
    time=3;
    FuzzySearchA();
})
$(".search li").eq(3).on("click", function () {
    $(".search li").removeClass("font-red");
    $(this).addClass("font-red");
    $(".page").empty();
    time=2;
    FuzzySearchA();
})



$(function(){
	FuzzySearchA();
})

$(".after").on("click", function() {
	
	if(pagesize<das){	
		pagesize++;
		console.log("after"+pagesize);
		$(".page span").removeClass("main-pagination-page");
		$(".page span").eq(pagesize-1).addClass("main-pagination-page");
		FuzzySearchAa();
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
	FuzzySearchAa();
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
		FuzzySearchAa();
	
		
		
	}
				
})
$(".wei").on("click", function() {
	if(das==0){
	alert("没有查询到数据哈，亲!")
	}
	else{
		var name = $(".search").val();
		pagesize = das;
		FuzzySearchAa();
	}
				
})

















function FuzzySearchA() {
	
	$.ajax({
		type : "get",
		url : "/expenses",
		data : {
		time:time,
		pagesize:pagesize,
		pagenum:pagenum,
		},
		dataType : "json",
		success : function(data) {
            
			$(".ser").empty();
			
			var da=data.code;
			das=Math.ceil(data.codea/2);
			var tx="";
			
		    for(i=1;i<=das;i++){
		
		tx +=`<span class="border-red" id="${i}">${i}</span>`;
	   
		
	}
	$(".page").append(tx);
			
			var txt="";
			var ss=0;
			for(i=0;i<da.length;i++){
			txt +=`
                        <tr>
                        <td>${da[i].ordeCustomername}</td>
                        <td>${da[i].ordeStarttime}</td>
                        <td>${da[i].ordeCustomerid}</td>
                        <td>${da[i].ordePrice}</td>
                        <td>${da[i].ordePayway}</td>
                        <td>${da[i].ordeProduct}</td>
                    </tr>`
				ss+=da[i].ordePrice;
				
				
				
			}
			console.log("ss="+ss);
			$(".as").text(ss);
			
				$(".ser").append(txt); 
				
					
		},
		error : function(data) {
			console.log("失败", data);
		}
	})

}


function FuzzySearchAa() {
	
	$.ajax({
		type : "get",
		url : "/expenses",
		data : {
		time:time,
		pagesize:pagesize,
		pagenum:pagenum,
		},
		dataType : "json",
		success : function(data) {
            
			$(".ser").empty();
			
			var da=data.code;
			das=Math.ceil(data.codea/2);
			var tx="";
	
	$(".page").append(tx);
			
			var txt="";
			var ss=0;
			for(i=0;i<da.length;i++){
			txt +=`
                        <tr>
                        <td>${da[i].ordeCustomername}</td>
                        <td>${da[i].ordeStarttime}</td>
                        <td>${da[i].ordeCustomerid}</td>
                        <td>${da[i].ordePrice}</td>
                        <td>${da[i].ordePayway}</td>
                        <td>${da[i].ordeProduct}</td>
                  
                    </tr>`
			
				ss+=da[i].ordePrice;
			
			}
				$(".ser").append(txt);
				$(".as").empty();
				$(".as").text(ss);
					
		},
		error : function(data) {
			console.log("失败", data);
		}
	})

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

