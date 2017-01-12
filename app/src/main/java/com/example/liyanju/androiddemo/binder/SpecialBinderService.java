package com.example.liyanju.androiddemo.binder;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by liyanju on 2016/11/29.
 */
public class SpecialBinderService extends Service{

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    IServiceBinder.Stub specialBinder = new IServiceBinder.Stub(){

         String name;

         @Override
         public void setName(String name) throws RemoteException {
             try {
                 Thread.sleep(4000);
             } catch (Exception e) {
                 e.printStackTrace();
             }
            Log.v("XX", " getName getCallingPid: " + Binder.getCallingPid());
            this.name = name;
         }

         @Override
         public String getName() throws RemoteException {
             Log.v("XX", " SpecialBinderService getName name " + name);
             return name;
         }
     };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MyMessage myMessage = intent.getParcelableExtra("messager");

        try {
            myMessage.getClientBinder().onCallBack(specialBinder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
