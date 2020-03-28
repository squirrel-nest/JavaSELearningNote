/**
 * <p>Title:电信资源动态管理系统</p>
 * <p>Description:资源对象属性配置Form实现类</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:福建富士通信息软件有限公司</p>
 * @date 2006-04-17
 * @author lzw
 * @version 1.0
 */

package com.form;

import com.form.BaseActionForm;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import com.util.StringUtils;

public class TestForm extends BaseActionForm {	

	private String id;
	private String name;
	private String remark;
	private String isnew;	//0-新增,1-编辑
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIsnew() {
		return isnew;
	}
	public void setIsnew(String isnew) {
		this.isnew = isnew;
	}

	
}