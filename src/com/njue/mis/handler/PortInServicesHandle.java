/**
 * ��������ӿ�
 */
package com.njue.mis.handler;

import com.njue.mis.model.PortIn;

import java.util.Vector;

public interface PortInServicesHandle
{
	/**
	 * ����µĽ�����¼
	 * @param portIn ��װ�õ�PortIn����
	 * @return ִ�н��
	 */
	boolean addPortIn(PortIn portIn);

	/**
	 * ������¼
	 *
	 * @param username �û���
	 * @param password ����
	 * @param dept     ����
	 * @return ��ѯ���
	 */
	boolean addLog(String username, String time, String power, String dept, String detail);
	
	/**
	 * ��ȡ���еĽ�����Ϣ
	 * @return ������Ϣ����
	 */
	Vector<PortIn> getAllPortIn();
	/**
	 * ��ѯ���ݿ������������Ľ�����¼
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	Vector<PortIn> searchPortIn(String field,String value);
	/**
	 * ��ѯ���ݿ������������Ľ�����¼
	 * @param beginTime ��ѯ�Ŀ�ʼʱ��
	 * @param endTime  ��ѯ�Ľ���ʱ��
	 * @return ��ѯ�����
	 */
	Vector<PortIn> searchPortInByTime(String beginTime,String endTime);
	/**
	 * �жϽ�������Ƿ����
	 * @param id 
	 * @return
	 */
	boolean isExited(String id);
}
