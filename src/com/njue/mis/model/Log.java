package com.njue.mis.model;

public class Log {


    String username;
    String time;
    String power;
    String dept;
    String detail;

    public Log(String username, String time, String power, String dept, String detail) {
        this.username = username;
        this.time = time;
        this.power = power;
        this.dept = dept;
        this.detail = detail;
    }

    public Object getLog(int columnNumber) {
        switch (columnNumber) {
            case 0:
                return getUsername();
            case 1:
                return getTime();
            case 2:
                return getPower();
            case 3:
                return getDept();
            case 4:
                return getDetail();

            default:
                return "";
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
