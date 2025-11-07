package com.oplus.camera.update;

/* loaded from: classes2.dex */
public class UpdateReceiver extends android.content.BroadcastReceiver {
    public static final java.lang.String ACTION_OTA_SUCCESSED = "oplus.intent.action.OPLUS_OTA_UPDATE_SUCCESSED";
    public static final java.lang.String ROM_UPDATE_ACTION = "oplus.intent.action.ROM_UPDATE_CONFIG_SUCCESS";
    private static final java.lang.String TAG = "UpdateReceiver";
    private static final java.lang.String UPDATE_LIST_KEY = "ROM_UPDATE_CONFIG_LIST";

    @Override // android.content.BroadcastReceiver
    public void onReceive(final android.content.Context context, android.content.Intent intent) {
        java.lang.String action = intent.getAction();
        if (ROM_UPDATE_ACTION.equals(action)) {
            java.util.ArrayList<java.lang.String> stringArrayListExtra = null;
            try {
                stringArrayListExtra = intent.getStringArrayListExtra(UPDATE_LIST_KEY);
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
            com.oplus.camera.e_renamed.a_renamed(TAG, "onReceive, updateList: " + stringArrayListExtra);
            if (stringArrayListExtra != null) {
                com.oplus.camera.update.UpdateUtil.getInstance(context).startUpdate(stringArrayListExtra.contains(com.oplus.camera.update.UpdateUtil.APP_TO_UPDATE), stringArrayListExtra.contains(com.oplus.camera.update.UpdateUtil.APS_TO_UPDATE));
                return;
            }
            return;
        }
        if (ACTION_OTA_SUCCESSED.equals(action)) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "onReceive, action: " + action);
            com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.update.-$$Lambda$UpdateReceiver$cmx9-HgcM5Apzpu63lGFVNS6V6k
                @Override // java.lang.Runnable
                public final void run() {
                    com.oplus.camera.update.UpdateReceiver.lambda$onReceive$0(context);
                }
            }, "removeDynamicShortcuts");
        }
    }

    static /* synthetic */ void lambda$onReceive$0(android.content.Context context) {
        if (context != null) {
            com.oplus.camera.util.Util.u_renamed(context);
        }
        if (com.oplus.camera.util.Util.i_renamed()) {
            return;
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
