package com.example.liyanju.androiddemo.customview.coupondisplay;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;

import com.example.liyanju.androiddemo.R;

/**
 * Created by liyanju on 16/7/26.
 */
public class MyCouponDisplayActivity extends Activity {

    private static final String ACTION_NOTIFICATION_LISTENER_SETTINGS = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS";

    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_coupon_display);



        startActivity(new Intent(ACTION_NOTIFICATION_LISTENER_SETTINGS));
    }

    private boolean isEnabled() {
        String pkgName = getPackageName();

        final String flat = Settings.Secure.getString(getContentResolver(),
                ENABLED_NOTIFICATION_LISTENERS);
        if (!TextUtils.isEmpty(flat)) {
            final String[] names = flat.split(":");
            for (int i = 0; i < names.length; i++) {
                final ComponentName cn = ComponentName.unflattenFromString(names[i]);
                if (cn != null) {
                    if (TextUtils.equals(pkgName, cn.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
