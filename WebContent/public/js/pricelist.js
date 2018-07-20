/*
 * 下拉框
 */

var a="";
var b="";
$(".select1").change(function(){
	var pricename=$(this).val();
	if(pricename!='---请选择---'){
		var rep=$.ajax({  
	        type: "POST",  
	        url: "pricelist",  
	        data:{"pricename": pricename},
	    	success:function( data ){ 
	    		$(".bor").eq(0).val(data.price);
	    		$(".bor").eq(1).val(data.type_t);
	    		$(".bor").eq(0).attr("disabled","");
	    		$(".bor").eq(1).attr("disabled","");
	    		$(".borcost").val(data.cost_id);
	    		a=data.price;
	    		b=data.type_t;
	        }
		});
	}else{
		$(".bor").eq(0).val("");
		$(".bor").eq(1).val("");
		$(".bor").eq(0).attr("disabled","disabled");
		$(".bor").eq(1).attr("disabled","disabled");
	}
})

/*
 * 修改
 */
$(".updent").click(function(){
	var prices=$(".bor").eq(0).val().trim();
	var type_t=$(".bor").eq(1).val().trim();
	var cost_id=$(".borcost").val().trim();
	var price={"cost_id":cost_id,"price":prices,"type_t":type_t};
	if(type_t!=""&&price!=""){
		if(a!=prices||b!=type_t){
		var rep=$.ajax({  
	        type: "POST",  
	        url: "updprice",  
	        data:price,
	    	success:function( data ){ 
	    		$(".bori").attr("style","color: green;margin-left: 980px;");
	    		$(".bori").text(data.pricename);
	    		$(".select1").val("---请选择---");
	    		$(".bor").eq(0).val("");
	    		$(".bor").eq(1).val("");
	        },
	        error:function(){ 
	        	$(".bori").attr("style","color: red;margin-left: 980px;");
	    		$(".bori").text("输入不合理！");
	        }
		});
		}else{
			$(".bori").attr("style","color: red;margin-left: 980px;");
			$(".bori").text("请修改后再试！");
		}
	}else{
		$(".bori").attr("style","color: red;margin-left: 980px;");
		$(".bori").text("价格或单位不能为空！");
	}
})
/*
 * 点击录入
 */
$(".addent").click(function(){
	var pricename=$(".select").val().trim();
	if(pricename!="---请选择---"){
		var rep=$.ajax({  
	        type: "POST",  
	        url: "chartlist",  
	        data:{"pricename":pricename},
	    	success:function( data ){
	    		var pricenames="";
	    		if(pricename=="电费"){
					pricenames="电表";
				}
				if(pricename=="水费"){
					pricenames="水表";
				}
				if(pricename=="燃气费"){
					pricenames="燃气表";
				}
				if(pricename=="物业费"){
					pricenames="物业表";
				}
				if(pricename=="其他费用"){
					pricenames="其他";
				}
	    		$(".bor").eq(0).attr("disabled","disabled");
	    		$(".bor").eq(1).attr("disabled","disabled");
	    		$(".charttab").attr("style","display:;");
	    		console.log(data);
	    		curduser(data,pricenames);
	        },
	        error:function(){ 
	        	$(".bori").attr("style","color: red;margin-left: 980px;");
	    		$(".bori").text("输入不合理！");
	        }
		});
	}else{
		$(".bori").attr("style","color: red;margin-left: 980px;");
		$(".charttab").attr("style","display: none;");
		$(".bori").text("请先选择要录入的抄表！");
	}
})

/*
 * 录入
 */
$(".addchart").live("blur",function(){
	var pricename=$(".pricename").eq(0).text();
	var e=$(this).text();
	var s=$(this).prev().text();
	if(e==""){
		return;
	}
	else if(s>=e){
		$(".bori").attr("style","color: red;margin-left: 980px;");
		$(".bori").text("请认真核对录入数据是否正确！");
	}else{
		var number=e-s;
		var price=number*$(".bor").eq(0).val().trim();
		var ttype=$(this).next().next().next().next().text();
		price=price.toFixed(2);//保留两位
		$(this).next().text(number);//页面显示
		$(this).next().next().text(price);//页面价格
		var tds=$(this).next().next().next().text();
		var chart={"pricename":pricename,"tvalues":e,"tvalue":s,"price":price,"tds":tds,"ttype":ttype} 
		var rep=$.ajax({  
	        type: "POST",  
	        url: "updateprice",  
	        data:chart,
	    	success:function( data ){ 
	    		 curduser(data,pricename);
	        }
		});
	}
})

/*  共用方法，必须放最底端
 * */

function curduser(data,pricename) {
	
	var newInfo = '';
    if(!data) return alert('对不起，输入有误或没有此项！');
	$('.price tr').remove();
	for (var i = 0; i < data.length; i++) {
		var a=data[i].tvalue;
		if(pricename=="其他"||pricename=="物业表"){
			a=0;
		}
		var b="暂无住户";
		if(data[i].username){
			b=data[i].username;
		}
		newInfo +='<tr style="height:42px;">'+
			'<td class="pricename">'+pricename+'</td>'+
			'<td>'+data[i].house_name +'</td>'+
	    	'<td>'+b+'</td>'+
			'<td>'+data[i].ttime+'</td>'+
			'<td>'+a+'</td>'+
			'<td class="addchart" contentEditable="true"></td>'+
	    	'<td></td>'+
	    	'<td></td>'+
	    	'<td style="display:none;">'+data[i].tds+'</td>'+
	    	'<td style="display:none;">'+data[i].ttype+'</td>'+
        '</tr>';
    }
	$('.price').append(newInfo);
}
