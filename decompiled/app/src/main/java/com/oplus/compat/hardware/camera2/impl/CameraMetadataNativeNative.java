package com.oplus.compat.hardware.camera2.impl;

/* loaded from: classes2.dex */
public class CameraMetadataNativeNative {
    private static java.lang.Object copyBufCompat(java.lang.Object obj, long j_renamed) {
        return null;
    }

    private static java.lang.Object getBufSizeCompat(java.lang.Object obj) {
        return null;
    }

    private static java.lang.Object getMetadataPtrCompat(java.lang.Object obj) {
        return null;
    }

    private static java.lang.Object getVendorTagIdCompat(android.hardware.camera2.CaptureResult captureResult) {
        return null;
    }

    public static int copyBuf(java.lang.Object obj, long j_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported in_renamed S_renamed");
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.hardware.camera2.impl.CameraMetadataNativeWrapper.copyBuf(obj, j_renamed);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Integer) copyBufCompat(obj, j_renamed)).intValue();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before Q_renamed");
    }

    public static int getBufSize(java.lang.Object obj) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported in_renamed S_renamed");
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.hardware.camera2.impl.CameraMetadataNativeWrapper.getBufSize(obj);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Integer) getBufSizeCompat(obj)).intValue();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before Q_renamed");
    }

    public static long getMetadataPtr(android.hardware.camera2.CameraMetadata cameraMetadata) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return cameraMetadata.getNativeMetadataPtr();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.hardware.camera2.impl.CameraMetadataNativeWrapper.getMetadataPtr(cameraMetadata);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Long) getMetadataPtrCompat(cameraMetadata)).longValue();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before Q_renamed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static java.util.concurrent.ConcurrentHashMap<android.hardware.camera2.CaptureResult.Key<?>, java.lang.Integer> getVendorTagId(android.hardware.camera2.CaptureResult captureResult) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            java.util.concurrent.ConcurrentHashMap<android.hardware.camera2.CaptureResult.Key<?>, java.lang.Integer> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>();
            for (android.hardware.camera2.CaptureResult.Key<?> key : captureResult.getKeys()) {
                if (!key.getName().contains("android")) {
                    concurrentHashMap.put(key, 0);
                }
            }
            if (captureResult.getNativeMetadata() != null) {
                java.util.HashMap map = new java.util.HashMap();
                for (android.hardware.camera2.CaptureResult.Key key2 : concurrentHashMap.keySet()) {
                    map.put(key2, java.lang.Integer.valueOf(android.hardware.camera2.impl.CameraMetadataNative.getTag(key2.getName(), key2.getVendorId())));
                }
                for (android.hardware.camera2.CaptureResult.Key key3 : map.keySet()) {
                    concurrentHashMap.put(key3, map.get(key3));
                }
            }
            return concurrentHashMap;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.hardware.camera2.impl.CameraMetadataNativeWrapper.getVendorTagId(captureResult);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (java.util.concurrent.ConcurrentHashMap) getVendorTagIdCompat(captureResult);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before Q_renamed");
    }
}
