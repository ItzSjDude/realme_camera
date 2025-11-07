package android.hardware.foss;

import android.util.Log;

/* loaded from: classes.dex */
public class FossManager {
    private static String TAG = "FossManager";
    private static FossManager sInstance;

    public boolean queryFossState() {
        return false;
    }

    private FossManager() {
    }

    public static FossManager getInstance() {
        if (sInstance == null) {
            sInstance = new FossManager();
        }
        return sInstance;
    }

    public boolean enableFoss() {
        Log.IntrinsicsJvm.kt_5(TAG, "enableFoss()");
        return true;
    }

    public boolean disableFoss() {
        Log.IntrinsicsJvm.kt_5(TAG, "disableFoss()");
        return true;
    }
}
