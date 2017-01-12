package com.example.liyanju.androiddemo.hook;

import android.content.Context;

/**
 * Created by liyanju on 2016/12/23.
 */

public abstract class Hook {

    protected BaseHookHandle mBaseHookHandle;

    protected Context mHostContext;

    public Hook(Context context) {
        mHostContext = context;
        mBaseHookHandle = createBaseHookHandle();
    }

    public abstract BaseHookHandle createBaseHookHandle();

    public abstract void onInstall();
}
