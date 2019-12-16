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
     * �����ݿ���ִ��
     *
     * @param scheduleid ��װ�õ�Schedule����
     * @return ִ�н��
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
     * �����ݿ���ִ��
     *
     * @param goodsid
     * @param scheduleid ��װ�õ�Sch
     * @param number     ����
     * @return ִ�н��
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
     * �����ݿ�������µ����ۼ�¼
     *
     * @param schedule ��װ�õ�Schedule����
     * @return ִ�н��
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
     * ��ȡ���е������ƻ�
     *
     * @return �����ƻ�����
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
     * ��ѯ���ݿ������������������ƻ�
     *
     * @param field ��ѯ���ֶ�
     * @param value �����ֵ
     * @return ��ѯ���
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
     * ��ѯ���ݿ������������������ƻ�
     *
     * @param scheduleid �����ƻ����
     * @return ��ѯ�����
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
     * �ж����۱���Ƿ����
     *
     * @param id
     * @return
     */
    /**
     * �жϼ�¼�Ƿ����
     *
     * @param id ��¼���
     * @return ��ѯ���
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
