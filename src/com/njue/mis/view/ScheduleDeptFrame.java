package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.handler.ScheduleServicesHandler;
import com.njue.mis.model.Schedule;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ScheduleDeptFrame extends JInternalFrame {
    public ScheduleDeptFrame() {
        super("生产计划", true, true, true, true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, screenSize.width * 2 / 3,
                screenSize.height * 2 / 3);
        this.setContentPane(new ScheduleDeptFramePanel());
    }
}


class ScheduleDeptFramePanel extends JPanel {
    JTable table;
    MyTableModel tableModel;
    JComboBox comboBox;
    JTextField textField;
    JCheckBox checkBox;
    JTextField textField_starttime;
    JTextField textField_endtime;
    JButton del = new JButton("删除生产计划");
    float sum = 0;
    String paystate = "";

    public ScheduleDeptFramePanel() {
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

        //获取点击的信息
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel model = (ListSelectionModel) e.getSource();
                int index = model.getMaxSelectionIndex();
                // System.out.println(table.getValueAt(index, 0).toString());
                orderid.setText(table.getValueAt(index, 0).toString());
                sum = Integer.parseInt(table.getValueAt(index, 2).toString());
                paystate = table.getValueAt(index, 4).toString();//get pay state
                System.out.println(paystate);
                tit.setText("你选择的生产计划是");
                //   goodsField.setText(goodsTable.getValueAt(index, 0).toString());
                // goodsPrices=Double.valueOf(goodsTable.getValueAt(index, 8).toString());
            }
        });

        comboBox = new JComboBox();
        comboBox.addItem("生产计划编号");
        comboBox.addItem("产品名称");
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

                } else {

                }
            }
        });
        panel2.add(button);


        JButton button1 = new JButton();
        button1.setText("显示全部信息");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScheduleServicesHandler handler = CommonFactory.getScheduleServices();
                Vector<Schedule> scheduleVector = handler.getAllSchedule();
                if (scheduleVector.size() == 0) {
                    JOptionPane.showMessageDialog(null, "当前没有任何生产计划", "警告", JOptionPane.WARNING_MESSAGE);
                }
                tableModel.updateData(scheduleVector);
            }
        });
        panel2.add(button1);


        panel3 = new JPanel();//选择支付页面
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tit.getText() == "") {
                    JOptionPane.showMessageDialog(null, "请选择一个生产计划", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    //System.out.println(paystate + "|");
                    if (paystate != "true") {

                        ScheduleServicesHandler handler = CommonFactory.getScheduleServices();
                        handler.opt(orderid.getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "此计划已经进入生产部门执行", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tit.getText() == "") {
                    JOptionPane.showMessageDialog(null, "请选择一个生产计划", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    //System.out.println(paystate + "|");
                    if (paystate != "true") {

                        ScheduleServicesHandler handler = CommonFactory.getScheduleServices();
                        handler.delSchedule(orderid.getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "此计划已经进入生产部门执行,无法进行取消", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        del.setText("取消生产计划");
        panel3.add(del);
   /*     //添加手动添加生产计划的设置
        JPanel panel4 = new JPanel();
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
        panel4.add(tmplabel);
        panel4.add(scheduleid);
        scheduleid.setText("SI"+new RandomBuilder(10).getRandomString());
        tmplabel = new JLabel("产品id");
        panel4.add(tmplabel);
        panel4.add(goodsid);

        tmplabel = new JLabel("产品生产数量");
        panel4.add(tmplabel);
        panel4.add(number);

        tmplabel = new JLabel("备注");
        panel4.add(tmplabel);
        panel4.add(comment);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (scheduleid.getText() == "") {
                    JOptionPane.showMessageDialog(null, "请输入生产编号", "警告", JOptionPane.WARNING_MESSAGE);
                } else if (goodsid.getText() == "") {
                    JOptionPane.showMessageDialog(null, "请生成生产产品", "警告", JOptionPane.WARNING_MESSAGE);
                } else if (number.getText() == "") {
                    JOptionPane.showMessageDialog(null, "请选择生产数量", "警告", JOptionPane.WARNING_MESSAGE);
                } else if ((Integer.parseInt(number.getText())) <= 0) {
                    JOptionPane.showMessageDialog(null, "请输入正确的生产数量", "警告", JOptionPane.WARNING_MESSAGE);
                } else {

                    ScheduleServicesHandler handler = CommonFactory.getScheduleServices();
                    boolean flag = handler.isExited(scheduleid.getText());
                    if(flag==false){
                        Schedule tmp = new Schedule(scheduleid.getText(),goodsid.getText(),(Integer.parseInt(number.getText())),comment.getText(),"false");
                        handler.addSchedule(tmp);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "生产计划编号已存在，请重新输入", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }

        });confirm.setText("执行");
        panel4.add(confirm);
*/



        panel3.add(tit);
        panel3.add(orderid);
        panel3.add(pay);

        panel.add(panel2);

        panel.add(panel3);
        //panel.add(panel4);
        return panel;
    }

    private String getValue(String field) {
        if (field.equals("生产计划编号")) {
            return "scheduleid";
        } else if (field.equals("产品编号")) {
            return "goodsid";
        } else if (field.equals("数量")) {
            return "sum";
        } else if (field.equals("生产计划状态")) {
            return "state";
        } else {
            return "comment";
        }
    }

    class MyTableModel extends AbstractTableModel {
        Vector<Schedule> scheduleVector = new Vector<Schedule>();

        private String[] columnNames =
                {
                        "生产计划编号", "产品编号", "数量", "备注", "生产计划状态"
                };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return scheduleVector.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            Schedule schedule = scheduleVector.get(row);
            return schedule.getScheduleValue(col);
        }

        @SuppressWarnings("unchecked")
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        //更新数据
        public void updateData(Vector<Schedule> scheduleVector) {
            this.scheduleVector = scheduleVector;
            if (scheduleVector.size() == 0) {
                scheduleVector = new Vector<Schedule>();
            } else {
                fireTableRowsInserted(0, scheduleVector.size() - 1);
            }
        }

    }
}
