<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎来到盛世一城</title>
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>
<body style="background-color:#1c77ac; background-image:url(${pageContext.request.contextPath}/assets/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
	<c:url value="/login" var="login"/>
	<div class="logintop">    
	    <span>欢迎登录盛世一城</span>  
    </div> 
    <div class="loginbody">
    
	    <span class="systemlogo"></span> 
	       
	    <div class="loginbox">
	    <form action="${login }" method="post">
		    <ul>
		    <c:if test="${not empty loginerr }">
		        <li style="margin-left: 120px;margin-top: -44px;font-size: 14px;color: red;">
					${loginerr }
		        </li>
		   </c:if>
			    <li><input name="username" value="${loginusername }" type="text" class="loginuser" placeholder="用户名"  autocomplete="off"/></li>
			    <li><input name="userpwd" type="password" class="loginpwd" placeholder="请输入密码"  autocomplete="off"/></li>
			    <li><input name="logsub" type="submit" class="loginbtn" value="登录"/>
			    <label style="margin-left: 100px"><a href="loginfd">忘记密码？</a></label></li>
		    </ul>
	    </form>
	    
	    </div>
    
    </div>
    <div class="loginbm">湖南省长沙市望城区长沙医学院</div>
</body>

</html>
