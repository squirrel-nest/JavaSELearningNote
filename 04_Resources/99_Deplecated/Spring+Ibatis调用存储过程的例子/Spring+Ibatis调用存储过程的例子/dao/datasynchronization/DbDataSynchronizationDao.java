/*
 * DbDataSynchronizationDao.java
 * <p>Title:��ͻ�ҵ������ʵʱ����ϵͳ</p>
 * <p>Description:����ͬ��</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2007</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
 *  @author $Author: lindsh $
 * @version $Revision: 1.4 $
 * @since $Date: 2007/07/11 01:50:39 $
 *
 */


package com.ffcs.util.dao.datasynchronization;

import com.ffcs.util.dao.datasynchronization.*;
import com.ffcs.util.domain.datasynchronization.CustomerSynBase;
import com.ffcs.util.domain.datasynchronization.CircuitSynBase;
import com.ffcs.util.log.LoggerIfc;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import com.ffcs.util.log.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DbDataSynchronizationDao extends SqlMapClientDaoSupport implements IDataSynchronizationDao {

public static final LoggerIfc log=LogFactory.getLogger(DbDataSynchronizationDao.class);
    
//���ݵ�·IDͬ������
   public String synDataByCircuitID(int circuitID,int property) throws DataAccessException{
       CircuitSynBase circuitSynBase=new CircuitSynBase();
       circuitSynBase.setId(Integer.valueOf(circuitID));
       circuitSynBase.setProperty(Integer.valueOf(property));
       try{
           getSqlMapClientTemplate().queryForObject("synDataByCircuitID",circuitSynBase);
       }catch(org.springframework.jdbc.UncategorizedSQLException e){
           String cause=e.getSQLException().getCause().toString();
           String temp[]=cause.split("\n");
           log.info(cause);
           for(int i=0;i<temp.length;i++){
               if(temp[i].indexOf("java.sql.SQLException")!=-1){
                   String temp2[]=temp[i].split(":");
                   if(temp2.length>=3)circuitSynBase.setOutput(temp2[2]);
               }
           }
       }
       return circuitSynBase.getOutput();
   };
   //���ݿͻ�IDͬ������
   public String synDataByCustomID(int customID) throws DataAccessException{
       CustomerSynBase customerSynBase=new CustomerSynBase();
       customerSynBase.setId(Integer.valueOf(customID));
       try{
           getSqlMapClientTemplate().queryForObject("synDataByCustomID",customerSynBase);
       }catch(org.springframework.jdbc.UncategorizedSQLException e){
           String cause=e.getSQLException().getCause().toString();
           String temp[]=cause.split("\n");
           log.info(cause);
           for(int i=0;i<temp.length;i++){
               if(temp[i].indexOf("java.sql.SQLException")!=-1){
                   String temp2[]=temp[i].split(":");
                   if(temp2.length>=3)customerSynBase.setOutput(temp2[2]);
               }
           }
       }
       return customerSynBase.getOutput();
   }; 
   //���ݵ�·IDɾ������
   public String delDataByCircuitID(int circuitID,int property)throws DataAccessException{
       CircuitSynBase circuitSynBase=new CircuitSynBase();
       circuitSynBase.setId(Integer.valueOf(circuitID));
       circuitSynBase.setProperty(Integer.valueOf(property));
       try{
           getSqlMapClientTemplate().queryForObject("delDataByCircuitID",circuitSynBase);
       }catch(org.springframework.jdbc.UncategorizedSQLException e){
           String cause=e.getSQLException().getCause().toString();
           String temp[]=cause.split("\n");
           log.info(cause);
           for(int i=0;i<temp.length;i++){
               if(temp[i].indexOf("java.sql.SQLException")!=-1){
                   String temp2[]=temp[i].split(":");
                   if(temp2.length>=3)circuitSynBase.setOutput(temp2[2]);
               }
           }
       }
       return circuitSynBase.getOutput();
   };
  //���ݿͻ�IDɾ������ ��Դ���ݲ�����
     public String delDataByCustomID(int customID) throws DataAccessException{
       CustomerSynBase customerSynBase=new CustomerSynBase();
       customerSynBase.setId(Integer.valueOf(customID));
       try{
           getSqlMapClientTemplate().queryForObject("delDataByCustomID",customerSynBase);
       }catch(org.springframework.jdbc.UncategorizedSQLException e){
           String cause=e.getSQLException().getCause().toString();
           String temp[]=cause.split("\n");
           log.info(cause);
           for(int i=0;i<temp.length;i++){
               if(temp[i].indexOf("java.sql.SQLException")!=-1){
                   String temp2[]=temp[i].split(":");
                   if(temp2.length>=3)customerSynBase.setOutput(temp2[2]);
               }
           }
       }
       return customerSynBase.getOutput();
     }; 
   
}
