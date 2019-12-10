package com.njue.mis.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.common.ValidationManager;
import com.njue.mis.handler.GoodsServicesHandler;
import com.njue.mis.model.Goods;

public class PriceChangeFrame extends JInternalFrame
{
	public PriceChangeFrame()
	{
		super("价格调整", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 6, screenSize.height / 8,
				350, 200);
		this.getContentPane().add(PriceChangePanel());
	}

	JTextField textField_name = new JTextField();
	JTextField textField_price2 = new JTextField();
	JTextField textField_price1 = new JTextField();
	JButton button_sure;

	public JPanel PriceChangePanel()
	{
		textField_name = new JTextField();
		textField_price1 = new JTextField();
		textField_price2 = new JTextField();
		JPanel panel = new JPanel();

		JPanel panel_goods = new JPanel();
		JLabel lable = new JLabel("商品ID：");
		panel_goods.add(lable);
		textField_name = new JTextField();
		textField_name.setColumns(13);
		JButton button = new JButton("搜索原价");
		button.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				if (textField_name.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "货品ID不能为空！", "消息",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					GoodsServicesHandler goodsServicesHandler = CommonFactory
							.getGoodsServices();
					Goods goods = goodsServicesHandler
							.getGoodsInfo(textField_name.getText());
					if(goods.getAvailable()==0)
					{
						JOptionPane.showMessageDialog(null, "货品不存在！", "消息",
								JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						textField_price1.setText(String.valueOf(goods.getPrice()));
						button_sure.setEnabled(true);
					}
					
					
				}

			}
		});
		panel_goods.add(textField_name);
		panel_goods.add(button);

		JPanel panel_price1 = new JPanel();
		JLabel label1 = new JLabel("改前原价：");
		panel_price1.add(label1);
		textField_price1 = new JTextField();
		textField_price1.setColumns(13);
		textField_price1.setEditable(false);
		panel_price1.add(textField_price1);

		JPanel panel_price2 = new JPanel();
		JLabel lable2 = new JLabel("改后价格：");
		panel_price2.add(lable2);
		textField_price2 = new JTextField();
		textField_price2.setColumns(13);
		panel_price2.add(textField_price2);

		JPanel panel_button = new JPanel();
		button_sure = new JButton("确定");
		button_sure.setEnabled(false);
		button_sure.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				if (textField_name.getText().trim().length() == 0
						|| textField_price2.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "货品ID或价格不能为空！", "消息",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (textField_price2.getText().trim().length() != 0)
				{
					if (!ValidationManager.validatePrice(textField_price2
							.getText().trim()))
					{
						JOptionPane.showMessageDialog(null, "商品价格不合法！", "警告",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				GoodsServicesHandler goodsServicesHandler = CommonFactory
						.getGoodsServices();
				if (goodsServicesHandler.modifyGoodsPrice(textField_name
						.getText(), Double.valueOf(textField_price2.getText())))
				{
					JOptionPane.showMessageDialog(null, "恭喜你，价格调整成功！", "消息",
							JOptionPane.INFORMATION_MESSAGE);
					textField_name.setText("");
					textField_price1.setText("");
					textField_price2.setText("");
					button_sure.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "对不起，价格调整失败！", "消息",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		JButton button_new = new JButton("取消");
		button_new.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		panel_button.add(button_sure);
		panel_button.add(button_new);

		panel.add(panel_goods);
		panel.add(panel_price1);
		panel.add(panel_price2);
		panel.add(panel_button);
		return panel;
	}
}
