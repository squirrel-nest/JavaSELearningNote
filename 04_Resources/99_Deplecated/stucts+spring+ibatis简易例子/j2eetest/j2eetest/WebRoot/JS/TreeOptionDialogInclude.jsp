<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<SCRIPT>

function TreeOptionDialog(treeDataUrl , listDataUrl){
	
	this.treeDataUrl = treeDataUrl;
	
	this.listDataUrl = listDataUrl;
	

	this.leftWidth = 200;
	this.rightWidth = 500;
	
	this.open = open;
	this.setLeftWidth = setLeftWidth;
	this.setRightWidth = setRightWidth;
}


function open(width , height){
	var paramStr ="?treeDataUrl=" + this.treeDataUrl 
				+ "&listDataUrl=" + this.listDataUrl
				+ "&leftWidth=" + this.leftWidth
				+ "&rightWidth=" + this.rightWidth;
				
	var dialogStyle = "help=yes; scroll=auto; status=yes; dialogWidth=" + width +"px; dialogHeight=" + height + "px;"	
	var options = showModalDialog("<%=basePath%>JS/TreeOptionDialog.jsp" + paramStr ,"OptionDialog",  dialogStyle);
	if(options == null){
		options="";
	}
	return options;
}

function setLeftWidth(left){
	this.leftWidth = left;
}

function setRightWidth(right){
	this.rightWidth = right;
}

</SCRIPT>
	