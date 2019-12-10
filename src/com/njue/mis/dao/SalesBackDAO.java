/**
 * 销售退货类DAO
 */
package com.njue.mis.dao;

import java.sql.ResultSet;
import java.util.Vector;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.SalesBack;

public class SalesBackDAO extends ManagerDAO
{

	public SalesBackDAO()
	{
		super();
	}
	
	/**
	 * 向数据库中添加新的退货记录
	 * @param SalesBack 封装好的SalesIn对象
	 * @return 执行结果
	 */
	public boolean addSalesBack(SalesBack salesBack)
	{
		boolean result=false;
		try
		{
			String sql="insert into tb_salesback(id,customerid,paytype,salesbacktime,operateperson,number,price,comment,goodsid) values(?,?,?,?,?,?,?,?,?)";
			Object[] params=new Object[]{salesBack.getId(),salesBack.getCustomerId(),salesBack.getPayType(),
										 salesBack.getTime(),salesBack.getOperatePerson(),salesBack.getNumber(),
										 salesBack.getPrice(),salesBack.getComment(),salesBack.getGoodsId()};
			result=super.add(sql, params);
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesBackDAO.addSalesBack", e);
		}
		return result;
	}
	/**
	 * 查询数据库中满足条件的销售退货记录
	 * @param field 查询的字段
	 * @param value 满足的值
	 * @return 查询结果
	 */
	public Vector<SalesBack> searchSalesBack(String field,String value)
	{
		Vector<SalesBack> result=new Vector<SalesBack>();
		try
		{
			String sql="{call pr_searchSalesBack(?,?)}";
			Object[] params=new Object[]{field,value};
			ResultSet rs=manager.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				SalesBack salesBack=new SalesBack(rs.getString("id"),rs.getString("customerid"),rs.getString("goodsid"),
									  rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
									  rs.getString("salesbacktime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(salesBack);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesBackDAO.searchSalesBack", e);
		}
		return result;
	}
	/**
	 * 查询数据库中满足条件的销售退货记录
	 * @param beginTime 查询的开始时间
	 * @param endTime  查询的结束时间
	 * @return 查询结果
	 */
	public Vector<SalesBack> searchSalesBackByTime(String beginTime,String endTime)
	{
		Vector<SalesBack> result=new Vector<SalesBack>();
		try
		{
			String sql="{call pr_searchThroughTime(?,?,?,?)}";
			Object[] params=new Object[]{"tb_salesback","salesbacktime",beginTime,endTime};
			ResultSet rs=manager.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				SalesBack salesBack=new SalesBack(rs.getString("id"),rs.getString("customerid"),rs.getString("goodsid"),
									  rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
									  rs.getString("salesbacktime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(salesBack);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesBackDAO.searchSalesBack", e);
		}
		return result;
	}
	/**
	 * 获取所有的销售退回信息
	 * @return 销售退回信息集合
	 */
	public Vector<SalesBack> getAllSalesBack()
	{
        Vector<SalesBack> result=new Vector<SalesBack>();
		try
		{
			String sql="{call pr_getAllSalesBack()}";
			ResultSet rs=manager.executeQuery(sql, null, Constants.CALL_TYPE);
			while(rs.next())
			{
				SalesBack salesBack=new SalesBack(rs.getString("id"),rs.getString("customerid"),rs.getString("goodsid"),
											rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
											rs.getString("salesbacktime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(salesBack);
			}
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesBackDAO.getAllSalesBack", e);
		}
		return result;
	}
	/**
	 * 判断销售退回编号是否存在
	 * @param id 
	 * @return
	 */
	public boolean isExited(String id)
	{
		return super.isExited("tb_salesback", id);
	}
}
