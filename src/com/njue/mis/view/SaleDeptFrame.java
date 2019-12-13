/*
 * Created by JFormDesigner on Fri Dec 13 19:34:49 CST 2019
 */

package com.njue.mis.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Brainrain
 */
public class SaleDeptFrame extends JFrame {
    public static String power;
    public static String username;
    private static SaleDeptFrame saleDeptFrame;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    public static SaleDeptFrame getSaleDeptFrame() {
        if (saleDeptFrame == null) {
            saleDeptFrame = new SaleDeptFrame();
        }
        return saleDeptFrame;
    }

    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenuItem menuItem4;
    private JMenuItem menuItem3;
    private JMenu menu3;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenu menu4;
    private JMenuItem menuItem7;
    private JLabel label1;

    public SaleDeptFrame() {
        super("食品公司管理系统");
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu3 = new JMenu();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menu4 = new JMenu();
        menuItem7 = new JMenuItem();
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u5ba2\u6237\u4fe1\u606f\u7ba1\u7406");

                //---- menuItem1 ----
                menuItem1.setText("\u6dfb\u52a0\u5ba2\u6237\u4fe1\u606f");
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u5220\u9664\u5ba2\u6237\u4fe1\u606f");
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u4f9b\u5e94\u5546\u4fe1\u606f\u7ba1\u7406");

                //---- menuItem4 ----
                menuItem4.setText("\u6dfb\u52a0\u4f9b\u5e94\u5546\u4fe1\u606f");
                menu2.add(menuItem4);

                //---- menuItem3 ----
                menuItem3.setText("\u5220\u9664\u4f9b\u5e94\u5546\u4fe1\u606f");
                menu2.add(menuItem3);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u8ba2\u5355\u7ba1\u7406");

                //---- menuItem5 ----
                menuItem5.setText("\u751f\u6210\u8ba2\u8d27\u5355");
                menu3.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText("\u751f\u6210\u9000\u8d27\u5355");
                menu3.add(menuItem6);
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("\u5176\u4ed6");

                //---- menuItem7 ----
                menuItem7.setText("\u9700\u8981\u6dfb\u52a0\u7684\u529f\u80fd");
                menu4.add(menuItem7);
            }
            menuBar1.add(menu4);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText("\u5f53\u524d\u767b\u5f55\uff1a");
        contentPane.add(label1, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
