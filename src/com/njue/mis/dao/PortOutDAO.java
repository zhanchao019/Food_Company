/**
 * �˻�����DAO
 */
package com.njue.mis.dao;

import java.sql.ResultSet;
import java.util.Vector;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.PortOut;

public class PortOutDAO extends ManagerDAO
{

	public PortOutDAO()
	{
		super();
	}

	/**
	 * ����µ��˻���¼
	 * @param portOut ��װ�õ�portOut����
	 * @return ִ�н��
	 */
	public boolean addPortOut(PortOut portOut)
	{
		boolean result=false;
		try
		{
			String sql="insert into tb_outport(id,providerid,paytype,outporttime,operateperson,number,price,comment,goodsid) values(?,?,?,?,?,?,?,?,?)";
			Object[] params=new Object[]{portOut.getId(),portOut.getProviderId(),portOut.getPayType(),
										 portOut.getTime(),portOut.getOperatePerson(),portOut.getNumber(),
										 portOut.getPrice(),portOut.getComment(),portOut.getGoodsId()};
			result=super.add(sql, params);
		}
		catch (Exception e)
		{
			ErrorManager.printError("PortOutDAO.addPortOut", e);
		}
		return result;
	}
	/**
	 * ��ѯ���ݿ��������������˻���¼
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	public Vector<PortOut> searchPortOut(String field,String value)
	{
		Vector<PortOut> result=new Vector<PortOut>();
		try
		{
			String sql="{call pr_searchPortOut(?,?)}";
			Object[] params=new Object[]{field,value};
			ResultSet rs=manager.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				PortOut portOut=new PortOut(rs.getString("id"),rs.getString("providerid"),rs.getString("goodsid"),
									  rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
									  rs.getString("outporttime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(portOut);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("PortOutDAO.searchPortOut", e);
		}
		return result;
	}
	/**
	 * ��ѯ���ݿ��������������˻���¼
	 * @param beginTime ��ѯ�Ŀ�ʼʱ��
	 * @param endTime  ��ѯ�Ľ���ʱ��
	 * @return ��ѯ���
	 */
	public Vector<PortOut> searchPortInByTime(String beginTime,String endTime)
	{
		Vector<PortOut> result=new Vector<PortOut>();
		try
		{
			String sql="{call pr_searchThroughTime(?,?,?,?)}";
			Object[] params=new Object[]{"tb_outport","outporttime",beginTime,endTime};
			ResultSet rs=manager.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				PortOut portOut=new PortOut(rs.getString("id"),rs.getString("providerid"),rs.getString("goodsid"),
									  rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
									  rs.getString("outporttime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(portOut);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesInDAO.searchPortIn", e);
		}
		return result;
	}
	/**
	 * ��ȡ���е��˻���Ϣ
	 * @return �˻���Ϣ����
	 */
	public Vector<PortOut> getAllPortOut()
	{
        Vector<PortOut> result=new Vector<PortOut>();
		try
		{
			String sql="{call pr_getAllPortOut()}";
			ResultSet rs=manager.executeQuery(sql, null, Constants.CALL_TYPE);
			while(rs.next())
			{
				PortOut portOut=new PortOut(rs.getString("id"),rs.getString("providerid"),rs.getString("goodsId"),
											rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
											rs.getString("outporttime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(portOut);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("PortOutDAO.getAllPortOut", e);
		}
		return result;
	}
	/**
	 * �ж��˻�����Ƿ����
	 * @param id 
	 * @return
	 */
	public boolean isExited(String id)
	{
		return super.isExited("tb_outport", id);
	}
}
