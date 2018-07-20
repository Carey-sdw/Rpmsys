<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品入库</title>
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
    <li><a href="javascript:void(0)">商品入库</a></li>
    </ul>
    </div> 
    <div class="tools">
    
    	<ul class="toolbar">
        	<li class="click">
        	  <a class="addbors">
        	 <span><img src="${pageContext.request.contextPath}/assets/images/t01.png" /></span>新增物品
        	 </a>
        	  <a class="addbor" style="display: none">
        	 <span><img src="${pageContext.request.contextPath}/assets/images/t01.png" /></span>物品入库
        	 </a>
        </li>
        
       </ul>
    </div>
  <form class="form-search addb">
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
  		<label>商品型号：</label>
  		<select class="select select2">
  		<option selected="selected">---请选择---</option>
  		</select>
  	</div>
  	<div class="divs" style="margin-top: 10px;">
  		<label>生产厂家：</label><input disabled="disabled" class="bor" type="text"/>
  	</div>
  	<div class="divs" style="margin-top: 10px;">
  		<label>厂家电话：</label><input disabled="disabled" class="bor" type="text"/>
  	</div>
  	<div class="divs" style="margin-top: 10px;">
  		<label>上次单价：</label><input disabled="disabled" class="bor" type="text"/>
  	</div>
  	<div class="divs" style="margin-top: 10px;">
  		<label>商品数量：</label><input class="bors" type="text"/>
  	</div>
  	<div class="divs" style="margin-top: 10px;">	
  	<a class="enter ent addent">确认入库</a>
  	</div>
  </form>
  
<form action="boringslist" method="post" class="form-search addbo" style="display:none;">
  	<div class="divs" style="margin-top: 10px;">
  		<label>商品名称：</label>
  		<input class="sbor" placeholder="必填" name="boringname" type="text"/>
  	</div>
  	<div class="divs" style="margin-top: 10px;">
  		<label>商品型号：</label>
  		<input class="sbor" placeholder="必填" name="type_t" type="text"/>
  	</div>
  	<div class="divs" style="margin-top: 10px;">
  		<label>生产厂家：</label>
  		<input class="sbor" name="source_s" type="text"/>
  	</div>
  	<div class="divs" style="margin-top: 10px;">
  		<label>厂家电话：</label>
  		<input class="sbor" name="telephone" type="tel"/>
  	</div>
  	  	<div class="divs" style="margin-top: 10px;">
  		<label>商品单价：</label>
  		<input class="sbor" placeholder="必填" name="price" type="text"/>
  	</div>
  	<div class="divs" style="margin-top: 10px;">
  		<label>商品数量：</label>
  		<input class="sbor" placeholder="必填" name="number_s" type="text"/>
  	</div>
  	<div class="divs" style="margin-top: 10px;">	
  	<a class="enter ent addents">确认新增</a>
  	</div>
  	<div class="divs" style="margin-top: 10px;display: none">
  		<label>商品数量：</label>
  		<input class="sbor"value="${userlogin }" name="handle" type="text"/>
  	</div>
 </form>
  <div class="divs">	
  	<label class="bori" style="color: green;margin-left: 60px;"></label>
  	</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/boringlist.js"></script></body>
</html>
