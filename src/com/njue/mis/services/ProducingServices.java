package com.njue.mis.services;

import com.njue.mis.dao.ProducingDAO;
import com.njue.mis.dao.ProducingLineDAO;
import com.njue.mis.handler.ProducingServicesHandeler;
import com.njue.mis.model.Producing;
import com.njue.mis.model.ProducingLine;

import java.util.Vector;

public class ProducingServices implements ProducingServicesHandeler {
    ProducingDAO producingDAO = null;
    ProducingLineDAO producingLIneDAO = null;
    public ProducingServices() {
        super();
    }

    /**
     * 获取所有的销售信息
     *
     * @return 销售信息集合
     */
    public Vector<Producing> getAllSchedule() {
        producingDAO = new ProducingDAO();
        return producingDAO.getAllSchedule();
    }

    /**
     * 获取所有的流水线新信息
     *
     * @return 销售信息集合
     */
    public Vector<ProducingLine> getAllProducingLine() {
        producingLIneDAO = new ProducingLineDAO();
        return producingLIneDAO.getAllProducingLine();
    }

}
