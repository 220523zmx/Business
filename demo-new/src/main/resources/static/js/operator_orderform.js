$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})

$(".business-order").on("click", function(){
    $(".main-content").show();
    $("table").show();
    $(".main-sercive").hide();
    $(".business-order").addClass("border-red");
    $(".service-order").removeClass("border-red");
    $(".main-top li").eq(3).text("业务订单");
})
$(".service-order").on("click", function(){
    $(".main-content").hide();
    $("table").hide();
    $(".main-sercive").show();
    $(".service-order").addClass("border-red");
    $(".business-order").removeClass("border-red");
    $(".main-top li").eq(3).text("服务订单");
})

$(function()
		{
	
	getOrderInfo();
	console.log("xsxsxsx");
		}
		

)
function getOrderInfo(){
  	  //ajax
	var id = $(".input") .val();
	console.log(id);
  	  $.ajax({
  		  //请求类型
  		  type:"get",
  		  //请求路径
  		  url:"/getOrderInfo",
  		  //传递参数
  		  data:{
  			id:id,
  		  },
  		  //返回数据类型，“jsonp”可以跨域
  		  dataType:"json",
  		  //成功后的回馈
  		  success:function(data){
  			  console.log("成功后返回的数据==",data);
  			  var orderInfo = data.orderInfo;
  			console.log(orderInfo);
  			  //清空之前查看的数据
  			  $("tbody").html("")
  			  
  			  var txt ="";
  			  for(var i=0;i<orderInfo.length;i++){
  				  txt +=`<tr>
  				       <td>${orderInfo[i].ordeId}</td>
  				       <td>${orderInfo[i].ordeCustomername}</td>
  				       <td>${orderInfo[i].ordeProduct}</td>
  				       <td>${orderInfo[i].ordePrice}</td>
  				       <td>${orderInfo[i].ordeStarttime}</td>
  				       `
  					  if(orderInfo[i].ordeState == 1){
  						  txt +="<td>已完成</td>";
  					  }
  					  else{
  						txt +="<td>未完成</td>";
  					  }
  				txt += `
  				       <td><button onclick="delOrder('${orderInfo[i].ordeId}')">删除</button></td>
  				  </tr>`;
  			  }
  			  console.log(txt);
  			  $("tbody").append(txt);
  		  },
  		  //失败后的回馈
  		  error:function(data){
  			  console.log("失败后返回的数据==",data);
  		  }
  	  })
}


//删除信息
function delOrder(orderId){
	 
	 console.log(orderId);
	 
	 $.ajax({
		 //请求类型
		 type:"post",
		 //请求路径
		 url:"/orderdelete",
		 //传递参数
		 data:{
			 orderId:orderId,
		 },
		 //返回数据类型
		 dataType:"json",
		 //成功后的回调
		 success:function(data){
			 console.log("成功后返回的数据==",data);
		 },
	    error:function(data){
		    console.log("失败后返回的数据==",data);
	     }
	 })

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

