package com.oplus.compat.os.storage;

/* loaded from: classes2.dex */
public class StorageManagerNative {
    private static final java.lang.String COMPONENT_NAME = "android.os.storage.StorageManager";
    private static final java.lang.String TAG = "StorageManagerNative";
    private static java.util.HashMap<com.oplus.compat.os.storage.StorageEventListenerNative, com.oplus.inner.os.storage.StorageEventListenerWrapper> mListenerMap = new java.util.HashMap<>();
    private static java.util.HashMap<com.oplus.compat.os.storage.StorageEventListenerNative, java.lang.Object> mListenerMapCompat = new java.util.HashMap<>();

    private static java.lang.Object getSDCardVolumeInfoCompat() {
        return null;
    }

    private static java.lang.Object getVolumeStateCompat(android.content.Context context, java.lang.String str) {
        return null;
    }

    private static java.lang.Object registerListenerCompat(android.content.Context context, java.util.function.Consumer<java.util.List<java.lang.String>> consumer, java.util.function.BiConsumer<java.lang.Object, java.util.List<java.lang.Integer>> biConsumer) {
        return null;
    }

    private static void unregisterListenerCompat(android.content.Context context, java.lang.Object obj) {
    }

    private static class ReflectInfo {

        @com.oplus.utils.reflect.MethodName(name = "getVolumeList", params = {int.class, int.class})
        private static com.oplus.utils.reflect.RefMethod<android.os.storage.StorageVolume[]> getVolumeList;
        private static com.oplus.utils.reflect.RefMethod<java.lang.String[]> getVolumePaths;
        private static com.oplus.utils.reflect.RefMethod<java.lang.String> getVolumeState;
        private static com.oplus.utils.reflect.RefMethod<java.util.List<java.lang.Object>> getVolumes;
        private static com.oplus.utils.reflect.RefMethod<java.lang.Boolean> isFileEncryptedNativeOnly;
        private static com.oplus.utils.reflect.RefMethod<java.lang.Void> registerListener;

        private ReflectInfo() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.os.storage.StorageManagerNative.ReflectInfo.class, (java.lang.Class<?>) android.os.storage.StorageManager.class);
        }
    }

    private static class ReflectVolumeInfo {
        private static com.oplus.utils.reflect.RefMethod<java.lang.Object> getDisk;

        private ReflectVolumeInfo() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.os.storage.StorageManagerNative.ReflectInfo.class, (java.lang.Class<?>) android.os.storage.VolumeInfo.class);
        }
    }

    private static class RefDiskInfo {
        private static com.oplus.utils.reflect.RefMethod<java.lang.Boolean> isSd;

        private RefDiskInfo() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.os.storage.StorageManagerNative.ReflectInfo.class, (java.lang.Class<?>) android.os.storage.DiskInfo.class);
        }
    }

    private StorageManagerNative() {
    }

    public static com.oplus.compat.os.storage.VolumeInfoNative getSDCardVolumeInfo(android.content.Context context) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            java.util.Iterator it = ((android.os.storage.StorageManager) context.getSystemService("storage")).getVolumes().iterator();
            while (it.hasNext()) {
                com.oplus.compat.os.storage.VolumeInfoNative volumeInfoNative = new com.oplus.compat.os.storage.VolumeInfoNative((android.os.storage.VolumeInfo) it.next());
                if (volumeInfoNative.isSd()) {
                    return volumeInfoNative;
                }
            }
            return null;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            com.oplus.inner.os.storage.VolumeInfoWrapper sDCardVolumeInfo = com.oplus.inner.os.storage.StorageManagerWrapper.getSDCardVolumeInfo();
            if (sDCardVolumeInfo != null) {
                return new com.oplus.compat.os.storage.VolumeInfoNative(sDCardVolumeInfo);
            }
        } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            java.lang.Object sDCardVolumeInfoCompat = getSDCardVolumeInfoCompat();
            if (sDCardVolumeInfoCompat != null) {
                return new com.oplus.compat.os.storage.VolumeInfoNative(sDCardVolumeInfoCompat);
            }
        } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.j_renamed()) {
            java.util.List list = (java.util.List) com.oplus.compat.os.storage.StorageManagerNative.ReflectInfo.getVolumes.call((android.os.storage.StorageManager) context.getSystemService("storage"), new java.lang.Object[0]);
            for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
                java.lang.Object objCall = com.oplus.compat.os.storage.StorageManagerNative.ReflectVolumeInfo.getDisk.call(list.get(i_renamed), new java.lang.Object[0]);
                if (objCall != null && ((java.lang.Boolean) com.oplus.compat.os.storage.StorageManagerNative.RefDiskInfo.isSd.call(objCall, new java.lang.Object[0])).booleanValue()) {
                    return new com.oplus.compat.os.storage.VolumeInfoNative(list.get(i_renamed));
                }
            }
        } else {
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
        }
        return null;
    }

    public static void registerListener(android.content.Context context, final com.oplus.compat.os.storage.StorageEventListenerNative storageEventListenerNative) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            android.os.storage.StorageManager storageManager = (android.os.storage.StorageManager) context.getSystemService("storage");
            storageEventListenerNative.setDelegate(new android.os.storage.StorageEventListener() { // from class: com.oplus.compat.os.storage.StorageManagerNative.1
                public void onStorageStateChanged(java.lang.String str, java.lang.String str2, java.lang.String str3) {
                    storageEventListenerNative.onStorageStateChanged(str, str2, str3);
                }

                public void onVolumeStateChanged(android.os.storage.VolumeInfo volumeInfo, int i_renamed, int i2) {
                    storageEventListenerNative.onVolumeStateChanged(new com.oplus.compat.os.storage.VolumeInfoNative(volumeInfo), i_renamed, i2);
                }
            });
            storageManager.registerListener(storageEventListenerNative.delegate());
            return;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            com.oplus.inner.os.storage.StorageEventListenerWrapper storageEventListenerWrapper = new com.oplus.inner.os.storage.StorageEventListenerWrapper() { // from class: com.oplus.compat.os.storage.StorageManagerNative.2
                public void onStorageStateChanged(java.lang.String str, java.lang.String str2, java.lang.String str3) {
                    storageEventListenerNative.onStorageStateChanged(str, str2, str3);
                }

                public void onVolumeStateChanged(com.oplus.inner.os.storage.VolumeInfoWrapper volumeInfoWrapper, int i_renamed, int i2) {
                    storageEventListenerNative.onVolumeStateChanged(new com.oplus.compat.os.storage.VolumeInfoNative(volumeInfoWrapper), i_renamed, i2);
                }
            };
            if (mListenerMap.get(storageEventListenerNative) != null) {
                mListenerMap.remove(storageEventListenerNative);
            }
            com.oplus.inner.os.storage.StorageManagerWrapper.registerListener(context, storageEventListenerWrapper);
            mListenerMap.put(storageEventListenerNative, storageEventListenerWrapper);
            return;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            storageEventListenerNative.getClass();
            java.util.function.Consumer consumer = new java.util.function.Consumer() { // from class: com.oplus.compat.os.storage.-$$Lambda$DglFd_ZrNnv1j1YRcnJPNRSsukY
                @Override // java.util.function.Consumer
                public final void accept(java.lang.Object obj) {
                    storageEventListenerNative.onStorageStateChangedCompat((java.util.List) obj);
                }
            };
            storageEventListenerNative.getClass();
            java.lang.Object objRegisterListenerCompat = registerListenerCompat(context, consumer, new java.util.function.BiConsumer() { // from class: com.oplus.compat.os.storage.-$$Lambda$D6YHO-XTP3MHWQuokNHCjcjamUU
                @Override // java.util.function.BiConsumer
                public final void accept(java.lang.Object obj, java.lang.Object obj2) {
                    storageEventListenerNative.onVolumeStateChangedCompat(obj, (java.util.List) obj2);
                }
            });
            if (mListenerMap.get(storageEventListenerNative) != null) {
                mListenerMap.remove(storageEventListenerNative);
            }
            mListenerMapCompat.put(storageEventListenerNative, objRegisterListenerCompat);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static void unregisterListener(android.content.Context context, com.oplus.compat.os.storage.StorageEventListenerNative storageEventListenerNative) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            ((android.os.storage.StorageManager) context.getSystemService("storage")).unregisterListener(storageEventListenerNative.delegate());
            return;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            if (mListenerMap.get(storageEventListenerNative) != null) {
                com.oplus.inner.os.storage.StorageManagerWrapper.unregisterListener(context, mListenerMap.get(storageEventListenerNative));
                mListenerMap.remove(storageEventListenerNative);
                return;
            }
            return;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            if (mListenerMapCompat.get(storageEventListenerNative) != null) {
                unregisterListenerCompat(context, mListenerMapCompat.get(storageEventListenerNative));
                mListenerMapCompat.remove(storageEventListenerNative);
                return;
            }
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static android.os.storage.StorageVolume[] getVolumeList(int i_renamed, int i2) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.j_renamed()) {
            return (android.os.storage.StorageVolume[]) com.oplus.compat.os.storage.StorageManagerNative.ReflectInfo.getVolumeList.call(null, java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before M_renamed");
    }

    public static java.lang.String getVolumeState(android.content.Context context, java.lang.String str) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return (java.lang.String) com.oplus.compat.os.storage.StorageManagerNative.ReflectInfo.getVolumeState.call((android.os.storage.StorageManager) context.getSystemService("storage"), str);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (java.lang.String) getVolumeStateCompat(context, str);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.g_renamed()) {
            return ((android.os.storage.StorageManager) context.getSystemService("storage")).getVolumeState(str);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before O_renamed");
    }

    public static java.lang.Boolean isFileEncryptedNativeOnly() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return (java.lang.Boolean) com.oplus.compat.os.storage.StorageManagerNative.ReflectInfo.isFileEncryptedNativeOnly.call(null, new java.lang.Object[0]);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }

    public static java.util.List<java.lang.Object> getVolumes(android.content.Context context) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return (java.util.List) com.oplus.compat.os.storage.StorageManagerNative.ReflectInfo.getVolumes.call((android.os.storage.StorageManager) context.getSystemService("storage"), new java.lang.Object[0]);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }

    public static java.lang.String[] getVolumePaths(android.content.Context context) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return (java.lang.String[]) com.oplus.compat.os.storage.StorageManagerNative.ReflectInfo.getVolumePaths.call((android.os.storage.StorageManager) context.getSystemService("storage"), new java.lang.Object[0]);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }
}
