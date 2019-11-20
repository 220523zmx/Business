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
    $(".main-pagination").show();
    $(".main-sercive").hide();
    $(".business-order").addClass("border-red");
    $(".service-order").removeClass("border-red");
    $(".main-top li").eq(3).text("注册用户");
})
$(".service-order").on("click", function(){
    $(".main-content").hide();
    $("table").hide();
    $(".main-pagination").hide();
    $(".main-sercive").show();
    $(".service-order").addClass("border-red");
    $(".business-order").removeClass("border-red");
    $(".main-top li").eq(3).text("服务商用户");
})
$(function()
		{
	
	getUserInfo();
		}
		

)
function getUserInfo(){
  	  //ajax
	var name = $(".input") .val();
	console.log("name:",name);
  	  $.ajax({
  		  //请求类型
  		  type:"get",
  		  //请求路径
  		  url:"/getuserinfo",
  		  //传递参数
  		  data:{
  			name:name,
  		  },
  		  //返回数据类型，“jsonp”可以跨域
  		  dataType:"json",
  		  //成功后的回馈
  		  success:function(data){
  			  console.log("成功后返回的数据==",data);
  			  var userInfo = data.userInfo;
  			console.log("userInfo:",userInfo);
  			  //清空之前查看的数据
  			  $("tbody").html("")
  			  
  			  var txt ="";
  			  for(var i=0;i<userInfo.length;i++){
  				  txt +=`<tr>
  				       <td>${userInfo[i].admiId}</td>
  				       <td>${userInfo[i].admiName}</td>
  				       <td>${userInfo[i].admiPhone}</td>
  				       <td>${userInfo[i].admiEmail}</td>
  				       <td>${userInfo[i].admiCretime}</td>
  				       <td>${userInfo[i].admiState}</td>
  				       <td><button onclick="delUser('${userInfo[i].admiId}')">删除</button></td>
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
function delUser(admiId){
	 
	 console.log(admiId);
	 
	 $.ajax({
		 //请求类型
		 type:"post",
		 //请求路径
		 url:"/userdelete",
		 //传递参数
		 data:{
			 admiId:admiId,
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
		    // jQuery自运行函数，页面加载就调用的函数
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

	   

	    
