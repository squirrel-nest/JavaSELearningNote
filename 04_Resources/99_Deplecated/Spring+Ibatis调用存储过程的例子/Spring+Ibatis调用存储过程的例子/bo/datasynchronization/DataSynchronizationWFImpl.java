/*
 * DataSynchronizationWFImpl.java
 * <p>Title:大客户业务质量实时监视系统</p>
 * <p>Description:业务层数据同步实现类</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2007</p>
 * <p>Company:福建富士通信息软件有限公司</p>
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
 * 业务层数据同步实现类
 */
public class DataSynchronizationWFImpl implements IDataSynchronizationWFFacade{
    
    /**
     * 数据操作层数据同步对象
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
     * 根据客户ID同步数据
     * @param customerID 客户ID号
     * @throws org.springframework.dao.DataAccessException 数据操作异常
     * @return 同步是否成功
     */
    public String synDataByCustomerID(int customerID) throws DataAccessException{
        return dataSynchronizationDao.synDataByCustomID(customerID);
    };

    /**
     * 根据电路ID同步数据
     * @param circuitID 电路ID号
     * @throws org.springframework.dao.DataAccessException 数据操作异常
     * @return 同步是否成功
     */
     public String synDataByCircuitID(int circuitID, int property) throws DataAccessException{     
         return dataSynchronizationDao.synDataByCircuitID(circuitID, property);
     }; 
//     public boolean synDataByCircuitID(int circuitID) throws DataAccessException{
//         boolean isSuccess=false;
//         isSuccess=dataSynchronizationDao.test(circuitID);
//         isSuccess=dataSynchronizationDao2.test(circuitID);
////        if(dataSynchronizationDao.importRoutetbl(circuitID)) //根据电路ID导入电路路由记录
////        if(dataSynchronizationDao.getCirroutetblOrderNO(circuitID))  //计算路由表中路由序号
////        if(dataSynchronizationDao.updateCircuitFromRoute(circuitID)) //根据路由序号查找并更新电路的AZ端设备ID
////        if(dataSynchronizationDao.importNePortFromCir(circuitID)) //根据电路ID下的AZ端设备ID导入网元类型表,网元表,端口类型表,端口表,时隙表 再根据以上导入的数据更新该电路的网元,端口,时隙详细信息
////        if(dataSynchronizationDao.importRouteConnTbl(circuitID))  //根据电路ID导入SDH段(及段保护),PDH段,配线展开数据至路由连接表
////           isSuccess= true;
//         return isSuccess;
//     };


    
    
    
    
}
