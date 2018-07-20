<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>住户管理</title>
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
</head>


<body>
<b class="usersname" style="display:none">${usersname }</b>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index">首页</a></li>
    <li><a href="javascript:void(0)">住户管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
   <div class="tools">
    
    	<ul class="toolbar">
	        <li class="click">
	        <a href="houselist"><span><img src="${pageContext.request.contextPath}/assets/images/t01.png" /></span>
	       	 去房屋</a>
	        </li>
       </ul>
    </div>
    
    <div class="toold">
    	<form action="cable" method="post" class="form-search">  
			住户,房屋名：<input class="cableuser" value="${usersname }"name="cableuser" type="text">  
			<button class="cablebtn" type="button" >
			<span>搜    索</span>
			</button> 
		</form>
    </div>
    
    <ul class="classlist">
    <c:forEach items="${user }" var="user">
	    <li>
	    <c:if test="${not empty user.photo_url }">
	    	<span><img src="${user.photo_url }" /></span>
	    </c:if>
	    <c:if test="${empty user.photo_url }">
	    	<span><img src="${pageContext.request.contextPath}/assets/images/user/t00.png" /></span>
	    </c:if>
		    <div class="lright">
			    <h2>住户资料</h2>
			    <p>姓名：${user.username }</p>
			    <p>电话：${user.telephone }</p>
			    <p>入住类型：${user.occupancy_type }</p>
			    <a class="enter update">修改资料</a><a class="enter delete">删除客户</a>
		    <span class="deluser" style="display: none;">${user.user_id }</span>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/imglist.js"></script>
</body>
</html>
