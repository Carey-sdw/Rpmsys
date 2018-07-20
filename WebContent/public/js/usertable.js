/*  收索验证  */
$(".cablebtn").click(function(){
	if ($(".cableuser1").val().trim()=="") {
	} else{
		$(".form-search").submit();
	}
});

var username=$(".usersname").text();
/*首页*/
$(".paginItem").eq(0).click(function(){
	var pages = $('.blue').eq(1).text();
	if(pages!=1){
		var page=1;
		var rep=$.ajax({  
	        type: "POST",  
	        url: "usertable",  
	        data:{"page": page,"username":$(".usersname").text()},
	    	success:function( data ){  
	    		curduser(data);
	    		$('.blue').eq(1).text("1");
	        }
		}); 
	}
})

/*尾页*/
$(".paginItem").eq(3).click(function(){
	var page=$(".blue").eq(0).text();
	var pages=$(".blue").eq(1).text();
	if(page!=pages){
		var rep=$.ajax({  
	        type: "POST",  
	        url: "usertable",  
	        data:{"page": page,"username":$(".usersname").text()},
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
	        url: "usertable",  
	        data:{"page": page,"username":$(".usersname").text()},
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
	        url: "usertable",  
	        data:{"page": page,"username":$(".usersname").text()},
	    	success:function( data ){  
	    		curduser(data);
	    		$('.blue').eq(1).text(page);
	        }
		});
	}
})

/*
 * 共用方法，必须放最底端
 * */
function curduser(data) {
	var newInfo = '';
    if(!data) return alert('对不起，输入有误或没有此项！');
    
	$('.usert tr').remove();
	for (var i = 0; i < data.length; i++) {
		var a="/Rpmsys/assets/images/user/t00.png";
		if(data[i].photo_url){
			a=data[i].photo_url;
		}
		 newInfo +='<tr>'+
		 '<td><span><img src="'+a+'" /></span></td>'+
		   '<td class="odd">'+data[i].username+'</td>'+
		   '<td>'+data[i].idcard+'</td>'+
		   '<td class="odd">'+data[i].telephone+'</td>'+
		   '<td>'+data[i].house_name+'</td>'+
		   '<td class="odd">'+data[i].occupancy_type+'</td>'+
		   '<td>'+data[i].occupancy_number+'</td>'+
		   '<td class="odd">'+data[i].registration_time+'</td>'+
		   '<td>'+data[i].describe+'</td>'+
        '</tr>';
    }$('.usert').append(newInfo);
}