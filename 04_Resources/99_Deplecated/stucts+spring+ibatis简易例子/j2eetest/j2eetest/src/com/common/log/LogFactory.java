/**
 * <p>Title:������Դ��̬����ϵͳ</p>
 * <p>Description:Log������</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
 * ${date}
 * @author licm
 * @version 1.0
 */

package com.common.log;

//import java.io.File;
//import com.zkhx.work.SystemResource;
import org.apache.log4j.LogManager;
//import org.apache.log4j.xml.DOMConfigurator;
//import org.apache.log4j.PropertyConfigurator;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;


/** 
* <p>��log��������log4jʵ���ࡣ</p> 
*/ 

public class LogFactory
{

    public LogFactory()
    {
    }

    public static LoggerIfc getLogger(String s)
    {
        return new Log4jLogger(LogManager.getLogger(s));
    }

    public static LoggerIfc getLogger(Class class1)
    {
        return new Log4jLogger(LogManager.getLogger(class1));
    }

/*    
    private static String fileName;
    private static String workHome;

    static 
    {   	
    	workHome = SystemResource.workHome;
    	if(workHome==null){
    		workHome = SystemResource.getInstance().getWorkHome();
    	}
    	//fileName = "log4j.xml";
        //DOMConfigurator domconfigurator = new DOMConfigurator();
        //DOMConfigurator.configure(workHome + File.separator + fileName);
        PropertyConfigurator.configure(workHome + File.separator + "log4j.properties");
    }
    */
}