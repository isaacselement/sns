
var xmlHttp;                        //用于保存XMLHttpRequest对象的全局变量
//var username;                       //用于保存姓名
//var title;                          //用于保存标题
//var content;                        //用于保存内容
//var threadid;                       //用于保存主题编号
var list;
//用于创建XMLHttpRequest对象
function createXmlHttp() {
    //根据window.XMLHttpRequest对象是否存在使用不同的创建方式
    if (window.XMLHttpRequest) {
       xmlHttp = new XMLHttpRequest();                  //FireFox、Opera等浏览器支持的创建方式
    } else {
       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");//IE浏览器支持的创建方式
    }
}

//提交请求到服务器
function showMes(){
        createXmlHttp();                                     //创建XMLHttpRequest对象
        xmlHttp.onreadystatechange = submitPostCallBack;            
        xmlHttp.open("POST", "json/showMessages.action", true);           //发送POST请求
        //设置POST请求体类型
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlHttp.send(null);     
   //     setTimeout("showMes()",8000)//8秒后再次刷新数据库
}

//服务器响应后发送数据回来，展示到页面.
function submitPostCallBack() {
	 if (xmlHttp.readyState == 4) {     
        var omessages = eval('(' + xmlHttp.responseText + ')');
        var slider = document.getElementById('slider');
        var smessages ='';
       for(var i = 0; i < omessages.messages.length;) {
            smessages += (' <li><a class="fl" href="javascript:;"><img  src="'+omessages.messages[i].user.photo+'"  alt="" width="30" height="30"></a> <p>' + omessages.messages[i].context + '</li>');i+=1;
       }
       slider.innerHTML = smessages;
   }
}

//检查表单是否内容已填写完毕
//function checkForm() {
 //   if (username == "") {
 //       alert("请填写姓名");
 //       return false;
  //  } else if (title == "") {
  //      alert("请填写标题");
  //      return false;
 //   } else if (content == "") {
  //      alert("请填写内容");
 //       return false;
  //  }
 //   return true;
//}
