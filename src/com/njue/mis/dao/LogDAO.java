package com.njue.mis.dao;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.Log;

import java.sql.ResultSet;
import java.util.Vector;

public class LogDAO {
    SqlManager manage = null;

    public LogDAO() {
        super();
        manage = SqlManager.createInstance();
        manage.connectDB();
    }

    /**
     * 获取所有的商品
     *
     * @return 商品的集合
     */
    public Vector<Log> getAllLog() {
        Vector<Log> result = new Vector<Log>();
        try {
            String sql = "{call pr_getAllLog()}";
            ResultSet rs = manage.executeQuery(sql, null, Constants.CALL_TYPE);
            while (rs.next()) {
                Log log = new Log(rs.getString("username"), rs.getString("time"), rs.getString("power"),
                        rs.getString("dept"), rs.getString("detail"));
                result.add(log);
            }

            manage.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("LogDAO.getAllLog", e);
        }
        return result;
    }


    public boolean addLog(String username, String time, String power, String dept, String detail) {
        boolean result = false;
        try {
            Object[] params = new Object[]{username, time, power, dept, detail};
            String sql = "insert into tb_log(username,time,power,dept,detail) values(?,?,?,?,?)";
            result = manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
            System.out.println("添加完成？");
            manage.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("LogDAO.addlog", e);
        }
        return result;
    }
}
