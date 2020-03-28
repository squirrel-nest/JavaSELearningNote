/*
 * ICustomerInfoMgrFacade.java
 *
 * Created on 2006年12月28日, 上午10:56
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.ffcs.util.bo.customerinfomgr;

import com.ffcs.util.domain.customerinfomgr.Codetbl;
import com.ffcs.util.domain.customerinfomgr.Customer;
import com.ffcs.util.domain.customerinfomgr.Sysdata;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ldh
 */
public interface ICustomerInfoMgrFacade {
    public Customer getCustomerInfo(String id);
    public String getCustomerMaxId();
    public List getCustomerInfo(int userid);
    public List getCustomerInfo(Map map);
    public void deleteCustomerInfo(String tradeClsId);
    public void addCustomerInfo(Customer customerInfo);
    public void updateCustomerInfo(Customer customerInfo,String tradeClsId);
    public String getCustomerIdByName(String namecn);
    public List getCustomerName(String namecn);
    public List getCodetblRemark(Codetbl codetbl);
    public List getCodetblRemarkValue(Codetbl codetbl);
    public List getClildId(String id);
    public String getCodetblRemarkByValue(Codetbl codetbl);
    public List getCodetblRemarkMust(String tablename);
    public boolean isOnlyCustomerName(String custname);
    public void repleaseCustomerInfo(Map map);
    public String getCustomerNameById(String id);
}
