/*
 * ���ݿ�����࣬�������ݿ�ײ����
 * ������Ϣ��Config.properties�ļ���
 * Made By:coolszy
 * 2009.07.07
 */

package com.njue.mis.dao;

import javax.swing.*;
import java.sql.*;
import java.util.PropertyResourceBundle;

public class SqlManager
{
	//���峣��
	private final int PSTM_TYPE=0;
	private final int CALL_TYPE=1;
	
	private static SqlManager manager = null; //��̬��Ա������֧�ֵ�̬ģʽ
	private PropertyResourceBundle bundle; //������Դ�ļ�
	private static String jdbcDrive = null; //JDBC��������
	private String DBhost = ""; //���ݿ�������ַ
	private String DBname = ""; //���ݿ���
	private String DBprot = ""; //���ݿ�˿�
	private String DBuser = ""; //���ݿ��û���
	private String DBpasswd = ""; //���ݿ�����
	private String strcon = null; //�����ַ���

	private Connection conn = null; //���Ӷ���    
	private PreparedStatement pstm = null;
	private CallableStatement cstm = null;

	/**
	 *   ˽�й��캯��,����ʵ����
	 */
	private SqlManager()
	{
		try
		{
			// ��ȡ�����ļ�
			bundle = new PropertyResourceBundle(SqlManager.class
					.getResourceAsStream("Config.properties"));
			this.DBhost = getString("DBhost"); //��ȡ������
			this.DBname = getString("DBname"); //��ȡ�û���
			this.DBprot = getString("DBport"); //��ȡ�˿�
			this.DBuser = getString("DBuser"); //��ȡ�û�
			this.DBpasswd = getString("DBpassword"); //��ȡ����
			String databese_type = getString("database-type"); //��ȡ���ݿ�����
			if (databese_type != null) //������Ͳ�Ϊ��
			{
				if (databese_type.toLowerCase().equals("mysql"))
				{ // ����mysql���ݿ����������������ַ�
					jdbcDrive = "com.mysql.jdbc.Driver";
					strcon = "jdbc:mysql://" + DBhost + ":" + DBprot + "/"
							+ DBname + "useUnicode=true&characterEncoding=utf8";
				}
				else
					if (databese_type.toLowerCase().equals("oracle"))
					{ // ����oracle���ݿ����������������ַ�
						jdbcDrive = "oracle.jdbc.driver.OracleDrive";
						strcon = "jdbc:oracle:thin:@" + DBhost + ":" + DBprot
								+ ":" + DBname;
					}
					else
						if (databese_type.toLowerCase().equals("sqlserver2000"))
						{ // ����sqlserver2000���ݿ����������������ַ�
							jdbcDrive = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
							strcon = "jdbc:micorsoft:sqlserver://" + DBhost
									+ ":" + DBprot + ";DatabaseName=" + DBname;
						}
						else
							if (databese_type.toLowerCase().equals(
									"sqlserver2005"))
							{ // ����sqlserver2005���ݿ����������������ַ�
								jdbcDrive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
								strcon = "jdbc:sqlserver://" + DBhost + ":"
										+ DBprot + ";DatabaseName=" + DBname;
							}
			}
		}
		catch (Exception e)
		{
			System.err.println("SqlManager Error!" + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 *  ��ȡ�����ļ��е�ֵ
	 * @param key �����ļ���key
	 * @return  key��Ӧ��ֵ
	 */
	private String getString(String key)
	{
		return this.bundle.getString(key);
	}

	/**
	 * ��̬ģʽ��ȡʵ��
	 * @return SqlManager����
	 */
	public static SqlManager createInstance()
	{
		if (manager == null)
		{
			manager = new SqlManager();
			manager.initDB();
		}
		return manager;
	}

	/**
	 *  ��ʼ�����Ӳ�������ָ����DBType����
	 */
	public void initDB()
	{
		try
		{
			Class.forName(jdbcDrive);
		}
		catch (Exception e)
		{
			System.err.println("initDB Error!" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("�ɹ����������࣡");
	}

	/**
	 *  �������ݿ�
	 */
	public void connectDB()
	{
		try
		{
			conn = DriverManager.getConnection(strcon, DBuser, DBpasswd); // ��ȡ����
			conn.setAutoCommit(false); //�����Զ��ύΪfalse
		}
		catch (SQLException e)
		{
			if(e.getErrorCode() == 0) {
				JOptionPane.showMessageDialog(null, "���ݿ�δ����", "����", JOptionPane.WARNING_MESSAGE);
			}
			if(e.getErrorCode() == 1045) {
				JOptionPane.showMessageDialog(null, "���ݿ������������,", "����", JOptionPane.WARNING_MESSAGE);
			}
			if(e.getErrorCode() == 1049) {
				JOptionPane.showMessageDialog(null, "���ݿ����ƴ���", "����", JOptionPane.WARNING_MESSAGE);
			}
			System.err.println(e.getErrorCode()+"connectDB Error!" + e.getMessage());
			e.printStackTrace();
			return;
		}
		System.out.println("�ɹ����ӵ����ݿ⣡");
	}

	/**
	 *  �Ͽ����ݿ�
	 */
	public void closeDB()
	{
		try
		{
			if (pstm != null)
			{
				pstm.close();
			}
			if (cstm != null)
			{
				cstm.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		catch (Exception e)
		{
			System.err.println("closeDB Error!" + e.getMessage());
			e.printStackTrace();
			return;
		}
		finally
		{
			pstm = null;
			cstm = null;
			conn = null;
		}
		System.out.println("�ɹ��ر����ݿ⣡");
	}

	/**
	 * ����PrepareStatement������Sql����еĲ���
	 * @param sql sql���
	 * @param params �����б�
	 */
	private void setPrepareStatementParams(String sql, Object[] params)
	{
		try
		{
			pstm = conn.prepareStatement(sql); //��ȡ����
			if (params != null)
			{
				for (int i = 0; i < params.length; i++) // ���������б�������
				{
					pstm.setObject(i + 1, params[i]);
				}
			}
		}
		catch (SQLException e)
		{
			System.err.println("setPrepareStatementParams Error!"+ e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * ����CallableStatementParams������sql����еĲ���
	 * @param sql sql���
	 * @param params �����б�
	 */
	private void setCallableStatementParams(String sql, Object[] params)
	{
		try
		{
			cstm = conn.prepareCall(sql); //��ȡCallableStatement����
			if (params != null)
			{
				for (int i = 0; i < params.length; i++) // ��������������
				{
					cstm.setObject(i + 1, params[i]);
				}
			}
		}
		catch (SQLException e)
		{
			System.err.println("setCallableStatementParams Error!"+ e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * ִ�в�ѯ
	 * @param sql sql���
	 * @param params �����б�
	 * @param type sql��������
	 * @return ����ResultSet���͵Ĳ�ѯ���
	 */
	public ResultSet executeQuery(String sql, Object[] params, int type)
	{ // ִ�в�ѯ���ݿ�ӿ�
		ResultSet rs = null;
		try
		{
			switch (type)
			//�ж���PrepareStatement����CallableStatement
			{
			case PSTM_TYPE:
				manager.setPrepareStatementParams(sql, params); //������
				rs = pstm.executeQuery(); // ִ�в�ѯ����
				break;
			case CALL_TYPE:
				manager.setCallableStatementParams(sql, params); //������
				rs = cstm.executeQuery(); //ִ�в�ѯ
				break;
			default:
				throw new Exception("�����ڸ�ѡ��");
			}
		}
		catch (Exception e)
		{
			System.err.println("executeQuery Error!" + e.getMessage());
			e.printStackTrace();
		}
		return rs;
	}
//	public ResultSet executeQuery(String sql)
//	{
//		ResultSet rs = null;
//		try
//		{
//			Statement stmt=conn.createStatement();
//			rs=stmt.executeQuery(sql);
//		}
//		catch (Exception e)
//		{
//			System.err.println("executeQuery Error!" + e.getMessage());
//			e.printStackTrace();
//		}
//		return rs;
//	}

	/**
	 * �������ݿ����
	 *
	 * @param sql    sql���
	 * @param params �����б�
	 * @param type   sql��������
	 * @param num    ��Ӵ���
	 * @return ִ�в����Ľ��
	 */
	public boolean executeUpdate(String sql, Object[] params, int type, int num) // ִ���޷������ݵ����ݲ�ѯ������ֵ�Ǳ��ı���������ݿ�����
	{
		boolean result = false;
		try {
			switch (type)
			//�ж���PrepareStatement����CallableStatement
			{
				case PSTM_TYPE:
					manager.setPrepareStatementParams(sql, params); //������
					for (int i = 0; i < num; i++) {
						pstm.executeUpdate(); // ִ�и���
						manager.commitChange();
					}
					result = true;
					break;
				case CALL_TYPE:
					manager.setCallableStatementParams(sql, params); //������
					for (int i = 0; i < num; i++) {
						pstm.executeUpdate(); // ִ�и���
						manager.commitChange();
					}
					result = true;
					break;

				default:
					throw new Exception("�����ڸ�ѡ��");
			}
		} catch (Exception e) {
			System.err.println("executeUpdate Error!:" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * �������ݿ����
	 * @param sql sql���
	 * @param params �����б�
	 * @param type sql��������
	 * @return ִ�в����Ľ��
	 */
	public boolean executeUpdate(String sql, Object[] params, int type) // ִ���޷������ݵ����ݲ�ѯ������ֵ�Ǳ��ı���������ݿ�����
	{
		boolean result=false;
		try
		{
			switch (type)  
			//�ж���PrepareStatement����CallableStatement
			{
			case PSTM_TYPE:  
				manager.setPrepareStatementParams(sql, params); //������
			    pstm.executeUpdate(); // ִ�и���
			    manager.commitChange();
			    result=true;
				break;
			case CALL_TYPE:
				manager.setCallableStatementParams(sql, params); //������
				cstm.executeUpdate(); // ִ�и���
				manager.commitChange();
				result=true;
				break;

			default:
				throw new Exception("�����ڸ�ѡ��");
			}
		}
		catch (Exception e)
		{
			System.err.println("executeUpdate Error!:" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * �ύ��Ϣ�����ݿ�
	 * @throws SQLException
	 */
	private void commitChange() throws SQLException
	{
		try
		{
			conn.commit();
			System.out.println("�����ύ�ɹ���");
		}
		catch (Exception e)
		{
			System.out.println("CommitChange Error!" + e.getMessage());
			e.printStackTrace();
		}
	}
}
