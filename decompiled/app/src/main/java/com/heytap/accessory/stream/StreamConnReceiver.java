package com.heytap.accessory.stream;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.heytap.accessory.p103a.SdkLog;

/* loaded from: classes2.dex */
public class StreamConnReceiver extends BroadcastReceiver {
    public static final String INTERNAL_STREAM_REQUEST_ACTION = "com.heytap.accessory.streamconnection.internal";
    private String TAG = StreamConnReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SdkLog.m8378b(this.TAG, "onReceive");
        if (intent != null) {
            try {
                if (intent.getAction() == null || !StreamTransfer.ACTION_STREAM_TRANSFER_REQUESTED.equalsIgnoreCase(intent.getAction())) {
                    return;
                }
                SdkLog.m8381c(this.TAG, "Intent action is " + intent.getAction());
                try {
                    String stringExtra = intent.getStringExtra("agentClass");
                    SdkLog.m8378b(this.TAG, "onReceive: implClass".concat(String.valueOf(stringExtra)));
                    StreamTransfer streamTransferM8699c = StreamTransferManager.m8699c(stringExtra);
                    if (streamTransferM8699c != null) {
                        streamTransferM8699c.informIncomingSTRequest(context, intent);
                    } else {
                        SdkLog.m8383e(this.TAG, "onReceive:streamTransfer is null");
                    }
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            } catch (Exception e2) {
                SdkLog.m8379b(this.TAG, "StreamConnReceiver receive exception", e2);
            }
        }
    }
}
