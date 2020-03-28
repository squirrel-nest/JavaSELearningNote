/**
 * <p>Title:������Դ��̬����ϵͳ</p>
 * <p>Description:Log�ӿ���</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
 * ${date}
 * @author licm
 * @version 1.0
 */

package com.common.log;

/** 
* <p>log4jʵ�ֽӿڡ�</p> 
*/ 

public interface LoggerIfc
{

    public abstract void debug(Object obj);

    public abstract void debug(Object obj, Throwable throwable);

    public abstract void info(Object obj);

    public abstract void info(Object obj, Throwable throwable);

    public abstract void warn(Object obj);

    public abstract void warn(Object obj, Throwable throwable);

    public abstract void error(Object obj);

    public abstract void error(Object obj, Throwable throwable);

    public abstract void fatal(Object obj);

    public abstract void fatal(Object obj, Throwable throwable);

    public abstract LoggerIfc getLogger(Class class1);

    public abstract LoggerIfc getLogger(String s);
}