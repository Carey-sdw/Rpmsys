<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>房屋信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"  type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
    <style>
    	body{
    		user-select:none;
    	}
    	ul.info li {
    		float: left;
    	}
    	.panel{
    		margin-bottom:0;
    	}    
    	p{
    		margin: 5px;
    	}
    	table tr:first-child td{
    		width: 19%;
    	}
    	table tr:first-child td:nth-child(2n){
    		width: 31%;
    	}
    	table tr td{
    		height: 50px;
    		font-size: 15px;
    		border: 0.1px solid #E9E9E9;
    	}
    	.cen{
    		margin: 0px;
    	}
    	.sen{
    		margin-left: 150px;
    		margin-top: -20px;
    	}
		.file-btn{
		    filter:alpha(opacity=0);
			-moz-opacity:0;
			-khtml-opacity: 0;
			opacity:0;
			margin-top: -31px;
			margin-left: 19px;
			height: 32px;
			width: 90px;
		} 
		.btns{
			margin-left: 120px;
			margin-top: -31px;
		}
		.lltv{
			width: 90px;
			margin-top: 5px;
			margin-left: 20px;
		}
		.houc{
			border-color: f1f6f7;
		}
    </style>
</head>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="index">首页</a></li>
	    <li><a href="houselist">房屋管理</a></li>
	    <li><a href="javaScript:void(0)">房屋信息</a></li>
	    </ul>
    </div>
	<div class="panel panel-default" style="width:100%;">
	<div class="panel-heading">
		<div class="title text-center" >
			<p style="font-size: 16px;font-weight: bold;">按原有格式认真修改需要修改的信息</p>
		</div>
	</div>
	<div class="panel-body" style="width:100%;">
		<ul class="info">
			<li style="width:1050px;margin-left: 0px;">
				<table class="table table-striped">
					<tr>
						<td>房屋名</td>
						<td class="nos">${house.housename }</td>
						<td>屋主</td>
						<td class="nos">
				<c:if test="${empty house.user.username }"></c:if>
	    		<c:if test="${not empty house.user.username }">
	    		${house.user.username }
	    		</c:if>
	    				</td>
					</tr>
					<tr>
						<td>室</td>
						<td>${house.room }</td>
						<td>厅</td>
						<td>${house.hall }</td>
					</tr>
					<tr>
						<td>厨</td>
						<td>${house.kitchen}</td>
						<td>卫</td>
						<td>${house.toilet}</td>
					</tr>
					<tr>
						<td>面积</td>
						<td>${house.acreage }</td>
						<td>购价</td>
						<td>${house.price }</td>
					</tr>
					<tr>
						<td>租金</td>
						<td>${house.rent}
		    			</td>
						<td>有无阳台(0/有,1/无)</td>
						<td>${house.balcony}</td>
					</tr>
					<tr>
	    			<td>是否二手房(0/是,1/否)</td>
	    			<td colspan="3">${house.t_types}</td>
	    			
					</tr>
					
					<tr>
						<td colspan="4" style="text-align: center;">
							<button><a class="enter cen">确认修改</a></button>
						</td>
					</tr>
					<tr>
						<td class="house_id" style="display: none;">	
						${house.house_id }
						</td>
						<td class="upreturn" colspan="4" style="text-align: center;color: red;">
							
						</td>
					</tr>
				</table>
			</li><!-- style="display: none;"-->
		</ul>
		
	</div>	
</div>
<script type="text/javascript">
$('.table tbody td:odd').attr("contentEditable","true");
$('.nos').attr("contentEditable","false");
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/housedetail.js"></script>
</body>
</html>
