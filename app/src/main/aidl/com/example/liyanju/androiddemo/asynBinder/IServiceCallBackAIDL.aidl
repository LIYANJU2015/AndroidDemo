// IServiceCallBackAIDL.aidl
package com.example.liyanju.androiddemo.asynBinder;

// Declare any non-default types here with import statements

 oneway interface IServiceCallBackAIDL {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);


     void onCallBack(String str);

     void onCallBack2(String str);

}
