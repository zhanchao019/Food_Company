package com.njue.mis.handler;

import com.njue.mis.model.Producing;
import com.njue.mis.model.ProducingLine;
import com.njue.mis.model.ProducingLineDetail;

import java.util.Vector;

public interface ProducingServicesHandeler {

    boolean addLog(String username, String time, String power, String dept, String detail);
    /**
     * ��ȡ���е�������Ϣ
     *
     * @return ������Ϣ����
     */
    Vector<Producing> getAllSchedule();

    /**
     * ��ȡ���е���ˮ������Ϣ
     *
     * @return ������Ϣ����
     */
    Vector<ProducingLine> getAllProducingLine();

    /**
     * ��ȡ���е���ˮ������Ϣ
     *
     * @return ������Ϣ����
     */
    boolean addProducingDetail(String scheduleid, String goodsid, String pici, String producinglineid, int number);

    /**
     * ��ѯ���ݿ���������������ˮ�߼�¼
     *
     * @param field ��ѯ���ֶ�
     * @param value �����ֵ
     * @return ��ѯ���
     */
    Vector<ProducingLineDetail> searchProducingLineDetail(String field, String value);

    /**
     * ��ȡ���е���ˮ�߼�¼��Ϣ
     *
     * @return ������Ϣ����
     */
    Vector<ProducingLineDetail> getAllProducingLineDetail();

    /**
     * ��ȡ���е���ˮ�߼�¼��Ϣ
     *
     * @return ������Ϣ����
     */
    Vector<ProducingLineDetail> getAllFinishedProducingLineDetail();

    /**
     * �����ˮ������
     *
     * @param pici ���κ�
     * @return ִ�н��
     */
    boolean finish(String pici, String producinglineid);

    /**
     * ���
     *
     * @param pici ���κ�
     * @return ִ�н��
     */
    boolean getout(String goodsid, String pici, String date, int number, String state);

}
