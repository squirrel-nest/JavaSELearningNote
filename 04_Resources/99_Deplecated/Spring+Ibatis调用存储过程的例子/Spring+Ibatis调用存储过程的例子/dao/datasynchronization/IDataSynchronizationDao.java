/*
 * IDataSynchronizationDao.java
 * <p>Title:大客户业务质量实时监视系统</p>
 * <p>Description:数据同步</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2007</p>
 * <p>Company:福建富士通信息软件有限公司</p>
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
    //根据电路ID同步数据
     public String synDataByCircuitID(int circuitID,int property) throws DataAccessException;
    //根据客户ID同步数据
     public String synDataByCustomID(int customID) throws DataAccessException;
    //根据电路ID删除数据
     public String delDataByCircuitID(int circuitID,int property)throws DataAccessException;
    //根据客户ID删除数据
     public String delDataByCustomID(int customID) throws DataAccessException; 
}
