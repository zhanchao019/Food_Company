/**
 * ���۱�
 */

package com.njue.mis.model;


public class SalesIn extends Sales
{

	public SalesIn()
	{
		super();
	}

	public SalesIn(String id, String customerId, String goodsId,
				   String payType, int number, double price, String time,
				   String operatePerson, String comment, String state)
	{
		super(id, customerId, goodsId, payType, number, price, time, operatePerson,
				comment, state);
	}

}
