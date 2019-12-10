package com.njue.mis.model;

public class StorageGoods
{
	private int id;
	private int number;
	private Goods goods;

	public StorageGoods()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public StorageGoods(int id, int number, Goods goods)
	{
		super();
		this.id = id;
		this.number = number;
		this.goods = goods;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public Goods getGoods()
	{
		return goods;
	}

	public void setGoods(Goods goods)
	{
		this.goods = goods;
	}

	public Object getStorageGoodsValue(int col)
	{
		switch (col)
		{
		case 0:
			return id;
		case 1:
			return goods.getGoodsName();
		case 2:
			return goods.getProviderId();
		case 3:
			return goods.getProducePlace();
		case 4:
			return number;
		case 5:
			return String.valueOf(goods.getPrice());
		case 6:
			return goods.getSize();
		case 7:
			return goods.get_package();
		default:
			return null;
		}
	}
}
