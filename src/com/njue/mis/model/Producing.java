package com.njue.mis.model;

public class Producing {
    String scheduleid, goodsid;
    int sum, finished, unfinished;
    String pici;
    String producinglineid;

    public Producing(String scheduleid, String goodsid, int sum, int finished, int unfinished, String pici, String producinglineid, String productiondate, String state) {
        this.scheduleid = scheduleid;
        this.goodsid = goodsid;
        this.sum = sum;
        this.finished = finished;
        this.unfinished = unfinished;
        this.pici = pici;
        this.producinglineid = producinglineid;
        this.productiondate = productiondate;
        this.state = state;
    }

    public Producing(String scheduleid, String goodsid, int sum, int finished, int unfinished) {
        this.scheduleid = scheduleid;
        this.goodsid = goodsid;
        this.sum = sum;
        this.finished = finished;
        this.unfinished = unfinished;
    }

    String productiondate;
    String state;

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

    public String getProductiondate() {
        return productiondate;
    }

    public void setProductiondate(String productiondate) {
        this.productiondate = productiondate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getProducingValue(int columnNumber) {
        switch (columnNumber) {
            case 0:
                return getScheduleid();
            case 1:
                return getGoodsid();
            case 2: {
                return getSum();
            }
            case 3: {
                return getFinished();
            }
            case 4:
                return getFinished();
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

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public int getUnfinished() {
        return unfinished;
    }

    public void setUnfinished(int unfinished) {
        this.unfinished = unfinished;
    }
}