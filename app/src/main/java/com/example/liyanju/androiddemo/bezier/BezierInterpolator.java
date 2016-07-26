package com.example.liyanju.androiddemo.bezier;

import android.util.Log;
import android.view.animation.Interpolator;

/**
 * Created by baidu on 16/7/23.
 *
 *   B(t) = (1 - t)^2 * P0 + 2t * (1 - t) * P1 + t^2 * P2, t ∈ [0,1]
 *
 */
public class BezierInterpolator implements Interpolator {

    private float centerY;

    public BezierInterpolator(float centerY){
        this.centerY = centerY;
    }

    @Override
    public float getInterpolation(float input) {
        //input 0-1
        float y = (float) (Math.pow((1 - input), 2) * 0
                + 2 * input * (1 - input) * centerY
                + Math.pow(input, 2) * 1);
        Log.v("XX", " BezierInterpolator getInterpolation y " + y);
        return y;
    }
}
