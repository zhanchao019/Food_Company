/**
 * ����Ա��DAO
 */
package com.njue.mis.dao;

import java.sql.ResultSet;
import java.util.Vector;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.Operator;

public class OperatorDAO
{
	SqlManager manage=null;
	
	public OperatorDAO()
	{
		super();
		manage=SqlManager.createInstance();
		manage.connectDB();
	}
	
	/**
	 * ��ѯ�û����������Ƿ���ȷ
	 *
	 * @param username �û���
	 * @param password ����
	 * @param password ����
	 * @return ��ѯ���
	 */
	public boolean loginCheck(String username, String password, String dept) {
		boolean result = false;
		try {
			String sql = "select * from tb_operator where username=? and password=? and dept=?";
			Object[] params = new Object[]{username, password, dept};
			ResultSet rs = manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			while (rs.next())
				result = true;
			manage.closeDB();
		} catch (Exception e) {
			ErrorManager.printError("OperatorDAO.loginCheck", e);
		}
		return result;
	}

	/**
	 * �����ݿ�������µĲ���Ա
	 * @param operator ��װ�õĲ���Ա
	 * @return ִ�н��
	 */
	public boolean addOperator(Operator operator)
	{
		boolean result=false;
		try
		{
			String sql="insert into tb_operator(username,password,name,power) values (?,?,?,?)";
			Object[] params=new Object[]{operator.getUserName(),operator.getPassword(),
					                     operator.getName(),operator.getPower()};
			result=manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("OperatorDAO.addOperator", e);
		}
		return result;
	}
	/**
	 * ɾ������Ա��Ϣ
	 * @param username ��ɾ���Ĳ���Ա���� 
	 * @return ִ�н��
	 */
	public boolean deleteOperator(String username)
	{
		boolean result=false;
		try
		{
			String sql="delete from tb_operator where username=?";
			Object[] params= new Object[]{username};
			result=manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("OperatorDAO.deleteOperator", e);
		}
		return result;
	}
	/**
	 * �޸�����
	 * @param username ���޸ĵ��û���
	 * @param password ������
	 * @return ִ�н��
	 */
	public boolean modifyPassword(String username,String password)
	{
		boolean result=false;
		try
		{
			String sql="update tb_operator set password=? where username=?";
			Object[] params=new Object[]{password,username};
			result=manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("OperatorDAO.modifyPassword", e);
		}
		return result;
	}
	/**
	 * ��ȡ����Ա������
	 * @param username �û���
	 * @return ����
	 */
	public String getPassword(String username)
	{
		String result="";
		try
		{
			String sql="select * from tb_operator where username=?";
			Object[] params=new Object[]{username};
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			while(rs.next())
			{
				result=rs.getString("password");
				break;
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("OperatorDAO.modifyPassword", e);
		}
		return result;
	}
	/**
	 * ��ȡ�û�Ȩ��
	 * @param username �û���
	 * @return ��ѯ���
	 */
	public String getPower(String username)
	{
		String result=null;
		try
		{
			String sql="select power from tb_operator where username=?";
			Object[] params=new Object[]{username};
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			rs.next();  //������һ��
			result=rs.getString("power");
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("OperatorDAO.getPower", e);
		}
		return result;
	}
	/**
     * �жϲ���Ա�Ƿ����
     * @param id ��ѯ�Ĳ���Ա�ǳ�
     * @return ��ѯ���
     */
    public boolean isExited(String username)
    {
    	boolean result=false;
    	try
		{
			String sql="select * from tb_operator where username=?";
			Object[] params=new Object[]{username};
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			if(rs.next())
				result=true;
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("OperatorDAO.isExited", e);
		}
    	return result;
    }
    /**
     * ��ȡ�ض�ְȨ���û���
     * @param type ����
     * @return �������
     */
    public Vector<Operator> getOperator(String type)
    {
    	Vector<Operator> result=new Vector<Operator>();
    	try
		{
			String sql="select * from tb_operator where power=?";
			Object[] params=new Object[]{type};
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			while(rs.next())
			{
				Operator operator=new Operator(rs.getString("username"),rs.getString("password"),rs.getString("name"),rs.getString("power"));
				result.add(operator);
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("OperatorDAO.getOperator", e);
		}
    	return result;
    }
    /**
     * ��ȡ�û�����Ϣ
     * @param userName �û���
     * @return  �û���Ϣ
     */
    public  Operator getOperatorInfo(String userName)
    {
    	Operator result=new Operator();
    	try
		{
			String sql="select * from tb_operator where username=?";
			Object[] params=new Object[]{userName};
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			if(rs.next())
			{
				result.setUserName(userName);
				result.setPassword(rs.getString("password"));
				result.setName(rs.getString("name"));
				result.setPower(rs.getString("power"));
			}
		}
		catch (Exception e)
		{
			ErrorManager.printError("OperatorDAO.getOperatorInfo", e);
		}
		return result;
    }
}
