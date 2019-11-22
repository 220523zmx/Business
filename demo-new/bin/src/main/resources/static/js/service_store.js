$(function(){
	var pvname = sessionStorage.getItem("pvname");
	var serid = sessionStorage.getItem("serid");
	var pv ="";
	$(".pvname").html();
	pv+=`${pvname}`;
	$(".pvname").append(pv);
	var txt1 = `<input  name="serid" type="hidden" value = "${serid}">`;
	$(".imgto").append(txt1);
} )

$(function() {
	var id = sessionStorage.getItem("serid");
	$(".imgshow").attr("src", "/service/headimgshow?id=" + id);
	$(".storeimgshow").attr("src", "/service/storeimgshow?id=" + id);
})
function defaultImg(img) {
	img.src = "/images/default_user.png";
}





$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})


$(".pvintpupto").on("click",function(){
	var pvintrduction = $(".pvintrduction").val();
	var worktime = $(".worktime").val();
	var pvqq = $(".pvqq").val();
	var pvtell = $(".pvtell").val();
	var pvid = sessionStorage.getItem("serid");
	console.log(pvintrduction,worktime,pvqq,pvtell,pvid);
	$
	.ajax({
		type : "post",
		url : "/service/updatepvint",
		dataType : "json",
		data : {
			pvid:pvid,
			pvintrduction:pvintrduction,
			worktime:worktime,
			pvqq:pvqq,
			pvtell:pvtell,
			
		},
		success : function(data) {
			console.log("成功", data);
			console.log(data);
			
		},
		error : function(data) {
			console.log("失败",data);
		}
	})
	
	
})
