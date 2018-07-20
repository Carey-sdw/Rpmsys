/*  收索验证  */
$(".buttontn").click(function(){
	if ($(".costcables").val().trim()=="") {
	} else{
		$(".form-search").submit();
	}
});

//首页
$(".paginItem").eq(0).click(function(){
	var pages=$('.blue').eq(1).text().trim();
	if(pages!=1){
		var page=1;
		var rep=$.ajax({  
	        type: "POST",  
	        url: "costtable",  
	        data:{"page": page,"costsname":$(".costsname").text()},
	    	success:function( data ){  
	    		curduser(data);
	    		$('.blue').eq(1).text("1");
	        }
		});
	} 
})

//尾页
$(".paginItem").eq(3).click(function(){
	var pages=$(".blue").eq(1).text().trim();
	var page=$(".blue").eq(0).text().trim();
	if(pages!=page){
		var rep=$.ajax({  
	        type: "POST",  
	        url: "costtable",  
	        data:{"page": page,"costsname":$(".costsname").text()},
	    	success:function( data ){  
	    		console.log(data);
	    		curduser(data);
	    		$('.blue').eq(1).text($(".blue").eq(0).text());
	        }
		});
	} 
})

/*上一页*/
$(".paginItem").eq(1).click(function(){
	var page=$(".blue").eq(1).text()-1;
	if(page>0){
		var rep=$.ajax({  
	        type: "POST",  
	        url: "costtable",  
	        data:{"page": page,"costsname":$(".costsname").text()},
	    	success:function( data ){  
	    		curduser(data);
	    		$('.blue').eq(1).text(page);
	        }
		});
	}
})
/*
下一页*/
$(".paginItem").eq(2).click(function(){
	var page=parseInt($(".blue").eq(1).text())+parseInt(1);
	var pages=parseInt($(".blue").eq(0).text())+parseInt(1);
	if(page<pages){
		var rep=$.ajax({  
	        type: "POST",  
	        url: "costtable",  
	        data:{"page": page,"costsname":$(".costsname").text()},
	    	success:function( data ){  
	    		curduser(data);
	    		$('.blue').eq(1).text(page);
	        }
		});
	}
})

/*  共用方法，必须放最底端
 * */

function curduser(data) {
	var newInfo = '';
    if(!data) return alert('对不起，输入有误或没有此项！');
	$('.costs tr').remove();
	for (var i = 0; i < data.length; i++) {
		var a="---";
		if(data[i].time_s){
			a=data[i].time_s;
		}
		var b="暂无住户";
		if(data[i].username!=null){
			b=data[i].username;
		}
		newInfo +='<tr style="height:75px">'+
			'<td>'+data[i].housename +'</td>'+
			'<td style="width: 170px">'+b+'</td>'+
			'<td>'+data[i].water_bill +' 元</td>'+
			'<td>'+data[i].electric_bill+' 元</td>'+
			'<td>'+data[i].gas_bill +' 元</td>'+
			'<td>'+data[i].property_bill+' 元</td>'+
			'<td>'+data[i].other +' 元</td>'+
			'<td>'+data[i].allcost+' 元</td>'+
			'<td style="width: 180px">'+a+'</td>'+
        '</tr>';
    }
	$('.costs').append(newInfo);
}