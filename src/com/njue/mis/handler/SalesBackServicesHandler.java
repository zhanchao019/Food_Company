/**
 * �����˻�����ӿ�
 */
package com.njue.mis.handler;

import com.njue.mis.model.SalesBack;

import java.util.Vector;

public interface SalesBackServicesHandler
{
	boolean addLog(String username, String time, String power, String dept, String detail);
	/**
	 * �����ݿ�������µ��˻���¼
	 * @param SalesBack ��װ�õ�SalesBack����
	 * @return ִ�н��
	 */
	boolean addSalesBack(SalesBack salesBack);
	/**
	 * ��ȡ���е������˻���Ϣ
	 * @return �����˻���Ϣ����
	 */
	Vector<SalesBack> getAllSalesBack();
	/**
	 * ��ѯ���ݿ������������������˻���¼
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	Vector<SalesBack> searchSalesBack(String field,String value);
	/**
	 * ��ѯ���ݿ������������������˻���¼
	 * @param beginTime ��ѯ�Ŀ�ʼʱ��
	 * @param endTime  ��ѯ�Ľ���ʱ��
	 * @return ��ѯ���
	 */
	Vector<SalesBack> searchSalesBackByTime(String beginTime,String endTime);
	/**
	 * �ж��˻�����Ƿ����
	 * @param id 
	 * @return
	 */
	boolean isExited(String id);
}
