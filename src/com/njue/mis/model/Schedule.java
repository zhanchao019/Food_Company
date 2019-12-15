package com.njue.mis.model;

public class Schedule {
    public String scheduleid;


    public String goodsid;
    public int sum;
    public String comment;
    public String state;

    public Schedule(String scheduleid, String goodsid, int sum, String comment, String state) {
        this.scheduleid = scheduleid;
        this.goodsid = goodsid;
        this.sum = sum;
        this.comment = comment;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(String scheduleid) {
        this.scheduleid = scheduleid;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public Object getScheduleValue(int columnNumber) {
        switch (columnNumber) {
            case 0:
                return getScheduleid();

            case 1:
                return getGoodsid();
            case 2: {
                return getSum();
            }
            case 3: {
                return getComment();
            }
            case 4:
                return getState();
            default:
                return "";
        }
    }
}
