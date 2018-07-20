<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户缴费</title>
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>

<style type="text/css">
	
	label{
		margin-left: 20px;
	}
	 .select{
	 	width: 250px;
	  	height: 33px;
	 	border: 1px solid #1F3D74;
	}
	.select option{
		height: 23px;
		font-size: 12px;
	}
	.ent{
		text-indent:0px;
		width: 100px;
		float: right;
		margin-right: 200px;
	}
	.updprice{
	margin-top: 20px;
	}
	.imgtable tbody tr:hover{
	background:#ffffff;
	}
</style>
</head>

<body style="min-width: 1155px;">
  <b class="han" style="display:none">${userlogin }</b>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index">首页</a></li>
    <li><a href="javascript:void(0)">客户缴费</a></li>
    </ul>
    </div> 

   <form class="form-search updprice">
  		<label style="margin-left: 80px">缴费名称：</label>
  		<select class="select select1">
  		<option selected="selected">---请选择---</option>
  		<c:forEach items="${price }" var="price">
  			<option>${price.pricename }</option>
  		</c:forEach>
  		</select>
  		<label>房屋号：</label>
  		<input  style="width: 250px;" disabled="disabled" placeholder="如：A0101 (必填)" class="bor" type="text"/>
  		<input class="borcost" type="hidden"/>
  		 <a class="enter ent addent">查找</a>
  <div  style="height: 40px;">
  	<label class="bori" style="color: red;margin-left: 880px;margin-top: -40px"></label>
  </div>
  </form>


<div class="charttab" style="display: none">
<div  style="height: 460px;width: 100%;">
 <table class="imgtable " style="width: 1155px;">
    <thead>
    <tr>
   	<th>缴费名称</th>
    <th>房屋名</th>
    <th>住户名</th>
    <th>应缴费用</th>
    <th>操作</th>
    </tr>
    </thead>
    <tbody class="price">
	    
    </tbody>
    </table>
  </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/paylist.js"></script></body>
</html>
