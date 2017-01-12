package com.example.liyanju.androiddemo.binder;

import android.app.Activity;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.example.liyanju.androiddemo.R;

/**
 * Created by liyanju on 2016/11/29.
 */
public class SpecialBinderActivity extends Activity {

    private IServiceBinder mServiceBinder;

    IClientCallBack.Stub specialBinderClient = new IClientCallBack.Stub() {
        @Override
        public void onCallBack(IBinder serviceBinder) throws RemoteException {
            mServiceBinder = IServiceBinder.Stub.asInterface(serviceBinder);
            Log.v("XX", " SpecialBinderActivity onCallBack " + serviceBinder.getClass());
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.only_button_layout);

        Intent intent = new Intent(SpecialBinderActivity.this, SpecialBinderService.class);
        intent.putExtra("messager", new MyMessage(specialBinderClient));
        SpecialBinderActivity.this.startService(intent);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            mServiceBinder.setName("zhangsan");
                            Log.v("xx", "getName :::" + mServiceBinder.getName() + " getCallingPid11 " + Binder.getCallingPid());
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }
        });


    }
}
