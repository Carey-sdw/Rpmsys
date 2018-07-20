/*
 * 获取input的焦点--显示当前的要求  再input内容判断是否为空 -- 隐藏要求信息 显示错位信息
 * 获取input的焦点是 判断是否有类名inp_box_err
 * */

var errInfo = {
    "0" :"房屋名不能为空",
    "1" :"",
    "2" :"",
    "3" :"",
    "4" :"",
    "5" :"建筑面积不为空",
    "6" :"购价不为空",
    "7" :""
};
var errData = {
	"0" :"房屋名有误",
	"1" :"室数不符合常理",
    "2" :"厅数不符合常理",
    "3" :"厨数不符合常理",
    "4" :"卫数不符合常理",
    "5" :"厅建筑面积不符合常理",
    "6" :"售价不符合常理",
    "7" :"租金不符合常理"
}
var reg =[
    "^[a-zA-Z][0-9]{4}$", //姓名
    "^$|^[0-9]$",//室
    "^$|^[0-9]$", //厅
    "^$|^[0-9]$",  //厨
    "^$|^[0-9]$",  //卫
    "^[1-9][0-9]{1,3}$|[.][0-9]{1,2}$",//面积
    "^[1-9][0-9]{2,4}$|[.][0-9]{1,2}$", // 售价
    "^$|^[1-9][0-9]{2,4}$|[.][0-9]{1,2}$" // 租金
]
var flag = false;
//获取标签
var oP = document.getElementsByClassName("item_p"),
   oInput = document.getElementsByClassName("ipt"),
   oSpan = document.getElementsByClassName("ipt_box"),
   oError = document.getElementsByClassName("error"),
   oSucce = document.getElementsByClassName("succ"),
   oPormpt = document.getElementsByClassName("prompt");
for (var i = 0; i < oInput.length; i++) {
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
           if(""== this.value&&(i==0||i==5||i==6)){
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
var oSubmit = document.getElementById("summm");
var froms = window.document.getElementById("cnmgdj");
var oDialog = document.getElementsByClassName("dialog")[0];
var oClose = document.getElementsByClassName("close")[0];
oSubmit.onclick = function(){
	for(var i = 0; i < oInput.length; i++){
		if(oInput[i].value==""&&(i==0||i==5||i==6)){
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
var $oInput=$(oInput[0]);
var $oError=$(oError[0]);
$oInput.blur(function (){
	var house=$oInput.val().trim();
	if(house!=""){
	var rep=$.ajax({  
        type: "POST",  
        url: "addhouses",  
        data:{"house":house},
    	success:function( data ){
    		if(data=="1"){
    			 oError[0].innerHTML = "<i></i><b>"+ "房间已存在" +"<b>";
                 oError[0].style.setProperty("display","inline-block");
                 flag = false;
    		}
    	}
	});  
	}
})
