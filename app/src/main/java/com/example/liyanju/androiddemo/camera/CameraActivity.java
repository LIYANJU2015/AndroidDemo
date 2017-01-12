package com.example.liyanju.androiddemo.camera;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.liyanju.androiddemo.R;

/**
 * Created by liyanju on 16/9/19.
 */
public class CameraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_layout);

        final ImageView imageView = (ImageView) findViewById(R.id.imageview);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rotate3dAnimation rotate3dAnimation = new Rotate3dAnimation();
                rotate3dAnimation.setDuration(5000);
                imageView.startAnimation(rotate3dAnimation);

            }
        });




    }


}
