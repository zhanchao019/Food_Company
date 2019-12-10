package com.njue.mis.services;

import java.util.Vector;

import com.njue.mis.dao.SqlManager;
import com.njue.mis.handler.StorageGoodsHandler;
import com.njue.mis.model.StorageGoods;

public class StorageGoodsServices implements StorageGoodsHandler
{
	SqlManager manage=null;
	
	public StorageGoodsServices()
	{
		super();
		manage=SqlManager.createInstance();
		manage.connectDB();
	}
	public Vector<StorageGoods> getAllStorageGoods()
	{
		Vector<StorageGoods> result=new Vector<StorageGoods>();
//    	try
//		{
//			String sql="select * from tb_goods ";
//			ResultSet rs=manage.executeQuery(sql, null, Constants.CALL_TYPE);
//			while(rs.next())
//			{
//				Customer person=new Customer(rs.getString("id"),rs.getString("customername"),rs.getString("zip"),
//					     rs.getString("address"),rs.getString("telephone"),rs.getString("connectionPerson"),
//					     rs.getString("phone"),rs.getString("bank"),rs.getString("account"),
//					     rs.getString("email"),rs.getString("fax"));
//				result.add(person);
//			}
//			manage.closeDB();
//		}
//		catch (Exception e)
//		{
//			ErrorManager.printError("CustomerDAO.getAllCustomer", e);
//		}
		return result;	
	}
}
