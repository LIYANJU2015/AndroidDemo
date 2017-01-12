package com.example.liyanju.androiddemo.hook;

import java.lang.reflect.Method;

/**
 * Created by liyanju on 2016/12/23.
 */

public class HookedMethodHandler {

    public synchronized Object doHookInner(Object receiver, Method method, Object[] args) throws Throwable {
        boolean suc = beforeInvoke(receiver, method, args);
        Object invokeResult = null;
        if (!suc) {
            invokeResult = method.invoke(receiver, method, args);
        }
        afterInvoke(receiver, method, args, invokeResult);
        return invokeResult;
    }

    protected boolean beforeInvoke(Object receiver, Method method, Object[] args) throws Throwable {
        return false;
    }

    protected void afterInvoke(Object receiver, Method method, Object[] args, Object invokeResult) throws Throwable {
    }
}
