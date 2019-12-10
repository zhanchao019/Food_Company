package com.njue.mis.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
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
import com.njue.mis.handler.CustomerServicesHandler;
import com.njue.mis.model.Customer;
 
public class CustomerInforSearchFrame extends JInternalFrame
{
	
	public CustomerInforSearchFrame()
	{
		super("�ͻ���ѯ",true,true,true,true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0,0, screenSize.width * 2 / 3,
				screenSize.height  *2/ 3);
		this.setContentPane(new CustomerInforSearchPanel());
	}
}

class CustomerInforSearchPanel extends JPanel
{
	JTable table;	
	MyTableModel tableModel;
	JComboBox comboBox;
	JTextField textField ;
	
	public CustomerInforSearchPanel()
	{
		super(new BorderLayout());
		JPanel pane = search();
		add(pane,BorderLayout.NORTH);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		tableModel=new MyTableModel();
		table = new JTable(tableModel);
		
		table.setPreferredScrollableViewportSize(new Dimension(screenSize.width * 2 / 3-60,
				screenSize.height  / 3));
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);

		JScrollPane scrollPane = new JScrollPane(table);

		add(scrollPane,BorderLayout.CENTER);
	}

	public JPanel search()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel lable = new JLabel("��ѡ���ѯ������");
		panel.add(lable);

		comboBox = new JComboBox();
		comboBox.addItem("�ͻ�ID");
		comboBox.addItem("�ͻ�����");
		comboBox.addItem("��ϵ��");
		comboBox.setSelectedIndex(0);
		panel.add(comboBox);

		textField = new JTextField();
		textField.setColumns(13);
		panel.add(textField);

		JButton button = new JButton();
		button.setText("��ѯ");
		button.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			String field=comboBox.getSelectedItem().toString();
			String value=textField.getText();
			if (value==null||value.trim().length()==0)
			{
				JOptionPane.showMessageDialog(null,"������������ֵ","����",JOptionPane.WARNING_MESSAGE);
			}
			else 
			{
				CustomerServicesHandler handler=CommonFactory.getCustomerServices();
				Vector<Customer> customerVector=handler.searchCustomer(getValue(field), value);
				if(customerVector.size()==0)
				{
					JOptionPane.showMessageDialog(null,"û�������������Ŀͻ�","����",JOptionPane.WARNING_MESSAGE);
				}

				tableModel.updateData(customerVector);
			}
			
		}});

		panel.add(button);
		JButton button1 = new JButton();
		button1.setText("��ʾȫ����Ϣ");
		button1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			CustomerServicesHandler handler=CommonFactory.getCustomerServices();
			Vector<Customer> customerVector=handler.getAllCustomer();	
			if(customerVector.size()==0)
			{
				JOptionPane.showMessageDialog(null,"��ǰ�������κοͻ���Ϣ","����",JOptionPane.WARNING_MESSAGE);
			}
			tableModel.updateData(customerVector);
		}});
		panel.add(button1);

		return panel;
	}
	
	private String getValue(String field)
	{
		if (field.equals("�ͻ�ID"))
		{
			return "id";
		}
		else if (field.equals("�ͻ�����"))
		{
			return "customername";
		}
		else 
		{
			return "connectionperson";
		}
	}

	class MyTableModel extends AbstractTableModel
	{
		Vector<Customer> customerVector=new Vector<Customer>();
		
		private String[] columnNames =
		{
				"�ͻ����", "�ͻ�ȫ��", "�ͻ��ʱ�", "�ͻ���˾��ַ", "�ͻ���˾�绰",
				"��ϵ��", "��ϵ�绰", "��������","�����˺�", "��ϵ������", "�ͻ�����"
		};
		
		public int getColumnCount()
		{
			return columnNames.length;
		}

		public int getRowCount()
		{
			return customerVector.size();
		}

		public String getColumnName(int col)
		{
			return columnNames[col];
		}

		public Object getValueAt(int row, int col)
		{
			Customer customer=customerVector.get(row);
			return customer.getPersonValue(col);
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
		public void updateData(Vector<Customer> customerVector)
		{
			this.customerVector=customerVector;
			if(customerVector.size()==0)
			{
				customerVector=new Vector<Customer>();
			}
			else
			{
				fireTableRowsInserted(0, customerVector.size()-1);
			}
		}
	}
}


