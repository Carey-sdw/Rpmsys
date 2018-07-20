<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料信息</title>
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
</head>

<body style="min-width: 1155px">
<c:if test="${Tabletype=='入库' }">
	<b class="boringsname" style="display:none">${boringsname }</b>
		<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="index">首页</a></li>
	    <li><a href="javascript:void(0)">入库信息</a></li>
	    </ul>
	    </div>
	    
 <div style="height: 550px;width: 100%;">	 
	    <table class="imgtable">
		    <thead>
		    <tr>
		    <th>物品名</th>
		    <th>厂家</th>
		    <th>厂家电话</th>
		    <th>处理人</th>
		    <th>入库数量</th>
		    <th>处理时间</th>
		    <th>单价</th>
		    </tr>
		    </thead>
		    <tbody class="borings">
		    	<c:forEach items="${boring }" var="boring">
			   		 <tr style="height:63.5px">
				    	<td>${boring.boringname }</td>
				    	<td>${boring.source_s }</td>
				    	<td>${boring.telephone }</td>
				    	<td>${boring.handle }</td>
				    	<td>${boring.number_s }</td>
				    	<td>${boring.time_s }</td>
				    	<td>${boring.price }</td>
				    </tr>
		    	</c:forEach>
		    </tbody>
	    </table>
	 </div>
	     <div class="pagin">
	    	<div class="message">&nbsp;共<i class="blue">${pagenumber }</i>&nbsp;条记录，当前显示第&nbsp;<i class="blue">${page }</i>&nbsp;页</div>
	        <ul class="paginList">
	        	<li class="paginItem"><a href="javascript:;">首页</a></li>
		        <li class="paginItem"><a href="javascript:;">上一页</a></li>
		        <li class="paginItem"><a href="javascript:;">下一页</a></li>
		        <li class="paginItem"><a href="javascript:;">尾页</a></li>
	       </ul>
	    </div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/boringtable.js"></script>
</c:if>	
<c:if test="${Tabletype=='出库' }">
	<b class="boringsname" style="display:none">${boringsname }</b>
		<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="index">首页</a></li>
	    <li><a href="javascript:void(0)">出库信息</a></li>
	    </ul>
	    </div>
	    
 <div style="height: 550px;width: 100%;"> 
	    <table class="imgtable" >
		    <thead>
		    <tr>
		    <th>物品名</th>
		    <th>库存个数</th>
		    <th>出库个数</th>
		    <th>剩余个数</th>
		    <th>处理人</th>
		    <th>处理时间</th>
		    <th>用途</th>
		    </tr>
		    </thead>
		    <tbody class="borings">
		    	<c:forEach items="${boring }" var="boring">
			   		 <tr style="height:63.5px">
				    	<td>${boring.boringname }</td>
				    	<td>现有：${boring.bnumber }</td>
				    	<td>出库：${boring.number_s }</td>
				    	<td>还剩：${boring.enumber }</td>
				    	<td>${boring.handle }</td>
				    	<td>${boring.time_s }</td>
				    	<td>${boring.purpose }</td>
				    </tr>
		    	</c:forEach>
		    </tbody>
	    </table>
	    </div>
	     <div class="pagin">
	    	<div class="message">&nbsp;共<i class="blue">${pagenumber }</i>&nbsp;条记录，当前显示第&nbsp;<i class="blue">${page }</i>&nbsp;页</div>
	        <ul class="paginList">
	        	<li class="paginItem"><a href="javascript:;">首页</a></li>
		        <li class="paginItem"><a href="javascript:;">上一页</a></li>
		        <li class="paginItem"><a href="javascript:;">下一页</a></li>
		        <li class="paginItem"><a href="javascript:;">尾页</a></li>
	       </ul>
	    </div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/boringouttable.js"></script>
</c:if>	
</body>
</html>
