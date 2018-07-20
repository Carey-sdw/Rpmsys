<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>盛世一城管理系统</title>
	<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
	<script type="text/javascript">
		$(function() {
			//顶部导航切换
			$(".nav li a").click(function() {
				$(".nav li a.selected").removeClass("selected")
				$(this).addClass("selected");
			})
		})

		$(function() {
			//lift导航切换
			$(".menuson li").click(function() {
				$(".menuson li.active").removeClass("active")
				$(this).addClass("active");
			});

			$('.title').click(function() {
				var $ul = $(this).next('ul');
				$('dd').find('ul').slideUp();
				if($ul.is(':visible')) {
					$(this).next('ul').slideUp();
				} else {
					$(this).next('ul').slideDown();
				}
			});
		})
	</script>
</head>

<body scoll=no>
	<!--top-->
	<div style="height:88px;width:1365px;overflow:hidden;background:url(${pageContext.request.contextPath}/assets/images/topbg.gif) repeat-x;">
		<div class="topleft">
			<a href="main" target="_parent"><img src="${pageContext.request.contextPath}/assets/images/logo.png" style="margin-top: 15px;" /></a>
		</div>
		<ul class="nav">
			<li>
				<a href="main" target="_parent" class="selected"><img src="${pageContext.request.contextPath}/assets/images/icon01.png" />
					<h2>首页</h2></a>
			</li>
			<li>
				<a href="usertable" target="rightFrame"><img src="${pageContext.request.contextPath}/assets/images/icon02.png" />
					<h2>住户资料</h2></a>
			</li>
			<li>
				<a href="housetable" target="rightFrame"><img src="${pageContext.request.contextPath}/assets/images/icon03.png" />
					<h2>楼房资料</h2></a>
			</li>
			<li>
				<a href="costtable"  target="rightFrame"><img src="${pageContext.request.contextPath}/assets/images/icon04.png" />
					<h2>本月账单</h2></a>
			</li>
			<li>
				<a href="boringtable" target="rightFrame"><img src="${pageContext.request.contextPath}/assets/images/icon05.png" />
					<h2>物料详情</h2></a>
			</li>
			<li>
				<a href="pricelist" target="rightFrame"><img src="${pageContext.request.contextPath}/assets/images/icon06.png" />
					<h2>收费设置</h2></a>
			</li>
		</ul>

		<div class="topright">
			<ul>
				<li><span><img src="${pageContext.request.contextPath}/assets/images/help.png" title="帮助"  class="helpimg"/></span>
					<a href="javaScript:void(0)">帮助</a>
				</li>
				<li>
					<a href="javaScript:void(0)">关于</a>
				</li>
				<li>
					<a href="login" target="_parent">退出</a>
				</li>
			</ul>
			<div class="user">
				<span>${userlogin }</span>
				<i>消息</i>
				<b>${copmnumber }</b>
			</div>
		</div>
	</div>

	<!--lift-->
	<div style="width:187px;height:548px;float:left;background:#f0f9fd;">
		<div class="lefttop"><span></span>基本功能</div>

		<dl class="leftmenu" style="display:display;">

			<dd>
				<div class="title">
					<span><img src="${pageContext.request.contextPath}/assets/images/leftico05.png" /></span>基本信息管理
				</div>
				<ul class="menuson" style="height:60px;">
					<li><cite></cite>
						<a href="imglist" target="rightFrame">住户资料管理</a><i></i></li>
					<li><cite></cite>
						<a href="houselist" target="rightFrame">楼房资料管理</a><i></i></li>
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="${pageContext.request.contextPath}/assets/images/leftico01.png" /></span>收费管理
				</div>
				<ul class="menuson" style="height:60px;">
					<li><cite></cite>
						<a href="pricelist" target="rightFrame">抄表录入</a><i></i></li>
					<li><cite></cite>
						<a href="paylist" target="rightFrame">客户缴费</a><i></i></li>
				</ul>
			</dd>

			<dd>
				<div class="title"><span><img src="${pageContext.request.contextPath}/assets/images/leftico03.png" /></span>物料管理</div>
				<ul class="menuson" style="height:60px;">
					<li><cite></cite>
						<a href="boringlist" target="rightFrame">物品入库</a><i></i></li>
					<li><cite></cite>
						<a href="boringoutlist" target="rightFrame">物品出库</a><i></i></li>
				</ul>
			</dd>

			<dd>
				<div class="title">
					<span><img src="${pageContext.request.contextPath}/assets/images/leftico02.png" /></span>报修与反馈
				</div>
				<ul class="menuson" style="height:60px;">
					<li><cite></cite>
						<a href="repairlist" target="rightFrame">报修管理</a><i></i></li>
					<li><cite></cite>
						<a href="complaintlist" target="rightFrame">投诉管理</a><i></i></li>
				</ul>
			</dd>

			<dd>
				<div class="title"><span><img src="${pageContext.request.contextPath}/assets/images/leftico04.png" /></span>报表</div>
				<ul class="menuson" style="height:210px;">
					<li><cite></cite>
						<a href="usertable" target="rightFrame">住户信息</a><i></i></li>
					<li><cite></cite>
						<a href="housetable" target="rightFrame">房屋信息</a><i></i></li>
					<li><cite></cite>
						<a href="costtable" target="rightFrame">账单明细</a><i></i></li>
					<li><cite></cite>
						<a href="boringtable" target="rightFrame">入库</a><i></i></li>
					<li><cite></cite>
						<a href="boringouttable" target="rightFrame">出库</a><i></i></li>
					<li><cite></cite>
						<a href="repairtable" target="rightFrame">维修</a><i></i></li>
					<li><cite></cite>
						<a href="complainttable" target="rightFrame">举报</a><i></i></li>
				</ul>
			</dd>
		</dl>
		<dl class="leftmenu" style="display:none;">

			<dd>
				<div class="title">
					<span><img src="${pageContext.request.contextPath}/assets/images/leftico01.png" /></span>我的功能
				</div>
				<ul class="menuson">
					<li><cite></cite>
						<a href="index.html">我的资料</a><i></i></li>
					<li><cite></cite>
						<a href="imgtable.html">房屋资料</a><i></i></li>
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="${pageContext.request.contextPath}/assets/images/leftico02.png" /></span>报表与费用
				</div>
				<ul class="menuson">
					<li><cite></cite>
						<a href="form.html" target="rightFrame">水,电,气费用</a><i></i></li>
					<li><cite></cite>
						<a href="form.html" target="rightFrame">其他费用</a><i></i></li>
					<li><cite></cite>
						<a href="imglist.html" target="rightFrame">水,电,气报表</a><i></i></li>
					<li><cite></cite>
						<a href="imglist.html" target="rightFrame">其他报表</a><i></i></li>
				</ul>
			</dd>

			<dd>
				<div class="title"><span><img src="${pageContext.request.contextPath}/assets/images/leftico03.png" /></span>投诉与维修</div>
				<ul class="menuson">
					<li><cite></cite>
						<a href="imglist1.html" target="rightFrame">我要投诉</a><i></i></li>
					<li><cite></cite>
						<a href="tools.html" target="rightFrame">我要报修</a><i></i></li>
				</ul>
			</dd>

			<dd>
				<div class="title">
					<span>
		<img src="${pageContext.request.contextPath}/assets/images/leftico04.png" />
	</span>其他
				</div>
				<ul class="menuson">
					<li><cite></cite>
						<a href="filelist.html" target="rightFrame">我的停车场</a><i></i></li>
					<li><cite></cite>
						<a href="tab.html" target="rightFrame">小区新闻</a><i></i></li>
				</ul>
			</dd>
		</dl>
	</div>

		<!--right-->
<iframe src="index"style="height:548px;width:1175px;float: left;overflow: hidden;position: absolute;left:187px;top: 88px;" name="rightFrame" id="rightFrame" title="rightFrame" />
	
</body>

</html>