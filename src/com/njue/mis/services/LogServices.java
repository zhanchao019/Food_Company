package com.njue.mis.services;

import com.njue.mis.dao.LogDAO;
import com.njue.mis.handler.LogServicesHandler;
import com.njue.mis.model.Log;

import java.util.Vector;

public class LogServices implements LogServicesHandler {
    LogDAO logDAO = null;

    public Vector<Log> getAllLog() {
        logDAO = new LogDAO();
        return logDAO.getAllLog();
    }
}
