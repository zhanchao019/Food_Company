package com.njue.mis.handler;

import com.njue.mis.model.Log;

import java.util.Vector;

public interface LogServicesHandler {
    /**
     * ��ȡ���еļ�¼
     *
     * @return ��¼
     */
    Vector<Log> getAllLog();
}
