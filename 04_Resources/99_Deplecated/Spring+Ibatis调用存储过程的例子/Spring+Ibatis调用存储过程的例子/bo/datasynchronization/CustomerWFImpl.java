/**
 * <p>Title:��ͻ�ҵ������ʵʱ����ϵͳ</p>
 * <p>Description:��ͻ��ӿ�ʵ��</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
 * @date 2006-12-23
 * @author licm.
 * @version 1.0
 */

package com.ffcs.util.bo.alarmwatch;

import com.ffcs.util.dao.IPagedStatementDao;
import com.ffcs.util.dao.Page;
import com.ffcs.util.dao.alarmwatch.ICustomerDao;
import com.ffcs.util.dao.datasynchronization.IDataSynchronizationDao;
import com.ffcs.util.domain.Param;
import com.ffcs.util.domain.alarmwatch.CirAlarm;
import com.ffcs.util.domain.alarmwatch.Customer;
import com.ffcs.util.domain.alarmwatch.Filtercontbl;
import com.ffcs.util.domain.alarmwatch.Region;
import com.ffcs.util.tools.ContVar;
import com.ffcs.util.tools.StringUtils;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;


public class CustomerWFImpl implements CustomerWFFacade {
    
    private ICustomerDao customerDao;
    private IPagedStatementDao pageStatementDao;
    private IDataSynchronizationDao dataSynchronizationDao;
    
    
    public ICustomerDao getCustomerDao() {
        return customerDao;
    }
    
    public void setCustomerDao(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    
    public IPagedStatementDao getPageStatementDao() {
        return pageStatementDao;
    }
    
    public void setPageStatementDao(IPagedStatementDao pageStatementDao) {
        this.pageStatementDao = pageStatementDao;
    }
    
    public IDataSynchronizationDao getDataSynchronizationDao() {
        return dataSynchronizationDao;
    }
    
    public void setDataSynchronizationDao(IDataSynchronizationDao dataSynchronizationDao) {
        this.dataSynchronizationDao = dataSynchronizationDao;
    }
    
    /*Describe:��ô�ͻ���
     *Author:licm
     *Date:2006-12-26
     */
    public List getCustomerList() throws DataAccessException{
        return this.customerDao.getCustomerList();
    }
    
    /*Describe:��ô�ͻ���
     *Author:licm
     *Date:2006-12-26
     */
    public List getChildCustomerList(String customerid) throws DataAccessException{
        return this.customerDao.getChildCustomerList(customerid);
    }
    
    /*Describe:���ĳ��ͻ��������ӿͻ���������·�������ӿͻ�
     *Author:licm
     *Date:2007-01-22
     */
    public List getChildCustomerList2(String circuitids) throws DataAccessException {
        return this.customerDao.getChildCustomerList2(circuitids);
    }
    
    /*Describe:���ĳ��ͻ�
     *Author:licm
     *Date:2007-01-22
     */
    public Customer getCustomerByID(String customerid) throws DataAccessException{
        return this.customerDao.getCustomerByID(customerid);
    }
    /*Describe:������ҵ��ô�ͻ��б�
     *Author:licm
     *Date:2007-01-08
     */
    public List getCustomerListByTrade(String tradeid) throws DataAccessException {
        return this.customerDao.getCustomerListByTrade(tradeid);
    }
    
    /*Describe:��·���˹��ˣ���ȡ�ͻ��ڵ�
     *Author:licm
     *Date:2007-01-14
     */
    public List getChildCustomerListByCon(Map map) throws DataAccessException {
        return this.customerDao.getChildCustomerListByCon(map);
    }
    
    /*Describe:��������б�
     *Author:licm
     *Date:2007-02-09
     */
    public List getRegionList2sel() throws DataAccessException {
        return this.customerDao.getRegionList2sel();
    }
    
    /*Describe:�ͻ���ѯ
     *Author:licm
     *Date:2007-02-10
     */
    public List findCustomerByCondiction(Map map) throws DataAccessException {
        return this.customerDao.findCustomerByCondiction(map);
    }
    
    /*Describe:�ͻ���ѯ����,��������PL/SQL�Ĳ�ѯ��һ���ķ�ʽ���������
     *Author:licm
     *Date:2007-02-12
     */
    public Page findCustomerByCondictionCache(Map map) throws DataAccessException{
        //�ѵ�½�û���Ȩ�޼ӽ�ȥ
        int userid = StringUtils.parseInt(System.getProperty("inms.userid","-1"));
        /*CustomerWFFacade customerWFFacade = (CustomerWFFacade)AppContext.getInstance().getAppContext().getBean("customerWFFacade");
        List custList = customerWFFacade.getCustomeridsByUserid(userid);
        String customerids = "";
        for (Iterator it = custList.iterator(); it.hasNext();) {
            Object ob=it.next();
            customerids = customerids + ob.toString() + ",";
        }
        if(customerids.length()>0) customerids = customerids.substring(0,customerids.length()-1);*/
        
        Param param = new Param();
        int pageNumber = Integer.parseInt(map.get("pageNumber").toString());
        int totalcount = Integer.parseInt(map.get("totalcount")==null?"0":map.get("totalcount").toString());
        
        int isAll = Integer.parseInt(map.get("isAll")==null?"0":map.get("isAll").toString());
        
        param.setPageNo(pageNumber);
        param.setTotalCount(totalcount);
        param.setPageSize(100);//ÿ��ȡ100����¼
        param.setIsAll(isAll);//�Ƿ��ѯȫ��
        String DataSql = "";
        String countSql = "";
        if(userid==0) {
            DataSql = "select * from " +
                    "(select customerid, namecn, tradeclsid," +
                    "(select tr.namecn from tradeclstbl tr where tr.tradeclsid=custtbl.tradeclsid) tradeclsname," +
                    "nameen, custcode, custaddr, custgrade," +
                    "(select d.descname from codetbl d where d.value=custtbl.custgrade and d.tablename=upper('customertbl') and d.colname=upper('custgrade')) custgradename," +
                    "custlevel," +
                    "(select d.descname from codetbl d where d.value=custtbl.custlevel and d.tablename=upper('customertbl') and d.colname=upper('custlevel')) custlevelname," +
                    "custtype," +
                    "(select d.descname from codetbl d where d.value=custtbl.custtype and d.tablename=upper('customertbl') and d.colname=upper('custtype')) custtypename," +
                    "servicelevel," +
                    "(select d.descname from codetbl d where d.value=custtbl.servicelevel and d.tablename=upper('customertbl') and d.colname=upper('servicelevel')) servicelevelname," +
                    "creditlevel," +
                    "(select d.descname from codetbl d where d.value=custtbl.creditlevel and d.tablename=upper('customertbl') and d.colname=upper('creditlevel')) creditlevelname," +
                    "linkname, linkphone, linkmobile, linkemail, linkfax, mngrname, mngrphone, mngrmobile, parentcustomerid," +
                    "(select t.namecn from customertbl t where t.customerid=custtbl.parentcustomerid) parentcustomername," +
                    "remark, regionid,(select r.namecn from regiontbl r where r.regionid=custtbl.regionid) regionname,entityname, " +
                    "NAMELAST as OldName,CUSTNO as No,BANKNAME as Bank,COUNTSNO as Counts,FileNO as FileNO,NAMEENABBR as AbbrevPY,NAMECNABBR as AbbrevCN from customertbl custtbl) " +
                    "where 1=1 ";
            countSql = "select count(*) as cc from " +
                    "(select customerid,namecn, linkname,  " +
                    "(select tr.namecn from tradeclstbl tr where tr.tradeclsid=c.tradeclsid) tradeclsname, " +
                    "(select d.descname from codetbl d where d.value=c.custlevel and d.tablename=upper('customertbl') and d.colname=upper('custlevel')) custlevelname, " +
                    "custcode,  " +
                    "(select r.namecn from regiontbl r where r.regionid=c.regionid) regionname, " +
                    "(select d.descname from codetbl d where d.value=c.custtype and d.tablename=upper('customertbl') and d.colname=upper('custtype')) custtypename, " +
                    "mngrname, CUSTNO as No from customertbl c) " +
                    " where 1=1 ";
        }else{
            DataSql = "select * from " +
                    "(select customerid, namecn, tradeclsid," +
                    "(select tr.namecn from tradeclstbl tr where tr.tradeclsid=custtbl.tradeclsid) tradeclsname," +
                    "nameen, custcode, custaddr, custgrade," +
                    "(select d.descname from codetbl d where d.value=custtbl.custgrade and d.tablename=upper('customertbl') and d.colname=upper('custgrade')) custgradename," +
                    "custlevel," +
                    "(select d.descname from codetbl d where d.value=custtbl.custlevel and d.tablename=upper('customertbl') and d.colname=upper('custlevel')) custlevelname," +
                    "custtype," +
                    "(select d.descname from codetbl d where d.value=custtbl.custtype and d.tablename=upper('customertbl') and d.colname=upper('custtype')) custtypename," +
                    "servicelevel," +
                    "(select d.descname from codetbl d where d.value=custtbl.servicelevel and d.tablename=upper('customertbl') and d.colname=upper('servicelevel')) servicelevelname," +
                    "creditlevel," +
                    "(select d.descname from codetbl d where d.value=custtbl.creditlevel and d.tablename=upper('customertbl') and d.colname=upper('creditlevel')) creditlevelname," +
                    "linkname, linkphone, linkmobile, linkemail, linkfax, mngrname, mngrphone, mngrmobile, parentcustomerid," +
                    "(select t.namecn from customertbl t where t.customerid=custtbl.parentcustomerid) parentcustomername," +
                    "remark, regionid,(select r.namecn from regiontbl r where r.regionid=custtbl.regionid) regionname,entityname, " +
                    "NAMELAST as OldName,CUSTNO as No,BANKNAME as Bank,COUNTSNO as Counts,FileNO as FileNO,NAMEENABBR as AbbrevPY,NAMECNABBR as AbbrevCN from customertbl custtbl," +
                    "(select distinct t.cstmid from rolecstmtbl t where t.roleid in (select u.roleid from userroletbl u where u.userid=" + userid +
                    ") and t.idtype =1 union select cust.customerid cstmid from customertbl cust where cust.userid=" + userid + ") right where custtbl.customerid = right.cstmid) c where 1=1 ";
            countSql = "select count(*) as cc from " +
                    "(select customerid,namecn, linkname,  " +
                    "(select tr.namecn from tradeclstbl tr where tr.tradeclsid=c.tradeclsid) tradeclsname, " +
                    "(select d.descname from codetbl d where d.value=c.custlevel and d.tablename=upper('customertbl') and d.colname=upper('custlevel')) custlevelname, " +
                    "custcode,  " +
                    "(select r.namecn from regiontbl r where r.regionid=c.regionid) regionname, " +
                    "(select d.descname from codetbl d where d.value=c.custtype and d.tablename=upper('customertbl') and d.colname=upper('custtype')) custtypename, " +
                    "mngrname, CUSTNO as No from customertbl c," +
                    "(select distinct t.cstmid from rolecstmtbl t where t.roleid in (select u.roleid from userroletbl u where u.userid=" + userid +
                    ") and t.idtype =1 union select cust.customerid cstmid from customertbl cust where cust.userid=" + userid + ") right where c.customerid = right.cstmid) custtbl" +
                    " where 1=1 ";
        }
        String sql = "";
        String namecn = map.get("namecn")==null?"":map.get("namecn").toString();
        String linkname = map.get("linkname")==null?"":map.get("linkname").toString();
        String tradecls = map.get("tradecls")==null?"":map.get("tradecls").toString();
        String custlevel = map.get("custlevel")==null?"":map.get("custlevel").toString();
        String custcode = map.get("custcode")==null?"":map.get("custcode").toString();
        String regionname = map.get("regionname")==null?"":map.get("regionname").toString();
        String no = map.get("no")==null?"":map.get("no").toString();
        String mngrname = map.get("mngrname")==null?"":map.get("mngrname").toString();
        if(!namecn.equals("")) sql = sql + "and namecn like '%" +namecn + "%' ";
        if(!linkname.equals("")) sql = sql + "and linkname like '%" + linkname + "%' ";
        if(!tradecls.equals("")) sql = sql + "and tradeclsname = '" + tradecls + "' ";
        if(!custlevel.equals("")) sql = sql + "and custlevelname = '" + custlevel + "' ";
        if(!custcode.equals("")) sql = sql + "and custcode like '%" + custcode + "%' ";
        if(!regionname.equals("")) sql = sql + "and regionname = '" + regionname + "' ";
        if(!no.equals("")) sql = sql + "and no like '%" + no + "%' ";
        if(!mngrname.equals("")) sql = sql + "and mngrname like '" + mngrname + "' ";
        
        //��ѡ�еļ�¼���ɴ�ͻ���
        String whereCon = map.get("whereCon")==null?"":map.get("whereCon").toString();
        if(!whereCon.equals("")) sql = sql + "and namecn in " + whereCon ;
        
        //���������ṹSQL����ѯ������ᵼ�����ݶ�ʧ
        //String sql2 = "Start With c.parentcustomerid is null Connect By Prior c.customerid = c.parentcustomerid";
        param.setQuerySql(DataSql+sql);//+sql2);
        param.setCountSql(countSql+sql);
        
        param.setIbatisState("findCustomerByCondictionCache");
        
        return this.pageStatementDao.executeQuery(param);
    }
    
    /*Describe:��·��ѯ����,��������PL/SQL�Ĳ�ѯ��һ���ķ�ʽ���������,��ѯ�澯��·
     *Author:licm
     *Date:2007-07-05
     */
    public Page findCustAlarmByCondictionCache4CircuitTopo(Map map) throws DataAccessException{
        int userid = StringUtils.parseInt(System.getProperty("inms.userid","-1"));
        String customerids = map.get("customerids").toString();
        Param param = new Param();
        int pageNumber = Integer.parseInt(map.get("pageNumber").toString());
        
        int totalcount = Integer.parseInt(map.get("totalcount")==null?"0":map.get("totalcount").toString());
        
        int isAll = Integer.parseInt(map.get("isAll")==null?"0":map.get("isAll").toString());
        param.setPageNo(pageNumber);
        param.setTotalCount(totalcount);
        param.setPageSize(ContVar.pagecount);   //ÿ��ȡ1000����¼
        param.setIsAll(isAll);                  //�Ƿ��ѯȫ��
        
        String DataSql = "select customerid, namecn, tradeclsid,  tradeclsname, nameen, custcode, custaddr, custgrade, custgradename,custlevel,  custlevelname, custtype,  custtypename, servicelevel,  servicelevelname, creditlevel,  creditlevelname, linkname, linkphone, linkmobile, linkemail, linkfax, mngrname, mngrphone, mngrmobile, parentcustomerid,  parentcustomername, remark, regionid, regionname,entityname,  OldName,No,Bank,Counts,FileNO,AbbrevPY,AbbrevCN from CUSTALARMVIEW v where v.customerid in ("+customerids+") ";
        
        String countSql = "select count(*) as cc from (select customerid, namecn from CUSTALARMVIEW v where v.customerid in ("+customerids+")) ut";
        
        param.setQuerySql(DataSql);
        param.setCountSql(countSql);
        
        param.setIbatisState("findCustomerByCondictionCache");
        
        return this.pageStatementDao.executeQuery(param);
    }
    
    /*Describe:����ѡ�еĴ�ͻ�id�ַ�����ô�ͻ��б�
     *Author:licm
     *Date:2007-02-14
     */
    public List getCustomerListByCustomerids(String customerids) throws DataAccessException {
        return this.customerDao.getCustomerListByCustomerids(customerids);
    }
    
    /*Describe:���ݵ�½�û�id���ӵ��Ȩ�޵Ĵ�ͻ�ID
     *Author:licm
     *Date:2007-03-01
     */
    public List getCustomeridsByUserid(int userid) throws DataAccessException {
        return this.customerDao.getCustomeridsByUserid(userid);
    }
    
    /*Describe:���ݵ�½�û�id��ô�ͻ��б�
     *Author:licm
     *Date:2007-03-01
     */
    public List getCustomerListByUserid(int userid) throws DataAccessException{
        return this.customerDao.getCustomerListByUserid(userid);
    }
    
    /*Describe:���ݵ�ǰ��½�û�ID�͵�ǰ˫������ҵID��ô�ͻ��б�
     *Author:licm
     *Date:2007-03-02
     */
    public List getCustomerListByTradeAndUserid(Map map) throws DataAccessException {
        return this.customerDao.getCustomerListByTradeAndUserid(map);
    }
    
    /**
     * �˴������˴洢����
     * ���ݿͻ�IDͬ������
     * @param customerID �ͻ�ID��
     * @throws org.springframework.dao.DataAccessException ���ݲ����쳣
     * @return ͬ���Ƿ�ɹ�
     */
    public String synDataByCustomerID(int customerID) throws DataAccessException{
        return dataSynchronizationDao.synDataByCustomID(customerID);
    };
    
    /**
     * �˴������˴洢����
     * ���ݵ�·IDͬ������
     * @param circuitID ��·ID��
     * @throws org.springframework.dao.DataAccessException ���ݲ����쳣
     * @return ͬ���Ƿ�ɹ�
     */
    public String synDataByCircuitID(int circuitID, int property) throws DataAccessException{
        return dataSynchronizationDao.synDataByCircuitID(circuitID, property);
    }
    
     /*Describe:��·���˹��ˣ���ȡ�ͻ��ڵ㣬����֮ǰ��ֱ�Ӵ���SQLʱ��·����ʱ�ᱨ���ܷ����ڴ�Ĵ��������޸ķ���
      *Author:licm
      *Date:2007-06-28
      */
    public List getChildCustomerListByConProc(Map map) throws DataAccessException {
        return customerDao.getChildCustomerListByConProc(map);
    }
    
    /*Describe:����ѡ�еĴ�ͻ�id�ַ�����������б�
     *Author:licm
     *Date:2007-07-04
     */
    public List getRegionListByCustomerids(String customerids) throws DataAccessException {
        return customerDao.getRegionListByCustomerids(customerids);
    }
    
    /*Describe:���ĳ����
     *Author:licm
     *Date:2007-07-04
     */
    public Region getRegionByID(String regionid) throws DataAccessException {
        return (Region)customerDao.getRegionByID(regionid);
    }
    
     /*Describe:��ô�ͻ����˽���б�
      *Author:luodenghui
      *Date:2007-07-09
      */
    public List getFilgercontblList(String userid) {
        return customerDao.getFilgercontblList(userid);
    }
    /*Describe:������µĴ�ͻ����˽��
     *Author:luodenghui
     *Date:2007-07-09
     */
    public Filtercontbl getFilgercontbl(String userid) {
        return customerDao.getFilgercontbl(userid);
    }
    /*Describe:������µĴ�ͻ����˽��
     *Author:luodenghui
     *Date:2007-07-09
     */
    public String getMaxFILTERCONID() {
        return customerDao.getMaxFILTERCONID();
    }
    /*Describe:��Ӵ�ͻ����˽��
     *Author:luodenghui
     *Date:2007-07-09
     */
    public void addFilgercontb(Filtercontbl filtercontbl) {
        customerDao.addFilgercontb(filtercontbl);
    }
    /*Describe:������µĴ�ͻ����˽��
     *Author:luodenghui
     *Date:2007-07-09
     */
    public Filtercontbl getFilgercontblByName(Map map) {
        return customerDao.getFilgercontblByName(map);
    }
    /*Describe:��Ӵ�ͻ����˽���Ƿ�����
     *Author:luodenghui
     *Date:2007-07-09
     */
    public boolean isHasFilgercontbName(Map map){
        return customerDao.isHasFilgercontbName(map);
    }
    /*Describe:��Ӵ�ͻ����˽���Ƿ�����
     *Author:luodenghui
     *Date:2007-07-09
     */
    public void updateFiltercontblByName(Filtercontbl filtercontbl){
        customerDao.updateFiltercontblByName(filtercontbl);
    }
    
    /*Describe:ɾ�����˱���������¼
     *Author:licm
     *Date:2007-07-16
     */
    public void delFiltercontbl(String names) throws DataAccessException {
        customerDao.delFiltercontbl(names);
    }
    
    /*Describe:����customerids��ȡmanageobject�б�
     *Author:licm
     *Date:2007-08-13
     */
    public List getManageobjectByCustomerid(String customerids) throws DataAccessException{
        return customerDao.getManageobjectByCustomerid(customerids);
    }
    
    //���ݵ�·IDɾ������
    public String delDataByCircuitID(int circuitID,int property)throws DataAccessException{
        return this.dataSynchronizationDao.delDataByCircuitID(circuitID, property);
    }
    
    //���ݿͻ�IDɾ������ ��Դ���ݲ�����
    public String delDataByCustomID(int customID) throws DataAccessException{
        return this.dataSynchronizationDao.delDataByCustomID(customID);
    }
    
    /*Describe:����manageobject��ȡciralarmtbl�������Ӧ���eventtime
     *Author:licm
     *Date:2007-08-14
     */
    public String getMaxtimeByManageobject(String manageobject) throws DataAccessException {
        return this.customerDao.getMaxtimeByManageobject(manageobject);
    }
    
    
    /*Describe:����managedobject��eventtime��ȡciralarm����
     *Author:licm
     *Date:2007-08-15
     */
    public CirAlarm getCirAlarmByMOAndET(Map map) throws DataAccessException {
        return this.customerDao.getCirAlarmByMOAndET(map);
    }

    /*Describe:���ݸ澯������ʾ����Ӧ�ĸ澯�ͻ��б�
     *Author:licm
     *Date:2007-08-22
     */
    public Page findCustAlarm4AlarmNum(Map map) throws DataAccessException{
        int userid = StringUtils.parseInt(System.getProperty("inms.userid","-1"));
        String customerids = map.get("customerids").toString();
        String alarmlevel = map.get("alarmlevel").toString();
        Param param = new Param();
        int pageNumber = Integer.parseInt(map.get("pageNumber").toString());
        
        int totalcount = Integer.parseInt(map.get("totalcount")==null?"0":map.get("totalcount").toString());
        
        int isAll = Integer.parseInt(map.get("isAll")==null?"0":map.get("isAll").toString());
        param.setPageNo(pageNumber);
        param.setTotalCount(totalcount);
        param.setPageSize(ContVar.pagecount);   //ÿ��ȡ1000����¼
        param.setIsAll(isAll);                  //�Ƿ��ѯȫ��
        
        String DataSql = "select customerid, namecn, tradeclsid," +
                "(select tr.namecn from tradeclstbl tr where tr.tradeclsid=c.tradeclsid) tradeclsname," +
                "nameen, custcode, custaddr, custgrade," +
                "(select d.descname from codetbl d where d.value=c.custgrade and d.tablename=upper('customertbl') and d.colname=upper('custgrade')) custgradename," +
                "custlevel," +
                "(select d.descname from codetbl d where d.value=c.custlevel and d.tablename=upper('customertbl') and d.colname=upper('custlevel')) custlevelname," +
                "custtype," +
                "(select d.descname from codetbl d where d.value=c.custtype and d.tablename=upper('customertbl') and d.colname=upper('custtype')) custtypename," +
                "servicelevel," +
                "(select d.descname from codetbl d where d.value=c.servicelevel and d.tablename=upper('customertbl') and d.colname=upper('servicelevel')) servicelevelname," +
                "creditlevel," +
                "(select d.descname from codetbl d where d.value=c.creditlevel and d.tablename=upper('customertbl') and d.colname=upper('creditlevel')) creditlevelname," +
                "linkname, linkphone, linkmobile, linkemail, linkfax, mngrname, mngrphone, mngrmobile, parentcustomerid," +
                "(select t.namecn from customertbl t where t.customerid=c.parentcustomerid) parentcustomername, remark," +
                "regionid," +
                "(select r.namecn from regiontbl r where r.regionid=c.regionid) regionname," +
                "entityname, c.NAMELAST as OldName,c.CUSTNO as No,c.BANKNAME as Bank,c.COUNTSNO as Counts,c.FileNO as FileNO," +
                "c.NAMEENABBR as AbbrevPY,c.NAMECNABBR as AbbrevCN " +
                "from customertbl c WHERE c.customerid in (" + customerids + ")";
                /*"WHERE c.customerid in (" + customerids + ") and (c.customerid IN (SELECT cir.Customerid FROM CIRCUITTBL cir, tnfm.ELEMENTALARM E WHERE cir.ENTITYKEY = E.KEY AND E.PERCEIVEDSEVERITY = " + alarmlevel + ") " +
                "OR c.customerid IN (SELECT cir.acustomerid FROM CIRCUITTBL cir, tnfm.ELEMENTALARM E WHERE cir.ENTITYKEY = E.KEY AND E.PERCEIVEDSEVERITY = " + alarmlevel + ") " +
                "OR c.customerid IN (SELECT cir.zcustomerid FROM CIRCUITTBL cir, tnfm.ELEMENTALARM E WHERE cir.ENTITYKEY = E.KEY AND E.PERCEIVEDSEVERITY = " + alarmlevel + ")) ";*/
        
        String countSql = "select count(*) as cc from (select customerid, namecn, tradeclsid," +
                "nameen, custcode, custaddr, custgrade," +
                "custlevel," +
                "custtype," +
                "servicelevel," +
                "creditlevel," +
                "linkname, linkphone, linkmobile, linkemail, linkfax, mngrname, mngrphone, mngrmobile, parentcustomerid," +
                "regionid," +
                "entityname, c.NAMELAST as OldName,c.CUSTNO as No,c.BANKNAME as Bank,c.COUNTSNO as Counts,c.FileNO as FileNO," +
                "c.NAMEENABBR as AbbrevPY,c.NAMECNABBR as AbbrevCN " +
                "from customertbl c WHERE c.customerid in (" + customerids + ")) ut";
                /*"WHERE c.customerid in (" + customerids + ") and (c.customerid IN (SELECT cir.Customerid FROM CIRCUITTBL cir, tnfm.ELEMENTALARM E WHERE cir.ENTITYKEY = E.KEY AND E.PERCEIVEDSEVERITY = " + alarmlevel + ") " +
                "OR c.customerid IN (SELECT cir.acustomerid FROM CIRCUITTBL cir, tnfm.ELEMENTALARM E WHERE cir.ENTITYKEY = E.KEY AND E.PERCEIVEDSEVERITY = " + alarmlevel + ") " +
                "OR c.customerid IN (SELECT cir.zcustomerid FROM CIRCUITTBL cir, tnfm.ELEMENTALARM E WHERE cir.ENTITYKEY = E.KEY AND E.PERCEIVEDSEVERITY = " + alarmlevel + "))) ut";*/
        
        param.setQuerySql(DataSql);
        param.setCountSql(countSql);
        
        param.setIbatisState("findCustomerByCondictionCache");
        
        return this.pageStatementDao.executeQuery(param);
    }    
}