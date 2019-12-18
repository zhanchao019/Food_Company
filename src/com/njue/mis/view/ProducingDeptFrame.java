package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.handler.ProducingServicesHandeler;
import com.njue.mis.model.Producing;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ProducingDeptFrame extends JInternalFrame {
    public ProducingDeptFrame() {
        super("生产车间", true, true, true, true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, screenSize.width * 2 / 3,
                screenSize.height * 2 / 3);
        this.setContentPane(new ProducingDeptFramePanel());
    }
}


class ProducingDeptFramePanel extends JPanel {
    JTable table;
    MyTableModel tableModel;
    JComboBox comboBox;
    JTextField textField;
    JCheckBox checkBox;
    JTextField textField_starttime;
    JTextField textField_endtime;
    JLabel goods_id = new JLabel("");

    boolean flag = false;

    int sum = 0;
    int unfinished = 0;
    String paystate = "";
    public ProducingDeptFramePanel() {
        super(new BorderLayout());
        tableModel = new MyTableModel();
        table = new JTable(tableModel);
        JPanel pane = search();
        this.add(pane, BorderLayout.NORTH);


        table.setPreferredScrollableViewportSize(new Dimension(100, 70));
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
                // System.out.println(table.getValueAt(index, 0).toString());
                orderid.setText(table.getValueAt(index, 0).toString());
                sum = Integer.parseInt(table.getValueAt(index, 2).toString());
                goods_id.setText(table.getValueAt(index, 1).toString());
                System.out.println(table.getValueAt(index, 4).toString());
                unfinished = Integer.parseInt(table.getValueAt(index, 4).toString());
                System.out.println(unfinished);
                tit.setText("你选择的生产计划是");
                //   goodsField.setText(goodsTable.getValueAt(index, 0).toString());
                // goodsPrices=Double.valueOf(goodsTable.getValueAt(index, 8).toString());
            }
        });





        JButton button1 = new JButton();
        button1.setText("显示全部信息");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag = true;
                ProducingServicesHandeler handler = CommonFactory.getProducingServices();
                Vector<Producing> producingsInVector = handler.getAllSchedule();
                if (producingsInVector.size() == 0) {
                    JOptionPane.showMessageDialog(null, "当前没有任何生产计划", "警告", JOptionPane.WARNING_MESSAGE);
                }
                tableModel.updateData(producingsInVector);
            }
        });

        JButton refresh = new JButton("刷新页面");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag == true) {
                    ProducingServicesHandeler handler = CommonFactory.getProducingServices();
                    Vector<Producing> salesInVector = handler.getAllSchedule();
                    if (salesInVector.size() == 0) {
                        JOptionPane.showMessageDialog(null, "当前没有任何生产计划", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                    tableModel.updateData(salesInVector);
                }
            }
        });

        JButton producingstate = new JButton("流水线状态");
        producingstate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ProducingLineFrame
                ProducingLineFrame pf = new ProducingLineFrame();
                MainFrame.getMainFrame().getContentPane().add(pf);
                pf.setVisible(true);
            }
        });

        panel2.add(button1);
        panel2.add(refresh);
        panel2.add(producingstate);
        panel3 = new JPanel();//选择支付页面

        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (orderid.getText().equals("请在查询结果中选择相应的订单")) {
                    JOptionPane.showMessageDialog(null, "请选择一个生产计划", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (unfinished <= 0) {
                        JOptionPane.showMessageDialog(null, "此生产计划已经完成，无法继续生产", "警告", JOptionPane.WARNING_MESSAGE);
                    } else {
                        ProducingFrame pf = new ProducingFrame(orderid.getText(), goods_id.getText(), sum, unfinished);
                        MainFrame.getMainFrame().getContentPane().add(
                                pf);
                        pf.setVisible(true);
                    }
                }
            }
        });

        pay.setText("生产");

        panel3.add(tit);
        panel3.add(orderid);
        panel3.add(pay);

        panel.add(panel2);

        panel.add(panel3);

        return panel;
    }

    private String getValue(String field) {
        if (field.equals("生产计划编号")) {
            return "scheduleid";
        } else if (field.equals("产品编号")) {
            return "goodsid";
        } else if (field.equals("产品总数")) {
            return "sum";
        } else if (field.equals("产品未完成数")) {
            return "unfinished";
        } else {
            return "";
        }
    }

    class MyTableModel extends AbstractTableModel {
        Vector<Producing> producingVector = new Vector<Producing>();

        private String[] columnNames =
                {
                        "生产计划编号", "产品编号", "产品总数", "产品已完成数", "产品未完成数"
                };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return producingVector.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            Producing producing = producingVector.get(row);
            return producing.getProducingValue(col);
        }

        @SuppressWarnings("unchecked")
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        //更新数据
        public void updateData(Vector<Producing> producingsVector) {
            this.producingVector = producingsVector;
            if (producingVector.size() == 0) {
                producingVector = new Vector<Producing>();
            } else {
                fireTableRowsInserted(0, producingVector.size() - 1);
            }
        }


    }
}
