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
		super("客户查询",true,true,true,true);
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
		JLabel lable = new JLabel("请选择查询条件：");
		panel.add(lable);

		comboBox = new JComboBox();
		comboBox.addItem("客户ID");
		comboBox.addItem("客户名称");
		comboBox.addItem("联系人");
		comboBox.setSelectedIndex(0);
		panel.add(comboBox);

		textField = new JTextField();
		textField.setColumns(13);
		panel.add(textField);

		JButton button = new JButton();
		button.setText("查询");
		button.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			String field=comboBox.getSelectedItem().toString();
			String value=textField.getText();
			if (value==null||value.trim().length()==0)
			{
				JOptionPane.showMessageDialog(null,"请输入搜索的值","警告",JOptionPane.WARNING_MESSAGE);
			}
			else 
			{
				CustomerServicesHandler handler=CommonFactory.getCustomerServices();
				Vector<Customer> customerVector=handler.searchCustomer(getValue(field), value);
				if(customerVector.size()==0)
				{
					JOptionPane.showMessageDialog(null,"没有满足你条件的客户","警告",JOptionPane.WARNING_MESSAGE);
				}

				tableModel.updateData(customerVector);
			}
			
		}});

		panel.add(button);
		JButton button1 = new JButton();
		button1.setText("显示全部信息");
		button1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			CustomerServicesHandler handler=CommonFactory.getCustomerServices();
			Vector<Customer> customerVector=handler.getAllCustomer();	
			if(customerVector.size()==0)
			{
				JOptionPane.showMessageDialog(null,"当前不存在任何客户信息","警告",JOptionPane.WARNING_MESSAGE);
			}
			tableModel.updateData(customerVector);
		}});
		panel.add(button1);

		return panel;
	}
	
	private String getValue(String field)
	{
		if (field.equals("客户ID"))
		{
			return "id";
		}
		else if (field.equals("客户名称"))
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
				"客户编号", "客户全称", "客户邮编", "客户公司地址", "客户公司电话",
				"联系人", "联系电话", "卡户银行","银行账号", "联系人信箱", "客户传真"
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
		
		//更新数据
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


