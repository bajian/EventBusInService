package com.example.bajian.eventbusinservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import de.greenrobot.event.EventBus;


public class MainActivity2 extends ActionBarActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EventBus.getDefault().register(this);//这里也注册，使得12activity同时收到消息
        intent = new Intent(MainActivity2.this,ExampleService.class);
    }
    public void send(View view){
        EventBus.getDefault().post(new Event1("FirstEvent btn clicked"));
        EventBus.getDefault().post(new Event2(1, 2));
        EventBus.getDefault().post(new Event3(1, 2, 3, 1));
    }
    public void service(View view){
        startService(intent);
        Log.i("startService", "startService");
    }

    public void stopservice(View view){
        stopService(intent);
    }
    public void onEventMainThread(Event1 event) {

        String msg = "MainActivity2onEventMainThread:" + event.getMsg();
        Log.d("Event1", msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
