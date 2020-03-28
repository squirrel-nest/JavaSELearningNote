<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import="java.util.*,com.domain.*"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="org.w3c.dom.*"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="Content-Language" content="gb2312" />
<meta name="author" content="lzw" />
<meta name="keywords" content="主界面" />
<base target="_self"/>
<title>TEST操作主界面</title>
<link href="../common/css/model.css" rel="stylesheet" type="text/css" />
<link href="../common/css/sortabletable.css" rel="stylesheet" type="text/css" />
<link href="../common/css/ie.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../common/scripts/validation-framework.js"></script>
<SCRIPT language="JavaScript" src="../common/scripts/openWin.js" ></SCRIPT>
<SCRIPT language=javascript>
<!--
	//ValidationFramework.init("../common/scripts/validation-resourceobj.xml");
	function adda(){
			    var strURL = window.location.toString();
			    strURL = strURL.substring(strURL.lastIndexOf('/') + 1,strURL.indexOf('?'));
				var myfrm =document.forms[0];	
				var url = strURL+"?postMethod=openEditWindow&isnew=0";
	            var returnValue =showModalDialog(url,self,"dialogHeight: 550px; dialogWidth:750px;dialogTop:100;dialogLeft: 120;center: yes; status=no");
	            if (returnValue!=undefined){
		            myfrm.action = strURL+"?postMethod=getTestInfList";
	            	myfrm.submit();
	            }
	}
	function deleteb(){
				alert('系统建设中。。。');
				return;
				if(!window.confirm("您确定要删除当前所选的数据吗？")) return;
			    var strURL = window.location.toString();
			    strURL = strURL.substring(strURL.lastIndexOf('/') + 1,strURL.indexOf('?'));
				var myfrm =document.forms[0];
		    	if(selectedCheckboxCount(myfrm)< 1){
		    		alert("请先打勾选择差错数据后，再进行删除处理。");
		    		return;
		    	}
		    	var rowid = getSelectedCheckboxValue(myfrm);
		    	var tableids = "";
		    	for(i=0; i< rowid.length ; i++){
		    		tableids = tableids + rowid[i] + "^";
		    	}
		    	tableids = tableids.substr(0, tableids.length-1);
		    	
		    	var url = strURL+"?postMethod=openEditWindow&isnew=1&curid"+tableids;
    			myfrm.action=url;
        		myfrm.submit();
	}
	
	function editc(){
	    var strURL = window.location.toString();
	    strURL = strURL.substring(strURL.lastIndexOf('/') + 1,strURL.indexOf('?'));
		var myfrm =document.forms[0];
    	if(selectedCheckboxCount(myfrm)< 1 || selectedCheckboxCount(myfrm)> 1){
    		alert("请先勾选待编辑的记录或所勾选的记录数不能大于1，再进行修改操作。");
    		return;
    	}
    	var rowid = getSelectedCheckboxValue(myfrm);
    	var curid = rowid[0];
    	var url = strURL+"?postMethod=openEditWindow&isnew=1&curid="+curid;
        var returnValue =showModalDialog(url,self,"dialogHeight: 550px; dialogWidth:750px;dialogTop:100;dialogLeft: 120;center: yes; status=no");
		if (returnValue!=undefined){
            myfrm.action = strURL+"?postMethod=getTestInfList";
        	myfrm.submit();
        }
	}
	
-->
</SCRIPT>
<SCRIPT language=javascript>
var strURL = window.location.toString();
strURL = strURL.substring(strURL.lastIndexOf('/') + 1,strURL.indexOf('?'));

<!--
function selectedCheckboxCount(form){
	var length =0;
	var i=0;
	var count =0;	
	eles = form.elements;
	while(i<eles.length){
		obj= eles.item(i);
		type = obj.type;
		if(type.indexOf("checkbox")!=-1){
			if(obj.checked&&obj.name!="cksearch"){
				count++;
			}
		}
		i++;
	}	
	return count;
}

function getSelectedCheckboxValue(form){
	var length =0;
	var i=0;
	var k=0;	
	var ret=new Array();
	eles = form.elements;
	while(i<eles.length){
		obj= eles.item(i);			
		type = obj.type;		
		if(type.indexOf("checkbox")!=-1){
			//alert(obj.name);
			if(obj.checked&&obj.name!="cksearch"){
				ret[k++]=obj.value;
			}
		}
		i++;
	}
	return ret;
}	

function doSearch()
	{
		document.all.waitdiv.style.display="";	
		var myfrm =document.forms[0];
		var strURL = window.location.toString();
	    strURL = strURL.substring(strURL.lastIndexOf('/') + 1,strURL.indexOf('?'));	
		myfrm.action = strURL+"?postMethod=getTestInfList&issearch=1";
	    myfrm.submit();
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
       }
    }
}
document.onreadystatechange = init;
-->
</SCRIPT>
</head>
<body oncontextmenu="self.event.returnValue=true" topmargin="0" leftmargin="0" rightmargin="0" scroll="yes" style="overflow-x:scroll">
<html:form action="jsp/doTestAction.do" method="post">
<div id="waitdiv" style="display:none;z-index:10; LEFT: 100px; POSITION: absolute; TOP: 110px;">
	<table width=90% border=0 cellspacing=0 cellpadding=0>
	<tr>          
	<td width=30%></td>
	<td bgcolor=red>
	<table width=100% height=50 border=0 cellspacing=2 cellpadding=0 class="form">
	<tr>
	<td bgcolor=#FFFFCC align=center>
	<div align="center" style="FONT-SIZE: 13px;" >数据查询中,请稍候...</div>
	</td>
	</tr>                         
	</table>
	</td>                 
	<td width=30%></td>
	</tr>
	</table>
</div>
<div style="HEIGHT=20%;width=100%">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td>
	<table width="100%" >
		<thead>		
		<tr>
			<td colspan="8" width="100%" background="../common/images/button_bg.gif" height="27" align="left">
			<SCRIPT language=javascript>
				document.write('&nbsp;&nbsp;<input type="button" value="新增" class="buttoncom2" name="add" onClick="adda();" title="新增">'); 
				document.write('&nbsp;&nbsp;<input type="button" value="编辑" class="buttoncom2" name="edit" onClick="editc();" title="编辑">'); 
				document.write('&nbsp;&nbsp;<input type="button" value="删除" class="buttoncom2" name="del" onClick="deleteb();" title="删除">'); 
			</SCRIPT>
 			</td>
		</tr>		
		<tr>
			<td colspan="8" width="700">
				<table class="sort-table" border="1" cellspacing="0" cellpadding="0" bordercolordark="#FFFFFF" bordercolorlight="#A5A5A6" width="100%">
				<tr>
					<td background="../common/images/table_title_bg.gif" align="center" width="10%" nowrap>编号：</td>
					<td align="left" width="15%">
			   			<html:text property="id" size="20%"/>
					</td>					
					<td background="../common/images/table_title_bg.gif" width="20%"><input type="button" onclick="javascript:doSearch();" class="buttoncom2" value="查询" width="100%"></td>
				</tr>
				</table>
			</td>
		</tr>
	  </thead>	
  </td>
  </tr>	
  </table>
 </div>
 <div style="HEIGHT=80%;width=100%">
	<table width="100%" class="tablecolor2">
	<thead>
	   <tr>
		<td background="../common/images/table_title_bg.gif" height="21" align="center" nowrap>选择</td>
		<td background="../common/images/table_title_bg.gif" align="center" nowrap>编号</td>
		<td background="../common/images/table_title_bg.gif" align="center" nowrap>名称</td>
		<td background="../common/images/table_title_bg.gif" align="center" nowrap>备注</td>
	   </tr>
	 </thead>
	<%
	  int i=0;
	  //List list = (List)request.getAttribute("testInfList");
	%>
	<c:forEach var="item" items="${testInfList}" varStatus="var">	
		<c:if test="${var.index % 2 == 0}">
			<tr bgcolor="#FFFFFF">
		</c:if>	    
		<c:if test="${var.index % 2 != 0}">
			<tr bgcolor="#F1F4FA">
		</c:if>	    
			<td align="center" nowrap><input type="checkbox" class="checkbox2" name="rowid" value="<c:out value="${item.id}"/>"></td>
			<td nowrap><c:out value="${item.id}"/>&nbsp;</td>
			<td nowrap><c:out value="${item.name}"/>&nbsp;</td>
			<td nowrap><c:out value="${item.remark}"/>&nbsp;</td>
			</tr>
		<%i++;
		%>		
	</c:forEach> 
  <tr>
   </table>	
  </td>
  </tr>
 </table>
</div>
</html:form>
</html:html>