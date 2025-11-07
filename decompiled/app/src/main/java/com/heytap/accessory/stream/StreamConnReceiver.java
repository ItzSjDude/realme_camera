package com.heytap.accessory.stream;

/* loaded from: classes2.dex */
public class StreamConnReceiver extends android.content.BroadcastReceiver {
    public static final java.lang.String INTERNAL_STREAM_REQUEST_ACTION = "com.heytap.accessory.streamconnection.internal";
    private java.lang.String TAG = com.heytap.accessory.stream.StreamConnReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(this.TAG, "onReceive");
        if (intent != null) {
            try {
                if (intent.getAction() == null || !com.heytap.accessory.stream.StreamTransfer.ACTION_STREAM_TRANSFER_REQUESTED.equalsIgnoreCase(intent.getAction())) {
                    return;
                }
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(this.TAG, "Intent action is_renamed " + intent.getAction());
                try {
                    java.lang.String stringExtra = intent.getStringExtra("agentClass");
                    com.heytap.accessory.a_renamed.a_renamed.b_renamed(this.TAG, "onReceive: implClass".concat(java.lang.String.valueOf(stringExtra)));
                    com.heytap.accessory.stream.StreamTransfer streamTransferC = com.heytap.accessory.stream.a_renamed.c_renamed(stringExtra);
                    if (streamTransferC != null) {
                        streamTransferC.informIncomingSTRequest(context, intent);
                    } else {
                        com.heytap.accessory.a_renamed.a_renamed.e_renamed(this.TAG, "onReceive:streamTransfer is_renamed null");
                    }
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
            } catch (java.lang.Exception e2) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(this.TAG, "StreamConnReceiver receive exception", e2);
            }
        }
    }
}
