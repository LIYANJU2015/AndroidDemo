package com.example.liyanju.androiddemo.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.liyanju.androiddemo.R;

/**
 * Created by liyanju on 16/7/21.
 */
public class DrawBitmapView extends View {

    private int width;
    private int height;

    private Bitmap bitmap;
    Paint paint, paint2;

    int w;
    int h;

    public DrawBitmapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.checkmark);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint2 = new Paint();
        paint2.setAntiAlias(true);


        w = bitmap.getWidth() / 13;
        h = bitmap.getHeight();
        totaLeft = 0;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        Log.v("XX", " onSizeChanged ");
    }

    boolean isStart;

    int tempValue;

    public void startShow() {
        isStart = true;
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 13);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.v("xx", " getAnimatedValue " + animation.getAnimatedValue());
                int value = (Integer) animation.getAnimatedValue();
                if (tempValue != value) {
                    tempValue = value;
                    invalidate();
                }
            }
        });
        valueAnimator.setDuration(2000);
        valueAnimator.start();
    }

    Rect src = new Rect();

    Rect dst = new Rect();

    int totaLeft = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        paint.setColor(Color.BLUE);
        canvas.drawCircle((float) (width / 2), (float) (height / 2), h / 2 + 50, paint);
        if (!isStart) {
            return;
        }


        src.set(totaLeft, 0, w + totaLeft, h);

        Log.v("xx", " totaLeft >>>" + totaLeft + " right " + (w + totaLeft) + " h " + h);

        int destleft = (width / 2) - w / 2;
        int desttop = (height / 2) - h / 2;

        Log.v("xx", " destleft >>>" + destleft + " desttop " + desttop + " w " + w + " h " + h);

        dst.set(destleft, desttop, destleft + w, desttop + h);

        totaLeft = totaLeft + w;

        canvas.drawBitmap(bitmap, src, dst, paint2);

    }
}
