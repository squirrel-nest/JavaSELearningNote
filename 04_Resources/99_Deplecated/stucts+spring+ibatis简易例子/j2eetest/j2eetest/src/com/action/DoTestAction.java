/**
 * <p>Title:������Դ��̬����ϵͳ</p>
 * <p>Description:��˾ά��������</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
 * @date 2006-07-20
 * @author lzw
 * @version 1.0
 */
package com.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.springframework.beans.support.PagedListHolder;

import com.domain.Test;
import com.util.ParamUtils;
import com.action.WorkBaseDispatchAction;
import com.form.TestForm;

public class DoTestAction extends WorkBaseDispatchAction {
	
	// ��������
	public ActionForward getTestInfList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		try {
			
			TestForm testform = (TestForm) form;
			HashMap map = new HashMap();
			if (testform.getId()==null || testform.getId().equals(""))
				map.put("id",null);
			else
				map.put("id",testform.getId());
			
			ArrayList arry_getinf = new ArrayList(); 
			arry_getinf = (ArrayList)this.getTestobjWorkForm().getTestInfWithMap(map);
			request.setAttribute("testInfList", arry_getinf);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e.getMessage());
			errors.add("error", new ActionMessage("errors.comptree"));
		}
		return mapping.findForward("getTestInfList");
	}
	
	//������/�༭����
	public ActionForward openEditWindow(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		try {
			
			String isNew = request.getParameter("isnew")==null?"0":(String)request.getParameter("isnew");
			ArrayList arry_getinf = new ArrayList(); 			
			if (isNew.equals("0")){
				//����
			}else{
				//�༭
				String curId = request.getParameter("curid")==null?"-1":(String)request.getParameter("curid");
				HashMap map = new HashMap();
				map.put("id",curId);
				
				Test test = (Test)this.getTestobjWorkForm().getTestInfWithMap(map).get(0);		
				TestForm testForm = (TestForm) form;				
				PropertyUtils.copyProperties(testForm,test);
			}
			
			request.setAttribute("testInfList", arry_getinf);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e.getMessage());
			errors.add("error", new ActionMessage("errors.comptree"));
		}
		return mapping.findForward("openEditWindow");
	}	
	
	
	/*//ɾ��
	public ActionForward delOrg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		errors.clear();
		messages.clear();
		try{
			String compid = request.getParameter("compid")==null?"0":(String)request.getParameter("compid");
			this.getCompTBLWorkForm().delCompTBL(compid);
			request.setAttribute("refresh", "tree");
			request.setAttribute("compid", "1");
		}catch(Exception e){
			e.printStackTrace();
			log.debug(e.getMessage());
			errors.add("delerror", new ActionMessage("errors.org.delFaile"));
		}
		if (!errors.isEmpty()) {
			saveMessages(request, errors);
		} else {
			messages.add("delsuccess", new ActionMessage("messages.org.delSuccess"));
			saveMessages(request, messages);
		}
		return getRootCompForm(mapping, form, request, response);
	}
	*/
	
	//�޸�
	public ActionForward saveTestInf(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		errors.clear();
		messages.clear();
		try {
			String isNew = request.getParameter("isnew")==null?"0":(String)request.getParameter("isnew"); 
			Test test = new Test();
			TestForm testForm = (TestForm) form;
			PropertyUtils.copyProperties(test, testForm);
			
			if (isNew.equals("0"))
				//����
				this.getTestobjWorkForm().insertTestTbl(test);
			else
				this.getTestobjWorkForm().updateTestTbl(test);
			request.setAttribute("isnew",isNew);
			
		}catch (Exception e) {
			log.error(e.getMessage());
			errors.add("error", new ActionMessage("�������ʧ��",false));
		}
		if (!errors.isEmpty()) {
			saveMessages(request, errors);
			return mapping.getInputForward();
		} else {
			messages.add("message", new ActionMessage("��������ɹ�",false));
			saveMessages(request, messages);
		}
		return mapping.findForward("openEditWindow");		
	}
	
}