//××××××××××××××××调用方式×××××××××××××××××××
//if(!(obj.,''))return false;
//××××××××××××××××××××××××××××××××××××××××××

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
		alert(str+" 不是电话号码格式!");
		obj.focus();
		return false;
	}
	else return true;
}

function isMail(obj,str,allowNull) {
	var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" 不是合法电子邮件格式!");
		obj.focus();
		return false;
	}
	else return true;
}
//非法字符校验，以英文字母开头其后只能包含英文字母、数字及"_"
function isEN(obj,str,allowNull) {
	var pattern = /^([a-zA-Z])+([a-zA-Z0-9_]*)+$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" 必须以英文字母开头其后只能包含英文字母、数字及'_'");
		obj.focus();
		return false;
	}
	else return true;
}

function isNotNull (obj,str,allowNull){
  if (obj.value==""&&!allowNull){
    alert(str+" 不能为空!");
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
		alert(str+" 不是数字格式!");
		obj.focus();
		return false;
	}
	else return true;
}

function isPositiveNumber(obj,str,allowNull) {
	var pattern =/^[0-9]{0,}[.]{0,1}[0-9]{0,}$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" 不是数字格式!");
		obj.focus();
		return false;
	}
	else return true;
}

function isInteger(obj,str,allowNull) {
	var pattern = /^-*\d+$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" 不是整数格式!");
		obj.focus();
		return false;
	}
	else return true;
}

function isDate(obj,str,allowNull) {
	var pattern = /^[1-9]\d{3}[/|-]((0[1-9])|(1(0|1|2))|([1-9]))[/|-](([0-2][1-9])|([1-2][0-9])|(3(0|1))|([1-9]))$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" 不是日期格式!");
		obj.focus();
		return false;
	}
	else return true;
}


function verifyPassword(obj1, obj2) {
  if (obj1.value != obj2.value) {
	  alert("输入的密码不一致!");
	  obj1.focus();
      return false;
  }
  else return true;
}

function checkMobile(obj,str,allowNull){
      var pattern=/^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" 格式不对！");
		obj.focus();
		return false;
	}
	else return true;
}
/**********验证身份证号码的有效性***********/
function isIdCard(obj,str,allowNull){
	var pattern = /^\d{15}(\d{2}[A-Za-z0-9])?$/;
	if(!isNotNull(obj,str,allowNull)) return false;
	if(!(pattern.test(obj.value))&&!isNull(obj)){
		alert(str+" 不是正确的身份证号码!");
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
