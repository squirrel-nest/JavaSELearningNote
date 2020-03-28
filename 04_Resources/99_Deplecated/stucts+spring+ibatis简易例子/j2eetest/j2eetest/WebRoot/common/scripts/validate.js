//�����������������������������������÷�ʽ��������������������������������������
//if(!(obj.,''))return false;
//������������������������������������������������������������������������������������

function getTotalBytes(varField) {
	if(varField == null)
		return -1;
	
	var totalCount = 0;
	for (i = 0; i< varField.value.length; i++) {
		if (varField.value.charCodeAt(i) > 127) 
			totalCount += 2;
		else
			totalCount++ ;
	}
	return totalCount;
}

function isPhone(obj,str,allowNull) {
	var pattern = /^[0-9]{0,}[-]{0,1}[0-9]{0,}[-]{0,1}[0-9]{0,}$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" ���ǵ绰�����ʽ!");
		obj.focus();
		return false;
	}
	else return true;
}

function isMail(obj,str,allowNull) {
	var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" ���ǺϷ������ʼ���ʽ!");
		obj.focus();
		return false;
	}
	else return true;
}
//�Ƿ��ַ�У�飬��Ӣ����ĸ��ͷ���ֻ�ܰ���Ӣ����ĸ�����ּ�"_"
function isEN(obj,str,allowNull) {
	var pattern = /^([a-zA-Z])+([a-zA-Z0-9_]*)+$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" ������Ӣ����ĸ��ͷ���ֻ�ܰ���Ӣ����ĸ�����ּ�'_'");
		obj.focus();
		return false;
	}
	else return true;
}

function isNotNull (obj,str,allowNull){
  if (obj.value==""&&!allowNull){
    alert(str+" ����Ϊ��!");
    obj.focus();
    return false;
  }
  else return true;
}

function isNull(obj){
	if(obj.value==""||!obj.value) return true;
	else return false;
}
//

function isNumber(obj,str,allowNull) {
	var pattern =/^[-,+]{0,1}[0-9]{0,}[.]{0,1}[0-9]{0,}$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" �������ָ�ʽ!");
		obj.focus();
		return false;
	}
	else return true;
}

function isPositiveNumber(obj,str,allowNull) {
	var pattern =/^[0-9]{0,}[.]{0,1}[0-9]{0,}$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" �������ָ�ʽ!");
		obj.focus();
		return false;
	}
	else return true;
}

function isInteger(obj,str,allowNull) {
	var pattern = /^-*\d+$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" ����������ʽ!");
		obj.focus();
		return false;
	}
	else return true;
}

function isDate(obj,str,allowNull) {
	var pattern = /^[1-9]\d{3}[/|-]((0[1-9])|(1(0|1|2))|([1-9]))[/|-](([0-2][1-9])|([1-2][0-9])|(3(0|1))|([1-9]))$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" �������ڸ�ʽ!");
		obj.focus();
		return false;
	}
	else return true;
}


function verifyPassword(obj1, obj2) {
  if (obj1.value != obj2.value) {
	  alert("��������벻һ��!");
	  obj1.focus();
      return false;
  }
  else return true;
}

function checkMobile(obj,str,allowNull){
      var pattern=/^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" ��ʽ���ԣ�");
		obj.focus();
		return false;
	}
	else return true;
}
/**********��֤���֤�������Ч��***********/
function isIdCard(obj,str,allowNull){
	var pattern = /^\d{15}(\d{2}[A-Za-z0-9])?$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" ������ȷ�����֤����!");
		obj.focus();
		return false;
	}
	else return true;
}

function checkNumber(){    //??????????
    key=window.event.keyCode; 
    //window.alert(key+"") 
    if ((key>57)||(key<48)&&(key!=46)&&key!=13&&key!=45){
       //alert("???????");
       return false;
    }
    return true;
}
