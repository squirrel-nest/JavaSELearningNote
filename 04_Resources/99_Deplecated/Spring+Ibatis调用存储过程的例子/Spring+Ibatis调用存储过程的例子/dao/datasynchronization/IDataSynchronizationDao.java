/*
 * IDataSynchronizationDao.java
 * <p>Title:��ͻ�ҵ������ʵʱ����ϵͳ</p>
 * <p>Description:����ͬ��</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2007</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
 *  @author $Author: lindsh $
 * @version $Revision: 1.3 $
 * @since $Date: 2007/07/11 01:50:39 $
 *
 */

package com.ffcs.util.dao.datasynchronization;

import com.ffcs.util.domain.datasynchronization.CustomerSynBase;
import java.util.List;
import org.springframework.dao.DataAccessException;

public interface IDataSynchronizationDao {
    //���ݵ�·IDͬ������
     public String synDataByCircuitID(int circuitID,int property) throws DataAccessException;
    //���ݿͻ�IDͬ������
     public String synDataByCustomID(int customID) throws DataAccessException;
    //���ݵ�·IDɾ������
     public String delDataByCircuitID(int circuitID,int property)throws DataAccessException;
    //���ݿͻ�IDɾ������
     public String delDataByCustomID(int customID) throws DataAccessException; 
}
