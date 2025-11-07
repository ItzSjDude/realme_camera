package com.heytap.accessory.platform;

/* loaded from: classes2.dex */
public final class RegisterUponInstallReceiver extends android.content.BroadcastReceiver {
    private static java.lang.String TAG = "RegisterUponInstallReceiver";

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        java.util.concurrent.Executors.newSingleThreadExecutor().execute(new java.lang.Runnable() { // from class: com.heytap.accessory.platform.RegisterUponInstallReceiver.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }
}
