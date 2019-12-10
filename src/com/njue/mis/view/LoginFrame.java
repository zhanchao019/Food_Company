package com.njue.mis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.handler.OperatorServicesHandler;

public class LoginFrame extends JFrame implements ActionListener
{

	JTextField username;
	JPasswordField password;
	JButton submit;
	JButton cancel;

	public LoginFrame()
	{
		super("小超市进销存管理系统");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 3, screenSize.height / 3, 330, 230);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		submit = new JButton("确定");
		submit.addActionListener(this);

		cancel = new JButton("取消");
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});

		loginLayout();

		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e)
	{
		String usernameString = username.getText();
		String passwordString = String.valueOf(password.getPassword());

 		if (usernameString.trim().length() == 0)
		{
			JOptionPane.showMessageDialog(null, "用户名不能为空！","警告",JOptionPane.WARNING_MESSAGE);
		}
		else
			if (passwordString.trim().length() == 0)
			{
				JOptionPane.showMessageDialog(null, "密码不能为空！","警告",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				OperatorServicesHandler operator = CommonFactory
						.getOperatorServices();
				boolean isPass = operator.loginCheck(usernameString,
						passwordString);
				if (isPass)
				{
					MainFrame.username=usernameString;
					MainFrame.power=operator.getPower(usernameString);
					MainFrame.getMainFrame().setVisible(true);
					this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "登陆失败,用户名或密码错误！(如果在此弹窗之前已经有弹窗提示数据库有错误，那说明你数据库还没有配置好，请仔细按照视频教程配置好数据库了再运行，否则就是真的输错了登录名和密码)","警告",JOptionPane.WARNING_MESSAGE);
				}
			}
	}

	/**
	 * 窗体布局
	 */
	private void loginLayout()
	{
		JLabel name;
		JLabel passwordLabel;
		JPanel panel_center, panel_south;
		JLabel label;
		name = new JLabel("用户名:  ", JLabel.RIGHT);
		name.setForeground(new Color(0, 128, 255));
		passwordLabel = new JLabel("密码:  ", JLabel.RIGHT);
		passwordLabel.setForeground(new Color(0, 128, 255));
		username = new JTextField();
		username.setColumns(10);
		password = new JPasswordField();
		password.setColumns(10);
		password.setEchoChar('*');
		panel_center = new JPanel();
		panel_center.setLayout(new GridLayout(3, 1));
		panel_south = new JPanel();
		this.setLayout(new BorderLayout());
		this.setContentPane(new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				setDoubleBuffered(true);
				g.drawImage(new ImageIcon(LoginFrame.class.getResource("images/login.jpg"))
						.getImage(), 0, 0, null);
			}
		});
		for (int i = 0; i < 13; i++)
		{
			label = new JLabel();
			label.setPreferredSize(new Dimension(600, 1));
			this.getContentPane().add(label, BorderLayout.NORTH);
		}
		panel_center.add(name);
		panel_center.add(username);
		panel_center.add(passwordLabel);
		panel_center.add(password);
		label = new JLabel();
		label.setPreferredSize(new Dimension(70, 1));
		panel_south.add(label);
		panel_south.add(submit);
		panel_south.add(cancel);
		panel_center.setOpaque(false);
		panel_south.setOpaque(false);
		this.getContentPane().add(panel_center, BorderLayout.EAST);
		this.getContentPane().add(panel_south, BorderLayout.SOUTH);
	}
}
