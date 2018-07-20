/*  收索验证  */
$(".cablebtn").click(function(){
	if ($(".cablecomplaints").val().trim()=="") {
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
	        url: "complainttable",  
	        data:{"page": page,"complaintsname":$(".complaintsname").text()},
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
	        url: "complainttable",  
	        data:{"page": page,"complaintsname":$(".complaintsname").text()},
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
	        url: "complainttable",  
	        data:{"page": page,"complaintsname":$(".complaintsname").text()},
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
	        url: "complainttable",  
	        data:{"page": page,"complaintsname":$(".complaintsname").text()},
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
	$('.complaints tr').remove();
	for (var i = 0; i < data.length; i++) {
		var a;
		if(data[i].type_t !=0){
			a='处理完毕'
		}else{
			a='暂未处理'
		}
		var b;
		if(data[i].time_e){
			b=data[i].time_e
		}else{
			b='-'
		}
		var c="-";
		if(data[i].describe){
			c=data[i].describe;	
		}
		newInfo +='<tr style="height:75px">'+
			'<td>'+data[i].housename +'</td>'+
			'<td>'+data[i].username+'</td>'+
	    	'<td style="width: 370px">'+c+'</td>'+
	    	'<td>'+'暂无'+'</td>'+
	    	'<td>'+data[i].time_s+'</td>'+
	    	'<td>'+b+'</td>'+
	    	'<td>'+a+'</td>'+
        '</tr>';
    }
	$('.complaints').append(newInfo);
}