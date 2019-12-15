package com.njue.mis.handler;

import com.njue.mis.model.Schedule;

import java.util.Vector;

public interface ScheduleServicesHandler {
    /**
     * ȷ��ִ�������ƻ�
     *
     * @param scheduleid ��װ�õ�Schedule����
     * @return ִ�н��
     */
    boolean opt(String scheduleid);

    /**
     * �����ݿ�������µ������ƻ�
     *
     * @param schedule ��װ�õ�Schedule����
     * @return ִ�н��
     */
    boolean addSchedule(Schedule schedule);

    /**
     * ��ȡ���е������ƻ�
     *
     * @return �����ƻ�����
     */
    Vector<Schedule> getAllSchedule();

    /**
     * ��ѯ���ݿ������������������ƻ�
     *
     * @param field ��ѯ���ֶ�
     * @param value �����ֵ
     * @return ��ѯ���
     */
    Vector<Schedule> searchSchedule(String field, String value);

    /**
     * ��ѯ���ݿ������������������ƻ�
     *
     * @param scheduleid �����ƻ����
     * @return ��ѯ�����
     */
    boolean delSchedule(String scheduleid);

    /**
     * �ж������ƻ�����Ƿ����
     *
     * @param id
     * @return
     */
    boolean isExited(String id);
}
