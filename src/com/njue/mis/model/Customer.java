/**
 * ¿Í»§Àà 
 */

package com.njue.mis.model;


public class Customer extends Person
{

	public Customer()
	{
		super();
	}

	public Customer(String id, String customerName, String zip, String address,
			String telephone, String connectionPerson,
			String phone,  String bank, String account, String email,String fax)
	{
		super(id, customerName, zip, address, telephone, connectionPerson, phone,
				 bank, account, email,fax);
	}

	public Customer(String id, String name, String zip, String address,
			String telephone,  String connectionPerson,
			String phone,  String bank, String account,String email,String fax,
			int available)
	{
		super(id, name, zip, address, telephone, connectionPerson, phone,
				bank, account, email, fax, available );
		// TODO Auto-generated constructor stub
	}
	
}
