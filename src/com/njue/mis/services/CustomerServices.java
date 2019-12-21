/**
 * 客户服务类
 */
package com.njue.mis.services;

import com.njue.mis.dao.CustomerDAO;
import com.njue.mis.dao.LogDAO;
import com.njue.mis.handler.CustomerServicesHandler;
import com.njue.mis.model.Customer;

import java.util.Vector;
 
public class CustomerServices implements CustomerServicesHandler
{
	CustomerDAO customerDAO=null;
	
	public CustomerServices()
	{
		super();
	}

    public boolean addLog(String username, String time, String power, String dept, String detail) {
        LogDAO logDAO = new LogDAO();
        return logDAO.addLog(username, time, power, dept, detail);
    }
	
	public boolean addCustomer(Customer customer)
	{
		customerDAO=new CustomerDAO();
		return customerDAO.addCustomer(customer);
	}

	
	public boolean deleteCustomer(String id)
	{
		customerDAO=new CustomerDAO();
		return customerDAO.deleteCustomer(id);
		
	}

	
	public boolean modifyCustomer(Customer customer)
	{
		customerDAO=new CustomerDAO();
		return customerDAO.modifyCustomer(customer);
	}

	
	public Vector<Customer> getAllCustomer()
	{
		customerDAO=new CustomerDAO();
		return customerDAO.getAllCustomer();
	}

	
	public Vector<Customer> searchCustomer(String field, String value)
	{
		customerDAO=new CustomerDAO();
		return customerDAO.searchCustomer(field, value);
	}

	
	public boolean isExited(String id)
	{
		customerDAO=new CustomerDAO();
		return customerDAO.isExited(id);
	}

	
	public Customer getCustomerInfo(String id)
	{
		customerDAO=new CustomerDAO();
		return customerDAO.getCustomerInfo(id);
	}


}
