/**
 * ����Ա��
 */

package com.njue.mis.model;

public class Operator
{
	private String userName;  //�û���
	private String password;  //����
	private String name;  //����
	private String power;  //Ȩ��
	public Operator()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Operator(String userName, String password, String name, String power)
	{
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.power = power;
	}
	
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPower()
	{
		return power;
	}
	public void setPower(String power)
	{
		this.power = power;
	}
}
