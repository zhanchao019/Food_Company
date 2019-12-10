/**
 * 销售收退货服务类
 */
package com.njue.mis.services;

import java.util.Vector;

import com.njue.mis.dao.SalesBackDAO;
import com.njue.mis.handler.SalesBackServicesHandler;
import com.njue.mis.model.SalesBack;

public class SalesBackServices implements SalesBackServicesHandler
{
	SalesBackDAO salesBackDAO=null;
	public SalesBackServices()
	{
		super();
	}

	
	public boolean addSalesBack(SalesBack salesBack)
	{
		salesBackDAO=new SalesBackDAO();
		boolean result=false;
		result=salesBackDAO.addSalesBack(salesBack);
		//修改库存量
		GoodsServices goodsServices=new GoodsServices();
		goodsServices.changeGoodsNumber(salesBack.getGoodsId(), salesBack.getNumber());
		return result;
	}

	
	public Vector<SalesBack> getAllSalesBack()
	{
		salesBackDAO=new SalesBackDAO();
		return salesBackDAO.getAllSalesBack();
	}

	
	public Vector<SalesBack> searchSalesBack(String field, String value)
	{
		salesBackDAO=new SalesBackDAO();
		return salesBackDAO.searchSalesBack(field, value);
	}

	
	public Vector<SalesBack> searchSalesBackByTime(String beginTime,String endTime)
	{
		salesBackDAO=new SalesBackDAO();
		return salesBackDAO.searchSalesBackByTime(beginTime, endTime);
	}

	
	public boolean isExited(String id)
	{
		salesBackDAO=new SalesBackDAO();
		return salesBackDAO.isExited(id);
	}

}
