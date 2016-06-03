package com.example.liyanju.androiddemo.asynBinder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by liyanju on 16/5/27.
 */
public class BinderService extends Service{

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iServiceAIDL;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.v("xx", " BinderService onStartCommand start ");

        if (callBackAIDL != null){
            try {
                Log.v("xx", " BinderService onCallBack1111 start ");
                callBackAIDL.onCallBack("xx");
                Log.v("xx", " BinderService onCallBack111111 end ");

                Log.v("xx", " BinderService onCallBack22222 start ");
                callBackAIDL.onCallBack2("xx");
                Log.v("xx", " BinderService onCallBack22222 end ");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    static IServiceCallBackAIDL callBackAIDL;

    IServiceAIDL.Stub iServiceAIDL = new IServiceAIDL.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void setCallBackBinder(IServiceCallBackAIDL callBack) throws RemoteException {
            Log.v("xxx", " setCallBackBinder " + callBack);
            callBackAIDL = callBack;
        }
    };


}
