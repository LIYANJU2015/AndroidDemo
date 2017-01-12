package com.example.liyanju.androiddemo.eventbus;

import android.app.Activity;
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
public class EventbusActivity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.demo_item);

        findViewById(R.id.item_demo_tv).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent());
            }
        });

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHandle2Event(MessageEvent messageEvent) {
        Log.v("xx", "EventbusActivity1111111 onHandleEvent ");
    }
}
