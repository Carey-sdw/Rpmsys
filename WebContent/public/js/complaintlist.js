/*  收索验证  */
$(".cablebtn").click(function(){
	if ($(".cablehouselist").val().trim()=="") {
	} else{
		$(".form-search").submit();
	}
});

/*  删除   */
!(function closure() {
	$(".delete").live("click",function(){
		var complaint_id=$(this).parent().next().text();
		$(this).parent().parent().remove();
		var rep=$.ajax({  
	        type: "POST",  
	        url: "delcomplaint",  
	        data:{"complaint_id": complaint_id,"page": $('.blue').eq(1).text(),"complaintsname":$(".complaintsname").text()},
	    	success:function( data ){
	    		/* console.log(data[0].username); */
	    		curduser(data);
	    	}
		});  
	});
})()

/*  修改  */
!(function closure() {
	$(".update").live("click",function(){
		var complaint_id=$(this).parent().next().text();
		var type_t=$(this).parent().prev().text();
		var rep=$.ajax({  
	        type: "POST",  
	        url: "updcomplaint",  
	        data:{"complaint_id": complaint_id,
	        	"page": $('.blue').eq(1).text(),
	        	"complaintsname":$(".complaintsname").text(),
	        	"type_t":type_t},
	    	success:function( data ){
	    		/* console.log(data[0].username); */
	    		curduser(data);
	    	}
		});  
	});
})()


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
		var a='暂未处理';
		var c='<button class="cen update">立即处理</button>';
		if(data[i].type_t ==2){
			a='处理完毕';
			c='<button class="cen delete">删除该项</button>';
		}
		if(data[i].type_t ==1){
			a='正在处理';
			c='<button class="cen update">完成处理</button>';
		}
		var b="";
		if(data[i].telephone){
			b=data[i].telephone;
		}
		var d="";
		if(data[i].describe){
			d=data[i].describe;
		}

		newInfo +='<tr style="height:76px">'+
			'<td>'+data[i].housename +'</td>'+
			'<td>'+data[i].username+'</td>'+
	    	'<td style="width: 360px">'+d+'</td>'+
	    	'<td style="width: 123px">'+b+'</td>'+
	    	'<td style="width: 166px">'+data[i].time_s+'</td>'+
	    	'<td>'+a+'</td>'+
	    	'<td style="display: none;">'+data[i].type_t+'</td>'+
	    	'<td style="width: 170px">'+c+'</td>'+
	    	'<td style="display: none;">'+data[i].complaint_id+'</td>'+
        '</tr>';
    }
	$('.complaints').append(newInfo);
}