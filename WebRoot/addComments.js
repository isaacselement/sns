var xmlHttp;                        //用于保存XMLHttpRequest对象的全局变量
var saveComment;
var addComment;
//var commentNum;//一条评论对应微博的ID
var commentsByMessageid;
var commentsByForwardid;
var deleteMessageid;//删除一条微博
var deleteForwardid;//删除一条微博
var addFollowingid;//关注别人
var forwardMessageid;//转发的
var forwardForwardid;//转发要转发的信息
var collectMessageid;
var collectForwardid;

var tips=new String("输入评论");
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

function toggle1(targetid,id){
	commentsByMessageid=targetid;
     if (document.getElementById){
    	var target="."+targetid;
         $(target).slideToggle("normal");
         addComments(id);
     }
}

function toggle2(targetid,id){
	commentsByForwardid=targetid;
     if (document.getElementById){
    	 var target="."+targetid;
         $(target).slideToggle("normal");
         addCommentsByForwardid(id);
     }
}

function toggle3(targetid,id){//删除一条微博
	deleteMessageid=targetid;
    if (document.getElementById){
        deleteMessage(id);
    }
}

function toggle4(targetid,id){//删除一条转发
	deleteForwardid=targetid;
	 if (document.getElementById){
	deleteForward(id);
	 }
}



function toggleForward(targetid,id){//转发微博处理
	forwardMessageid=targetid;
	var obj = $(".span"+targetid);var obj2=$(".spanUser"+targetid);
	var messageContext="@"+obj2.html()+":"+obj.html();//得到微博的内容
	var allDialogs = [];
	var dialog = new Boxy("<div><div><p>"+
		messageContext+"</p></div><div><textarea id='forwardContext' class='' style='width:100%;height:90px;'/></div>"+
		"<div align='center'><input type='submit' name='a' id='a' value='转发' onclick='submitForwardToMessage("+id+",this)'/>"+
		"<input type='submit' name='a' id='a' value='取消' onclick='Boxy.get(this).hide(); return false'/></div></div>",$.extend({title: "转发框"}, {modal:true} || {}));
	allDialogs.push(dialog);
	allDialogs[allDialogs.length-1].tween(400,300);
}

function toggleForwardTofor(targetid,id){
	forwardForwardid=targetid;
	var obj = $(".span"+targetid);var obj2=$(".spanForwarder"+targetid);
	var forwardcontext=$(".forwardContext"+targetid).html();
	var forwardUser=$(".forwardUser"+targetid).html()+":";
	var messageContext=obj2.html()+":"+obj.html();//得到微博的内容
	var allDialogs = [];
	var dialog = new Boxy("<div><div><p>"+
		messageContext+"</p></div><div><textarea id='forwardContext' class='' style='width:100%;height:90px;'>"+"//@"+forwardUser+forwardcontext+"</textarea></div>"+
		"<div align='center'><input type='submit' value='转发' onclick='submitForwardToForward("+id+",this)'/>"+
		"<input type='submit' value='取消' onclick='Boxy.get(this).hide(); return false'/></div></div>",$.extend({title: "转发框"}, {modal:true} || {}));
	allDialogs.push(dialog);
	allDialogs[allDialogs.length-1].tween(400,300);
}

function addComments(commentId){//根据微博ID得到评论集
	 	createXmlHttp();                                      //创建XMLHttpRequest对象
        xmlHttp.onreadystatechange = submitPostCallBack1;    //设置回调函数
        xmlHttp.open("POST", "json/jsonAddCommets.action", true);         //发送POST请求
       //设置POST请求体类型
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
        xmlHttp.send("messageid=" + commentId);    //发送包含一个参数的请求体	}
}

function addCommentsByForwardid(forwardId){//根据转发ID得到评论集
	 	createXmlHttp();                                   //创建XMLHttpRequest对象
        xmlHttp.onreadystatechange = submitPostCallBack2;    //设置回调函数
        xmlHttp.open("POST", "json/jsonAddCommentsByForwardid.action", true);         //发送POST请求
       //设置POST请求体类型
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
        xmlHttp.send("forwardid=" + forwardId);   //发送包含一个参数的请求体	}
}

function submitForwardToMessage(messageid,tag){
	Boxy.get(tag).hide();
	var addForward=document.getElementById("forwardContext");
	var saveForward=addForward.value;
	createXmlHttp();//创建XMLHttpRequest对象
	xmlHttp.onreadystatechange = submitPostCallBack7;  //设置回调函数
    xmlHttp.open("POST", "json/jsonSaveForward.action", true);         //发送POST请求
    //设置POST请求体类型
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8"); 
    xmlHttp.send("forwardToMessage.comment="+encodeURIComponent(saveForward)+"&commentToMessageid="+messageid);       //发送包含一个参数的请求体 
}

function submitPostCallBack7() {
    if (xmlHttp.readyState == 4) {
    	$.zxxbox.remind("转发成功", null, { delay: 1020 });
    }
}
function submitForwardToForward(forwardid,tag){
	Boxy.get(tag).hide();
	var addForward=document.getElementById("forwardContext");
	var saveForward=addForward.value;
	createXmlHttp();//创建XMLHttpRequest对象
	xmlHttp.onreadystatechange = submitPostCallBack8;  //设置回调函数
    xmlHttp.open("POST", "json/jsonSaveForwardToForward.action", true);         //发送POST请求
    //设置POST请求体类型
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8"); 
    xmlHttp.send("forwardToMessage.comment=" + encodeURIComponent(saveForward)+"&commentToMessageid="+forwardid);       //发送包含一个参数的请求体  
}
function submitPostCallBack8() {
    if (xmlHttp.readyState == 4) {
    	$.zxxbox.remind("转发成功", null, { delay: 1020 });
    }
}

function submitComment(messageid){
	addComment=document.getElementById("addComment");
	saveComment = addComment.value;
	createXmlHttp();//创建XMLHttpRequest对象
    xmlHttp.onreadystatechange = submitPostCallBack3;   //设置回调函数
    xmlHttp.open("POST", "json/jsonSaveComment.action", true);         //发送POST请求
    //设置POST请求体类型
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8"); 
    xmlHttp.send("commentToMessage.context=" +encodeURIComponent(saveComment)+"&commentToMessageid="+messageid);         //发送包含一个参数的请求体  
}
function submitPostCallBack3() {
    if (xmlHttp.readyState == 4) {
    	$.zxxbox.remind("评论成功", null, { delay: 1020 });
    	$("#addComment").attr("value",'');//这里要将输入框清空
    }
}

function submitCommentByForward(forwardid){
	addComment=document.getElementById("addCommentByForwardid");
	saveComment = addComment.value; 
	createXmlHttp();//创建XMLHttpRequest对象
    xmlHttp.onreadystatechange = submitPostCallBack4;   //设置回调函数
    xmlHttp.open("POST", "json/jsonSaveCommentByForwardid.action", true);         //发送POST请求
    //设置POST请求体类型
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8"); 
    xmlHttp.send("commentToForward.context=" + encodeURIComponent(saveComment)+"&commentToMessageid="+forwardid);         //发送包含一个参数的请求体  
}
function submitPostCallBack4() {
    if (xmlHttp.readyState == 4) {
    	$.zxxbox.remind("评论成功", null, { delay: 1020 });
       	$("#addCommentByForwardid").attr("value",'');//这里要将输入框清空
    }
}

function deleteMessage(messageid){
	Boxy.confirm("确定要删除这条微博？", function() {
	createXmlHttp();//创建XMLHttpRequest对象
    xmlHttp.onreadystatechange = submitPostCallBack5;   //设置回调函数
    xmlHttp.open("POST", "json/jsonDeleteMessage.action", true);         //发送POST请求
    //设置POST请求体类型
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8"); 
    xmlHttp.send("deleteMessageid="+messageid);         //发送包含一个参数的请求体  
    }, {title: "提示信息"});return false;
}
function deleteForward(forwardid){
	Boxy.confirm("确定要删除这条转发信息？", function() {
	createXmlHttp();
	 xmlHttp.onreadystatechange = submitPostCallBack6;   //设置回调函数
	 xmlHttp.open("POST", "json/jsonDeleteForward.action", true);         //发送POST请求
	 //设置POST请求体类型
	 xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8"); 
	 xmlHttp.send("deleteMessageid="+forwardid);         //发送包含一个参数的请求体  
	}, {title: "提示信息"});return false;
}

function submitPostCallBack5(){
	if (xmlHttp.readyState == 4) {
		$.zxxbox.remind("删除成功", null, { delay: 1020 });
    	target=document.getElementById(deleteMessageid);//得到标签
    	$("#mes"+deleteMessageid).attr("style",'display: none;');
	}
}

function submitPostCallBack6(){
	if (xmlHttp.readyState == 4) {
		$.zxxbox.remind("删除成功", null, { delay: 1020 });
    	target=document.getElementById(deleteForwardid);//得到标签
    	$("#for"+deleteForwardid).attr("style",'display: none;');
	}
}

function submitPostCallBack1() {//异步处理返回微博ID到页面
    if (xmlHttp.readyState == 4) {
    var ocomments=eval('(' + xmlHttp.responseText + ')');
      var addcomments= document.getElementById(commentsByMessageid);
	  var scomments='<table width="87%" height="97" border="0" align="center" style="background-image: url(images/commentsBackground.png); text-align: left;">'+
	  '<tr align="left" valign="top"><td  valign="top" ><input type="text" id="addComment" class="addComment" maxlength="140" name="" size="60" height="40"/></td><td align="right" valign="top">'+
	  '<input type="submit"  value="评论" onclick="submitComment('+ocomments.messageid+')"/></td></tr>';
	  for(var i=0;i<ocomments.comments.length;i++){
	  scomments+='<tr align="left" valign="top"><td  valign="top" >'+
	  '<small><div class="" id=""><span style="background-position: left; width: 45%; height: 87%; text-align: right;"><a herf="#">'+
	  ocomments.comments[i].user.username+'</a></span><span>:'+ocomments.comments[i].context+'</span><span>('+
	  ocomments.comments[i].time.toLocaleString()+')</span></div></small><br></td></tr>';
	  }
	  addcomments.innerHTML=scomments+'</table>';
    }
 }

 function submitPostCallBack2() {//异步处理返回转发ID到页面
    if (xmlHttp.readyState == 4) {
   var ocomment=eval('(' + xmlHttp.responseText + ')');
    	var addcomments= document.getElementById(commentsByForwardid); 
	  var scomments='<table width="87%" height="97" border="0" align="center" style="background-image: url(images/commentsBackground.png); text-align: left;">'+
	  '<tr align="left" valign="top"><td  valign="top" ><input type="text" id="addCommentByForwardid" maxlength="140" name="" size="60" /></td><td align="right" valign="top">'+
	  '<input type="submit"  value="评论" onclick="submitCommentByForward('+ocomment.forwardid+')"/></td></tr>';
	  for(var i=0;i<ocomment.comments.length;i++){
	  scomments+='<tr align="left" valign="top"><td  valign="top" >'+
	  '<small><div class="" id=""><span style="background-position: left; width: 45%; height: 87%; text-align: right;"><a herf="#">'+
	  ocomment.comments[i].user.username+'</a></span><span>:'+ocomment.comments[i].context+'</span><span>('+
	  ocomment.comments[i].time.toLocaleString()+')</span></div></small><br></td></tr>';
	  }
	  addcomments.innerHTML=scomments+'</table>';
    }
 }
 
 
 function addFollowing(targetid,id){//加关注
	 addFollowingid=targetid;
	 if(document.getElementById){
		 createXmlHttp();                                      //创建XMLHttpRequest对象
	        xmlHttp.onreadystatechange = submitPostCallBack12;    //设置回调函数
	        xmlHttp.open("POST", "json/jsonAddFollowing.action", true);         //发送POST请求
	       //设置POST请求体类型
	        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
	        xmlHttp.send("followingToUserid=" + id);    //发送包含一个参数的请求体
	        }
 }
 function submitPostCallBack12(){
	 if (xmlHttp.readyState == 4) {
		 $.zxxbox.remind("已关注成功", null, { delay: 1020 });
		 $("#add"+addFollowingid).attr("value",'已关注');
		 $("#add"+addFollowingid).attr("disabled","disabled");
	 }
 }
 
 function tipsToUser(){//提示是否有私信或者评论
	 createXmlHttp();                                      //创建XMLHttpRequest对象
     xmlHttp.onreadystatechange = submitPostCallBack13;    //设置回调函数
     xmlHttp.open("POST", "json/jsonTips.action", true);         //发送POST请求
    //设置POST请求体类型
    // xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
     xmlHttp.send(null);    //发送包含一个参数的请求体	}
 }
 function submitPostCallBack13(){
	 if (xmlHttp.readyState == 4) {
		 var ocomment=eval('(' + xmlHttp.responseText + ')');
		 var addcomments= document.getElementById("float"); 
		 if(ocomment.userUpdatesSize!=0){
			 $("#float").slideToggle("normal");
		//	 $("#float").attr("style",'display:inline');
		 }
	 }
 }
 
 //收藏微薄
 function toggleCollection(messageid){
	 collectMessageid = messageid;
	 createXmlHttp();
	 xmlHttp.onreadystatechange = submitPostCallBackCollection;
     xmlHttp.open("POST","json/jsonSaveCollection.action",true);
     xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
	 xmlHttp.send("collectionToMessageid="+messageid);
}
function submitPostCallBackCollection(){
	if (xmlHttp.readyState == 4) {
		$.zxxbox.remind("收藏成功", null, { delay: 1020 });
		$("#collect"+collectMessageid).html("取消收藏");
		$("#collect"+collectMessageid).attr("style",'color: #787878');
		$("#collect"+collectMessageid).attr("onclick",'');
		$("#collect"+collectMessageid).attr("href","javascript:deleteCollectMess("+collectMessageid+")");
	}
}

//取消微薄的收藏
function deleteCollectMess(DecollectMessageid){
	collectMessageid = DecollectMessageid;
	createXmlHttp();
	xmlHttp.onreadystatechange = submitPostCallBackDeleteCollectMess;
    xmlHttp.open("POST","json/jsonDeleteCollectMess.action",true);
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
	xmlHttp.send("collectionToMessageid="+collectMessageid);
}
function submitPostCallBackDeleteCollectMess(){
	if (xmlHttp.readyState == 4) {
		$.zxxbox.remind("取消收藏成功", null, { delay: 1020 });
		$("#collect"+collectMessageid).html("收藏");
		$("#collect"+collectMessageid).attr("style",'color: #005580');
		$("#collect"+collectMessageid).attr("href","javascript:toggleCollection("+collectMessageid+")");
	}
}

//收藏转发
function farwardCollection(forwardid){
	collectForwardid = forwardid;
	createXmlHttp();
	xmlHttp.onreadystatechange = submitPostCallBackCollectionForward;
    xmlHttp.open("POST","json/jsonSaveForwardCollection.action",true);
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
	xmlHttp.send("collectionToForwardid="+forwardid);
}
function submitPostCallBackCollectionForward(){
	if (xmlHttp.readyState == 4) {
		$.zxxbox.remind("收藏成功", null, { delay: 1020 });
		$("#forwardCollect"+collectForwardid).html("取消收藏");
		$("#forwardCollect"+collectForwardid).attr("style",'color: #787878');
		$("#forwardCollect"+collectForwardid).attr("onclick",'');
		$("#forwardCollect"+collectForwardid).attr("href","javascript:deleteCollectForw("+collectForwardid+")");
	}
}

//取消微薄的收藏
function deleteCollectForw(collectForwardid){
	createXmlHttp();
	xmlHttp.onreadystatechange = submitPostCallBackDeleteCollectForw;
   xmlHttp.open("POST","json/jsonDeleteCollectForw.action",true);
   xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
	xmlHttp.send("collectionToForwardid="+collectForwardid);
}
function submitPostCallBackDeleteCollectForw(){
	if (xmlHttp.readyState == 4) {
		$.zxxbox.remind("取消收藏成功", null, { delay: 1020 });
		$("#forwardCollect"+collectForwardid).html("收藏");
		$("#forwardCollect"+collectForwardid).attr("style",'color: #005580');
		$("#forwardCollect"+collectForwardid).attr("href","javascript:farwardCollection("+collectForwardid+")");
	}
}
 
 