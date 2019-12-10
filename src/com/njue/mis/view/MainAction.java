package com.njue.mis.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainAction
{
	public static ActionListener clickCustomerInfoManager()
	{

		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CustomerFrame customerFrame = new CustomerFrame();
				MainFrame.getMainFrame().getContentPane().add(customerFrame);
				customerFrame.setVisible(true);
			}
		};
	}

	public static ActionListener clickGoodsInfoManager()
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GoodsFrame goodsFrame = new GoodsFrame();
				MainFrame.getMainFrame().getContentPane().add(goodsFrame);
				goodsFrame.setVisible(true);
			}
		};
	}

	public static ActionListener clickProviderInfoManager()
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ProviderFrame privoderFrame = new ProviderFrame();
				MainFrame.getMainFrame().getContentPane().add(privoderFrame);
				privoderFrame.setVisible(true);
			}
		};
	}

	public static ActionListener clickCustomerInforserch()
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CustomerInforSearchFrame customerInforSearchFrame = new CustomerInforSearchFrame();
				MainFrame.getMainFrame().getContentPane().add(
						customerInforSearchFrame);
				customerInforSearchFrame.setVisible(true);
			}
		};
	}
	
	public static ActionListener clickGoodsInforserch()
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GoodsInforSearchFrame goodsInforSearchFrame = new GoodsInforSearchFrame();
				MainFrame.getMainFrame().getContentPane().add(
						goodsInforSearchFrame);
				goodsInforSearchFrame.setVisible(true);
			}
		};
	}
	
	public static ActionListener clickInputInforserch()
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				InputInforSearchFrame inputInforSearchFrame = new InputInforSearchFrame();
				MainFrame.getMainFrame().getContentPane().add(
						inputInforSearchFrame);
				inputInforSearchFrame.setVisible(true);
			}
		};
	}
	
	public static ActionListener clickOutputInforserch()
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				OutputInforSearchFrame outputInforSearchFrame = new OutputInforSearchFrame();
				MainFrame.getMainFrame().getContentPane().add(
						outputInforSearchFrame);
				outputInforSearchFrame.setVisible(true);
			}
		};
	}
	
	public static ActionListener clickPrivoderInforSearch()
	{
		return new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				ProviderInforSearchFrame privoderInforSearchFrame = new ProviderInforSearchFrame();
				MainFrame.getMainFrame().getContentPane().add(
						privoderInforSearchFrame);
				privoderInforSearchFrame.setVisible(true);
			}
		};
	}
	
	public static ActionListener clickSaleBackInforSearch()
	{
		return new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				SaleBackInforSearchFrame saleBackInforSearchFrame = new SaleBackInforSearchFrame();
				MainFrame.getMainFrame().getContentPane().add(
						saleBackInforSearchFrame);
				saleBackInforSearchFrame.setVisible(true);
			}
		};
	}
	
	public static ActionListener clickSaleInforSearch()
	{
		return new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				SaleInforSearchFrame saleInforSearchFrame = new SaleInforSearchFrame();
				MainFrame.getMainFrame().getContentPane().add(
						saleInforSearchFrame);
				saleInforSearchFrame.setVisible(true);
			}
		};
	}
	

	public static ActionListener operaterManager()
	{
		return new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				OperaterManagerFrame operaterManagerFrame = new OperaterManagerFrame();
				MainFrame.getMainFrame().getContentPane().add(
						operaterManagerFrame);
				operaterManagerFrame.setVisible(true);
			}
		};
	}
	
	public static ActionListener sales()
	{
		return new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				SalesFrame salesFrame = new SalesFrame();
				MainFrame.getMainFrame().getContentPane().add(
						salesFrame);
				salesFrame.setVisible(true);
			}
		};
	}
	
	public static ActionListener salesBack()
	{
		return new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				SalesBackFrame salesBackFrame = new SalesBackFrame();
				MainFrame.getMainFrame().getContentPane().add(
						salesBackFrame);
				salesBackFrame.setVisible(true);
			}
		}; 
	}
	
	public static ActionListener priceChange()
	{
		return new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				PriceChangeFrame priceChangeFrame = new PriceChangeFrame();
				MainFrame.getMainFrame().getContentPane().add(
						priceChangeFrame);
				priceChangeFrame.setVisible(true);
			}
		};
	}
	
	public static ActionListener importGoods()
	{
		return new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				InportFrame importFrame = new InportFrame();
				MainFrame.getMainFrame().getContentPane().add(
						importFrame);
				importFrame.setVisible(true);
			}
		};
	}
	
	public static ActionListener outportGoods()
	{
		return new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				OutportFrame outportFrame = new OutportFrame();
				MainFrame.getMainFrame().getContentPane().add(
						outportFrame);
				outportFrame.setVisible(true);
			}
		};
	}
	
	public static ActionListener storeHouseInfor()
	{
		return new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				StorehouseInfoFrame storehouseInfoFrame = new StorehouseInfoFrame();
				MainFrame.getMainFrame().getContentPane().add(
						storehouseInfoFrame);
				storehouseInfoFrame.setVisible(true);
			}
		};
	}
	
	public static ActionListener changePassword()
	{
		return new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				ChangePasswordFrame changePasswordFrame = new ChangePasswordFrame();
				MainFrame.getMainFrame().getContentPane().add(
						changePasswordFrame);
				changePasswordFrame.setVisible(true);
			}
		};
	}
}
