/**
 * <p>Title:大客户业务质量实时监视系统</p>
 * <p>Description:大客户逻辑层接口</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:福建富士通信息软件有限公司</p>
 * @date 2006-12-23
 * @author licm
 * @version 1.0
 */

package com.ffcs.util.bo.alarmwatch;

import com.ffcs.util.dao.Page;
import com.ffcs.util.domain.alarmwatch.CirAlarm;
import com.ffcs.util.domain.alarmwatch.Customer;
import com.ffcs.util.domain.alarmwatch.Filtercontbl;
import com.ffcs.util.domain.alarmwatch.Region;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface CustomerWFFacade {
    
    /*Describe:获得大客户树
     *Author:licm
     *Date:2006-12-26
     */
    public List getCustomerList() throws DataAccessException;
    
    /*Describe:获得大客户树
     *Author:licm
     *Date:2006-12-26
     */
    public List getChildCustomerList(String customerid) throws DataAccessException;

    /*Describe:获得某大客户及下属子客户，包含电路的其他子客户
     *Author:licm
     *Date:2007-01-22
     */
    public List getChildCustomerList2(String circuitids) throws DataAccessException;
    
    /*Describe:获得某大客户
     *Author:licm
     *Date:2007-01-22
     */
    public Customer getCustomerByID(String customerid) throws DataAccessException;

    
    /*Describe:根据行业获得大客户列表
     *Author:licm
     *Date:2007-01-08
     */
    public List getCustomerListByTrade(String tradeid) throws DataAccessException;

    /*Describe:电路拓扑过滤，获取客户节点
     *Author:licm
     *Date:2007-01-14
     */
    public List getChildCustomerListByCon(Map map) throws DataAccessException;
    
    /*Describe:获得区域列表
     *Author:licm
     *Date:2007-02-09
     */
    public List getRegionList2sel() throws DataAccessException;
    
    /*Describe:客户查询
     *Author:licm
     *Date:2007-02-10
     */
    public List findCustomerByCondiction(Map map) throws DataAccessException;

    /*Describe:客户查询缓存,采用类似PL/SQL的查询下一批的方式解决此问题
     *Author:licm
     *Date:2007-02-12
     */
    public Page findCustomerByCondictionCache(Map map) throws DataAccessException;

    /*Describe:电路查询缓存,采用类似PL/SQL的查询下一批的方式解决此问题,查询告警电路
     *Author:licm
     *Date:2007-07-05
     */
    public Page findCustAlarmByCondictionCache4CircuitTopo(Map map) throws DataAccessException;
    
    /*Describe:根据选中的大客户id字符串获得大客户列表
     *Author:licm
     *Date:2007-02-14
     */
    public List getCustomerListByCustomerids(String customerids) throws DataAccessException;

    /*Describe:根据登陆用户id获得拥有权限的大客户ID
     *Author:licm
     *Date:2007-03-01
     */
    public List getCustomeridsByUserid(int userid) throws DataAccessException;
    
    /*Describe:根据登陆用户id获得大客户列表
     *Author:licm
     *Date:2007-03-01
     */
    public List getCustomerListByUserid(int userid) throws DataAccessException;

    /*Describe:根据当前登陆用户ID和当前双击的行业ID获得大客户列表
     *Author:licm
     *Date:2007-03-02
     */
    public List getCustomerListByTradeAndUserid(Map map) throws DataAccessException;
    
    public String synDataByCustomerID(int customerID) throws DataAccessException;
    public String synDataByCircuitID(int circuitID, int property) throws DataAccessException;
    
    /*Describe:电路拓扑过滤，获取客户节点，由于之前的直接传递SQL时电路过多时会报不能分配内存的错误，所以修改方法
     *Author:licm
     *Date:2007-06-28
     */
    public List getChildCustomerListByConProc(Map map) throws DataAccessException;
    
    /*Describe:根据选中的大客户id字符串获得区域列表
     *Author:licm
     *Date:2007-07-04
     */
    public List getRegionListByCustomerids(String customerids) throws DataAccessException;
    
    /*Describe:获得某区域
     *Author:licm
     *Date:2007-07-04
     */
    public Region getRegionByID(String regionid) throws DataAccessException;

    /*Describe:获得大客户过滤结果列表
     *Author:luodenghui
     *Date:2007-07-09
     */
    public List getFilgercontblList(String userid);
    /*Describe:获得最新的大客户过滤结果
     *Author:luodenghui
     *Date:2007-07-09
     */
    public Filtercontbl getFilgercontbl(String userid);
    /*Describe:获得最新的大客户过滤结果
     *Author:luodenghui
     *Date:2007-07-09
     */
    public String getMaxFILTERCONID();
    /*Describe:添加大客户过滤结果
     *Author:luodenghui
     *Date:2007-07-09
     */
    public void addFilgercontb(Filtercontbl filtercontbl);
    /*Describe:获得最新的大客户过滤结果
     *Author:luodenghui
     *Date:2007-07-09
     */
    public Filtercontbl getFilgercontblByName(Map map);
         /*Describe:添加大客户过滤结果是否重名
     *Author:luodenghui
     *Date:2007-07-09
     */
    public boolean isHasFilgercontbName(Map map);
    /*Describe:添加大客户过滤结果是否重名
     *Author:luodenghui
     *Date:2007-07-09
     */
    public void updateFiltercontblByName(Filtercontbl filtercontbl);
    
    /*Describe:删除过滤保存条件记录
     *Author:licm
     *Date:2007-07-16
     */
    public void delFiltercontbl(String names) throws DataAccessException;
    
    /*Describe:根据customerids获取manageobject列表
     *Author:licm
     *Date:2007-08-13
     */
    public List getManageobjectByCustomerid(String customerids) throws DataAccessException;
    
    //根据电路ID删除数据
    public String delDataByCircuitID(int circuitID,int property)throws DataAccessException;
    
    //根据客户ID删除数据 资源数据不存在
    public String delDataByCustomID(int customID) throws DataAccessException;
    
    /*Describe:根据manageobject获取ciralarmtbl表里的相应最大eventtime
     *Author:licm
     *Date:2007-08-14
     */
    public String getMaxtimeByManageobject(String manageobject) throws DataAccessException;
    
    /*Describe:根据managedobject和eventtime获取ciralarm对象
     *Author:licm
     *Date:2007-08-15
     */
    public CirAlarm getCirAlarmByMOAndET(Map map) throws DataAccessException;
    
    /*Describe:根据告警数量提示打开相应的告警客户列表
     *Author:licm
     *Date:2007-08-22
     */
    public Page findCustAlarm4AlarmNum(Map map) throws DataAccessException;    
    
}