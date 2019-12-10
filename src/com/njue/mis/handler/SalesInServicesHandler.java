/**
 * 销售服务接口
 */
package com.njue.mis.handler;

import java.util.Vector;

import com.njue.mis.model.SalesIn;

public interface SalesInServicesHandler
{
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
	Vector<SalesIn> searchPortInByTime(String beginTime,String endTime);
	/**
	 * 判断销售编号是否存在
	 * @param id 
	 * @return
	 */
	boolean isExited(String id);
}
