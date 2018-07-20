<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>住户报修</title>
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>

<style type="text/css">
	.divs{
		height: 40px;
		width: 90%;
		margin-left: 50px;
		padding-top: 20px;
		float: left;
	}
	.div{
		height: 100px;
		width: 500px;
		padding-top: 20px;
		float: left;
	}
	.text{
		padding-left: 2px;
		width:400px;
		height:100px;
		border: 1px solid black;
	}
</style>
</head>

<body style="min-width: 1155px">
<div>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index">首页</a></li>
    <li><a href="javaScript:void(0)">住户报修</a></li>
    </ul>
    </div>
    
       
   <div class="toold">
    	<form class="form-search">  
			房屋名：<input class="cablehouselist" name="cablehouselist" type="text">  
			<button class="cablebtn" type="button" ><span>搜    索</span></button> 
			<a class="repaira" style="color: red;"></a>
		</form>
   </div>
 <table class="imgtable">
    	
    <thead>
    <tr>
    	<th></th>
    </tr>
    </thead>
    
</table>
  <form class="form-search">
  	<div class="divs" style="margin-top: 10px;">
  		<label>房屋编号：</label><input type="text" class="repair1" disabled="disabled" />
  	</div>
  	
  	<div class="divs">
  		<label>住户姓名：</label><input type="text" class="repair2" disabled="disabled" />
  	</div>
  	
  	<div class="divs">
  		<label>联系电话：</label><input type="text" class="repair3" disabled="disabled" />
  	</div>
  	
  	<div class="divs" style="width: 60px;padding-top: 60px;">
	  	<label>报修内容：</label>
	</div>
	<div class="div">
	  	<textarea name="a" class="text"></textarea>
  	</div>
  	
  	<div class="divs" style="padding-left: 60px;">
  		<a class="enter">确认报修</a>
  	</div>
  </form>
  </div>
  <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/addrepair.js"></script>
</body>
</html>