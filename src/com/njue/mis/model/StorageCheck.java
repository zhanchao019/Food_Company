/**
 * 库存表
 */

package com.njue.mis.model;

public class StorageCheck
{
	private int id;  //编号
	private String goodsId;  //商品编号
	private int number;  //商品数量
	public StorageCheck()
	{
		super();
	}
	public StorageCheck(int id, String goodsId, int number)
	{
		super();
		this.id = id;
		this.goodsId = goodsId;
		this.number = number;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getGoodsId()
	{
		return goodsId;
	}
	public void setGoodsId(String goodsId)
	{
		this.goodsId = goodsId;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
}
