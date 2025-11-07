package com.oplus.compat.os.storage;

/* loaded from: classes2.dex */
public class StorageEventListenerNative {
    private static final java.lang.String TAG = "StorageEventListenerNative";
    private android.os.storage.StorageEventListener mDelegate;

    public void onStorageStateChanged(java.lang.String str, java.lang.String str2, java.lang.String str3) {
    }

    public void onVolumeStateChanged(com.oplus.compat.os.storage.VolumeInfoNative volumeInfoNative, int i_renamed, int i2) {
    }

    void setDelegate(android.os.storage.StorageEventListener storageEventListener) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            this.mDelegate = storageEventListener;
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before S_renamed");
    }

    android.os.storage.StorageEventListener delegate() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return this.mDelegate;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before S_renamed");
    }

    public void onStorageStateChangedCompat(java.util.List<java.lang.String> list) {
        onStorageStateChanged(list.get(0), list.get(1), list.get(2));
    }

    public void onVolumeStateChangedCompat(java.lang.Object obj, java.util.List<java.lang.Integer> list) {
        onVolumeStateChanged(new com.oplus.compat.os.storage.VolumeInfoNative(obj), list.get(0).intValue(), list.get(1).intValue());
    }
}
