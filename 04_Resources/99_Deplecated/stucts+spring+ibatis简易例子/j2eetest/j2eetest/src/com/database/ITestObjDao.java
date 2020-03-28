/**
 * <p>Title:电信资源动态管理系统</p>
 * <p>Description:差错管理DAO层接口类[]</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:福建富士通信息软件有限公司</p>
 * @date 2006-05-8
 * @author lzw
 * @version 1.0
 */
package com.database;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.springframework.dao.DataAccessException;
import com.domain.Test;

public interface ITestObjDao {
	
	// 根据参数，获取数据
	public List getTestInfWithMap(HashMap map) throws DataAccessException;	
	
	// 插入记录
	public void insertTestTbl(Test test) throws DataAccessException;	
		
	// 传编码，删除记录
	public void delTestWithId(String value) throws DataAccessException;	
	
	// 更新记录
	public void updateTestTbl(Test test) throws DataAccessException;		
	
}
