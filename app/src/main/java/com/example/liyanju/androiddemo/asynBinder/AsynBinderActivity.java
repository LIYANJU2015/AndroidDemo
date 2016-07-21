package com.example.liyanju.androiddemo.asynBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.liyanju.androiddemo.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by liyanju on 16/5/27.
 * 结论: binder异步回调方法是同步执行的 调用binder 回调是异步的执行
 *
 */
public class AsynBinderActivity extends Activity {

    IServiceAIDL iServiceAIDL;

    /**
     * binder异步回调方法是同步执行的
     */
    public static class stubIServiceCallBackAIDL extends IServiceCallBackAIDL.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void onCallBack(String str) throws RemoteException {
            Log.v("xx", " stubIServiceCallBackAIDL onCallBack11111111111 start ");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.v("xx", " stubIServiceCallBackAIDL onCallBack1111111 end ");
        }

        @Override
        public void onCallBack2(String str) throws RemoteException {
            Log.v("xx", " stubIServiceCallBackAIDL onCallBack22222 start ");

            Log.v("xx", " stubIServiceCallBackAIDL onCallBack2222222 end ");
        }
    }

    private void bindService(){
        Intent intent = new Intent(AsynBinderActivity.this, BinderService.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                iServiceAIDL = IServiceAIDL.Stub.asInterface(service);
                Log.v("xx", "bindService onServiceConnected start ");
                try {
                    iServiceAIDL.setCallBackBinder(new stubIServiceCallBackAIDL());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BinderService.BIND_AUTO_CREATE);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

//    @Override
//    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.only_button_layout);

        bindService();

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AsynBinderActivity.this, BinderService.class);
                AsynBinderActivity.this.startService(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
