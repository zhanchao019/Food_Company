/**
 * ÕÀªı¿‡
 */

package com.njue.mis.model;


public class SalesBack extends Sales
{

	public SalesBack()
	{
		super();
	}

	public SalesBack(String id, String customerId, String goodsId,
					 String payType, int number, double price, String time,
					 String operatePerson, String comment, String state, String paid)
	{
		super(id, customerId, goodsId, payType, number, price, time, operatePerson,
				comment, state, paid);
	}

}
