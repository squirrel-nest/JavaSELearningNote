/**
 * <p>Title:������Դ��̬����ϵͳ</p>
 * <p>Description:���ö���Form����</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
 * @date 2006-04-17
 * @author licm
 * @version 1.0
 */
package com.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.common.log.LogFactory;
import com.common.log.LoggerIfc;

public class BaseActionForm extends ActionForm {

	//�������Ĵ���������ADD,DEL,UPDATE��
	private String postMethod;

	 public static LoggerIfc log;
	 
     static {    	
	        try {
		    	log = LogFactory.getLogger("FACE");
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	 }	 
	
	public BaseActionForm() {
	}

	public ActionErrors validate(ActionMapping mapping,	HttpServletRequest request) {
		ActionErrors actionErrors = null;
		ArrayList errorList = new ArrayList();
		doValidate(mapping, request, errorList);
		if (!errorList.isEmpty()) {
			actionErrors = new ActionErrors();
			actionErrors.add(ActionErrors.GLOBAL_ERROR, new ActionError("global.error"));
		}
		return actionErrors;
	}

	public void doValidate(ActionMapping mapping, HttpServletRequest request,	List errors) {
	}

	protected void addErrorIfStringEmpty(List errors, String message,	String value) {
		if (value == null || value.trim().length() < 1) {
			errors.add(message);
		}
	}

	public String getPostMethod() {
		return postMethod != null ? postMethod.trim() : "0";
	}

	public void setPostMethod(String postMethod) {
		this.postMethod = postMethod;
	}

}