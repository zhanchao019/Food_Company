/**
 * ��Ʒ�����ӿ�
 */

package com.njue.mis.handler;

import com.njue.mis.model.Goods;
import com.njue.mis.model.StorageGoods;

import java.util.Vector;

public interface GoodsServicesHandler
{
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
	 * �����ݿ����������Ʒ
	 * @param goods  ��װ�õ�goods����
	 * @return  ִ�н��
	 */
	boolean addGoods(Goods goods);
	/**
	 * �����ݿ���ɾ����Ʒ
	 * @param id  ��ɾ����Ʒ�ı��
	 * @return  ִ�н��
	 */
	boolean deleteGoods(String id);
	/**
	 * ��ѯ���ݿ���������������Ʒ
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	Vector<Goods> searchGoods(String field,String value);
	/**
	 * �޸���Ʒ�ļ۸�
	 * @param id ���޸ĵ���Ʒ���
	 * @param price �µļ۸�
	 * @return ִ�н��
	 */
	boolean modifyGoodsPrice(String id,double price);
	/**
	 * ��ȡ���е���Ʒ
	 * @return ��Ʒ�ļ���
	 */
	Vector<Goods> getAllGoods();
	/**
     * �ж���Ʒ�Ƿ����
     * @param id ��ѯ����Ʒ���
     * @return ��ѯ���
     */
    boolean isExited(String id);
    /**
     * ��ȡ��Ʒ����Ϣ
     * @param id ����ѯ����Ʒ�ı��
     * @return ��ѯ���
     */
    Goods getGoodsInfo(String id);
    /**
	 * ��ѯ������Ʒ��Ϣ
	 * @return  ��ѯ�����
	 */
	Vector<StorageGoods> getAllStorageGoods();
}
