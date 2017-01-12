package com.example.liyanju.androiddemo.plugin;


import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by liyanju on 2016/12/20.
 */

public class MyInstrumentation extends Instrumentation {

    @Override
    public Activity newActivity(ClassLoader cl, String className, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Log.v("xx", "MyInstrumentation  pluginclass:::" + intent.getStringExtra("pluginclass"));
        if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("pluginclass"))) {

            return (Activity) Class.forName(intent.getStringExtra("pluginclass")).newInstance();
        }

        return super.newActivity(cl, className, intent);
    }
}
