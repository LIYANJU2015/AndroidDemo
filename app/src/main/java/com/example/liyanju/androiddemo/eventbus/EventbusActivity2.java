package com.example.liyanju.androiddemo.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.liyanju.androiddemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by liyanju on 2016/11/30.
 */
public class EventbusActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.only_button_layout);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventbusActivity2.this, EventbusActivity1.class);
                EventbusActivity2.this.startActivity(intent);
            }
        });


        EventBus.getDefault().register(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHandleEvent(MessageEvent messageEvent) {
        Log.v("xx", "EventbusActivity2 onHandleEvent ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
