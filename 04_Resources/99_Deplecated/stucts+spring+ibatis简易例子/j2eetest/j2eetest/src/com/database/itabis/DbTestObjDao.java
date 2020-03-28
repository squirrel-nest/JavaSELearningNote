/**
 * <p>Title:������Դ��̬����ϵͳ</p>
 * <p>Description:��Դ����DAO��ʵ����</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
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
	
	// ���ݲ�������ȡ����
	public List getTestInfWithMap(HashMap map) throws DataAccessException{
        return getSqlMapClientTemplate().queryForList("getTestByMap", map);
	}
	
	// �����¼
	public void insertTestTbl(Test test) throws DataAccessException{
		getSqlMapClientTemplate().insert("insertTest", test);		
	}
		
	// �����룬ɾ����¼
	public void delTestWithId(String value) throws DataAccessException{
		getSqlMapClientTemplate().delete("deleteTest", value);		
	}
	
	// ���¼�¼
	public void updateTestTbl(Test test) throws DataAccessException{
		getSqlMapClientTemplate().update("updateTest", test);		
	}
	

}