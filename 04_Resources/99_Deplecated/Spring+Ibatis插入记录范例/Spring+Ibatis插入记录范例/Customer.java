/*
 * Customer.java
 *
 * Created on 2006年12月20日, 上午9:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.ffcs.util.domain.customerinfomgr;

/**
 *
 * @author CHENJH
 */
public class Customer {
    private String customerid;
    private String namecn;
    private int tradeclsid;
    private String nameen;
    private String custcode;
    private String custaddr;
    private int custgrade;
    private int custlevel;
    private int custtype;
    private int servicelevel;
    private int creditlevel;
    private String linkname;
    private String linkphone;
    private String linkmobile;
    private String linkemail;
    private String linkfax;
    private String mngrname;
    private String mngrphone;
    private String mngrmobile;
    private String parentcustomerid;
    private String remark;
    private int regionid;
    private String tnamecn;
    private String rnamecn;
    private String parentname;
    private int userid;
     
    private String oldName;// 曾用名 海南
    private String no;// 编号/贵宾卡号 海南
    private String bank;//帐号所在银行 海南
    private String counts;// 银行帐号 海南
    private String fileNO;//对应的文件编号 海南
    private String abbrevPY;//字符串
    private String abbrevCN;// 字符串
    
    public Customer() {
    }
    
    public String getCustomerid() {
        return customerid;
    }
    
    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }
    
    public String getNamecn() {
        return namecn;
    }
    
    public void setNamecn(String namecn) {
        this.namecn = namecn;
    }
    
    public int getTradeclsid() {
        return tradeclsid;
    }
    
    public void setTradeclsid(int tradeclsid) {
        this.tradeclsid = tradeclsid;
    }
    
    public String getNameen() {
        return nameen;
    }
    
    public void setNameen(String nameen) {
        this.nameen = nameen;
    }
    
    public String getCustcode() {
        return custcode;
    }
    
    public void setCustcode(String custcode) {
        this.custcode = custcode;
    }
    
    public String getCustaddr() {
        return custaddr;
    }
    
    public void setCustaddr(String custaddr) {
        this.custaddr = custaddr;
    }
    
    public int getCustgrade() {
        return custgrade;
    }
    
    public void setCustgrade(int custgrade) {
        this.custgrade = custgrade;
    }
    
    public int getCustlevel() {
        return custlevel;
    }
    
    public void setCustlevel(int custlevel) {
        this.custlevel = custlevel;
    }
    
    public int getCusttype() {
        return custtype;
    }
    
    public void setCusttype(int custtype) {
        this.custtype = custtype;
    }
    
    public int getServicelevel() {
        return servicelevel;
    }
    
    public void setServicelevel(int servicelevel) {
        this.servicelevel = servicelevel;
    }
    
    public int getCreditlevel() {
        return creditlevel;
    }
    
    public void setCreditlevel(int creditlevel) {
        this.creditlevel = creditlevel;
    }
    
    public String getLinkname() {
        return linkname;
    }
    
    public void setLinkname(String linkname) {
        this.linkname = linkname;
    }
    
    public String getLinkphone() {
        return linkphone;
    }
    
    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone;
    }
    
    public String getLinkmobile() {
        return linkmobile;
    }
    
    public void setLinkmobile(String linkmobile) {
        this.linkmobile = linkmobile;
    }
    
    public String getLinkemail() {
        return linkemail;
    }
    
    public void setLinkemail(String linkemail) {
        this.linkemail = linkemail;
    }
    
    public String getLinkfax() {
        return linkfax;
    }
    
    public void setLinkfax(String linkfax) {
        this.linkfax = linkfax;
    }
    
    public String getMngrname() {
        return mngrname;
    }
    
    public void setMngrname(String mngrname) {
        this.mngrname = mngrname;
    }
    
    public String getMngrphone() {
        return mngrphone;
    }
    
    public void setMngrphone(String mngrphone) {
        this.mngrphone = mngrphone;
    }
    
    public String getMngrmobile() {
        return mngrmobile;
    }
    
    public void setMngrmobile(String mngrmobile) {
        this.mngrmobile = mngrmobile;
    }
    
    public String getParentcustomerid() {
        return parentcustomerid;
    }
    
    public void setParentcustomerid(String parentcustomerid) {
        this.parentcustomerid = parentcustomerid;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public int getRegionid() {
        return regionid;
    }
    
    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }
    
    public String getTnamecn() {
        return tnamecn;
    }
    
    public void setTnamecn(String tnamecn) {
        this.tnamecn = tnamecn;
    }
    
    public String getRnamecn() {
        return rnamecn;
    }
    
    public void setRnamecn(String rnamecn) {
        this.rnamecn = rnamecn;
    }
    
    public String getParentname() {
        return parentname;
    }
    
    public void setParentname(String parentname) {
        this.parentname = parentname;
    }
    
    public int getUserid() {
        return userid;
    }
    
    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    public String getFileNO() {
        return fileNO;
    }

    public void setFileNO(String fileNO) {
        this.fileNO = fileNO;
    }

    public String getAbbrevPY() {
        return abbrevPY;
    }

    public void setAbbrevPY(String abbrevPY) {
        this.abbrevPY = abbrevPY;
    }

    public String getAbbrevCN() {
        return abbrevCN;
    }

    public void setAbbrevCN(String abbrevCN) {
        this.abbrevCN = abbrevCN;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
    
}

