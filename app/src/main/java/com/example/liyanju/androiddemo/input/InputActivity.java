package com.example.liyanju.androiddemo.input;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.liyanju.androiddemo.R;

/**
 * Created by liyanju on 16/6/7.
 */
public class InputActivity extends Activity{

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContentView(R.layout.only_edittext_layout);

//        editText = (EditText)findViewById(R.id.eidttext);

//        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(editText.getWindowToken(),0);


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("XX", " isInEditMode : " + editText.isInTouchMode());
       // getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }
}
