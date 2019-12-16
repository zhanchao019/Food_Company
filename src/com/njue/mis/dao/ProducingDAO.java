package com.njue.mis.dao;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.Producing;

import java.sql.ResultSet;
import java.util.Vector;

public class ProducingDAO extends ManagerDAO {

    /**
     * 获取所有的销售信息
     *
     * @return 销售信息集合
     */
    public Vector<Producing> getAllSchedule() {
        Vector<Producing> result = new Vector<Producing>();
        try {
            String sql = "{call pr_getAllScheduleproducing()}";
            ResultSet rs = manager.executeQuery(sql, null, Constants.CALL_TYPE);
            while (rs.next()) {
                Producing producing = new Producing(rs.getString("goodsid"), rs.getString("scheduleid"), rs.getInt("sum"), rs.getInt("finished"), rs.getInt("unfinished"));
                result.add(producing);
            }
            manager.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("ProducingDAO.getAllSchedule", e);
        }
        return result;
    }

}
