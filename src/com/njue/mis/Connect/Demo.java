package com.njue.mis.Connect;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {

    static String sql = null;
    static ConnectionBuilder db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) {
        sql = "select id from tb_goods";//SQL���
        db1 = new ConnectionBuilder(sql, 0);//����DBHelper����

        try {
            ret = db1.pst.executeQuery();//ִ����䣬�õ������
            while (ret.next()) {
                String uid = ret.getString(1);

                System.out.println(uid);
            }//��ʾ����
            ret.close();
            db1.close();//�ر�����
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("???");
        sql = "pr_pay(SI20191214132234)";
        db1 = new ConnectionBuilder(sql);
        try {
            ret = db1.pst.executeQuery();

            ret.close();
            db1.close();//�ر�����

        } catch (SQLException e) {

        }

    }
}