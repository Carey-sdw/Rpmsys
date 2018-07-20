<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品出库</title>
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>

<style type="text/css">
	.divs{
		height: 40px;
		width: 1080px;
		margin-left: 60px;
		padding-top: 20px;
	}
	 .select{
	 	width: 300px;
	  	height: 33px;
	 	border: 1px solid #1F3D74;
	 	margin-right: 20px;
	}
	.select option{
		height: 23px;
		font-size: 12px;
	}
	.ent{
		margin-left: 100px;
		width: 150px;
	}
	.tab tbody tr{
		height: 70px;
	}
	.bor{
		width: 300px;
	}
</style>
</head>

<body style="min-width: 1155px;">
  <b class="han" style="display:none">${userlogin }</b>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index">首页</a></li>
    <li><a href="javascript:void(0)">商品出库</a></li>
    </ul>
    </div> 
   
  <form class="form-search">
  	<div class="divs" style="margin-top: 10px;">
  		<label>商品名称：</label>
  		<select class="select select1">
  		<option selected="selected">---请选择---</option>
  		<c:forEach items="${borings }" var="borings">
  			<option>${borings.boringname }</option>
  		</c:forEach>
  		</select>
  	</div>
  	<div class="divs" style="margin-top: 10px;">
  		<label>商品类型：</label>
  		<select class="select select2">
  		<option selected="selected">---请选择---</option>
  		</select>
  	</div>
  	<div class="divs" style="margin-top: 10px;">
  		<label>剩余数量：</label><input disabled="disabled" class="bor" type="text"/>
  	</div>
  	<div class="divs" style="margin-top: 10px;">
  		<label>出售价格：</label><input disabled="disabled" class="borp" type="text"/>
  	</div>
  	<div class="divs" style="margin-top: 10px;">
  		<label>出库数量：</label><input class="bors" type="text"/>
  	</div>
  	<div class="divs" style="margin-top: 10px;">
  		<label>商品用途：</label><input class="borsy" type="text"/>
  	</div>
  	<div class="divs" style="margin-top: 10px;">	
  	<a class="enter ent">确认出库</a>
  	</div>
  </form>
  <div class="divs">	
  	<label class="bori" style="color: red;margin-left: 60px;"></label>
  	</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/boringoutlist.js"></script></body>
</html>
