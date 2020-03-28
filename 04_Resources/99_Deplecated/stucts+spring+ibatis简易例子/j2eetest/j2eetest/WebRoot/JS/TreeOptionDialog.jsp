<%@ page language="java" contentType="text/html; charset=GBK" import="java.util.*"%>

<%

	/**************************************************
	** @Author	 : Linliangyi in Team of Miracle
	**
	** @Date	 	 : 2005.07.11
	**
	** @Name     : Common Web Components 
	** 
	** @CopyLeft : 2002-2005
	**
	** @Version  : 1.0
	***********************************************
	*/
	
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	String treeDataUrl = request.getParameter("treeDataUrl");
	String listDataUrl = request.getParameter("listDataUrl");

	String leftWidth = request.getParameter("leftWidth");
	String rightWidth = request.getParameter("rightWidth");
	
	String pagedListUrl = basePath + "JS/PagedList.jsp?listDataUrl=" + listDataUrl;
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>层级式列表选择框</title>
    
	<LINK href="<%=basePath%>CSS/XMLSelTree.css" type="text/css" rel="stylesheet">
	
	<SCRIPT language="javascript" src="<%=basePath%>JS/XMLSelTree.js"></SCRIPT>
	
	<SCRIPT language="javascript">
		function InitRightTree(){
	   
		    var sXMLFile = "<%=treeDataUrl%>";
		    var sXSLPath = "<%=basePath%>JS/XMLSelTree.xsl";	
		    if(sXMLFile == null || sXMLFile==""){
		    	alert("Lose data or template url!");
		    	return;
		    }	  
		    var oSrcDiv	= document.all("SrcDiv");
		    var optionTree = InitTree(sXMLFile, sXSLPath, oSrcDiv,true);
		    optionTree.setBasePath("<%=basePath%>");
		    optionTree.setGirdPageURL("JS/PagedList.jsp");
		}
	
	</SCRIPT>

  </head>

  <body onload="InitRightTree()">
  	<TABLE height="100%" cellpadding="0" cellspacing="0">
 			<TR>
				<TD height="100%">
					<DIV class="tdbig" id="SrcDiv" style="OVERFLOW: auto; WIDTH: <%=leftWidth%>px; HEIGHT: 100%" align="left"></DIV>
				</TD>
				<TD height="100%">
					<IFrame name="myScreen" src="<%=pagedListUrl%>" width="<%=rightWidth%>" , height="100%" scrolling="auto" marginheight="0" marginwidth="0"/>
				</TD>
			</TR>
		</TABLE>
  </body>
</html>
