/**
 * 抽象类
 */

package com.njue.mis.model;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.common.ValidationManager;
import com.njue.mis.handler.CustomerServicesHandler;
import com.njue.mis.handler.GoodsServicesHandler;

public abstract class Sales
{
	private String id;  //编号
	private String customerId;  //客户编号
	private String goodsId;  //商品编号
	private String payType;  //支付类型
	private int number;  //数量
	private double price;  //价格
	private String time;  //时间
	private String operatePerson; //操作员  
	private String comment;  //注释
	public Sales()
	{
		super();
	}

	public Sales(String id, String customerId, String goodsId, String payType,
			int number, double price, String time, String operatePerson,
			String comment)
	{
		super();
		this.id = id;
		this.customerId = customerId;
		this.goodsId = goodsId;
		this.payType = payType;
		this.number = number;
		this.price = price;
		this.time = time;
		this.operatePerson = operatePerson;
		this.comment = comment;
	}

	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getCustomerId()
	{
		return customerId;
	}
	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}
	public String getGoodsId()
	{
		return goodsId;
	}
	public void setGoodsId(String goodsId)
	{
		this.goodsId = goodsId;
	}
	public String getPayType()
	{
		return payType;
	}
	public void setPayType(String payType)
	{
		this.payType = payType;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public String getOperatePerson()
	{
		return operatePerson;
	}
	public void setOperatePerson(String operatePerson)
	{
		this.operatePerson = operatePerson;
	}
	public String getComment()
	{
		return comment;
	}
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public Object getSalesValue(int columnNumber)
	{
		switch (columnNumber)
		{
		case 0:
			return ValidationManager.changeNull(getId());
			
		case 1:
			return ValidationManager.changeNull(getGoodsId());
		case 2:
			{
				GoodsServicesHandler handler=CommonFactory.getGoodsServices();
				Goods goods=handler.getGoodsInfo(getGoodsId());
				return  ValidationManager.changeNull(goods.getGoodsName());
			}
		case 3:
			{
				GoodsServicesHandler handler=CommonFactory.getGoodsServices();
				Goods goods=handler.getGoodsInfo(getGoodsId());
				return  ValidationManager.changeNull(goods.getPrice());
			}
		case 4:
			return ValidationManager.changeNull(getNumber());
		case 5:
			return ValidationManager.changeNull(getPrice());
		case 6:
			return ValidationManager.changeNull(getCustomerId());
		case 7:
			{
				CustomerServicesHandler handler=CommonFactory.getCustomerServices();
				Customer customer=handler.getCustomerInfo(getCustomerId());
				return ValidationManager.changeNull(customer.getName());
			}
		case 8:		
			return ValidationManager.changeNull(getTime());
		case 9:
			return ValidationManager.changeNull(getOperatePerson());
		default:
			return "";
		}
	}
	
}
