package com.example.liyanju.androiddemo;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.android.internal.telephony.ITelephony;

import java.lang.reflect.Method;

/**
 * Created by liyanju on 16/8/5.
 */
public class NotificationListener extends NotificationListenerService {



    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        Log.v("XXX", "onNotificationPosted >>>>>>>> " + sbn.getPackageName());
        try {
            getITelephony(AppApplication.sContext).cancelMissedCallsNotification();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        //cancelAllNotifications();

        if (sbn.getPackageName().equals("com.android.phone")) {
            cancelNotification(sbn.getPackageName(), sbn.getTag(), sbn.getId());
        }

        stopCall();
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {

    }

    public void stopCall() {

        try {
            Method method = Class.forName("android.os.ServiceManager").getMethod("getService", String.class);
            // 获取远程TELEPHONY_SERVICE的IBinder对象的代理
            IBinder binder = (IBinder) method.invoke(null, new Object[] { "phone" });
            // 将IBinder对象的代理转换为ITelephony对象
            ITelephony telephony = ITelephony.Stub.asInterface(binder);
            // 挂断电话
           // telephony.endCall();
            telephony.cancelMissedCallsNotification();
        } catch (Exception e) {
        }

    }

    private static ITelephony getITelephony(Context context) {
        ITelephony iTelephony=null;
        TelephonyManager mTelephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        Class<TelephonyManager> c = TelephonyManager.class;
        Method getITelephonyMethod = null;
        try {
            getITelephonyMethod = c.getDeclaredMethod("getITelephony",
                    (Class[]) null); // 获取声明的方法
            getITelephonyMethod.setAccessible(true);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            iTelephony = (ITelephony) getITelephonyMethod.invoke(
                    mTelephonyManager, (Object[]) null); // 获取实例
            return iTelephony;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iTelephony;
    }
}
