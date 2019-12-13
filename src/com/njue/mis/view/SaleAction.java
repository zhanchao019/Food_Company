package com.njue.mis.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaleAction {
    public static ActionListener clickCustomerInfoManager() {

        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerFrame customerFrame = new CustomerFrame();
                SaleDeptFrame.getSaleDeptFrame().getContentPane().add(customerFrame);
                customerFrame.setVisible(true);
            }
        };
    }

    public static ActionListener clickProviderInfoManager() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProviderFrame privoderFrame = new ProviderFrame();
                SaleDeptFrame.getSaleDeptFrame().getContentPane().add(privoderFrame);
                privoderFrame.setVisible(true);
            }
        };
    }
}
