package com.heytap.accessory.platform;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.BaseJobService;
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
public final class ServiceConnectionIndicationReceiver extends BroadcastReceiver {
    private final String TAG = ServiceConnectionIndicationReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) throws ClassNotFoundException {
        ComponentName componentNameStartService;
        SdkLog.m8378b(this.TAG, "onReceive");
        if (intent == null || intent.getAction() == null || !"com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED".equalsIgnoreCase(intent.getAction())) {
            return;
        }
        SdkLog.m8381c(this.TAG, "Incoming service connection request received.");
        try {
            new SdkConfig(context);
            try {
                String stringExtra = intent.getStringExtra(AFConstants.EXTRA_AGENT_IMPL_CLASS);
                if (stringExtra == null) {
                    SdkLog.m8383e(this.TAG, "Impl class not available in intent. Ignoring request");
                    return;
                }
                SdkLog.m8375a(this.TAG, "Connection request will be handled by :".concat(String.valueOf(stringExtra)));
                Class<?> cls = Class.forName(stringExtra);
                if (isValidImplClass(context, cls.getName())) {
                    boolean zM8581a = ClassUtils.m8581a(BaseJobAgent.class, cls);
                    boolean z = false;
                    int OplusGLSurfaceView_13 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
                    boolean z2 = Build.VERSION.SDK_INT >= 21 && OplusGLSurfaceView_13 >= 21;
                    if (Build.VERSION.SDK_INT >= 26 && OplusGLSurfaceView_13 >= 26) {
                        z = true;
                    }
                    intent.setClassName(context, stringExtra);
                    if (zM8581a && z2) {
                        BaseJobService.scheduleSCJob(context.getApplicationContext(), stringExtra, intent.getLongExtra("transactionId", 0L), intent.getStringExtra(AFConstants.EXTRA_AGENT_ID), (PeerAgent) intent.getParcelableExtra(AFConstants.EXTRA_PEER_AGENT));
                        return;
                    }
                    if (z) {
                        SdkLog.m8378b(this.TAG, "startForegroundService");
                        componentNameStartService = context.startForegroundService(intent);
                    } else {
                        SdkLog.m8378b(this.TAG, "startService");
                        componentNameStartService = context.startService(intent);
                    }
                    if (componentNameStartService == null) {
                        SdkLog.m8383e(this.TAG, "Agent " + stringExtra + " not found. Check Accessory Service XML for serviceImpl attribute");
                    }
                }
            } catch (ClassNotFoundException COUIBaseListPopupWindow_8) {
                SdkLog.m8383e(this.TAG, "Agent Impl class not found!".concat(String.valueOf(COUIBaseListPopupWindow_8)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (GeneralException e3) {
            SdkLog.m8383e(this.TAG, "SDK config init failed.".concat(String.valueOf(e3)));
        }
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
                SdkLog.m8383e(this.TAG, "fetch service profile description failed !!");
            }
        } else {
            SdkLog.m8383e(this.TAG, "config  util default instance  creation failed !!");
        }
        return z;
    }
}
