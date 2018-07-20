<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>住户管理</title>
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
    		height: 40px;
    		font-size: 14px;
    		border: 0.1px solid #E9E9E9;
    	}
    	.cen{
    		margin: 0px;
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
    </style>
	</head>
	<body>
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
		    <li><a href="index">首页</a></li>
		    <li><a href="imglist">住户资料</a></li>
		    <li><a href="javaScript:void(0)">住户管理</a></li>
		    </ul>
	    </div>
		<div class="panel panel-default" style="width:100%;">
		<div class="panel-heading">
			<div class="title text-center" >
				<p style="font-size: 16px;font-weight: bold;">按原有格式认真修改需要修改的信息<p>
			</div>
		</div>
		<div class="panel-body" style="width:100%;">
			<ul class="info">
				<li style="width: 250px;margin-left: 0px;">
					<c:if test="${not empty user.photo_url }">
					<img src="${user.photo_url }" width="100%" height="100%"/>
					</c:if>
					<c:if test="${empty user.photo_url }">
					<img src="${pageContext.request.contextPath}/assets/images/user/t00.png" width="250px" height="335px"/>
					</c:if>
					<form action="upphoto?id=${user.user_id }" method="post" class="file-box" enctype="multipart/form-data">
						<label class="lltv enter cen">选择头像</label><input type="file" name="photo_url" class="file-btn" />
						<button class="btns"><a href="javaScript:void(0)" class="enter cen">确认上传</a></button>
					</form>
				</li>
				<li style="width:800px;margin-left: 30px;">
					<table class="table table-striped">
						<tr>
							<td>姓名</td>
							<td>${user.username }</td>
							<td>房屋名</td>
							<td class="nos">${user.house_name }</td>
						</tr>
						<tr>
							<td>身份证</td>
							<td>${user.idcard }</td>
							<td>手机号</td>
							<td>${user.telephone }</td>
						</tr>
						<tr>
							<td>入住类型</td>
							<td>${user.occupancy_type }</td>
							<td>入住人数</td>
							<td>${user.occupancy_number }</td>
						</tr>
						<tr>
							<td>登记时间</td>
							<td>${user.registration_time }</td>
							<c:if test="${user.occupancy_type=='租户' }">
							<td>到期时间</td>
							<td>${user.time_e }</td>
							</c:if>
							<c:if test="${user.occupancy_type=='业主' }">
							<td>到期时间</td>
							<td>无</td>
							</c:if>
						</tr>
						<tr>
							<td colspan="4" style="text-align: center;">描述</td>
						</tr>
						<tr>
							<td colspan="4" >
								${user.describe }
							</td>
						</tr>
						<tr>
							<td colspan="4" style="text-align: center;">
								<button><a class="enter cen sen">确认修改</a></button>
							</td>
						</tr>
						<tr>
							<td class="user_id" style="display: none;">	
							${user.user_id }
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/userdetails.js"></script>
	</body>
</html>
