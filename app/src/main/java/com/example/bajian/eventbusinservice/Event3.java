package com.example.bajian.eventbusinservice;

/**
 * Created by hgx on 2015/7/28.
 */
public class Event3 {
    public int getServiceState() {
        return mServiceState;
    }

    public int getMsg() {
        return mMsg;
    }

    public void setMsg(int msg) {
        mMsg = msg;
    }

    public int getMsg2() {
        return mMsg2;
    }

    public void setMsg2(int msg2) {
        mMsg2 = msg2;
    }

    public int getMsg3() {
        return mMsg3;
    }

    public void setMsg3(int msg3) {
        mMsg3 = msg3;
    }

    private final int mServiceState;
    private int mMsg;
    private int mMsg2;
    private int mMsg3;

    /**
     * @param msg
     * @param msg2
     * @param msg3
     * @param serviceState 1启动，0关闭
     */
    public Event3(int msg, int msg2,int msg3,int serviceState) {
        mMsg = msg;
        mMsg2 = msg2;
        mMsg3 = msg3;
        mServiceState=serviceState;
    }
    public int getTatal(){
        return mMsg+mMsg2+mMsg3;
    }
}
