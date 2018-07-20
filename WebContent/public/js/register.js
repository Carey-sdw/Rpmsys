/*
 * 获取input的焦点--显示当前的要求  再input内容判断是否为空 -- 隐藏要求信息 显示错位信息
 * 获取input的焦点是 判断是否有类名inp_box_err
 * */

var errInfo = {
    "0" :"真实姓名不能为空",
    "1" :"手机号码不能为空",
    "2" :"住户地址不能为空",
    "3" :"身份证号码不能为空",
    "4" :"入住人数不能为空"
};
var errData = {
	"0" :"真实姓名有误",
	"1" :"手机号码不符合要求",
    "2" :"住户地址不符合要求",
    "3" :"身份证号码有误",
    "4" :"入住人数不合法"
}
var reg =[
     "^[a-zA-Z\u4e00-\u9fa5]{0,}$", //姓名
     "^[1][3,4,5,7,8][0-9]{9}$",//手机号
     "^[A-Za-z][0-9]{4}$", //房
     "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$",  //身份证
     "^[1-9]{1,2}$" // 人数 
]
var flag = false;
//获取标签
var oP = document.getElementsByClassName("item_p"),
    oInput = document.getElementsByClassName("ipt"),
    oSpan = document.getElementsByClassName("ipt_box"),
    oError = document.getElementsByClassName("error"),
    oSucce = document.getElementsByClassName("succ"),
    oPormpt = document.getElementsByClassName("prompt");
for (var i = 0; i < oInput.length-1; i++) {
    //闭包
    (function (i) {
        //获取Input 的焦点
        oInput[i].onfocus = function () {
            // p标签层级
            oP[i].style.setProperty("z-index","1");
            // 当前input输入的要求
            oPormpt[i].style.setProperty("display","inline-block");
            oPormpt[i].style.setProperty("z-index","100");
            // 错误信息
            oError[i].style.setProperty("display","none");
            //input焦点样式
            oSpan[i].classList.add("ipt_box_foc");
            // 判断input是否有值 如果有 移除input边框错误样式
            /\err?/.test(oSpan[i].className) && oSpan[i].classList.remove("ipt_box_err");
        };
        // input移除焦点
        oInput[i].onblur = function () {
            //移除
            oSpan[i].classList.remove("ipt_box_foc");
            oPormpt[i].style.setProperty("display","none");
            // 判断当前input值 ，如果没有 显示错误信息
            if(""== this.value ){
                oSpan[i].classList.add("ipt_box_err");
                oError[i].innerHTML = "<i></i><b>"+ errInfo[i] +"<b>";
                oError[i].style.setProperty("display","inline-block");
                oP[i].style.setProperty("z-index","0");
                flag = false;
            }else{
            	var re=new RegExp(reg[i]);
            	if(re.test(this.value)){
        			//不做提示
        			flag = true;
            	}else{
            		oError[i].innerHTML = "<i></i><b>"+ errData[i] +"<b>";
                	oError[i].style.setProperty("display","inline-block");
                	flag = false;
            	}
            }
        }
    })(i);
};
var oSubmit = document.getElementById("subbbb");
var froms = window.document.getElementById("cnmlgb");
var oDialog = document.getElementsByClassName("dialog")[0];
var oClose = document.getElementsByClassName("close")[0];
oSubmit.onclick = function(){
	for(var i = 0; i < oInput.length-1; i++){
		if(oInput[i].value==""){
			flag = false;
			break;
		}
	}
	if(flag){
		// 验证成功，跳转
		froms.submit();
	}else{
		// 验证失败,
		oDialog.style.display = "block";
	}
}
oClose.onclick = function(){
	oDialog.style.display = "none";
}
/*console.log(flag)*/
