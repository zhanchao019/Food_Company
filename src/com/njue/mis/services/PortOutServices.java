/**
 * 退货服务类
 */
package com.njue.mis.services;

import com.njue.mis.dao.LogDAO;
import com.njue.mis.dao.PortOutDAO;
import com.njue.mis.handler.PortOutServicesHandle;
import com.njue.mis.model.PortOut;

import java.util.Vector;

public class PortOutServices implements PortOutServicesHandle
{
    PortOutDAO portOutDAO=null;
    
	public PortOutServices()
	{
		super();
	}

	public boolean addLog(String username, String time, String power, String dept, String detail) {
		LogDAO logDAO = new LogDAO();
		return logDAO.addLog(username, time, power, dept, detail);

	}
	
	public boolean addPortOut(PortOut portOut)
	{
		portOutDAO=new PortOutDAO();
		boolean result=true;
		result=portOutDAO.addPortOut(portOut);;
		//修改库存量
		GoodsServices goodsServices=new GoodsServices();
		goodsServices.changeGoodsNumber(portOut.getGoodsId(), -portOut.getNumber());
		return result;
	}

	
	public Vector<PortOut> getAllPortOut()
	{
		portOutDAO=new PortOutDAO();
		return portOutDAO.getAllPortOut();
	}

	
	public Vector<PortOut> searchPortOut(String field, String value)
	{
		portOutDAO=new PortOutDAO();
		return portOutDAO.searchPortOut(field, value);
	}

	
	public Vector<PortOut> searchPortInByTime(String beginTime,String endTime)
	{
		portOutDAO=new PortOutDAO();
		return portOutDAO.searchPortInByTime(beginTime, endTime);
	}

	
	public boolean isExited(String id)
	{
		portOutDAO=new PortOutDAO();
		return portOutDAO.isExited(id);
	}

}
