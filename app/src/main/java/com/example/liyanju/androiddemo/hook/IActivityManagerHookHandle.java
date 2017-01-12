package com.example.liyanju.androiddemo.hook;

import java.lang.reflect.Method;

/**
 * Created by liyanju on 2016/12/23.
 */

public class IActivityManagerHookHandle extends BaseHookHandle {

    @Override
    public void init() {
        sHookedMethodHandlers.put("startActivity", new startActivity());
    }

    public class startActivity extends HookedMethodHandler {

        @Override
        protected boolean beforeInvoke(Object receiver, Method method, Object[] args) throws Throwable {
            return super.beforeInvoke(receiver, method, args);
        }

        @Override
        protected void afterInvoke(Object receiver, Method method, Object[] args, Object invokeResult) throws Throwable {
            super.afterInvoke(receiver, method, args, invokeResult);
        }
    }
}
