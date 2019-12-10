/**
 * ����������
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
	 *  �����ݿ�����Ӽ�¼
	 * @param sql sql���
	 * @param params �����б�
	 * @return ִ�н��
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
	 * �жϼ�¼�Ƿ����
	 * @param tableName ����ѯ�ı���
	 * @param id ��¼���
	 * @return ��ѯ���
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
