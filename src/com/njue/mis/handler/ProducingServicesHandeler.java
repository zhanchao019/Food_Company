package com.njue.mis.handler;

import com.njue.mis.model.Producing;
import com.njue.mis.model.ProducingLine;

import java.util.Vector;

public interface ProducingServicesHandeler {
    /**
     * 获取所有的销售信息
     *
     * @return 销售信息集合
     */
    Vector<Producing> getAllSchedule();

    /**
     * 获取所有的流水线新信息
     *
     * @return 销售信息集合
     */
    Vector<ProducingLine> getAllProducingLine();

    /**
     * 获取所有的流水线新信息
     *
     * @return 销售信息集合
     */
    boolean addProducingDetail(String scheduleid, String goodsid, String pici, String producinglineid, int number);

}
