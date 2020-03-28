/**
 * <p>Title:电信资源动态管理系统</p>
 * <p>Description:数据比对逻辑层接口实现</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:福建富士通信息软件有限公司</p>
 * @date 2006-05-08
 * @author lzw
 * @version 1.0
 */

package com.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import com.database.ITestObjDao;
import com.domain.Test;
import java.util.HashMap;

public class TestObjWorkFormImpl implements TestObjWorkFormFacade {

	private ITestObjDao testDao;


	public ITestObjDao getTestDao() {
		return testDao;
	}

	public void setTestDao(ITestObjDao testDao) {
		this.testDao = testDao;
	}

	// 根据参数，获取数据
	public List getTestInfWithMap(HashMap map) throws DataAccessException{
		return this.testDao.getTestInfWithMap(map);
	}
	
	// 插入记录
	public void insertTestTbl(Test test) throws DataAccessException{
		this.testDao.insertTestTbl(test);
	}
		
	// 传编码，删除记录
	public void delTestWithId(String value) throws DataAccessException{
		this.testDao.delTestWithId(value);		
	}
	
	// 更新记录
	public void updateTestTbl(Test test) throws DataAccessException{		
		this.testDao.updateTestTbl(test);		
	}
	
}