/**
 * 供应商类DAO
 */
package com.njue.mis.dao;

import java.sql.ResultSet;
import java.util.Vector;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.Provider;

public class ProviderDAO extends PersonDAO
{ 
	public ProviderDAO()
	{
		super();
	}
	/**
	 * 添加新供应商
	 * @param provider 封装好的供应商信息
	 * @return 执行结果
	 */
	public boolean  addProvider(Provider provider)
	{
		boolean result=false;
		try
		{
			String sql="insert into tb_provider(id,providername,zip,address,telephone,connectionperson,phone,bank,account,email,fax,available) values (?,?,?,?,?,?,?,?,?,?,?,1)";
			Object[] params=new Object[]{provider.getId(),provider.getName(),provider.getZip(),
					                     provider.getAddress(),provider.getTelephone(),provider.getConnectionPerson(),
					                     provider.getPhone(),provider.getBank(),provider.getAccount(),
					                     provider.getEmail(),provider.getFax()};
			result=super.addPerson(sql, params);
		}
		catch (Exception e)
		{
			ErrorManager.printError("ProviderDAO.addProvider", e);
		}
		return result;
	}
	/**
	 * 从数据库中删除指定供应商的信息，由于存在外键关系，此处仅设置表中 available=0
	 * @param id 被删除供应商的编号
	 * @return 执行结果
	 */
	public boolean deleteProvider(String id)
	{
		boolean result=false;
		try
		{
			String sql="update tb_provider set available=0 where id=?";
			Object[] params=new Object[]{id};
			result=super.deletePerson(sql, params);
		}
		catch (Exception e)
		{
			ErrorManager.printError("ProviderDAO.deleteProvider", e);
		}
		return result;
	}
	/**
	 * 查询数据库中满足条件的供应商
	 * @param field 查询的字段
	 * @param value 满足的值
	 * @return 查询结果
	 */
    public Vector<Provider> searchProvider(String field,String value)
    {
    	Vector<Provider> result=new Vector<Provider>();
		try
		{
			String sql="{call pr_searchProvider(?,?)}";
			Object[] params=new Object[]{field,value};
			ResultSet rs=manage.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				Provider provider=new Provider(rs.getString("id"),rs.getString("providerName"),rs.getString("zip"),
									  rs.getString("address"),rs.getString("telephone"),
									  rs.getString("connectionPerson"),rs.getString("phone"),
									  rs.getString("bank"),rs.getString("account"),
									  rs.getString("email"),rs.getString("fax"));
				result.add(provider);
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("ProviderDAO.searchProvider", e);
		}
		return result;
    }
    /**
	 * 修改供应商信息
	 * @param provider 封装好的供应商新信息
	 * @return 执行结果
	 */
    public boolean modifyProvider(Provider provider)
    {
    	boolean result=false;
    	try
		{
    		String sql="update tb_provider set providername=?,zip=?,address=?,telephone=?,connectionperson=?,phone=?,bank=?,account=?,email=?,fax=? where id=?";
			Object[] params=new Object[]{provider.getName(),provider.getZip(),provider.getAddress(),
										 provider.getTelephone(),provider.getConnectionPerson(),provider.getPhone(),
										 provider.getBank(),provider.getAccount(),provider.getEmail(),
										 provider.getFax(),provider.getId()};
			result=super.modifyPerson(sql, params);
		}
		catch (Exception e)
		{
			ErrorManager.printError("ProviderDAO.modifyProvider", e);
		}
    	return result;
    }
    /**
     * 显示所有的供应商
     * @return 供应商集合
     */
    public Vector<Provider> getAllProvider()
    {
    	Vector<Provider>result=new Vector<Provider>();
    	try
		{
			String sql="{call pr_getAllProvider()}";
			ResultSet rs=manage.executeQuery(sql, null, Constants.CALL_TYPE);
			while(rs.next())
			{
				Provider provider=new Provider(rs.getString("id"),rs.getString("providername"),rs.getString("zip"),
					     rs.getString("address"),rs.getString("telephone"),rs.getString("connectionPerson"),
					     rs.getString("phone"),rs.getString("bank"),rs.getString("account"),
					     rs.getString("email"),rs.getString("fax"));
				result.add(provider);
			}
		}
		catch (Exception e)
		{
			ErrorManager.printError("ProviderDAO.getAllProvider", e);
		}
		return result;
    }
    /**
     * 判断供应商是否存在
     * @param id 查询的用户便还
     * @return 查询结果
     */
    public boolean isExited(String id)
    {
    	boolean result=false;
    	try
		{
			String sql="select * from tb_provider where id=?";
			Object[] params=new Object[]{id};
			result=super.isExited(sql, params);
			
		}
		catch (Exception e)
		{
			ErrorManager.printError("ProviderDAO.isExited", e);
		}
    	return result;
    }
    /**
     * 获取特定供应商的信息
     * @param id 供应商编号
     * @return 查询结果
     */
    public Provider getProviderInfo(String id)
    {
    	Provider provider=new Provider();
    	try
		{
			String sql="select * from tb_provider where id=?";
			Object[] params=new Object[]{id};
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
		    if(rs.next())
		    {
		    	provider=new Provider(rs.getString("id"),rs.getString("providername"),rs.getString("zip"),
					     rs.getString("address"),rs.getString("telephone"),rs.getString("connectionPerson"),
					     rs.getString("phone"),rs.getString("bank"),rs.getString("account"),
					     rs.getString("email"),rs.getString("fax"),rs.getInt("available"));
		    }
		    manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("ProviderDAO.getProviderInfo", e);
		}
    	return provider;
    }
}
