/**
 * <p>Title:电信资源动态管理系统</p>
 * <p>Description:处理基类</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:福建富士通信息软件有限公司</p>
 * @date 2006-04-17
 * @author licm
 * @editor zhonghr,yinyq,linzw,licm
 * @version 1.0
 */
package com.action;

import javax.servlet.ServletContext;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.actions.DispatchAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.logic.TestObjWorkFormFacade;

public abstract class BaseDispatchAction extends DispatchAction {

	private TestObjWorkFormFacade testobjWorkForm;
	
	public void setServlet(ActionServlet actionServlet) {
		super.setServlet(actionServlet);
		ServletContext servletContext = actionServlet.getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils .getRequiredWebApplicationContext(servletContext);
		
		// this.workForm = (workFormFacade) wac.getBean("workForm");
		this.testobjWorkForm = (TestObjWorkFormFacade) wac.getBean("testObjWorkForm");
	}

	public TestObjWorkFormFacade getTestobjWorkForm() {
		return testobjWorkForm;
	}

	public void setTestobjWorkForm(TestObjWorkFormFacade testobjWorkForm) {
		this.testobjWorkForm = testobjWorkForm;
	}

}