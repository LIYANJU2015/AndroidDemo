package com.example.liyanju.androiddemo.lable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;


/**
 * Created by liyanju on 16/9/12.
 */
public class LogoLableLinearLayout extends LinearLayout {

    private int mWidth;

    private int mHeight;

    private Paint paint = new Paint();

    private int round = 9;

    public LogoLableLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        setWillNotDraw(false);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        Log.v("XX", " onSizeChanged mHeight " + mHeight + " mWidth : " + mWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();

        path.moveTo(0, round);

        path.quadTo(2,0, round, 0);

        path.lineTo(mWidth - 80 - round, 0);

        path.quadTo(mWidth - 80, 0, mWidth - 80 + round, round);

        path.lineTo(mWidth, mHeight);

        path.lineTo(0, mHeight);

        path.lineTo(0, round);

        path.close();

        canvas.drawPath(path, paint);

    }
}
