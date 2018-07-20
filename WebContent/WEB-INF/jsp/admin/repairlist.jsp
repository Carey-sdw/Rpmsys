<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
<style type="text/css">
  	.cen{
  		margin-left: 10px;
  		width: 60px;
  		height: 30px;
  		background: #3eafe0;
  	}
  	.cen:hover {
		background: #1F7CB6;
	}
	.imgtable tbody tr:hover{
	background:#ffffff;
	}
</style>
</head>
<body style="min-width: 1155px">
<b class="repairsname" style="display:none">${repairsname }</b>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index">首页</a></li>
    <li><a href="javaScript:void(0)">住户报修</a></li>
    </ul>
    </div>
   <div class="toold" style="width: 475px;">
    	<form action="cablerepairlist" method="post" class="form-search">  
			住户,房屋名：<input class="cablehouselist" name="cablehouselist" type="text">  
			<button class="cablebtn" type="button" ><span>搜    索</span></button> 
			<a class="repaira" style="color: red;"></a>

			<ul class="toolbar" style="margin-left: 508px;width:100px;margin-top: -35px;">
	        <li class="click">
	        <a href="addrepair"><span><img src="${pageContext.request.contextPath}/assets/images/t01.png" /></span>
	       	 添加</a>
	        </li>
       </ul>
		</form>
		
   </div>
  <div style="height: 552px;width: 100%;">
<table class="imgtable table" >
    <thead>
    <tr>
    <th>房间号</th>
    <th>住户名</th>
    <th>类容</th>
    <th>住户电话</th>
    <th>报修时间</th>
    <th>处理状况</th>
    <th>操作</th>
    </tr>
    </thead>
    <tbody class="repairs">
    	<c:forEach items="${repair }" var="repair">
	   		 <tr style="height:76px">
		    	<td>${repair.housename }</td>
		    	<td>${repair.username }</td>
		    	<td style="width: 365px">${repair.describe }</td>
		    	<td style="width: 125px">${repair.telephone }</td>
		    	<td style="width: 170px">${repair.time_t }</td>
		    	<td>
			    	<c:if test="${repair.type_t ==2}">处理完毕</c:if>
			    	<c:if test="${repair.type_t ==1}">正在处理</c:if>
			    	<c:if test="${repair.type_t ==0}">暂未处理</c:if>
		    	</td>
		    	<td style="display: none;">${repair.type_t}</td>
		    	<td style="width: 170px">
		    	<c:if test="${repair.type_t ==0}"><button class="cen update">立即处理</button></c:if>
		    	<c:if test="${repair.type_t ==1}"><button class="cen update">完成处理</button></c:if>
		    	<c:if test="${repair.type_t ==2}"><button class="cen delete">删除该项</button></c:if>
		    	</td>
		    	<td style="display: none;">${repair.repair_id }</td>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/repairlist.js"></script>
	
</body>
</html>