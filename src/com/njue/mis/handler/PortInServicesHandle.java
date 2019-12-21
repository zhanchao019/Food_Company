/**
 * 进货服务接口
 */
package com.njue.mis.handler;

import com.njue.mis.model.PortIn;

import java.util.Vector;

public interface PortInServicesHandle
{
	/**
	 * 添加新的进货记录
	 * @param portIn 封装好的PortIn对象
	 * @return 执行结果
	 */
	boolean addPortIn(PortIn portIn);

	/**
	 * 操作记录
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @param dept     部门
	 * @return 查询结果
	 */
	boolean addLog(String username, String time, String power, String dept, String detail);
	
	/**
	 * 获取所有的进货信息
	 * @return 进货信息集合
	 */
	Vector<PortIn> getAllPortIn();
	/**
	 * 查询数据库中满足条件的进货记录
	 * @param field 查询的字段
	 * @param value 满足的值
	 * @return 查询结果
	 */
	Vector<PortIn> searchPortIn(String field,String value);
	/**
	 * 查询数据库中满足条件的进货记录
	 * @param beginTime 查询的开始时间
	 * @param endTime  查询的结束时间
	 * @return 查询结果集
	 */
	Vector<PortIn> searchPortInByTime(String beginTime,String endTime);
	/**
	 * 判断进货编号是否存在
	 * @param id 
	 * @return
	 */
	boolean isExited(String id);
}
