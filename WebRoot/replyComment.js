var replyCommentid;//回复评论
var addComment;

function createXmlHttp() {
    //根据window.XMLHttpRequest对象是否存在使用不同的创建方式
    if (window.XMLHttpRequest) {
       xmlHttp = new XMLHttpRequest();                  //FireFox、Opera等浏览器支持的创建方式
    } else {
    	var msxmls=["MSXML3","MSXML3","MSXML2","Microsoft"];
    	for(var i=o;i<msxmls.length;i++){
    		try {
    			xmlHttp = new ActiveXObject(msxmls[i]+".XMLHTTP");//IE浏览器支持的创建方式
    		}
    		catch(e){  }
    	}
    }
}

function toggleReply(targetid ,id){//回复评论
	replyCommentid=targetid;
	var addcomment= document.getElementById(replyCommentid); 
	$("#"+replyCommentid).slideToggle("normal");
	addcomment.innerHTML='<input type="text" id="addComment" class="addComment" maxlength="140" name="" size="60" height="40"/>'+
	'<input type="submit"  value="评论" onclick="submitReplyComment('+id+')"/>';
}

function submitReplyComment(commentid){
	addComment=document.getElementById("addComment");
	var context = addComment.value;
	createXmlHttp();//创建XMLHttpRequest对象
    xmlHttp.onreadystatechange = submitPostCallBack18;   //设置回调函数
    xmlHttp.open("POST", "json/jsonReplyCommet.action", true);         //发送POST请求
   //设置POST请求体类型
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
    xmlHttp.send("context="+encodeURIComponent(context)+"&commentid=" + commentid);    //发送包含一个参数的请求体	
}
function submitPostCallBack18() {
    if (xmlHttp.readyState == 4) {
    	$.zxxbox.remind("评论成功", null, { delay: 1000 });
    	$("#addComment").attr("value",'');//这里要将输入框清空
    	$("#"+replyCommentid).slideToggle("normal");
    }
}
