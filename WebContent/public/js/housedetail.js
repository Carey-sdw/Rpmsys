var a=$("td").eq(5).text().trim();
var c=$("td").eq(7).text().trim();
var d=$("td").eq(9).text().trim();
var e=$("td").eq(11).text().trim();
var f=$("td").eq(13).text().trim();
var g=$("td").eq(15).text().trim();
var h=$("td").eq(17).text().trim();
var j=$("td").eq(21).text().trim();
var k=$("td").eq(19).text().trim();
var reg =[
	 "^[0-9]{1,2}$",
	 "^[0-9]{1,2}$",
	 "^[0-9]{1,2}$",
	 "^[0-9]{1,2}$", //卫
    "^[1-9][0-9]{1,3}$|[.][0-9]{1,2}$",//面积
    "^[1-9][0-9]{2,4}$|[.][0-9]{1,2}$", // 售价
    "^0|^[1-9][0-9]{2,4}$|[.][0-9]{1,2}$", // 租金
    "^[0-1]$",
    "^[0-1]$"
]
/*首页*/
$(".cen").click(function(){
	/*var pages = $('.blue').eq(1).text();*/
	var room=$("td").eq(5).text().trim();
	var hall=$("td").eq(7).text().trim();
	var kitchen=$("td").eq(9).text().trim();
	var toilet=$("td").eq(11).text().trim();
	var acreage=$("td").eq(13).text().trim();
	var price=$("td").eq(15).text().trim();
	var rent=$("td").eq(17).text().trim();
	var balcony=$("td").eq(21).text().trim();
	var t_types=$("td").eq(19).text().trim();
	
	var house_id=$(".house_id").text().trim();
	var b=[room,hall,kitchen,toilet,acreage,price,rent,t_types,balcony];
	var flag=true;
	var errorl="";
	for(var b1=0;b1<reg.length;b1++){
		var re=new RegExp(reg[b1]);
	   	if(!re.test(b[b1])){
	   	errorl=b1+1+"个可更改项";
		 flag=false;	
	   	}
	   	
	}
	
	if(a!=room||c!=hall||d!=kitchen||e!=toilet||
		f!=acreage||g!=price||h!=rent||j!=balcony||k!=t_types){
	if(flag){
	var house={"house_id":house_id,"room":room,
			"hall":hall,"kitchen":kitchen,
			"toilet":toilet,"acreage":acreage,
			"price":price,"rent":rent,"balcony":balcony,"t_types":t_types}
	var rep=$.ajax({  
	        type: "POST",  
	        url: "updatehouse",  
	        data:house,
	    	success:function( data ){ 
	    		$('.upreturn').attr("style","text-align: center;color: green;");
	    		$('.upreturn').text(data.housename);
	        },error: function(){
	        	$('.upreturn').attr("style","text-align: center;color: red;");
	    		$('.upreturn').text("操作失误，资料更改失败");
	        }
		}); 
	}else{
		$('.upreturn').attr("style","text-align: center;color: red;");
		$('.upreturn').text("第"+errorl+"未按要求修改，资料修改失败");
	}
	}else{
		$('.upreturn').attr("style","text-align: center;color: red;");
		$('.upreturn').text("请先更改内容再点击是修改");
	}
})
