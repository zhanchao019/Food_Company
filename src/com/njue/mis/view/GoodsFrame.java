package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.common.ValidationManager;
import com.njue.mis.handler.GoodsServicesHandler;
import com.njue.mis.handler.ProviderServicesHandler;
import com.njue.mis.model.Goods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoodsFrame extends JInternalFrame
{
	JTextField goodsField;
	JTextField ID_goodsField;
	JTextField priceField;
	JTextField goodsdressField;
	JTextField packageField;
	JTextField sizeField;
	JTextField productField;
	JTextField promitField;
	JTextField decriptionField;
	JTextField ID_privoderField;

	JTextField goodsField1;
	JTextField ID_goodsField1;
	JTextField priceField1;
	JTextField goodsdressField1;
	JTextField packageField1;
	JTextField sizeField1;
	JTextField productField1;
	JTextField promitField1;
	JTextField decriptionField1;
	JTextField ID_privoderField1;

	public GoodsFrame()
	{
		super("��Ʒ��Ϣ����", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 12, screenSize.height / 20,
				screenSize.width / 2, screenSize.height / 2);
		this.getContentPane().add(createTabbedPane());

	}

	public JTabbedPane createTabbedPane()
	{
		/*
		 * ����������
		 */
		JTabbedPane tabbedPane = new JTabbedPane();
		/*
		 * ������Ʒ�����Ϣҳ��
		 * */
		JPanel addPanel = new JPanel();

		goodsField = new JTextField(30);
		ID_goodsField = new JTextField(13);
		priceField = new JTextField(13);
		goodsdressField = new JTextField(30);
		ID_privoderField = new JTextField(13);
		packageField = new JTextField(13);
		sizeField = new JTextField(13);
		productField = new JTextField(13);
		promitField = new JTextField(30);
		decriptionField = new JTextField(30);

		JPanel addpanel1 = new JPanel();
		JLabel goodsLabel = new JLabel("��Ʒ����:");
		addpanel1.add(goodsLabel);
		addpanel1.add(goodsField);

		JPanel addpanel2 = new JPanel();
		JLabel ID_goodsLabel = new JLabel("��Ʒ���:");
		addpanel2.add(ID_goodsLabel);
		addpanel2.add(ID_goodsField);
		JLabel priceLabel = new JLabel("����:");
		addpanel2.add(priceLabel);
		addpanel2.add(priceField);

		JPanel addpanel3 = new JPanel();
		JLabel goodsdressLabel = new JLabel("����:         ");
		addpanel3.add(goodsdressLabel);

		addpanel3.add(goodsdressField);

		JPanel addpanel4 = new JPanel();
		JLabel ID_privoderLabel = new JLabel("��Ӧ�̺�:");
		addpanel4.add(ID_privoderLabel);

		addpanel4.add(ID_privoderField);
		JLabel sizeLabel = new JLabel("��������/��:");
		addpanel4.add(sizeLabel);

		addpanel4.add(sizeField);

		JPanel addpanel5 = new JPanel();
		JLabel packageLabel = new JLabel("ԭ����:         ");
		addpanel5.add(packageLabel);

		addpanel5.add(packageField);
		JLabel productLabel = new JLabel("����:");
		addpanel5.add(productLabel);

		addpanel5.add(productField);

		JPanel addpanel6 = new JPanel();
		JLabel promitLabel = new JLabel("��׼�ĺ�:");
		addpanel6.add(promitLabel);

		addpanel6.add(promitField);

		JPanel addpanel7 = new JPanel();
		JLabel descriptionLabel = new JLabel("����:         ");
		addpanel7.add(descriptionLabel);

		addpanel7.add(decriptionField);

		JPanel addpanel8 = new JPanel();
		JButton saveButton = new JButton("����");
		saveButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				if (goodsField.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "��Ʒȫ�Ʋ���Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (ID_goodsField.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "��Ʒ��Ų���Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (ID_privoderField.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "��Ӧ�̱�Ų���Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (priceField.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null,"��Ʒ�۸���Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (packageField.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "��Ʒԭ���ϲ���Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (priceField.getText().trim().length() != 0)
				{
					if (!ValidationManager.validatePrice(priceField.getText().trim()))
					{
						JOptionPane.showMessageDialog(null,"��Ʒ�۸񲻺Ϸ���", "����",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				GoodsServicesHandler handler = CommonFactory.getGoodsServices();
				if (handler.isExited("goodsField.getText()"))
				{
					JOptionPane.showMessageDialog(null, "����Ʒ����Ѿ�����", "����",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				ProviderServicesHandler handler2 = CommonFactory
						.getProviderServices();
				if (!handler2.isExited(ID_privoderField.getText()))
				{
					JOptionPane.showMessageDialog(null, "�ù�Ӧ�̱�Ų����ڣ�����ӹ�Ӧ��",
							"����", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else
				{

					if (handler.addGoods(new Goods(ID_goodsField.getText(),
							goodsField.getText(), goodsdressField.getText(),
							Integer.parseInt(sizeField.getText().trim()), packageField.getText(),
							productField.getText(), promitField.getText(),
							decriptionField.getText(), Double
									.valueOf(priceField.getText()),
							ID_privoderField.getText())))
					{
						JOptionPane.showMessageDialog(null, "��Ʒ��Ϣ��ӳɹ���", "��Ϣ",
								JOptionPane.INFORMATION_MESSAGE);
						setNull();
					}
					else
					{
						JOptionPane.showMessageDialog(null,
								"��Ʒ��Ϣ���ʧ�ܣ��밴Ҫ���������ݣ�", "����",
								JOptionPane.WARNING_MESSAGE);
						setNull();
					}
				}
			}
		});
		addpanel8.add(saveButton);
		JButton reButton = new JButton("����");
		reButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				setNull();
			}
		});
		addpanel8.add(reButton);

		addPanel.add(addpanel1);
		addPanel.add(addpanel2);
		addPanel.add(addpanel3);
		addPanel.add(addpanel4);
		addPanel.add(addpanel5);
		addPanel.add(addpanel6);
		addPanel.add(addpanel7);
		addPanel.add(addpanel8);
		tabbedPane.addTab("��Ʒ�����Ϣ", addPanel);

		/*
		 * ������Ʒɾ����Ϣҳ��
		 * */
		goodsField1 = new JTextField(11);
		goodsField1.setEditable(false);
		ID_goodsField1 = new JTextField(13);
		priceField1 = new JTextField(13);
		priceField1.setEditable(false);
		goodsdressField1 = new JTextField(30);
		goodsdressField1.setEditable(false);
		ID_privoderField1 = new JTextField(13);
		ID_privoderField1.setEditable(false);
		sizeField1 = new JTextField(13);
		sizeField1.setEditable(false);
		packageField1 = new JTextField(13);
		packageField1.setEditable(false);
		productField1 = new JTextField(13);
		productField1.setEditable(false);
		promitField1 = new JTextField(30);
		promitField1.setEditable(false);
		decriptionField1 = new JTextField(30);
		decriptionField1.setEditable(false);

		final JPanel deletePanel = new JPanel();

		JPanel deletepanel1 = new JPanel();
		JLabel goodsLabel1 = new JLabel("��ƷID:");
		deletepanel1.add(goodsLabel1);
		deletepanel1.add(ID_goodsField1);
		
		JButton selectButton = new JButton("��ѯ");
		selectButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{

				if (ID_goodsField1.getText().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "��ƷID����Ϊ��", "����",
							JOptionPane.WARNING_MESSAGE);
				}

				else
				{
					GoodsServicesHandler goodsServicesHandler = CommonFactory
							.getGoodsServices();
					Goods goods = goodsServicesHandler.getGoodsInfo(ID_goodsField1
							.getText());
					if (goods.getAvailable()==0)
					{
						JOptionPane.showMessageDialog(null, "���������Ļ����Ų�����",  "����",
								JOptionPane.WARNING_MESSAGE);

					}
					else
					{
						goodsField1.setText(goods.getGoodsName());
						priceField1.setText(String.valueOf(goods.getPrice()));
						goodsdressField1.setText(goods.getProducePlace());
						ID_privoderField1.setText(goods.getProviderId());
						sizeField1.setText(String.valueOf(goods.getSize()));
						packageField1.setText(goods.get_package());
						productField1.setText(goods.getProductCode());
						promitField1.setText(goods.getPromitCode());
						decriptionField1.setText(goods.getDescription());
						goodsField1.setEditable(false);
					}

				}
			}
		});
		deletepanel1.add(selectButton);

		JPanel deletepanel2 = new JPanel();
		JLabel ID_goodsLabel1 = new JLabel("��Ʒȫ��:");
		deletepanel2.add(ID_goodsLabel1);

		deletepanel2.add(goodsField1);
		JLabel priceLabel1 = new JLabel("����:");
		deletepanel2.add(priceLabel1);

		deletepanel2.add(priceField1);

		JPanel deletepanel3 = new JPanel();
		JLabel goodsdressLabel1 = new JLabel("����:         ");
		deletepanel3.add(goodsdressLabel1);

		deletepanel3.add(goodsdressField1);

		JPanel deletepanel4 = new JPanel();
		JLabel ID_privoderLabel1 = new JLabel("��Ӧ�̺�:");
		deletepanel4.add(ID_privoderLabel1);

		deletepanel4.add(ID_privoderField1);
		JLabel sizeLabel1 = new JLabel("������/��:");
		deletepanel4.add(sizeLabel1);

		deletepanel4.add(sizeField1);

		JPanel deletepanel5 = new JPanel();
		JLabel packageLabel1 = new JLabel("��װ:         ");
		deletepanel5.add(packageLabel1);

		deletepanel5.add(packageField1);
		JLabel productLabel1 = new JLabel("����:");
		deletepanel5.add(productLabel1);

		deletepanel5.add(productField1);

		JPanel deletepanel6 = new JPanel();
		JLabel promitLabel1 = new JLabel("��׼�ĺ�:");
		deletepanel6.add(promitLabel1);

		deletepanel6.add(promitField1);

		JPanel deletepanel7 = new JPanel();
		JLabel descriptionLabel1 = new JLabel("����:         ");
		deletepanel7.add(descriptionLabel1);

		deletepanel7.add(decriptionField1);

		JPanel deletepanel8 = new JPanel();
		JButton deleteButton = new JButton("ɾ��");
		deleteButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				if(ID_goodsField1.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "��ƷID����Ϊ��", "����",
							JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					GoodsServicesHandler goodsServicesHandler=CommonFactory.getGoodsServices();
					if(goodsServicesHandler.deleteGoods(ID_goodsField1.getText())){
						JOptionPane.showMessageDialog(null, "��ϲ�㣬ɾ���ɹ���", "��Ϣ",
								JOptionPane.INFORMATION_MESSAGE);
						ID_goodsField1.setEditable(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "�Բ���ɾ��ʧ�ܣ�", "����",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		
		deletepanel8.add(deleteButton);
		JButton reButton1 = new JButton("ȡ��");
		reButton1.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		deletepanel8.add(reButton1);

		deletePanel.add(deletepanel1);
		deletePanel.add(deletepanel2);
		deletePanel.add(deletepanel3);
		deletePanel.add(deletepanel4);
		deletePanel.add(deletepanel5);
		deletePanel.add(deletepanel6);
		deletePanel.add(deletepanel7);
		deletePanel.add(deletepanel8);

		tabbedPane.addTab("��Ʒɾ����Ϣ", deletePanel);

		return tabbedPane;
	}

	private void setNull()
	{
		ID_goodsField.setText("");
		goodsField.setText("");
		goodsdressField.setText("");
		sizeField.setText("");
		packageField.setText("");
		productField.setText("");
		promitField.setText("");
		decriptionField.setText("");
		priceField.setText("");
		ID_privoderField.setText("");
	}
}
