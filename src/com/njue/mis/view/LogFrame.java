package com.njue.mis.view;


import com.njue.mis.common.CommonFactory;
import com.njue.mis.handler.LogServicesHandler;
import com.njue.mis.model.Log;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class LogFrame extends JInternalFrame {
    public LogFrame() {
        super("操作历史信息", true, true, true, true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, screenSize.width * 2 / 3,
                screenSize.height * 2 / 3);
        this.getContentPane().add(new LogFramePanel());
    }
}

class LogFramePanel extends JPanel {
    JTable table;
    MyTableModel model;
    private Vector<Log> log = new Vector<Log>();

    public LogFramePanel() {
        super(new BorderLayout());
        JPanel pane = search();
        add(pane, BorderLayout.NORTH);
        model = new MyTableModel();
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        // Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        // Add the scroll pane to this panel.
        add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel search() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel lable = new JLabel("操作人员：");
        panel.add(lable);
        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setText(MainFrame.username);
        textField.setColumns(13);
        panel.add(textField);
        JLabel lable1 = new JLabel("检查时间：");
        panel.add(lable1);
        JTextField textField1 = new JTextField();
        textField1.setEditable(false);

        java.util.Date data = new java.util.Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        textField1.setText(format.format(data));
        textField1.setColumns(13);
        panel.add(textField1);

        JButton button = new JButton();
        button.setText("检查");
        panel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LogServicesHandler logServices = CommonFactory.getLogServices();
                log = logServices.getAllLog();
                System.out.println("共" + log.size() + "条记录");
                if (log.size() == 0) {
                    JOptionPane.showMessageDialog(null, "没有商品", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    model.addAllLog(log);
                }

            }
        });
        return panel;
    }

    class MyTableModel extends AbstractTableModel {
        private Vector<Log> log = new Vector<Log>();
        private String[] columnNames =
                {
                        "用户名", "时间", "权限", "部门", "详细信息"
                };

        public void addAllLog(Vector<Log> log) {
            this.log = log;
            fireTableRowsInserted(0, log.size() - 1);
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return log.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return log.get(row).getLog(col);
        }

        @SuppressWarnings("unchecked")
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }
    }
}
