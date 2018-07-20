<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户资料明细</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
  	<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />
	<style>
		html,body{
			height: 100%;
		}
		body{
			height: 100%;
		}
		ul.placeul{
			margin-bottom: 0;
		}
	</style>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>


<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index">首页</a></li>
    <li><a href="javascript:void(0)">用户列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="toold">
    	<form class="form-search">  
			用户姓名：<input type="text">  
			<button type="submit"><span>搜    索</span></button>  
		</form>
   </div>
 
    <table class="imgtables">
    	
    <thead>
    <tr>
    <th>住户姓名</th>
    <th>房屋地址</th>
    <th>收款费用</th>
    <th>收款时间</th>
    <th>查看详情</th>
    </tr>
    </thead>
    
    <tbody>
    <tr>
    <td>aaa</td>
    <td>A428</td>
    <td>租户</td>
    <td>2</td>
    <td>2017-12-10</td>
    <td>长得丑</td>
    </tr>
    
     <tr>
    <td>aaa</td>
    <td>A428</td>
    <td>租户</td>
    <td>2</td>
    <td>2017-12-10</td>
    <td>长得丑</td>
    </tr>
    
     <tr>
    <td>aaa</td>
    <td>A428</td>
    <td>租户</td>
    <td>2</td>
    <td>2017-12-10</td>
    <td>长得丑</td>
    </tr>
    
     <tr>
    <td>aaa</td>
    <td>A428</td>
    <td>租户</td>
    <td>2</td>
    <td>2017-12-10</td>
    <td>长得丑</td>
    </tr>
    
    
     <tr>
    <td>aaa</td>
    <td>A428</td>
    <td>租户</td>
    <td>2</td>
    <td>2017-12-10</td>
    <td>长得丑</td>
    </tr>
    
    <tr>
    <td>aaa</td>
    <td>A428</td>
    <td>租户</td>
    <td>2</td>
    <td>2</td>
    <td>长得丑</td>
    </tr>
    
    <tr>
    <td>aaa</td>
    <td>A428</td>
    <td>租户</td>
    <td>2</td>
    <td>2</td>
    <td>长得丑</td>
    </tr>
    
    <tr>
    <td>aaa</td>
    <td>A428</td>
    <td>租户</td>
    <td>2</td>
    <td>2</td>
    <td>长得丑</td>
    </tr>
    </tbody>
    
    </table>
    

    <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop">
    		<span>新增用户</span>
    		<a id="ayh"></a>
    	</div>
    </div>
   <div style="display: none;"><iframe id="iframeContent" width="680px" height="520px"  src="addyh.html"></iframe></div>
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	var topyh=document.getElementsByClassName("tiptop");
	var nods=document.getElementById("iframeContent");
	var fra=document.getElementById("iframeContent");
	$("#ayh").click(function(){
		if(fra!=undefined){
			fra.remove();
		}
	});
	$(".click").eq(0).click(function(){
		$(nods).insertAfter(topyh);
	});
	$(".click1").eq(0).click(function(){
		$(".imgtable").attr("contentEditable","true");
		$(".click1").attr("style","display: none;");
		$(".click2").attr("style","display: block;");
		$(".click3").attr("style","display: block;");
	});
	$(".click2").eq(0).click(function(){
		$(".imgtable").attr("contentEditable","false");
		$(".click1").attr("style","display: block;");
		$(".click2").attr("style","display: none;");
		$(".click3").attr("style","display: none;");
	});
	$(".click3").eq(0).click(function(){
		$(".imgtable").attr("contentEditable","false");
		$(".click1").attr("style","display: block;");
		$(".click2").attr("style","display: none;");
		$(".click3").attr("style","display: none;");
	});
</script>
</body>
</html>
