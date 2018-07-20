/*  收索验证  */
$(".cablebtn").click(function(){
	if ($(".cablehouses").val().trim()=="") {
	} else{
		$("#cableh").submit();
	}
});

var housesname=$(".housesname").text();
//首页
$(".paginItem").eq(0).click(function(){
	var pages=$('.blue').eq(1).text().trim();
	if(pages!=1){
		var page=1;
		var rep=$.ajax({  
	        type: "POST",  
	        url: "housetable",  
	        data:{"page": page,"housesname":$(".housesname").text()},
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
	        url: "housetable",  
	        data:{"page": page,"housesname":$(".housesname").text()},
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
	        url: "housetable",  
	        data:{"page": page,"housesname":$(".housesname").text()},
	    	success:function( data ){  
	    		curduser(data);
	    		$('.blue').eq(1).text(page);
	        }
		});
	}
})

/*下一页*/
$(".paginItem").eq(2).click(function(){
	var page=parseInt($(".blue").eq(1).text())+parseInt(1);
	var pages=parseInt($(".blue").eq(0).text())+parseInt(1);
	if(page<pages){
		var rep=$.ajax({  
	        type: "POST",  
	        url: "housetable",  
	        data:{"page": page,"housesname":$(".housesname").text()},
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
    if(!data) return alert('对不起，没有数据可供操作！');
	$('.houses tr').remove();
	for (var i = 0; i < data.length; i++) {
		var a;
		if(data[i].room !=0){
			a=data[i].room+'室'
		}else{
			a='无'
		}
		var b;
		if(data[i].hall !=0){
			b=data[i].hall+'厅'
		}else{
			b='无'
		}
		var c;
		if(data[i].toilet !=0){
			c=data[i].toilet+'卫'
		}else{
			c='无'
		}
		var d;
		if(data[i].kitchen !=0){
			d=data[i].kitchen+'厨'
		}else{
			d='无'
		}
		var e;
		if(data[i].rent !=0){
			e=data[i].rent+'元/月'
		}else{
			e='暂无租价'
		}
		var f;
		if(data[i].t_type ==0){
			f='空闲'
		}else if(data[i].t_type ==1){
			f='已售'
		}else{
			f='已租'
		}
		var g;
		if(data[i].user != ''&&data[i].user!=undefined){
			if(data[i].user.username!= ''&&data[i].user.username!=undefined){
				g=data[i].user.username
			}else{
				g='无用户';
			}
		}else{
			g='无用户';
		}
		var h;
		if(data[i].t_types ==0){
			h='否'
		}else{
			h='是'
		}
		var j;
		if(data[i].balcony !=0){
			j='有阳台'
		}else{
			j='无阳台'
		}
		 newInfo +='<tr style="height:75px">'+
			'<td>'+data[i].housename +'</td>'+
			'<td>'+a+'</td>'+
	    	'<td>'+b+'</td>'+
	    	'<td>'+c+'</td>'+
	    	'<td>'+d+'</td>'+
	    	'<td>'+data[i].acreage +'平米</td>'+
	    	'<td>'+data[i].price +'元/平米</td>'+
	    	'<td>'+e+'</td>'+
	    	'<td>'+f+'</td>'+
	    	'<td>'+g+'</td>'+
	    	'<td>'+h+'</td>'+
	    	'<td>'+j+'</td>' +
        '</tr>';
    }
	$('.houses').append(newInfo);
}