/*
 * Created by JFormDesigner on Wed Dec 11 20:41:14 CST 2019
 */

package com.njue.mis.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author unknown
 */
public class CounterDeptFrame extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    public static String power;
    public static String username;
    private static CounterDeptFrame counterDeptFrame;

    public CounterDeptFrame() {
        super("食品公司管理系统");
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static CounterDeptFrame getCounterDeptFrame() {
        if (counterDeptFrame == null) {
            counterDeptFrame = new CounterDeptFrame();
        }
        return counterDeptFrame;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("\u8fd9\u662f\u8d22\u52a1\u7cfb\u7edf");
        contentPane.add(label1, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
