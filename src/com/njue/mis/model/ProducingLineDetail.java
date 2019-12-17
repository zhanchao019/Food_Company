package com.njue.mis.model;

public class ProducingLineDetail {
    String scheduleid, goodsid, pici, producinglineid, state;
    int num;

    public ProducingLineDetail(String scheduleid, String goodsid, String pici, String producinglineid, String state, int num) {
        this.scheduleid = scheduleid;
        this.goodsid = goodsid;
        this.pici = pici;
        this.producinglineid = producinglineid;
        this.state = state;
        this.num = num;
    }


    public Object getProducingLineDetailValue(int columnNumber) {
        switch (columnNumber) {
            case 0:
                return getScheduleid();
            case 1:
                return getGoodsid();
            case 2:
                return getPici();
            case 3:
                return getProducinglineid();
            case 4:
                return getNum();
            case 5:
                return getState();


            default:
                return "";
        }
    }

    public String getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(String scheduleid) {
        this.scheduleid = scheduleid;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getPici() {
        return pici;
    }

    public void setPici(String pici) {
        this.pici = pici;
    }

    public String getProducinglineid() {
        return producinglineid;
    }

    public void setProducinglineid(String producinglineid) {
        this.producinglineid = producinglineid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}