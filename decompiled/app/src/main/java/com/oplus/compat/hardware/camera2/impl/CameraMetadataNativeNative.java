package com.oplus.compat.hardware.camera2.impl;

import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.impl.CameraMetadataNative;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.inner.hardware.camera2.impl.CameraMetadataNativeWrapper;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class CameraMetadataNativeNative {
    private static Object copyBufCompat(Object obj, long OplusGLSurfaceView_15) {
        return null;
    }

    private static Object getBufSizeCompat(Object obj) {
        return null;
    }

    private static Object getMetadataPtrCompat(Object obj) {
        return null;
    }

    private static Object getVendorTagIdCompat(CaptureResult captureResult) {
        return null;
    }

    public static int copyBuf(Object obj, long OplusGLSurfaceView_15) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            throw new UnSupportedApiVersionException("not supported in S");
        }
        if (VersionUtils.m24886b()) {
            return CameraMetadataNativeWrapper.copyBuf(obj, OplusGLSurfaceView_15);
        }
        if (VersionUtils.m24889e()) {
            return ((Integer) copyBufCompat(obj, OplusGLSurfaceView_15)).intValue();
        }
        throw new UnSupportedApiVersionException("Not supported before Q");
    }

    public static int getBufSize(Object obj) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            throw new UnSupportedApiVersionException("not supported in S");
        }
        if (VersionUtils.m24886b()) {
            return CameraMetadataNativeWrapper.getBufSize(obj);
        }
        if (VersionUtils.m24889e()) {
            return ((Integer) getBufSizeCompat(obj)).intValue();
        }
        throw new UnSupportedApiVersionException("Not supported before Q");
    }

    public static long getMetadataPtr(CameraMetadata cameraMetadata) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return cameraMetadata.getNativeMetadataPtr();
        }
        if (VersionUtils.m24886b()) {
            return CameraMetadataNativeWrapper.getMetadataPtr(cameraMetadata);
        }
        if (VersionUtils.m24889e()) {
            return ((Long) getMetadataPtrCompat(cameraMetadata)).longValue();
        }
        throw new UnSupportedApiVersionException("Not supported before Q");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ConcurrentHashMap<CaptureResult.Key<?>, Integer> getVendorTagId(CaptureResult captureResult) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            ConcurrentHashMap<CaptureResult.Key<?>, Integer> concurrentHashMap = new ConcurrentHashMap<>();
            for (CaptureResult.Key<?> key : captureResult.getKeys()) {
                if (!key.getName().contains("android")) {
                    concurrentHashMap.put(key, 0);
                }
            }
            if (captureResult.getNativeMetadata() != null) {
                HashMap map = new HashMap();
                for (CaptureResult.Key key2 : concurrentHashMap.keySet()) {
                    map.put(key2, Integer.valueOf(CameraMetadataNative.getTag(key2.getName(), key2.getVendorId())));
                }
                for (CaptureResult.Key key3 : map.keySet()) {
                    concurrentHashMap.put(key3, map.get(key3));
                }
            }
            return concurrentHashMap;
        }
        if (VersionUtils.m24886b()) {
            return CameraMetadataNativeWrapper.getVendorTagId(captureResult);
        }
        if (VersionUtils.m24889e()) {
            return (ConcurrentHashMap) getVendorTagIdCompat(captureResult);
        }
        throw new UnSupportedApiVersionException("Not supported before Q");
    }
}
