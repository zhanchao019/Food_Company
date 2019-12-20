package com.njue.mis.model;

public class Storage {
    private String goodsid;
    private String pici;
    private String orderid;
    private String producedate;
    private String state;

    public Storage(String goodsid, String pici, String orderid, String producedate, String state) {
        this.goodsid = goodsid;
        this.pici = pici;
        this.orderid = orderid;
        this.producedate = producedate;
        this.state = state;
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

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getProducedate() {
        return producedate;
    }

    public void setProducedate(String producedate) {
        this.producedate = producedate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
