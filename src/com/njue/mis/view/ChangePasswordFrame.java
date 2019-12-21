package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.handler.OperatorServicesHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangePasswordFrame extends JInternalFrame
{

	JLabel label_user, label_old_password, label_new_password,
			label_repassword;
	JTextField user;
	JPasswordField old_password, new_password, repassword;
	JLabel empty1, empty2, empty3, empty4, empty5;
	JButton change, cancel;
	public ChangePasswordFrame()
	{
		super("��������", true, true, false, true);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 8, screenSize.height / 12,
				screenSize.width *2/8, screenSize.height *2/5);
		label_user = new JLabel("�û�����        ");

		label_old_password = new JLabel("�����룺        ");
		label_new_password = new JLabel("�����룺        ");
		label_repassword = new JLabel("�ظ������룺");
		empty1 = new JLabel();
		empty2 = new JLabel();
		empty3 = new JLabel();
		empty4 = new JLabel();
		empty5 = new JLabel();
		user = new JTextField(10);
		user.setEditable(false);
		user.setText(MainFrame.username);

		old_password = new JPasswordField(10);
		new_password = new JPasswordField(10);
		repassword = new JPasswordField(10);
		old_password.setEchoChar('*');
		new_password.setEchoChar('*');
		repassword.setEchoChar('*');
		
		change = new JButton("�޸�");
		change.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				String oldPasswordString = String.valueOf(old_password
						.getPassword());
				String newPasswordString = String.valueOf(new_password
						.getPassword());
				String rePasswordString = String.valueOf(repassword
						.getPassword());
				if (oldPasswordString.trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "�����벻��Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
				}
				else
					if (newPasswordString.trim().length() == 0)
					{
						JOptionPane.showMessageDialog(null, "�����벻��Ϊ�գ�", "����",
								JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						OperatorServicesHandler operator = CommonFactory
								.getOperatorServices();

						if (oldPasswordString.equals(operator.getPassword(MainFrame.username)))
						{
							if (newPasswordString.equals(rePasswordString))
							{
                                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
                                operator.addLog(MainFrame.username, df.format(new Date()), operator.getPower(MainFrame.username), MainFrame.dept, "��������ɹ�");
								operator.modifyPassword(MainFrame.username, newPasswordString);
								JOptionPane.showMessageDialog(null,
										"��ϲ�㣬�������޸ĳɹ���", "��Ϣ",
										JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
							else
							{
                                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
                                operator.addLog(MainFrame.username, df.format(new Date()), operator.getPower(MainFrame.username), MainFrame.dept, "��������ʧ��");
								JOptionPane.showMessageDialog(null,
										"��������ͬ�����룡", "����",
										JOptionPane.WARNING_MESSAGE);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "�����벻��ȷ��",
									"����", JOptionPane.WARNING_MESSAGE);
						}

					}
			}
		});
		cancel = new JButton("ȡ��");
		cancel.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			dispose();
		}});
		empty1.setPreferredSize(new Dimension(600, 20));
		empty2.setPreferredSize(new Dimension(600, 5));
		empty3.setPreferredSize(new Dimension(600, 5));
		empty4.setPreferredSize(new Dimension(600, 5));
		empty5.setPreferredSize(new Dimension(600, 30));

		this.setLayout(new FlowLayout());
		this.add(empty1);
		this.add(label_user);
		this.add(user);


		this.add(empty2);
		this.add(label_old_password);
		this.add(old_password);
		this.add(empty3);
		this.add(label_new_password);
		this.add(new_password);
		this.add(empty4);
		this.add(label_repassword);
		this.add(repassword);
		this.add(empty5);
		this.add(change);
		this.add(cancel);
	}
}
