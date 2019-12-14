package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.handler.OperatorServicesHandler;
import com.njue.mis.model.Operator;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class OperaterManagerFrame extends JInternalFrame
{

	public String dept1;
	JComboBox deptbox;
	JTabbedPane power_operator;
	JLabel login_name, operator_name, password, repassword, power;
	JLabel del_operator, del_name, del_power;
	JTextField text_login_name;
	JTextField text_operator_name;
	JPasswordField text_password;
	JPasswordField text_repassword;
	JButton sure;
	JButton cancel;
	JButton del_sure;
	JButton del_cancel;
	JButton check;
	int count = 0;
	JPanel add_panel;
	JPanel delete_panel;
	JTextField del_operator_name;
	JTextField text_del_power;
	JComboBox jcbpower, jcbname;
	JLabel empty1, empty2, empty3, empty4, empty5, empty6, empty7, empty8,
			empty9, empty10;

	public OperaterManagerFrame(String dept1)
	{
		super("����Ա����", true, true, false, true);
		power_operator = new JTabbedPane();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 8, screenSize.height / 12,
				screenSize.width *2/5, screenSize.height *2/5);

		login_name = new JLabel(" ��¼��:        ", JLabel.LEFT);
		operator_name = new JLabel("ע��������:", JLabel.LEFT);
		password = new JLabel("��������:    ", JLabel.LEFT);
		repassword = new JLabel("ȷ������:    ", JLabel.LEFT);
		power = new JLabel("Ȩ������");

		empty1 = new JLabel();
		empty2 = new JLabel();
		empty3 = new JLabel();
		empty4 = new JLabel();
		empty5 = new JLabel();
		empty6 = new JLabel();
		empty7 = new JLabel();
		empty8 = new JLabel();
		empty9 = new JLabel();
		empty10 = new JLabel();
		del_operator = new JLabel("ɾ������Ա��");
		del_name = new JLabel("����Ա������");
		del_power = new JLabel("����ԱȨ�ޣ�");
		text_del_power = new JTextField(10);
		text_del_power.setEditable(false);
		del_operator_name = new JTextField(10);
		del_operator_name.setEditable(false);
		text_login_name = new JTextField(11);
		text_operator_name = new JTextField(20);
		text_password = new JPasswordField(20);
		text_repassword = new JPasswordField(20);
		text_password.setEchoChar('*');
		text_repassword.setEchoChar('*');
		check = new JButton("����û���");
		sure = new JButton("���");
		cancel = new JButton("ȡ��");
		del_sure = new JButton("ɾ��");
		del_cancel = new JButton("ȡ��");
		add_panel = new JPanel();
		delete_panel = new JPanel();

		jcbpower = new JComboBox();
		jcbpower.addItem("����Ա");
		jcbpower.addItem("����Ա");
		jcbname = new JComboBox();
		deptbox = new JComboBox();
		if (dept1 == "����Ա") {
			deptbox.addItem("����Ա");
			deptbox.addItem("���۲�");
			deptbox.addItem("����");
			deptbox.addItem("��Ʒ��");
			deptbox.addItem("ԭ�Ͽ�");
			deptbox.addItem("��������");
			deptbox.addItem("�����ƻ���");
		} else {
			deptbox.addItem(dept1);
		}



		add_panel.setLayout(new FlowLayout());
		empty1.setPreferredSize(new Dimension(screenSize.width * 2 / 5, 1));
		empty2.setPreferredSize(new Dimension(screenSize.width * 2 / 5, 1));
		empty3.setPreferredSize(new Dimension(screenSize.width * 2 / 5, 1));
		empty4.setPreferredSize(new Dimension(screenSize.width * 2 / 5, 1));
		empty5.setPreferredSize(new Dimension(screenSize.width * 2 / 5, 1));
		empty6.setPreferredSize(new Dimension(screenSize.width * 2 / 5, 20));
		empty7.setPreferredSize(new Dimension(screenSize.width * 2 / 5, 20));
		empty8.setPreferredSize(new Dimension(screenSize.width * 2 / 5, 20));
		empty9.setPreferredSize(new Dimension(screenSize.width * 2 / 5, 20));
		empty10.setPreferredSize(new Dimension(screenSize.width * 2 / 5, 30));
		add_panel.add(empty1);
		add_panel.add(login_name);
		add_panel.add(text_login_name);
		add_panel.add(check);
		add_panel.add(empty2);
		add_panel.add(operator_name);
		add_panel.add(text_operator_name);
		add_panel.add(empty3);
		add_panel.add(password);
		add_panel.add(text_password);
		add_panel.add(empty4);
		add_panel.add(repassword);
		add_panel.add(text_repassword);
		add_panel.add(empty5);
		add_panel.add(new JLabel("�������"));
		add_panel.add(empty5);
		add_panel.add(jcbpower);

		add_panel.add(deptbox);
		add_panel.add(empty5);

		add_panel.add(empty6);
		add_panel.add(sure);
		add_panel.add(cancel);
		delete_panel.add(empty9);
		delete_panel.add(del_operator);
		delete_panel.add(jcbname);
		delete_panel.add(empty7);
		delete_panel.add(del_name);
		delete_panel.add(del_operator_name);
		delete_panel.add(empty8);
		delete_panel.add(del_power);
		delete_panel.add(text_del_power);
		delete_panel.add(empty10);
		delete_panel.add(del_sure);
		delete_panel.add(del_cancel);

		add_panel.setVisible(true);
		delete_panel.setVisible(true);

		power_operator.addTab("��Ӳ���Ա", add_panel);
		power_operator.addTab("ɾ������Ա", delete_panel);
		jcbname.addItem("��ѡ���û�");
		this.getContentPane().add(power_operator);

		check.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				String loginnameString = text_login_name.getText();
				if (loginnameString.trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "����",
							JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					OperatorServicesHandler operator = CommonFactory
							.getOperatorServices();
					if (operator.isExited(loginnameString))
					{
						JOptionPane.showMessageDialog(null, "�û����Ѵ���", "����",
								JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "��ϲ�㣬���û�������", "��Ϣ",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}

			}
		});

		sure.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				String loginnameString = text_login_name.getText();
				String operatorNameString = text_operator_name.getText();
				String passwordString = String.valueOf(text_password
						.getPassword());
				String repasswordString = String.valueOf(text_repassword
						.getPassword());
				String powerString = jcbpower.getSelectedItem().toString();
				if (loginnameString.trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "����",
							JOptionPane.WARNING_MESSAGE);
				}
				else if (operatorNameString.trim().length() == 0){
					JOptionPane.showMessageDialog(null, "��������Ϊ��", "����",
							JOptionPane.WARNING_MESSAGE);
				}
				else if (passwordString.trim().length() == 0){
					JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "����",
							JOptionPane.WARNING_MESSAGE);
				}
				else if (repasswordString.trim().length() == 0){
					JOptionPane.showMessageDialog(null, "������ȷ������", "����",
							JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					if (passwordString.equals(repasswordString))
					{
						OperatorServicesHandler addOperator = CommonFactory
								.getOperatorServices();
						if (addOperator.isExited(loginnameString))
						{
							JOptionPane.showMessageDialog(null, "�û����Ѵ���", "����",
									JOptionPane.WARNING_MESSAGE);
						}
						else
							if (addOperator.addOperator(new Operator(
									loginnameString, passwordString,
									operatorNameString, powerString)))
							{
								JOptionPane.showMessageDialog(null, "��ϲ�㣬���"
										+ powerString + "�ѳɹ���", "��Ϣ",
										JOptionPane.INFORMATION_MESSAGE);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "�Բ������"
										+ powerString + "ʧ�ܣ����������룡", "��Ϣ",
										JOptionPane.INFORMATION_MESSAGE);
							}

					}
					else
					{
						JOptionPane.showMessageDialog(null, "������������벻һ��", "����",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		cancel.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		del_sure.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				OperatorServicesHandler operator = CommonFactory
						.getOperatorServices();
				String usernameString = jcbname.getSelectedItem().toString();
				if (usernameString.equals("��ѡ���û�"))
				{
					JOptionPane.showMessageDialog(null, "��ѡ���û���", "��Ϣ",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (operator.deleteOperator(usernameString))
					{
						JOptionPane.showMessageDialog(null, "��ϲ�㣬ɾ���ɹ���", "��Ϣ",
								JOptionPane.INFORMATION_MESSAGE);
						jcbname.removeAllItems();
						jcbname.addItem("��ѡ���û�");
						Vector<Operator> operatorsVector = operator
								.getOperator("����Ա");
						for (Operator o : operatorsVector)
						{
							jcbname.addItem(o.getUserName());
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "�Բ���ɾ��ʧ�ܣ�", "��Ϣ",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}

			}
		});
		del_cancel.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});

		power_operator.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				JTabbedPane tabbedPanel = (JTabbedPane) e.getSource();

				if (((JPanel) tabbedPanel.getSelectedComponent())
						.equals(delete_panel))
				{
					jcbname.removeAllItems();
					jcbname.addItem("��ѡ���û�");
					OperatorServicesHandler operator = CommonFactory
							.getOperatorServices();
					Vector<Operator> operatorsVector = operator
							.getOperator("����Ա");
					for (Operator o : operatorsVector)
					{
						jcbname.addItem(o.getUserName());
					}
				}
			}
		});

		jcbname.addItemListener(new ItemListener()
		{

			public void itemStateChanged(ItemEvent e)
			{
				OperatorServicesHandler operator = CommonFactory
						.getOperatorServices();
				if (jcbname.getSelectedItem() != null)
				{
					Operator oprt = operator.getOperatorInfo(jcbname
							.getSelectedItem().toString());
					del_operator_name.setText(oprt.getName());
					text_del_power.setText(oprt.getPower());
				}
			}
		});
	}

	public void setdept(String tmp) {
		dept1 = tmp;
	}
}
