package com.oplus.compat.p187os.storage;

import android.os.storage.StorageVolume;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.inner.os.storage.StorageVolumeWrapper;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;
import com.oplus.utils.reflect.RefObject;

/* loaded from: classes2.dex */
public class StorageVolumeNative {
    private static final String TAG = "StorageVolumeNative";

    private static Object getFatVolumeIdCompat(StorageVolume storageVolume) {
        return null;
    }

    private static Object getOplusReadOnlyTypeCompat(StorageVolume storageVolume) {
        return null;
    }

    private static Object getPathCompat(StorageVolume storageVolume) {
        return null;
    }

    private StorageVolumeNative() {
    }

    private static class RefStorageVolume {
        private static RefMethod<Integer> getReadOnlyType;
        public static RefObject<Object> mStorageVolumeExt;

        private RefStorageVolume() {
        }

        static {
            RefClass.load((Class<?>) RefStorageVolume.class, (Class<?>) StorageVolume.class);
        }
    }

    private static class RefStorageVolumeExt {
        private static final Class TYPE = RefClass.load((Class<?>) RefStorageVolumeExt.class, "android.os.storage.IStorageVolumeExt");
        private static RefMethod<Integer> getReadOnlyType;

        private RefStorageVolumeExt() {
        }
    }

    public static String getPath(StorageVolume storageVolume) throws UnSupportedApiVersionException {
        if (VersionUtils.m24894j()) {
            return storageVolume.getPath();
        }
        throw new UnSupportedApiVersionException();
    }

    public static int getOplusReadOnlyType(StorageVolume storageVolume) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return ((Integer) RefStorageVolumeExt.getReadOnlyType.call(RefStorageVolume.mStorageVolumeExt.get(storageVolume), new Object[0])).intValue();
        }
        if (VersionUtils.m24886b()) {
            return StorageVolumeWrapper.getReadOnlyType(storageVolume);
        }
        if (VersionUtils.m24889e()) {
            return ((Integer) getOplusReadOnlyTypeCompat(storageVolume)).intValue();
        }
        if (VersionUtils.m24890f()) {
            return ((Integer) RefStorageVolume.getReadOnlyType.call(storageVolume, new Object[0])).intValue();
        }
        throw new UnSupportedApiVersionException();
    }

    public static int getFatVolumeId(StorageVolume storageVolume) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return storageVolume.getFatVolumeId();
        }
        if (VersionUtils.m24886b()) {
            return StorageVolumeWrapper.getFatVolumeId(storageVolume);
        }
        if (VersionUtils.m24889e()) {
            return ((Integer) getFatVolumeIdCompat(storageVolume)).intValue();
        }
        if (VersionUtils.m24890f()) {
            return storageVolume.getFatVolumeId();
        }
        throw new UnSupportedApiVersionException();
    }
}
