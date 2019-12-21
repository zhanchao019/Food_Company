/**
 * ��ƷDAO�࣬��Ҫ����Ʒ��Ϣ���й���
 */
package com.njue.mis.dao;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.Goods;
import com.njue.mis.model.StorageGoods;

import java.sql.ResultSet;
import java.util.Vector;

public class GoodsDAO
{

	SqlManager manage=null;
	public GoodsDAO()
	{
		super();
		manage=SqlManager.createInstance();
		manage.connectDB();
	}
	
	/**
	 * �����ݿ��������Ʒ
	 * @param goods ��װ�õ�Goods����
	 * @return ִ�н��
	 */
	public boolean addGoods(Goods goods)
	{
		boolean result=false;
		try {
			Object[] params = new Object[]{goods.getId(), goods.getGoodsName(), goods.getProducePlace(),
					goods.getSize(), goods.get_package(), goods.getProductCode(),
					goods.getPromitCode(), goods.getDescription(), goods.getPrice(),
					goods.getProviderId()};
            String sql = "insert into tb_goods(id,goodsname,produceplace,size,rawmaterial,productcode,promitcode,description,price,providerid,available) values(?,?,?,?,?,?,?,?,?,?,1)";
			result = manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			System.out.println("�����ɣ�");
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("oodsDAO.addGoods", e);
		}
		return result;
	}
	/**
	 * ɾ�����ݿ��е���Ʒ�����ڴ��������ϵ���˴������ñ��� available=0
	 * @param id ��ɾ����Ʒ�ı��
	 * @return ִ�н��
	 */
	public boolean deleteGoods(String id)
	{
		boolean result=false;
		try
		{
			String sql="update tb_goods set available=0 where id=?";
			Object[] params=new Object[]{id};
			result=manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("oodsDAO.deleteGoods", e);
		}
		return result;
	}
	
	/**
	 * ��ѯ���ݿ���������������Ʒ
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	public Vector<Goods> searchGoods(String field,String value)
	{
		Vector<Goods> result=new Vector<Goods>();
		try
		{
			String sql="{call pr_searchGoods(?,?)}";
			Object[] params=new Object[]{field,value};
			ResultSet rs=manage.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				Goods goods=new Goods(rs.getString("id"),rs.getString("goodsName"),rs.getString("producePlace"),
						rs.getInt("size"), rs.getString("rawmaterial"), rs.getString("productCode"),
									  rs.getString("promitCode"),rs.getString("description"),rs.getDouble("price"),
									  rs.getString("providerId"));
				result.add(goods);
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("oodsDAO.searchGoods", e);
		}
		return result;
	}
	/**
	 * �޸���Ʒ�ļ۸�
	 * @param id ���޸���Ʒ�ı��
	 * @param price �µļ۸�
	 * @return ִ�н��
	 */
	public boolean modifyGoodsPrice(String id,double price)
	{
		boolean result=false;
		try
		{
			String sql = "update tb_goods set price= ? where id=?";
			Object[] params=new Object[]{price,id};
			result=manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("oodsDAO.modifyGoodsPrice", e);
		}
		return result;
	}
	/**
	 * ��ȡ���е���Ʒ
	 * @return ��Ʒ�ļ���
	 */
	public Vector<Goods> getAllGoods()
	{
		Vector<Goods> result=new Vector<Goods>();
		try
		{
			String sql="{call pr_getAllgoods()}";
			ResultSet rs=manage.executeQuery(sql, null, Constants.CALL_TYPE);
			while(rs.next())
			{
				Goods goods=new Goods(rs.getString("id"),rs.getString("goodsName"),rs.getString("producePlace"),
						rs.getInt("size"), rs.getString("rawmaterial"), rs.getString("productCode"),
						rs.getString("promitCode"), rs.getString("description"), rs.getDouble("price"),
						rs.getString("providerId"));
				result.add(goods);
			}

			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("oodsDAO.getAllGoods", e);
		}
		return result;
	}
	/**
	 * ��ѯ������Ʒ��Ϣ
	 * @return  ��ѯ�����
	 */
	public Vector<StorageGoods> getAllStorageGoods()
	{
		Vector<StorageGoods> result=new Vector<StorageGoods>();
		try
		{
			String sql="{call pr_getAllStorageGoods()}";
			ResultSet rs=manage.executeQuery(sql, null, Constants.CALL_TYPE);
			while(rs.next())
			{
				Goods goods=new Goods(rs.getString("id"),rs.getString("goodsName"),rs.getString("producePlace"),
						rs.getInt("size"), rs.getString("rawmaterial"), rs.getString("productCode"),
						rs.getString("promitCode"), rs.getString("description"), rs.getDouble("price"),
						rs.getString("providerId"));
				StorageGoods storageGoods=new StorageGoods(rs.getInt("id"),rs.getInt("number"),goods);
				result.add(storageGoods);
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("GoodsDAO.getAllStorageGoods", e);
		}
		return result;
	}
	/**
	 * �޸���Ʒ�Ŀ����
	 * @param goodsID ���޸ĵ���Ʒ���
	 * @param number ����
	 * @return
	 */
	public boolean changeGoodsNumber(String goodsID,int number)
	{
		boolean result=false;
		try
		{
			if(!isExitedInStorage(goodsID))
			{
				String sql="insert into tb_storagecheck(goodsid,number) values(?,?)";
				Object[] params=new Object[]{goodsID,number};
				result=manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
			}
			else
			{
				String sql="call pr_changeGoodsNumber(?,?)";
				Object[] params=new Object[]{goodsID,number};
				result=manage.executeUpdate(sql, params, Constants.CALL_TYPE);
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("GoodsDAO.changeGoodsNumber", e);
		}
		return result;
	}
	/**
	 * �ж���Ʒ��¼�Ƿ������tb_storagecheck����
	 * @param goodsID ��ѯ����Ʒ���
	 * @return ��ѯ���
	 */
	private boolean isExitedInStorage(String goodsID)
	{
		boolean result=false;
		try
		{
			String sql="select * from tb_storagecheck where goodsid=?";
			Object[] params=new Object[]{goodsID};
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			while(rs.next())
			{
				result=true;
				break;
			}
		}
		catch (Exception e)
		{
			ErrorManager.printError("GoodsDAO.changeGoodsNumber", e);
		}
		return result;
	}
	/**
     * �ж���Ʒ�Ƿ����
     * @param id ��ѯ����Ʒ���
     * @return ��ѯ���
     */
    public boolean isExited(String id)
    {
    	boolean result=false;
    	try
		{
			String sql="select * from tb_goods where id=?";
			Object[] params=new Object[]{id};
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			if(rs.next())
				result=true;
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("GoodsDAO.isExited", e);
		}
    	return result;
    }
    /**
     * ��ȡ��Ʒ����Ϣ
     * @param id ����ѯ����Ʒ�ı��
     * @return ��ѯ���
     */
    public Goods getGoodsInfo(String id)
    {
    	Goods goods=new Goods();
    	try
		{
			String sql = "select * from tb_goods where id= ?";
			Object[] params=new Object[]{id};
			ResultSet rs=manage.executeQuery(sql, params, Constants.PSTM_TYPE);
			if(rs.next())
			{
				goods=new Goods(rs.getString("id"),rs.getString("goodsName"),rs.getString("producePlace"),
						rs.getInt("size"), rs.getString("rawmaterial"), rs.getString("productCode"),
						rs.getString("promitCode"), rs.getString("description"), rs.getDouble("price"),
						rs.getString("providerId"));
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("GoodsDAO.getGoodsInfo", e);
		}
    	return goods;
    }

}
