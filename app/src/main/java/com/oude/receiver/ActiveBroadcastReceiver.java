package com.oude.receiver;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ActiveBroadcastReceiver extends BroadcastReceiver
{
    public String log;

    @Override
    public void onReceive(Context p1, Intent p2)
    {
        Toast.makeText(p1,"外部接收",Toast.LENGTH_SHORT).show();
        log = "接收到主动广播!";
        MainActivity mainActivity = new MainActivity();
        mainActivity.setLogs(log);
    }

    
}
