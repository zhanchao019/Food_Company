package com.njue.mis.handler;

import com.njue.mis.model.StorageGoods;

import java.util.Vector;

public interface StorageGoodsHandler
{
	boolean addLog(String username, String time, String power, String dept, String detail);
	public Vector<StorageGoods> getAllStorageGoods();
}
