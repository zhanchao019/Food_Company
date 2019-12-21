/**
 * 销售服务类
 */
package com.njue.mis.services;

import com.njue.mis.dao.LogDAO;
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

	public boolean pay(String orderid) {
		salesInDAO = new SalesInDAO();
		return salesInDAO.pay(orderid);
	}


	public boolean back(String orderid, String paystate) {
		salesInDAO = new SalesInDAO();
		return salesInDAO.back(orderid, paystate);
	}


	public boolean addLog(String username, String time, String power, String dept, String detail) {
		LogDAO logDAO = new LogDAO();
		return logDAO.addLog(username, time, power, dept, detail);

	}
	public int getSum(String goodsid) {
		salesInDAO = new SalesInDAO();
		return salesInDAO.getSum(goodsid);
	}

    public boolean opt(String orderid, String goodsid) {
		salesInDAO = new SalesInDAO();
        return salesInDAO.opt(orderid, goodsid);
	}


	public boolean optR(String orderid, String goodsid, int sum) {
		salesInDAO = new SalesInDAO();
		return salesInDAO.optR(orderid, goodsid, sum);
	}
	public boolean addSalesIn(SalesIn salesIn)
	{
		salesInDAO=new SalesInDAO();
		boolean result=true;
		result=salesInDAO.addSalesIn(salesIn);
		//修改库存量
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


	public Vector<SalesIn> getAllOnTimeSalesIn() {
		salesInDAO = new SalesInDAO();
		return salesInDAO.getAllOnTimeSalesIn();
	}

	public Vector<SalesIn> getAllOrderedSalesIn() {
		salesInDAO = new SalesInDAO();
		return salesInDAO.getAllOrderedSalesIn();
	}
	public boolean isExited(String id)
	{
		salesInDAO=new SalesInDAO();
		return salesInDAO.isExited(id);
	}
}
