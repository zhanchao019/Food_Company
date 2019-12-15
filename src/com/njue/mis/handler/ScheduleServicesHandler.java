package com.njue.mis.handler;

import com.njue.mis.model.Schedule;

import java.util.Vector;

public interface ScheduleServicesHandler {
    /**
     * 确认执行生产计划
     *
     * @param scheduleid 封装好的Schedule对象
     * @return 执行结果
     */
    boolean opt(String scheduleid);

    /**
     * 向数据库中添加新的生产计划
     *
     * @param schedule 封装好的Schedule对象
     * @return 执行结果
     */
    boolean addSchedule(Schedule schedule);

    /**
     * 获取所有的生产计划
     *
     * @return 生产计划集合
     */
    Vector<Schedule> getAllSchedule();

    /**
     * 查询数据库中满足条件的生产计划
     *
     * @param field 查询的字段
     * @param value 满足的值
     * @return 查询结果
     */
    Vector<Schedule> searchSchedule(String field, String value);

    /**
     * 查询数据库中满足条件的生产计划
     *
     * @param scheduleid 生产计划编号
     * @return 查询结果集
     */
    boolean delSchedule(String scheduleid);

    /**
     * 判断生产计划编号是否存在
     *
     * @param id
     * @return
     */
    boolean isExited(String id);
}
