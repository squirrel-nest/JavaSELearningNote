/*
 * CustomerDao.java
 *
 * Created on 2006年12月29日, 下午12:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.ffcs.util.dao.customerinfomgr;

import com.ffcs.util.domain.customerinfomgr.Codetbl;
import com.ffcs.util.domain.customerinfomgr.Customer;
import com.ffcs.util.domain.customerinfomgr.Sysdata;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 *
 * @author ldh
 */
public class CustomerInfoDao extends SqlMapClientDaoSupport{
    
    /** Creates a new instance of CustomerDao */
    public CustomerInfoDao() {
    }

    public Customer getCustomerById(String strId) {
        return (Customer)getSqlMapClientTemplate().queryForObject("getCustomerInfoById",strId);
    }

    public String getCustomerInfoMaxId() {
        return ((String)getSqlMapClientTemplate().queryForObject("getMaxCustomerId"));
    }
    

    public List getCustomerInfo(int userid) {
        return getSqlMapClientTemplate().queryForList("getCustomerInfoList",new Integer(userid));
    }

    public List getCustomerInfo(Map map) {
        return getSqlMapClientTemplate().queryForList("getCustomerInfoListByTerm",map);
    }

    public void deleteCustomerInfo(String customerId) {
        getSqlMapClientTemplate().delete("deleteCustomerInfoById",customerId);
    }

    public void insertCustomerInfo(Customer customer) {
        getSqlMapClientTemplate().insert("addCustomerInfo",customer);
    }

    public void updateCustomerInfo(Customer customer, String CustomerId) {
        getSqlMapClientTemplate().update("updateCustomerInfoById",customer);
    }
    
    public String getCustomerIdByName(String namecn){
        return ((String)getSqlMapClientTemplate().queryForObject("getCustomerIdByName",namecn));
    }
    public List getCustomerName(String namecn){
        return getSqlMapClientTemplate().queryForList("getCustomerName",namecn);
    }
    
    
    public List getCodetblRemark(Codetbl codetbl){
        return getSqlMapClientTemplate().queryForList("getCodetblRemark",codetbl);
    }
    public List getCodetblRemsrkValue(Codetbl codetbl){
        return getSqlMapClientTemplate().queryForList("getCodetblRemsrkValue",codetbl);
    }
    public List getClildId(String id){
        return getSqlMapClientTemplate().queryForList("getClildId",id);
    }
    
    public String getCodetblRemsrkByValue(Codetbl codetbl){
        return (String)getSqlMapClientTemplate().queryForObject("getCodetblRemsrkByValue",codetbl);
    }
    public List getCodetblRemsrkMust(String tablename){
        return getSqlMapClientTemplate().queryForList("getCodetblRemsrkMust",tablename);
    }
    public void repleaseCustomerInfo(Map map){
        getSqlMapClientTemplate().update("repleaseCustomerInfo",map);
    }
    public String getCustomerNameById(String id){
        return (String)getSqlMapClientTemplate().queryForObject("getCustomerNameById1",id);
    }
}
