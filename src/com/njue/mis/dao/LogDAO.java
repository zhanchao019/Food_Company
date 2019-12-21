package com.njue.mis.dao;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;

public class LogDAO {
    SqlManager manage = null;

    public LogDAO() {
        super();
        manage = SqlManager.createInstance();
        manage.connectDB();
    }


    public boolean addLog(String username, String time, String power, String dept, String detail) {
        boolean result = false;
        try {
            Object[] params = new Object[]{username, time, power, dept, detail};
            String sql = "insert into tb_log(username,time,power,dept,detail) values(?,?,?,?,?)";
            result = manage.executeUpdate(sql, params, Constants.PSTM_TYPE);
            System.out.println("ÃÌº”ÕÍ≥…£ø");
            manage.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("LogDAO.addlog", e);
        }
        return result;
    }
}
