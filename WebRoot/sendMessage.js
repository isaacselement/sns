
var xmlHttp;                        //用于保存XMLHttpRequest对象的全局变量
var content;   //用于保存内容
var post_content;

//用于创建XMLHttpRequest对象
function createXmlHttp() {
    //根据window.XMLHttpRequest对象是否存在使用不同的创建方式
    if (window.XMLHttpRequest) {
       xmlHttp = new XMLHttpRequest();                  //FireFox、Opera等浏览器支持的创建方式
    } else {
       xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");//IE浏览器支持的创建方式
    }
}

//提交内容到服务器
function submitPost() {
	 post_content=document.getElementById("post_content");
	content = post_content.value; 
        createXmlHttp();                                     //创建XMLHttpRequest对象
        xmlHttp.onreadystatechange = submitPostCallBack;    //设置回调函数
        xmlHttp.open("POST", "json/jsonSaveMessage.action", true);         //发送POST请求
        //设置POST请求体类型
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlHttp.send("message.context=" +encodeURIComponent(content));          //发送包含一个参数的请求体
}

//获取发布成功的回调函数
function submitPostCallBack() {
    if (xmlHttp.readyState == 4) {
    	$.zxxbox.remind("发布成功,查看内容请刷新！", null, { delay: 620 });
       	$("#post_content").attr("value",'');//这里要将输入框清空
    	
    }
}







