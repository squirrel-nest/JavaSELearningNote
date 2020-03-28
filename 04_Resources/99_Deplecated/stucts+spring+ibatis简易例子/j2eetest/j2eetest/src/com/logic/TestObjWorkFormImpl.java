/**
 * <p>Title:������Դ��̬����ϵͳ</p>
 * <p>Description:���ݱȶ��߼���ӿ�ʵ��</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
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

	// ���ݲ�������ȡ����
	public List getTestInfWithMap(HashMap map) throws DataAccessException{
		return this.testDao.getTestInfWithMap(map);
	}
	
	// �����¼
	public void insertTestTbl(Test test) throws DataAccessException{
		this.testDao.insertTestTbl(test);
	}
		
	// �����룬ɾ����¼
	public void delTestWithId(String value) throws DataAccessException{
		this.testDao.delTestWithId(value);		
	}
	
	// ���¼�¼
	public void updateTestTbl(Test test) throws DataAccessException{		
		this.testDao.updateTestTbl(test);		
	}
	
}