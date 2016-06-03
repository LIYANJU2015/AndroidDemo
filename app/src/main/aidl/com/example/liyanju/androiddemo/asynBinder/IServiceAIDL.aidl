// IServiceAIDL.aidl
package com.example.liyanju.androiddemo.asynBinder;

// Declare any non-default types here with import statements
import com.example.liyanju.androiddemo.asynBinder.IServiceCallBackAIDL;

interface IServiceAIDL {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);


   void setCallBackBinder(in IServiceCallBackAIDL callBack);
}
