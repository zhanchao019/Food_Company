package com.njue.mis.handler;

import com.njue.mis.model.Producing;
import com.njue.mis.model.ProducingLine;

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

}
