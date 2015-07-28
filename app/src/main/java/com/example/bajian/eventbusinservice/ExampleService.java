package com.example.bajian.eventbusinservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import de.greenrobot.event.EventBus;

/**
 * <service android:name=".ExampleService"/>
 * Created by hgx on 2015/7/28.
 */
public class ExampleService extends Service {
    private static final String TAG = "ExampleService";

    @Override
    public void onCreate() {
        Log.i(TAG, "ExampleService-onCreate");
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //执行文件的下载或者播放等操作
        Log.i(TAG, "ExampleService-onStartCommand");
        EventBus.getDefault().post(new Event3(1,2,3,1));
        /*
         * 这里返回状态有三个值，分别是:
         * 1、START_STICKY：当服务进程在运行时被杀死，系统将会把它置为started状态，但是不保存其传递的Intent对象，之后，系统会尝试重新创建服务;
         * 2、START_NOT_STICKY：当服务进程在运行时被杀死，并且没有新的Intent对象传递过来的话，系统将会把它置为started状态，
         *   但是系统不会重新创建服务，直到startService(Intent intent)方法再次被调用;
         * 3、START_REDELIVER_INTENT：当服务进程在运行时被杀死，它将会在隔一段时间后自动创建，并且最后一个传递的Intent对象将会再次传递过来。
         */
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "ExampleService-onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "ExampleService-onDestroy");
        EventBus.getDefault().post(new Event3(1, 2, 3, 0));
        super.onDestroy();
    }
}
