<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>房屋管理</title>
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
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
</script>
</head>


<body>
<b class="housesnames" style="display:none">${housesname }</b>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index">首页</a></li>
    <li><a href="JavaScript:void(0)">房屋管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        	<li class="click">
        	  <a href="addfw">
        	 <span><img src="${pageContext.request.contextPath}/assets/images/t01.png" /></span>添加
        	 </a>
        </li>
        
       </ul>
    </div>
    
    <div class="toold">
    	<form action="cablehouselist" method="post" class="form-search">  
			房屋名：<input value="${housenames }" class="cablehouselist" name="cablehouselist" type="text">  
			<button class="cablebtn" type="button" ><span>搜    索</span></button> 
		</form>
    </div>
    
    <ul class="classlist">
    <c:forEach items="${house }" var="house">
	    <li>
	    	<span>
	    	<c:if test="${not empty house.user }">
		        <c:if test="${not empty house.user.photo_url }">
		    	<img src="${house.user.photo_url }" />
			    </c:if>
			    <c:if test="${empty house.user.photo_url }">
			    	<img src="${pageContext.request.contextPath}/assets/images/user/t00.png" />
			    </c:if>
			    <b> 住户名：${house.user.username }</b>
			</c:if>
			<c:if test="${empty house.user }">
			<img src="${pageContext.request.contextPath}/assets/images/user/t00.jpg" />
	        <p style="margin-left: 5px;font-weight: bold;">
	        <a href="addyh?house_name=${house.housename }&from_id=${house.from_id }">暂无住户：可添加</a>
	        </p>
			</c:if>
			</span>
		    <div class="lright">
			    <h2>房屋资料</h2>
			    <p>房名：${house.housename }</p>
			    <p>规格：${house.room }室${house.hall }厅${house.kitchen }厨${house.toilet }卫${house.balcony }阳台</p>   
			    <p>售价：${house.price }</p>
			    <a class="enter update">修改资料</a><a class="enter delete">删除房屋</a>
		    <span class="deluser" style="display: none;">${house.house_id }</span>
		    </div>
		</li>
    </c:forEach>

    </ul>
    
    <div class="clear"></div>
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${pagenumber }</i>页，当前显示第&nbsp;<i class="blue">${page }</i>&nbsp;页</div>
        <ul class="paginList">
        	<li class="paginItem"><a href="javascript:;">首 页</a></li>
	        <li class="paginItem"><a href="javascript:;">上一页</a></li>
	        <li class="paginItem"><a href="javascript:;">下一页</a></li>
	        <li class="paginItem"><a href="javascript:;">尾 页</a></li>
        </ul>
    </div>
    </div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/houselist.js"></script>
</body>
</html>
