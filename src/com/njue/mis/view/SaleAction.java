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

    //销售订单生成
    public static ActionListener sales() {
        return new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                SalesFrame salesFrame = new SalesFrame();
                SaleDeptFrame.getSaleDeptFrame().getContentPane().add(
                        salesFrame);
                salesFrame.setVisible(true);
            }
        };
    }
    //退单生成编号

    public static ActionListener salesBack() {
        return new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                SalesBackFrame salesBackFrame = new SalesBackFrame();
                SaleDeptFrame.getSaleDeptFrame().getContentPane().add(
                        salesBackFrame);
                salesBackFrame.setVisible(true);
            }
        };
    }

    //销售订单查询
    public static ActionListener clickSaleInforSearch() {
        return new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                SaleInforSearchFrame saleInforSearchFrame = new SaleInforSearchFrame();
                SaleDeptFrame.getSaleDeptFrame().getContentPane().add(
                        saleInforSearchFrame);
                saleInforSearchFrame.setVisible(true);
            }
        };
    }

    //销售退单查询

    public static ActionListener clickSaleBackInforSearch() {
        return new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                SaleBackInforSearchFrame saleBackInforSearchFrame = new SaleBackInforSearchFrame();
                SaleDeptFrame.getSaleDeptFrame().getContentPane().add(
                        saleBackInforSearchFrame);
                saleBackInforSearchFrame.setVisible(true);
            }
        };
    }


}
