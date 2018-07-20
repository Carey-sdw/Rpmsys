$(".btns").click(function(){
	var file=$(".file-btn").val();
	var name=file.substring(file.lastIndexOf(".") + 1);  
	if (file=="") {
		$('.upreturn').attr("style","text-align: center;color: red;");
		$('.upreturn').text("未选择图片，请先选择图片");
	} else{
		var name=file.substring(file.lastIndexOf(".") + 1).toUpperCase(); 
		if(name=="JPG"||name=="PNG"){
			$(".file-box").submit();
		}else{
			$('.upreturn').attr("style","text-align: center;color: red;");
			$('.upreturn').text("您选择的不是图片或图片不符合要求");
		}
	}
//		$(".file-box").submit();
});

var a=$("td").eq(1).text().trim();
var c=$("td").eq(5).text().trim();
var d=$("td").eq(7).text().trim();
var e=$("td").eq(9).text().trim();
var f=$("td").eq(11).text().trim();
var h=$("td").eq(13).text().trim();
var g=$("td").eq(15).text().trim();
var i=$("td").eq(17).text().trim();

var reg =[
    "^[a-zA-Z\u4e00-\u9fa5]{0,}$", //姓名
    "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$",  //身份证
    "^[1][3,4,5,7,8][0-9]{9}$",//手机号
    "^[1-9]{1,2}$", // 人数 
    "^[1-9][0-9]{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", // 人数 
    "^$|^[1-9][0-9]{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$"
]
/*首页*/
$(".sen").click(function(){
	/*var pages = $('.blue').eq(1).text();*/
	var username=$("td").eq(1).text().trim();
	var idcard=$("td").eq(5).text().trim();
	var telephone=$("td").eq(7).text().trim();
	var occupancy_type=$("td").eq(9).text().trim();
	var occupancy_number=$("td").eq(11).text().trim();
	var registration_time=$("td").eq(13).text().trim();
	var time_e=$("td").eq(15).text().trim();
	var describe=$("td").eq(17).text().trim();
	var user_id=$(".user_id").text().trim();

	if(a!=username||c!=idcard||d!=telephone||e!=occupancy_type||
		f!=occupancy_number||g!=time_e||h!=registration_time||i!=describe){
		/*a=username;c=idcard;d=telephone;e=occupancy_type;f=occupancy_number;g=time_e;
		h=registration_time;
		i=describe;*/
		if(time_e=="无"){
			time_e="";
		}
		
		var b=[username,idcard,telephone,occupancy_number,registration_time,time_e];
		var flag=true;
		var errorl="";
		for(var b1=0;b1<reg.length;b1++){
			var re=new RegExp(reg[b1]);
		   	if(!re.test(b[b1])){
			 flag=false;	
			 errorl=b1+1+"个可更改项";
		   	}
		}
	if(flag){
	var user={"user_id":user_id,"username":username,"idcard":idcard,
			"telephone":telephone,"occupancy_type":occupancy_type,
			"occupancy_number":occupancy_number,"time_e":time_e,
			"registration_time":registration_time,"describe":describe}
	var rep=$.ajax({  
	        type: "POST",  
	        url: "updateuser",  
	        data:user,
	    	success:function( data ){ 
	    		$('.upreturn').attr("style","text-align: center;color: green;");
	    		$('.upreturn').text(data.username);
	        },error: function(){
	        	$('.upreturn').attr("style","text-align: center;color: red;");
	    		$('.upreturn').text("资料更改失败");
	        }
		}); 
	}else{
		$('.upreturn').attr("style","text-align: center;color: red;");
		$('.upreturn').text("第"+errorl+"未按要求修改");
	}
	}else{
		$('.upreturn').attr("style","text-align: center;color: red;");
		$('.upreturn').text("请先更改内容再点击是修改");
	}
})
