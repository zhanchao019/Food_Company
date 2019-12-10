/**
 * �ͻ�DAO�࣬��Ҫ�Կͻ���Ϣ���й���
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
	 * �����ݿ�������¿ͻ�
	 * @param customer ��װ�õĿͻ�
	 * @return ִ�н��
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
	 * �����ݿ���ɾ��ָ���ͻ�����Ϣ�����ڴ��������ϵ���˴������ñ��� available=0
	 * @param id ��ɾ���ͻ��ı��
	 * @return ִ�н��
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
	 * ��ѯ���ݿ������������Ŀͻ�
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
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
	 * �޸Ŀͻ���Ϣ
	 * @param customer ��װ�õĿͻ�����Ϣ
	 * @return ִ�н��
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
     * ��ʾ���еĿͻ�
     * @return �ͻ�����
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
     * �ж��û��Ƿ����
     * @param id ��ѯ�Ŀͻ����
     * @return ��ѯ���
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
     * ��ȡ�ض��ͻ�����Ϣ
     * @param id �ͻ����
     * @return ��ѯ���
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
