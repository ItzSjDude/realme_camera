package com.oplus.compat.os.storage;

/* loaded from: classes2.dex */
public class StorageVolumeNative {
    private static final java.lang.String TAG = "StorageVolumeNative";

    private static java.lang.Object getFatVolumeIdCompat(android.os.storage.StorageVolume storageVolume) {
        return null;
    }

    private static java.lang.Object getOplusReadOnlyTypeCompat(android.os.storage.StorageVolume storageVolume) {
        return null;
    }

    private static java.lang.Object getPathCompat(android.os.storage.StorageVolume storageVolume) {
        return null;
    }

    private StorageVolumeNative() {
    }

    private static class RefStorageVolume {
        private static com.oplus.utils.reflect.RefMethod<java.lang.Integer> getReadOnlyType;
        public static com.oplus.utils.reflect.RefObject<java.lang.Object> mStorageVolumeExt;

        private RefStorageVolume() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.os.storage.StorageVolumeNative.RefStorageVolume.class, (java.lang.Class<?>) android.os.storage.StorageVolume.class);
        }
    }

    private static class RefStorageVolumeExt {
        private static final java.lang.Class TYPE = com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.os.storage.StorageVolumeNative.RefStorageVolumeExt.class, "android.os.storage.IStorageVolumeExt");
        private static com.oplus.utils.reflect.RefMethod<java.lang.Integer> getReadOnlyType;

        private RefStorageVolumeExt() {
        }
    }

    public static java.lang.String getPath(android.os.storage.StorageVolume storageVolume) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.j_renamed()) {
            return storageVolume.getPath();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static int getOplusReadOnlyType(android.os.storage.StorageVolume storageVolume) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return ((java.lang.Integer) com.oplus.compat.os.storage.StorageVolumeNative.RefStorageVolumeExt.getReadOnlyType.call(com.oplus.compat.os.storage.StorageVolumeNative.RefStorageVolume.mStorageVolumeExt.get(storageVolume), new java.lang.Object[0])).intValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.os.storage.StorageVolumeWrapper.getReadOnlyType(storageVolume);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Integer) getOplusReadOnlyTypeCompat(storageVolume)).intValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.f_renamed()) {
            return ((java.lang.Integer) com.oplus.compat.os.storage.StorageVolumeNative.RefStorageVolume.getReadOnlyType.call(storageVolume, new java.lang.Object[0])).intValue();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static int getFatVolumeId(android.os.storage.StorageVolume storageVolume) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return storageVolume.getFatVolumeId();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.os.storage.StorageVolumeWrapper.getFatVolumeId(storageVolume);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Integer) getFatVolumeIdCompat(storageVolume)).intValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.f_renamed()) {
            return storageVolume.getFatVolumeId();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }
}
