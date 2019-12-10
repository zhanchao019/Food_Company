/**
 * �˻�����ӿ�
 */
package com.njue.mis.handler;

import java.util.Vector;

import com.njue.mis.model.PortOut;

public interface PortOutServicesHandle
{
	
	/**
	 * ����µ��˻���¼
	 * @param portOut ��װ�õ�portOut����
	 * @return ִ�н��
	 */
	boolean addPortOut(PortOut portOut);
	/**
	 * ��ȡ���е��˻���Ϣ
	 * @return �˻���Ϣ����
	 */
	Vector<PortOut> getAllPortOut();
	/**
	 * ��ѯ���ݿ��������������˻���¼
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	Vector<PortOut> searchPortOut(String field,String value);
	/**
	 * ��ѯ���ݿ��������������˻���¼
	 * @param beginTime ��ѯ�Ŀ�ʼʱ��
	 * @param endTime  ��ѯ�Ľ���ʱ��
	 * @return ��ѯ���
	 */
	Vector<PortOut> searchPortInByTime(String beginTime,String endTime);
	/**
	 * �ж��˻�����Ƿ����
	 * @param id 
	 * @return
	 */
	boolean isExited(String id);
}
