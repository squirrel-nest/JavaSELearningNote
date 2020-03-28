/**
 * <p>Title:电信资源动态管理系统</p>
 * <p>Description:公司表基本对象类</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:福建富士通信息软件有限公司</p>
 * @date 2006-07-20
 * @author licm
 * @version 1.0
 */
package com.ffcs.zydt.domain;

import java.io.Serializable;

public class CompTBL implements Serializable {
	//compid, name, parentid, remark, complevel
	private int compid;

	private String name;

	private int parentid;

	private String remark;

	private int complevel;
	
	private String parentname;

	public int getCompid() {
		return compid;
	}

	public void setCompid(int compid) {
		this.compid = compid;
	}

	public int getComplevel() {
		return complevel;
	}

	public void setComplevel(int complevel) {
		this.complevel = complevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
	
}
