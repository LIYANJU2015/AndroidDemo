package com.example.liyanju.androiddemo.binder;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by liyanju on 2016/11/29.
 */
public class MyMessage implements Parcelable {

    private IBinder mClientBinder;


    public MyMessage(IBinder clientBinder) {
        mClientBinder = clientBinder;
    }

    private MyMessage(Parcel in) {
        mClientBinder = in.readStrongBinder();
    }

    public IClientCallBack getClientBinder() {
        Log.v("XX", "MyMessage getClientBinder " + mClientBinder);
        return IClientCallBack.Stub.asInterface(mClientBinder);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(mClientBinder);
    }

    public static final Creator<MyMessage> CREATOR = new Creator<MyMessage>() {
        @Override
        public MyMessage createFromParcel(Parcel source) {
            return new MyMessage(source);
        }

        @Override
        public MyMessage[] newArray(int size) {
            return new MyMessage[size];
        }
    };
}
