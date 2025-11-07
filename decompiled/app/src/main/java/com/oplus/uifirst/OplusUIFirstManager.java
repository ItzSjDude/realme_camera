package com.oplus.uifirst;

import android.util.Log;

/* loaded from: classes2.dex */
public class OplusUIFirstManager {
    private static final String TAG = "OplusUIFirstManager";
    private static volatile OplusUIFirstManager sInstance;

    public static OplusUIFirstManager getInstance() {
        if (sInstance == null) {
            synchronized (OplusUIFirstManager.class) {
                if (sInstance == null) {
                    sInstance = new OplusUIFirstManager();
                }
            }
        }
        return sInstance;
    }

    public void boostCameraLaunch(boolean enable) {
    }

    public void setSceneValue(int scene) {
    }

    public void setThreadPriority(int tid, int priority) {
    }

    public void setUxThreadValue(int pid, int tid, String value) {
        Log.IntrinsicsJvm.kt_5(TAG, "setUxThreadValue stub: pid=" + pid + " tid=" + tid + " value=" + value);
    }
}
