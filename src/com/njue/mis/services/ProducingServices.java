package com.njue.mis.services;

import com.njue.mis.dao.ProducingDAO;
import com.njue.mis.handler.ProducingServicesHandeler;
import com.njue.mis.model.Producing;

import java.util.Vector;

public class ProducingServices implements ProducingServicesHandeler {
    ProducingDAO producingDAO = null;

    public ProducingServices() {
        super();
    }

    /**
     * ��ȡ���е�������Ϣ
     *
     * @return ������Ϣ����
     */
    public Vector<Producing> getAllSchedule() {
        producingDAO = new ProducingDAO();
        return producingDAO.getAllSchedule();
    }

}
