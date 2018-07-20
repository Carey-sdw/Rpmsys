<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>增加房屋</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/register.css" type="text/css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"  type="text/css">
  	  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style1.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/init.css" type="text/css">
 </head>
  <body>
  <body>
  <div class="place" style="font-size: 12px">
		<span>位置：</span>
		<ul class="placeul">
			<li><a style="color: #333" href="index">首页</a></li>
			<li><a style="color: #333" href="houselist">房屋管理</a></li>
			<li><a style="color: #333" href="javaScript:void(0)">增加房屋</a></li>
		</ul>
	</div>
  <div class="webregform" style="height: 100%; width: 100%;">
      <form method="post" id="cnmgdj" action="addhouse" class="reg_form_web">
          <p class="item_p">
              <label class="lbn">房间号<b>*</b></label>
              <span class="ipt_box">
                <input type="text" name="housename" data-tip="房屋名"
					autocomplete="off" value="${house.housename }" tabindex="4" class="ipt"/>
                        </span>
              <span class="prompt tops3 tip">
                            <i></i>
                            <b>如：A0101 (注!一经录入禁止修改)</b>
                        </span>
              <span class="error tip"></span>
              <span class="succ tip"></span>
          </p>
          <p class="item_p">
              <label class="lbn">几室<b>*</b></label>
              <span class="ipt_box">
                            <input type="text" name="room" data-tip="室" 
                            autocomplete="off" value="${house.room }" tabindex="4" class="ipt"/>
                        </span>
              <span class="prompt tops2 tip">
                            <i></i>
                            <b>如：1</b>
                        </span>
              <span class="error tip"></span>
              <span class="succ tip"></span>
          </p>
          <p class="item_p">
              <label class="lbn">几厅<b>*</b></label>
              <span class="ipt_box">
                  <input type="text" name="hall" data-tip="厅" maxlength="16" 
                  autocomplete="off" value="${house.hall }" tabindex="2" class="ipt"/>
                    </span>
              <span class="prompt tops2 tip">
                            <i></i>
                            <b>如：1</b>
                        </span>
              <span class="error tip"></span>
              <span class="succ tip"></span>
              <span id="pass_strength" class="pass_weak tip"></span>
          </p>
          <p class="item_p">
              <label class="lbn">几厨<b>*</b></label>
              <span class="ipt_box">
                   <input type="text" name="kitchen" data-tip="厨" autocomplete="off" 
                   value="${house.kitchen }" tabindex="5" class="ipt"/>
                        </span>
              <span class="prompt tops3 tip">
                            <i></i>
                            <b>如：1</b>
                        </span>
              <span class="error  tip">

                        </span>
              <span class="succ tip"></span>
          </p>
          <p class="item_p">
              <label class="lbn">几卫<b>*</b></label>
              <span class="ipt_box">
                 <input type="text" name="toilet" data-tip="卫" autocomplete="off" 
                 value="${house.toilet }" tabindex="6" class="ipt"/>
                        </span>
              <span class="prompt tops3 tip">
                            <i></i>
                            <b>如：1</b></span>
              <span class="error tip"></span>
              <span class="succ tip"></span>
          </p>

          <div class="js_china_captcha_box js_static_captcha"></div>
          <p class="item_p">
              <label class="lbn">面积<b>*</b></label>
              <span class="ipt_box">
                   <input type="text" name="acreage" value="${house.acreage }" 
                   data-tip="面积" autocomplete="off" tabindex="3" class="ipt"/>
                     </span>
              <span class="prompt tops3 tip">
                            <i></i>
                            <b>如：40</b></span>
              <span class="error tip"></span>
              <span class="succ tip"></span>
          </p>
             <p class="item_p">
              <label class="lbn">购价<b>*</b></label>
              <span class="ipt_box">
                    <input type="text" name="price" data-tip="购价" 
                    autocomplete="off" value="${house.price }" tabindex="6" class="ipt"/>
                     </span>
              <span class="prompt tops3 tip">
                            <i></i>
                            <b>如：3000</b></span>
              <span class="error tip"></span>
              <span class="succ tip"></span>
          </p>
         <p class="item_p">
              <label class="lbn">租金<b>*</b></label>
              <span class="ipt_box">
                            <input type="text" name="rent" data-tip="租金" autocomplete="off" value="" tabindex="6" class="ipt"/>
                        </span>
              <span class="prompt tops3 tip">
                            <i></i>
                            <b>如：1000(注！仅二手房可租)</b></span>
              <span class="error tip"></span>
              <span class="succ tip"></span>
          </p>
		<p style="margin-top: 12px;">
          	<label style="margin-left:140px;font-size: 14px;color:#000000;">有无阳台<b style="display: inline-block;padding-left: 6px;color: #cb0000;font-weight: 400;font-size: 16px;font-family: SimSun">*&nbsp;</b></label>
              <input type="radio" style="margin-top: -2px" name="balcony" id="yman" value="1"/>
              <label for="yman" style="color: #000000;font-size: 14px;margin:0px 10px 0px 0px;">&nbsp;有&nbsp;</label>
              <input type="radio" style="margin-top: -2px" name="balcony" checked="checked" id="ywoman" value="0"/>
              <label for="ywoman" style="color: #000000;font-size: 14px;">&nbsp;无</label>
          </p>
          
          <p class="item_p">
              <label class="lbn"></label>
              <a class="ipt_btn" href="javascript:void(0);">
                  <input type="button" class="btn_sub" id="summm" value="确定" tabindex="9"/>
              </a>
              <!--<input type="reset" class="btn_sub" id="resyh" value="取消" tabindex="9"/>-->
          </p>  
      </form>
      <div class="dialog">
	      	  <div class="d-header">验证消息:</div>
	      	  <div class="d-content">你输入的信息有误或内容不完善,请重新填写</div>
	      	  <div class="d-foot">
	      		<button class="close">确定</button>
	          </div>
 		  </div>
  </div>
  <script src="${pageContext.request.contextPath}/assets/js/addfw.js" type="text/javascript" charset="UTF-8"></script>
  </body>
</html>