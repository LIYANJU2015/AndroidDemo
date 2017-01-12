package com.example.liyanju.androiddemo.hook;

import android.content.Context;

/**
 * Created by liyanju on 2016/12/23.
 */

public class IActivityManagerHook extends ProxyHook {

    public IActivityManagerHook(Context context) {
        super(context);
    }

    @Override
    public BaseHookHandle createBaseHookHandle() {
        return new IActivityManagerHookHandle();
    }

    @Override
    public void onInstall() {

    }
}
