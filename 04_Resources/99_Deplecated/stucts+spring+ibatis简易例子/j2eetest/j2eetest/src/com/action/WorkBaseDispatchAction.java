/**
 * <p>Title:电信资源动态管理系统</p>
 * <p>Description:处理基类</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:福建富士通信息软件有限公司</p>
 * @date 2006-04-17
 * @author licm
 * @version 1.0
 */
package com.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.common.log.LogFactory;
import com.common.log.LoggerIfc;

public class WorkBaseDispatchAction extends BaseDispatchAction
{
	 public static LoggerIfc log;
	 public ActionErrors errors = new ActionErrors();
	 public ActionMessages messages = new ActionMessages();
	 
     static {    	
	        try {
		    	if(LogFactory.getLogger("FACE")!=null) {
		    	     log = LogFactory.getLogger("FACE");
		    	}
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	 }	 
	
	 public WorkBaseDispatchAction() {
	    super();
	 }

	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException,Exception 
	 {
	 	return super.execute(mapping, form, request, response);
	 }	 
}