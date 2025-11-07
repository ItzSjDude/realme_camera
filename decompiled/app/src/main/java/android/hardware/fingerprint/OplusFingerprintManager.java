package android.hardware.fingerprint;

/* loaded from: classes.dex */
public class OplusFingerprintManager {
    public static final int KEYCODE_SYSTEM_FINGERPRINT_KEYMODE = -1;
    private static java.lang.String TAG = "OplusFingerprintManager";

    public OplusFingerprintManager() {
    }

    public OplusFingerprintManager(android.content.Context context) {
    }

    public void setFingerKeymode(int i_renamed) {
        android.util.Log.d_renamed(TAG, "setFingerKeymode for test, enable: " + i_renamed);
    }

    public void setFingerKeymode(int i_renamed, int i2) {
        android.util.Log.d_renamed(TAG, "setFingerKeymode for test, enable: " + i_renamed + ", id_renamed:" + i2);
    }
}
