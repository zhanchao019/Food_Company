/**
 * ��Ӧ����DAO
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
	 * ����¹�Ӧ��
	 * @param provider ��װ�õĹ�Ӧ����Ϣ
	 * @return ִ�н��
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
	 * �����ݿ���ɾ��ָ����Ӧ�̵���Ϣ�����ڴ��������ϵ���˴������ñ��� available=0
	 * @param id ��ɾ����Ӧ�̵ı��
	 * @return ִ�н��
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
	 * ��ѯ���ݿ������������Ĺ�Ӧ��
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
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
	 * �޸Ĺ�Ӧ����Ϣ
	 * @param provider ��װ�õĹ�Ӧ������Ϣ
	 * @return ִ�н��
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
     * ��ʾ���еĹ�Ӧ��
     * @return ��Ӧ�̼���
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
     * �жϹ�Ӧ���Ƿ����
     * @param id ��ѯ���û��㻹
     * @return ��ѯ���
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
     * ��ȡ�ض���Ӧ�̵���Ϣ
     * @param id ��Ӧ�̱��
     * @return ��ѯ���
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
