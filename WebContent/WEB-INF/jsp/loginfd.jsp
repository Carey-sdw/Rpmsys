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
<script src="${pageContext.request.contextPath}/assets/js/cloud.js" type="text/javascript"></script>

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
	<c:url value="/loginfd" var="login"/>
	<div class="logintop">    
	    <span>按要求查找密码</span>  
    </div> 
    <div class="loginbody">
    
	    <span class="systemlogo"></span> 
	       
	    <div class="loginbox" style="background:url(${pageContext.request.contextPath}/assets/images/logininfo1.png) no-repeat;">
	    <form action="${login }" method="post">
		    <ul>
		    <c:if test="${not empty loginpwd }">
		        <li style="margin-left: 120px;margin-top: -44px;font-size: 14px;color: red;">
					${loginpwd }
		        </li>
		   </c:if>
			    <li><input name="forgetname" type="text" value="${loginfdusername }" class="loginuser" placeholder="用户名"  autocomplete="off"/></li>
			    <li><input name="forgetpwd" type="text" value="${loginfdusercard }" class="loginuser" placeholder="身份证"  autocomplete="off"/></li>
			    <li><input name="logsub" type="submit" class="loginbtn" value="确认更改"/>
			    <label style="margin-left: 100px"><a href="login">记起密码去登录</a></label></li>
		    </ul>
	    </form>
	    
	    </div>
    
    </div>

    <div class="loginbm">湖南省-长沙市-望城区-长沙医学院</div>
</body>

</html>
