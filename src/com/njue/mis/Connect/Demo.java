package com.njue.mis.Connect;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {

    static String sql = null;
    static ConnectionBuilder db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) {
        sql = "select id from tb_goods";//SQL语句
        db1 = new ConnectionBuilder(sql, 0);//创建DBHelper对象

        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            while (ret.next()) {
                String uid = ret.getString(1);

                System.out.println(uid);
            }//显示数据
            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("???");
        sql = "pr_pay(SI20191214132234)";
        db1 = new ConnectionBuilder(sql);
        try {
            ret = db1.pst.executeQuery();

            ret.close();
            db1.close();//关闭连接

        } catch (SQLException e) {

        }

    }
}