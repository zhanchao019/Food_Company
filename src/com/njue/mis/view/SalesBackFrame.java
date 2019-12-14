package com.njue.mis.view;


import com.njue.mis.common.CommonFactory;
import com.njue.mis.handler.CustomerServicesHandler;
import com.njue.mis.handler.GoodsServicesHandler;
import com.njue.mis.handler.SalesBackServicesHandler;
import com.njue.mis.model.Goods;
import com.njue.mis.model.SalesBack;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class SalesBackFrame extends JInternalFrame
{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	JTextField ID_importtextField;
	JTextField ID_customerField;
	JTextField numberField;
	JComboBox paytypeComboBox;
	JTextField salesbacktimeField;
	JTextField operaterField;
	JTextField goodsField;
	JTextField explainField;
	JTextField stateField;
	JTable goodsTable;

	private double goodsPrices=0;  //记录商品的单价
	
	public SalesBackFrame()
	{
		super("销售退货" ,true, true, true, true);
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width * 2 / 3,
				screenSize.height  *2/ 3);
		this.getContentPane().add(importgoods());
	}

	public JPanel importgoods()
	{
		JPanel panel = new JPanel();
		
		JPanel panel1 = new JPanel();
		JLabel ID_importlable = new JLabel("退货票号:");
		ID_importtextField = new JTextField(10);
		JLabel ID_privoderLabel = new JLabel("客户编号:");
		ID_customerField = new JTextField(10); 
		JLabel numberLabel = new JLabel("数量:");
		JLabel stateLabel = new JLabel("订单状态");
		numberField = new JTextField(10);
		panel1.add(ID_importlable);
		panel1.add(ID_importtextField);
		panel1.add(ID_privoderLabel);
		panel1.add(ID_customerField);
		panel1.add(numberLabel);
		panel1.add(numberField);
		
		JPanel panel2 = new JPanel();
		JLabel paytypeLabel = new JLabel("支付类型:");
		paytypeComboBox = new JComboBox();
		paytypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] 
		{ "请选择支付类型", "现金", "银行卡", "支票"  }));
		JLabel salesbacktimeLabel = new JLabel("销退时间:");
		salesbacktimeField = new JTextField(10);		
		JLabel opreaterLabel = new JLabel("操作员:");
		operaterField = new JTextField(10);
		panel2.add(paytypeLabel);
		panel2.add(paytypeComboBox);
		panel2.add(salesbacktimeLabel);
		panel2.add(salesbacktimeField);
		panel2.add(opreaterLabel);
		panel2.add(operaterField);
		
		JPanel panel3 = new JPanel();
		JScrollPane goodScrollPane = new JScrollPane();
		
		goodsTable = new JTable(new MyTableModel());
		goodsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				ListSelectionModel model = (ListSelectionModel)e.getSource();
				int index = model.getMaxSelectionIndex();
				goodsField.setText(goodsTable.getValueAt(index, 0).toString());
				goodsPrices=Double.valueOf(goodsTable.getValueAt(index, 8).toString());
			}
		});
		
		goodsTable.setPreferredScrollableViewportSize(new Dimension(screenSize.width * 2 / 3-60,
				screenSize.height  / 3));
		goodScrollPane.setViewportView(goodsTable);
		panel3.add(goodScrollPane);
		
		JPanel panel4 = new JPanel();
		JLabel goodsLabel = new JLabel("商品编号:");
		goodsField = new JTextField(10);
		JLabel explainLabel = new JLabel("商品注释:");
		explainField = new JTextField(20);
		JButton addButton = new JButton("添加");
		addButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				Date date=new Date();
				SimpleDateFormat formate=new SimpleDateFormat("yyyyMMddHHmmss");
				ID_importtextField.setText("SB"+formate.format(date));
				formate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				salesbacktimeField.setText(formate.format(date));
				operaterField.setText(MainFrame.username);
				setEnableTrue();
			}
			
		});
		
		JButton salesbackButton = new JButton("退货");
		salesbackButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				String salesBackID=ID_importtextField.getText();
				String customerID=ID_customerField.getText();
				String numberStr=numberField.getText();
				String payType=paytypeComboBox.getSelectedItem().toString();
				String inportTime=salesbacktimeField.getText();
				String operator=operaterField.getText();
				String goodsID=goodsField.getText();
				String comment=explainField.getText();
				String state = "现货";
				double price=0;
				if(numberStr==null||numberStr.trim().length()==0)
				{
					JOptionPane.showMessageDialog(null,"请输入商品数量","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				int number=0;
				try
				{
					number=Integer.valueOf(numberStr);
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null,"商品的数量不合法","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(paytypeComboBox.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(null,"请选择支付类型","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(customerID==null||customerID.trim().length()==0)
				{
					JOptionPane.showMessageDialog(null,"请输入客户编号","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(goodsID==null||goodsID.trim().length()==0)
				{
					JOptionPane.showMessageDialog(null,"请选择商品","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				CustomerServicesHandler handler1=CommonFactory.getCustomerServices();
				if(!handler1.isExited(customerID))
				{
					JOptionPane.showMessageDialog(null,"该客户编号不存在，请核对信息","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				price=goodsPrices*number;  //计算出总价格
				SalesBack salesBack=new SalesBack(salesBackID,customerID,goodsID,payType,number,
						price, inportTime, operator, comment, state);
				SalesBackServicesHandler handler=CommonFactory.getSalesBackServices();
				if (handler.addSalesBack(salesBack))
				{
					JOptionPane.showMessageDialog(null,"退货单添加成功","消息",JOptionPane.INFORMATION_MESSAGE);
					numberField.setText("");
					setEnableFalse();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"退货单添加失败，请按要求输入数据","警告",JOptionPane.WARNING_MESSAGE);	
				}
				
			}
			
		});
		
		setEnableFalse();
		
		panel4.add(goodsLabel);
		panel4.add(goodsField);
		panel4.add(explainLabel);
		panel4.add(explainField);
		panel4.add(addButton);
		panel4.add(salesbackButton);
		
		
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		return panel;
	}
	//设置部分控件为不可用状态
	private void setEnableFalse()
	{
		ID_importtextField.setEnabled(false);
		ID_customerField.setEnabled(false);
		numberField.setEnabled(false);
		paytypeComboBox.setEnabled(false);
		salesbacktimeField.setEnabled(false);
		operaterField.setEnabled(false);
		explainField.setEnabled(false);
		goodsField.setEnabled(false);
	}
	//设置部分控件为可用状态
	private void setEnableTrue()
	{
		ID_customerField.setEnabled(true);
		numberField.setEnabled(true);
		paytypeComboBox.setEnabled(true);
		explainField.setEnabled(true);
	}
	class MyTableModel extends AbstractTableModel
	{
		GoodsServicesHandler handler=CommonFactory.getGoodsServices();
		Vector<Goods> goodsVector=handler.getAllGoods();
		
		private String[] columnNames =
		{
				"商品编号", "商品名称", "产地", "规格","包装","生产批号",
                "批准文号","描述","价格","供应商编号"
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
	}
}
