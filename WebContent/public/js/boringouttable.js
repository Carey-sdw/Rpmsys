
//首页
$(".paginItem").eq(0).click(function(){
	var pages=$('.blue').eq(1).text().trim();
	if(pages!=1){
		var page=1;
		var rep=$.ajax({  
	        type: "POST",  
	        url: "boringouttable",  
	        data:{"page": page,"boringsname":$(".boringsname").text()},
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
	        url: "boringouttable",  
	        data:{"page": page,"boringsname":$(".boringsname").text()},
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
	        url: "boringouttable",  
	        data:{"page": page,"boringsname":$(".boringsname").text()},
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
	        url: "boringouttable",  
	        data:{"page": page,"boringsname":$(".boringsname").text()},
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
	$('.borings tr').remove();
	for (var i = 0; i < data.length; i++) {
		var c="";
		if(data[i].handle){
			c=data[i].handle;
		}
		newInfo +='<tr style="height:63.5px">'+
			'<td>'+data[i].boringname +'</td>'+
			'<td>现有：'+data[i].bnumber+'</td>'+
	    	'<td>出库：'+data[i].number_s+'</td>'+
			'<td>还剩：'+data[i].enumber +'</td>'+
			'<td>'+c+'</td>'+
	    	'<td>'+data[i].time_s+'</td>'+
	    	'<td>'+data[i].purpose+'</td>'+
        '</tr>';
    }
	$('.borings').append(newInfo);
}