/**
 * 供应商服务类
 */
package com.njue.mis.services;

import com.njue.mis.dao.LogDAO;
import com.njue.mis.dao.ProviderDAO;
import com.njue.mis.handler.ProviderServicesHandler;
import com.njue.mis.model.Provider;

import java.util.Vector;

public class ProviderServices implements ProviderServicesHandler
{
    ProviderDAO providerDAO=null;
    
	public ProviderServices()
	{
		super();
	}


	public boolean addLog(String username, String time, String power, String dept, String detail) {
		LogDAO logDAO = new LogDAO();
		return logDAO.addLog(username, time, power, dept, detail);

	}
	public boolean addProvider(Provider provider)
	{
		providerDAO=new ProviderDAO();
		return providerDAO.addProvider(provider);
	}

	
	public boolean deleteProvider(String id)
	{
		providerDAO=new ProviderDAO();
		return providerDAO.deleteProvider(id);
	}

	
	public boolean modifyProvider(Provider provider)
	{
		providerDAO=new ProviderDAO();
		return providerDAO.modifyProvider(provider);
	}

	
	public Vector<Provider> getAllProvider()
	{
		providerDAO=new ProviderDAO();
		return providerDAO.getAllProvider();
	}

	
	public Vector<Provider> searchProvider(String field, String value)
	{
		providerDAO=new ProviderDAO();
		return providerDAO.searchProvider(field, value);
	}

	
	public boolean isExited(String id)
	{
		providerDAO=new ProviderDAO();
		return providerDAO.isExited(id);
	}

	
	public Provider getProviderInfo(String id)
	{
		providerDAO=new ProviderDAO();
		return providerDAO.getProviderInfo(id);
	}


}
