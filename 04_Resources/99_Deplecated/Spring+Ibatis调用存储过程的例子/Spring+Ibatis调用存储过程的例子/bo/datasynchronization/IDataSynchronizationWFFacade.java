/*
 * IDataSynchronizationWFFacade.java
 * <p>Title:��ͻ�ҵ������ʵʱ����ϵͳ</p>
 * <p>Description:����ͬ��</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2007</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
 * @author $Author: lindsh $
 * @version $Revision: 1.2 $
 * @since $Date: 2007/06/20 06:24:12 $
 */


package com.ffcs.util.bo.datasynchronization;

import java.util.Map;
import org.springframework.dao.DataAccessException;


/**
 * ҵ�������ͬ���ӿ���
 */
public interface IDataSynchronizationWFFacade {
    
    /**
     * ���ݿͻ�IDͬ������
     * @param customerID �ͻ�ID��
     * @throws org.springframework.dao.DataAccessException ���ݲ����쳣
     * @return ͬ���Ƿ�ɹ�
     */
     public String synDataByCustomerID(int customerID) throws DataAccessException;
     
    /**
     * ���ݵ�·IDͬ������
     * @param circuitID ��·ID��
     * @throws org.springframework.dao.DataAccessException ���ݲ����쳣
     * @return ͬ���Ƿ�ɹ�
     */
     public String synDataByCircuitID(int circuitID, int property) throws DataAccessException;
    
}
