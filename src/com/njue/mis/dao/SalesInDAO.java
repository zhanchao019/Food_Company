/**
 * 销售进货类DAO
 */
package com.njue.mis.dao;

import java.sql.ResultSet;
import java.util.Vector;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.SalesIn;

public class SalesInDAO extends ManagerDAO
{

	public SalesInDAO()
	{
		super();
	}
	/**
	 * 向数据库中添加新的销售记录
	 * @param salesIn 封装好的SalesIn对象
	 * @return 执行结果
	 */
	public boolean addSalesIn(SalesIn salesIn)
	{
		boolean result=false;
		try
		{
			String sql="insert into tb_sales(id,customerid,paytype,salestime,operateperson,number,price,comment,goodsid) values(?,?,?,?,?,?,?,?,?)";
			Object[] params=new Object[]{salesIn.getId(),salesIn.getCustomerId(),salesIn.getPayType(),
					                   salesIn.getTime(),salesIn.getOperatePerson(),salesIn.getNumber(),
					                   salesIn.getPrice(),salesIn.getComment(),salesIn.getGoodsId()};
			result=super.add(sql, params);
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesInDAO.addSalesIn", e);
		}
		return result;
	}
	/**
	 * 获取所有的销售信息
	 * @return 销售信息集合
	 */
	public Vector<SalesIn> getAllSalesIn()
	{
        Vector<SalesIn> result=new Vector<SalesIn>();
		try
		{
			String sql="{call pr_getAllSalesIn()}";
			ResultSet rs=manager.executeQuery(sql, null, Constants.CALL_TYPE);
			while(rs.next())
			{
				SalesIn salesIn=new SalesIn(rs.getString("id"),rs.getString("customerid"),rs.getString("goodsid"),
											rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
											rs.getString("salestime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(salesIn);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesInDAO.getAllSalesIn", e);
		}
		return result;
	}
	/**
	 * 查询数据库中满足条件的销售记录
	 * @param field 查询的字段
	 * @param value 满足的值
	 * @return 查询结果
	 */
	public Vector<SalesIn> searchSalesIn(String field,String value)
	{
		Vector<SalesIn> result=new Vector<SalesIn>();
		try
		{
			String sql="{call pr_searchSalesIn(?,?)}";
			Object[] params=new Object[]{field,value};
			ResultSet rs=manager.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				SalesIn salesIn=new SalesIn(rs.getString("id"),rs.getString("customerid"),rs.getString("goodsid"),
									  rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
									  rs.getString("salestime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(salesIn);
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
	 * 查询数据库中满足条件的销售记录
	 * @param beginTime 查询的开始时间
	 * @param endTime  查询的结束时间
	 * @return 查询结果集
	 */
	public Vector<SalesIn> searchPortInByTime(String beginTime,String endTime)
	{
		Vector<SalesIn> result=new Vector<SalesIn>();
		try
		{
			String sql="{call pr_searchThroughTime(?,?,?,?)}";
			Object[] params=new Object[]{"tb_sales","salestime",beginTime,endTime};
			ResultSet rs=manager.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				SalesIn salesIn=new SalesIn(rs.getString("id"),rs.getString("customerid"),rs.getString("goodsid"),
									  rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
									  rs.getString("salestime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(salesIn);
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
	 * 判断销售编号是否存在
	 * @param id 
	 * @return
	 */
	public boolean isExited(String id)
	{
		return super.isExited("tb_sales", id);
	}
}
