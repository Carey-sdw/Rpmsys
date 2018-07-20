<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>住户信息</title>
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
<b class="usersname" style="display:none">${usersname }</b>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index">首页</a></li>
    <li><a href="javascript:void(0)">住户列表</a></li>
    </ul>
    </div>
    
   
   <div class="toold">
    	<form action="cableuser" method="post" class="form-search">  
			住户,房屋名：<input class="cableuser1" value="${usersname }" name="cableuser" type="text">  
			<button type="button" class="cablebtn" style="display: "><span>搜    索</span></button>
		</form>
		<span class="prompt" style="float:left; margin-left: 600px;margin-top: -50px;"></span>
   </div>
  <div style="height: 550px;width: 100%;">
    <table class="imgtable">
    	
    <thead>
    <tr>
	    <th width="100px">住户照片</th>
	    <th>住户名</th>
	    <th>身份证</th>
	    <th>手机号</th>
	    <th>房间号</th>
	    <th>入住类型</th>
	    <th>入住人数</th>
	    <th>登记时间</th>
	    <th>描述</th>
    </tr>
    </thead>
    
    <tbody class="usert" >
    <c:forEach items="${user }" var="user">
	    <tr>
	    	<td>
		    	<c:if test="${not empty user.photo_url }">
		   		 	<span><img src="${user.photo_url }" /></span>
		    	</c:if>
		    	<c:if test="${empty user.photo_url }">
		   		 	<span><img src="${pageContext.request.contextPath}/assets/images/user/t00.png" /></span>
		    	</c:if>
		    </td>
		    <td>${user.username }</td>
			<td>${user.idcard }</td>
			<td>${user.telephone }</td> 
			<td>${user.house_name }</td>  
			<td>${user.occupancy_type }</td> 
			<td>${user.occupancy_number }</td>
		    <td>${user.registration_time }</td> 
		    <td>${user.describe }</td>
		</tr>
    </c:forEach>
    
    </tbody>
    
    </table>
</div>   

     <div class="pagin">
    	<div class="message">共&nbsp;<i class="blue">${pagenumber }</i>&nbsp;条记录，当前显示第&nbsp;<i class="blue">${page }</i>&nbsp;页</div>
        <ul class="paginList">
        	<li class="paginItem"><a href="javascript:;">首页</a></li>
	        <li class="paginItem"><a href="javascript:;">上一页</a></li>
	        <li class="paginItem"><a href="javascript:;">下一页</a></li>
	        <li class="paginItem"><a href="javascript:;">尾页</a></li>
	        </ul>
    </div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/usertable.js"></script>
</body>
</html>
