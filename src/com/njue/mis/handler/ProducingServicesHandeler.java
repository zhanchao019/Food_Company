package com.njue.mis.handler;

import com.njue.mis.model.Producing;

import java.util.Vector;

public interface ProducingServicesHandeler {
    /**
     * 获取所有的销售信息
     *
     * @return 销售信息集合
     */
    Vector<Producing> getAllSchedule();
}
