/**
 * <p>Title:电信资源动态管理系统</p>
 * <p>Description:网格数据字符串分割</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:福建富士通信息软件有限公司</p>
 * @date 2006-04-19
 * @author licm
 * @version 1.0
 */
package com.util; 

import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.common.log.LogFactory;
import com.common.log.LoggerIfc;
import com.domain.ClassInfo;

public class BaseGridDataProcessor {
	public static LoggerIfc log = LogFactory.getLogger("");
	
	 /**
	   * Gets the name of the class the instance provides information for
	   *
	   * @return The class name
	   */	
	public static final List spliterGridData(String Griddata, String className) throws Exception 
	{
		if(Griddata==null) return null;
		Object obj = null;
		ArrayList result = new ArrayList();
		SAXReader reader = new SAXReader();
		StringReader sread = new StringReader(Griddata);
		Document document = reader.read(sread);
		if(document==null) return null;
		//try {
			List nodes = document.selectNodes("//data/row");
			Iterator iter = nodes.iterator();
			while(iter.hasNext()){
				Element el = (Element)iter.next();
				Iterator iter2 = el.elementIterator();			
				obj = Class.forName(className).newInstance();
				while(iter2.hasNext()){
					Element childEl = (Element)iter2.next();
					//System.out.println("el name :" + childEl.getName());
					//System.out.println("el value:" + childEl.getTextTrim());
					String name = childEl.getName();
					String value = childEl.getTextTrim();
					
					Method method = ClassInfo.getInstance(obj.getClass()).getSetter(name);
					Class type = method.getParameterTypes()[0];
					//Method method = obj.getClass().getMethod("set" + (name), new Class[]{value.getClass()});
					if(type.getName().endsWith("int")){
						method.invoke(obj, new Object[]{new Integer(value)});
					}else if(type.getName().endsWith("date")){
						method.invoke(obj, new Object[]{new java.util.Date(value)});
					}else {
						method.invoke(obj, new Object[]{value});
					}
					//log.debug("&&&" + name + ",---" + value+"****"+type.getName());
				}
				result.add(obj);
				//System.out.println("*****");
			}			
		/**}catch(ClassNotFoundException e){
			System.out.println("--------Class not found!--------");
			e.printStackTrace();
		}catch(NoSuchMethodException e) {
			System.out.println("--------No such method!--------");
			e.printStackTrace();
		}catch(InvocationTargetException e){
			System.out.println("--------Invocation target exception!--------");
			e.printStackTrace();
		}catch (IllegalAccessException e){
			System.out.println("--------Illegal access exception!--------");
			e.printStackTrace();
		}catch(InstantiationException e){
			System.out.println("--------Instantiation exception!--------");
			e.printStackTrace();
		}catch(Exception e){
			System.out.println("------- Exception!--------");
			e.printStackTrace();
		}*/
		return result;	
	}
}