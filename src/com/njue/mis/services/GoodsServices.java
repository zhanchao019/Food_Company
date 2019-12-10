/**
 * 商品服务类
 */
package com.njue.mis.services;

import java.util.Vector;

import com.njue.mis.dao.GoodsDAO;
import com.njue.mis.handler.GoodsServicesHandler;
import com.njue.mis.model.Goods;
import com.njue.mis.model.StorageGoods;

public class GoodsServices implements GoodsServicesHandler
{

	GoodsDAO goodsDAO=null;
	public GoodsServices()
	{
		super();
	}

	
	public boolean addGoods(Goods goods)
	{
		goodsDAO=new GoodsDAO();
		return goodsDAO.addGoods(goods);
	}

	
	public boolean deleteGoods(String id)
	{
		goodsDAO=new GoodsDAO();
		return goodsDAO.deleteGoods(id);
	}

	
	public Vector<Goods> searchGoods(String field,String value)
	{
		goodsDAO=new GoodsDAO();
		return goodsDAO.searchGoods(field, value);
	}

	
	public boolean modifyGoodsPrice(String id,double price)
	{
		goodsDAO=new GoodsDAO();
		return goodsDAO.modifyGoodsPrice(id, price);
	}

	
	public Vector<Goods> getAllGoods()
	{
		goodsDAO=new GoodsDAO();
		return goodsDAO.getAllGoods();
	}
	/**
	 * 修改商品的库存量
	 * @param goodsID 被修改的商品编号
	 * @param number 数量
	 * @return
	 */
	public boolean changeGoodsNumber(String goodsID,int number)
	{
		goodsDAO=new GoodsDAO();
		return goodsDAO.changeGoodsNumber(goodsID, number);
	}

	
	public boolean isExited(String id)
	{
		goodsDAO=new GoodsDAO();
		return goodsDAO.isExited(id);
	}

	
	public Goods getGoodsInfo(String id)
	{
		goodsDAO=new GoodsDAO();
		return goodsDAO.getGoodsInfo(id);
	}

	
	public Vector<StorageGoods> getAllStorageGoods()
	{
		goodsDAO=new GoodsDAO();
		return goodsDAO.getAllStorageGoods();
	}
}
