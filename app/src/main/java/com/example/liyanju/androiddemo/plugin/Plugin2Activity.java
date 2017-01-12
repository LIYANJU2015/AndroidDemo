package com.example.liyanju.androiddemo.plugin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.liyanju.androiddemo.R;

/**
 * Created by liyanju on 2016/12/20.
 */

public class Plugin2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.demo_item);

        ((TextView)findViewById(R.id.item_demo_tv)).setText(" Plugin22Activity ");


    }
}
