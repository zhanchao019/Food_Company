package com.njue.mis.model;

public class ProducingLine {
    int number;
    String producinglineid;

    public ProducingLine(String producinglineid, int number) {
        this.number = number;
        this.producinglineid = producinglineid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProducinglineid() {
        return producinglineid;
    }

    public void setProducinglineid(String producinglineid) {
        this.producinglineid = producinglineid;
    }

    public Object getProducingValue(int columnNumber) {
        switch (columnNumber) {
            case 0:
                return getProducinglineid();
            case 1:
                return getNumber();

            default:
                return "";
        }
    }
}
