package com.example.liyanju.androiddemo.customview;

import android.app.Activity;
import android.os.Bundle;

import com.example.liyanju.androiddemo.R;

/**
 * Created by liyanju on 16/7/30.
 */
public class XFermodeActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xfermode_activity);
        findViewById(R.id.content).setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }
}
