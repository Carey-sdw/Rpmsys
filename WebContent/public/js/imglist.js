$('.imgtable tbody tr:odd').addClass('odd');

var topyh=document.getElementsByClassName("tiptop");
var nods=document.getElementById("iframeContent");
var fra=document.getElementById("iframeContent");
var cableuser=document.getElementById("cableuser");
/*
 * 添加用户
 */
$("#ayh").click(function(){
	if(fra!=undefined){
		fra.remove();
	}
});
$(".click").eq(0).click(function(){
	$(nods).insertAfter(topyh);
});

/*  收索验证  */
$(".cablebtn").click(function(){
	if ($(".cableuser").val().trim()=="") {
	} else{
		$(".form-search").submit();
	}
});

/*  删除   */
!(function closure() {
	$(".delete").live("click",function(){
		var user_id=$(this).next().text();
		$(this).parent().parent().remove();
		var rep=$.ajax({  
	        type: "POST",  
	        url: "deluser",  
	        data:{"user_id": user_id,"page": $('.blue').eq(1).text(),"username":$(".usersname").text()},
	    	success:function( data ){
	    		/* console.log(data[0].username); */
	    		curduser(data);
	    	}
		});  
	});
})()

/*  修改   */
!(function clos() {
	$(".update").live("click",function(){
		var user_id=$(this).next().next().text();
		 window.location ="updateuser?id="+user_id;//跳到详情页
	});
})()

/*首页*/
$(".paginItem").eq(0).click(function(){
	var pages = $('.blue').eq(1).text();
	if(pages!=1){
	var page=1;
	var rep=$.ajax({  
        type: "POST",  
        url: "imglist",  
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
        url: "imglist",  
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
	        url: "imglist",  
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
	        url: "imglist",  
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
   
	$('.classlist li').remove();
	for (var i = 0; i < data.length; i++) {
		 var a="/Rpmsys/assets/images/user/t00.png";
		if(data[i].photo_url){
			a=data[i].photo_url;
		}
		 newInfo +='<li>'+
		 '<span><img src="'+a+'" /></span>'+
		 '<div class="lright">' +
         '<h2>客户资料</h2>'+
          '<p>姓名：'+data[i].username+'</p>'+
          '<p>电话：'+data[i].telephone+'</p>'+
          '<p>入住类型：'+data[i].occupancy_type+'</p>'+
          '<a class="enter update" href="updateuser?id='+data[i].user_id+'">修改资料</a><a class="enter delete">删除客户</a>'+
          '<span class="deluser" style="display: none;">'+data[i].user_id+'</span>'+
          '</div>'+
        '</li>';
    }$('.classlist').append(newInfo);
}