package com.njue.mis.dao;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.ProducingLineDetail;

import java.sql.ResultSet;
import java.util.Vector;

public class ProducingLineDetailDAO extends ManagerDAO {
    /**
     * 查询数据库中满足条件的流水线记录
     *
     * @param field 查询的字段
     * @param value 满足的值
     * @return 查询结果
     */
    public Vector<ProducingLineDetail> searchProducingLineDetail(String field, String value) {
        Vector<ProducingLineDetail> result = new Vector<ProducingLineDetail>();
        try {
            String sql = "{call pr_searchProducingLineDetail(?,?)}";
            Object[] params = new Object[]{field, value};
            ResultSet rs = manager.executeQuery(sql, params, Constants.CALL_TYPE);
            while (rs.next()) {
                ProducingLineDetail producingLineDetail = new ProducingLineDetail(rs.getString("scheduleid"), rs.getString("goodsid"), rs.getString("pici"),
                        rs.getString("producinglineid"), rs.getString("state"), rs.getInt("num"));
                result.add(producingLineDetail);
            }
            manager.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("ProducingLineDetailDAO.getAllProducingLineDetail", e);
        }
        return result;
    }

    /**
     * 获取所有的流水线记录信息
     *
     * @return 销售信息集合
     */
    public Vector<ProducingLineDetail> getAllProducingLineDetail() {
        Vector<ProducingLineDetail> result = new Vector<ProducingLineDetail>();
        try {
            String sql = "{call pr_getAllProducingLineDetail()}";
            ResultSet rs = manager.executeQuery(sql, null, Constants.CALL_TYPE);
            while (rs.next()) {
                ProducingLineDetail producingLineDetail = new ProducingLineDetail(rs.getString("scheduleid"), rs.getString("goodsid"), rs.getString("pici"),
                        rs.getString("producinglineid"), rs.getString("state"), rs.getInt("num"));
                result.add(producingLineDetail);
            }
            manager.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("ProducingLineDetailDAO.getAllProducingLineDetail", e);
        }
        return result;
    }

    /**
     * 获取所有的完成的流水线记录信息
     *
     * @return 销售信息集合
     */
    public Vector<ProducingLineDetail> getAllFinishedProducingLineDetail() {
        Vector<ProducingLineDetail> result = new Vector<ProducingLineDetail>();
        try {
            String sql = "{call pr_getAllProducingLineDetail()}";
            ResultSet rs = manager.executeQuery(sql, null, Constants.CALL_TYPE);
            while (rs.next()) {
                ProducingLineDetail producingLineDetail = new ProducingLineDetail(rs.getString("scheduleid"), rs.getString("goodsid"), rs.getString("pici"),
                        rs.getString("producinglineid"), rs.getString("state"), rs.getInt("num"), rs.getString("producedate"));
                result.add(producingLineDetail);
            }
            manager.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("ProducingLineDetailDAO.getAllProducingLineDetail", e);
        }
        return result;
    }


    /**
     * 完成流水线任务
     *
     * @param pici 批次号
     * @return 执行结果
     */
    public boolean finish(String pici, String producinglineid) {
        try {

            System.out.println(pici + " " + producinglineid);

            boolean tmp;
            String sql = "{call pr_updateProducingLineDetail(?)}";
            Object[] params = new Object[]{
                    pici};
            manager.executeQuery(sql, params, Constants.CALL_TYPE);


            String tm = "{call pr_decreaseProducingCount(?)}";
            Object[] tt = new Object[]{producinglineid};
            manager.executeQuery(tm, tt, Constants.CALL_TYPE);

            sql = "{call pr_updateProducingScheduleCount(?)}";
            tt = new Object[]{pici};

            manager.executeQuery(sql, tt, Constants.CALL_TYPE);

            sql = "update (tb_producingdetail)" +
                    "set state = 'true'" +
                    "where pici= ?";
            return super.add(sql, params);



        } catch (Exception e) {
            ErrorManager.printError("ProducingLineDetailDAO.finish", e);
            return false;
        }

    }
}
