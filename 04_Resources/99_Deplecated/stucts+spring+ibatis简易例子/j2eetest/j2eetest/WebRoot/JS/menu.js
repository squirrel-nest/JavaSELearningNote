var contextMenuEnabled	= false;
var selectEnabled		= false;
var targetFrame			= "mainFrame";

var menuWidth			= 191;
var menuHeight			= 230;
var barHeight			= 29;
var ctrlDivWidth		= 15;
var imgWidth			= 20;
var menuDivLeft			= 12;
var menuLeft			= 0;
var menuTop				= 0;

var imgPath				= "menu/menuImg/";
var barImg				= "bis-bg1.gif";
var bgImg				= "bis-bg.gif";
var uImg				= "top1.gif";
var dImg				= "down1.gif";
var menuDownImg			= "bis-down2.gif";
var itemDefaultIco		= "2.gif";
var itemFatherIco		= "1.gif";
var itemFatherIcoL		= "2.gif";

var menubgCol			= "#E8EAEA";
var bgCol				= "#E1F0F3";
var itemFontCol			= "#818181";
var itemMoveFontCol		= "#07849D";

var ifMouseDown = false;
var ctrlMenuList;
var MenuItemCHeight	= new Array();
var itemSpeed = 10;
var itemTime = 3;
var itemStep = 30;
var menuSpeed = 10;
var menuTime = 10;
var menuStep = 10;
var barElement;
var menuHeight;
var menuMaxHeight;
var currentShowMenu = 0;
var menuCount;
var ifMenuUp = false;
var ifMenuRun = false;
var ifItemRun = false;

function menuListMove(tag,id)
{
	ifMouseDown = true;
	ctrlMenuList = eval(id);
	(tag=="up")?menuListUp(ctrlMenuList):menuListDown(ctrlMenuList);
}
	
function menuListStop()
{
	ifMouseDown = false;
}
	
function menuListUp()
{
	ctrlMenuList.scrollTop += 1;
	if (ifMouseDown==true)
		setTimeout("menuListUp()",1);
	else
		return;
}
	
function menuListDown()
{
	ctrlMenuList.scrollTop -= 1;
	if (ifMouseDown==true)
		setTimeout("menuListDown()",1);
	else
		return;
}
	
function ctrlMeunItem(id,itemID)
{
	if (ifItemRun) return;
	ifItemRun = true;
	var oElement = document.getElementById(itemID+"Img");
	ctrlMenuItemD = eval("MenuItemC"+id+"D");
	ctrlMenuItemT = eval("MenuItemC"+id+"T");
	if (ctrlMenuItemD.style.display=="none")
	{
		ctrlMenuItemD.style.display = "";
		oElement.src = imgPath+itemFatherIcoL;
		showMenuItem(1,itemStep,id);
	}	
	else
	{
		oElement.src = imgPath+itemFatherIco;
		hideMenuItem(MenuItemCHeight[id],itemStep,id);
	}
}
	
function getMenuItemAlphaValue()
{
	var temp = ctrlMenuItemT.style.filter.split("=")[1];
	var alphaValue = parseInt(temp.substring(0,temp.length-1));
	return alphaValue;
}
	
function hideMenuItem(height,sp)
{
	var alphaValue = getMenuItemAlphaValue();
	if(height>1)
	{
		height = height - sp;
		if(height<1)
		{
			height = 1;
			alphaValue = 0;
		}
		alphaValue -= 10;
		ctrlMenuItemT.style.filter = "Alpha(opacity="+alphaValue+")";
		ctrlMenuItemD.style.height = height + "px";
		sp = sp + itemSpeed;
		if(sp>itemStep) sp=itemStep;
		window.setTimeout("hideMenuItem("+height+","+sp+")",itemTime);
	}
	else
	{
		ctrlMenuItemD.style.display = "none";
		itemStep = sp;
		ifItemRun = false
		return;
	}	
}
	
function showMenuItem(height,sp,id)
{
	var alphaValue = getMenuItemAlphaValue();
	var H = MenuItemCHeight[id];
	if(height<H)
	{
		height = height + sp;
		if (height>H)
		{
			height = H;
			alphaValue = 100;
		}
		alphaValue += 10; 
		ctrlMenuItemT.style.filter = "Alpha(opacity="+alphaValue+")";
		ctrlMenuItemD.style.height = height + "px";
		sp = sp - itemSpeed;
		if(sp<1) sp = sp+itemSpeed;
		window.setTimeout("showMenuItem("+height+","+sp+","+id+")",itemTime);
	}
	else
	{
		itemStep = sp;
		ifItemRun = false;
		return;
	}
}
	
function moveMenu(id)
{
	if((id==currentShowMenu)||(ifMenuRun))
		return;
	else
	{
		ifMenuRun = true;
		menuChage(id,currentShowMenu,menuMaxHeight-1,menuStep);
	}	 
}

function menuChage(showId,hideId,height,sp)
{
	if(height>1)
	{
		height = height - sp;
		height = (height<1)?1:height;
		eval("menuDiv"+hideId+".style.height='"+height+"px';");
		eval("CtrlMenuDiv"+hideId+".style.height='"+height+"px';");
		eval("menuDiv"+showId+".style.height='"+(menuMaxHeight-height+"px';"));
		eval("CtrlMenuDiv"+showId+".style.height='"+(menuMaxHeight-height+"px';"));
		sp = sp + menuSpeed;
		window.setTimeout("menuChage("+showId+","+hideId+","+height+","+sp+")",menuTime);
	}
	else
	{
		currentShowMenu = showId;
		ifMenuRun = false;
		return;
	}
}

function itemMove(id)
{
	var oElement = document.getElementById(id);
	oElement.style.color = itemMoveFontCol;
}

function itemOut(id)
{
	var oElement = document.getElementById(id);
	oElement.style.color = itemFontCol;

}

function itemClick(url)
{
	eval("parent."+targetFrame+".location.href='"+url+"';");
}

function document.onselectstart()
{
     return selectEnabled;
}

function document.oncontextmenu()
{
     return contextMenuEnabled;
}