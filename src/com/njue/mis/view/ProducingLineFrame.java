package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
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

public class ProducingLineFrame extends JInternalFrame {
    public ProducingLineFrame() {
        super("��ˮ��״̬", true, true, true, true);
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

    float sum = 0;
    String paystate = "";

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
        JLabel orderid = new JLabel("���ڲ�ѯ�����ѡ����Ӧ�Ķ���");
        JButton pay = new JButton();
        JLabel lable = new JLabel("��ѡ���ѯ������");
        panel2.add(lable);

        //��ȡ�������Ϣ
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
                tit.setText("��ѡ��Ķ�����");
                //   goodsField.setText(goodsTable.getValueAt(index, 0).toString());
                // goodsPrices=Double.valueOf(goodsTable.getValueAt(index, 8).toString());
            }
        });

        comboBox = new JComboBox();
        comboBox.addItem("�����ƻ����");
        comboBox.addItem("��Ʒ���");
        comboBox.addItem("���α��");
        comboBox.addItem("�����߱��");
        comboBox.setSelectedIndex(0);
        panel2.add(comboBox);

        textField = new JTextField();
        textField.setColumns(13);
        panel2.add(textField);

        JButton button = new JButton();
        button.setText("��ѯ");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("��������");
                String field = comboBox.getSelectedItem().toString();
                String value = textField.getText();

                if (value == null || value.length() == 0) {
                    JOptionPane.showMessageDialog(null, "������������ֵ", "����", JOptionPane.WARNING_MESSAGE);
                } else {
                    SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                    Vector<SalesIn> salesInVector = handler.searchSalesIn(getValue(field), value);
                    if (salesInVector.size() == 0) {
                        JOptionPane.showMessageDialog(null, "û�����������������۵�", "����", JOptionPane.WARNING_MESSAGE);
                    } else {
                        tableModel.updateData(salesInVector);
                    }

                }
            }
        });
        panel2.add(button);


        JButton button1 = new JButton();
        button1.setText("��ʾȫ����Ϣ");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                flag = true;
                SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                Vector<SalesIn> salesInVector = handler.getAllSalesIn();
                if (salesInVector.size() == 0) {
                    JOptionPane.showMessageDialog(null, "��ǰû���κ����ۼ�¼", "����", JOptionPane.WARNING_MESSAGE);
                }
                tableModel.updateData(salesInVector);
            }
        });

        JButton refresh = new JButton("ˢ��ҳ��");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag == true) {
                    SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                    Vector<SalesIn> salesInVector = handler.getAllSalesIn();
                    if (salesInVector.size() == 0) {
                        JOptionPane.showMessageDialog(null, "��ǰû���κ����ۼ�¼", "����", JOptionPane.WARNING_MESSAGE);
                    }
                    tableModel.updateData(salesInVector);
                }
            }
        });
        panel2.add(button1);
        panel2.add(refresh);
        panel3 = new JPanel();//ѡ��֧��ҳ��
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tit.getText() == "") {
                    JOptionPane.showMessageDialog(null, "��ѡ��һ�����ۼ�¼", "����", JOptionPane.WARNING_MESSAGE);
                } else {
                    System.out.println(paystate + "|");
                    if (paystate != "true") {

                        SalesInServicesHandler handler = CommonFactory.getSalesInServices();
                        handler.pay(orderid.getText());
                        JOptionPane.showMessageDialog(null, "����" + orderid.getText() + "�Գɹ��ɷ�", "����", JOptionPane.WARNING_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "�˶����Ѿ��ɷ�", "����", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        pay.setText("֧��");

        panel3.add(tit);
        panel3.add(orderid);
        panel3.add(pay);

        panel.add(panel2);

        panel.add(panel3);

        return panel;
    }

    private String getValue(String field) {
        if (field.equals("���۵���")) {
            return "id";
        } else if (field.equals("����Ա")) {
            return "operateperson";
        } else if (field.equals("�ͻ����")) {
            return "customerid";
        } else {
            return "goodsid";
        }
    }

    class MyTableModel extends AbstractTableModel {
        Vector<SalesIn> salesInVector = new Vector<SalesIn>();

        private String[] columnNames =
                {
                        "���۵���", "��Ʒ���", "��Ʒ����", "����", "����",
                        "���", "�ͻ����", "�ͻ�����", "����ʱ��", "����Ա", "����״̬", "֧��״̬"
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

        //��������
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
