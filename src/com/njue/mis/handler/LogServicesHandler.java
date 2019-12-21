package com.njue.mis.handler;

import com.njue.mis.model.Log;

import java.util.Vector;

public interface LogServicesHandler {
    /**
     * 获取所有的记录
     *
     * @return 记录
     */
    Vector<Log> getAllLog();
}
