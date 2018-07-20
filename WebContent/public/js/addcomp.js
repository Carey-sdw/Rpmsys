
/*  收索验证  */
$(".cablebtn").click(function(){
	if ($(".cablehouselist").val().trim()=="") {
		$(".repaira").attr("style","color:red;");
		$(".repaira").text("(请输入要投诉的房屋号)");
	} else{
		var rep=$.ajax({  
	        type: "POST",  
	        url: "cablecomphouse",  
	        data:{"housesname":$(".cablehouselist").val().trim()},
	    	success:function( data ){ 
	    		if(!data){
	    			$(".repaira").attr("style","color:red;");
	    			$(".repaira").text("(输入有误或没有此房屋)");
	    		}
	    		$(".repaira").text("");
	    		$(".repair1").val(data.housename);
	    		$(".repair2").val(data.user.username);
	    		$(".repair3").val(data.user.telephone);
	        }
		});
	}
});
/*  添加报修  */
$(".enter").click(function(){
	if ($(".repair1").val().trim()==""||$(".text").val().trim()=="") {
		$(".repaira").attr("style","color:red;");
		$(".repaira").text("(请查找房屋再填写内容！)");
	} else{
		var repair={"describe":$(".text").val().trim(),
				"housename":$(".repair1").val(),
				"username":$(".repair2").val(),
				"telephone":$(".repair3").val()};
		var rep=$.ajax({  
	        type: "POST",  
	        url: "addcomp",  
	        data:repair,
	    	success:function( data ){ 
	    		$(".repaira").attr("style","color:green;");
	    		$(".repaira").text(data.housename);
	    		$(".text").val("");
	        }
		});
	}
});
