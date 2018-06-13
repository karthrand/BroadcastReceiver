package com.oude.receiver;

import android.app.*;
import android.os.*;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

public class MainActivity extends Activity
{


    private TextView tv;
    private ActiveBroadcastReceiver activeBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv =findViewById(R.id.mainTextView1);
        tv.setText("广播接收记录:\n");
        IntentFilter intentFilter =new IntentFilter();
        intentFilter.addAction("com.oude.broadcast.action.MY_BROADCAST");
        activeBroadcastReceiver = new ActiveBroadcastReceiver();
        registerReceiver(activeBroadcastReceiver,intentFilter);
    }
    
    
    public String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy年MM月dd日 HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(activeBroadcastReceiver);
    }
    
    

    
    class ActiveBroadcastReceiver extends BroadcastReceiver
    {
        public String log;

        @Override
        public void onReceive(Context p1, Intent p2)
        {
            Toast.makeText(p1,"外部接收",Toast.LENGTH_SHORT).show();
            log = "接收到主动广播!";
            tv.append(getTime() + log + "\n");

        }


    }
    
}
