/**
 * ����
 */

package com.njue.mis.model;

public class StorageCheck
{
	private int id;  //���
	private String goodsId;  //��Ʒ���
	private int number;  //��Ʒ����
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
