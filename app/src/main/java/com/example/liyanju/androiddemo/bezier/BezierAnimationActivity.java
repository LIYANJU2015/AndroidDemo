package com.example.liyanju.androiddemo.bezier;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.liyanju.androiddemo.R;

import java.util.Locale;

/**
 * Created by baidu on 16/7/23.
 *
 * B(t) = (1 - t)^2 * P0 + 2t * (1 - t) * P1 + t^2 * P2, t ∈ [0,1]
 *
 *
 */
public class BezierAnimationActivity extends Activity{

    ImageView imageView;

    int width;

    int height;

    View contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.bezier_layout);


        imageView = (ImageView)findViewById(R.id.imageview);
        imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startAnimation(imageView);
            }
        });

        WindowManager wm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);

        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();

        contentView = findViewById(R.id.content);

    }

    private void startAnimation(final ImageView imageView){

        PointF startPoint = new PointF(imageView.getX(), imageView.getY());


        PointF endPoint = new PointF(contentView.getWidth() - imageView.getWidth(),
                contentView.getHeight() - imageView.getHeight());

        PointF centerPoint = new PointF(width - imageView.getWidth(), imageView.getY());

        // 贝塞尔曲线自定义 估值器
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new BezierTypeEvaluator(centerPoint),
                startPoint, endPoint);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF = (PointF)animation.getAnimatedValue();
                Log.v("xx", " pointF.x " + pointF.x + " pointF.y " + pointF.y);
                imageView.setX(pointF.x);
                imageView.setY(pointF.y);
            }
        });
        //贝塞尔曲线自定义插值器
        valueAnimator.setInterpolator(new BezierInterpolator(centerPoint.y/height));
        valueAnimator.setDuration(3000);
        valueAnimator.start();
    }
}
