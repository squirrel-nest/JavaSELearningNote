/**
 * <p>Title:������Դ��̬����ϵͳ</p>
 * <p>Description:���ݱȶ��߼���ӿ�</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
 * @date 2006-05-08
 * @author lzw
 * @version 1.0
 */

package com.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.springframework.dao.DataAccessException;

import com.domain.Test;

public interface TestObjWorkFormFacade {

	// ���ݲ�������ȡ����
	public List getTestInfWithMap(HashMap map) throws DataAccessException;	
	
	// �����¼
	public void insertTestTbl(Test test) throws DataAccessException;	
		
	// �����룬ɾ����¼
	public void delTestWithId(String value) throws DataAccessException;	
	
	// ���¼�¼
	public void updateTestTbl(Test test) throws DataAccessException;		
	
}