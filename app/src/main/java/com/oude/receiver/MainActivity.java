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

public class MainActivity extends Activity 
{
    private TextView tv;
    private String time;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv =findViewById(R.id.mainTextView1);
        
        time =getTime();
        
        tv.setText("广播接收记录:\n");
    }
    
    
    public String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy年MM月dd日 HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }
    
    public void setLogs(String log){
        tv.append(getTitle() + log + "\n");
    }
    
}
