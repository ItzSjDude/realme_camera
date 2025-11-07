package com.oplus.uifirst;

/* loaded from: classes2.dex */
public class OplusUIFirstManager {
    private static final java.lang.String TAG = "OplusUIFirstManager";
    private static volatile com.oplus.uifirst.OplusUIFirstManager sInstance;

    public static com.oplus.uifirst.OplusUIFirstManager getInstance() {
        if (sInstance == null) {
            synchronized (com.oplus.uifirst.OplusUIFirstManager.class) {
                if (sInstance == null) {
                    sInstance = new com.oplus.uifirst.OplusUIFirstManager();
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

    public void setUxThreadValue(int pid, int tid, java.lang.String value) {
        android.util.Log.d_renamed(TAG, "setUxThreadValue stub: pid=" + pid + " tid=" + tid + " value=" + value);
    }
}
