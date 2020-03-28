<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="org.w3c.dom.*"%>
<html:html>
<title>维护</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="Content-Language" content="gb2312" />
<meta name="author" content="lzw" />
<base target="_self"/>
<meta name="keywords" content="维护" />
<link type="text/css" rel="stylesheet" href="../common/css/tableFrameLeft.css"/>
<link type="text/css" rel="stylesheet" href="../common/css/ie.css"/>
<link type="text/css" rel="StyleSheet" href="../common/css/sortabletable.css" />
<SCRIPT language="JavaScript" src="../common/scripts/openWin.js" ></SCRIPT>
<SCRIPT language=javascript>
<!--
	//ValidationFramework.init("../common/scripts/validation-resourceobj.xml");
	function savea(){
	    var strURL = window.location.toString();
	    strURL = strURL.substring(strURL.lastIndexOf('/') + 1,strURL.indexOf('?'));
		var myfrm =document.forms[0];	
		//if(!window.confirm("您确定要删除当前所选的比对方案信息吗？")) return;   	
    	var url = strURL+"?postMethod=saveTestInf&isnew="+myfrm.isnew.value;		
   		myfrm.action=url;		
		myfrm.submit();
		//myfrm.action = strURL+"?postMethod=getThanProjectTop";
	}
-->
</SCRIPT>
<SCRIPT language=javascript>
<!--
var msg = '<html:messages id="error"><bean:write name="error"/></html:messages>';
msg = msg!=''?msg:'<html:messages id="message" message="true"><bean:write name="message"/></html:messages>';
while(msg.indexOf("#")!=-1) msg = msg.replace("#","\r\n");

function init() {
    if(document.readyState=='complete') { 
       if(msg!='') {
       	  alert(msg);
       	  if (msg=='保存操作成功'){
			returnValue ="1";			//返回值
			self.close();       	  	
       	  }
       	  else{
          	alert(msg);
			self.close();          	
          }
       }
    }
}
document.onreadystatechange = init;

-->
</SCRIPT>
</head>
<body oncontextmenu="self.event.returnValue=true" topmargin="0" leftmargin="0" rightmargin="0" >
<html:form action="jsp/doTestAction.do" method="post">
<html:hidden property="isnew"/>
<div align="center" id="notice">
<table width="100%" class="tablecolor2">
	<tbody>
	<TR>
		<TD background="../common/images/title_bgimg.gif" height="31" align="center" class="title2" colspan="4" style="Font-Size=13;">
		  维护
		</TD>  
	</TR>
	  <tr>
			<td colspan="4" width="100%" background="../common/images/button_bg.gif" height="27" align="left">
			<SCRIPT language=javascript>
				document.write('&nbsp;&nbsp;<input type="button" value="保存" class="buttoncom2" name="save" onClick="savea();" title="保存">'); 
				document.write('&nbsp;&nbsp;<input type="button" value="关闭" class="buttoncom2" name="edit" onClick="javascript:self.close();" title="关闭">'); 
			</SCRIPT>
 			</td>	  	
	  </tr>
	  <tr>
	   		<td background="../common/images/table_title_bg.gif" align="center" width="20%">编号：</td>
	   		<td align="left" width="30%">
				<logic:equal name="testForm" property="isnew" value="0">
               		<html:text property="id" size="30%"/>
                </logic:equal>	   			
				<logic:equal name="testForm" property="isnew" value="1">
               		<html:text property="id" size="30%" disabled="true"/>
                </logic:equal>	 				
	        </td>
	   		<td background="../common/images/table_title_bg.gif" align="center" width="15%">名称：</td>
	   		<td align="left" width="30%"><html:text property="name" size="35%"/></td>
	   </tr>
	   <tr>
	   		<td background="../common/images/table_title_bg.gif" align="center" width="20%">备注：</td>	
	   		<td align="left" colspan="3" width="80%"><html:textarea property="remark" cols="80%" rows="5"/></td>
	   </tr>
	  </tbody>
</table>
</div>
</html:form>
</body>
</html:html>
