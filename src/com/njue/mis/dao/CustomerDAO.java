/**
 * 客户DAO类，主要对客户信息进行管理
 */
package com.njue.mis.dao;

import java.sql.ResultSet;
import java.util.Vector;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.Customer;

public class CustomerDAO extends PersonDAO
{

	public CustomerDAO()
	{
		super();
	}
	/**
	 * 向数据库中添加新客户
	 * @param customer 封装好的客户
	 * @return 执行结果
	 */
	public boolean addCustomer(Customer customer)
	{
		boolean result=false;
		try
		{
			String sql = "insert into tb_customer(id,customername,zip,address,telephone,connectionperson,phone,bank,account,email,fax,available) values(?,?,?,?,?,?,?,?,?,?,?,1)";
			Object[] params=new Object[]{customer.getId(),customer.getName(),customer.getZip(),
					                     customer.getAddress(),customer.getTelephone(),customer.getConnectionPerson(),
					                     customer.getPhone(),customer.getBank(),customer.getAccount(),
					                     customer.getEmail(),customer.getFax()};
			result=super.addPerson(sql, params);
		}
		catch (Exception e)
		{
			ErrorManager.printError("CustomerDAO.addCustomer", e);
		}
		return result;
	}
	/**
	 * 从数据库中删除指定客户的信息，由于存在外键关系，此处仅设置表中 available=0
	 * @param id 被删除客户的编号
	 * @return 执行结果
	 */
	public boolean deleteCustomer(String id)
	{
		boolean result=false;
		try
		{
			String sql="update tb_customer set available=0 where id=?";
			Object[] params=new Object[]{id};
			result=super.deletePerson(sql, params);
		}
		catch (Exception e)
		{
			ErrorManager.printError("CustomerDAO.deleteCustomer", e);
		}
		return result;
	}
	/**
	 * 查询数据库中满足条件的客户
	 * @param field 查询的字段
	 * @param value 满足的值
	 * @return 查询结果
	 */
	public Vector<Customer> searchCustomer(String field,String value)
	{
		Vector<Customer> result=new Vector<Customer>();
		try
		{
			String sql="{call pr_searchCustomer(?,?)}";
			Object[] params=new Object[]{field,value};
			ResultSet rs=manage.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				Customer customer=new Customer(rs.getString("id"),
						                       rs.getString("customerName"),
						                       rs.getString("zip"),
									           rs.getString("address"),
									           rs.getString("telephone"),
									           rs.getString("connectionPerson"),
									           rs.getString("phone"),
									           rs.getString("bank"),
									           rs.getString("account"),
									           rs.getString("email"),
									           rs.getString("fax")
									          
									           );
				result.add(customer);
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CustomerDAO.searchCustomer", e);
		}
		return result;
	}
	/**
	 * 修改客户信息
	 * @param customer 封装好的客户新信息
	 * @return 执行结果
	 */
	public boolean modifyCustomer(Customer customer)
	{
		boolean result=false;
		try
		{
			String sql="update tb_customer set customername=?,zip=?,address=?,telephone=?,connectionperson=?,phone=?,bank=?,account=?,email=?,fax=? where id=?";
			Object[] params=new Object[]{customer.getName(),customer.getZip(),
					                     customer.getAddress(),
					 					 customer.getTelephone(),
					 					 customer.getConnectionPerson(),
					 					 customer.getPhone(),
					 					 customer.getBank(),
					 					 customer.getAccount(),
					 					 customer.getEmail(),
					 					 customer.getFax(),
					 					 customer.getId()};
			result=super.modifyPerson(sql, params);
		}
		catch (Exception e)
		{
			ErrorManager.printError("CustomerDAO.modifyCustomer", e);
		}
		return result;
	}
	/**
     * 显示所有的客户
     * @return 客户集合
     */
    public Vector<Customer> getAllCustomer()
    {
    	Vector<Customer>result=new Vector<Customer>();
    	try
		{
			String sql="{call pr_getAllCustomer()}";
			ResultSet rs=manage.executeQuery(sql, null, Constants.CALL_TYPE);
			while(rs.next())
			{
				Customer person=new Customer(rs.getString("id"),
						rs.getString("customername"),rs.getString("zip"),
					     rs.getString("address"),rs.getString("telephone"),
					     rs.getString("connectionPerson"),
					     rs.getString("phone"),rs.getString("bank"),
					     rs.getString("account"),
					     rs.getString("email"),
					     rs.getString("fax"));
				result.add(person);
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CustomerDAO.getAllCustomer", e);
		}
		return result;
    }
    /**
     * 判断用户是否存在
     * @param id 查询的客户编号
     * @return 查询结果
     */
    public boolean isExited(String id)
    {
    	boolean result=false;
    	try
		{
			String sql="select * from tb_customer where id=?";
			Object[] params=new Object[]{id};
			result=super.isExited(sql, params);
			
		}
		catch (Exception e)
		{
			ErrorManager.printError("CustomerDAO.isExited", e);
		}
    	return result;
    }
    /**
     * 获取特定客户的信息
     * @param id 客户编号
     * @return 查询结果
     */
    public Customer getCustomerInfo(String id)
    {
    	Customer customer=new Customer();
    	try
		{
			String sql="select * from tb_customer where id=?";
			Object[] params=new Object[]{id};
			
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
		    if(rs.next())
		    {
		    	customer=new Customer(rs.getString("id"),rs.getString("customername"),rs.getString("zip"),
					     rs.getString("address"),rs.getString("telephone"),rs.getString("connectionPerson"),
					     rs.getString("phone"),rs.getString("bank"),rs.getString("account"),
					     rs.getString("email"),rs.getString("fax"),rs.getInt("available"));
		    }    
		    manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CustomerDAO.getCustomerInfo", e);
		}
    	return customer;
    }
}
