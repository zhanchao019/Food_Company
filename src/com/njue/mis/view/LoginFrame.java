package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.handler.OperatorServicesHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {

	JTextField username;
	JPasswordField password;
	JButton submit;
	JButton cancel;
	JComboBox department;

	public LoginFrame() {
		super("ʳƷ��˾����ϵͳ");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 3, screenSize.height / 3, 330, 230);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		submit = new JButton("ȷ��");
		submit.addActionListener(this);

		department = new JComboBox();
		String[] selected = {"����Ա", "���۲�", "����", "��Ʒ��", "ԭ�Ͽ�", "��������", "�����ƻ���"};
		department.setModel(new DefaultComboBoxModel(selected));
		department.setBounds(15, 15, 100, 25);

		cancel = new JButton("ȡ��");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		loginLayout();

		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String usernameString = username.getText();
		String passwordString = String.valueOf(password.getPassword());
		String selected_department = department.getSelectedItem().toString().trim();
		System.out.println(selected_department);
		if (usernameString.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�", "����", JOptionPane.WARNING_MESSAGE);
		} else if (passwordString.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�", "����", JOptionPane.WARNING_MESSAGE);
		} else {
			OperatorServicesHandler operator = CommonFactory
					.getOperatorServices();
			boolean isPass = operator.loginCheck(usernameString,
					passwordString, selected_department);
			if (isPass) {
				/*
				MainFrame.username = usernameString;
				MainFrame.power = operator.getPower(usernameString);
				MainFrame.getMainFrame().setVisible(true);
				this.setVisible(false);
				*/

				switch (selected_department) {//�������Բ�ͬ�Ĳ��Ž�����Ʋ�ͬ����ʾ��
					//"����Ա", "���۲�", "����", "��Ʒ��", "ԭ�Ͽ�", "��������", "�����ƻ���"
					case "����Ա":
						MainFrame.username = usernameString;
						MainFrame.power = operator.getPower(usernameString);
						MainFrame.getMainFrame().setVisible(true);
						break;
					case "���۲�":
						SaleDeptFrame.username = usernameString;
						SaleDeptFrame.power = operator.getPower(usernameString);
						SaleDeptFrame.getSaleDeptFrame().setVisible(true);
						break;
					case "����":
						CounterDeptFrame.username = usernameString;
						CounterDeptFrame.power = operator.getPower(usernameString);
						CounterDeptFrame.getCounterDeptFrame().setVisible(true);
						break;
					case "��Ʒ��":
						System.out.print("��Ʒ");
						ChengpinDeptFrame.username = usernameString;
						ChengpinDeptFrame.power = operator.getPower(usernameString);
						System.out.print("��Ʒ");
						ChengpinDeptFrame.getChengpinDeptFrame().setVisible(true);
						break;
					case "ԭ�Ͽ�":
						RawDeptFrame.username = usernameString;
						RawDeptFrame.power = operator.getPower(usernameString);
						RawDeptFrame.getSaleDeptFrame().setVisible(true);
						break;
					case "��������":
						ProducingDeptFrame.username = usernameString;
						ProducingDeptFrame.power = operator.getPower(usernameString);
						ProducingDeptFrame.getProducingDeptFrame().setVisible(true);
						break;
					case "�����ƻ���":
						ScheduleDeptFrame.username = usernameString;
						ScheduleDeptFrame.power = operator.getPower(usernameString);
						ScheduleDeptFrame.getScheduleDeptFrame().setVisible(true);
						break;


				}
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "��½ʧ��,�û������������)", "����", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	/**
	 * ���岼��
	 */
	private void loginLayout() {
		JLabel name;
		JLabel passwordLabel;
		JPanel panel_center, panel_south;
		JLabel label;
		JLabel departmentLabel;
		name = new JLabel("�û���:  ", JLabel.RIGHT);
		name.setForeground(new Color(0, 128, 255));
		passwordLabel = new JLabel("����:  ", JLabel.RIGHT);
		departmentLabel = new JLabel("����:  ", JLabel.RIGHT);
		departmentLabel.setForeground(new Color(0, 128, 255));
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
		panel_center.add(departmentLabel);
		panel_center.add(department);
		panel_south.add(submit);
		panel_south.add(cancel);


		panel_center.setOpaque(false);
		panel_south.setOpaque(false);
		this.getContentPane().add(panel_center, BorderLayout.EAST);
		this.getContentPane().add(panel_south, BorderLayout.SOUTH);
	}
}
