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

public class ProducingFrame extends JInternalFrame {
    public String scheduleid, goodsid;
    public int sum, unfinished;

    public ProducingFrame(String scheduleid, String goodsid, int sum, int unfinished) {

        super("生产车间流水线任务管理", true, true, true, true);
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

        JPanel panel = new JPanel();
        JLabel tit = new JLabel();
        textField = new JTextField();
        textField.setColumns(13);
        textField.setText("");

        panel.setLayout(new GridLayout(3, 1));
        JPanel title = new JPanel();
        JLabel detail = new JLabel("生产计划编号" + scheduleid + " 产品编号" + goodsid + " 完成状态" + finished + "/" + sum);
        title.add(detail);
        panel.add(title);
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
                orderid.setText(table.getValueAt(index, 1).toString());
                sum = Integer.parseInt(table.getValueAt(index, 4).toString());
                goods_id.setText(table.getValueAt(index, 0).toString());


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

        JLabel jj = new JLabel("输入生产的数量");
        panel2.add(button1);
        panel2.add(refresh);
        panel2.add(textField);
        panel3 = new JPanel();//选择支付页面

       /* pay.addActionListener(new ActionListener() {
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
*/
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
