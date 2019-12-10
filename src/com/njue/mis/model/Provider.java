/**
 * 供应商类
 */

package com.njue.mis.model;

public class Provider extends Person
{

	public Provider()
	{
		super();
	}

	public Provider(String id, String providerName, String zip, String address,
			String telephone, String fax, String connectionPerson,
			String phone, String email, String bank, String account)
	{
		super(id, providerName, zip, address, telephone, fax, connectionPerson, phone,
				email, bank, account);
	}

	public Provider(String id, String name, String zip, String address,
			String telephone, String fax, String connectionPerson,
			String phone, String email, String bank, String account,
			int available)
	{
		super(id, name, zip, address, telephone, fax, connectionPerson, phone, email,
				bank, account, available);
		// TODO Auto-generated constructor stub
	}

}
