package com.example.liyanju.androiddemo.hook;

import android.util.Log;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyanju on 2016/12/23.
 */

public abstract class BaseHookHandle {

    protected Map<String, HookedMethodHandler> sHookedMethodHandlers = new HashMap<String, HookedMethodHandler>(5);

    public abstract void init();

    protected Class<?> getHookedClass() throws ClassNotFoundException {
        return null;
    }

    protected HookedMethodHandler newBaseHandler() throws ClassNotFoundException {
        return null;
    }

    public HookedMethodHandler getHookedMethodHandler(Method method) {
        if (method != null) {
            return sHookedMethodHandlers.get(method.getName());
        } else {
            return null;
        }
    }

    protected void addAllMethodFromHookedClass(){
        try {
            Class clazz = getHookedClass();
            if(clazz!=null){
                Method[] methods = clazz.getDeclaredMethods();
                if(methods!=null && methods.length>0){
                    for (Method method : methods) {
                        if(Modifier.isPublic(method.getModifiers()) && !sHookedMethodHandlers.containsKey(method.getName())){
                            sHookedMethodHandlers.put(method.getName(),newBaseHandler());
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            Log.w(getClass().getSimpleName(),"init addAllMethodFromHookedClass error",e);
        }
    }

}
