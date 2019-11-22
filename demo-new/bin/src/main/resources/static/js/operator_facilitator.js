$(function(){

	sessionStorage.setItem("page",0);
	afterpage();
})
$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(".order1").on("click", function(){
    $(".main-content").show();
    $("table").show();
    $(".main-pagination").show();
    $(".main-sercive").hide();
    $(".order1").addClass("border-red");
    $(".order2").removeClass("border-red");
    $(".main-top li").eq(3).text("正常用户");
})
$(".order2").on("click", function(){
    $(".main-content").hide();
    $("table").hide();
    $(".main-pagination").hide();
    $(".main-sercive").show();
    $(".order2").addClass("border-red");
    $(".order1").removeClass("border-red");
    $(".main-top li").eq(3).text("停用用户");
})
$(".after").on("click",function(){
		afterpage();
})
function afterpage(){
	var p = 1+(+sessionStorage.getItem("page")); 
	var txt = "";
	console.log(p);
	$(".page").append().html("");
	for (var i = p-1;i<=p+1;i++)
		{
		console.log(i);
		if(i!=0)
			{
			if(i==p)
				{
				txt+=`<span class="main-pagination-page">${i}</span>`
				}else{
					txt+=`<span >${i}</span>`
				}
			}
		
		}
	$(".page").append(txt);
	sessionStorage.setItem("page",p); }