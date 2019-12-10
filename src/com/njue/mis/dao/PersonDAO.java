/**
 * 客户DAO类，主要对客户信息进行管理
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
	 * 添加新成员
	 * @param sql sql语句
	 * @param params 参数列表
	 * @return 执行结果
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
	 * 删除成员信息
	 * @param sql sql 语句
	 * @param params 参数列表
	 * @return 执行结果
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
	 * 修改成员信息
	 * @param sql sql语句
	 * @param params 参数列表
	 * @return 执行结果
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
	 * 判断用户是否存在
	 * @param sql Sql语句
	 * @param params 参数列表
	 * @return 查询结果
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
