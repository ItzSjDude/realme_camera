package android.app;

import android.content.Context;

/* loaded from: classes2.dex */
public class OplusWhiteListManager {
    private static OplusWhiteListManager sInstance;

    public OplusWhiteListManager(Context context) {
    }

    public static OplusWhiteListManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new OplusWhiteListManager(context);
        }
        return sInstance;
    }

    public void addAppToDynamicList(String str) {
    }

    public boolean isAppInDynamicList(String str) {
        return false;
    }

    public void removeAppFromDynamicList(String str) {
    }
}
