/**
 * ���۽�����DAO
 */
package com.njue.mis.dao;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.SalesIn;

import java.sql.ResultSet;
import java.util.Vector;

public class SalesInDAO extends ManagerDAO {

    public SalesInDAO() {
        super();
    }

    /**
     * �����ݿ�������µ����ۼ�¼
     *
     * @param orderid ��װ�õ�SalesIn����
     * @return ִ�н��
     */
    public boolean pay(String orderid) {
        try {
            String sql = "update (tb_sales)" +
                    "set paid = 'true'" +
                    "where id= ?";
            Object[] params = new Object[]{
                    orderid};
            return super.add(sql, params);


        } catch (Exception e) {
            ErrorManager.printError("SalesInDAO.pay", e);
            return false;
        }

    }


    /**
     * ����
     *
     * @param orderid ��װ�õ�SalesIn����
     * @return ִ�н��
     */

    public boolean opt(String orderid) {
        try {
            boolean tmp = true;
            String sql = "update (tb_sales)" +
                    "set paid = 'out'" +
                    "where id= ?";
            Object[] params = new Object[]{
                    orderid};
            tmp = super.add(sql, params);


            sql = "update (tb_storage)" +
                    "set state = 'out'" +
                    "where orderid= ?";
            params = new Object[]{
                    orderid};
            tmp = super.add(sql, params) && tmp;
            return tmp;

        } catch (Exception e) {
            ErrorManager.printError("SalesInDAO.opt", e);
            return false;
        }

    }

    /**
     * �����ݿ�������µ����ۼ�¼
     *
     * @param salesIn ��װ�õ�SalesIn����
     * @return ִ�н��
     */
    public boolean addSalesIn(SalesIn salesIn) {
        boolean result = false;
        try {
            String sql = "insert into tb_sales(id,customerid,paytype,salestime,operateperson,number,price,comment,goodsid,state) values(?,?,?,?,?,?,?,?,?,?)";
            Object[] params = new Object[]{salesIn.getId(), salesIn.getCustomerId(), salesIn.getPayType(),
                    salesIn.getTime(), salesIn.getOperatePerson(), salesIn.getNumber(),
                    salesIn.getPrice(), salesIn.getComment(), salesIn.getGoodsId(), "�ֻ�"};
            result = super.add(sql, params);
        } catch (Exception e) {
            ErrorManager.printError("SalesInDAO.addSalesIn", e);
        }
        return result;
    }

    /**
     * ��ȡ���е�������Ϣ
     *
     * @return ������Ϣ����
     */
    public Vector<SalesIn> getAllSalesIn() {
        Vector<SalesIn> result = new Vector<SalesIn>();
        try {
            String sql = "{call pr_getAllSalesIn()}";
            ResultSet rs = manager.executeQuery(sql, null, Constants.CALL_TYPE);
            while (rs.next()) {
                SalesIn salesIn = new SalesIn(rs.getString("id"), rs.getString("customerid"), rs.getString("goodsid"),
                        rs.getString("paytype"), rs.getInt("number"), rs.getDouble("price"),
                        rs.getString("salestime"), rs.getString("operateperson"), rs.getString("comment"), rs.getString("state"), rs.getString("paid"));
                result.add(salesIn);
            }
            manager.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("SalesInDAO.getAllSalesIn", e);
        }
        return result;
    }


    /**
     * ��ȡ���е�������Ϣ
     *
     * @return ������Ϣ����
     */
    public Vector<SalesIn> getAllOnTimeSalesIn() {
        Vector<SalesIn> result = new Vector<SalesIn>();
        try {
            String sql = "{call pr_getAllOnTimeSalesIn()}";
            ResultSet rs = manager.executeQuery(sql, null, Constants.CALL_TYPE);
            while (rs.next()) {
                SalesIn salesIn = new SalesIn(rs.getString("id"), rs.getString("customerid"), rs.getString("goodsid"),
                        rs.getString("paytype"), rs.getInt("number"), rs.getDouble("price"),
                        rs.getString("salestime"), rs.getString("operateperson"), rs.getString("comment"), rs.getString("state"), rs.getString("paid"));
                result.add(salesIn);
            }
            manager.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("SalesInDAO.getAllOnTimeSalesIn", e);
        }
        return result;
    }

    /**
     * ��ȡ���е�������Ϣ
     *
     * @return ������Ϣ����
     */
    public Vector<SalesIn> getAllOrderedSalesIn() {
        Vector<SalesIn> result = new Vector<SalesIn>();
        try {
            String sql = "{call pr_getAllOrderedSalesIn()}";
            ResultSet rs = manager.executeQuery(sql, null, Constants.CALL_TYPE);
            while (rs.next()) {
                SalesIn salesIn = new SalesIn(rs.getString("id"), rs.getString("customerid"), rs.getString("goodsid"),
                        rs.getString("paytype"), rs.getInt("number"), rs.getDouble("price"),
                        rs.getString("salestime"), rs.getString("operateperson"), rs.getString("comment"), rs.getString("state"), rs.getString("paid"));
                result.add(salesIn);
            }
            manager.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("SalesInDAO.pr_getAllOrderedSalesIn", e);
        }
        return result;
    }

    /**
     * ��ѯ���ݿ����������������ۼ�¼
     *
     * @param field ��ѯ���ֶ�
     * @param value �����ֵ
     * @return ��ѯ���
     */
    public Vector<SalesIn> searchSalesIn(String field, String value) {
        Vector<SalesIn> result = new Vector<SalesIn>();
        try {
            String sql = "{call pr_searchSalesIn(?,?)}";
            Object[] params = new Object[]{field, value};
            ResultSet rs = manager.executeQuery(sql, params, Constants.CALL_TYPE);
            while (rs.next()) {
                SalesIn salesIn = new SalesIn(rs.getString("id"), rs.getString("customerid"), rs.getString("goodsid"),
                        rs.getString("paytype"), rs.getInt("number"), rs.getDouble("price"),
                        rs.getString("salestime"), rs.getString("operateperson"), rs.getString("comment"), rs.getString("state"), rs.getString("paid"));
                result.add(salesIn);
            }
            manager.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("SalesInDAO.searchPortIn", e);
        }
        return result;
    }

    /**
     * ��ѯ���ݿ����������������ۼ�¼
     *
     * @param beginTime ��ѯ�Ŀ�ʼʱ��
     * @param endTime   ��ѯ�Ľ���ʱ��
     * @return ��ѯ�����
     */
    public Vector<SalesIn> searchPortInByTime(String beginTime, String endTime) {
        Vector<SalesIn> result = new Vector<SalesIn>();
        try {
            String sql = "{call pr_searchThroughTime(?,?,?,?)}";
            Object[] params = new Object[]{"tb_sales", "salestime", beginTime, endTime};
            ResultSet rs = manager.executeQuery(sql, params, Constants.CALL_TYPE);
            while (rs.next()) {
                SalesIn salesIn = new SalesIn(rs.getString("id"), rs.getString("customerid"), rs.getString("goodsid"),
                        rs.getString("paytype"), rs.getInt("number"), rs.getDouble("price"),
                        rs.getString("salestime"), rs.getString("operateperson"), rs.getString("comment"), rs.getString("state"), rs.getString("paid"));
                result.add(salesIn);
            }
            manager.closeDB();
        } catch (Exception e) {
            ErrorManager.printError("SalesInDAO.searchPortIn", e);
        }
        return result;
    }

    /**
     * �ж����۱���Ƿ����
     *
     * @param id
     * @return
     */
    public boolean isExited(String id) {
        return super.isExited("tb_sales", id);
    }
}
