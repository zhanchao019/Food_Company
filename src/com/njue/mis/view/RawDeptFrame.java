/*
 * Created by JFormDesigner on Wed Dec 11 20:53:10 CST 2019
 */

package com.njue.mis.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author unknown
 */
public class RawDeptFrame extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    public static String power;
    public static String username;
    private static RawDeptFrame rawDeptFrame;

    public RawDeptFrame() {
        super("食品公司管理系统");
        initComponents();
    }

    public static RawDeptFrame getSaleDeptFrame() {
        if (rawDeptFrame == null) {
            rawDeptFrame = new RawDeptFrame();
        }
        return rawDeptFrame;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("\u6211\u662f\u539f\u6599\u90e8\u95e8");
        contentPane.add(label1, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
