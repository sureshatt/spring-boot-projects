package com.sureshatt.springboot.redis;

import java.io.Serializable;

class RedisData implements Serializable {

    private String id;

    private String data1;

    private int data2;

    public RedisData() {
    }

    public RedisData(String id, String data1, int data2) {
        this.id = id;
        this.data1 = data1;
        this.data2 = data2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public int getData2() {
        return data2;
    }

    public void setData2(int data2) {
        this.data2 = data2;
    }
}
