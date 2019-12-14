package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.handler.ProviderServicesHandler;
import com.njue.mis.model.Provider;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ProviderInforSearchFrame extends JInternalFrame
{
	public ProviderInforSearchFrame()
	{
		super("供应商查询",true,true,true,true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width * 2 / 3,
				screenSize.height  *2/ 3);
		this.setContentPane(new PrivoderInforSearchPanel());
	}

	public PrivoderInforSearchPanel getPrivoderInforSearchPanel() {
		return new PrivoderInforSearchPanel();
	}
}


class PrivoderInforSearchPanel extends JPanel
{
	JTable table;	
	MyTableModel tableModel;
	JComboBox comboBox;
	JTextField textField;
	
	public PrivoderInforSearchPanel()
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
		panel.setLayout(new FlowLayout());
		JLabel lable = new JLabel("请选择查询条件：");
		panel.add(lable);

		comboBox = new JComboBox();
		comboBox.addItem("供应商编号");
		comboBox.addItem("供应商全称");
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
				ProviderServicesHandler handler=CommonFactory.getProviderServices();
				Vector<Provider> providerVector=handler.searchProvider(getValue(field), value);
				if(providerVector.size()==0)
				{
					JOptionPane.showMessageDialog(null,"没有满足你条件的供应商","警告",JOptionPane.WARNING_MESSAGE);
				}
				tableModel.updateData(providerVector);
			}
			
		}});
		panel.add(button);
		JButton button1 = new JButton();
		button1.setText("显示全部信息");
		button1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			ProviderServicesHandler handler=CommonFactory.getProviderServices();
			Vector<Provider> providerVector=handler.getAllProvider();
			if(providerVector.size()==0)
			{
				JOptionPane.showMessageDialog(null,"但前不存在任何供应商","警告",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				tableModel.updateData(providerVector);
			}
		}});
		panel.add(button1);

		return panel;
	}
	private String getValue(String field)
	{
		if (field.equals("供应商编号"))
		{
			return "id";
		}
		else if (field.equals("供应商全称"))
		{
			return "providername";
		}
		else 
		{
			return "connectionperson";
		}
	}

	class MyTableModel extends AbstractTableModel
	{
		Vector<Provider> providerVector=new Vector<Provider>();
		
		private String[] columnNames =
		{
				"供应商编号", "供应商全称", "供应商邮编", "公司地址", "公司电话",
				"联系人", "联系电话", "卡户银行","银行账号",
		};
		

		public int getColumnCount()
		{
			return columnNames.length;
		}

		public int getRowCount()
		{
			return providerVector.size();
		}

		public String getColumnName(int col)
		{
			return columnNames[col];
		}

		public Object getValueAt(int row, int col)
		{
			Provider provide=providerVector.get(row);
			return provide.getPersonValue(col);
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
		public void updateData(Vector<Provider> providerVector)
		{
			this.providerVector=providerVector;
			if(providerVector.size()==0)
			{
				providerVector=new Vector<Provider>();
			}
			else
			{
				fireTableRowsInserted(0, providerVector.size()-1);
			}
		}
	}
}
