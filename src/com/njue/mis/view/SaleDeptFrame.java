/*
 * Created by JFormDesigner on Thu Dec 12 16:39:52 CST 2019
 */

package com.njue.mis.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author unknown
 */
public class SaleDeptFrame extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar1;
    public static String power;
    public static String username;
    private static SaleDeptFrame saleDeptFrame;
    private JMenu menu1;
    private JMenu menu2;
    private JMenu menu3;

    public SaleDeptFrame() {
        initComponents();
    }

    public static SaleDeptFrame getSaleDeptFrame() {
        if (saleDeptFrame == null) {
            saleDeptFrame = new SaleDeptFrame();
        }
        return saleDeptFrame;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menu2 = new JMenu();
        menu3 = new JMenu();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("123");
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("234");
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("456");
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
