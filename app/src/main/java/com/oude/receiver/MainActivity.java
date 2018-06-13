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
        
        //创建外部主动广播接收器第一步：创建接收器
        IntentFilter intentFilter =new IntentFilter();
        intentFilter.addAction("com.oude.broadcast.action.MY_BROADCAST");
        activeBroadcastReceiver = new ActiveBroadcastReceiver();
        registerReceiver(activeBroadcastReceiver,intentFilter);
    }
    
    //实现获取当前时间
    public String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy年MM月dd日 HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }

    //注销外部广播接收器
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(activeBroadcastReceiver);
    }
    
    //创建外部主动广播接收器第二步：实现接收器，并将时间加log内容写入到TwxtView中
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
