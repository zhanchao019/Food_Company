package com.njue.mis.services;

import com.njue.mis.dao.ProducingDAO;
import com.njue.mis.dao.ProducingLineDAO;
import com.njue.mis.dao.ProducingLineDetailDAO;
import com.njue.mis.handler.ProducingServicesHandeler;
import com.njue.mis.model.Producing;
import com.njue.mis.model.ProducingLine;
import com.njue.mis.model.ProducingLineDetail;

import java.util.Vector;

public class ProducingServices implements ProducingServicesHandeler {
    ProducingDAO producingDAO = null;
    ProducingLineDAO producingLIneDAO = null;
    ProducingLineDetailDAO producingLineDetailDAO = null;
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

    /**
     * ��ȡ���е���ˮ������Ϣ
     *
     * @return ������Ϣ����
     */
    public Vector<ProducingLine> getAllProducingLine() {
        producingLIneDAO = new ProducingLineDAO();
        return producingLIneDAO.getAllProducingLine();
    }

    /**
     * ��ȡ�����ˮ������Ϣ
     *
     * @return ������Ϣ����
     */
    public boolean addProducingDetail(String scheduleid, String goodsid, String pici, String producinglineid, int number) {
        producingLIneDAO = new ProducingLineDAO();
        return producingLIneDAO.addProducingDetail(scheduleid, goodsid, pici, producinglineid, number);
    }

    /**
     * ��ѯ���ݿ���������������ˮ�߼�¼
     *
     * @param field ��ѯ���ֶ�
     * @param value �����ֵ
     * @return ��ѯ���
     */
    public Vector<ProducingLineDetail> searchProducingLineDetail(String field, String value) {
        producingLineDetailDAO = new ProducingLineDetailDAO();
        return producingLineDetailDAO.searchProducingLineDetail(field, value);
    }

    /**
     * ��ȡ���е���ˮ�߼�¼��Ϣ
     *
     * @return ������Ϣ����
     */
    public Vector<ProducingLineDetail> getAllProducingLineDetail() {
        producingLineDetailDAO = new ProducingLineDetailDAO();
        return producingLineDetailDAO.getAllProducingLineDetail();

    }

    /**
     * �����ˮ������
     *
     * @param pici ���κ�
     * @return ִ�н��
     */
    public boolean finish(String pici, String producinglineid) {
        producingLineDetailDAO = new ProducingLineDetailDAO();
        return producingLineDetailDAO.finish(pici, producinglineid);
    }
}
