/**
 * 进货单类DAO
 */
package com.njue.mis.dao;

import java.sql.ResultSet;
import java.util.Vector;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.PortIn;

public class PortInDAO extends ManagerDAO
{
	public PortInDAO()
	{
		super();
	}
	/**
	 * 添加新的进货记录
	 * @param portIn 封装好的PortIn对象
	 * @return 执行结果
	 */
	public boolean addPortIn(PortIn portIn)
	{
		boolean result=false;
		try
		{
			String sql="insert into tb_inport(id,providerid,paytype,inporttime,operateperson,number,price,comment,goodsid) values(?,?,?,?,?,?,?,?,?)";
			Object[] params=new Object[]{portIn.getId(),portIn.getProviderId(),portIn.getPayType(),
					                     portIn.getTime(),portIn.getOperatePerson(),portIn.getNumber(),
					                     portIn.getPrice(),portIn.getComment(),portIn.getGoodsId()};
			result=super.add(sql, params);
		}
		catch (Exception e)
		{
			ErrorManager.printError("PortInDAO.addPortIn", e);
		}
		return result;
	}
	
	/**
	 * 查询数据库中满足条件的进货记录
	 * @param field 查询的字段
	 * @param value 满足的值
	 * @return 查询结果
	 */
	public Vector<PortIn> searchPortIn(String field,String value)
	{
		Vector<PortIn> result=new Vector<PortIn>();
		try
		{
			String sql="{call pr_searchPortIn(?,?)}";
			Object[] params=new Object[]{field,value};
			ResultSet rs=manager.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				PortIn portIn=new PortIn(rs.getString("id"),rs.getString("providerid"),rs.getString("goodsid"),
									  rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
									  rs.getString("inporttime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(portIn);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("PortInDAO.searchPortIn", e);
		}
		return result;
	}
	/**
	 * 查询数据库中满足条件的进货记录
	 * @param beginTime 查询的开始时间
	 * @param endTime  查询的结束时间
	 * @return 查询结果集
	 */
	public Vector<PortIn> searchPortInByTime(String beginTime,String endTime)
	{
		Vector<PortIn> result=new Vector<PortIn>();
		try
		{
			String sql="{call pr_searchThroughTime(?,?,?,?)}";
			Object[] params=new Object[]{"tb_inport","inporttime",beginTime,endTime};
			ResultSet rs=manager.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				PortIn portIn=new PortIn(rs.getString("id"),rs.getString("providerid"),rs.getString("goodsid"),
									  rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
									  rs.getString("inporttime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(portIn);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("PortInDAO.searchPortIn", e);
		}
		return result;
	}
	/**
	 * 获取所有的进货信息
	 * @return 进货信息集合
	 */
	public Vector<PortIn> getAllPortIn()
	{
        Vector<PortIn> result=new Vector<PortIn>();
		try
		{
			String sql="{call pr_getAllPortIn()}";
			ResultSet rs=manager.executeQuery(sql, null, Constants.CALL_TYPE);
			while(rs.next())
			{
				PortIn portIn=new PortIn(rs.getString("id"),rs.getString("providerid"),rs.getString("goodsId"),
											rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
											rs.getString("inporttime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(portIn);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("PortInDAO.PortIn", e);
		}
		return result;
	}
	/**
	 * 判断进货编号是否存在
	 * @param id 
	 * @return
	 */
	public boolean isExited(String id)
	{
		return super.isExited("tb_inport", id);
	}
	
//	public static void main(String[] args)
//	{
//		PortInDAO in=new PortInDAO();
//		Vector<PortIn> vector=in.searchPortInByTime("2001-08-02","2010-01-01");
//		System.err.println(vector.size());
//	}
}
