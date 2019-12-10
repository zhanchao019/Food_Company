/**
 * 销售退货服务接口
 */
package com.njue.mis.handler;

import java.util.Vector;

import com.njue.mis.model.SalesBack;

public interface SalesBackServicesHandler
{
	/**
	 * 向数据库中添加新的退货记录
	 * @param SalesBack 封装好的SalesBack对象
	 * @return 执行结果
	 */
	boolean addSalesBack(SalesBack salesBack);
	/**
	 * 获取所有的销售退回信息
	 * @return 销售退回信息集合
	 */
	Vector<SalesBack> getAllSalesBack();
	/**
	 * 查询数据库中满足条件的销售退货记录
	 * @param field 查询的字段
	 * @param value 满足的值
	 * @return 查询结果
	 */
	Vector<SalesBack> searchSalesBack(String field,String value);
	/**
	 * 查询数据库中满足条件的销售退货记录
	 * @param beginTime 查询的开始时间
	 * @param endTime  查询的结束时间
	 * @return 查询结果
	 */
	Vector<SalesBack> searchSalesBackByTime(String beginTime,String endTime);
	/**
	 * 判断退货编号是否存在
	 * @param id 
	 * @return
	 */
	boolean isExited(String id);
}
