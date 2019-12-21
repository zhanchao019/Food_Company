package com.njue.mis.handler;

import com.njue.mis.model.Producing;
import com.njue.mis.model.ProducingLine;
import com.njue.mis.model.ProducingLineDetail;

import java.util.Vector;

public interface ProducingServicesHandeler {

    boolean addLog(String username, String time, String power, String dept, String detail);
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

    /**
     * 查询数据库中满足条件的流水线记录
     *
     * @param field 查询的字段
     * @param value 满足的值
     * @return 查询结果
     */
    Vector<ProducingLineDetail> searchProducingLineDetail(String field, String value);

    /**
     * 获取所有的流水线记录信息
     *
     * @return 销售信息集合
     */
    Vector<ProducingLineDetail> getAllProducingLineDetail();

    /**
     * 获取所有的流水线记录信息
     *
     * @return 销售信息集合
     */
    Vector<ProducingLineDetail> getAllFinishedProducingLineDetail();

    /**
     * 完成流水线任务
     *
     * @param pici 批次号
     * @return 执行结果
     */
    boolean finish(String pici, String producinglineid);

    /**
     * 输出
     *
     * @param pici 批次号
     * @return 执行结果
     */
    boolean getout(String goodsid, String pici, String date, int number, String state);

}
