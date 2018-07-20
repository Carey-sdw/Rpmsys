<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>费用资料</title>
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


<body>
<b class="costssname" style="display:none">${costssname }</b>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index">首页</a></li>
    <li><a href="javascript:void(0)">费用列表</a></li>
    </ul>
    </div>
       
   <div class="toold">
    	<form action="costcable" method="post" class="form-search">  
			房屋号：<input type="text" value="${costssname }" class="costcables" name="costcables">  
			<button type="button" class="buttontn" style="display: "><span>搜    索</span></button>
		</form>
   </div>
 <div style="height: 548px;width: 100%;">
    <table class="imgtable">
    	
    <thead>
    <tr>
    <th>房屋号</th>
    <th>住户名</th>
    <th>水费</th>
    <th>电费</th>
    <th>燃气费</th>
    <th>物业费</th>
    <th>其他费</th>
    <th>总费用</th>
    <th>时间</th>
    </tr>
    </thead>
    <tbody class="costs">
    	<c:forEach items="${cost }" var="cost">
	   		 <tr style="height:75px">   
		    	<td>${cost.housename }</td>
		    	<c:if test="${not empty cost.username }"><td style="width: 170px">${cost.username }</td></c:if> 
		    	<c:if test="${empty cost.username }"><td style="width: 170px">暂无住户</td></c:if> 
		    	<td>${cost.water_bill } 元</td>
		    	<td>${cost.electric_bill } 元</td>
		    	<td>${cost.gas_bill } 元</td>
		    	<td>${cost.property_bill } 元</td>
		    	<td>${cost.other } 元</td>
		    	<td>${cost.allcost } 元</td>
		    	<c:if test="${not empty cost.time_s }"><td style="width: 180px">${cost.time_s }</td></c:if> 
		    	<c:if test="${empty cost.time_s }"><td style="width: 180px">---</td></c:if> 
		    </tr>
    	</c:forEach> 
    </tbody>
    
    </table>
  </div>  

     <div class="pagin">
    	<div class="message">&nbsp;共<i class="blue">${pagenumber }&nbsp;</i>条记录，当前显示第&nbsp;<i class="blue">${page }&nbsp;</i>页</div>
        <ul class="paginList">
        	<li class="paginItem"><a href="javascript:;">首页</a></li>
	        <li class="paginItem"><a href="javascript:;">上一页</a></li>
	        <li class="paginItem"><a href="javascript:;">下一页</a></li>
	        <li class="paginItem"><a href="javascript:;">尾页</a></li>
       </ul>
    </div>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/costtable.js"></script>
</body>
</html>
