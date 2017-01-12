package com.example.liyanju.androiddemo.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.example.liyanju.androiddemo.R;


/**
 * Created by liyanju on 2016/12/14.
 */
public class TagBadgeView extends View {

    private int mHeight;

    private int mWidth;

    private Paint mPaint = new Paint();

    private int mRadius;

    private Bitmap mBadgeBitmap;

    private RectF mOval = new RectF();

    private Context mContext;

    private Path mPath = new Path();

    private Paint mBitmapPaint = new Paint();

    public TagBadgeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(Color.WHITE);
        mPaint.setAntiAlias(true);
        mBitmapPaint.setAntiAlias(true);

        mContext = getContext().getApplicationContext();

        mBadgeBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_badge);

        mRadius = mBadgeBitmap.getWidth() / 2  + DimensUtil.dip2px(mContext, 9);

        mWidth = mBadgeBitmap.getWidth() + DimensUtil.dip2px(mContext, 9)*2;

        mHeight = mBadgeBitmap.getHeight() + DimensUtil.dip2px(mContext, 12.5f) * 2;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(measureDimension(mWidth, widthMeasureSpec), measureDimension(mHeight, heightMeasureSpec));
    }

    private int measureDimension(int defaultSize, int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            result = Math.min(defaultSize, specSize);
        } else {
            result = defaultSize;
        }

        return result;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = getMeasuredHeight();
        mWidth = getMeasuredWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mOval.bottom = mRadius * 2;
        mOval.left = 0;
        mOval.right = mRadius * 2;
        mOval.top = 0;
        mPath.addArc(mOval, 180, 180);

        //mPath.addCircle(mRadius, mRadius, mRadius, Path.Direction.CW);

        canvas.drawPath(mPath, mPaint);

        canvas.drawBitmap(mBadgeBitmap, DimensUtil.dip2px(mContext, 8.5f),
                DimensUtil.dip2px(mContext, 12.5f), mBitmapPaint);

    }
}
