package com.njue.mis.handler;

import com.njue.mis.model.Producing;
import com.njue.mis.model.ProducingLine;
import com.njue.mis.model.ProducingLineDetail;

import java.util.Vector;

public interface ProducingServicesHandeler {
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
     * �����ˮ������
     *
     * @param pici ���κ�
     * @return ִ�н��
     */
    boolean finish(String pici);


}
