package com.oplus.camera.util.storage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.Storage;
import java.util.Iterator;
import java.util.Set;

/* compiled from: MediaStoreUtil.java */
/* renamed from: com.oplus.camera.util.storage.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class MediaStoreUtil implements CameraConstant {
    /* renamed from: PlatformImplementations.kt_3 */
    public static Uri m24649a(Context context) {
        if ("off".equals(Storage.f12095u)) {
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        if ("on".equals(Storage.f12095u) && Build.VERSION.SDK_INT >= 29) {
            Set<String> externalVolumeNames = MediaStore.getExternalVolumeNames(context);
            String strM11145h = Storage.m11145h();
            if (externalVolumeNames.contains(strM11145h)) {
                CameraLog.m12959b("MediaStoreUtil", "getStoragePlaceVideoUri VolumeNameForExternalDirectory: " + strM11145h);
                return MediaStore.Video.Media.getContentUri(strM11145h);
            }
            Iterator<String> it = externalVolumeNames.iterator();
            if (it.hasNext()) {
                return MediaStore.Video.Media.getContentUri(it.next());
            }
        }
        return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Uri m24650a(Context context, ContentResolver contentResolver, ContentValues contentValues) {
        return contentResolver.insert(m24649a(context), contentValues);
    }
}
