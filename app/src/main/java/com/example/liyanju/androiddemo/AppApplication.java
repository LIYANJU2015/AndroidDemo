package com.example.liyanju.androiddemo;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;


import com.example.liyanju.androiddemo.plugin.Plugin1Activity;
import com.example.liyanju.androiddemo.plugin.PluginActivity;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;

/**
 * Created by liyanju on 16/7/14.
 */
public class AppApplication extends Application{

    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
       // MyFileLoader.setParentPath(Environment.getExternalStorageDirectory()+ File.separator + "at");

        PluginActivity.hookInstruemation();
        Log.v("xx", " app start 111 ");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.v("xx", " app start 2224 ");
            }
        }, 2000);
        handler.sendEmptyMessage(0);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Log.v("xx", " app start 4444 ");
//            try {
//                Thread.sleep(4000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    };
}
