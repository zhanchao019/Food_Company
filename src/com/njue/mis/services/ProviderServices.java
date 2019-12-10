/**
 * 供应商服务类
 */
package com.njue.mis.services;

import java.util.Vector;

import com.njue.mis.dao.ProviderDAO;
import com.njue.mis.handler.ProviderServicesHandler;
import com.njue.mis.model.Provider;

public class ProviderServices implements ProviderServicesHandler
{
    ProviderDAO providerDAO=null;
    
	public ProviderServices()
	{
		super();
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
