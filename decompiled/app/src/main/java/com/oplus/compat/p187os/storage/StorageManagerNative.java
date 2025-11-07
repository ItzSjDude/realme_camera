package com.oplus.compat.p187os.storage;

import android.content.Context;
import android.os.storage.DiskInfo;
import android.os.storage.StorageEventListener;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.os.storage.VolumeInfo;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.inner.os.storage.StorageEventListenerWrapper;
import com.oplus.inner.os.storage.StorageManagerWrapper;
import com.oplus.inner.os.storage.VolumeInfoWrapper;
import com.oplus.utils.reflect.MethodName;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class StorageManagerNative {
    private static final String COMPONENT_NAME = "android.os.storage.StorageManager";
    private static final String TAG = "StorageManagerNative";
    private static HashMap<StorageEventListenerNative, StorageEventListenerWrapper> mListenerMap = new HashMap<>();
    private static HashMap<StorageEventListenerNative, Object> mListenerMapCompat = new HashMap<>();

    private static Object getSDCardVolumeInfoCompat() {
        return null;
    }

    private static Object getVolumeStateCompat(Context context, String str) {
        return null;
    }

    private static Object registerListenerCompat(Context context, Consumer<List<String>> consumer, BiConsumer<Object, List<Integer>> biConsumer) {
        return null;
    }

    private static void unregisterListenerCompat(Context context, Object obj) {
    }

    private static class ReflectInfo {

        @MethodName(name = "getVolumeList", params = {int.class, int.class})
        private static RefMethod<StorageVolume[]> getVolumeList;
        private static RefMethod<String[]> getVolumePaths;
        private static RefMethod<String> getVolumeState;
        private static RefMethod<List<Object>> getVolumes;
        private static RefMethod<Boolean> isFileEncryptedNativeOnly;
        private static RefMethod<Void> registerListener;

        private ReflectInfo() {
        }

        static {
            RefClass.load((Class<?>) ReflectInfo.class, (Class<?>) StorageManager.class);
        }
    }

    private static class ReflectVolumeInfo {
        private static RefMethod<Object> getDisk;

        private ReflectVolumeInfo() {
        }

        static {
            RefClass.load((Class<?>) ReflectInfo.class, (Class<?>) VolumeInfo.class);
        }
    }

    private static class RefDiskInfo {
        private static RefMethod<Boolean> isSd;

        private RefDiskInfo() {
        }

        static {
            RefClass.load((Class<?>) ReflectInfo.class, (Class<?>) DiskInfo.class);
        }
    }

    private StorageManagerNative() {
    }

    public static VolumeInfoNative getSDCardVolumeInfo(Context context) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            Iterator it = ((StorageManager) context.getSystemService("storage")).getVolumes().iterator();
            while (it.hasNext()) {
                VolumeInfoNative volumeInfoNative = new VolumeInfoNative((VolumeInfo) it.next());
                if (volumeInfoNative.isSd()) {
                    return volumeInfoNative;
                }
            }
            return null;
        }
        if (VersionUtils.m24886b()) {
            VolumeInfoWrapper sDCardVolumeInfo = StorageManagerWrapper.getSDCardVolumeInfo();
            if (sDCardVolumeInfo != null) {
                return new VolumeInfoNative(sDCardVolumeInfo);
            }
        } else if (VersionUtils.m24889e()) {
            Object sDCardVolumeInfoCompat = getSDCardVolumeInfoCompat();
            if (sDCardVolumeInfoCompat != null) {
                return new VolumeInfoNative(sDCardVolumeInfoCompat);
            }
        } else if (VersionUtils.m24894j()) {
            List list = (List) ReflectInfo.getVolumes.call((StorageManager) context.getSystemService("storage"), new Object[0]);
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
                Object objCall = ReflectVolumeInfo.getDisk.call(list.get(OplusGLSurfaceView_13), new Object[0]);
                if (objCall != null && ((Boolean) RefDiskInfo.isSd.call(objCall, new Object[0])).booleanValue()) {
                    return new VolumeInfoNative(list.get(OplusGLSurfaceView_13));
                }
            }
        } else {
            throw new UnSupportedApiVersionException();
        }
        return null;
    }

    public static void registerListener(Context context, final StorageEventListenerNative storageEventListenerNative) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            storageEventListenerNative.setDelegate(new StorageEventListener() { // from class: com.oplus.compat.os.storage.StorageManagerNative.1
                public void onStorageStateChanged(String str, String str2, String str3) {
                    storageEventListenerNative.onStorageStateChanged(str, str2, str3);
                }

                public void onVolumeStateChanged(VolumeInfo volumeInfo, int OplusGLSurfaceView_13, int i2) {
                    storageEventListenerNative.onVolumeStateChanged(new VolumeInfoNative(volumeInfo), OplusGLSurfaceView_13, i2);
                }
            });
            storageManager.registerListener(storageEventListenerNative.delegate());
            return;
        }
        if (VersionUtils.m24886b()) {
            StorageEventListenerWrapper storageEventListenerWrapper = new StorageEventListenerWrapper() { // from class: com.oplus.compat.os.storage.StorageManagerNative.2
                public void onStorageStateChanged(String str, String str2, String str3) {
                    storageEventListenerNative.onStorageStateChanged(str, str2, str3);
                }

                public void onVolumeStateChanged(VolumeInfoWrapper volumeInfoWrapper, int OplusGLSurfaceView_13, int i2) {
                    storageEventListenerNative.onVolumeStateChanged(new VolumeInfoNative(volumeInfoWrapper), OplusGLSurfaceView_13, i2);
                }
            };
            if (mListenerMap.get(storageEventListenerNative) != null) {
                mListenerMap.remove(storageEventListenerNative);
            }
            StorageManagerWrapper.registerListener(context, storageEventListenerWrapper);
            mListenerMap.put(storageEventListenerNative, storageEventListenerWrapper);
            return;
        }
        if (VersionUtils.m24889e()) {
            storageEventListenerNative.getClass();
            Consumer consumer = new Consumer() { // from class: com.oplus.compat.os.storage.-$$Lambda$DglFd_ZrNnv1j1YRcnJPNRSsukY
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    storageEventListenerNative.onStorageStateChangedCompat((List) obj);
                }
            };
            storageEventListenerNative.getClass();
            Object objRegisterListenerCompat = registerListenerCompat(context, consumer, new BiConsumer() { // from class: com.oplus.compat.os.storage.-$$Lambda$D6YHO-XTP3MHWQuokNHCjcjamUU
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    storageEventListenerNative.onVolumeStateChangedCompat(obj, (List) obj2);
                }
            });
            if (mListenerMap.get(storageEventListenerNative) != null) {
                mListenerMap.remove(storageEventListenerNative);
            }
            mListenerMapCompat.put(storageEventListenerNative, objRegisterListenerCompat);
            return;
        }
        throw new UnSupportedApiVersionException();
    }

    public static void unregisterListener(Context context, StorageEventListenerNative storageEventListenerNative) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            ((StorageManager) context.getSystemService("storage")).unregisterListener(storageEventListenerNative.delegate());
            return;
        }
        if (VersionUtils.m24886b()) {
            if (mListenerMap.get(storageEventListenerNative) != null) {
                StorageManagerWrapper.unregisterListener(context, mListenerMap.get(storageEventListenerNative));
                mListenerMap.remove(storageEventListenerNative);
                return;
            }
            return;
        }
        if (VersionUtils.m24889e()) {
            if (mListenerMapCompat.get(storageEventListenerNative) != null) {
                unregisterListenerCompat(context, mListenerMapCompat.get(storageEventListenerNative));
                mListenerMapCompat.remove(storageEventListenerNative);
                return;
            }
            return;
        }
        throw new UnSupportedApiVersionException();
    }

    public static StorageVolume[] getVolumeList(int OplusGLSurfaceView_13, int i2) throws UnSupportedApiVersionException {
        if (VersionUtils.m24894j()) {
            return (StorageVolume[]) ReflectInfo.getVolumeList.call(null, Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2));
        }
        throw new UnSupportedApiVersionException("not supported before M");
    }

    public static String getVolumeState(Context context, String str) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return (String) ReflectInfo.getVolumeState.call((StorageManager) context.getSystemService("storage"), str);
        }
        if (VersionUtils.m24889e()) {
            return (String) getVolumeStateCompat(context, str);
        }
        if (VersionUtils.m24891g()) {
            return ((StorageManager) context.getSystemService("storage")).getVolumeState(str);
        }
        throw new UnSupportedApiVersionException("not supported before O");
    }

    public static Boolean isFileEncryptedNativeOnly() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return (Boolean) ReflectInfo.isFileEncryptedNativeOnly.call(null, new Object[0]);
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }

    public static List<Object> getVolumes(Context context) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return (List) ReflectInfo.getVolumes.call((StorageManager) context.getSystemService("storage"), new Object[0]);
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }

    public static String[] getVolumePaths(Context context) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return (String[]) ReflectInfo.getVolumePaths.call((StorageManager) context.getSystemService("storage"), new Object[0]);
        }
        throw new UnSupportedApiVersionException("not supported before R");
    }
}
