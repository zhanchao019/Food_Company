/**
 * 进货服务类
 */
package com.njue.mis.services;

import com.njue.mis.dao.LogDAO;
import com.njue.mis.dao.PortInDAO;
import com.njue.mis.handler.PortInServicesHandle;
import com.njue.mis.model.PortIn;

import java.util.Vector;

public class PortInServices implements PortInServicesHandle
{

	PortInDAO portInDAO=null;
	public PortInServices()
	{
		super();
	}


	public boolean addLog(String username, String time, String power, String dept, String detail) {
		LogDAO logDAO = new LogDAO();
		return logDAO.addLog(username, time, power, dept, detail);

	}



	public boolean addPortIn(PortIn portIn)
	{
		portInDAO=new PortInDAO();
		boolean result=false;
		result=portInDAO.addPortIn(portIn);
		//修改库存量
		GoodsServices goodsServices=new GoodsServices();
		goodsServices.changeGoodsNumber(portIn.getGoodsId(), portIn.getNumber());
		return  result;
	}

	
	public Vector<PortIn> getAllPortIn()
	{
		portInDAO=new PortInDAO();
		return portInDAO.getAllPortIn();
	}

	
	public Vector<PortIn> searchPortIn(String field, String value)
	{
		portInDAO=new PortInDAO();
		return portInDAO.searchPortIn(field, value);
	}

	
	public Vector<PortIn> searchPortInByTime(String beginTime,String endTime)
	{
		portInDAO=new PortInDAO();
		return portInDAO.searchPortInByTime(beginTime, endTime);
	}

	
	public boolean isExited(String id)
	{
		portInDAO=new PortInDAO();
		return portInDAO.isExited(id);
	}

}
