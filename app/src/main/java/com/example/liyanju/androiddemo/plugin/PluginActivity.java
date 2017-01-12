package com.example.liyanju.androiddemo.plugin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.example.liyanju.androiddemo.R;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static android.webkit.WebSettings.PluginState.ON;

/**
 * Created by liyanju on 2016/12/20.
 */

public class PluginActivity extends Activity {

    public static void hookInstruemation() {
        try {
            Class activityThreadClazz = Class.forName("android.app.ActivityThread");

            Field field = activityThreadClazz.getDeclaredField("sCurrentActivityThread");
            field.setAccessible(true);

            Object activityThreadObj = field.get(null);

            Field instrumentationFile = activityThreadClazz.getDeclaredField("mInstrumentation");
            instrumentationFile.setAccessible(true);
            instrumentationFile.set(activityThreadObj, new MyInstrumentation());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.only_button_layout);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PluginActivity.this, Plugin1Activity.class);

                ComponentName componentName = intent.getComponent();

                intent.setClassName(componentName.getPackageName(), "com.example.liyanju.androiddemo.plugin.Plugin1");

                intent.putExtra("pluginclass", componentName.getClassName());

                Log.v("xx", " getClassName>>> " + componentName.getClassName());

                PluginActivity.this.startActivity(intent);

            }
        });

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String dexPath = Environment.getExternalStorageDirectory().getPath() + "/DuCaller-gp-debug-unaligned-3.1.1.1.apk";
                String libPath = getApplicationContext().getFilesDir() + "/plugin/lib";
                createDir(libPath);
                String optimizedPath = getApplicationContext().getFilesDir() + "/plugin/dalvik-cache";
                createDir(optimizedPath);

                ClassLoader parentClassLoader = getApplicationContext().getClassLoader();

                MyClassLoader myClassLoader = new MyClassLoader(parentClassLoader);
                myClassLoader.addPluginClassLoader(dexPath, optimizedPath, libPath);

                try {
                    Class clazz = myClassLoader.loadClass("com.ducaller.callmonitor.component.AddSpamTagActivity");
                    Log.v("xx", "clazzclazzclazz:: "  + clazz);
                    Object object = (Object) clazz.newInstance();
                    Method method = clazz.getDeclaredMethod("handleIntent", Intent.class);
                    method.setAccessible(true);
                    method.invoke(object, new Intent());

                    clazz = myClassLoader.loadClass("contacts.NameItem");
                    Log.v("xx", "clazzclazzclazz222:: "  + clazz);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public boolean createDir(String path) {
        File file = new File(path);
        Log.v("xx", " createDir mkdirs:: " + file.mkdirs() + " path:: " + path);
        return file.mkdirs();
    }

}
