package com.example.liyanju.androiddemo;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.liyanju.androiddemo.input.InputActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

/**
 * Created by liyanju on 16/7/14.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class InputActivityTest{

    @Before
    public void setUp() {
        Log.i("xx", "setUp");
        ShadowLog.stream = System.out;
        Activity activity = Robolectric.setupActivity(InputActivity.class);

    }

    @Test
    public void test(){
        Log.i("xx", "test");
    }

}
