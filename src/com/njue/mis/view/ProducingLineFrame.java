package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.handler.ProducingServicesHandeler;
import com.njue.mis.model.ProducingLineDetail;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class ProducingLineFrame extends JInternalFrame {
    public ProducingLineFrame() {
        super("流水线状态", true, true, true, true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, screenSize.width * 2 / 3,
                screenSize.height * 2 / 3);
        this.setContentPane(new ProducingLineFramePanel());
    }
}


class ProducingLineFramePanel extends JPanel {
    JTable table;
    MyTableModel tableModel;
    JComboBox comboBox;
    JTextField textField;
    JCheckBox checkBox;

    boolean flag = false;

    int sum = 0;
    String state = "";
    String pici = "";
    String line = "";
    public ProducingLineFramePanel() {
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
        JLabel scheduleid = new JLabel("请在查询结果中选择相应的订单");
        JButton pay = new JButton();
        JLabel lable = new JLabel("请选择查询条件：");
        panel2.add(lable);

        //获取点击的信息
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel model = (ListSelectionModel) e.getSource();
                int index = model.getMaxSelectionIndex();
                //     System.out.println(table.getValueAt(index, 0).toString());
                scheduleid.setText(table.getValueAt(index, 0).toString());
                sum = Integer.parseInt(table.getValueAt(index, 4).toString());
                state = table.getValueAt(index, 5).toString();//get pay state
                pici = table.getValueAt(index, 2).toString();
                line = table.getValueAt(index, 3).toString();
                state.trim();
                System.out.println(state);
                tit.setText("你选择的订单是");
                //   goodsField.setText(goodsTable.getValueAt(index, 0).toString());
                // goodsPrices=Double.valueOf(goodsTable.getValueAt(index, 8).toString());
            }
        });

        comboBox = new JComboBox();
        comboBox.addItem("生产计划编号");
        comboBox.addItem("产品编号");
        comboBox.addItem("批次编号");
        comboBox.addItem("生产线编号");
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

                if (value == null || value.length() == 0) {
                    JOptionPane.showMessageDialog(null, "请输入搜索的值", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    ProducingServicesHandeler handler = CommonFactory.getProducingServices();
                    Vector<ProducingLineDetail> producingLineDetailVector = handler.searchProducingLineDetail(getValue(field), value);
                    if (producingLineDetailVector.size() == 0) {
                        JOptionPane.showMessageDialog(null, "没有满足你条件的流水线记录", "警告", JOptionPane.WARNING_MESSAGE);
                    } else {
                        tableModel.updateData(producingLineDetailVector);
                    }

                }
            }
        });
        panel2.add(button);


        JButton button1 = new JButton();
        button1.setText("显示全部信息");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag = true;
                ProducingServicesHandeler handler = CommonFactory.getProducingServices();
                Vector<ProducingLineDetail> producingLineDetailVector = handler.getAllProducingLineDetail();
                if (producingLineDetailVector.size() == 0) {
                    JOptionPane.showMessageDialog(null, "当前没有任何流水线记录", "警告", JOptionPane.WARNING_MESSAGE);
                }
                tableModel.updateData(producingLineDetailVector);
            }
        });

        JButton refresh = new JButton("刷新页面");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag == true) {
                    ProducingServicesHandeler handler = CommonFactory.getProducingServices();
                    Vector<ProducingLineDetail> producingLineDetailVector = handler.getAllProducingLineDetail();
                    if (producingLineDetailVector.size() == 0) {
                        JOptionPane.showMessageDialog(null, "当前没有任何流水线记录", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                    tableModel.updateData(producingLineDetailVector);
                }
            }
        });


        panel2.add(button1);
        panel2.add(refresh);
        panel3 = new JPanel();//选择支付页面
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (scheduleid.getText() == "") {
                    JOptionPane.showMessageDialog(null, "请选择一条生产线信息", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    System.out.println(state.length() + "|");
                    state = state.trim();
                    if (state.length() != 4) {

                        ProducingServicesHandeler handler = CommonFactory.getProducingServices();
                        handler.finish(pici.trim(), line);
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                        handler.addLog(MainFrame.username, df.format(new Date()), (MainFrame.username), MainFrame.dept, "生产任务" + scheduleid.getText() + "成功完成");
                        JOptionPane.showMessageDialog(null, "生产任务" + scheduleid.getText() + "已经成功完成", "警告", JOptionPane.WARNING_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "此生产任务已经完成", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        pay.setText("完成此批次");

        panel3.add(tit);
        panel3.add(scheduleid);
        panel3.add(pay);

        panel.add(panel2);

        panel.add(panel3);

        return panel;
    }

    private String getValue(String field) {
        if (field.equals("生产计划编号")) {
            return "scheduleid";
        } else if (field.equals("商品编号")) {
            return "goodsid";
        } else if (field.equals("批次编号")) {
            return "pici";
        } else if (field.equals("流水线编号")) {
            return "producinglineid";
        } else if (field.equals("数量")) {
            return "num";
        } else if (field.equals("完成状态")) {
            return "state";
        } else {
            return "";
        }
    }

    class MyTableModel extends AbstractTableModel {
        Vector<ProducingLineDetail> producingLineDetailVector = new Vector<ProducingLineDetail>();

        private String[] columnNames =
                {
                        "生产计划编号", "产品编号", "批次编号", "流水线编号", "数量", "完成状态"
                };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return producingLineDetailVector.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            ProducingLineDetail producingLineDetail = producingLineDetailVector.get(row);
            return producingLineDetail.getProducingLineDetailValue(col);
        }

        @SuppressWarnings("unchecked")
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        //更新数据
        public void updateData(Vector<ProducingLineDetail> producingLineDetailVector) {
            this.producingLineDetailVector = producingLineDetailVector;
            if (producingLineDetailVector.size() == 0) {
                producingLineDetailVector = new Vector<ProducingLineDetail>();
            } else {
                fireTableRowsInserted(0, producingLineDetailVector.size() - 1);
            }
        }

    }
}
