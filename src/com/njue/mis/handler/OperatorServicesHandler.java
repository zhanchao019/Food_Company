/**
 * 操作员服务接口
 */
package com.njue.mis.handler;

import java.util.Vector;

import com.njue.mis.model.Operator;

public interface OperatorServicesHandler
{
	/**
	 * 查询用户名和密码是否正确
	 * @param username 用户名
	 * @param password 密码
	 * @return 查询结果
	 */
	boolean loginCheck(String username,String password);
	/**
	 * 向数据库中田间新的操作员
	 * @param operator 封装好的操作员
	 * @return 执行结果
	 */
	boolean addOperator(Operator operator);
	/**
	 * 删除操作员信息
	 * @param username 被删除的操作员名称 
	 * @return 执行结果
	 */
	boolean deleteOperator(String username);
	/**
	 * 修改密码
	 * @param username 被修改的用户名
	 * @param password 新密码
	 * @return 执行结果
	 */
	boolean modifyPassword(String username,String password);
	/**
	 * 获取用户权限
	 * @param username 用户名
	 * @return 查询结果
	 */
	String getPower(String username);
	/**
	 * 获取操作员的密码
	 * @param username 用户名
	 * @return 密码
	 */
	String getPassword(String username);
	/**
     * 判断操作员是否存在
     * @param id 查询的操作员昵称
     * @return 查询结果
     */
    boolean isExited(String username);
    /**
     * 获取特定职权的用户名
     * @param type 类型
     * @return 结果集合
     */
    Vector<Operator> getOperator(String type);
    /**
     * 获取用户的信息
     * @param userName 用户名
     * @return  用户信息
     */
    Operator getOperatorInfo(String userName);
}
