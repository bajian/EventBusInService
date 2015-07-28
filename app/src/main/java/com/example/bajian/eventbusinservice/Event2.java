package com.example.bajian.eventbusinservice;

/**
 * Created by hgx on 2015/7/28.
 */
public class Event2 {
    private int mMsg;
    private int mMsg2;
    public Event2(int msg,int msg2) {
        // TODO Auto-generated constructor stub
        mMsg = msg;
        mMsg2 = msg2;
    }
    public int getTatal(){
        return mMsg+mMsg2;
    }
}
