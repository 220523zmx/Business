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
    $(".main-content").show();
    $(".returns_detailed").hide();
    $(".order1").addClass("border-red");
    $(".order2").removeClass("border-red");
})
$(".order2").on("click", function(){
    $(".main-content").hide();
    $(".returns_detailed").show();
    $(".order2").addClass("border-red");
    $(".order1").removeClass("border-red");
})

function defaultImg(img){
	img.src="/images/default_user.png";
}
$(".serv-quit").on("click", function() {
	sessionStorage.clear();
	location.href="/toPage?url=index.html"
})