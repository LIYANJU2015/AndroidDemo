package com.example.liyanju.androiddemo.camera;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by liyanju on 16/9/19.
 */
public class Rotate3dAnimation extends Animation{

    private Camera mCamera;

    private int mWidth;

    private int mHeight;

    private int mFromDegrees = 0;

    private int mToDegrees = 180;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mWidth = width;
        mHeight = height;
        mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final float fromDegrees = mFromDegrees;
        float degrees = fromDegrees + ((mToDegrees - fromDegrees) * interpolatedTime);

        Log.v("xx", "Rotate3dAnimation applyTransformation >>>> degrees " + degrees
                + " interpolatedTime " + interpolatedTime
                + " mWidth : " + mWidth + " mHeight " + mHeight);

        Camera camera = mCamera;

        Matrix matrix = t.getMatrix();

        camera.save();

        camera.translate(0, 100, 200);
        camera.rotateX(degrees);
        camera.getMatrix(matrix);
        camera.restore();

        Log.v("XX", " applyTransformation toShortString : " + matrix.toShortString());

        matrix.preTranslate(-mWidth/2, -mHeight/2);
        matrix.postTranslate(mWidth/2, mHeight/2);
    }
}
