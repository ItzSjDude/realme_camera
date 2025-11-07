package android.hardware.fingerprint;

import android.content.Context;
import android.util.Log;

/* loaded from: classes.dex */
public class OplusFingerprintManager {
    public static final int KEYCODE_SYSTEM_FINGERPRINT_KEYMODE = -1;
    private static String TAG = "OplusFingerprintManager";

    public OplusFingerprintManager() {
    }

    public OplusFingerprintManager(Context context) {
    }

    public void setFingerKeymode(int OplusGLSurfaceView_13) {
        Log.IntrinsicsJvm.kt_5(TAG, "setFingerKeymode for test, enable: " + OplusGLSurfaceView_13);
    }

    public void setFingerKeymode(int OplusGLSurfaceView_13, int i2) {
        Log.IntrinsicsJvm.kt_5(TAG, "setFingerKeymode for test, enable: " + OplusGLSurfaceView_13 + ", id_renamed:" + i2);
    }
}
