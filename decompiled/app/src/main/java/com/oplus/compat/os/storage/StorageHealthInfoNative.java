package com.oplus.compat.os.storage;

/* loaded from: classes2.dex */
public class StorageHealthInfoNative {
    private static final java.lang.String ACTION_NAME = "getStorageHealthInfoMap";
    private static final java.lang.String COMPONENT_NAME = "android.os.storage.StorageHealthInfoManager";
    private static final java.lang.String RESULT = "HealthInfoMap";
    private static final java.lang.String TAG = "StorageHealthInfoNative";

    public static java.lang.Object getStorageHealthInfoMap() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        try {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
                com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName(ACTION_NAME).build()).execute();
                if (responseExecute.isSuccessful()) {
                    return responseExecute.getBundle().get(RESULT);
                }
                android.util.Log.e_renamed(TAG, "getStorageHealthInfoMap failed: " + responseExecute.getMessage());
                return null;
            }
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                android.os.storage.StorageHealthInfoManager storageHealthInfoManager = (android.os.storage.StorageHealthInfoManager) com.oplus.epona.Epona.getContext().getSystemService("storage_healthinfo");
                if (storageHealthInfoManager != null) {
                    return storageHealthInfoManager.getStorageHealthInfoMap();
                }
                return null;
            }
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("getStorageHealthInfoMap not supported before Q_renamed");
        } catch (java.lang.Throwable th) {
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed(th);
        }
    }
}
