package com.njue.mis.view;

import com.njue.mis.common.CommonFactory;
import com.njue.mis.common.ValidationManager;
import com.njue.mis.handler.ProviderServicesHandler;
import com.njue.mis.model.Provider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProviderFrame extends JInternalFrame
{
	JTextField providerField;
	JTextField ID_providerField;
	JTextField provider_zipField;
	JTextField provider_addressField;
	JTextField provider_teleField;
	JTextField provider_faxField;
	JTextField provider_linkpField;
	JTextField provider_linktField;
	JTextField provider_mailField;
	JTextField provider_bankField;
	JTextField provider_bankIDField;

	JTextField providerField1;
	JTextField ID_providerField1;
	JTextField provider_zipField1;
	JTextField provider_addressField1;
	JTextField provider_teleField1;
	JTextField provider_faxField1;
	JTextField provider_linkpField1;
	JTextField provider_linktField1;
	JTextField provider_mailField1;
	JTextField provider_bankField1;
	JTextField provider_bankIDField1;

	public ProviderFrame()
	{
		super("��Ӧ�̹���", true, true, false, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 12, screenSize.height / 20,
				screenSize.width / 2, screenSize.height / 2);
		this.getContentPane().add(createTabbedPane());
	}

	public JTabbedPane createTabbedPane()
	{
		/*
		 * ���������
		 */
		JTabbedPane tabbedPane = new JTabbedPane();

		/*
		 * ������Ӧ�������Ϣҳ��
		 */

		providerField = new JTextField(30);
		ID_providerField = new JTextField(11);
		provider_zipField = new JTextField(11);
		provider_addressField = new JTextField(30);
		provider_teleField = new JTextField(11);
		provider_faxField = new JTextField(11);
		provider_linkpField = new JTextField(11);
		provider_linktField = new JTextField(11);
		provider_mailField = new JTextField(30);
		provider_bankField = new JTextField(11);
		provider_bankIDField = new JTextField(11);
		JPanel addPanel = new JPanel();

		JPanel addpanel1 = new JPanel();
		JLabel providerLabel = new JLabel("��Ӧ��ȫ��:");
		addpanel1.add(providerLabel);

		addpanel1.add(providerField);

		JPanel addpanel2 = new JPanel();
		JLabel ID_providerLabel = new JLabel("��Ӧ�̱��:");
		addpanel2.add(ID_providerLabel);

		addpanel2.add(ID_providerField);
		JLabel provider_zipLabel = new JLabel("��������:      ");
		addpanel2.add(provider_zipLabel);

		addpanel2.add(provider_zipField);

		JPanel addpanel3 = new JPanel();
		JLabel provider_addressLabel = new JLabel("��Ӧ�̵�ַ:");
		addpanel3.add(provider_addressLabel);

		addpanel3.add(provider_addressField);

		JPanel addpanel4 = new JPanel();
		JLabel provider_teleLabel = new JLabel("�绰:             ");
		addpanel4.add(provider_teleLabel);

		addpanel4.add(provider_teleField);
		JLabel provider_faxLabel = new JLabel("����:               ");
		addpanel4.add(provider_faxLabel);

		addpanel4.add(provider_faxField);

		JPanel addpanel5 = new JPanel();
		JLabel provider_linkpLabel = new JLabel("��ϵ��:         ");
		addpanel5.add(provider_linkpLabel);

		addpanel5.add(provider_linkpField);
		JLabel provider_linktLabel = new JLabel("��ϵ�绰:      ");
		addpanel5.add(provider_linktLabel);

		addpanel5.add(provider_linktField);

		JPanel addpanel6 = new JPanel();
		JLabel provider_mailLabel = new JLabel("�����ʼ�:     ");
		addpanel6.add(provider_mailLabel);

		addpanel6.add(provider_mailField);

		JPanel addpanel7 = new JPanel();
		JLabel provider_bankLabel = new JLabel("��������:     ");
		addpanel7.add(provider_bankLabel);

		addpanel7.add(provider_bankField);
		JLabel provider_bankIDLabel = new JLabel("�����˺�:       ");
		addpanel7.add(provider_bankIDLabel);

		addpanel7.add(provider_bankIDField);

		JPanel addpanel8 = new JPanel();
		JButton provider_saveButton = new JButton("����");
		provider_saveButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				if(ID_providerField.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "��Ӧ�̱�Ų���Ϊ�գ�","����",JOptionPane.WARNING_MESSAGE);
					return;
				}
						
				if(providerField.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "��Ӧ��ȫ�Ʋ���Ϊ�գ�","����",JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(provider_zipField.getText().length()!=0)
				{
					if (!ValidationManager.validateZip(provider_zipField.getText().trim()))
					{
						JOptionPane.showMessageDialog(null, "�������벻�Ϸ���","����",JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if(provider_teleField.getText().length()!=0)
				{
					if (!ValidationManager.validatePhone(provider_teleField.getText().trim()))
					{
						JOptionPane.showMessageDialog(null, "�绰���벻�Ϸ���","����",JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if (provider_mailField.getText().length() != 0)
				{
					if (!ValidationManager.validateEmail(provider_mailField
							.getText().trim()))
					{
						JOptionPane.showMessageDialog(null, "�����ʼ���ʽ���Ϸ���", "����",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
				}

				ProviderServicesHandler handler = CommonFactory
						.getProviderServices();
				if (handler.isExited(ID_providerField.getText()))
				{
					JOptionPane.showMessageDialog(null, "��Ӧ�̱���Ѵ��ڣ�", "����",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				else
					if (handler
							.addProvider(new Provider(ID_providerField
									.getText(), providerField.getText(),
									provider_zipField.getText(),
									provider_addressField.getText(),
									provider_teleField.getText(),
									provider_faxField.getText(),
									provider_linkpField.getText(),
									provider_linktField.getText(),
									provider_mailField.getText(),
									provider_bankField.getText(),
									provider_bankIDField.getText())))
					{
						JOptionPane.showMessageDialog(null, "��Ӧ����Ϣ��ӳɹ���", "��Ϣ",
								JOptionPane.INFORMATION_MESSAGE);
						setNull();
					}
					else
					{
						JOptionPane.showMessageDialog(null,
								"��Ӧ����Ϣ���ʧ�ܣ��밴Ҫ���������ݣ�", "����",
								JOptionPane.WARNING_MESSAGE);
					}
			}
		});
		addpanel8.add(provider_saveButton);

		JButton provider_reButton = new JButton("����");
		provider_reButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				setNull();
			}
		});
		addpanel8.add(provider_reButton);
		addPanel.add(addpanel1);
		addPanel.add(addpanel2);
		addPanel.add(addpanel3);
		addPanel.add(addpanel4);
		addPanel.add(addpanel5);
		addPanel.add(addpanel6);
		addPanel.add(addpanel7);
		addPanel.add(addpanel8);
		tabbedPane.addTab("��Ӧ�������Ϣ", addPanel);

		/*
		 * ������Ӧ��ɾ�����޸���Ϣҳ��
		 */
		providerField1 = new JTextField(11);
		providerField1.setEditable(false);
		ID_providerField1 = new JTextField(11);
		provider_zipField1 = new JTextField(11);
		provider_zipField1.setEditable(false);
		provider_addressField1 = new JTextField(30);
		provider_addressField1.setEditable(false);
		provider_teleField1 = new JTextField(11);
		provider_teleField1.setEditable(false);
		provider_faxField1 = new JTextField(11);
		provider_faxField1.setEditable(false);
		provider_linkpField1 = new JTextField(11);
		provider_linkpField1.setEditable(false);
		provider_linktField1 = new JTextField(11);
		provider_linktField1.setEditable(false);
		provider_mailField1 = new JTextField(30);
		provider_mailField1.setEditable(false);
		provider_bankField1 = new JTextField(11);
		provider_bankField1.setEditable(false);
		provider_bankIDField1 = new JTextField(11);
		provider_bankIDField1.setEditable(false);
		JPanel deletePanel = new JPanel();

		JPanel deletepanel1 = new JPanel();
		JLabel providerLabel1 = new JLabel("��Ӧ��ID:");
		deletepanel1.add(providerLabel1);
		deletepanel1.add(ID_providerField1);
		JButton selectButton = new JButton("��ѯ");
		deletepanel1.add(selectButton);
		selectButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				
				if (ID_providerField1.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "��Ӧ��ID����Ϊ��","����",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					ProviderServicesHandler providerServicesHandler=CommonFactory.getProviderServices();
					Provider provider=providerServicesHandler.getProviderInfo(ID_providerField1.getText());
					if(provider.getAvailable()==0)
					{
						JOptionPane.showMessageDialog(null, "��Ҫ������ID������","����",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						providerField1.setText(provider.getName());
						provider_zipField1.setText(provider.getZip());
						provider_addressField1.setText(provider.getAddress());
						provider_teleField1.setText(provider.getTelephone());
						provider_faxField1.setText(provider.getFax());
						provider_linkpField1.setText(provider.getConnectionPerson());
						provider_linktField1.setText(provider.getPhone());
						provider_mailField1.setText(provider.getEmail());
						provider_bankField1.setText(provider.getBank());
						provider_bankIDField1.setText(provider.getAccount());
						ID_providerField1.setEditable(false);
					}
				}

			}
		});

		JPanel deletepanel2 = new JPanel();
		JLabel ID_providerLabel1 = new JLabel("��Ӧ��ȫ��:");
		deletepanel2.add(ID_providerLabel1);

		deletepanel2.add(providerField1);
		JLabel provider_zipLabel1 = new JLabel("��������:      ");
		deletepanel2.add(provider_zipLabel1);

		deletepanel2.add(provider_zipField1);

		JPanel deletepanel3 = new JPanel();
		JLabel provider_addressLabel1 = new JLabel("��Ӧ�̵�ַ:");
		deletepanel3.add(provider_addressLabel1);

		deletepanel3.add(provider_addressField1);

		JPanel deletepanel4 = new JPanel();
		JLabel provider_teleLabel1 = new JLabel("�绰:             ");
		deletepanel4.add(provider_teleLabel1);

		deletepanel4.add(provider_teleField1);
		JLabel provider_faxLabel1 = new JLabel("����:               ");
		deletepanel4.add(provider_faxLabel1);

		deletepanel4.add(provider_faxField1);

		JPanel deletepanel5 = new JPanel();
		JLabel provider_linkpLabel1 = new JLabel("��ϵ��:         ");
		deletepanel5.add(provider_linkpLabel1);

		deletepanel5.add(provider_linkpField1);
		JLabel provider_linktLabel1 = new JLabel("��ϵ�绰:      ");
		deletepanel5.add(provider_linktLabel1);

		deletepanel5.add(provider_linktField1);

		JPanel deletepanel6 = new JPanel();
		JLabel provider_mailLabel1 = new JLabel("�����ʼ�:     ");
		deletepanel6.add(provider_mailLabel1);

		deletepanel6.add(provider_mailField1);

		JPanel deletepanel7 = new JPanel();
		JLabel provider_bankLabel1 = new JLabel("��������:     ");
		deletepanel7.add(provider_bankLabel1);

		deletepanel7.add(provider_bankField1);
		JLabel provider_bankIDLabel1 = new JLabel("�����˺�:       ");
		deletepanel7.add(provider_bankIDLabel1);

		deletepanel7.add(provider_bankIDField1);

		JPanel deletepanel8 = new JPanel();
		JButton provider_deleteButton1 = new JButton("ɾ��");
		provider_deleteButton1.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				if(ID_providerField1.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null, "��Ӧ��ID����Ϊ��","����",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					ProviderServicesHandler providerServicesHandler = CommonFactory.getProviderServices();
					if(providerServicesHandler.deleteProvider(ID_providerField1.getText())){
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
						providerServicesHandler.addLog(MainFrame.username, df.format(new Date()), (MainFrame.username), MainFrame.dept, "ɾ����Ӧ��" + ID_providerField1.getText() + "�ɹ����");
						JOptionPane.showMessageDialog(null, "��ϲ�㣬ɾ���ɹ���","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
						ID_providerField1.setEditable(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "�Բ���ɾ��ʧ�ܣ�","����",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
	
		deletepanel8.add(provider_deleteButton1);
		JButton provider_reButton1 = new JButton("ȡ��");
		provider_reButton1.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				ID_providerField1.setEditable(true);
				dispose();
			}
		});
		deletepanel8.add(provider_reButton1);

		deletePanel.add(deletepanel1);
		deletePanel.add(deletepanel2);
		deletePanel.add(deletepanel3);
		deletePanel.add(deletepanel4);
		deletePanel.add(deletepanel5);
		deletePanel.add(deletepanel6);
		deletePanel.add(deletepanel7);
		deletePanel.add(deletepanel8);
		tabbedPane.addTab("��Ӧ����Ϣɾ��", deletePanel);
		ProviderInforSearchFrame tmp = new ProviderInforSearchFrame();
		PrivoderInforSearchPanel a = tmp.getPrivoderInforSearchPanel();


		tabbedPane.addTab("��ѯ��Ӧ����Ϣ", a);
		return tabbedPane;
	}

	private void setNull()
	{
		ID_providerField.setText("");
		providerField.setText("");
		provider_zipField.setText("");
		provider_addressField.setText("");
		provider_teleField.setText("");
		provider_linktField.setText("");
		provider_faxField.setText("");
		provider_linkpField.setText("");
		provider_mailField.setText("");
		provider_bankField.setText("");
		provider_bankIDField.setText("");
	}
}
