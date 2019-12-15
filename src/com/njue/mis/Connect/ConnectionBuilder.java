package com.njue.mis.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionBuilder {
    public static final String url = "jdbc:mysql://localhost:3306/db_jxc_swing";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public ConnectionBuilder(String sql, int type) {
        try {
            Class.forName(name);//ָ����������
            conn = DriverManager.getConnection(url, user, password);//��ȡ����
            if (type == 0) {
                pst = conn.prepareStatement(sql);//׼��ִ�����
            } else if (type == 1) {
                pst = conn.prepareCall("{call " + sql + "()}");//ִ�д洢����
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConnectionBuilder(String sql) {
        try {
            Class.forName(name);//ָ����������
            conn = DriverManager.getConnection(url, user, password);//��ȡ����

            pst = conn.prepareCall("{ call " + sql + " }");//ִ�д洢����


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
