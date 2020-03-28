/**
 * <p>Title:电信资源动态管理系统</p>
 * <p>Description:资源对象DAO层实现类</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:福建富士通信息软件有限公司</p>
 * @date 2006-04-17
 * @author licm
 * @version 1.0
 */
package com.database.itabis;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.database.ITestObjDao;
import com.domain.Test;
import com.util.StringUtils;

public class DbTestObjDao extends SqlMapClientDaoSupport implements ITestObjDao {
	/*private DbSequenceDao sequenceDao;
	
	public void setSequenceDao(DbSequenceDao sequenceDao) {
		this.sequenceDao = sequenceDao;
	}*/
	
	// 根据参数，获取数据
	public List getTestInfWithMap(HashMap map) throws DataAccessException{
        return getSqlMapClientTemplate().queryForList("getTestByMap", map);
	}
	
	// 插入记录
	public void insertTestTbl(Test test) throws DataAccessException{
		getSqlMapClientTemplate().insert("insertTest", test);		
	}
		
	// 传编码，删除记录
	public void delTestWithId(String value) throws DataAccessException{
		getSqlMapClientTemplate().delete("deleteTest", value);		
	}
	
	// 更新记录
	public void updateTestTbl(Test test) throws DataAccessException{
		getSqlMapClientTemplate().update("updateTest", test);		
	}
	

}