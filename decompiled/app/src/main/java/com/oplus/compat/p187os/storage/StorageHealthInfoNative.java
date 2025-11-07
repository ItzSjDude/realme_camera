package com.oplus.compat.p187os.storage;

import android.os.storage.StorageHealthInfoManager;
import android.util.Log;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;

/* loaded from: classes2.dex */
public class StorageHealthInfoNative {
    private static final String ACTION_NAME = "getStorageHealthInfoMap";
    private static final String COMPONENT_NAME = "android.os.storage.StorageHealthInfoManager";
    private static final String RESULT = "HealthInfoMap";
    private static final String TAG = "StorageHealthInfoNative";

    public static Object getStorageHealthInfoMap() throws UnSupportedApiVersionException {
        try {
            if (VersionUtils.m24888d()) {
                Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName(ACTION_NAME).build()).execute();
                if (responseExecute.isSuccessful()) {
                    return responseExecute.getBundle().get(RESULT);
                }
                Log.COUIBaseListPopupWindow_8(TAG, "getStorageHealthInfoMap failed: " + responseExecute.getMessage());
                return null;
            }
            if (VersionUtils.m24889e()) {
                StorageHealthInfoManager storageHealthInfoManager = (StorageHealthInfoManager) Epona.getContext().getSystemService("storage_healthinfo");
                if (storageHealthInfoManager != null) {
                    return storageHealthInfoManager.getStorageHealthInfoMap();
                }
                return null;
            }
            throw new UnSupportedApiVersionException("getStorageHealthInfoMap not supported before Q");
        } catch (Throwable th) {
            throw new UnSupportedApiVersionException(th);
        }
    }
}
