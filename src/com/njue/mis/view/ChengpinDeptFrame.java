/*
 * Created by JFormDesigner on Wed Dec 11 20:52:28 CST 2019
 */

package com.njue.mis.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author unknown
 */
public class ChengpinDeptFrame extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    public static String power;
    public static String username;
    private static ChengpinDeptFrame chengpinDeptFrame;

    public ChengpinDeptFrame() {
        super("ʳƷ��˾����ϵͳ");
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static ChengpinDeptFrame getChengpinDeptFrame() {
        if (chengpinDeptFrame == null) {
            chengpinDeptFrame = new ChengpinDeptFrame();
        }
        return chengpinDeptFrame;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("\u6211\u662f\u6210\u54c1\u5e93");
        contentPane.add(label1, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
