/**
 *用户操作接口，定义对用户进行的操作 
 */

package com.njue.mis.handler;

import java.util.Vector;

import com.njue.mis.model.Customer;

public interface CustomerServicesHandler
{
	/**
	 * 向数据库中添加新客户
	 * @param customer 封装好的客户
	 * @return 执行结果
	 */
	boolean addCustomer(Customer customer);
	
	/**
	 * 从数据库中删除指定客户的信息
	 * @param id 被删除客户的编号
	 * @return 执行结果
	 */
	boolean deleteCustomer(String id);
	/**
	 * 查询数据库中满足条件的客户
	 * @param field 查询的字段
	 * @param value 满足的值
	 * @return 查询结果
	 */
	Vector<Customer> searchCustomer(String field,String value);
	
	/**
	 * 更新客户信息
	 * @param customer 封装好的客户新信息
	 */
	boolean modifyCustomer(Customer customer);
	/**
	 * 获取所有客户信息
	 * @return 客户集合
	 */
	Vector<Customer> getAllCustomer();
	/**
     * 判断用户是否存在
     * @param id 查询的用户便还
     * @return 查询结果
     */
    boolean isExited(String id);
    /**
     * 获取特定客户的信息
     * @param id 客户编号
     * @return 查询结果
     */
    Customer getCustomerInfo(String id);
	
}
