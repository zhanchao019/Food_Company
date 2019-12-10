package com.njue.mis.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.handler.GoodsServicesHandler;
import com.njue.mis.model.StorageGoods;

public class StorehouseInfoFrame extends JInternalFrame
{
	public StorehouseInfoFrame()
	{
		super("库存盘点",true,true,true,true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width * 2 / 3,
				screenSize.height * 2 / 3);
		this.getContentPane().add(new StorehouseInfoPanel());
	}
}

class StorehouseInfoPanel extends JPanel
{
	private Vector<StorageGoods> storageGoodses=new Vector<StorageGoods>();
	JTable table;
	MyTableModel model;
	public StorehouseInfoPanel()
	{
		super(new BorderLayout());
		JPanel pane = search();
		add(pane,BorderLayout.NORTH);
		model=new MyTableModel();
		table = new JTable(model);
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
		JLabel lable = new JLabel("盘点员：");
		panel.add(lable);
		JTextField textField = new JTextField();
		textField.setEditable(false);
		textField.setText(MainFrame.username);
		textField.setColumns(13);
		panel.add(textField);
		JLabel lable1 = new JLabel("盘点时间：");
		panel.add(lable1);
		JTextField textField1 = new JTextField();
		textField1.setEditable(false);
		
		java.util.Date data=new java.util.Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		textField1.setText(format.format(data));
		textField1.setColumns(13);
		panel.add(textField1);
		
		JButton button = new JButton();
		button.setText("盘点");
		panel.add(button);
		button.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			GoodsServicesHandler goods=CommonFactory.getGoodsServices();
			storageGoodses=goods.getAllStorageGoods();
			System.out.println("共"+storageGoodses.size()+"条记录");
			if(storageGoodses.size()==0)
			{
				JOptionPane.showMessageDialog(null,"没有商品","警告",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				model.addAllStorageGoods(storageGoodses);
			}
			
		}});
		return panel;
	}

	class MyTableModel extends AbstractTableModel
	{	
		private Vector<StorageGoods> storageGoodses=new Vector<StorageGoods>();
		
		public void addAllStorageGoods(Vector<StorageGoods> storageGoodses)
		{
			this.storageGoodses=storageGoodses;
			fireTableRowsInserted(0, storageGoodses.size()-1);
		}

		private String[] columnNames =
		{
				"商品编号", "商品全称", "供应商名称", "产地","数量","单价", "规格", "包装",
		};
		 
		public int getColumnCount()
		{
			return columnNames.length;
		}
		public int getRowCount()
		{
			return storageGoodses.size();
		}

		public String getColumnName(int col)
		{
			return columnNames[col];
		}

		public Object getValueAt(int row, int col)
		{
			return storageGoodses.get(row).getStorageGoodsValue(col);
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
	}
}
