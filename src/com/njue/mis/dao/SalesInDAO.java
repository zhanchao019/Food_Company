/**
 * 销售进货类DAO
 */
package com.njue.mis.dao;

import com.njue.mis.common.Constants;
import com.njue.mis.common.ErrorManager;
import com.njue.mis.model.SalesIn;
import com.njue.mis.model.Storage;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.Vector;

public class SalesInDAO extends ManagerDAO {

    public SalesInDAO() {
        super();
    }

    /**
     * 向数据库中添加新的销售记录
     *
     * @param orderid 封装好的SalesIn对象
     * @return 执行结果
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
     * 向数据库中退货
     *
     * @param orderid  封装好的SalesIn对象
     * @param paystate
     * @return 执行结果
     */
    public boolean back(String orderid, String paystate) {
        try {

            if (paystate.length() == 3) {//out
                String sql = "update (tb_sales)" +
                        "set paid = 'Saleback'" +
                        "set state = '退货'" +
                        "where id= ?";
                Object[] params = new Object[]{
                        orderid};
                super.add(sql, params);//更新订单状态


                sql = "update (tb_storage)" +
                        "set state = 'in',set orderid='NULL'" +
                        "where orderid= ?";
                params = new Object[]{
                        orderid};
                super.add(sql, params);//更新库存中订单状态


                JOptionPane.showMessageDialog(null, "订单" + orderid + "成功退单", "警告", JOptionPane.WARNING_MESSAGE);
            } else if (paystate.length() == 4) {//付款
                String sql = "update (tb_sales)" +
                        "set paid = 'Saleback'" +
                        "where id= ?";
                Object[] params = new Object[]{
                        orderid};
                super.add(sql, params);

                JOptionPane.showMessageDialog(null, "订单" + orderid + "成功退单", "警告", JOptionPane.WARNING_MESSAGE);
            } else if (paystate.length() == 5) {//未付款
                String sql = "update (tb_sales)" +
                        "set paid = 'Saleback'" +
                        "where id= ?";
                Object[] params = new Object[]{
                        orderid};
                super.add(sql, params);
                JOptionPane.showMessageDialog(null, "订单" + orderid + "成功退单", "警告", JOptionPane.WARNING_MESSAGE);
            } else if (paystate.length() == 8) {//已退款
                JOptionPane.showMessageDialog(null, "订单" + orderid + "已经退单，无法重复操作", "警告", JOptionPane.WARNING_MESSAGE);
            }

            return true;

        } catch (Exception e) {
            ErrorManager.printError("SalesInDAO.pay", e);
            return false;
        }

    }

    /**
     * 出库
     *
     * @param orderid 封装好的SalesIn对象
     * @return 执行结果
     */

    public boolean opt(String orderid, String goodsid) {
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


            sql = "update (tb_sales)" +
                    "set state = '已出货'" +
                    "where id= ?";
            params = new Object[]{
                    orderid};
            tmp = super.add(sql, params) && tmp;
            tmp = super.add(sql, params) && tmp;


            sql = "{call pr_updateStorage()}";
            manager.executeQuery(sql, null, Constants.CALL_TYPE);



            return tmp;

        } catch (Exception e) {
            ErrorManager.printError("SalesInDAO.opt", e);
            return false;
        }

    }

    /**
     * 预定订单出库
     *
     * @param orderid 封装好的SalesIn对象
     * @return 执行结果
     */

    public boolean optR(String orderid, String goodsid, int sum) {
        try {


            boolean tmp = true;
            String sql = "update (tb_sales)" +
                    "set paid = 'out'" +
                    "where id= ?";
            Object[] params = new Object[]{
                    orderid};
            tmp = super.add(sql, params);

            sql = "update tb_storage set tb_storage.orderid=? where (tb_storage.goodsid=? and tb_storage.orderid='NULL') LIMIT ? ";
            params = new Object[]{
                    orderid, goodsid, sum};
            tmp = super.add(sql, params);


            sql = "update (tb_storage)" +
                    "set state = 'out'" +
                    "where orderid= ?";
            params = new Object[]{
                    orderid};
            tmp = super.add(sql, params) && tmp;


            sql = "update (tb_sales)" +
                    "set state = '已出货'" +
                    "where id= ?";
            params = new Object[]{
                    orderid};
            tmp = super.add(sql, params) && tmp;


            sql = "{call pr_updateStorage()}";
            manager.executeQuery(sql, null, Constants.CALL_TYPE);
            return tmp;

        } catch (Exception e) {
            ErrorManager.printError("SalesInDAO.opt", e);
            return false;
        }

    }

    /**
     * 向数据库中添加新的销售记录
     *
     * @param salesIn 封装好的SalesIn对象
     * @return 执行结果
     */
    public boolean addSalesIn(SalesIn salesIn) {
        boolean result = false;
        try {
            String sql = "insert into tb_sales(id,customerid,paytype,salestime,operateperson,number,price,comment,goodsid,state) values(?,?,?,?,?,?,?,?,?,?)";
            Object[] params = new Object[]{salesIn.getId(), salesIn.getCustomerId(), salesIn.getPayType(),
                    salesIn.getTime(), salesIn.getOperatePerson(), salesIn.getNumber(),
                    salesIn.getPrice(), salesIn.getComment(), salesIn.getGoodsId(), "现货"};
            result = super.add(sql, params);
        } catch (Exception e) {
            ErrorManager.printError("SalesInDAO.addSalesIn", e);
        }
        return result;
    }

    /**
     * 获取所有的销售信息
     *
     * @return 销售信息集合
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
     * 向数据库中添加新的销售记录
     *
     * @param goodsid
     * @return 执行结果
     */
    public int getSum(String goodsid) {
        Vector<Storage> result = new Vector<Storage>();
        int count = 0;
        try {
            String sql = "select * from tb_storage where goodsid= ? and orderid = 'NULL'";
            Object[] params = new Object[]{goodsid};
            ResultSet rs = manager.executeQuery(sql, params, Constants.PSTM_TYPE);
            while (rs.next()) {
                count++;
                Storage storage = new Storage(rs.getString("goodsid"), rs.getString("pici"), rs.getString("orderid"),
                        rs.getString("producedate"), rs.getString("state"));
                result.add(storage);
            }
            manager.closeDB();

        } catch (Exception e) {
            ErrorManager.printError("SalesInDAO.getstorageItemsum", e);
        }
        return count;
    }


    /**
     * 获取所有的销售信息
     *
     * @return 销售信息集合
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
     * 获取所有的销售信息
     *
     * @return 销售信息集合
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
     * 查询数据库中满足条件的销售记录
     *
     * @param field 查询的字段
     * @param value 满足的值
     * @return 查询结果
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
     * 查询数据库中满足条件的销售记录
     *
     * @param beginTime 查询的开始时间
     * @param endTime   查询的结束时间
     * @return 查询结果集
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
     * 判断销售编号是否存在
     *
     * @param id
     * @return
     */
    public boolean isExited(String id) {
        return super.isExited("tb_sales", id);
    }
}
