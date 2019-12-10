/**
 * �ͻ�DAO�࣬��Ҫ�Կͻ���Ϣ���й���
 */
package com.njue.mis.dao;

import java.sql.ResultSet;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;

public class PersonDAO
{
	protected SqlManager manage=null;
	
	public PersonDAO()
	{
		super();
		manage=SqlManager.createInstance();
		manage.connectDB();
	}

	/**
	 * ����³�Ա
	 * @param sql sql���
	 * @param params �����б�
	 * @return ִ�н��
	 */
	protected boolean addPerson(String sql, Object[] params)
	{
		boolean result=false;
		try
		{
			result=manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("PersonDAO.addPerson", e);
		}
		return result;
	}

	/**
	 * ɾ����Ա��Ϣ
	 * @param sql sql ���
	 * @param params �����б�
	 * @return ִ�н��
	 */
	protected boolean deletePerson(String sql,Object[] params)
	{
		boolean result=false;
		try
		{
			result=manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("PersonDAO.deletePerson", e);
		}
		return result;
	}
	/**
	 * �޸ĳ�Ա��Ϣ
	 * @param sql sql���
	 * @param params �����б�
	 * @return ִ�н��
	 */
	protected boolean modifyPerson(String sql,Object[] params)
	{
		boolean result=false;
		try
		{
			result=manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("PersonDAO.modifyPerson", e);
		}
		return result;
	}
	/**
	 * �ж��û��Ƿ����
	 * @param sql Sql���
	 * @param params �����б�
	 * @return ��ѯ���
	 */
	protected boolean isExited(String sql,Object[] params)
	{
		boolean result=false;
		try
		{
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			while(rs.next())
			{
				result=true;
				break;
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("PersonDAO.modifyPerson", e);
		}
		return result;
	}
}
