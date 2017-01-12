package com.example.liyanju.androiddemo.plugin;

import android.util.Log;

import java.io.File;

import dalvik.system.BaseDexClassLoader;

/**
 * Created by liyanju on 2016/12/21.
 */

public class PluginClassLoader extends BaseDexClassLoader {

    public PluginClassLoader(String dexPath, File optimizedDirectory, String libraryPath, ClassLoader parent) {
        super(dexPath, optimizedDirectory, libraryPath, parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Log.v("xx", "PluginClassLoader findClass " + name);
        return super.findClass(name);
    }
}
