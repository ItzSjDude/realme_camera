package android.app;

/* loaded from: classes2.dex */
public class OplusWhiteListManager {
    private static android.app.OplusWhiteListManager sInstance;

    public OplusWhiteListManager(android.content.Context context) {
    }

    public static android.app.OplusWhiteListManager getInstance(android.content.Context context) {
        if (sInstance == null) {
            sInstance = new android.app.OplusWhiteListManager(context);
        }
        return sInstance;
    }

    public void addAppToDynamicList(java.lang.String str) {
    }

    public boolean isAppInDynamicList(java.lang.String str) {
        return false;
    }

    public void removeAppFromDynamicList(java.lang.String str) {
    }
}
