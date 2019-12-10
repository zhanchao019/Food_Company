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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.common.ValidationManager;
import com.njue.mis.handler.GoodsServicesHandler;
import com.njue.mis.handler.ProviderServicesHandler;
import com.njue.mis.model.Goods;

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
		super("商品信息管理", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 12, screenSize.height / 20,
				screenSize.width / 2, screenSize.height / 2);
		this.getContentPane().add(createTabbedPane());

	}

	public JTabbedPane createTabbedPane()
	{
		/*
		 * 建立主体框架
		 */
		JTabbedPane tabbedPane = new JTabbedPane();
		/*
		 * 建立商品添加信息页面
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
		JLabel goodsLabel = new JLabel("商品名称:");
		addpanel1.add(goodsLabel);
		addpanel1.add(goodsField);

		JPanel addpanel2 = new JPanel();
		JLabel ID_goodsLabel = new JLabel("商品编号:");
		addpanel2.add(ID_goodsLabel);
		addpanel2.add(ID_goodsField);
		JLabel priceLabel = new JLabel("单价:");
		addpanel2.add(priceLabel);
		addpanel2.add(priceField);

		JPanel addpanel3 = new JPanel();
		JLabel goodsdressLabel = new JLabel("产地:         ");
		addpanel3.add(goodsdressLabel);

		addpanel3.add(goodsdressField);

		JPanel addpanel4 = new JPanel();
		JLabel ID_privoderLabel = new JLabel("供应商号:");
		addpanel4.add(ID_privoderLabel);

		addpanel4.add(ID_privoderField);
		JLabel sizeLabel = new JLabel("规格:");
		addpanel4.add(sizeLabel);

		addpanel4.add(sizeField);

		JPanel addpanel5 = new JPanel();
		JLabel packageLabel = new JLabel("包装:         ");
		addpanel5.add(packageLabel);

		addpanel5.add(packageField);
		JLabel productLabel = new JLabel("批号:");
		addpanel5.add(productLabel);

		addpanel5.add(productField);

		JPanel addpanel6 = new JPanel();
		JLabel promitLabel = new JLabel("批准文号:");
		addpanel6.add(promitLabel);

		addpanel6.add(promitField);

		JPanel addpanel7 = new JPanel();
		JLabel descriptionLabel = new JLabel("描述:         ");
		addpanel7.add(descriptionLabel);

		addpanel7.add(decriptionField);

		JPanel addpanel8 = new JPanel();
		JButton saveButton = new JButton("保存");
		saveButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				if (goodsField.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "商品全称不能为空！", "警告",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (ID_goodsField.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "商品编号不能为空！", "警告",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (ID_privoderField.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "供应商编号不能为空！", "警告",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (priceField.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null,"商品价格不能为空！", "警告",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (priceField.getText().trim().length() != 0)
				{
					if (!ValidationManager.validatePrice(priceField.getText().trim()))
					{
						JOptionPane.showMessageDialog(null,"商品价格不合法！", "警告",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				GoodsServicesHandler handler = CommonFactory.getGoodsServices();
				if (handler.isExited("goodsField.getText()"))
				{
					JOptionPane.showMessageDialog(null, "该商品编号已经存在", "警告",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				ProviderServicesHandler handler2 = CommonFactory
						.getProviderServices();
				if (!handler2.isExited(ID_privoderField.getText()))
				{
					JOptionPane.showMessageDialog(null, "该供应商编号不存在，请添加供应商",
							"警告", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else
				{

					if (handler.addGoods(new Goods(ID_goodsField.getText(),
							goodsField.getText(), goodsdressField.getText(),
							sizeField.getText(), packageField.getText(),
							productField.getText(), promitField.getText(),
							decriptionField.getText(), Double
									.valueOf(priceField.getText()),
							ID_privoderField.getText())))
					{
						JOptionPane.showMessageDialog(null, "商品信息添加成功！", "消息",
								JOptionPane.INFORMATION_MESSAGE);
						setNull();
					}
					else
					{
						JOptionPane.showMessageDialog(null,
								"商品信息添加失败，请按要求输入数据！", "警告",
								JOptionPane.WARNING_MESSAGE);
						setNull();
					}
				}
			}
		});
		addpanel8.add(saveButton);
		JButton reButton = new JButton("重置");
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
		tabbedPane.addTab("商品添加信息", addPanel);

		/*
		 * 建立商品删除信息页面
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
		JLabel goodsLabel1 = new JLabel("商品ID:");
		deletepanel1.add(goodsLabel1);
		deletepanel1.add(ID_goodsField1);
		
		JButton selectButton = new JButton("查询");
		selectButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{

				if (ID_goodsField1.getText().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "商品ID不能为空", "警告",
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
						JOptionPane.showMessageDialog(null, "你所搜索的货物编号不存在",  "警告",
								JOptionPane.WARNING_MESSAGE);

					}
					else
					{
						goodsField1.setText(goods.getGoodsName());
						priceField1.setText(String.valueOf(goods.getPrice()));
						goodsdressField1.setText(goods.getProducePlace());
						ID_privoderField1.setText(goods.getProviderId());
						sizeField1.setText(goods.getSize());
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
		JLabel ID_goodsLabel1 = new JLabel("商品全称:");
		deletepanel2.add(ID_goodsLabel1);

		deletepanel2.add(goodsField1);
		JLabel priceLabel1 = new JLabel("单价:");
		deletepanel2.add(priceLabel1);

		deletepanel2.add(priceField1);

		JPanel deletepanel3 = new JPanel();
		JLabel goodsdressLabel1 = new JLabel("产地:         ");
		deletepanel3.add(goodsdressLabel1);

		deletepanel3.add(goodsdressField1);

		JPanel deletepanel4 = new JPanel();
		JLabel ID_privoderLabel1 = new JLabel("供应商号:");
		deletepanel4.add(ID_privoderLabel1);

		deletepanel4.add(ID_privoderField1);
		JLabel sizeLabel1 = new JLabel("规格:");
		deletepanel4.add(sizeLabel1);

		deletepanel4.add(sizeField1);

		JPanel deletepanel5 = new JPanel();
		JLabel packageLabel1 = new JLabel("包装:         ");
		deletepanel5.add(packageLabel1);

		deletepanel5.add(packageField1);
		JLabel productLabel1 = new JLabel("批号:");
		deletepanel5.add(productLabel1);

		deletepanel5.add(productField1);

		JPanel deletepanel6 = new JPanel();
		JLabel promitLabel1 = new JLabel("批准文号:");
		deletepanel6.add(promitLabel1);

		deletepanel6.add(promitField1);

		JPanel deletepanel7 = new JPanel();
		JLabel descriptionLabel1 = new JLabel("描述:         ");
		deletepanel7.add(descriptionLabel1);

		deletepanel7.add(decriptionField1);

		JPanel deletepanel8 = new JPanel();
		JButton deleteButton = new JButton("删除");
		deleteButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				if(ID_goodsField1.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "商品ID不能为空", "警告",
							JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					GoodsServicesHandler goodsServicesHandler=CommonFactory.getGoodsServices();
					if(goodsServicesHandler.deleteGoods(ID_goodsField1.getText())){
						JOptionPane.showMessageDialog(null, "恭喜你，删除成功！", "消息",
								JOptionPane.INFORMATION_MESSAGE);
						ID_goodsField1.setEditable(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "对不起，删除失败！", "警告",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		
		deletepanel8.add(deleteButton);
		JButton reButton1 = new JButton("取消");
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

		tabbedPane.addTab("商品删除信息", deletePanel);

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
