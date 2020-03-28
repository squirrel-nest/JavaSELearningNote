function img_auto_size(oldimg,maxSize,openNewWindow){
	var newimg = new Image();
	newimg.src = oldimg.src;
	if (newimg.width > 0 && newimg.height > 0) {
		if (newimg.width > maxSize){ 
			oldimg.width = maxSize;
			oldimg.height = (newimg.height * maxSize) / newimg.width;
			oldimg.onmouseover = function() {
				this.style.cursor= "hand";
			};
			oldimg.onmouseout = function() {
				this.style.cursor="";
			};
			if(openNewWindow){
				oldimg.onclick = function() {
					window.open(this.src, '_blank');
				};
			}
		} else {
			oldimg.width = newimg.width; 
			oldimg.height = newimg.height;
		}
		oldimg.alt = "点击查看原始大小 " + newimg.width + " x " + newimg.height;
	}
} 

function getCookieVal(offset)
{
 var iEndStr=document.cookie.indexOf(";",offset);
 if(iEndStr==-1)
 iEndStr=document.cookie.length;
 return unescape(document.cookie.substring(offset,iEndStr));
}

function getCookie(name)
{
 var strArg=name+"=";
 var iArgLength=strArg.length;
 var iCookieLength=document.cookie.length;
 var iIndex=0;
 while(iIndex<iCookieLength)
 {
  var kIndex=iIndex+iArgLength;
  if(document.cookie.substring(iIndex,kIndex)==strArg)
   return getCookieVal(kIndex);
  iIndex=document.cookie.indexOf(" ",iIndex)+1;
  if(iIndex==0)
  break;
 }
 return null;
}

function reply(){
document.getElementById('replyForm').action="http://publishblog.blogdriver.com/blog/postRemark.b";
if(document.getElementById('replyForm').remark.value.length > 1000){
alert("评论字数太多，不能发布");
document.getElementById('replyForm').remark.focus();
return false;
}
if(document.getElementById('replyForm').remark.value.length==''){
document.getElementById('replyForm').remark.focus();
return false;
}
document.getElementById('replyForm').submit();
}