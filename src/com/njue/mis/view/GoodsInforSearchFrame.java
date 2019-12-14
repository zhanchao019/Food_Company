package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.handler.GoodsServicesHandler;
import com.njue.mis.model.Goods;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GoodsInforSearchFrame extends JInternalFrame
{
	public GoodsInforSearchFrame()
	{
		super("商品查询",true,true,true,true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width * 2 / 3,
				screenSize.height  *2/ 3);
		this.setContentPane(new GoodsInforSearchPanel());
	}
}

class GoodsInforSearchPanel extends JPanel
{
	JTable table;	
	MyTableModel tableModel;
	JComboBox comboBox ;
	JTextField textField;
	
	public GoodsInforSearchPanel()
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
		comboBox.addItem("商品编号");
		comboBox.addItem("商品名称");
		comboBox.addItem("生产批号");
		comboBox.addItem("供应商编号");
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
				GoodsServicesHandler handler=CommonFactory.getGoodsServices();
				Vector<Goods> goodsVector=handler.searchGoods(getValue(field), value);
				if(goodsVector.size()==0)
				{
					JOptionPane.showMessageDialog(null,"没有满足你条件的商品","警告",JOptionPane.WARNING_MESSAGE);
				}
				tableModel.updateData(goodsVector);
			}
			
		}});
		panel.add(button);
		JButton button1 = new JButton();
		button1.setText("显示全部信息");
		button1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			GoodsServicesHandler handler=CommonFactory.getGoodsServices();
			Vector<Goods> goodsVector=handler.getAllGoods();
			if(goodsVector.size()==0)
			{
				JOptionPane.showMessageDialog(null,"当前不存在任何商品信息","警告",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				tableModel.updateData(goodsVector);
			}
			
		}});
		panel.add(button1);

		return panel;
	}
	private String getValue(String field)
	{
		if (field.equals("商品编号"))
		{
			return "id";
		}
		else if (field.equals("商品名称"))
		{
			return "goodsname";
		}else if(field.equals("生产批号")){
			return "productcode";
		}
		else 
		{
			return "providerid";
		}
	}

	class MyTableModel extends AbstractTableModel
	{
		Vector<Goods> goodsVector=new Vector<Goods>();
		
		private String[] columnNames =
		{
				"商品编号", "商品名称", "产地", "规格", "原料",
				"生产批号", "批准文号", "描述","价格", "供应商编号"
		};
		

		public int getColumnCount()
		{
			return columnNames.length;
		}

		public int getRowCount()
		{
			return goodsVector.size();
		}

		public String getColumnName(int col)
		{
			return columnNames[col];
		}

		public Object getValueAt(int row, int col)
		{
			Goods goods=goodsVector.get(row);
			return goods.getGoodsValue(col);
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
		public void updateData(Vector<Goods> goodsVector)
		{
			this.goodsVector=goodsVector;
			if(goodsVector.size()==0)
			{
				goodsVector=new Vector<Goods>();
			}
			else
			{
				fireTableRowsInserted(0, goodsVector.size()-1);
			}
		}
	}
	
}
