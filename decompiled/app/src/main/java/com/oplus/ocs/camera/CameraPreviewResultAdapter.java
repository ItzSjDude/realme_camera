package com.oplus.ocs.camera;

import android.hardware.camera2.CaptureResult;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
abstract class CameraPreviewResultAdapter {
    public void addRef() {
    }

    public void close() {
    }

    public <T> T get(CaptureResult.Key<T> key) {
        return null;
    }

    public <T> T get(String str, Class<T> cls, T t) {
        return null;
    }

    public ConcurrentHashMap<String, Integer> getApsTotalResult() {
        return null;
    }

    public CaptureResult getCaptureResult() {
        return null;
    }

    CameraPreviewResultAdapter() {
    }
}
