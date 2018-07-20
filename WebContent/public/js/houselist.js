
/*  收索验证  */
$(".cablebtn").click(function(){
	if ($(".cablehouselist").val().trim()=="") {
	} else{
		$(".form-search").submit();
	}
});

/*首页*/
$(".paginItem").eq(0).click(function(){
	var pages = $('.blue').eq(1).text();
	if(pages!=1){
	var page=1;
	var rep=$.ajax({  
        type: "POST",  
        url: "houselist",  
        data:{"page": page,"housesname":$(".housesname").text()},
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
	if(page>pages){
	var rep=$.ajax({  
        type: "POST",  
        url: "houselist",  
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
	        url: "houselist",  
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
	        url: "houselist",  
	        data:{"page": page,"housesname":$(".housesname").text()},
	    	success:function( data ){  
	    		curduser(data);
	    		$('.blue').eq(1).text(page);
	        }
		});
	}
})

!(function closure() {
	/*  删除   */
	$(".delete").live("click",function(){
		var house_id=$(this).next().text();
		$(this).parent().parent().remove();
		var rep=$.ajax({  
	        type: "POST",  
	        url: "delhouse",  
	        data:{"house_id": house_id,"page": $('.blue').eq(1).text(),"housesname":$(".housesnames").text()},
	    	success:function( data ){
	    		/* console.log(data[0].username); */
	    		curduser(data);
	        }
		});  
	});
})()
/*
 * 修改
 */
!(function closure() {
	$(".update").live("click",function(){
		var house_id=$(this).next().next().text();
		 window.location ="updatehouse?id="+house_id;
	});
})()
/*
 * 共用方法，必须放最底端
 * */
function curduser(data) {
	var newInfo = '';
    if(!data) return alert('对不起，输入有误或没有此项！');
	$('.classlist li').remove();
	for (var i = 0; i < data.length; i++) {
		var a="/Rpmsys/assets/images/user/t00.jpg";
	    var b='<p style="margin-left: 5px;font-weight: bold;">'+
		        '<a href="addyh?house_name='+data[i].housename+'&from_id='+data[i].from_id+'">暂无住户：可添加</a>'+
		        '</p>';
		if(data[i].user){
			if(data[i].user.username){
				if(data[i].user.photo_url){
					a=data[i].user.photo_url;
				}else{
					a="/Rpmsys/assets/images/user/t00.png";
				}
				b='<b> 住户名：'+data[i].user.username+'</b>';
			}
			
		}
		 newInfo +='<li>'+
		 '<span><img src="'+a+'" />'+b+'</span>'+
		 '<div class="lright">' +
         '<h2>房屋资料</h2>'+
          '<p>房屋名：'+data[i].housename+'</p>'+
          '<p>规格：'+data[i].room+'室'+data[i].hall+'厅'+data[i].kitchen+'厨'+data[i].toilet+'卫'+data[i].balcony+'阳台'+'</p>'+
          '<p>售价：'+data[i].price+'</p>'+
          '<a class="enter update">修改资料</a><a class="enter delete">删除房屋</a>'+
          '<span class="deluser" style="display: none;">'+data[i].house_id+'</span>'+
          '</div>'+
        '</li>';
    }$('.classlist').append(newInfo);
}
