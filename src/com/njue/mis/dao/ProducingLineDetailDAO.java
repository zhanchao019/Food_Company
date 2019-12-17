package com.njue.mis.dao;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.ProducingLineDetail;

import java.sql.ResultSet;
import java.util.Vector;

public class ProducingLineDetailDAO extends ManagerDAO {
    /**
     * ��ѯ���ݿ���������������ˮ�߼�¼
     *
     * @param field ��ѯ���ֶ�
     * @param value �����ֵ
     * @return ��ѯ���
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
     * ��ȡ���е���ˮ�߼�¼��Ϣ
     *
     * @return ������Ϣ����
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
     * �����ˮ������
     *
     * @param pici ���κ�
     * @return ִ�н��
     */
    public boolean finish(String pici) {
        try {

            boolean tmp;
            String sql = "{call pr_updateProducingLineDetail(?)}";
            Object[] params = new Object[]{
                    pici};
            manager.executeQuery(sql, params, Constants.CALL_TYPE);
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
