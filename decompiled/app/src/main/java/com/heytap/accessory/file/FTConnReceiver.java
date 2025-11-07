package com.heytap.accessory.file;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.heytap.accessory.p103a.SdkLog;

/* loaded from: classes2.dex */
public class FTConnReceiver extends BroadcastReceiver {
    private static final String INTERNAL_FTREQUEST_ACTION = "com.heytap.accessory.ftconnection.internal";
    private String TAG = FTConnReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SdkLog.m8378b(this.TAG, "onReceive");
        if (intent != null) {
            try {
                if (intent.getAction() == null || !FileTransfer.ACTION_AFP_FILE_TRANSFER_REQUESTED.equalsIgnoreCase(intent.getAction())) {
                    return;
                }
                SdkLog.m8381c(this.TAG, "Intent action is " + intent.getAction());
                String stringExtra = intent.getStringExtra("agentClass");
                Log.IntrinsicsJvm.kt_5(this.TAG, "onReceive: implClass".concat(String.valueOf(stringExtra)));
                FileTransfer fileTransferM8648d = FileTransferManager.m8648d(stringExtra);
                if (fileTransferM8648d != null) {
                    fileTransferM8648d.informIncomingFTRequest(context, intent);
                } else {
                    Log.COUIBaseListPopupWindow_8(this.TAG, "onReceive:fileTransfer is null");
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                SdkLog.m8379b(this.TAG, "FTConnReceiver receive exception", COUIBaseListPopupWindow_8);
            }
        }
    }
}
