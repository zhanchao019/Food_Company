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


        sql = "pr_getAllSalesIn";
        db1 = new ConnectionBuilder(sql, 1);
        try {
            ret = db1.pst.executeQuery();
            while (ret.next()) {
                String uid = ret.getString(1);

                System.out.println(uid);
            }//��ʾ����
            ret.close();
            db1.close();//�ر�����

        } catch (SQLException e) {

        }

    }
}