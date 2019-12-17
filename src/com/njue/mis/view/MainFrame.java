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
	 * 创建主窗体
	 */
	private MainFrame() {
		super("食品公司管理系统");
		time = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("                    当前登陆人员： " + power + "   		" + username + new SimpleDateFormat("yyyy年MM月dd日 EEEE hh:mm:ss").format(new Date()));

				setTitle("食品公司管理系统                    当前登陆人员：  " + power + "		   " + username + "		" + new SimpleDateFormat("yyyy年MM月dd日 EEEE hh:mm:ss").format(new Date()));
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

		//Set up the backgound image,设置主界面背景颜色
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
	 * 创建主窗体的菜单栏
	 * 
	 * @return JMenuBar
	 */
	protected JMenuBar createMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();

		// Set up the info menu.
		JMenu menu = new JMenu("基础信息管理");
		menuBar.add(menu);
		JMenuItem menuItem = new JMenuItem("客户信息管理");
		menuItem.addActionListener(MainAction.clickCustomerInfoManager());
		menu.add(menuItem);
		menuItem = new JMenuItem("商品信息管理");
		menuItem.addActionListener(MainAction.clickGoodsInfoManager());
		menu.add(menuItem);
		menuItem = new JMenuItem("供应商信息管理");
		menuItem.addActionListener(MainAction.clickProviderInfoManager());
		menu.add(menuItem);


		// Set up the inport menu.
		/*
		menu = new JMenu("进货管理");
		menuBar.add(menu);
		menuItem = new JMenuItem("进货单");
		menuItem.addActionListener(MainAction.importGoods());
		menu.add(menuItem);
		menuItem = new JMenuItem("退货单");
		menuItem.addActionListener(MainAction.outportGoods());
		menu.add(menuItem);

*/
		// Set up the sales menu.
		menu = new JMenu("销售管理");
		menuBar.add(menu);
		menuItem = new JMenuItem("销售单");
		menuItem.addActionListener(MainAction.sales());
		menu.add(menuItem);
		/*menuItem = new JMenuItem("退货单");
		menuItem.addActionListener(MainAction.salesBack());
		menu.add(menuItem);
*/
		// Set up the counter menu.
		menu = new JMenu("财务管理");
		menuBar.add(menu);
		menuItem = new JMenuItem("销售单缴费");
		menuItem.addActionListener(MainAction.clickCounterInfoSearch());
		menu.add(menuItem);

        // Set up the production schedule dept menu.
		menu = new JMenu("生产计划管理");
		menuBar.add(menu);
		menuItem = new JMenuItem("生产计划");
		menuItem.addActionListener(MainAction.clickScheduleInfoSearch());
		menu.add(menuItem);

        //set up the producing dept menu
        menu = new JMenu("生产车间管理");
        menuBar.add(menu);
        menuItem = new JMenuItem("生产车间");
        menuItem.addActionListener(MainAction.clickProducingInfoManager());
		menu.add(menuItem);




        // Set up the select menu.
		menu = new JMenu("查询管理");
		menuBar.add(menu);
		menuItem = new JMenuItem("客户查询");
		menuItem.addActionListener(MainAction.clickCustomerInforserch());
		menu.add(menuItem);
		menuItem = new JMenuItem("商品查询");
		menuItem.addActionListener(MainAction.clickGoodsInforserch());
		menu.add(menuItem);
		menuItem = new JMenuItem("供应商查询");
		menuItem.addActionListener(MainAction.clickPrivoderInforSearch());
		menu.add(menuItem);
		menuItem = new JMenuItem("销售查询");
		menuItem.addActionListener(MainAction.clickSaleInforSearch());
		menu.add(menuItem);
		menuItem = new JMenuItem("销售退货查询");
		menuItem.addActionListener(MainAction.clickSaleBackInforSearch());
		menu.add(menuItem);
		menuItem = new JMenuItem("入库查询");
		menuItem.addActionListener(MainAction.clickInputInforserch());
		menu.add(menuItem);
		menuItem = new JMenuItem("入库退货查询");
		menuItem.addActionListener(MainAction.clickOutputInforserch());
		menu.add(menuItem);

		// Set up the save menu.
		menu = new JMenu("库存管理");
		menuBar.add(menu);
		menuItem = new JMenuItem("库存盘点");
		menuItem.addActionListener(MainAction.storeHouseInfor());
		menu.add(menuItem);
		menuItem = new JMenuItem("价格调整");
		menuItem.addActionListener(MainAction.priceChange());
		menu.add(menuItem);

//		 Set up the system menu.
		menu = new JMenu("系统管理");
		menuBar.add(menu);
		menuItem = new JMenuItem("更改密码");
		menuItem.addActionListener(MainAction.changePassword());
		menu.add(menuItem);
		if (power.equals("管理员"))
		{
			menuItem = new JMenuItem("操作员管理");
			menuItem.addActionListener(MainAction.operaterManager());
			menu.add(menuItem);
		}
		else if(power.equals("操作员"))
		{
		}
		else
		{
			JOptionPane.showMessageDialog(null, "非法用户！！！","警告",JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		return menuBar;
	}
}
