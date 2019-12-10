package com.njue.mis.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.common.ValidationManager;
import com.njue.mis.handler.SalesBackServicesHandler;
import com.njue.mis.model.SalesBack;

public class SaleBackInforSearchFrame extends JInternalFrame
{
	public SaleBackInforSearchFrame()
	{
		super("�����˻���ѯ",true,true,true,true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width * 2 / 3,
				screenSize.height  *2/ 3);
		this.setContentPane(new SaleBackInforSearchPanel());
	}
}

class SaleBackInforSearchPanel extends JPanel
{
	JTable table;	
	MyTableModel tableModel;
	JComboBox comboBox;
	JTextField textField ;
	JCheckBox checkBox;
	JTextField textField_starttime;
	JTextField textField_endtime;
	
	public SaleBackInforSearchPanel()
	{
		super(new BorderLayout());
		JPanel pane = search();
		this.add(pane,BorderLayout.NORTH);
		
		tableModel=new MyTableModel();
		table = new JTable(tableModel);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane,BorderLayout.CENTER);
	}

	public JPanel search()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		JPanel panel2=new JPanel(new FlowLayout());
		JPanel panel3=new JPanel(new FlowLayout());
		
		JLabel lable = new JLabel("��ѡ���ѯ������");
		panel2.add(lable);

		comboBox = new JComboBox();
		comboBox.addItem("�˻�����");
		comboBox.addItem("����Ա");
		comboBox.addItem("�ͻ����");
		comboBox.addItem("��Ʒ���");
		comboBox.setSelectedIndex(0);
		panel2.add(comboBox);

		textField = new JTextField();
		textField.setColumns(13);
		panel2.add(textField);

		JButton button = new JButton();
		button.setText("��ѯ");
		button.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
			{
				String field = comboBox.getSelectedItem().toString();
				String value = textField.getText();
				if (checkBox.isSelected())
				{
					String beginTime = textField_starttime.getText();
					String endTime = textField_endtime.getText();
					if (beginTime == null || beginTime.trim().length() == 0)
					{
						JOptionPane.showMessageDialog(null, "�����뿪ʼʱ��", "����",JOptionPane.WARNING_MESSAGE);
						return;
					}
					if (endTime == null || endTime.trim().length() == 0)
					{
						JOptionPane.showMessageDialog(null, "���������ʱ��", "����",JOptionPane.WARNING_MESSAGE);
						return;
					}
					if (!ValidationManager.validateDate(beginTime))
					{
						JOptionPane.showMessageDialog(null,"ʱ���ʽ����ȷ!��ȷ��ʽ: yyyy-mm-dd","����",JOptionPane.WARNING_MESSAGE);
						return;
					}
					if (!ValidationManager.validateDate(endTime))
					{
						JOptionPane.showMessageDialog(null,"ʱ���ʽ����ȷ!��ȷ��ʽ: yyyy-mm-dd","����",JOptionPane.WARNING_MESSAGE);
						return;
					}
					SalesBackServicesHandler handler = CommonFactory.getSalesBackServices();
					Vector<SalesBack> salesBackVector = handler.searchSalesBackByTime(beginTime, endTime);
					if (salesBackVector.size() == 0) 
					{
						JOptionPane.showMessageDialog(null, "û���������������˻���","����", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						tableModel.updateData(salesBackVector);
					}
				}
				else
				{

					if (value == null || value.trim().length() == 0)
					{
						JOptionPane.showMessageDialog(null, "������������ֵ", "����",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						SalesBackServicesHandler handler = CommonFactory.getSalesBackServices();
						Vector<SalesBack> salesBackVector = handler.searchSalesBack(getValue(field), value);
						if (salesBackVector.size() == 0)
						{
							JOptionPane.showMessageDialog(null, "û���������������˻���","����", JOptionPane.WARNING_MESSAGE);
						}
						tableModel.updateData(salesBackVector);
					}
				}

			}
		});
		panel2.add(button);
		
		
		checkBox=new JCheckBox("��ָ�����ڲ�ѯ");
		checkBox.addItemListener(new ItemListener()
		{
			
			public void itemStateChanged(ItemEvent e)
			{
				if (!checkBox.isSelected())
				{
					textField_starttime.setText("");
					textField_endtime.setText("");
					textField_starttime.setEnabled(false);
					textField_endtime.setEnabled(false);
				}
				else
				{
					textField_starttime.setEnabled(true);
					textField_endtime.setEnabled(true);
				}
			}
		});
		panel3.add(checkBox);
		
		JLabel lable1 = new JLabel("��");
		panel3.add(lable1);
		textField_starttime = new JTextField();
		textField_starttime.setColumns(13);
		textField_starttime.setEnabled(false);
		panel3.add(textField_starttime);
		JLabel lable2 = new JLabel("��");
		panel3.add(lable2);
		textField_endtime = new JTextField();
		textField_endtime.setColumns(13);
		textField_endtime.setEnabled(false);
		panel3.add(textField_endtime);
		JButton button1 = new JButton();
		button1.setText("��ʾȫ����Ϣ");
		button1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			SalesBackServicesHandler handler=CommonFactory.getSalesBackServices();
			Vector<SalesBack> salesBackVector=handler.getAllSalesBack();
			if(salesBackVector.size()==0)
			{
				JOptionPane.showMessageDialog(null,"��ǰ�������κ��˻���","����",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				tableModel.updateData(salesBackVector);
			}
		}});
		panel2.add(button1);
		panel.add(panel2);
		panel.add(panel3);
		
		return panel;
	}
	private String getValue(String field)
	{
		if (field.equals("�˻�����"))
		{
			return "id";
		}
		else if (field.equals("����Ա"))
		{
			return "operateperson";
		}
		else if (field.equals("�ͻ����"))
		{
			return "customerid";
		}
		else 
		{
			return "goodsid";
		}
	}

	class MyTableModel extends AbstractTableModel
	{
		Vector<SalesBack> salesBackVector=new Vector<SalesBack>();
		private String[] columnNames =
		{
				"�˻�Ʊ��", "��Ʒ���", "��Ʒ����", "����", "����",
				"���", "�ͻ����","�ͻ�����", "�˻�ʱ��","����Ա"
		};

		public int getColumnCount()
		{
			return columnNames.length;
		}

		public int getRowCount()
		{
			return salesBackVector.size();
		}

		public String getColumnName(int col)
		{
			return columnNames[col];
		}

		public Object getValueAt(int row, int col)
		{
			SalesBack salesBack=salesBackVector.get(row);
			return salesBack.getSalesValue(col);
		}

		@SuppressWarnings("unchecked")
		public Class getColumnClass(int c)
		{
			return getValueAt(0, c).getClass();
		}

		public boolean isCellEditable(int row, int col)
		{
			return false;

		}
		//��������
		public void updateData(Vector<SalesBack> salesBackVector)
		{
			this.salesBackVector=salesBackVector;
			if(salesBackVector.size()==0)
			{
				salesBackVector=new Vector<SalesBack>();
			}
			else
			{
				fireTableRowsInserted(0, salesBackVector.size()-1);
			}
		}
		
	}
}
