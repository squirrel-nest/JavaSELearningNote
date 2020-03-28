/**
 * <p>Title:������Դ��̬����ϵͳ</p>
 * <p>Description:Log�ӿ�ʵ����</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
 * 2006-04-17
 * @author licm
 * @version 1.0
 */

package com.common.log;

import org.apache.log4j.Logger;

/** 
* <p>log4jʵ���ࡣ</p> 
*/ 

public class Log4jLogger implements LoggerIfc
{

    public Log4jLogger(Logger logger)
    {
        log4jLogger = logger;
    }

    public void info(Object obj)
    {
        log4jLogger.info(obj);
    }

    public void info(Object obj, Throwable throwable)
    {
        log4jLogger.info(obj, throwable);
    }

    public void debug(Object obj)
    {
        log4jLogger.debug(obj);
    }

    public void debug(Object obj, Throwable throwable)
    {
        log4jLogger.debug(obj, throwable);
    }

    public void error(Object obj)
    {
        log4jLogger.error(obj);
    }

    public void error(Object obj, Throwable throwable)
    {
        log4jLogger.error(obj, throwable);
    }

    public void warn(Object obj)
    {
        log4jLogger.warn(obj);
    }

    public void warn(Object obj, Throwable throwable)
    {
        log4jLogger.warn(obj, throwable);
    }

    public void fatal(Object obj)
    {
        log4jLogger.fatal(obj);
    }

    public void fatal(Object obj, Throwable throwable)
    {
        log4jLogger.fatal(obj, throwable);
    }

    public LoggerIfc getLogger(Class class1)
    {
        Log4jLogger _tmp = this;
        return new Log4jLogger(Logger.getLogger(class1));
    }

    public LoggerIfc getLogger(String s)
    {
        Log4jLogger _tmp = this;
        return new Log4jLogger(Logger.getLogger(s));
    }

    private Logger log4jLogger;
}