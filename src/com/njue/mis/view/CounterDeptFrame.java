package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.common.ValidationManager;
import com.njue.mis.handler.SalesInServicesHandler;
import com.njue.mis.model.SalesIn;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class CounterDeptFrame extends JInternalFrame {
    public CounterDeptFrame() {
        super("销售查询", true, true, true, true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, screenSize.width * 2 / 3,
                screenSize.height * 2 / 3);
        this.setContentPane(new CounterDeptFramePanel());
    }
}


class CounterDeptFramePanel extends JPanel {
    JTable table;
    MyTableModel tableModel;
    JComboBox comboBox;
    JTextField textField;
    JCheckBox checkBox;
    JTextField textField_starttime;
    JTextField textField_endtime;
    boolean flag = false;

    float sum = 0;
    String paystate = "";
    public CounterDeptFramePanel() {
        super(new BorderLayout());
        tableModel = new MyTableModel();
        table = new JTable(tableModel);
        JPanel pane = search();
        this.add(pane, BorderLayout.NORTH);


        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel search() {

        JPanel panel = new JPanel();
        JLabel tit = new JLabel();
        panel.setLayout(new GridLayout(2, 1));
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel orderid = new JLabel("请在查询结果中选择相应的订单");
        JButton pay = new JButton();
        JLabel lable = new JLabel("请选择查询条件：");
        panel2.add(lable);

        //获取点击的信息
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel model = (ListSelectionModel) e.getSource();
                int index = model.getMaxSelectionIndex();
                System.out.println(table.getValueAt(index, 0).toString());
                orderid.setText(table.getValueAt(index, 0).toString());
                sum = Float.parseFloat(table.getValueAt(index, 5).toString());
                paystate = table.getValueAt(index, 11).toString();//get pay state
                paystate.trim();
                System.out.println(paystate);
                tit.setText("你选择的订单是");
                //   goodsField.setText(goodsTable.getValueAt(index, 0).toString());
                // goodsPrices=Double.valueOf(goodsTable.getValueAt(index, 8).toString());
            }
        });

        comboBox = new JComboBox();
        comboBox.addItem("销售单号");
        comboBox.addItem("操作员");
        comboBox.addItem("客户编号");
        comboBox.addItem("商品编号");
        comboBox.setSelectedIndex(0);
        panel2.add(comboBox);

        textField = new JTextField();
        textField.setColumns(13);
        panel2.add(textField);

        JButton button = new JButton();
        button.setText("查询");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("你查个锤锤");
                String field = comboBox.getSelectedItem().toString();
                String value = textField.getText();
                if (checkBox.isSelected()) {
                    String beginTime = textField_starttime.getText();
                    String endTime = textField_endtime.getText();
                    if (beginTime == null || beginTime.trim().length() == 0) {
                        JOptionPane.showMessageDialog(null, "请输入开始时间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (endTime == null || endTime.trim().length() == 0) {
                        JOptionPane.showMessageDialog(null, "请输入结束时间", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (!ValidationManager.validateDate(beginTime)) {
                        JOptionPane.showMessageDialog(null, "时间格式不正确!正确格式: yyyy-mm-dd", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (!ValidationManager.validateDate(endTime)) {
                        JOptionPane.showMessageDialog(null, "时间格式不正确!正确格式: yyyy-mm-dd", "警告", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                    Vector<SalesIn> salesInVector = handler.searchPortInByTime(beginTime, endTime);
                    if (salesInVector.size() == 0) {
                        JOptionPane.showMessageDialog(null, "没有满足你条件的销售单", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                    tableModel.updateData(salesInVector);

                } else {
                    if (value == null || value.length() == 0) {
                        JOptionPane.showMessageDialog(null, "请输入搜索的值", "警告", JOptionPane.WARNING_MESSAGE);
                    } else {
                        SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                        Vector<SalesIn> salesInVector = handler.searchSalesIn(getValue(field), value);
                        if (salesInVector.size() == 0) {
                            JOptionPane.showMessageDialog(null, "没有满足你条件的销售单", "警告", JOptionPane.WARNING_MESSAGE);
                        } else {
                            tableModel.updateData(salesInVector);
                        }
                    }
                }
            }
        });
        panel2.add(button);


        checkBox = new JCheckBox("按指定日期查询");

        checkBox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (!checkBox.isSelected()) {
                    textField_starttime.setText("");
                    textField_endtime.setText("");
                    textField_starttime.setEnabled(false);
                    textField_endtime.setEnabled(false);
                } else {
                    textField_starttime.setEnabled(true);
                    textField_endtime.setEnabled(true);
                }
            }
        });

        panel3.add(checkBox);

        JLabel lable1 = new JLabel("从");
        panel3.add(lable1);
        textField_starttime = new JTextField();
        textField_starttime.setColumns(13);
        textField_starttime.setEnabled(false);
        panel3.add(textField_starttime);
        JLabel lable2 = new JLabel("到");
        panel3.add(lable2);
        textField_endtime = new JTextField();
        textField_endtime.setColumns(13);
        textField_endtime.setEnabled(false);
        panel3.add(textField_endtime);
        JButton button1 = new JButton();
        button1.setText("显示全部信息");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag = true;
                SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                Vector<SalesIn> salesInVector = handler.getAllSalesIn();
                if (salesInVector.size() == 0) {
                    JOptionPane.showMessageDialog(null, "当前没有任何销售记录", "警告", JOptionPane.WARNING_MESSAGE);
                }
                tableModel.updateData(salesInVector);
            }
        });

        JButton refresh = new JButton("刷新页面");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag == true) {
                    SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                    Vector<SalesIn> salesInVector = handler.getAllSalesIn();
                    if (salesInVector.size() == 0) {
                        JOptionPane.showMessageDialog(null, "当前没有任何销售记录", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                    tableModel.updateData(salesInVector);
                }
            }
        });
        panel2.add(button1);
        panel2.add(refresh);
        panel3 = new JPanel();//选择支付页面
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tit.getText() == "") {
                    JOptionPane.showMessageDialog(null, "请选择一个销售记录", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    System.out.println(paystate + "|");
                    if (paystate != "true") {

                        SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                        handler.pay(orderid.getText());
                        JOptionPane.showMessageDialog(null, "订单" + orderid.getText() + "以成功缴费", "警告", JOptionPane.WARNING_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "此订单已经缴费", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        pay.setText("支付");

        panel3.add(tit);
        panel3.add(orderid);
        panel3.add(pay);

        panel.add(panel2);

        panel.add(panel3);

        return panel;
    }

    private String getValue(String field) {
        if (field.equals("销售单号")) {
            return "id";
        } else if (field.equals("操作员")) {
            return "operateperson";
        } else if (field.equals("客户编号")) {
            return "customerid";
        } else {
            return "goodsid";
        }
    }

    class MyTableModel extends AbstractTableModel {
        Vector<SalesIn> salesInVector = new Vector<SalesIn>();

        private String[] columnNames =
                {
                        "销售单号", "商品编号", "商品名称", "单价", "数量",
                        "金额", "客户编号", "客户名称", "销售时间", "操作员", "订单状态", "支付状态"
                };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return salesInVector.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            SalesIn salesIn = salesInVector.get(row);
            return salesIn.getSalesValue(col);
        }

        @SuppressWarnings("unchecked")
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        //更新数据
        public void updateData(Vector<SalesIn> salesInVector) {
            this.salesInVector = salesInVector;
            if (salesInVector.size() == 0) {
                salesInVector = new Vector<SalesIn>();
            } else {
                fireTableRowsInserted(0, salesInVector.size() - 1);
            }
        }

    }
}
