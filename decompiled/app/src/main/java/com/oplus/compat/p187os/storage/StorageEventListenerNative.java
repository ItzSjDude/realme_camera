package com.oplus.compat.p187os.storage;

import android.os.storage.StorageEventListener;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import java.util.List;

/* loaded from: classes2.dex */
public class StorageEventListenerNative {
    private static final String TAG = "StorageEventListenerNative";
    private StorageEventListener mDelegate;

    public void onStorageStateChanged(String str, String str2, String str3) {
    }

    public void onVolumeStateChanged(VolumeInfoNative volumeInfoNative, int OplusGLSurfaceView_13, int i2) {
    }

    void setDelegate(StorageEventListener storageEventListener) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            this.mDelegate = storageEventListener;
            return;
        }
        throw new UnSupportedApiVersionException("Not supported before S");
    }

    StorageEventListener delegate() throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return this.mDelegate;
        }
        throw new UnSupportedApiVersionException("Not supported before S");
    }

    public void onStorageStateChangedCompat(List<String> list) {
        onStorageStateChanged(list.get(0), list.get(1), list.get(2));
    }

    public void onVolumeStateChangedCompat(Object obj, List<Integer> list) {
        onVolumeStateChanged(new VolumeInfoNative(obj), list.get(0).intValue(), list.get(1).intValue());
    }
}
