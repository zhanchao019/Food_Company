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

    /**
     * 获取添加流水线新信息
     *
     * @return 销售信息集合
     */
    public boolean addProducingDetail(String scheduleid, String goodsid, String pici, String producinglineid, int number) {
        producingLIneDAO = new ProducingLineDAO();
        return producingLIneDAO.addProducingDetail(scheduleid, goodsid, pici, producinglineid, number);
    }

    /**
     * 查询数据库中满足条件的流水线记录
     *
     * @param field 查询的字段
     * @param value 满足的值
     * @return 查询结果
     */
    public Vector<ProducingLineDetail> searchProducingLineDetail(String field, String value) {
        producingLineDetailDAO = new ProducingLineDetailDAO();
        return producingLineDetailDAO.searchProducingLineDetail(field, value);
    }

    /**
     * 获取所有的流水线记录信息
     *
     * @return 销售信息集合
     */
    public Vector<ProducingLineDetail> getAllProducingLineDetail() {
        producingLineDetailDAO = new ProducingLineDetailDAO();
        return producingLineDetailDAO.getAllProducingLineDetail();

    }

    /**
     * 完成流水线任务
     *
     * @param pici 批次号
     * @return 执行结果
     */
    public boolean finish(String pici, String producinglineid) {
        producingLineDetailDAO = new ProducingLineDetailDAO();
        return producingLineDetailDAO.finish(pici, producinglineid);
    }
}
