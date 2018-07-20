$(".select1").change(function(){
	var name=$(".select1").select().val();
	if(name!='---请选择---'){
		var rep=$.ajax({  
	        type: "POST",  
	        url: "boringoutlist",  
	        data:{"username": name},
	    	success:function( data ){  
	    		curdusers(data);
	        }
		});
	}
})
$(".select2").change(function(){
	var name=$(".select1").select().val();
	var type_t=$(this).select().val();
	if(name!='---请选择---'||type_t!='---请选择---'){
		var rep=$.ajax({  
	        type: "POST",  
	        url: "boringsoutlist",  
	        data:{"username": name,"type_t": type_t},
	    	success:function( data ){
	    		$(".bor").val(data.bnumber);
	    		$(".borp").val(data.price);
	    		$(".borp").attr("disabled","");
	        }
		});
	}
})
  
$(".enter").click(function(){
	var boringname=$(".select1").select().val();
	var type_t=$(".select2").select().val();
	var bnumber=$(".bor").val().trim();
	var price=$(".borp").val().trim();
	var number_s=$(".bors").val().trim();
	var purpose=$(".borsy").val().trim();
	var handle=$(".han").text();
	var boringOut={"boringname":boringname,"type_t":type_t,"bnumber":bnumber,"number_s":number_s,"purpose":purpose,"handle":handle,"price":price};
	if(number_s!=""&&price!=""){
	if(bnumber>=number_s&&bnumber!=0){
		var rep=$.ajax({
	        type: "POST",  
	        url: "addoutboring",  
	        data:boringOut,
	    	success:function( data ){
	    		$(".bor").val(data.bnumber);
	    		$(".bors").val("");
	    		$(".borsy").val("");
	    		$(".bori").attr("style","color: green;margin-left: 60px;");
	    		$(".bori").text(data.boringname);
	        }
		});
	}else{
		$(".bori").attr("style","color: red;margin-left: 60px;");
		$(".bori").text("库存不足!");
	}
	}else{
		$(".bori").attr("style","color: red;margin-left: 60px;");
		$(".bori").text("售价或数量不能为空");
	}
})
	

function curdusers(data) {
	var newInfo = '';
    if(!data) return alert('对不起，输入有误或没有此项！');
	$('.select2 option').remove();
	for (var i = 0; i < data.length; i++) {
		newInfo +='<option selected="selected">---请选择---</option>'+
		'<option>'+data[i].type_t+'</option>';
    }
	$('.select2').append(newInfo);
}
