package com.example.liyanju.androiddemo.bezier;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import android.util.Log;

/**
 * Created by baidu on 16/7/23.
 *
 * B(t) = (1 - t)^2 * P0 + 2*t * (1 - t) * P1 + t^2 * P2, t ∈ [0,1]
 *
 */
public class BezierTypeEvaluator implements TypeEvaluator<PointF> {

    private PointF centerPoint;

    public BezierTypeEvaluator(PointF centerPoint){
        this.centerPoint = centerPoint;
    }

    @Override
    public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
        Log.v("BezierTypeEvaluator", "fraction  " + fraction);
        float x = (float) (Math.pow((1 - fraction), 2) * startValue.x
                        + 2 * fraction * (1 - fraction) * centerPoint.x
                        + Math.pow(fraction, 2) * endValue.x);

        float y = (float) (Math.pow((1 - fraction), 2) * startValue.y
                + 2 * fraction * (1 - fraction) * centerPoint.y
                + Math.pow(fraction, 2) * endValue.y);

        PointF pointF = new PointF(x, y);

        return pointF;
    }
}
