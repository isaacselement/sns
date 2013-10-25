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
function showTopFans(){ 
        createXmlHttp();                                     //创建XMLHttpRequest对象
        xmlHttp.onreadystatechange = submitPostCallBack1;            
        xmlHttp.open("POST", "json/showTopFans.action", true);          //发送POST请求
        //设置POST请求体类型
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded"); 
        xmlHttp.send(null);     
        setTimeout("showMes()",800)//5秒后再次刷新数据库
}

//服务器响应后发送数据回来，展示到页面.
function submitPostCallBack1() {
	 if (xmlHttp.readyState == 4) {     
        var omessages = eval('(' + xmlHttp.responseText + ')');
        var TopFans = document.getElementById('TopFans');
        var smessages ='';
       for(var i = 0; i < omessages.users.length;) {
            smessages += (' <li><a class="fl1" href="javascript:;"><img  src="'+omessages.users[i].photo+'"  alt="" width="30" height="30"></a> <p>' + omessages.users[i].username + '</li>');i+=1;
             }
       TopFans.innerHTML = smessages;
   }
}