/**
 * 操作员服务类
 */
package com.njue.mis.services;

import com.njue.mis.dao.LogDAO;
import com.njue.mis.dao.OperatorDAO;
import com.njue.mis.handler.OperatorServicesHandler;
import com.njue.mis.model.Operator;

import java.util.Vector;

public class OperatorServices implements OperatorServicesHandler {
	OperatorDAO operatorDAO = null;

	public OperatorServices() {
		super();
	}

    public boolean addLog(String username, String time, String power, String dept, String detail) {
        LogDAO logDAO = new LogDAO();
        return logDAO.addLog(username, time, power, dept, detail);

    }

	public boolean addOperator(Operator operator) {
		operatorDAO = new OperatorDAO();
		return operatorDAO.addOperator(operator);
	}

	public boolean deleteOperator(String username) {
		operatorDAO = new OperatorDAO();
		return operatorDAO.deleteOperator(username);
	}

	public boolean loginCheck(String username, String password, String dept) {
		operatorDAO = new OperatorDAO();
		return operatorDAO.loginCheck(username, password, dept);
	}

	public boolean modifyPassword(String username, String password) {
		operatorDAO = new OperatorDAO();
		return operatorDAO.modifyPassword(username, password);
	}

	public String getPower(String username) {
		operatorDAO = new OperatorDAO();
		return operatorDAO.getPower(username);
	}


	public String getPassword(String username) {
		operatorDAO = new OperatorDAO();
		return operatorDAO.getPassword(username);
	}

	
	public boolean isExited(String username)
	{
		operatorDAO=new OperatorDAO();
		return operatorDAO.isExited(username);
	}


	public Vector<Operator> getOperator(String type)
	{
		operatorDAO=new OperatorDAO();
		return operatorDAO.getOperator(type);
	}

	public Vector<Operator> getOperator(String type, String dept) {
		operatorDAO = new OperatorDAO();
		return operatorDAO.getOperator(type, dept);
	}

	
	public Operator getOperatorInfo(String userName)
	{
		operatorDAO=new OperatorDAO();
		return operatorDAO.getOperatorInfo(userName);
	}

}
