package com.util; 

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class SelectSet {
   /**
    * ͨ��ȡ������ֵ
    * @param name:���ֶ���
    * @param width:���(�ַ���)
    * @param listname:Ҫ���ɵ�������������б�
    * @param p_id:���������е�����ֵ
    * @param p_name:��������ʾֵ
    * @param valuenow:�ֶε�ʵ��ֵ
    * @return
	* @throws IllegalArgumentException
	* @throws IllegalAccessException
	* @throws InvocationTargetException
	* @throws NoSuchMethodException
	* @throws SecurityException
    */
   public  static String getSelect(String name,String width,List listname,String p_id,String p_name,String valuenow) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
           return getSelectWithOnchange(name,width,listname,p_id,p_name,"",valuenow);
   }
   /**
    * ͨ��ȡ������ֵ(�����onChange�¼�)
    * @param name:���ֶ���
    * @param width:���(�ַ���)
    * @param listname:Ҫ���ɵ�������������б�
    * @param p_id:���������е�����ֵ
    * @param p_name:��������ʾֵ
    * @param valuenow:�ֶε�ʵ��ֵ
    * @param event:�����¼�
    * @return
	* @throws IllegalArgumentException
	* @throws IllegalAccessException
	* @throws InvocationTargetException
	* @throws NoSuchMethodException
	* @throws SecurityException
    */
   public  static String getSelectWithOnchange(String name,String width,List listname,String p_id,String p_name,String event,String valuenow) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
       String[] selectStr = new String[3];       
       if(listname==null || listname.size()< 1){
           selectStr[0] = "<select name=\""+name+"\" id=\""+name+"\" style=\"width:"+width+";height:100%;font-size:12px;background-color:#F2F5FB\" onchange=\""+ event+"\">\n<option value=\"\"></option>";
           selectStr[1] = "\n";
           selectStr[2] = "</select>";
       }else{
		       p_id = "get"+getStandardName(p_id);
		       p_name = "get"+getStandardName(p_name);
		
		       selectStr[0] = "<select name=\""+name+"\" id=\""+name+"\" style=\"width:"+width+";height:100%;font-size:12px;background-color:#F2F5FB\" onchange=\""+ event +"\" >\n<option value=\"\"></option>";

		       java.util.Iterator ite_type = listname.iterator();        
		       while(ite_type.hasNext()){
		           Object  typeobject = (Object)ite_type.next();
		           String vid = (String) typeobject.getClass().getMethod(p_id,null).invoke(typeobject,null);
		           String vname = (String) typeobject.getClass().getMethod(p_name,null).invoke(typeobject,null);
		           if(vid.equals(valuenow)){
		               selectStr[1] += "<option value=\"" + vid + "\" selected> " + vname + "</option>\n";  
		           }else{
		               selectStr[1] += "<option value=\"" + vid + "\"> "  + vname + "</option>\n";
		           }
		       }      
		       selectStr[2] = "</select>";
       }
       return selectStr[0]+selectStr[1]+selectStr[2];
   }   
   
   /**
    * ͨ��ȡ������ֵ(�����onChange�¼�)����һ������ʾ��һ��Ϊ�յĹ��ܡ�
    * @param name:���ֶ���
    * @param width:���(�ַ���)
    * @param listname:Ҫ���ɵ�������������б�
    * @param p_id:���������е�����ֵ
    * @param p_name:��������ʾֵ
    * @param valuenow:�ֶε�ʵ��ֵ
    * @param event:�����¼�
    * @return
	* @throws IllegalArgumentException
	* @throws IllegalAccessException
	* @throws InvocationTargetException
	* @throws NoSuchMethodException
	* @throws SecurityException
    */
   public  static String getSelectNoListNullWithOnchange(String name,String width,List listname,String p_id,String p_name,String event,String valuenow) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
       String[] selectStr = new String[3];       
       if(listname==null || listname.size()< 1){
           selectStr[0] = "<select name=\""+name+"\" id=\""+name+"\" style=\"width:"+width+";height:100%;font-size:12px;background-color:#F2F5FB\" onchange=\""+ event+"\">\n<option value=\"\"></option>";
           selectStr[1] = "\n";
           selectStr[2] = "</select>";
       }else{
		       p_id = "get"+getStandardName(p_id);
		       p_name = "get"+getStandardName(p_name);
		
		       selectStr[0] = "<select name=\""+name+"\" id=\""+name+"\" style=\"width:"+width+";height:100%;font-size:12px;background-color:#F2F5FB\" onchange=\""+ event +"\" >\n";

		       java.util.Iterator ite_type = listname.iterator();        
		       while(ite_type.hasNext()){
		           Object  typeobject = (Object)ite_type.next();
		           String vid = (String) typeobject.getClass().getMethod(p_id,null).invoke(typeobject,null);
		           String vname = (String) typeobject.getClass().getMethod(p_name,null).invoke(typeobject,null);
		           if(vid.equals(valuenow)){
		               selectStr[1] += "<option value=\"" + vid + "\" selected> " + vname + "</option>\n";  
		           }else{
		               selectStr[1] += "<option value=\"" + vid + "\"> "  + vname + "</option>\n";
		           }
		       }      
		       selectStr[2] = "</select>";
       }
       return selectStr[0]+selectStr[1]+selectStr[2];
   }   
      
   private static String getStandardName(String name){
       name = name.toLowerCase();
       String one = name.substring(0, 1);
       String two = name.substring(1, name.length());
       return one.toUpperCase() + two;    
   }
   
}
