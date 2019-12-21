/**
 * ��Ӧ�̷���ӿ�
 */
package com.njue.mis.handler;

import com.njue.mis.model.Provider;

import java.util.Vector;

public interface ProviderServicesHandler
{
	boolean addLog(String username, String time, String power, String dept, String detail);
	/**
	 * �����ݿ�������µĲ���Ա
	 * @param operator ��װ�õĲ���Ա
	 * @return ִ�н��
	 */
	boolean addProvider(Provider provider);
	/**
	 * �����ݿ���ɾ��ָ����Ӧ�̵���Ϣ
	 * @param id ��ɾ����Ӧ�̵ı��
	 * @return ִ�н��
	 */
	boolean deleteProvider(String id);
	/**
	 * ��ѯ���ݿ������������Ĺ�Ӧ��
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	Vector<Provider> searchProvider(String field,String value);
	/**
	 * ���¹�Ӧ����Ϣ
	 * @param customer ��װ�õĹ�Ӧ������Ϣ
	 */
	boolean modifyProvider(Provider provider);
	/**
	 * ��ȡ���й�Ӧ����Ϣ
	 * @return ��Ӧ�̼���
	 */
	Vector<Provider> getAllProvider();
	/**
     * �жϹ�Ӧ���Ƿ����
     * @param id ��ѯ���û��㻹
     * @return ��ѯ���
     */
   boolean isExited(String id);
   /**
    * ��ȡ�ض���Ӧ�̵���Ϣ
    * @param id ��Ӧ�̱��
    * @return ��ѯ���
    */
   Provider getProviderInfo(String id);
	
}
