/**
 * <p>Title:电信资源动态管理系统</p>
 * <p>Description:Log工厂类</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:福建富士通信息软件有限公司</p>
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
* <p>由log工厂产生log4j实现类。</p> 
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