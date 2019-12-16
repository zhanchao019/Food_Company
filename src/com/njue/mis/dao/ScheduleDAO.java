package com.njue.mis.dao;

import com.njue.mis.Connect.ConnectionBuilder;
import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.Schedule;

import java.sql.ResultSet;
import java.util.Vector;

public class ScheduleDAO extends ManagerDAO {
    public ScheduleDAO() {
        super();
    }

    /**
     * 向数据库中执行
     *
     * @param scheduleid 封装好的Schedule对象
     * @return 执行结果
     */
    public boolean opt(String scheduleid) {
        try {
            String sql = "update (tb_schedule)" +
                    "set state = 'true'" +
                    "where scheduleid=?";
            Object[] params = new Object[]{
                    scheduleid};
            return super.add(sql, params);


        } catch (Exception e) {
            ErrorManager.printError("ScheduleDAO.opt", e);
            return false;
        }

    }

    /**
     * 向数据库中执行
     *
     * @param goodsid
     * @param scheduleid 封装好的Sch
     * @param number     总数
     * @return 执行结果
     */
    public boolean opt(String goodsid, String scheduleid, int number) {
        try {
            String sql = "insert into tb_producing(goodsid,scheduleid,sum,finished,unfinished)" +
                    "values(?,?,?,?,?) ";
            Object[] params = new Object[]{goodsid,
                    scheduleid, number, 0, number};
            return super.add(sql, params);


        } catch (Exception e) {
            ErrorManager.printError("ScheduleDAO.opt", e);
            return false;
        }

    }
    /**
     * 向数据库中添加新的销售记录
     *
     * @param schedule 封装好的Schedule对象
     * @return 执行结果
     */
    public boolean addSchedule(Schedule schedule) {
        boolean result = false;
        try {
            String sql = "insert into tb_schedule(scheduleid,goodsid,sum,comment,state) values(?,?,?,?,?)";
            Object[] params = new Object[]{schedule.getScheduleid(), schedule.getGoodsid(), schedule.getSum(), schedule.getComment(), schedule.getState()};
            result = super.add(sql, params);
        } catch (Exception e) {
            ErrorManager.printError("ScheduleDAO.addSchedule", e);
        }
        return result;
    }

    /**
     * 获取所有的生产计划
     *
     * @return 生产计划集合
     */
    public Vector<Schedule> getAllSchedule() {
        Vector<Schedule> result = new Vector<Schedule>();
        try {
            String sql = "{call pr_getAllSchedule()}";
            ResultSet rs = manager.executeQuery(sql, null, Constants.CALL_TYPE);
            while (rs.next()) {
                Schedule schedule = new Schedule(rs.getString("scheduleid"), rs.getString("goodsid"), rs.getInt("sum"),
                        rs.getString("comment"), rs.getString("state"));
                result.add(schedule);
            }
            manager.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("scheduleDAO.getALLSchedule", e);
        }
        return result;
    }

    /**
     * 查询数据库中满足条件的生产计划
     *
     * @param field 查询的字段
     * @param value 满足的值
     * @return 查询结果
     */
    public Vector<Schedule> searchSchedule(String field, String value) {
        Vector<Schedule> result = new Vector<Schedule>();
        try {
            String sql = "{call pr_searchSchedule(?,?)}";
            Object[] params = new Object[]{field, value};
            ResultSet rs = manager.executeQuery(sql, params, Constants.CALL_TYPE);
            while (rs.next()) {
                Schedule schedule = new Schedule(rs.getString("scheduleid"), rs.getString("goodsid"), rs.getInt("sum"),
                        rs.getString("comment"), rs.getString("state"));
                result.add(schedule);
            }
            manager.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("scheduleDAO.searchSchedule", e);
        }
        return result;
    }

    /**
     * 查询数据库中满足条件的生产计划
     *
     * @param scheduleid 生产计划编号
     * @return 查询结果集
     */
    public boolean delSchedule(String scheduleid) {
        boolean result = false;
        try {
            String sql = "delete from tb_schedule where scheduleid ='" + scheduleid + "'";
            ConnectionBuilder cb = new ConnectionBuilder(sql, 0);
            cb.pst.execute();


        } catch (Exception e) {
            ErrorManager.printError("ScheduleDAO.delSchedule", e);
            return false;
        }
        return result;
    }


    /**
     * 判断销售编号是否存在
     *
     * @param id
     * @return
     */
    /**
     * 判断记录是否存在
     *
     * @param id 记录编号
     * @return 查询结果
     */
    public boolean isExited(String id) {
        boolean result = false;
        try {
            String sql = "select * from tb_schedule where scheduleid=?";
            Object[] params = new Object[]{id};
            ResultSet rs = manager.executeQuery(sql, params, Constants.PSTM_TYPE);
            if (rs.next())
                result = true;
            manager.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("ScheduleDAO.isExited", e);
        }
        return result;
    }
}
