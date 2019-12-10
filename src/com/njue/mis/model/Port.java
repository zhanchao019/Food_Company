/**
 * ������
 */

package com.njue.mis.model;


import com.njue.mis.common.CommonFactory;
import com.njue.mis.common.ValidationManager;
import com.njue.mis.handler.GoodsServicesHandler;
import com.njue.mis.handler.ProviderServicesHandler;

public abstract class Port
{
	private String id;  //���
	private String providerId;  //��Ӧ�̱��
	private String goodsId;  //��Ʒ���
	private String payType;  //֧������
	private int number;  //����
	private double price; //�۸�
	private String time;  //֧��ʱ��
	private String operatePerson;  //����Ա
	private String comment;  //ע��
	public Port()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Port(String id, String providerId, String goodsId, String payType,
			int number, double price, String time, String operatePerson,
			String comment)
	{
		super();
		this.id = id;
		this.providerId = providerId;
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
	public String getProviderId()
	{
		return providerId;
	}
	public void setProviderId(String providerId)
	{
		this.providerId = providerId;
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
	public void setInportTime(String time)
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
	public void setTime(String time)
	{
		this.time = time;
	}
	/**
	 * ���ؼ�����
	 * @param columnNumber �к�
	 * @return ��Ӧ�е�ֵ
	 */
	public Object getPortValue(int columnNumber)
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
			return ValidationManager.changeNull(getProviderId());
		case 7:
			{
				ProviderServicesHandler handler=CommonFactory.getProviderServices();
				Provider provider=handler.getProviderInfo(getProviderId());
				return ValidationManager.changeNull(provider.getName());
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
