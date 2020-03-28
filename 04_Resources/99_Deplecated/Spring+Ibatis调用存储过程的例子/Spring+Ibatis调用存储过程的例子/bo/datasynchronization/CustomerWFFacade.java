/**
 * <p>Title:��ͻ�ҵ������ʵʱ����ϵͳ</p>
 * <p>Description:��ͻ��߼���ӿ�</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
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
    
    /*Describe:��ô�ͻ���
     *Author:licm
     *Date:2006-12-26
     */
    public List getCustomerList() throws DataAccessException;
    
    /*Describe:��ô�ͻ���
     *Author:licm
     *Date:2006-12-26
     */
    public List getChildCustomerList(String customerid) throws DataAccessException;

    /*Describe:���ĳ��ͻ��������ӿͻ���������·�������ӿͻ�
     *Author:licm
     *Date:2007-01-22
     */
    public List getChildCustomerList2(String circuitids) throws DataAccessException;
    
    /*Describe:���ĳ��ͻ�
     *Author:licm
     *Date:2007-01-22
     */
    public Customer getCustomerByID(String customerid) throws DataAccessException;

    
    /*Describe:������ҵ��ô�ͻ��б�
     *Author:licm
     *Date:2007-01-08
     */
    public List getCustomerListByTrade(String tradeid) throws DataAccessException;

    /*Describe:��·���˹��ˣ���ȡ�ͻ��ڵ�
     *Author:licm
     *Date:2007-01-14
     */
    public List getChildCustomerListByCon(Map map) throws DataAccessException;
    
    /*Describe:��������б�
     *Author:licm
     *Date:2007-02-09
     */
    public List getRegionList2sel() throws DataAccessException;
    
    /*Describe:�ͻ���ѯ
     *Author:licm
     *Date:2007-02-10
     */
    public List findCustomerByCondiction(Map map) throws DataAccessException;

    /*Describe:�ͻ���ѯ����,��������PL/SQL�Ĳ�ѯ��һ���ķ�ʽ���������
     *Author:licm
     *Date:2007-02-12
     */
    public Page findCustomerByCondictionCache(Map map) throws DataAccessException;

    /*Describe:��·��ѯ����,��������PL/SQL�Ĳ�ѯ��һ���ķ�ʽ���������,��ѯ�澯��·
     *Author:licm
     *Date:2007-07-05
     */
    public Page findCustAlarmByCondictionCache4CircuitTopo(Map map) throws DataAccessException;
    
    /*Describe:����ѡ�еĴ�ͻ�id�ַ�����ô�ͻ��б�
     *Author:licm
     *Date:2007-02-14
     */
    public List getCustomerListByCustomerids(String customerids) throws DataAccessException;

    /*Describe:���ݵ�½�û�id���ӵ��Ȩ�޵Ĵ�ͻ�ID
     *Author:licm
     *Date:2007-03-01
     */
    public List getCustomeridsByUserid(int userid) throws DataAccessException;
    
    /*Describe:���ݵ�½�û�id��ô�ͻ��б�
     *Author:licm
     *Date:2007-03-01
     */
    public List getCustomerListByUserid(int userid) throws DataAccessException;

    /*Describe:���ݵ�ǰ��½�û�ID�͵�ǰ˫������ҵID��ô�ͻ��б�
     *Author:licm
     *Date:2007-03-02
     */
    public List getCustomerListByTradeAndUserid(Map map) throws DataAccessException;
    
    public String synDataByCustomerID(int customerID) throws DataAccessException;
    public String synDataByCircuitID(int circuitID, int property) throws DataAccessException;
    
    /*Describe:��·���˹��ˣ���ȡ�ͻ��ڵ㣬����֮ǰ��ֱ�Ӵ���SQLʱ��·����ʱ�ᱨ���ܷ����ڴ�Ĵ��������޸ķ���
     *Author:licm
     *Date:2007-06-28
     */
    public List getChildCustomerListByConProc(Map map) throws DataAccessException;
    
    /*Describe:����ѡ�еĴ�ͻ�id�ַ�����������б�
     *Author:licm
     *Date:2007-07-04
     */
    public List getRegionListByCustomerids(String customerids) throws DataAccessException;
    
    /*Describe:���ĳ����
     *Author:licm
     *Date:2007-07-04
     */
    public Region getRegionByID(String regionid) throws DataAccessException;

    /*Describe:��ô�ͻ����˽���б�
     *Author:luodenghui
     *Date:2007-07-09
     */
    public List getFilgercontblList(String userid);
    /*Describe:������µĴ�ͻ����˽��
     *Author:luodenghui
     *Date:2007-07-09
     */
    public Filtercontbl getFilgercontbl(String userid);
    /*Describe:������µĴ�ͻ����˽��
     *Author:luodenghui
     *Date:2007-07-09
     */
    public String getMaxFILTERCONID();
    /*Describe:��Ӵ�ͻ����˽��
     *Author:luodenghui
     *Date:2007-07-09
     */
    public void addFilgercontb(Filtercontbl filtercontbl);
    /*Describe:������µĴ�ͻ����˽��
     *Author:luodenghui
     *Date:2007-07-09
     */
    public Filtercontbl getFilgercontblByName(Map map);
         /*Describe:��Ӵ�ͻ����˽���Ƿ�����
     *Author:luodenghui
     *Date:2007-07-09
     */
    public boolean isHasFilgercontbName(Map map);
    /*Describe:��Ӵ�ͻ����˽���Ƿ�����
     *Author:luodenghui
     *Date:2007-07-09
     */
    public void updateFiltercontblByName(Filtercontbl filtercontbl);
    
    /*Describe:ɾ�����˱���������¼
     *Author:licm
     *Date:2007-07-16
     */
    public void delFiltercontbl(String names) throws DataAccessException;
    
    /*Describe:����customerids��ȡmanageobject�б�
     *Author:licm
     *Date:2007-08-13
     */
    public List getManageobjectByCustomerid(String customerids) throws DataAccessException;
    
    //���ݵ�·IDɾ������
    public String delDataByCircuitID(int circuitID,int property)throws DataAccessException;
    
    //���ݿͻ�IDɾ������ ��Դ���ݲ�����
    public String delDataByCustomID(int customID) throws DataAccessException;
    
    /*Describe:����manageobject��ȡciralarmtbl�������Ӧ���eventtime
     *Author:licm
     *Date:2007-08-14
     */
    public String getMaxtimeByManageobject(String manageobject) throws DataAccessException;
    
    /*Describe:����managedobject��eventtime��ȡciralarm����
     *Author:licm
     *Date:2007-08-15
     */
    public CirAlarm getCirAlarmByMOAndET(Map map) throws DataAccessException;
    
    /*Describe:���ݸ澯������ʾ����Ӧ�ĸ澯�ͻ��б�
     *Author:licm
     *Date:2007-08-22
     */
    public Page findCustAlarm4AlarmNum(Map map) throws DataAccessException;    
    
}