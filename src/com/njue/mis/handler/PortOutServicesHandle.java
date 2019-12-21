/**
 * 退货服务接口
 */
package com.njue.mis.handler;

import com.njue.mis.model.PortOut;

import java.util.Vector;

public interface PortOutServicesHandle
{

	boolean addLog(String username, String time, String power, String dept, String detail);
	/**
	 * 添加新的退货记录
	 * @param portOut 封装好的portOut对象
	 * @return 执行结果
	 */
	boolean addPortOut(PortOut portOut);
	/**
	 * 获取所有的退货信息
	 * @return 退货信息集合
	 */
	Vector<PortOut> getAllPortOut();
	/**
	 * 查询数据库中满足条件的退货记录
	 * @param field 查询的字段
	 * @param value 满足的值
	 * @return 查询结果
	 */
	Vector<PortOut> searchPortOut(String field,String value);
	/**
	 * 查询数据库中满足条件的退货记录
	 * @param beginTime 查询的开始时间
	 * @param endTime  查询的结束时间
	 * @return 查询结果
	 */
	Vector<PortOut> searchPortInByTime(String beginTime,String endTime);
	/**
	 * 判断退货编号是否存在
	 * @param id 
	 * @return
	 */
	boolean isExited(String id);
}
