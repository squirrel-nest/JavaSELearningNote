/*
 * IDataSynchronizationWFFacade.java
 * <p>Title:大客户业务质量实时监视系统</p>
 * <p>Description:数据同步</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2007</p>
 * <p>Company:福建富士通信息软件有限公司</p>
 * @author $Author: lindsh $
 * @version $Revision: 1.2 $
 * @since $Date: 2007/06/20 06:24:12 $
 */


package com.ffcs.util.bo.datasynchronization;

import java.util.Map;
import org.springframework.dao.DataAccessException;


/**
 * 业务层数据同步接口类
 */
public interface IDataSynchronizationWFFacade {
    
    /**
     * 根据客户ID同步数据
     * @param customerID 客户ID号
     * @throws org.springframework.dao.DataAccessException 数据操作异常
     * @return 同步是否成功
     */
     public String synDataByCustomerID(int customerID) throws DataAccessException;
     
    /**
     * 根据电路ID同步数据
     * @param circuitID 电路ID号
     * @throws org.springframework.dao.DataAccessException 数据操作异常
     * @return 同步是否成功
     */
     public String synDataByCircuitID(int circuitID, int property) throws DataAccessException;
    
}
