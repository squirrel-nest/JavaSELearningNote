/*
 * CustomerInfoMgr.java
 *
 * Created on 2006年12月29日, 下午3:12
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.ffcs.util.bo.customerinfomgr;

import com.ffcs.util.domain.customerinfomgr.Codetbl;
import com.ffcs.util.domain.customerinfomgr.Customer;
import com.ffcs.util.dao.customerinfomgr.CustomerInfoDao;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ldh
 */
public class CustomerInfoMgr implements ICustomerInfoMgrFacade{
    
    private CustomerInfoDao dao;
    /**
     * Creates a new instance of CustomerInfoMgr
     */
    public CustomerInfoMgr() {
    }

    public Customer getCustomerInfo(String id) {
        return dao.getCustomerById(id);
    }

    public String getCustomerMaxId() {
         return dao.getCustomerInfoMaxId();
    }

    public List getCustomerInfo(int userid) {
         return dao.getCustomerInfo(userid);
    }

    public List getCustomerInfo(Map map) {
         return dao.getCustomerInfo(map);
    }

    public void deleteCustomerInfo(String id) {
        dao.deleteCustomerInfo(id);
    }

    public void addCustomerInfo(Customer customerInfo) {
        dao.insertCustomerInfo(customerInfo);
    }

    public void updateCustomerInfo(Customer customerInfo, String id) {
        dao.updateCustomerInfo(customerInfo,id);
    }

    public CustomerInfoDao getDao() {
        return dao;
    }

    public void setDao(CustomerInfoDao dao) {
        this.dao = dao;
    }

    public String getCustomerIdByName(String namecn) {
        return dao.getCustomerIdByName(namecn);
    }

    public List getCustomerName(String namecn) {
        return dao.getCustomerName(namecn);
    }

    public List getClildId(String id) {
        return dao.getClildId(id);
    }


    public List getCodetblRemark(Codetbl codetbl) {
        return dao.getCodetblRemark(codetbl);
    }

    public List getCodetblRemarkValue(Codetbl codetbl) {
        return dao.getCodetblRemsrkValue(codetbl);
    }

    public String getCodetblRemarkByValue(Codetbl codetbl) {
        return dao.getCodetblRemsrkByValue(codetbl);
    }

    public List getCodetblRemarkMust(String tablename) {
        return dao.getCodetblRemsrkMust(tablename);
    }
    
    public boolean isOnlyCustomerName(String custname){
        boolean isOnly=false;
        String customerid=dao.getCustomerIdByName(custname);
        if(customerid==null){
            isOnly=true;
        }
        return isOnly;
    }

    public void repleaseCustomerInfo(Map map) {
        dao.repleaseCustomerInfo(map);
    }

    public String getCustomerNameById(String id) {
        return dao.getCustomerNameById(id);
    }

}
