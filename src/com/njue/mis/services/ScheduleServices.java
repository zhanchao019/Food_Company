package com.njue.mis.services;

import com.njue.mis.dao.LogDAO;
import com.njue.mis.dao.ScheduleDAO;
import com.njue.mis.handler.ScheduleServicesHandler;
import com.njue.mis.model.Schedule;

import java.util.Vector;

public class ScheduleServices implements ScheduleServicesHandler {
    ScheduleDAO scheduleDAO = null;

    public ScheduleServices() {
        super();
    }

    public boolean opt(String orderid) {
        scheduleDAO = new ScheduleDAO();
        return scheduleDAO.opt(orderid);
    }

    public boolean opt(String goodsid, String orderid, int num) {
        scheduleDAO = new ScheduleDAO();
        return scheduleDAO.opt(goodsid, orderid, num);
    }

    public boolean addSchedule(Schedule schedule) {
        scheduleDAO = new ScheduleDAO();
        boolean result = true;
        result = scheduleDAO.addSchedule(schedule);
        //ÐÞ¸Ä¿â´æÁ¿
        //GoodsServices goodsServices=new GoodsServices();
        //goodsServices.changeGoodsNumber(salesIn.getGoodsId(), -salesIn.getNumber());
        return result;
    }

    public boolean addLog(String username, String time, String power, String dept, String detail) {
        LogDAO logDAO = new LogDAO();
        return logDAO.addLog(username, time, power, dept, detail);

    }
    public Vector<Schedule> getAllSchedule() {
        scheduleDAO = new ScheduleDAO();
        return scheduleDAO.getAllSchedule();
    }

    public Vector<Schedule> searchSchedule(String field, String value) {
        scheduleDAO = new ScheduleDAO();
        return scheduleDAO.searchSchedule(field, value);
    }

    public boolean delSchedule(String scheduleid) {
        scheduleDAO = new ScheduleDAO();
        return scheduleDAO.delSchedule(scheduleid);
    }

    public boolean isExited(String id) {
        scheduleDAO = new ScheduleDAO();
        return scheduleDAO.isExited(id);
    }
}
