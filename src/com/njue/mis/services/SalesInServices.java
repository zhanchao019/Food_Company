/**
 * ���۷�����
 */
package com.njue.mis.services;

import com.njue.mis.dao.SalesInDAO;
import com.njue.mis.handler.SalesInServicesHandler;
import com.njue.mis.model.SalesIn;

import java.util.Vector;

public class SalesInServices implements SalesInServicesHandler
{
    SalesInDAO salesInDAO=null;
	public SalesInServices()
	{
		super();
	}
	
	public boolean addSalesIn(SalesIn salesIn)
	{
		salesInDAO=new SalesInDAO();
		boolean result=true;
		result=salesInDAO.addSalesIn(salesIn);
		//�޸Ŀ����
		//GoodsServices goodsServices=new GoodsServices();
		//goodsServices.changeGoodsNumber(salesIn.getGoodsId(), -salesIn.getNumber());
		return  result;
	}
	
	public Vector<SalesIn> getAllSalesIn()
	{
		salesInDAO=new SalesInDAO();
		return salesInDAO.getAllSalesIn();
	}
	
	public Vector<SalesIn> searchSalesIn(String field, String value)
	{
		salesInDAO=new SalesInDAO();
		return salesInDAO.searchSalesIn(field, value);
	}
	
	public Vector<SalesIn> searchPortInByTime(String beginTime,String endTime)
	{
		salesInDAO=new SalesInDAO();
		return salesInDAO.searchPortInByTime(beginTime, endTime);
	}
	
	public boolean isExited(String id)
	{
		salesInDAO=new SalesInDAO();
		return salesInDAO.isExited(id);
	}
}
