package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView tv_state;
    private NetworkReceiver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_state = findViewById(R.id.tv_state);

        //브로드 캐스트 리시버 등록
        IntentFilter filter = new IntentFilter();
        receiver = new NetworkReceiver();
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);//네트워크 변화되는 상태값을 intentfilter로 추가를 해라
        registerReceiver(receiver,filter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //브로드 캐스트 리시버 해제
        unregisterReceiver(receiver);

    }
}