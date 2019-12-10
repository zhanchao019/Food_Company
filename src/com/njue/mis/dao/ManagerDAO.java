/**
 * 公共管理类
 */

package com.njue.mis.dao;

import java.sql.ResultSet;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;

public abstract class ManagerDAO
{
	protected SqlManager manager=null;
	public ManagerDAO()
	{
		super();
		manager=SqlManager.createInstance();
		manager.connectDB();
	}
	/**
	 *  向数据库中添加记录
	 * @param sql sql语句
	 * @param params 参数列表
	 * @return 执行结果
	 */
	protected boolean add(String sql,Object[] params)
	{
		boolean result=false;
		try
		{
			result=manager.executeUpdate(sql, params, Constants.PSTM_TYPE);
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("ManagerDAO.add", e);
		}
		manager.closeDB();
		return result;
	}
	/**
	 * 判断记录是否存在
	 * @param tableName 被查询的表名
	 * @param id 记录编号
	 * @return 查询结果
	 */
    protected boolean isExited(String tableName,String id)
    {
    	boolean result=false;
    	try
		{
			String sql="select * from ? where id=?";
			Object[] params=new Object[]{tableName,id};
			ResultSet rs=manager.executeQuery(sql, params, Constants.PSTM_TYPE);
			if(rs.next())
				result=true;
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("ManagerDAO.isExited", e);
		}
    	return result;
    }
}
