/*
 * Created by JFormDesigner on Fri Dec 13 19:20:00 CST 2019
 */

package com.njue.mis.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Brainrain
 */
public class CounterDeptFrame extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    public static String power;
    public static String username;
    private static CounterDeptFrame counterDeptFrame;
    private JTextField textField1;
    public CounterDeptFrame() {
        initComponents();
    }

    public static CounterDeptFrame getCounterDeptFrame() {
        if (counterDeptFrame == null) {
            counterDeptFrame = new CounterDeptFrame();
        }
        return counterDeptFrame;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("\u6211\u662f\u8d22\u52a1\u7cfb\u7edf");
        contentPane.add(label1, BorderLayout.NORTH);
        contentPane.add(textField1, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
