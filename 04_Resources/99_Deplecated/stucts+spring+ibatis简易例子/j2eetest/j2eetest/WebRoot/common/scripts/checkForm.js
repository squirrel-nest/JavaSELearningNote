/*
����������ֵ�Ƿ������ģ�Ӣ�ģ��������.
*/

function checkCommonField(obj)
{
    if (obj == null) return false;
    if (obj.value == "") return false;
    return checkCommonChar(obj.value);
}

/*
�������ֵ�Ƿ������ģ�Ӣ�ģ��������.
*/

function checkCommonChar(val)
{
    var exp = new RegExp("^\\w+$"); //���Ӣ���ַ�������ʽ
    var exp2 = new RegExp("^[\u4E00-\u9FA5\uF900-\uFA2D]*$"); //��������ַ�������ʽ
    var retEnChar;
    var retChChar;
    var tmp;
    if (val == null || val == '') return false;
    tmp = val.replace(/[\u4E00-\u9FA5\uF900-\uFA2D]/,''); //��ɾ�������ַ�	
    retEnChar = exp.test(tmp);
    tmp = val.replace(/[a-zA-Z0-9]/g,''); //��ɾ��Ӣ�ļ������ַ�	
    retChChar = exp2.test(tmp);	
    return (retEnChar||retChChar);
}

/*
-------------------------------------------------------------------------------
�ļ����ƣ�checkForm.js
˵    ����JavaScript�ű�����֤���е�������
��    ����1.0
�޸ļ�¼:
---------------------------------------------------------------------------
ʱ��		�޸���		˵��
2003-2-26	zhangcun		����
------------------------------------------------------------------------------- 	
*/

function checkForm(objFrm){
	var len = 0;
	len = objFrm.elements.length;

	var i = 0;
	var objCheck;
	//�ı���
	for(i = 0; i < len; i ++){
		objCheck = objFrm.elements[i];
		if(objCheck.type =="text" && !f_checkTextValid(objCheck) ){
			return false;			
		}
	}
	//������
	for(i = 0; i < len; i ++){
		objCheck = objFrm.elements[i];
		if(objCheck.type =="select-one" && !f_checkSelectValid(objCheck) ){
			return false;			
		}
	}
	//ʱ�����Ч
	if( f_checkStartAndEndDate(objFrm) == false) return false;
	
	return true;
}
function f_checkSelectValid(obj){
	//alert("check select");
	if(obj.options.length <= 0){
		alert("����ѡ��������!");
		return false;	
	} 
	return true;
}
function f_checkStartAndEndDate(frm){
	var len = frm.elements.length;
	if(len == null && len == 0) return true;
	var i=0;
	var temp;
	var objCheck;
	var objStartDate;
	var objEndDate;
	//alert("start date period check");
	try{
		for(i=0; i< len ; i++){
			objCheck = frm.elements[i];
			temp = objCheck.name;
			if( temp.indexOf("startDate") >0 ||temp.indexOf("beginDate")>0 )
				objStartDate = objCheck;
			if( temp.indexOf("endDate") > 0 )
				objEndDate = objCheck;
				
		}
		//alert(objStartDate.value);
		//alert(objEndDate.value);
		if(objStartDate.value==null || objStartDate.value =="" || objStartDate.value ==null || objStartDate.value ==""){
			return true;
		}
		return checkTwoDate(objStartDate.value, objEndDate.value);	
		//alert("end date period check");
	}catch(E){}
	return true;
}

function f_checkTextValid(obj){
	//����Ϊ��
	if(obj.getAttribute("isNeed") != null){
		if(f_isNotNull(obj) == false) return false;
	}
	//���ܳ�������
	if(obj.getAttribute("maxlength") != null){
		if(f_checkLength(obj) == false) return false;
	}
	var checkType ="";
	checkType = obj.getAttribute("checkType");
	if(checkType==null||checkType=="") return true;
	//
	if (checkType.indexOf("number") >=0){
		if(f_isNumber(obj) == false)  return false;
		if(f_checkNumType(obj,checkType) == false)  return false;
		
	}
	//
	if (checkType.indexOf("positive") >=0){
		if(f_isNumber(obj) == false)  return false;
		if(f_isPositive(obj)==false)  return false;
		if(f_checkNumType(obj,checkType) == false)  return false;
		
	}
	if (checkType.indexOf("date") >=0){
		if(f_checkDate(obj) == false) return false;
		
	}
	
	/*
	switch(checkType){
		case "number": if(f_isNumber(obj) == false) return false;break;
		case "date": if(f_checkDate(obj) == false) return false;break;
		default:
	}
	*/
	return true;
}

function f_isNotNull(obj){
	if(obj.value == ""){
		f_alert(obj, " ������Ϊ��ֵ��");
		return false;
	}
	return true;
}

function f_isNumber(obj){
	if(isNaN(obj.value)){
		 f_alert(obj," ӦΪ��ֵ����");
		return false;		
	}
	return true;

}
function f_checkDate(obj) {
	if(checkDate(obj.value) ==false){
		 f_alert(obj," ���ǺϷ����ڸ�ʽ��");
		return false;		
	}
	return true;
}

function f_checkLength(obj){
	if(getTotalBytes(obj) > Math.abs( obj.getAttribute("maxlength") ) ){
		 f_alert(obj," ������������!");
		return false;		
	}
	return true;
	
}

function  f_alert(obj,alertStr){
	var fielName = obj.getAttribute("fieldName");
	if(fielName == null)
		fielName = "";
	alert(fielName + "\n" +alertStr);
	obj.select();
	obj.focus();
}

function f_checkNumType(obj, numType){
	//����: �Ѿ��������������ж�
	
	var strTemp;
	var numpric;
	var numLen;
	var strArr;
	var defaultLen = 19;
	var defaultpric = 5;

	try{
		if(numType == null|| numType =="") return f_checkNumLenPrec(obj,defaultLen, defaultpric);
		if(numType.indexOf("(") < 0 || numType.indexOf(")") < 0 ) return f_checkNumLenPrec(obj,defaultLen, defaultpric);
		strTemp = numType.substr( numType.indexOf("(") + 1 ,numType.indexOf(")") - numType.indexOf("(") -1 );
		if(strTemp == null||strTemp =="") return f_checkNumLenPrec(obj,defaultLen, defaultpric);
		strArr = strTemp.split(",");	
		numLen = Math.abs( strArr[0] ); 
		numpric = Math.abs( strArr[1] );	
		return f_checkNumLenPrec(obj,numLen, numpric);
	}catch(e){
		alert("in f_checkNumType = " + e);
		 return f_checkNumLenPrec(obj,defaultLen, defaultpric);
	}

}

function f_checkNumLenPrec(obj, len, pric){
	var numReg;
	var value = obj.value;
	var strValueTemp, strInt, strDec;	
	//alert(value + "=====" + len + "====="+ pric);
	try{	
		
		numReg =/[\-]/;
		strValueTemp = value.replace(numReg, "");
		strValueTemp = strValueTemp.replace(numReg, "");
		//����
		if(pric==0){
			numReg =/[\.]/;
			//alert(numReg.test(value));
			if(numReg.test(value) == true){
				f_alert(obj, "�������Ϊ��������!");
				return false;	
			}			
		}
		
		if(strValueTemp.indexOf(".") < 0 ){
			//alert("lennth==" + strValueTemp);		
			if(strValueTemp.length >( len - pric)){
				f_alert(obj, "����λ���ܳ���"+ (len - pric) +"λ");
				return false;
			}
		
		}else{
			strInt = strValueTemp.substr( 0, strValueTemp.indexOf(".") );		
			//alert("lennth==" + strInt);		
			if(strInt.length >( len - pric)){
				f_alert(obj, "����λ���ܳ���"+ (len - pric) +"λ");
				return false;
			}		

			strDec = strValueTemp.substr( (strValueTemp.indexOf(".")+1), strValueTemp.length );		
			//alert("pric==" + strDec);		
			if(strDec.length > pric){
				f_alert(obj, "С��λ���ܳ���"+  pric +"λ");
				return false;
			}		
		}
		
		return true;
	}catch(e){
		alert("in f_checkNumLenPrec = " + e);
		return false;
	}	
}

function f_isPositive(obj){
	var numReg =/[\-]/;
	if(numReg.test(obj.value) == true){
		f_alert(obj, "����Ϊ����!");
		return false;
	}
	return true;
	
}


/*
function selectedCheckboxCount(form)
����˵������Form��ѡ�еĿ�ѡ�����

����˵����
form:ָ���ı�
*/
function selectedCheckboxCount(form){
	var length =0;
	var i=0;
	var count =0;	
	eles = form.elements;
	while(i<eles.length){
		obj= eles.item(i);
		type = obj.type;
		if(type.indexOf("checkbox")!=-1){
			if(obj.checked){
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
			if(obj.checked){
				ret[k++]=obj.value;;
			}
		}
		i++;
	}
	return ret;
}

//�õ��ֽڳ���
function getByteLen(str)
{
        var l = str.length;
        var n = l;
        for ( var i=0; i<l; i++ )
				
                if ( str.charCodeAt(i) <0 || str.charCodeAt(i) >255 )
                        n=n+1;
        return n
}

/*
˵����
1.�������е�����(0.0 �� 0)
2.���cell��û�����ݣ����Զ�����һ���ո�
3.����հ��е�checkbox

������
clearzero:�Ƿ����"0"��"0.0"��false�������true�����Ĭ��Ϊtrue��
tablename:Ҫ����ı�����֣�Ĭ��ΪsortTable
*/
function clear_table(clearzero,tablename)
{
	var tobject;
	if(tablename==null)
		tobject=gmobj("sortTable");
	else
		tobject=gmobj(tablename);
	//���tableδ���壬�򲻽��й���
	
	if(tobject==null)
		return;
		
	
	//����������ò���Ϊ�գ���ʾҪ���0��0.0����֮����Ҫ���0��0.0��
	var clear = (clearzero==null)?true:clearzero;

	//���0��0.0����ո�
	var rows = tobject.rows;
	var j=0;
	for(var i=0;i<rows.length;i++)
	{
		//ȡ�õ�һ��cell������clear�����Ϊ1����ʾ����û�����ݣ������������������
		
			while(tobject.rows[i].cells[j] != null)
			{
				if(clear)
				{
					if(tobject.rows[i].cells[j].innerHTML==0 ||tobject.rows[i].cells[j].innerHTML==0.0||tobject.rows[i].cells[j].innerHTML=="")
						tobject.rows[i].cells[j].innerText=" ";
				}
				else
				{
					if (tobject.rows[i].cells[j].innerHTML=="")
						tobject.rows[i].cells[j].innerText=" ";
				}
				j++;
			}
			j=0;
		
	}
    return true;
}

function gmobj(mtxt)  /* Get object by object name */
{
  if (document.getElementById) {
      m=document.getElementById(mtxt);
  } else if (document.all) {
      m=document.all[mtxt];
  } else if (document.layers) {
      m=document.layers[mtxt];
  }
  return m;
}
/********************************************************************************************
* ���֤������֤����JAVASCRIPT�棩
*    ʱ�䣺   2005��9��23��
*    ���֤������֤����
*    ����һ��checkCard(cId) ��ݺ�����麯��
*    ����cIdΪҪ��֤�����֤���룬����ֵΪtrueʱ����֤ͨ����
*    ��һЩλ�ñ�����alert()��ע�ͣ��ɹ����ѵ���ʹ��
*    ��������C15ToC18(c15)  15λ���֤��������Ϊ18λ����
*        ����c15ΪҪת����15λ���֤���룬����ֵΪת�����18λ����
*         �������������Ч15λ���룬����ֵΪ"undefined"��
*    ��������isdate(intYear,intMonth,intDay) ���ڼ��麯��
*        �����ֱ��������գ�����ֵΪtrueʱ����֤ͨ����
************************************************************************************************/
//����������Ƿ��ǺϷ�����
function isdate(intYear,intMonth,intDay)
{
    if(isNaN(intYear)||isNaN(intMonth)||isNaN(intDay)) return false;
    if(intMonth>12||intMonth<1) return false; 
    if ( intDay<1||intDay>31)return false; 
    if((intMonth==4||intMonth==6||intMonth==9||intMonth==11)&&(intDay>30)) return false;  
    if(intMonth==2)
    {  
	     if(intDay>29) return false;
	     if((((intYear%100==0)&&(intYear%400!=0))||(intYear%4!=0))&&(intDay>28))return false;
    } 
    return true;  
}  
//������֤�Ƿ�����ȷ��ʽ
function checkCard(cId) 
{	 
   var pattern;
   if (cId.length==15)
   {
       pattern= /^\d{15}$/;//������ʽ,15λ��ȫ������
       if (pattern.exec(cId)==null)
       {
          alert("15λ���֤�������ȫΪ���֣�")
          return false;
       }
       if (!isdate("19"+cId.substring(6,8),cId.substring(8,10),cId.substring(10,12)))
       {
         alert("���֤�����г������ڲ���ȷ") 
          return false;
				}   
    }
    else if (cId.length==18)
    {
           pattern= /^\d{17}(\d|x|X)$/;//������ʽ,18λ��ǰ17λȫ�����֣����һλֻ������,x,X
           if (pattern.exec(cId)==null)
           {
               alert("18λ���֤����ǰ17λ����Ϊ���֣�")
               return false;
           }
           if (!isdate(cId.substring(6,10),cId.substring(10,12),cId.substring(12,14)))
           {
               alert("���֤�����г������ڲ���ȷ") 
               return false;
           }
           var strJiaoYan  =[  "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"];
           var intQuan =[7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1];
           var intTemp=0;
           for(i = 0; i < cId.length - 1; i++)
              intTemp +=  cId.substring(i, i + 1)  * intQuan[i];  
           intTemp%=11;
           if(cId.substring(cId.length -1,cId.length).toUpperCase()!=strJiaoYan[intTemp])
           {
              // if(confirm("��ǰ�������֤������ܲ���ȷ���Ƿ�ȷ�ϱ��棿")==true)
               return confirm("��ǰ�������֤������ܲ���ȷ���Ƿ�ȷ�ϱ��棿");
           }
    }
    else
    {
       alert("��ǰ�������֤���볤�Ȳ���ȷ�����������룡")
       return false;
    }
    return true;   
}
//����15λ���֤���뵽18λ
function C15ToC18(c15)
{
   var cId=c15;
   if (c15.length==15)
   {
	      cId=c15.substring(0,6)+"19"+c15.substring(6,15);
	      var strJiaoYan  =["1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"];
        var intQuan =[7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2,1];
	      var intTemp=0;
	      for(i = 0; i < cId.length; i++)
	      {	      	      	 
	         intTemp += parseInt(cId.substring(i, i + 1),10)  * intQuan[i];  
	      }
	      intTemp %= 11;
	      cId+=strJiaoYan[intTemp];	      
	  }
    return cId;
}
//��֤�����ʼ��ĺϷ���
function isEmail(sEmail)
{
	if (sEmail=='')
	{
    return false; 
  }
  if (sEmail.indexOf ('@',0) == -1 || sEmail.indexOf ('.',0) == -1)
  {
  return false;
  }
  return true;
}
function isValidateDate(str)
{
  var date = Date.parse(str);
  if (isNaN(date)) {
    date = Date.parse(str.replace(/-/g,"/")); // ʶ�����ڸ�ʽ��YYYY-MM-DD 
    if (isNaN(date)) date = 0;
  }
  if(date==0) return false;
  return true;
}
function CheckValidateChar(str,strMsg)
{
   var Result=false;		
   if(str.indexOf("'")>=0 || str.indexOf("\\")>=0 || str.indexOf("\"")>=0 || str.indexOf("<")>=0 || str.indexOf(">")>=0 || str.indexOf("&")>=0)
   {
       alert(strMsg+"������\" ' < > & \\�ȷǷ��ַ���\r\n���޸�Ϊ�����ַ������ԣ�");
	   Result=true;
   }
   return Result;
}
//ȡ��������С��λ������������ķ�ʽ
function RoundFloat(value, count)
{
   var Result=value;
   var iD=1;
   if(count<=0)
   {
      Result=Math.round(Result);
   }
   else
   {
	   for(var i=0;i<count;i++)
	   {
	      iD=iD*10;
	   }
	   Result=Result*iD;
	   Result=Math.round(Result);
	   Result=Result/iD;
   }
   return Result;
}

//clear space lzw add 
function JS_Trim(txt) 
{
 var newtxt = "";
 for(b=0;b<txt.length;b++)
 {
  s = txt.substring(b,b+1);
  if(s != " ")
  {
   newtxt = newtxt + s;
  }
 }
 return newtxt;
}
