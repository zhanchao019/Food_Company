/*
 * Created by JFormDesigner on Fri Dec 13 20:12:50 CST 2019
 */

package com.njue.mis.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Brainrain
 */
public class SaleDeptFrame extends JFrame {
    public static String power;
    public static String username;
    private static SaleDeptFrame saleDeptFrame;
    private JDesktopPane desktopPane;
    private Timer time;     // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;

    public static SaleDeptFrame getSaleDeptFrame() {
        if (saleDeptFrame == null) {
            saleDeptFrame = new SaleDeptFrame();
        }
        return saleDeptFrame;
    }


    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenu menu3;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenu menu4;
    private JMenuItem menuItem7;
    private JMenuItem menuItem8;
    private JMenuItem menuItem9;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;

    public SaleDeptFrame() {
        super("食品公司管理系统");
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(screenSize.width / 6, screenSize.height / 6, screenSize.width * 2 / 3,
                screenSize.height * 2 / 3);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktopPane = new JDesktopPane();

        desktopPane.setOpaque(true);
        label1.setForeground(Color.RED);//可以直接设置文字颜色
        this.setContentPane(desktopPane);
        time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("                    当前登陆人员：  " + power + "   " + username + new SimpleDateFormat("yyyy年MM月dd日 EEEE hh:mm:ss").format(new Date()));
                label1.setText("                    当前登陆人员：   " + power + "   " + username + new SimpleDateFormat("yyyy年MM月dd日 EEEE hh:mm:ss").format(new Date()));
            }
        });
        time.start();


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menu3 = new JMenu();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menu4 = new JMenu();
        menuItem7 = new JMenuItem();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        menuItem9 = new JMenuItem();
        menuItem8 = new JMenuItem();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {//设置用户信息
                menu1.setText("\u5ba2\u6237\u4fe1\u606f\u7ba1\u7406");

                //---- menuItem1 ----
                menuItem1.setText("\u7ba1\u7406\u5ba2\u6237\u4fe1\u606f");
                menuItem1.addActionListener(SaleAction.clickCustomerInfoManager());
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u4f9b\u5e94\u5546\u4fe1\u606f\u7ba1\u7406");


                //---- menuItem3 ----
                menuItem3.setText("\u7ba1\u7406\u4f9b\u5e94\u5546\u4fe1\u606f");
                menuItem3.addActionListener(SaleAction.clickProviderInfoManager());
                menu2.add(menuItem3);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u8ba2\u5355\u7ba1\u7406");

                //---- menuItem5 ----
                menuItem5.setText("\u751f\u6210\u8ba2\u8d27\u5355");
                menuItem5.addActionListener(SaleAction.sales());
                menu3.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText("\u751f\u6210\u9000\u8d27\u5355");
                menuItem6.addActionListener(SaleAction.salesBack());
                menu3.add(menuItem6);

                menuItem8.setText("销售订单查询");
                menuItem8.addActionListener(SaleAction.clickSaleInforSearch());
                menu3.add(menuItem8);

                menuItem9.setText("销售退货订单查询");
                menuItem9.addActionListener(SaleAction.clickSaleBackInforSearch());
                menu3.add(menuItem9);
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

            //---- label1 ----
            label1.setText("\u5f53\u524d\u767b\u5f55\uff1a");
            menuBar1.add(label1);
        }
        setJMenuBar(menuBar1);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textPane1);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

}
