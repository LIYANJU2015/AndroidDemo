package com.example.liyanju.androiddemo.hook;

import android.content.Context;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by liyanju on 2016/12/23.
 */

public abstract class ProxyHook extends Hook implements InvocationHandler {

    public ProxyHook(Context context) {
        super(context);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HookedMethodHandler hookedMethodHandler = mBaseHookHandle.getHookedMethodHandler(method);
        return hookedMethodHandler.doHookInner(proxy, method, args);
    }
}
