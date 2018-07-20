<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>报修资料</title>
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
	});
})	


</script>
</head>


<body style="min-width: 1155px">
<b class="repairsname" style="display:none">${repairsname }</b>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index">首页</a></li>
    <li><a href="javascript:void(0)">报修列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
       
   <div class="toold">
    	<form action="cablerepairs" method="post" class="form-search">  
			住户,房屋号：<input type="text" value="${repairsname }" class="cablerepairs" name="cablerepairs">  
			<button type="button" class="cablebtn" style="display: "><span>搜    索</span></button>
		</form>
   </div>
 <div style="height: 547px;width: 100%;">
    <table class="imgtable">
    	
    <thead>
    <tr>
    <th>房间号</th>
    <th>住户名</th>
    <th>类容</th>
    <th>处理人</th>
    <th>报修时间</th>
    <th>处理时间</th>
    <th>处理状况</th>
    </tr>
    </thead>
    <tbody class="repairs">
    	<c:forEach items="${repair }" var="repair">
	   		 <tr style="height:75px">
		    	<td>${repair.housename }</td>
		    	<td>${repair.username }</td>
		    	<td style="width: 370px">
		    	<c:if test="${empty repair.describe }">-</c:if>
			    <c:if test="${not empty repair.describe }">${repair.describe }</c:if>
		    	</td>
		    	<td>暂无</td>
		    	<td>${repair.time_t }</td>
		    	<td>
			    	<c:if test="${empty repair.time_e }">-</c:if>
			    	<c:if test="${not empty repair.time_e }">${repair.time_e }</c:if>
		    	</td>
		    	<td>
			    	<c:if test="${repair.type_t !=0}">处理完毕</c:if>
			    	<c:if test="${repair.type_t ==0}">等待处理</c:if>
		    	</td>
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
    </div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/repairtable.js"></script>
</body>
</html>
