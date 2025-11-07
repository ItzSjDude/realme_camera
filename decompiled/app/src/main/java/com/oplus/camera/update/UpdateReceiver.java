package com.oplus.camera.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.util.Util;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class UpdateReceiver extends BroadcastReceiver {
    public static final String ACTION_OTA_SUCCESSED = "oplus.intent.action.OPLUS_OTA_UPDATE_SUCCESSED";
    public static final String ROM_UPDATE_ACTION = "oplus.intent.action.ROM_UPDATE_CONFIG_SUCCESS";
    private static final String TAG = "UpdateReceiver";
    private static final String UPDATE_LIST_KEY = "ROM_UPDATE_CONFIG_LIST";

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        String action = intent.getAction();
        if (ROM_UPDATE_ACTION.equals(action)) {
            ArrayList<String> stringArrayListExtra = null;
            try {
                stringArrayListExtra = intent.getStringArrayListExtra(UPDATE_LIST_KEY);
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            CameraLog.m12954a(TAG, "onReceive, updateList: " + stringArrayListExtra);
            if (stringArrayListExtra != null) {
                UpdateUtil.getInstance(context).startUpdate(stringArrayListExtra.contains(UpdateUtil.APP_TO_UPDATE), stringArrayListExtra.contains(UpdateUtil.APS_TO_UPDATE));
                return;
            }
            return;
        }
        if (ACTION_OTA_SUCCESSED.equals(action)) {
            CameraLog.m12954a(TAG, "onReceive, action: " + action);
            CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.update.-$$Lambda$UpdateReceiver$cmx9-HgcM5Apzpu63lGFVNS6V6k
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateReceiver.lambda$onReceive$0(context);
                }
            }, "removeDynamicShortcuts");
        }
    }

    static /* synthetic */ void lambda$onReceive$0(Context context) {
        if (context != null) {
            Util.m24497u(context);
        }
        if (Util.m24462i()) {
            return;
        }
        Process.killProcess(Process.myPid());
    }
}
