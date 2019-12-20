package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.common.RandomBuilder;
import com.njue.mis.handler.SalesInServicesHandler;
import com.njue.mis.model.SalesIn;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class StorageFrame extends JInternalFrame {

    public StorageFrame() {
        super("？？？", true, true, true, true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, screenSize.width * 2 / 3,
                screenSize.height * 2 / 3);
        this.setContentPane(new StorageFramePanel());
    }
}


class StorageFramePanel extends JPanel {
    public boolean flag = false;
    JTable table;
    MyTableModel tableModel;
    JComboBox comboBox;
    JTextField textField;
    JCheckBox checkBox;
    JTextField textField_starttime;
    JTextField textField_endtime;
    JButton del = new JButton("删除生产计划");
    int sum = 0;
    String orderState = "";

    public StorageFramePanel() {
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
        JLabel orderid = new JLabel("请在查询结果中选择相应的生产计划");
        JButton pay = new JButton();
        JLabel lable = new JLabel("请选择查询条件：");
        panel2.add(lable);
        JLabel goods_id = new JLabel("");

        //获取点击的信息
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel model = (ListSelectionModel) e.getSource();
                int index = model.getMaxSelectionIndex();
                // System.out.println(table.getValueAt(index, 0).toString());
                orderid.setText(table.getValueAt(index, 0).toString());
                sum = Integer.parseInt(table.getValueAt(index, 2).toString());
                goods_id.setText(table.getValueAt(index, 1).toString());
                orderState = table.getValueAt(index, 4).toString();//get pay state
                System.out.println(orderState);
                tit.setText("你选择的生产计划是");
                //   goodsField.setText(goodsTable.getValueAt(index, 0).toString());
                // goodsPrices=Double.valueOf(goodsTable.getValueAt(index, 8).toString());
            }
        });

        comboBox = new JComboBox();
        comboBox.addItem("订单编号");
        comboBox.addItem("产品编号");
        comboBox.setSelectedIndex(0);
        panel2.add(comboBox);

        textField = new JTextField();
        textField.setColumns(13);
        textField.setText("");
        panel2.add(textField);

        JButton button = new JButton();
        button.setText("查询");
        pay.setText("交货产品出库");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("你查个锤锤");
                String field = comboBox.getSelectedItem().toString();
                String value = textField.getText();
                if (value == null || value.length() == 0) {
                    JOptionPane.showMessageDialog(null, "请输入搜索的值", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                    Vector<SalesIn> salesInVector = handler.searchSalesIn(getValue(field), value);
                    if (salesInVector.size() == 0) {
                        JOptionPane.showMessageDialog(null, "没有满足你条件的订单", "警告", JOptionPane.WARNING_MESSAGE);
                    } else {
                        tableModel.updateData(salesInVector);
                    }
                }
            }
        });
        panel2.add(button);


        JButton button1 = new JButton();
        button1.setText("显示全部信息");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                Vector<SalesIn> salesInVector = handler.getAllSalesIn();
                flag = true;
                if (salesInVector.size() == 0) {
                    JOptionPane.showMessageDialog(null, "当前没有任何待交付订单", "警告", JOptionPane.WARNING_MESSAGE);
                }

                tableModel.updateData(salesInVector);
            }
        });
        panel2.add(button1);


        panel3 = new JPanel();//选择支付页面
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tit.getText() == "") {
                    JOptionPane.showMessageDialog(null, "请选择一个待交付订单", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    //System.out.println(state + "|");
                    if (orderState != "true") {

                        SalesInServicesHandler handler = CommonFactory.getSalesInServices();

                        handler.opt(orderid.getText(), goods_id.getText());
                        JOptionPane.showMessageDialog(null, "订单" + orderid.getText() + "成功交付", "警告", JOptionPane.WARNING_MESSAGE);
                        //handler.getAllSchedule();handler.getAllSchedule();//刷新
                    } else {

                        JOptionPane.showMessageDialog(null, "订单已经交付", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });


        JButton refresh = new JButton("显示现货订单");
        refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                Vector<SalesIn> salesInVector = handler.getAllOnTimeSalesIn();
                if (salesInVector.size() == 0) {
                    JOptionPane.showMessageDialog(null, "当前没有任何待交付订单", "警告", JOptionPane.WARNING_MESSAGE);
                }
                tableModel.updateData(salesInVector);

            }
        });

        panel2.add(refresh);

        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                Vector<SalesIn> salesInVector = handler.getAllOrderedSalesIn();
                if (salesInVector.size() == 0) {
                    JOptionPane.showMessageDialog(null, "当前没有任何待交付订单", "警告", JOptionPane.WARNING_MESSAGE);
                }
                tableModel.updateData(salesInVector);
            }
        });
        del.setText("显示所有预定订单");

        //添加手动添加生产计划的设置
        //JPanel panel4 = new JPanel();
        JTextField scheduleid = new JTextField();
        scheduleid.setColumns(13);
        JTextField goodsid = new JTextField();
        goodsid.setColumns(13);
        JTextField number = new JTextField();
        number.setColumns(13);
        JTextField comment = new JTextField();
        comment.setColumns(13);
        JLabel tmplabel = new JLabel();
        JButton confirm = new JButton();
        confirm.setText("确认添加");
        tmplabel.setText("生产计划编号");
        // panel3.add(tmplabel);
        // panel3.add(scheduleid);
        scheduleid.setText("SI" + new RandomBuilder(10).getRandomString());
        tmplabel = new JLabel("产品id");
        // panel3.add(tmplabel);
        // panel3.add(goodsid);

        tmplabel = new JLabel("产品生产数量");
        //  panel3.add(tmplabel);
        //   panel3.add(number);

        tmplabel = new JLabel("备注");
        //  panel3.add(tmplabel);
        //  panel3.add(comment);

      /*  confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (scheduleid.getText() == "") {
                        JOptionPane.showMessageDialog(null, "请输入生产编号", "警告", JOptionPane.WARNING_MESSAGE);
                    } else if (goodsid.getText() == "") {
                        JOptionPane.showMessageDialog(null, "请生成生产产品", "警告", JOptionPane.WARNING_MESSAGE);
                    } else if (number.getText() == "") {
                        JOptionPane.showMessageDialog(null, "请选择生产数量", "警告", JOptionPane.WARNING_MESSAGE);
                    } else if ((Integer.parseInt(number.getText())) <= 0) {
                        JOptionPane.showMessageDialog(null, "请输入正确的生产数量", "警告", JOptionPane.WARNING_MESSAGE);
                    } else {

                        SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                        boolean flag = handler.isExited(scheduleid.getText());
                        if(flag==false){
                            Schedule tmp = new Schedule(scheduleid.getText(),goodsid.getText(),(Integer.parseInt(number.getText())),comment.getText(),"false");
                            handler.addSchedule(tmp);
                        } else {
                            JOptionPane.showMessageDialog(null, "生产计划编号已存在，请重新输入", "警告", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, "输入信息不正确，请重新输入", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }

        });//confirm.setText("");
   //     panel3.add(confirm);
*/
        panel2.add(del);
        panel2.add(tit);
        panel2.add(orderid);
        panel2.add(pay);


        panel.add(panel2);

        //   panel.add(panel3);
        //panel.add(panel4);
        return panel;
    }

    private String getValue(String field) {
        if (field.equals("订单编号")) {
            return "orderid";
        } else if (field.equals("产品编号")) {
            return "goodsid";
        } else if (field.equals("数量")) {
            return "sum";
        } else if (field.equals("订单创建时间")) {
            return "salestime";
        } else if (field.equals("订单状态")) {
            return "state";
        } else return "";
    }

    class MyTableModel extends AbstractTableModel {
        Vector<SalesIn> saleInVector = new Vector<SalesIn>();

        private String[] columnNames =
                {
                        "订单编号", "产品编号", "数量", "订单创建时间", "订单状态"
                };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return saleInVector.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            SalesIn salesIn = saleInVector.get(row);
            return salesIn.getStorageSaleValue(col);
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
            this.saleInVector = salesInVector;
            if (salesInVector.size() == 0) {
                salesInVector = new Vector<SalesIn>();
            } else {
                fireTableRowsInserted(0, salesInVector.size() - 1);
            }
        }

    }
}
