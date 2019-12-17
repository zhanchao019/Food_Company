package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.common.RandomBuilder;
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
        super("�����ƻ�", true, true, true, true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, screenSize.width * 2 / 3,
                screenSize.height * 2 / 3);
        this.setContentPane(new ScheduleDeptFramePanel());
    }
}


class ScheduleDeptFramePanel extends JPanel {
    public boolean flag = false;
    JTable table;
    MyTableModel tableModel;
    JComboBox comboBox;
    JTextField textField;
    JCheckBox checkBox;
    JTextField textField_starttime;
    JTextField textField_endtime;
    JButton del = new JButton("ɾ�������ƻ�");
    int sum = 0;
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
        JLabel orderid = new JLabel("���ڲ�ѯ�����ѡ����Ӧ�������ƻ�");
        JButton pay = new JButton();
        JLabel lable = new JLabel("��ѡ���ѯ������");
        panel2.add(lable);
        JLabel goods_id = new JLabel("");

        //��ȡ�������Ϣ
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel model = (ListSelectionModel) e.getSource();
                int index = model.getMaxSelectionIndex();
                // System.out.println(table.getValueAt(index, 0).toString());
                orderid.setText(table.getValueAt(index, 0).toString());
                sum = Integer.parseInt(table.getValueAt(index, 2).toString());
                goods_id.setText(table.getValueAt(index, 1).toString());
                paystate = table.getValueAt(index, 4).toString();//get pay state
                System.out.println(paystate);
                tit.setText("��ѡ��������ƻ���");
                //   goodsField.setText(goodsTable.getValueAt(index, 0).toString());
                // goodsPrices=Double.valueOf(goodsTable.getValueAt(index, 8).toString());
            }
        });

        comboBox = new JComboBox();
        comboBox.addItem("�����ƻ����");
        comboBox.addItem("��Ʒ���");
        comboBox.setSelectedIndex(0);
        panel2.add(comboBox);

        textField = new JTextField();
        textField.setColumns(13);
        textField.setText("");
        panel2.add(textField);

        JButton button = new JButton();
        button.setText("��ѯ");
        pay.setText("ִ�������ƻ�");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("��������");
                String field = comboBox.getSelectedItem().toString();
                String value = textField.getText();
                if (value == null || value.length() == 0) {
                    JOptionPane.showMessageDialog(null, "������������ֵ", "����", JOptionPane.WARNING_MESSAGE);
                } else {
                    ScheduleServicesHandler handler = CommonFactory.getScheduleServices();
                    Vector<Schedule> schedulesVector = handler.searchSchedule(getValue(field), value);
                    if (schedulesVector.size() == 0) {
                        JOptionPane.showMessageDialog(null, "û�������������������ƻ�", "����", JOptionPane.WARNING_MESSAGE);
                    } else {
                        tableModel.updateData(schedulesVector);
                    }
                }
            }
        });
        panel2.add(button);


        JButton button1 = new JButton();
        button1.setText("��ʾȫ����Ϣ");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScheduleServicesHandler handler = CommonFactory.getScheduleServices();
                Vector<Schedule> scheduleVector = handler.getAllSchedule();
                flag = true;
                if (scheduleVector.size() == 0) {
                    JOptionPane.showMessageDialog(null, "��ǰû���κ������ƻ�", "����", JOptionPane.WARNING_MESSAGE);
                }

                tableModel.updateData(scheduleVector);
            }
        });
        panel2.add(button1);


        panel3 = new JPanel();//ѡ��֧��ҳ��
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tit.getText() == "") {
                    JOptionPane.showMessageDialog(null, "��ѡ��һ�������ƻ�", "����", JOptionPane.WARNING_MESSAGE);
                } else {
                    //System.out.println(state + "|");
                    if (paystate != "true") {

                        ScheduleServicesHandler handler = CommonFactory.getScheduleServices();
                        handler.opt(orderid.getText());

                        JOptionPane.showMessageDialog(null, "�����ƻ�" + orderid.getText() + "�Ѿ�������������ִ��", "����", JOptionPane.WARNING_MESSAGE);
                        handler.opt(goods_id.getText(), orderid.getText(), sum);
                        //handler.getAllSchedule();handler.getAllSchedule();//ˢ��
                    } else {

                        JOptionPane.showMessageDialog(null, "�˼ƻ��Ѿ�������������ִ��", "����", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });


        JButton refresh = new JButton("ˢ��ҳ��");
        refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (flag == false) ;
                else {
                    ScheduleServicesHandler handler = CommonFactory.getScheduleServices();
                    Vector<Schedule> scheduleVector = handler.getAllSchedule();
                    if (scheduleVector.size() == 0) {
                        JOptionPane.showMessageDialog(null, "��ǰû���κ������ƻ�", "����", JOptionPane.WARNING_MESSAGE);
                    }
                    tableModel.updateData(scheduleVector);
                }
            }
        });

        panel2.add(refresh);
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tit.getText() == "") {
                    JOptionPane.showMessageDialog(null, "��ѡ��һ�������ƻ�", "����", JOptionPane.WARNING_MESSAGE);
                } else {
                    //System.out.println(state + "|");
                    if (paystate.length() == 4) {

                        ScheduleServicesHandler handler = CommonFactory.getScheduleServices();
                        handler.delSchedule(orderid.getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "�˼ƻ��Ѿ�������������ִ��,�޷�����ȡ��", "����", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        del.setText("ȡ�������ƻ�");

        //����ֶ���������ƻ�������
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
        confirm.setText("ȷ�����");
        tmplabel.setText("�����ƻ����");
        panel3.add(tmplabel);
        panel3.add(scheduleid);
        scheduleid.setText("SI"+new RandomBuilder(10).getRandomString());
        tmplabel = new JLabel("��Ʒid");
        panel3.add(tmplabel);
        panel3.add(goodsid);

        tmplabel = new JLabel("��Ʒ��������");
        panel3.add(tmplabel);
        panel3.add(number);

        tmplabel = new JLabel("��ע");
        panel3.add(tmplabel);
        panel3.add(comment);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (scheduleid.getText() == "") {
                        JOptionPane.showMessageDialog(null, "�������������", "����", JOptionPane.WARNING_MESSAGE);
                    } else if (goodsid.getText() == "") {
                        JOptionPane.showMessageDialog(null, "������������Ʒ", "����", JOptionPane.WARNING_MESSAGE);
                    } else if (number.getText() == "") {
                        JOptionPane.showMessageDialog(null, "��ѡ����������", "����", JOptionPane.WARNING_MESSAGE);
                    } else if ((Integer.parseInt(number.getText())) <= 0) {
                        JOptionPane.showMessageDialog(null, "��������ȷ����������", "����", JOptionPane.WARNING_MESSAGE);
                    } else {

                        ScheduleServicesHandler handler = CommonFactory.getScheduleServices();
                        boolean flag = handler.isExited(scheduleid.getText());
                        if(flag==false){
                            Schedule tmp = new Schedule(scheduleid.getText(),goodsid.getText(),(Integer.parseInt(number.getText())),comment.getText(),"false");
                            handler.addSchedule(tmp);
                        } else {
                            JOptionPane.showMessageDialog(null, "�����ƻ�����Ѵ��ڣ�����������", "����", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, "������Ϣ����ȷ������������", "����", JOptionPane.WARNING_MESSAGE);
                }
            }

        });//confirm.setText("");
        panel3.add(confirm);


        panel2.add(tit);
        panel2.add(orderid);
        panel2.add(pay);
        panel2.add(del);

        panel.add(panel2);

        panel.add(panel3);
        //panel.add(panel4);
        return panel;
    }

    private String getValue(String field) {
        if (field.equals("�����ƻ����")) {
            return "scheduleid";
        } else if (field.equals("��Ʒ���")) {
            return "goodsid";
        } else if (field.equals("����")) {
            return "sum";
        } else if (field.equals("�����ƻ�״̬")) {
            return "state";
        } else if (field.equals("�����ƻ�״̬")) {
            return "comment";
        } else return "";
    }

    class MyTableModel extends AbstractTableModel {
        Vector<Schedule> scheduleVector = new Vector<Schedule>();

        private String[] columnNames =
                {
                        "�����ƻ����", "��Ʒ���", "����", "��ע", "�����ƻ�״̬"
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

        //��������
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
