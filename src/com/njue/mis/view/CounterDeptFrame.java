/*
 * Created by JFormDesigner on Sat Dec 14 19:34:41 CST 2019
 */

package com.njue.mis.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Brainrain
 */
public class CounterDeptFrame extends JFrame {

    public static String power;
    public static String username;
    private static CounterDeptFrame counterDeptFrame;
    private JDesktopPane desktopPane;

    private Timer time;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenu menu2;
    private JMenuItem menuItem2;
    private JMenu menu3;
    private JMenuItem menuItem3;
    private OrderDealBehave action1;

    public CounterDeptFrame() {
        super("食品公司管理系统");
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(screenSize.width / 6, screenSize.height / 6, screenSize.width * 2 / 3,
                screenSize.height * 2 / 3);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        desktopPane = new JDesktopPane();

        desktopPane.setOpaque(true);

    /*    label1.setForeground(Color.RED);//可以直接设置文字颜色
        this.setContentPane(desktopPane);
        time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("                    当前登陆人员：  " + power + "   " + username + new SimpleDateFormat("yyyy年MM月dd日 EEEE hh:mm:ss").format(new Date()));
                label1.setText("                    当前登陆人员：   " + power + "   " + username + new SimpleDateFormat("yyyy年MM月dd日 EEEE hh:mm:ss").format(new Date()));
            }
        });
        time.start();
*/
    }

    public static CounterDeptFrame getCounterDeptFrame() {
        if (counterDeptFrame == null) {
            counterDeptFrame = new CounterDeptFrame();
        }
        return counterDeptFrame;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menu2 = new JMenu();
        menuItem2 = new JMenuItem();
        menu3 = new JMenu();
        menuItem3 = new JMenuItem();
        action1 = new OrderDealBehave();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u8ba2\u5355\u5904\u7406");

                //---- menuItem1 ----
                menuItem1.setAction(action1);
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u9000\u8d27");

                //---- menuItem2 ----
                menuItem2.setText("\u9000\u8d27\u8ba2\u5355\u5904\u7406");
                menu2.add(menuItem2);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("text");

                //---- menuItem3 ----
                menuItem3.setText("text");
                menu3.add(menuItem3);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private class OrderDealBehave extends AbstractAction {
        private OrderDealBehave() {
            // JFormDesigner - Action initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            putValue(NAME, "\u8ba2\u5355\u63d0\u8d27");
            // JFormDesigner - End of action initialization  //GEN-END:initComponents
        }

        public void actionPerformed(ActionEvent e) {
            // TODO add your code here
        }
    }
}
