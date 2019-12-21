/**
 *�û������ӿڣ�������û����еĲ��� 
 */

package com.njue.mis.handler;

import com.njue.mis.model.Customer;

import java.util.Vector;

public interface CustomerServicesHandler
{
	/**
	 * �����ݿ�������¿ͻ�
	 * @param customer ��װ�õĿͻ�
	 * @return ִ�н��
	 */
    /**
     * ������¼
     *
     * @param username �û���
     * @param password ����
     * @param dept     ����
     * @return ��ѯ���
     */
    boolean addLog(String username, String time, String power, String dept, String detail);
	boolean addCustomer(Customer customer);
	
	/**
	 * �����ݿ���ɾ��ָ���ͻ�����Ϣ
	 * @param id ��ɾ���ͻ��ı��
	 * @return ִ�н��
	 */
	boolean deleteCustomer(String id);
	/**
	 * ��ѯ���ݿ������������Ŀͻ�
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	Vector<Customer> searchCustomer(String field,String value);
	
	/**
	 * ���¿ͻ���Ϣ
	 * @param customer ��װ�õĿͻ�����Ϣ
	 */
	boolean modifyCustomer(Customer customer);
	/**
	 * ��ȡ���пͻ���Ϣ
	 * @return �ͻ�����
	 */
	Vector<Customer> getAllCustomer();
	/**
     * �ж��û��Ƿ����
     * @param id ��ѯ���û��㻹
     * @return ��ѯ���
     */
    boolean isExited(String id);
    /**
     * ��ȡ�ض��ͻ�����Ϣ
     * @param id �ͻ����
     * @return ��ѯ���
     */
    Customer getCustomerInfo(String id);
	
}
