package com.njue.mis.handler;

import com.njue.mis.model.Producing;

import java.util.Vector;

public interface ProducingServicesHandeler {
    /**
     * ��ȡ���е�������Ϣ
     *
     * @return ������Ϣ����
     */
    Vector<Producing> getAllSchedule();
}
