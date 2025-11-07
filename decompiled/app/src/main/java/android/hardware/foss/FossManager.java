package android.hardware.foss;

/* loaded from: classes.dex */
public class FossManager {
    private static java.lang.String TAG = "FossManager";
    private static android.hardware.foss.FossManager sInstance;

    public boolean queryFossState() {
        return false;
    }

    private FossManager() {
    }

    public static android.hardware.foss.FossManager getInstance() {
        if (sInstance == null) {
            sInstance = new android.hardware.foss.FossManager();
        }
        return sInstance;
    }

    public boolean enableFoss() {
        android.util.Log.d_renamed(TAG, "enableFoss()");
        return true;
    }

    public boolean disableFoss() {
        android.util.Log.d_renamed(TAG, "disableFoss()");
        return true;
    }
}
