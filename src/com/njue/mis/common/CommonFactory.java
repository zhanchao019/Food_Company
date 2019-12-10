/**
 * 工厂类，产生各个服务类的对象
 */
package com.njue.mis.common;

import com.njue.mis.handler.CustomerServicesHandler;
import com.njue.mis.handler.GoodsServicesHandler;
import com.njue.mis.handler.OperatorServicesHandler;
import com.njue.mis.handler.PortInServicesHandle;
import com.njue.mis.handler.PortOutServicesHandle;
import com.njue.mis.handler.ProviderServicesHandler;
import com.njue.mis.handler.SalesBackServicesHandler;
import com.njue.mis.handler.SalesInServicesHandler;

public class CommonFactory
{
	/**
	 * 获取GoodsService类的对象
	 * @return GoodsService类的对象
	 */
	public static GoodsServicesHandler getGoodsServices()
	{
		try
		{
			return (GoodsServicesHandler)Class.forName(Constants.GOODS_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getGoodsServices", e);
		}
		return null;
	}
	
	/**
	 * 获取CustomerServices类的对象
	 * @return CustomerServices类的对象
	 */
	public static CustomerServicesHandler getCustomerServices()
	{
		try
		{
			return (CustomerServicesHandler)Class.forName(Constants.CUSTOMER_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getCustomerServices", e);
		}
		return null;
	}
	/**
	 * 获取ProviderServices类的对象
	 * @return ProviderServices类的对象
	 */
	public static ProviderServicesHandler getProviderServices()
	{
		try
		{
			return (ProviderServicesHandler)Class.forName(Constants.PROVIDER_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getProviderServices", e);
		}
		return null;
	}
	/**
	 * 获取OperatorServices类的对象
	 * @return OperatorServices类的对象
	 */
	public static OperatorServicesHandler getOperatorServices()
	{
		try
		{
			return (OperatorServicesHandler)Class.forName(Constants.OPERATOR_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getOperatorServices", e);
		}
		return null;
	}
	/**
	 * 获取PortInServices类的对象
	 * @return PortInServices类的对象
	 */
	public static PortInServicesHandle getPortInServices()
	{
		try
		{
			return (PortInServicesHandle)Class.forName(Constants.PORTIN_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.PortInServicesHandle", e);
		}
		return null;
	}
	/**
	 * 获取PortOutServices类的对象
	 * @return PortOutServices类的对象
	 */
	public static PortOutServicesHandle getPortOutServices()
	{
		try
		{
			return (PortOutServicesHandle)Class.forName(Constants.PORTOUT_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getPortOutServices", e);
		}
		return null;
	}
	
	/**
	 * 获取SalesBackServices类的对象
	 * @return SalesBackServices类的对象
	 */
	public static SalesInServicesHandler getSalesInServices()
	{
		try
		{
			return (SalesInServicesHandler)Class.forName(Constants.SALESIN_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.SalesInServicesHandler", e);
		}
		return null;
	}
	/**
	 * 获取SalesBackServices类的对象
	 * @return SalesBackServices类的对象
	 */
	public static SalesBackServicesHandler getSalesBackServices()
	{
		try
		{
			return (SalesBackServicesHandler)Class.forName(Constants.SALESBACK_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getSalesBackServices", e);
		}
		return null;
	}
}
