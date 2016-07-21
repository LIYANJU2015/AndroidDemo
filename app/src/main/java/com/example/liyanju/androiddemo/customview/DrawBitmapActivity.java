package com.example.liyanju.androiddemo.customview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.liyanju.androiddemo.R;

/**
 * Created by liyanju on 16/7/21.
 */
public class DrawBitmapActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawbitmap_activity);

        final DrawBitmapView drawBitmapView = (DrawBitmapView)findViewById(R.id.drawbitmap);

        drawBitmapView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawBitmapView.startShow();
            }
        });


    }
}
