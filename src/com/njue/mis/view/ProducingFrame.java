package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.common.RandomBuilder;
import com.njue.mis.handler.ProducingServicesHandeler;
import com.njue.mis.model.ProducingLine;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ProducingFrame extends JInternalFrame {
    public String scheduleid, goodsid;
    public int sum, unfinished;


    public ProducingFrame(String scheduleid, String goodsid, int sum, int unfinished) {

        super("����������ˮ���������", true, true, true, true);
        this.scheduleid = scheduleid;
        this.goodsid = goodsid;
        this.sum = sum;
        this.unfinished = unfinished;


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, screenSize.width * 2 / 6,
                screenSize.height * 2 / 6);
        this.setContentPane(new ProducingFramePanel(scheduleid, goodsid, sum, unfinished));
    }
}


class ProducingFramePanel extends JPanel {
    JTable table;
    MyTableModel tableModel;
    JComboBox comboBox;
    JTextField textField;
    JCheckBox checkBox;
    public String scheduleid, goodsid;
    public int sum, unfinished, finished;


    JLabel goods_id = new JLabel("");
    boolean flag = false;


    String paystate = "";

    public ProducingFramePanel(String scheduleid, String goodsid, int sum, int unfinished) {
        super(new BorderLayout());
        this.scheduleid = scheduleid;
        this.goodsid = goodsid;
        this.sum = sum;
        this.unfinished = unfinished;
        this.finished = this.sum - this.unfinished;

        tableModel = new MyTableModel();
        table = new JTable(tableModel);
        JPanel pane = search();
        this.add(pane, BorderLayout.NORTH);


        table.setPreferredScrollableViewportSize(new Dimension(500, 50));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel search() {
        int plannum = 0;
        JPanel panel = new JPanel();
        JLabel tit = new JLabel();
        textField = new JTextField();
        textField.setColumns(13);
        textField.setText("");

        panel.setLayout(new GridLayout(3, 1));
        JPanel title = new JPanel();
        JLabel detail = new JLabel("�����ƻ����" + scheduleid + " ��Ʒ���" + goodsid + " ���״̬" + finished + "/" + sum);
        title.add(detail);
        panel.add(title);
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel orderid = new JLabel("���ڲ�ѯ�����ѡ����Ӧ�Ķ���");
        JButton pay = new JButton();
        JLabel lable = new JLabel("");


        //��ȡ�������Ϣ
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel model = (ListSelectionModel) e.getSource();
                int index = model.getMaxSelectionIndex();
                // System.out.println(table.getValueAt(index, 0).toString());
                orderid.setText(table.getValueAt(index, 0).toString());
                sum = Integer.parseInt(table.getValueAt(index, 1).toString());
                //goods_id.setText(table.getValueAt(index, 0).toString());


                tit.setText("��ѡ�����ˮ����");
                //   goodsField.setText(goodsTable.getValueAt(index, 0).toString());
                // goodsPrices=Double.valueOf(goodsTable.getValueAt(index, 8).toString());
            }
        });


        JButton button1 = new JButton();
        button1.setText("��ʾȫ����ˮ����Ϣ");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (true) {
                    ProducingServicesHandeler handler = CommonFactory.getProducingServices();
                    Vector<ProducingLine> producingLineVector = handler.getAllProducingLine();
                    if (producingLineVector.size() == 0) {
                        JOptionPane.showMessageDialog(null, "��ǰû���κ������ƻ�", "����", JOptionPane.WARNING_MESSAGE);

                    } else
                        tableModel.updateData(producingLineVector);
                }
            }
        });

        JButton refresh = new JButton("ˢ��ҳ��");
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag == true) {
                    ProducingServicesHandeler handler = CommonFactory.getProducingServices();
                    Vector<ProducingLine> producingLineVector = handler.getAllProducingLine();
                    if (producingLineVector.size() == 0) {
                        JOptionPane.showMessageDialog(null, "��ǰû���κ������ƻ�", "����", JOptionPane.WARNING_MESSAGE);
                    } else
                        tableModel.updateData(producingLineVector);
                }
            }
        });


        JLabel jj = new JLabel("��������������");

        panel2.add(button1);
        panel2.add(refresh);
        panel2.add(jj);
        textField.setText("");
        panel2.add(textField);
        panel3 = new JPanel();//ѡ��֧��ҳ��

        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // System.out.println(textField.getText().length());
                if (orderid.getText() == "") {
                    JOptionPane.showMessageDialog(null, "��ѡ��һ����ˮ��", "����", JOptionPane.WARNING_MESSAGE);
                } else if (textField.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "��������������", "����", JOptionPane.WARNING_MESSAGE);
                } else {
                    int tmp = Integer.parseInt(textField.getText().trim());
                    System.out.println(tmp + "  " + unfinished);
                    if (!(tmp > unfinished || tmp <= 0)) {
                        RandomBuilder rb = new RandomBuilder(10);
                        String pici = rb.getRandomString();
                        ProducingServicesHandeler handler = CommonFactory.getProducingServices();
                        handler.addProducingDetail(scheduleid, goodsid, pici, orderid.getText(), tmp);

                        JOptionPane.showMessageDialog(null, "��������" + pici + "�Գɹ�������������", "����", JOptionPane.WARNING_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "�����������Ϸ�", "����", JOptionPane.WARNING_MESSAGE);
                    }


                }
            }
        });

        pay.setText("����");

        panel3.add(tit);
        panel3.add(orderid);
        panel3.add(pay);

        panel.add(panel2);

        panel.add(panel3);

        return panel;
    }
/*
    private String getValue(String field) {
        if (field.equals("�����ƻ����")) {
            return "scheduleid";
        } else if (field.equals("��Ʒ���")) {
            return "goodsid";
        } else if (field.equals("��Ʒ����")) {
            return "sum";
        } else if (field.equals("��Ʒδ�����")) {
            return "unfinished";
        } else {
            return "";
        }
    }*/

    class MyTableModel extends AbstractTableModel {
        Vector<ProducingLine> producingVector = new Vector<ProducingLine>();

        private String[] columnNames =
                {
                        "�����߱��", "����������"
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
            ProducingLine producing = producingVector.get(row);
            return producing.getProducingValue(col);
        }

        @SuppressWarnings("unchecked")
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        //��������
        public void updateData(Vector<ProducingLine> producingsVector) {
            this.producingVector = producingsVector;
            if (producingVector.size() == 0) {
                producingVector = new Vector<ProducingLine>();
            } else {
                fireTableRowsInserted(0, producingVector.size() - 1);
            }
        }


    }
}
