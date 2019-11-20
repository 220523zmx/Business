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
