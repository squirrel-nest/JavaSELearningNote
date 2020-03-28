/*
 * DataSynchronizationWFImpl.java
 * <p>Title:��ͻ�ҵ������ʵʱ����ϵͳ</p>
 * <p>Description:ҵ�������ͬ��ʵ����</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2007</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
 * @author $Author: lindsh $
 * @version $Revision: 1.2 $
 * @since $Date: 2007/06/20 06:24:12 $
 *
 */


package com.ffcs.util.bo.datasynchronization;
import com.ffcs.util.dao.datasynchronization.IDataSynchronizationDao;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.springframework.dao.DataAccessException;
import java.util.Map;

/**
 * ҵ�������ͬ��ʵ����
 */
public class DataSynchronizationWFImpl implements IDataSynchronizationWFFacade{
    
    /**
     * ���ݲ���������ͬ������
     */
    private IDataSynchronizationDao dataSynchronizationDao;
    private IDataSynchronizationDao dataSynchronizationDao2;
    /**
     * Creates a new instance of DataSynchronizationWFImpl
     * 
     * @return a  instance of DataSynchronizationWFImpl
     */

    public IDataSynchronizationDao getDataSynchronizationDao() {
        return dataSynchronizationDao;
    }

    /**
     * Set a new instance of DataSynchronizationWFImpl
     * 
     * @param dataSynchronizationDao a new instance of DataSynchronizationWFImpl
     */
    public void setDataSynchronizationDao(IDataSynchronizationDao dataSynchronizationDao) {
        this.dataSynchronizationDao = dataSynchronizationDao;
    }
    /**
     * Creates a new instance of DataSynchronizationWFImpl
     * 
     * @return a  instance of DataSynchronizationWFImpl
     */
    public IDataSynchronizationDao getDataSynchronizationDao2() {
        return dataSynchronizationDao2;
    }
    /**
     * Set a new instance of DataSynchronizationWFImpl
     * 
     * @param dataSynchronizationDao a new instance of DataSynchronizationWFImpl
     */
    public void setDataSynchronizationDao2(IDataSynchronizationDao dataSynchronizationDao2) {
        this.dataSynchronizationDao2 = dataSynchronizationDao2;
    }

    /**
     * ���ݿͻ�IDͬ������
     * @param customerID �ͻ�ID��
     * @throws org.springframework.dao.DataAccessException ���ݲ����쳣
     * @return ͬ���Ƿ�ɹ�
     */
    public String synDataByCustomerID(int customerID) throws DataAccessException{
        return dataSynchronizationDao.synDataByCustomID(customerID);
    };

    /**
     * ���ݵ�·IDͬ������
     * @param circuitID ��·ID��
     * @throws org.springframework.dao.DataAccessException ���ݲ����쳣
     * @return ͬ���Ƿ�ɹ�
     */
     public String synDataByCircuitID(int circuitID, int property) throws DataAccessException{     
         return dataSynchronizationDao.synDataByCircuitID(circuitID, property);
     }; 
//     public boolean synDataByCircuitID(int circuitID) throws DataAccessException{
//         boolean isSuccess=false;
//         isSuccess=dataSynchronizationDao.test(circuitID);
//         isSuccess=dataSynchronizationDao2.test(circuitID);
////        if(dataSynchronizationDao.importRoutetbl(circuitID)) //���ݵ�·ID�����··�ɼ�¼
////        if(dataSynchronizationDao.getCirroutetblOrderNO(circuitID))  //����·�ɱ���·�����
////        if(dataSynchronizationDao.updateCircuitFromRoute(circuitID)) //����·����Ų��Ҳ����µ�·��AZ���豸ID
////        if(dataSynchronizationDao.importNePortFromCir(circuitID)) //���ݵ�·ID�µ�AZ���豸ID������Ԫ���ͱ�,��Ԫ��,�˿����ͱ�,�˿ڱ�,ʱ϶�� �ٸ������ϵ�������ݸ��¸õ�·����Ԫ,�˿�,ʱ϶��ϸ��Ϣ
////        if(dataSynchronizationDao.importRouteConnTbl(circuitID))  //���ݵ�·ID����SDH��(���α���),PDH��,����չ��������·�����ӱ�
////           isSuccess= true;
//         return isSuccess;
//     };


    
    
    
    
}
