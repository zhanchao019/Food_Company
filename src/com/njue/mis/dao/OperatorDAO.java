/**
 * 管理员类DAO
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
	 * 查询用户名和密码是否正确
	 * @param username 用户名
	 * @param password 密码
	 * @return 查询结果
	 */
	public boolean loginCheck(String username,String password)
	{
		boolean result=false;
		try
		{
			String sql="select * from tb_operator where username=? and password=?";
			Object[] params=new Object[]{username,password};
			ResultSet rs=manage.executeQuery(sql, params,Constants.PSTM_TYPE);
			while(rs.next())
				result=true;
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("OperatorDAO.loginCheck", e);
		}
		return result;
	}
	/**
	 * 向数据库中田间新的操作员
	 * @param operator 封装好的操作员
	 * @return 执行结果
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
	 * 删除操作员信息
	 * @param username 被删除的操作员名称 
	 * @return 执行结果
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
	 * 修改密码
	 * @param username 被修改的用户名
	 * @param password 新密码
	 * @return 执行结果
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
	 * 获取操作员的密码
	 * @param username 用户名
	 * @return 密码
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
	 * 获取用户权限
	 * @param username 用户名
	 * @return 查询结果
	 */
	public String getPower(String username)
	{
		String result=null;
		try
		{
			String sql="select power from tb_operator where username=?";
			Object[] params=new Object[]{username};
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			rs.next();  //滑到第一行
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
     * 判断操作员是否存在
     * @param id 查询的操作员昵称
     * @return 查询结果
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
     * 获取特定职权的用户名
     * @param type 类型
     * @return 结果集合
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
     * 获取用户的信息
     * @param userName 用户名
     * @return  用户信息
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
