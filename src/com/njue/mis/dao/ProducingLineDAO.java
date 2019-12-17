package com.njue.mis.dao;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.ProducingLine;

import java.sql.ResultSet;
import java.util.Vector;

public class ProducingLineDAO extends ManagerDAO {
    /**
     * 获取所有的流水线新信息
     *
     * @return 销售信息集合
     */
    public Vector<ProducingLine> getAllProducingLine() {
        Vector<ProducingLine> result = new Vector<ProducingLine>();
        try {
            String sql = "{call pr_getAllProducingLine()}";
            ResultSet rs = manager.executeQuery(sql, null, Constants.CALL_TYPE);
            while (rs.next()) {
                ProducingLine producingLine = new ProducingLine(rs.getString("producinglineid"), rs.getInt("number"));
                result.add(producingLine);
            }
            manager.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("ProducingDAO.getAllProducingLine", e);
        }
        return result;
    }

    public boolean addProducingDetail(String scheduleid, String goodsid, String pici, String producinglineid, int number) {
        boolean result = false;
        try {
            String sql = "insert into tb_producingdetail(scheduleid,goodsid,pici,producinglineid,num,state) values(?,?,?,?,?,?)";
            Object[] params = new Object[]{scheduleid, goodsid, pici, producinglineid, number, "false"};
            result = super.add(sql, params);
        } catch (Exception e) {
            ErrorManager.printError("ProducingLineDAO.addProducingDetail", e);
        }
        return result;


    }
}
