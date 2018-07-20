<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
	
<title></title>
</head>
<body>
<div style="height:549px;width:1150px;">
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
		    <li><a href="index">首页</a></li>
		    </ul>
		    </div>
	    
		    <div class="mainbox">
		    
		    <div class="mainleft" style="width: 1140px;padding: 0px;"> 
		    
		    <div class="leftinfo">
		    <div class="welinfo">
		    <span><img src="${pageContext.request.contextPath}/assets/images/sun.png" alt="天气" /></span>
		    <b>${userlogin }${nowtime }好，欢迎使用盛世一城管理系统</b>
		    </div>
		    
		    <div class="welinfo">
		    <span><img src="${pageContext.request.contextPath}/assets/images/time.png" alt="时间" /></span>
		    <c:if test="${not empty userlogin }">
			   <c:if test="${empty loginusertime }">
			    	<i>您是第一次登陆</i> （是否修改密码？<a href="loginup">请点这里,修改密码</a>）
			   </c:if>
			   <c:if test="${not empty loginusertime }">
			    	<i>您上次登录的时间：${loginusertime }</i> （不是您登录的？<a href="loginup"  target="_parent">请点这里,修改密码</a>）
			   </c:if>
			 </c:if>
		   		
		    </div>
		    
		    </div>
		 
		    <div class="dflist1" style="width: 1140px;margin-left: 20px;">
		    <div class="listtitle">信息统计</div>    
		    <ul class="newlist">
		    <li><i>屋主数：</i>${usernumber }</li>
		    <li><i>楼盘数：</i>${housesnumber }</li>
		    <li><i>空房数：</i>${housenumber }</li>
		    <li><i>维修待处理数：</i>${repairnumber }</li>
		    </ul>        
		    </div>
		    
		    </div>
		    <!--mainright end-->
		    
		    </div>		
	</div>

</body>
</html>