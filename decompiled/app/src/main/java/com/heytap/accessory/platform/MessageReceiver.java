package com.heytap.accessory.platform;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.BaseJobService;
import com.heytap.accessory.BaseMessage;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.ClassUtils;
import com.heytap.accessory.p104b.ConfigUtil;
import com.heytap.accessory.p104b.SdkConfig;

@TargetApi(26)
/* loaded from: classes2.dex */
public final class MessageReceiver extends BroadcastReceiver {
    private static String TAG = "MessageReceiver";

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) throws ClassNotFoundException {
        ComponentName componentNameStartService;
        if (intent != null && intent.getAction() != null) {
            if (BaseMessage.ACTION_ACCESSORY_MESSAGE_RECEIVED.equalsIgnoreCase(intent.getAction())) {
                SdkLog.m8378b(TAG, "Incoming Data Received!!!");
                try {
                    new SdkConfig(context);
                    try {
                        String stringExtra = intent.getStringExtra(AFConstants.EXTRA_AGENT_IMPL_CLASS);
                        if (stringExtra == null) {
                            SdkLog.m8383e(TAG, "Impl class not available in intent. ignoring message received");
                            return;
                        }
                        Class<?> cls = Class.forName(stringExtra);
                        if (!isValidImplClass(context, cls.getName())) {
                            SdkLog.m8382d(TAG, "invalid impl class: " + cls.getName());
                            return;
                        }
                        boolean z = false;
                        int OplusGLSurfaceView_13 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
                        if (Build.VERSION.SDK_INT >= 26 && OplusGLSurfaceView_13 >= 26) {
                            z = true;
                        }
                        intent.setClassName(context, stringExtra);
                        if (ClassUtils.m8581a(BaseJobAgent.class, cls) && z) {
                            BaseJobService.scheduleMessageJob(context.getApplicationContext(), stringExtra, intent.getLongExtra("transactionId", 0L), intent.getStringExtra(AFConstants.EXTRA_AGENT_ID), (PeerAgent) intent.getParcelableExtra(AFConstants.EXTRA_PEER_AGENT));
                            return;
                        }
                        if (z) {
                            componentNameStartService = context.startForegroundService(intent);
                        } else {
                            componentNameStartService = context.startService(intent);
                        }
                        if (componentNameStartService == null) {
                            SdkLog.m8383e(TAG, "Agent " + stringExtra + " not found. Check Accessory Service XML for serviceImpl attribute");
                            return;
                        }
                        return;
                    } catch (ClassNotFoundException COUIBaseListPopupWindow_8) {
                        SdkLog.m8383e(TAG, "Agent Impl class not found!".concat(String.valueOf(COUIBaseListPopupWindow_8)));
                        return;
                    } catch (Exception e2) {
                        SdkLog.m8379b(TAG, "", e2);
                        return;
                    }
                } catch (GeneralException e3) {
                    SdkLog.m8383e(TAG, "SDK config initialization failed.".concat(String.valueOf(e3)));
                    return;
                }
            }
            return;
        }
        SdkLog.m8378b(TAG, "received null intent!");
    }

    private synchronized boolean isValidImplClass(Context context, String str) {
        boolean z;
        z = false;
        ConfigUtil c2161dM8582a = ConfigUtil.m8582a(context);
        if (c2161dM8582a != null) {
            ServiceProfile serviceProfileM8584a = c2161dM8582a.m8584a(str);
            if (serviceProfileM8584a != null) {
                if (str.equalsIgnoreCase(serviceProfileM8584a.getServiceImpl())) {
                    z = true;
                }
            } else {
                SdkLog.m8383e(TAG, "fetch service profile description failed !!");
            }
        } else {
            SdkLog.m8383e(TAG, "config  util default instance  creation failed !!");
        }
        return z;
    }
}
