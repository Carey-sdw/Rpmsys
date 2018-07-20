<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>添加住户</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/register.css"
	type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style1.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/init.css"
	type="text/css">
</head>
<body>
	<div class="place" style="font-size: 12px">
		<span>位置：</span>
		<ul class="placeul">
			<li><a style="color: #333" href="index">首页</a></li>
			<li><a style="color: #333" href="imglist">住户管理</a></li>
			<li><a style="color: #333" href="javascript:void(0);">添加住户</a></li>
		</ul>
	</div>

	<div class="webregform" style="height: 100%; width: 100%;">
		<form method="post" id="cnmlgb" action="adduser" class="reg_form_web">
			<p class="item_p">
				<label class="lbn">真实姓名<b>*</b></label> <span class="ipt_box">
					<input type="text" name="username" data-tip="真实姓名"
					autocomplete="off" value="" tabindex="4" class="ipt" />
				</span> <span class="prompt tops3 tip"> <i></i> <b>请填写您的真实姓名</b>
				</span> <span class="error tip"></span> <span class="succ tip"></span>
			</p>
			<p class="item_p">
				<label class="lbn">手机号码<b>*</b></label> <span class="ipt_box">
					<input type="text" name="telephone" data-tip="手机号码"
					autocomplete="off" value="" tabindex="4" class="ipt" />
				</span> <span class="prompt tops2 tip"> <i></i> <b>输入您的手机号</b>
				</span> <span class="error tip"></span> <span class="succ tip"></span>
			</p>
			<p class="item_p">
				<label class="lbn">房屋地址<b>*</b></label> <span class="ipt_box">
					<input type="text" name="house_name"  readonly="readonly" value="${house_name }" maxlength="16"
					autocomplete="off" tabindex="2" class="ipt" />
				</span> <span class="prompt tops2 tip"> <i></i> <b>禁止修改</b>
				</span> <span class="error tip"></span> <span class="succ tip"></span> <span
					id="pass_strength" class="pass_weak tip"></span>
			</p>
			<p style="margin-top: 16px;">
				<label style="margin-left: 140px; font-size: 14px; color: #000000;">入住类型<b
					style="display: inline-block; padding-left: 6px; color: #cb0000; font-weight: 400; font-size: 16px; font-family: SimSun">*&nbsp;</b>
					<input type="radio" style="margin-top: -2px" name="occupancy_type" id="man"
					value="业主" checked="checked" /> 
					<label for="man" style="color: #000000; font-family: '微软雅黑'; font-size: 14px;">
						业主&nbsp;&nbsp;
					</label> <input type="radio" style="margin-top: -2px"
					name="occupancy_type" id="woman" value="租户" /> <label for="woman"
					style="color: #000000; font-family: '微软雅黑'; font-size: 14px;">
						租户</label>
				</label>
			</p>

			<p class="item_p">
				<label class="lbn">身份证号码<b>*</b></label> <span class="ipt_box">
					<input type="text" name="idcard" data-tip="身份证号码"
					autocomplete="off" value="" tabindex="5" class="ipt" />
				</span> <span class="prompt tops3 tip"> <i></i> <b>证件号码必须与证件姓名相符</b>
					<b>作为账号归属凭证</b> <b>证件号码不能修改，请认真填写</b>
				</span> <span class="error  tip"> </span> <span class="succ tip"></span>
			</p>
			<p class="item_p">
				<label class="lbn">入住人数<b>*</b></label> <span class="ipt_box">
					<input type="text" name="occupancy_number" data-tip="入住人数" autocomplete="off"
					value="" tabindex="6" class="ipt" />
				</span> <span class="prompt tops3 tip"> <i></i> <b>认真填写入住人数</b></span> <span
					class="error tip"></span> <span class="succ tip"></span>
			</p>
			<div class="js_china_captcha_box js_static_captcha"></div>
			<p class="item_p">
				<label class="lbn">描述<b>*</b></label> <span class="ipt_box">
					<input type="text" name="describe" data-tip="描述"
					autocomplete="off" tabindex="3" class="ipt" />
				</span>
			</p>
			<p class="item_p">
				<label class="lbn"></label> <a class="ipt_btn"
					href="javascript:void(0);"> <input type="button"
					class="btn_sub" id="subbbb" value="确定" tabindex="9" />
				</a>
				<!--<input type="reset" class="btn_sub" id="resyh" value="取消" tabindex="9"/>-->
			</p>
		<input type="hidden" name="registration_time" value="${registration_time }"/>
		<input type="hidden" name="from_id" value="${from_id }"/>
		</form>
		<div class="dialog">
			<div class="d-header">验证消息:</div>
			<div class="d-content">你输入的信息有误或内容不完善,请重新填写</div>
			<div class="d-foot">
				<button class="close">确定</button>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/assets/js/register.js" type="text/javascript"
		charset="UTF-8"></script>
</body>
</html>