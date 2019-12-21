package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.common.ValidationManager;
import com.njue.mis.handler.GoodsServicesHandler;
import com.njue.mis.model.Goods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PriceChangeFrame extends JInternalFrame
{
	public PriceChangeFrame()
	{
		super("�۸����", true, true, false, true);
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
		JLabel lable = new JLabel("��ƷID��");
		panel_goods.add(lable);
		textField_name = new JTextField();
		textField_name.setColumns(13);
		JButton button = new JButton("����ԭ��");
		button.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				if (textField_name.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "��ƷID����Ϊ�գ�", "��Ϣ",
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
						JOptionPane.showMessageDialog(null, "��Ʒ�����ڣ�", "��Ϣ",
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
		JLabel label1 = new JLabel("��ǰԭ�ۣ�");
		panel_price1.add(label1);
		textField_price1 = new JTextField();
		textField_price1.setColumns(13);
		textField_price1.setEditable(false);
		panel_price1.add(textField_price1);

		JPanel panel_price2 = new JPanel();
		JLabel lable2 = new JLabel("�ĺ�۸�");
		panel_price2.add(lable2);
		textField_price2 = new JTextField();
		textField_price2.setColumns(13);
		panel_price2.add(textField_price2);

		JPanel panel_button = new JPanel();
		button_sure = new JButton("ȷ��");
		button_sure.setEnabled(false);
		button_sure.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				if (textField_name.getText().trim().length() == 0
						|| textField_price2.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "��ƷID��۸���Ϊ�գ�", "��Ϣ",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (textField_price2.getText().trim().length() != 0)
				{
					if (!ValidationManager.validatePrice(textField_price2
							.getText().trim()))
					{
						JOptionPane.showMessageDialog(null, "��Ʒ�۸񲻺Ϸ���", "����",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				GoodsServicesHandler goodsServicesHandler = CommonFactory
						.getGoodsServices();
				if (goodsServicesHandler.modifyGoodsPrice(textField_name
						.getText(), Double.valueOf(textField_price2.getText())))
				{
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
					goodsServicesHandler.addLog(MainFrame.username, df.format(new Date()), (MainFrame.username), MainFrame.dept, "������Ʒ" + textField_name.getText() + "��" + textField_price1 + "��" + textField_price2.getText());
					JOptionPane.showMessageDialog(null, "��ϲ�㣬�۸�����ɹ���", "��Ϣ",
							JOptionPane.INFORMATION_MESSAGE);
					textField_name.setText("");
					textField_price1.setText("");
					textField_price2.setText("");
					button_sure.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "�Բ��𣬼۸����ʧ�ܣ�", "��Ϣ",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		JButton button_new = new JButton("ȡ��");
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
