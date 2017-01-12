package com.example.liyanju.androiddemo.plugin;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;

import dalvik.system.BaseDexClassLoader;

/**
 * Created by liyanju on 2016/12/21.
 */

public class MyClassLoader extends ClassLoader {

    public MyClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    private ArrayList<PluginClassLoader> mPluginClassLoaderList = new ArrayList<PluginClassLoader>();

    public void addPluginClassLoader(String dexPath, String optimizedDirectory, String libraryPath) {
        PluginClassLoader pluginClassLoader = new PluginClassLoader(dexPath, new File(optimizedDirectory), libraryPath, getParent());
        mPluginClassLoaderList.add(pluginClassLoader);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Log.v("XX", "findClass:: " + name);
        for (PluginClassLoader pluginClassLoader : mPluginClassLoaderList) {
            Class clazz = pluginClassLoader.findClass(name);
            if (clazz != null) {
                return clazz;
            }
        }

        throw new ClassNotFoundException( name + " ！！not find " + this);
    }
}
