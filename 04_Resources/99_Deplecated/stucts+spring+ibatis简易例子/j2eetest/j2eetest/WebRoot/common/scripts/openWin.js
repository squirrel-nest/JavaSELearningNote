/*
-------------------------------------------------------------------------------
�ļ����ƣ�openWin.js
˵    ����JavaScript�ű���������ҳ�е������ڵĴ���
��    ����1.0
�޸ļ�¼:
---------------------------------------------------------------------------
ʱ��			�޸���		˵��
2002-8-29	libo		����
2004-6-21	YuanYi		�޸�(��ε��ֻ����һ�����ڡ�ģʽ���ڵķ���ֵ)
------------------------------------------------------------------------------- 	
*/

/*
��;������ģʽ����
	�˹���ֻ����IE5.0���������ʹ�á�
	�������ڵķ��Ϊ���У�û��״̬����û��IE��ť���˵�,��ַ��
���룺
	strUrl��  	������������ʾ����ҳ�ĵ�ַ
	winWidth��	�������ڵĿ�ȣ���λΪpx
	winHeight:	�������ڵĸ߶ȣ���λΪpx
	middle:		���������Ƿ�Ҫ���У�Ĭ�ϲ�����
���أ�
	���ͨ����֤����true,���򷵻�false	
*/
function showModal( strUrl,winWidth,winHeight,middle){
	if(middle==null)
	{
		showx = event.screenX - event.offsetX - 210 ; // + deltaX;
		showy = event.screenY - event.offsetY + 18; // + deltaY;
		return window.showModalDialog(	strUrl,
										"window",
										"dialogWidth:"+ winWidth + "px;"
										+ "dialogHeight:"+winHeight + "px;"
										+ "dialogLeft:"+showx+"px;"
										+ "dialogTop:"+showy+"px;"
										+ "directories:yes;help:no;status:no;resizable:no;scrollbars:yes;");
	}
	else
	{
		return window.showModalDialog(	strUrl,
										"window",
										"dialogWidth:"+ winWidth + "px;"
										+ "dialogHeight:"+winHeight + "px;"
										+ "directories:yes;help:no;status:no;resizable:no;scrollbars:yes;");	
	}
}

function openNewWindow2( strUrl,winWidth,winHeight,type){
	if(type==null)
	{
	newwin = window.open(	strUrl,
							"popupnav",
							"width="+ winWidth + ","
							+ "height="+winHeight + ","
							+ "status=no,toolbar=no,menubar=no,location=no,scrollbars=yes");
	newwin.focus();
	}
	else
	{
	newwin = window.open(	strUrl,
							"popupnav",
							"width="+ winWidth + ","
							+ "height="+winHeight + ","
							+ "status=no,menubar=yes,scrollbars=yes");
	newwin.focus();
	}
}

function openNewWindow(url ,title , width , height, type){
	var _left= (screen.width - width)/2;
	var _top = (screen.height - height)/2;
	var newWindowInstance = null;
	if(type==0) {
	   newWindowInstance = window.open(url , title , 'toolbar=no,location=no,resizable=no,scrollbars=no,status=no,top='+ _top +',left='+ _left +',height=' + height + ',width=' + width + "'");
	   newWindowInstance.focus();
	}else if(type==1){
	   newWindowInstance = window.open(url , title , 'toolbar=no,location=no,resizable=yes,scrollbars=yes,status=no,top='+ _top +',left='+ _left +',height=' + height + ',width=' + width + "'");
	   newWindowInstance.focus();
	}else if(type==2){
	   newWindowInstance = window.open(url , title , 'fullscreen=3');		
	}
  return newWindowInstance;
}