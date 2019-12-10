/**
 * 商品DAO类，主要对商品信息进行管理
 */
package com.njue.mis.dao;

import java.sql.ResultSet;
import java.util.Vector;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.Goods;
import com.njue.mis.model.StorageGoods;

public class GoodsDAO
{

	SqlManager manage=null;
	public GoodsDAO()
	{
		super();
		manage=SqlManager.createInstance();
		manage.connectDB();
	}
	
	/**
	 * 向数据库中添加商品
	 * @param goods 封装好的Goods对象
	 * @return 执行结果
	 */
	public boolean addGoods(Goods goods)
	{
		boolean result=false;
		try
		{
			Object[] params=new Object[]{goods.getId(),goods.getGoodsName(),goods.getProducePlace(),
					                     goods.getSize(),goods.get_package(),goods.getProductCode(),
					                     goods.getPromitCode(),goods.getDescription(),goods.getPrice(),
					                     goods.getProviderId()};
			String sql="insert into tb_goods(id,goodsname,produceplace,size,package,productcode,promitcode,description,price,providerid,available) values(?,?,?,?,?,?,?,?,?,?,1)";
			result=manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("oodsDAO.addGoods", e);
		}
		return result;
	}
	/**
	 * 删除数据库中的商品，由于存在外键关系，此处仅设置表中 available=0
	 * @param id 被删除商品的编号
	 * @return 执行结果
	 */
	public boolean deleteGoods(String id)
	{
		boolean result=false;
		try
		{
			String sql="update tb_goods set available=0 where id=?";
			Object[] params=new Object[]{id};
			result=manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("oodsDAO.deleteGoods", e);
		}
		return result;
	}
	
	/**
	 * 查询数据库中满足条件的商品
	 * @param field 查询的字段
	 * @param value 满足的值
	 * @return 查询结果
	 */
	public Vector<Goods> searchGoods(String field,String value)
	{
		Vector<Goods> result=new Vector<Goods>();
		try
		{
			String sql="{call pr_searchGoods(?,?)}";
			Object[] params=new Object[]{field,value};
			ResultSet rs=manage.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				Goods goods=new Goods(rs.getString("id"),rs.getString("goodsName"),rs.getString("producePlace"),
									  rs.getString("size"),rs.getString("package"),rs.getString("productCode"),
									  rs.getString("promitCode"),rs.getString("description"),rs.getDouble("price"),
									  rs.getString("providerId"));
				result.add(goods);
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("oodsDAO.searchGoods", e);
		}
		return result;
	}
	/**
	 * 修改商品的价格
	 * @param id 被修改商品的编号
	 * @param price 新的价格
	 * @return 执行结果
	 */
	public boolean modifyGoodsPrice(String id,double price)
	{
		boolean result=false;
		try
		{
			String sql="update tb_goods set price=? where id=?";
			Object[] params=new Object[]{price,id};
			result=manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("oodsDAO.modifyGoodsPrice", e);
		}
		return result;
	}
	/**
	 * 获取所有的商品
	 * @return 商品的集合
	 */
	public Vector<Goods> getAllGoods()
	{
		Vector<Goods> result=new Vector<Goods>();
		try
		{
			String sql="{call pr_getAllgoods()}";
			ResultSet rs=manage.executeQuery(sql, null, Constants.CALL_TYPE);
			while(rs.next())
			{
				Goods goods=new Goods(rs.getString("id"),rs.getString("goodsName"),rs.getString("producePlace"),
						rs.getString("size"),rs.getString("package"),rs.getString("productCode"),
						rs.getString("promitCode"),rs.getString("description"),rs.getDouble("price"),rs.getString("providerId"));
				result.add(goods);
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("oodsDAO.getAllGoods", e);
		}
		return result;
	}
	/**
	 * 查询库存的商品信息
	 * @return  查询结果集
	 */
	public Vector<StorageGoods> getAllStorageGoods()
	{
		Vector<StorageGoods> result=new Vector<StorageGoods>();
		try
		{
			String sql="{call pr_getAllStorageGoods()}";
			ResultSet rs=manage.executeQuery(sql, null, Constants.CALL_TYPE);
			while(rs.next())
			{
				Goods goods=new Goods(rs.getString("id"),rs.getString("goodsName"),rs.getString("producePlace"),
						rs.getString("size"),rs.getString("package"),rs.getString("productCode"),
						rs.getString("promitCode"),rs.getString("description"),rs.getDouble("price"),rs.getString("providerId"));
				StorageGoods storageGoods=new StorageGoods(rs.getInt("id"),rs.getInt("number"),goods);
				result.add(storageGoods);
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("GoodsDAO.getAllStorageGoods", e);
		}
		return result;
	}
	/**
	 * 修改商品的库存量
	 * @param goodsID 被修改的商品编号
	 * @param number 数量
	 * @return
	 */
	public boolean changeGoodsNumber(String goodsID,int number)
	{
		boolean result=false;
		try
		{
			if(!isExitedInStorage(goodsID))
			{
				String sql="insert into tb_storagecheck(goodsid,number) values(?,?)";
				Object[] params=new Object[]{goodsID,number};
				result=manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			}
			else
			{
				String sql="call pr_changeGoodsNumber(?,?)";
				Object[] params=new Object[]{goodsID,number};
				result=manage.executeUpdate(sql, params, Constants.CALL_TYPE);
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("GoodsDAO.changeGoodsNumber", e);
		}
		return result;
	}
	/**
	 * 判断商品记录是否存在与tb_storagecheck表中
	 * @param goodsID 查询的商品编号
	 * @return 查询结果
	 */
	private boolean isExitedInStorage(String goodsID)
	{
		boolean result=false;
		try
		{
			String sql="select * from tb_storagecheck where goodsid=?";
			Object[] params=new Object[]{goodsID};
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			while(rs.next())
			{
				result=true;
				break;
			}
		}
		catch (Exception e)
		{
			ErrorManager.printError("GoodsDAO.changeGoodsNumber", e);
		}
		return result;
	}
	/**
     * 判断商品是否存在
     * @param id 查询的商品编号
     * @return 查询结果
     */
    public boolean isExited(String id)
    {
    	boolean result=false;
    	try
		{
			String sql="select * from tb_goods where id=?";
			Object[] params=new Object[]{id};
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			if(rs.next())
				result=true;
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("GoodsDAO.isExited", e);
		}
    	return result;
    }
    /**
     * 获取商品的信息
     * @param id 被查询的商品的编号
     * @return 查询结果
     */
    public Goods getGoodsInfo(String id)
    {
    	Goods goods=new Goods();
    	try
		{
			String sql="select * from tb_goods where id=?";
			Object[] params=new Object[]{id};
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			if(rs.next())
			{
				goods=new Goods(rs.getString("id"),rs.getString("goodsName"),rs.getString("producePlace"),
						rs.getString("size"),rs.getString("package"),rs.getString("productCode"),
						rs.getString("promitCode"),rs.getString("description"),rs.getDouble("price"),rs.getString("providerId"),rs.getInt("available"));
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("GoodsDAO.getGoodsInfo", e);
		}
    	return goods;
    }

}
