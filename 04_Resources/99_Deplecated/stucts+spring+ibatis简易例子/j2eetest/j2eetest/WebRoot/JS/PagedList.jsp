<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/web-component.tld" prefix="web" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String listDataUrl = request.getParameter("listDataUrl");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>列表选择框</title>

    <link rel="stylesheet" type="text/css" href="<%=basePath%>CSS/PagedList.css">
		<SCRIPT language="javascript">
			function CB_Row_OnDBLClick(eventObj){
				window.returnValue = eventObj.busiID;
				window.close();
			}
					
			function getSelect(){
				window.returnValue = pagedList.getSelectedRecordID().toString();
				window.close();
			}		
		</SCRIPT>	
  </head>
  
  <body>

		<TABLE cellpadding="0" cellspacing="0" border="0" >
		
			<TR>
		
				<TD valign="top">
					<web:pagedlist id="pagedList" dataxmlurl="<%=listDataUrl%>"/>
				</TD>
		
			</TR>
			<TR><TD>&nbsp;</TD></TR>
			<TR>
				<TD align="right">
					&nbsp;&nbsp;
					<input type=button value="确  定" onclick="javascript:getSelect();">
					<input type=button value="取  消" onclick="javascript:window.close();">
				</TD>
			</TR>
			
		</TABLE>

  </body>
  
</html>
