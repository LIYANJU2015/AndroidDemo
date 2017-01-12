package com.example.liyanju.androiddemo.plugin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.liyanju.androiddemo.R;

/**
 * Created by liyanju on 2016/12/20.
 */

public class Plugin1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.demo_item);

        ((TextView)findViewById(R.id.item_demo_tv)).setText(" Plugin1Activity ");

        ((TextView)findViewById(R.id.item_demo_tv)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Plugin1Activity.this, Plugin2Activity.class);

                ComponentName componentName = intent.getComponent();

                intent.setClassName(componentName.getPackageName(), "com.example.liyanju.androiddemo.plugin.Plugin1");

                intent.putExtra("pluginclass", componentName.getClassName());

                Log.v("xx", " getClassName>>> " + componentName.getClassName());

                Plugin1Activity.this.startActivity(intent);
            }
        });
    }
}
