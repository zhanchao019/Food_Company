/**
 * 管理员类
 */

package com.njue.mis.model;

public class Operator
{
	private String userName;  //用户名
	private String password;  //密码
	private String name;  //姓名
	private String power;  //权限
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
