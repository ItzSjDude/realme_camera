package com.heytap.accessory.file;

/* loaded from: classes2.dex */
public class FTConnReceiver extends android.content.BroadcastReceiver {
    private static final java.lang.String INTERNAL_FTREQUEST_ACTION = "com.heytap.accessory.ftconnection.internal";
    private java.lang.String TAG = com.heytap.accessory.file.FTConnReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.heytap.accessory.a_renamed.a_renamed.b_renamed(this.TAG, "onReceive");
        if (intent != null) {
            try {
                if (intent.getAction() == null || !com.heytap.accessory.file.FileTransfer.ACTION_AFP_FILE_TRANSFER_REQUESTED.equalsIgnoreCase(intent.getAction())) {
                    return;
                }
                com.heytap.accessory.a_renamed.a_renamed.c_renamed(this.TAG, "Intent action is_renamed " + intent.getAction());
                java.lang.String stringExtra = intent.getStringExtra("agentClass");
                android.util.Log.d_renamed(this.TAG, "onReceive: implClass".concat(java.lang.String.valueOf(stringExtra)));
                com.heytap.accessory.file.FileTransfer fileTransferD = com.heytap.accessory.file.FileTransferManager.d_renamed(stringExtra);
                if (fileTransferD != null) {
                    fileTransferD.informIncomingFTRequest(context, intent);
                } else {
                    android.util.Log.e_renamed(this.TAG, "onReceive:fileTransfer is_renamed null");
                }
            } catch (java.lang.Exception e_renamed) {
                com.heytap.accessory.a_renamed.a_renamed.b_renamed(this.TAG, "FTConnReceiver receive exception", e_renamed);
            }
        }
    }
}
