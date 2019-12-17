package com.njue.mis.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainFrame extends JFrame
{
	public static String power;
	public static String username;
	public static String dept;
	private JDesktopPane desktopPane;
	private static MainFrame mainFrame;
	private Timer time;
	/**
	 * ����������
	 */
	private MainFrame() {
		super("ʳƷ��˾����ϵͳ");
		time = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("                    ��ǰ��½��Ա�� " + power + "   		" + username + new SimpleDateFormat("yyyy��MM��dd�� EEEE hh:mm:ss").format(new Date()));

				setTitle("ʳƷ��˾����ϵͳ                    ��ǰ��½��Ա��  " + power + "		   " + username + "		" + new SimpleDateFormat("yyyy��MM��dd�� EEEE hh:mm:ss").format(new Date()));
			}
		});
		time.start();

		System.out.print("show main frame");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width / 6, screenSize.height / 6, screenSize.width * 2 / 3,
				screenSize.height * 2 / 3);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		desktopPane = new JDesktopPane();

		desktopPane.setOpaque(true);

		this.setContentPane(desktopPane);
		this.setJMenuBar(createMenuBar());

		//Set up the backgound image,���������汳����ɫ
		desktopPane.setBackground(new Color(56, 142, 143));
		// Make dragging a little faster but perhaps uglier.
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);


	}

	public static MainFrame getMainFrame()
	{
		if(mainFrame==null)
		{
			mainFrame=new MainFrame();
		}
		return mainFrame;
	}

	/**
	 * ����������Ĳ˵���
	 * 
	 * @return JMenuBar
	 */
	protected JMenuBar createMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();

		// Set up the info menu.
		JMenu menu = new JMenu("������Ϣ����");
		menuBar.add(menu);
		JMenuItem menuItem = new JMenuItem("�ͻ���Ϣ����");
		menuItem.addActionListener(MainAction.clickCustomerInfoManager());
		menu.add(menuItem);
		menuItem = new JMenuItem("��Ʒ��Ϣ����");
		menuItem.addActionListener(MainAction.clickGoodsInfoManager());
		menu.add(menuItem);
		menuItem = new JMenuItem("��Ӧ����Ϣ����");
		menuItem.addActionListener(MainAction.clickProviderInfoManager());
		menu.add(menuItem);


		// Set up the inport menu.
		/*
		menu = new JMenu("��������");
		menuBar.add(menu);
		menuItem = new JMenuItem("������");
		menuItem.addActionListener(MainAction.importGoods());
		menu.add(menuItem);
		menuItem = new JMenuItem("�˻���");
		menuItem.addActionListener(MainAction.outportGoods());
		menu.add(menuItem);

*/
		// Set up the sales menu.
		menu = new JMenu("���۹���");
		menuBar.add(menu);
		menuItem = new JMenuItem("���۵�");
		menuItem.addActionListener(MainAction.sales());
		menu.add(menuItem);
		/*menuItem = new JMenuItem("�˻���");
		menuItem.addActionListener(MainAction.salesBack());
		menu.add(menuItem);
*/
		// Set up the counter menu.
		menu = new JMenu("�������");
		menuBar.add(menu);
		menuItem = new JMenuItem("���۵��ɷ�");
		menuItem.addActionListener(MainAction.clickCounterInfoSearch());
		menu.add(menuItem);

        // Set up the production schedule dept menu.
		menu = new JMenu("�����ƻ�����");
		menuBar.add(menu);
		menuItem = new JMenuItem("�����ƻ�");
		menuItem.addActionListener(MainAction.clickScheduleInfoSearch());
		menu.add(menuItem);

        //set up the producing dept menu
        menu = new JMenu("�����������");
        menuBar.add(menu);
        menuItem = new JMenuItem("��������");
        menuItem.addActionListener(MainAction.clickProducingInfoManager());
		menu.add(menuItem);




        // Set up the select menu.
		menu = new JMenu("��ѯ����");
		menuBar.add(menu);
		menuItem = new JMenuItem("�ͻ���ѯ");
		menuItem.addActionListener(MainAction.clickCustomerInforserch());
		menu.add(menuItem);
		menuItem = new JMenuItem("��Ʒ��ѯ");
		menuItem.addActionListener(MainAction.clickGoodsInforserch());
		menu.add(menuItem);
		menuItem = new JMenuItem("��Ӧ�̲�ѯ");
		menuItem.addActionListener(MainAction.clickPrivoderInforSearch());
		menu.add(menuItem);
		menuItem = new JMenuItem("���۲�ѯ");
		menuItem.addActionListener(MainAction.clickSaleInforSearch());
		menu.add(menuItem);
		menuItem = new JMenuItem("�����˻���ѯ");
		menuItem.addActionListener(MainAction.clickSaleBackInforSearch());
		menu.add(menuItem);
		menuItem = new JMenuItem("����ѯ");
		menuItem.addActionListener(MainAction.clickInputInforserch());
		menu.add(menuItem);
		menuItem = new JMenuItem("����˻���ѯ");
		menuItem.addActionListener(MainAction.clickOutputInforserch());
		menu.add(menuItem);

		// Set up the save menu.
		menu = new JMenu("������");
		menuBar.add(menu);
		menuItem = new JMenuItem("����̵�");
		menuItem.addActionListener(MainAction.storeHouseInfor());
		menu.add(menuItem);
		menuItem = new JMenuItem("�۸����");
		menuItem.addActionListener(MainAction.priceChange());
		menu.add(menuItem);

//		 Set up the system menu.
		menu = new JMenu("ϵͳ����");
		menuBar.add(menu);
		menuItem = new JMenuItem("��������");
		menuItem.addActionListener(MainAction.changePassword());
		menu.add(menuItem);
		if (power.equals("����Ա"))
		{
			menuItem = new JMenuItem("����Ա����");
			menuItem.addActionListener(MainAction.operaterManager());
			menu.add(menuItem);
		}
		else if(power.equals("����Ա"))
		{
		}
		else
		{
			JOptionPane.showMessageDialog(null, "�Ƿ��û�������","����",JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		return menuBar;
	}
}
