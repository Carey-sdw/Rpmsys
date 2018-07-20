/*
 * 下拉框
 */
$(".select1").change(function(){
	var pricename=$(this).val();
	if(pricename!='---请选择---'){
	    $(".bor").attr("disabled","");
	}else{
		$(".bor").eq(0).val("");
		$(".bor").eq(0).attr("disabled","disabled");
	}
})

/*
 * 收费
 */
$(".addent").click(function(){
	var pricename=$(".select").val().trim();
	var housename= $(".bor").eq(0).val().trim();
	if(pricename!="---请选择---"&&housename!=""){
		var rep=$.ajax({  
	        type: "POST",  
	        url: "paylist",  
	        data:{"pricename":pricename,"housename":housename},
	    	success:function( data ){
	    		curduser(data,pricename);
	        },
	        error:function(){ 
	        	$(".bori").attr("style","color: red;margin-left: 880px;");
	    		$(".bori").text("输入不合理！");
	        }
		});
	}else{
		$(".bori").attr("style","color: red;margin-left: 880px;");
		$(".charttab").attr("style","display: none;");
		$(".bori").text("请先选择要缴的费和房屋名！");
	}
})

/*  共用方法，必须放最底端
 * */

function curduser(data,pricename) {
	var newInfo = '';
    if(!data){
    	$(".bori").attr("style","color: red;margin-left: 880px;");
		$(".bori").text("你已交过费无需缴费！");
    	return ;
    	}
	$(".charttab").attr("style","display:;");
	$('.price tr').remove();
	var b="暂无住户";
	if(data.username){
		b=data.username;
	}
		newInfo +='<tr style="height:42px;">'+
			'<td class="pricename">'+pricename+'</td>'+
			'<td>'+data.house_name +'</td>'+
	    	'<td>'+b+'</td>'+
			'<td>'+data.price+'</td>'+
			'<td><a class="enter ent addpay">缴 费</a></td>'+
        '</tr>';
	$('.price').append(newInfo);
}

$(".addpay").live("click",function(){
	var pricename=$(".select").val().trim();
	var housename= $(".bor").eq(0).val().trim();
	var rep=$.ajax({  
        type: "POST",  
        url: "updpay",  
        data:{"pricename":pricename,"housename":housename},
    	success:function( data ){
    		if(data=="1"){
    			$(".bori").attr("style","color: green;margin-left: 880px;");
        		$(".bori").text("缴费成功！");
    		}
    		$(".charttab").attr("style","display:none;");
    		$('.price tr').remove();
        },
        error:function(){ 
        	$(".bori").attr("style","color: red;margin-left: 880px;");
    		$(".bori").text("输入不合理！");
        }
	});
	
})