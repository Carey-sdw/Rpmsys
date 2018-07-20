<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>房屋资料</title>
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


<body style="min-width: 1150px">
<b class="housesname" style="display:none">${housesname }</b>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index">首页</a></li>
    <li><a href="javascript:void(0)">房屋列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
       
   <div class="toold">
    	<form action="cablehouses" id="cableh" method="post" class="form-search">  
			房屋号：<input type="text" value="${housesname }" class="cablehouses" name="cablehouses">  
			<button type="button" class="cablebtn" style="display: "><span>搜    索</span></button>
		</form>
   </div>
  <div style="height: 548px;width: 100%;">
    <table class="imgtable">
    	
    <thead>
    <tr>
    <th>房间号</th>
    <th>室</th>
    <th>厅</th>
    <th>卫</th>
    <th>厨</th>
    <th>面积</th>
    <th>购价</th>
    <th>租金</th>
    <th>是否空闲</th>
    <th>屋主</th>
    <th>是否二手房</th>
    <th>有无阳台</th>
    </tr>
    </thead>
    <tbody class="houses">
    	<c:forEach items="${house }" var="house">
	   		 <tr style="height:75px">
		    	<td>${house.housename }</td>
		    	<td>
		    		<c:if test="${house.room !=0}">${house.room }室</c:if>
		    		<c:if test="${house.room ==0}">无</c:if>
		    	</td>
		    	<td>
		    		<c:if test="${house.hall !=0}">${house.hall }厅</c:if>
		    		<c:if test="${house.hall ==0}">无</c:if>
		    	</td>
		    	<td>
		    		<c:if test="${house.toilet !=0}">${house.toilet }卫</c:if>
		    		<c:if test="${house.toilet ==0}">无</c:if>
		    	</td>
		    	<td>
		    		<c:if test="${house.kitchen !=0}">${house.kitchen }厨</c:if>
		    		<c:if test="${house.kitchen ==0}">无</c:if>
		    	</td>
		    	<td>${house.acreage }平米</td>
		    	<td>${house.price }元/平米</td>
		    	<td>
			    	<c:if test="${house.rent !=0}">${house.rent }元/月</c:if>
			    	<c:if test="${house.rent ==0}">暂无租价</c:if>
		    	</td>
		    	<td>
		    		<c:if test="${house.t_type==0 }">空闲</c:if>
			    	<c:if test="${house.t_type==1 }">已售</c:if>
			    	<c:if test="${house.t_type==2 }">已租</c:if>
		    	</td>
		    	<td>
		    		<c:if test="${empty house.user.username }">无用户</c:if>
		    		<c:if test="${not empty house.user.username }">${house.user.username }</c:if>
		    	</td>	
		    	<td>
		    		<c:if test="${house.t_types==0 }">否</c:if>
		    		<c:if test="${house.t_types==1 }">是</c:if>
		    	</td>
		    	<td>
		    		<c:if test="${house.balcony==0 }">无阳台</c:if>
		    		<c:if test="${house.balcony!=0 }">有阳台</c:if>
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
       </ul>
    </div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/housetable.js"></script>
</body>
</html>
