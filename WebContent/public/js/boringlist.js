$(".addbors").click(function() {
	$(".addb").attr("style","display:none;");
	$(".addbo").attr("style","display:;");
	$(".addbors").attr("style","display:none;");
	$(".addbor").attr("style","display:;");
})
$(".addbor").click(function() {
	$(".addbo").attr("style","display:none;");
	$(".addb").attr("style","display:;");
	$(".addbor").attr("style","display:none;");
	$(".addbors").attr("style","display:;");
})
$(".addents").click(function() {
	var a=$(".sbor").eq(0).val().trim();
	var b=$(".sbor").eq(1).val().trim();
	var c=$(".sbor").eq(2).val().trim();
	var d=$(".sbor").eq(3).val().trim();
	var e=$(".sbor").eq(4).val().trim();
	var f=$(".sbor").eq(5).val().trim();
	var flag=false;
	var err=["手机号码格式不正确","价格不合理","数量不合理"];
	var res=["^$|^[1][3,4,5,7,8][0-9]{9}$","^[0-9]{1,6}$|[.][0-9]{1,2}$","^[1-9]{1,5}$"];
 	var reg=[d,e,f];
	if(a!=""&&b!=""&&e!=""&&f!=""){
	 	for (var i = 0; i < reg.length; i++) {
	 		var re=new RegExp(res[i]);
	 	   	if(re.test(reg[i])){
	 				//不做提示
	 				flag = true;
	 	   	}else{
		 	   	$(".bori").attr("style","color: red;margin-left: 60px;");
				$(".bori").text(err[i]);
	           	flag = false;
	       	}
		}
	 	if(flag){
			$(".addbo").submit();
	 	}
	}else{
		$(".bori").attr("style","color: red;margin-left: 60px;");
		$(".bori").text("必填项不能为空");
	}
})

$(".select1").change(function(){
	var name=$(".select1").select().val();
	if(name!='---请选择---'){
		var rep=$.ajax({  
	        type: "POST",  
	        url: "boringlist",  
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
	        url: "aboringlist",  
	        data:{"username": name,"type_t": type_t},
	    	success:function( data ){
	    		$(".bor").eq(2).val(data.price);
	    		$(".bor").eq(0).val(data.source_s);
	    		$(".bor").eq(1).val(data.telephone);
	    		$(".bor").attr("disabled","");
	        }
		});
	}
})
$(".addent").click(function(){
	var boringname=$(".select1").select().val();
	var type_t=$(".select2").select().val();
	var price=$(".bor").eq(2).val().trim();
	var source_s=$(".bor").eq(0).val().trim();
	var telephone=$(".bor").eq(1).val().trim();
	var number_s=$(".bors").val().trim();
	var handle=$(".han").text();
	var boring={"boringname":boringname,"type_t":type_t,"price":price,"number_s":number_s,"source_s":source_s,"telephone":telephone,"handle":handle};
	if(price!=""&&number_s!=""){
		var rep=$.ajax({
	        type: "POST",  
	        url: "addboring",  
	        data:boring,
	    	success:function( data ){
	    		$(".bors").val("");
	    		$(".bori").attr("style","color: green;margin-left: 60px;");
	    		$(".bori").text(data.boringname);
	        }
		});
	}else{
		$(".bori").attr("style","color: red;margin-left: 60px;");
		$(".bori").text("价格或数量不为空");
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
