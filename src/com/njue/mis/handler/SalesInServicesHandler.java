/**
 * 销售服务接口
 */
package com.njue.mis.handler;

import com.njue.mis.model.SalesIn;

import java.util.Vector;

public interface SalesInServicesHandler
{
	boolean addLog(String username, String time, String power, String dept, String detail);
	/**
	 * 向数据库中添加新的销售记录
	 * @param orderid 封装好的SalesIn对象
	 * @return 执行结果
	 */
	boolean pay(String orderid);

	/**
	 * 向数据库中添加新的销售记录
	 * @param salesIn 封装好的SalesIn对象
	 * @return 执行结果
	 */
	boolean addSalesIn(SalesIn salesIn);
	/**
	 * 获取所有的销售信息
	 * @return 销售信息集合
	 */
	Vector<SalesIn> getAllSalesIn();

	/**
	 * 获取所有的销售信息
	 *
	 * @return 销售信息集合
	 */
	Vector<SalesIn> getAllOnTimeSalesIn();//getAllOnTimeSalesIn

	/**
	 * 获取所有的销售信息
	 *
	 * @return 销售信息集合
	 */
	Vector<SalesIn> getAllOrderedSalesIn();
	/**
	 * 查询数据库中满足条件的销售记录
	 * @param field 查询的字段
	 * @param value 满足的值
	 * @return 查询结果
	 */
	Vector<SalesIn> searchSalesIn(String field,String value);
	/**
	 * 查询数据库中满足条件的销售记录
	 * @param beginTime 查询的开始时间
	 * @param endTime  查询的结束时间
	 * @return 查询结果集
	 */
	Vector<SalesIn> searchPortInByTime(String beginTime, String endTime);

	/**
	 * 向数据库中添加新的销售记录
	 * @param orderid 封装好的SalesIn对象
	 * @return 执行结果
	 */
	boolean opt(String orderid, String goodsid);

	/**
	 * 向数据库中添加新的销售记录
	 *
	 * @param orderid 封装好的SalesIn对象
	 * @return 执行结果
	 */
	boolean optR(String orderid, String goodsid, int sum);

	/**
	 * 向数据库中添加新的销售记录
	 *
	 * @param goodsid
	 * @return 执行结果
	 */
	int getSum(String goodsid);

	/**
	 * 判断销售编号是否存在
	 * @param id 
	 * @return
	 */
	boolean isExited(String id);

	/**
	 * 向数据库中退货
	 *
	 * @param orderid  封装好的SalesIn对象
	 * @param paystate
	 * @return 执行结果
	 */
	boolean back(String orderid, String paystate);


}
