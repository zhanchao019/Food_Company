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
import com.njue.mis.handler.CustomerServicesHandler;
import com.njue.mis.model.Customer;

public class CustomerFrame extends JInternalFrame
{
	JTextField custoField;
	JTextField customer_addressField;
	JTextField simple_custoField;
	JTextField customer_zipField;
	JTextField customer_teleField;
	JTextField customer_linkpField;
	JTextField customer_faxField;
	JTextField customer_linktField;
	JTextField customer_mailField;
	JTextField customer_bankField;
	JTextField customer_bankIDField;

	JTextField custoField1;
	JTextField customer_addressField1;
	JTextField simple_custoField1;
	JTextField customer_zipField1;
	JTextField customer_teleField1;
	JTextField customer_linkpField1;
	JTextField customer_faxField1;
	JTextField customer_linktField1;
	JTextField customer_mailField1;
	JTextField customer_bankField1;
	JTextField customer_bankIDField1;

	public CustomerFrame()
	{
		super("客户信息管理", true, true, false, true);
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
		 * 建立客户添加信息页面
		 */
		custoField = new JTextField(30);
		customer_addressField = new JTextField(30);
		simple_custoField = new JTextField(11);
		customer_zipField = new JTextField(11);
		customer_teleField = new JTextField(11);
		customer_linkpField = new JTextField(11);
		customer_faxField = new JTextField(11);
		customer_linktField = new JTextField(11);
		customer_mailField = new JTextField(30);
		customer_bankField = new JTextField(11);
		customer_bankIDField = new JTextField(11);
		JPanel addPanel = new JPanel();

		JPanel addpanel1 = new JPanel();
		JLabel custoLabel = new JLabel("客户全称:");
		addpanel1.add(custoLabel);

		addpanel1.add(custoField);

		JPanel addpanel2 = new JPanel();
		JLabel customer_addressLabel = new JLabel("客户地址:");
		addpanel2.add(customer_addressLabel);

		addpanel2.add(customer_addressField);

		JPanel addpanel3 = new JPanel();
		JLabel simple_custoLabel = new JLabel("客户编号:");
		addpanel3.add(simple_custoLabel);

		addpanel3.add(simple_custoField);
		JLabel customer_zipLabel = new JLabel("邮政编码:      ");
		addpanel3.add(customer_zipLabel);

		addpanel3.add(customer_zipField);

		JPanel addpanel4 = new JPanel();
		JLabel customer_teleLabel = new JLabel("电话:         ");
		addpanel4.add(customer_teleLabel);

		addpanel4.add(customer_teleField);
		JLabel customer_faxLabel = new JLabel("传真:               ");
		addpanel4.add(customer_faxLabel);

		addpanel4.add(customer_faxField);

		JPanel addpanel5 = new JPanel();
		JLabel customer_linkpLabel = new JLabel("联系人:    ");
		addpanel5.add(customer_linkpLabel);

		addpanel5.add(customer_linkpField);
		JLabel customer_linktLabel = new JLabel("联系电话:       ");
		addpanel5.add(customer_linktLabel);

		addpanel5.add(customer_linktField);

		JPanel addpanel6 = new JPanel();
		JLabel customer_mailLabel = new JLabel("电子邮件:");
		addpanel6.add(customer_mailLabel);

		addpanel6.add(customer_mailField);

		JPanel addpanel7 = new JPanel();
		JLabel customer_bankLabel = new JLabel("开户银行:");
		addpanel7.add(customer_bankLabel);

		addpanel7.add(customer_bankField);
		JLabel customer_bankIDLabel = new JLabel("银行账号:       ");
		addpanel7.add(customer_bankIDLabel);

		addpanel7.add(customer_bankIDField);

		JPanel addpanel8 = new JPanel();
		JButton saveButton = new JButton("保存");
		saveButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				if (simple_custoField.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "客户编号不能为空","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(custoField.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "客户全称不能为空！","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(customer_zipField.getText().length()!=0)
				{
					if (!ValidationManager.validateZip(customer_zipField.getText().trim()))
					{
						JOptionPane.showMessageDialog(null, "邮政编码不合法！","警告",JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if(customer_teleField.getText().length()!=0)
				{
					if (!ValidationManager.validatePhone(customer_teleField.getText().trim()))
					{
						JOptionPane.showMessageDialog(null, "电话号码不合法！","警告",JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if(customer_mailField.getText().length()!=0)
				{
					if (!ValidationManager.validateEmail(customer_mailField.getText().trim()))
					{
						JOptionPane.showMessageDialog(null, "电子邮件格式不合法！","警告",JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				CustomerServicesHandler handler = CommonFactory
						.getCustomerServices();
				if (handler.isExited(simple_custoField.getText()))
				{
					JOptionPane.showMessageDialog(null, "客户编号已存在！", "警告",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				else
				{
					if (handler.addCustomer(new Customer(simple_custoField
							.getText(), custoField.getText(), customer_zipField
							.getText(), customer_addressField.getText(),
							customer_teleField.getText()
									, customer_linkpField.getText(),
							customer_linktField.getText(),
									customer_bankField.getText(),
							customer_bankIDField.getText(),  customer_mailField.getText(),customer_faxField .getText())))
					{
						JOptionPane.showMessageDialog(null, "客户信息添加成功！", "消息",
								JOptionPane.INFORMATION_MESSAGE);
						setNull();
					}
					else
					{
						JOptionPane.showMessageDialog(null,
								"客户信息添加失败，请按要求输入信息！", "警告",
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
		tabbedPane.addTab("客户添加信息", addPanel);

		/*
		 * 建立客户删除信息页面
		 */
		custoField1 = new JTextField(11);
		customer_addressField1 = new JTextField(11);
		customer_addressField1.setEditable(false);
		simple_custoField1 = new JTextField(30);
		simple_custoField1.setEditable(false);
		customer_zipField1 = new JTextField(11);
		customer_zipField1.setEditable(false);
		customer_teleField1 = new JTextField(11);
		customer_teleField1.setEditable(false);
		customer_faxField1 = new JTextField(11);
		customer_faxField1.setEditable(false);
		customer_linkpField1 = new JTextField(11);
		customer_linkpField1.setEditable(false);
		customer_linktField1 = new JTextField(11);
		customer_linktField1.setEditable(false);
		customer_mailField1 = new JTextField(30);
		customer_mailField1.setEditable(false);
		customer_bankField1 = new JTextField(11);
		customer_bankField1.setEditable(false);
		customer_bankIDField1 = new JTextField(11);
		customer_bankIDField1.setEditable(false);

		JPanel deletePanel = new JPanel();

		JPanel deletepanel1 = new JPanel();
		JLabel custoLabel1 = new JLabel("客户ID:");
		deletepanel1.add(custoLabel1);
		deletepanel1.add(custoField1);

		JButton selectButton = new JButton("查询");
		deletepanel1.add(selectButton);
		selectButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				if (custoField1.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "客户ID不能为空", "警告",
							JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					CustomerServicesHandler customerServicesHandler = CommonFactory
							.getCustomerServices();
					Customer customer = customerServicesHandler
							.getCustomerInfo(custoField1.getText());
					if (customer.getAvailable() == 0)
					{
						JOptionPane.showMessageDialog(null, "你要搜索的ID不存在", "警告",
								JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						simple_custoField1.setText(customer.getName());
						customer_addressField1.setText(customer.getAddress());
						customer_zipField1.setText(customer.getZip());
						customer_teleField1.setText(customer.getTelephone());
						customer_faxField1.setText(customer.getFax());
						customer_linkpField1.setText(customer.getConnectionPerson());
						customer_linktField1.setText(customer.getPhone());
						customer_mailField1.setText(customer.getEmail());
						customer_bankField1.setText(customer.getBank());
						customer_bankIDField1.setText(customer.getAccount());
						custoField1.setEditable(false);
					}
				}

			}
		});

		JPanel deletepanel2 = new JPanel();
		JLabel simple_custoLabel1 = new JLabel("客户全称:");
		deletepanel2.add(simple_custoLabel1);

		deletepanel2.add(simple_custoField1);

		JPanel deletepanel3 = new JPanel();
		JLabel customer_addressLabel1 = new JLabel("客户地址:");
		deletepanel3.add(customer_addressLabel1);

		deletepanel3.add(customer_addressField1);
		JLabel zipLabel1 = new JLabel("邮政编码:      ");
		deletepanel3.add(zipLabel1);

		deletepanel3.add(customer_zipField1);

		JPanel deletepanel4 = new JPanel();
		JLabel teleLabel1 = new JLabel("电话:         ");
		deletepanel4.add(teleLabel1);

		deletepanel4.add(customer_teleField1);
		JLabel fexLabel1 = new JLabel("传真:               ");
		deletepanel4.add(fexLabel1);

		deletepanel4.add(customer_faxField1);

		JPanel deletepanel5 = new JPanel();
		JLabel linkpLabel1 = new JLabel("联系人:    ");
		deletepanel5.add(linkpLabel1);

		deletepanel5.add(customer_linkpField1);
		JLabel linktLabel1 = new JLabel("联系电话:       ");
		deletepanel5.add(linktLabel1);

		deletepanel5.add(customer_linktField1);

		JPanel deletepanel6 = new JPanel();
		JLabel mailLabel1 = new JLabel("电子邮件:");
		deletepanel6.add(mailLabel1);

		deletepanel6.add(customer_mailField1);

		JPanel deletepanel7 = new JPanel();
		JLabel bankLabel1 = new JLabel("开户银行:");
		deletepanel7.add(bankLabel1);

		deletepanel7.add(customer_bankField1);
		JLabel bankIDLabel1 = new JLabel("银行账号:       ");
		deletepanel7.add(bankIDLabel1);

		deletepanel7.add(customer_bankIDField1);

		JPanel deletepanel8 = new JPanel();
		JButton deleteButton1 = new JButton("删除");
		deleteButton1.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				if (custoField1.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "客户ID不能为空", "警告",
							JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					CustomerServicesHandler customerServicesHandler = CommonFactory
							.getCustomerServices();
					if (customerServicesHandler.deleteCustomer(custoField1
							.getText()))

					{
						JOptionPane.showMessageDialog(null, "删除成功", "消息",
								JOptionPane.INFORMATION_MESSAGE);
						custoField1.setEditable(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "删除失败", "警告",
								JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		deletepanel8.add(deleteButton1);
		JButton reButton1 = new JButton("取消");
		reButton1.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				custoField1.setEditable(true);
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

		tabbedPane.addTab("客户删除信息", deletePanel);

		return tabbedPane;
	}

	private void setNull()
	{
		simple_custoField.setText("");
		custoField.setText("");
		customer_zipField.setText("");
		customer_addressField.setText("");
		customer_linktField.setText("");
		customer_faxField.setText("");
		customer_linkpField.setText("");
		customer_linktField.setText("");
		customer_mailField.setText("");
		customer_bankField.setText("");
		customer_bankIDField.setText("");
		customer_teleField.setText("");
	}
}
