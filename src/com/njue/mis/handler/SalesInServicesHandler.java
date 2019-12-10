/**
 * ���۷���ӿ�
 */
package com.njue.mis.handler;

import java.util.Vector;

import com.njue.mis.model.SalesIn;

public interface SalesInServicesHandler
{
	/**
	 * �����ݿ�������µ����ۼ�¼
	 * @param salesIn ��װ�õ�SalesIn����
	 * @return ִ�н��
	 */
	boolean addSalesIn(SalesIn salesIn);
	/**
	 * ��ȡ���е�������Ϣ
	 * @return ������Ϣ����
	 */
	Vector<SalesIn> getAllSalesIn();
	
	/**
	 * ��ѯ���ݿ����������������ۼ�¼
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	Vector<SalesIn> searchSalesIn(String field,String value);
	/**
	 * ��ѯ���ݿ����������������ۼ�¼
	 * @param beginTime ��ѯ�Ŀ�ʼʱ��
	 * @param endTime  ��ѯ�Ľ���ʱ��
	 * @return ��ѯ�����
	 */
	Vector<SalesIn> searchPortInByTime(String beginTime,String endTime);
	/**
	 * �ж����۱���Ƿ����
	 * @param id 
	 * @return
	 */
	boolean isExited(String id);
}
