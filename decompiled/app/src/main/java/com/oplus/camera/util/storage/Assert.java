package com.oplus.camera.util.storage;

/* compiled from: MediaStoreUtil.java */
/* loaded from: classes2.dex */
public class a_renamed implements com.oplus.camera.d_renamed {
    public static android.net.Uri a_renamed(android.content.Context context) {
        if ("off".equals(com.oplus.camera.Storage.u_renamed)) {
            return android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        if ("on_renamed".equals(com.oplus.camera.Storage.u_renamed) && android.os.Build.VERSION.SDK_INT >= 29) {
            java.util.Set<java.lang.String> externalVolumeNames = android.provider.MediaStore.getExternalVolumeNames(context);
            java.lang.String strH = com.oplus.camera.Storage.h_renamed();
            if (externalVolumeNames.contains(strH)) {
                com.oplus.camera.e_renamed.b_renamed("MediaStoreUtil", "getStoragePlaceVideoUri VolumeNameForExternalDirectory: " + strH);
                return android.provider.MediaStore.Video.Media.getContentUri(strH);
            }
            java.util.Iterator<java.lang.String> it = externalVolumeNames.iterator();
            if (it.hasNext()) {
                return android.provider.MediaStore.Video.Media.getContentUri(it.next());
            }
        }
        return android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    public static android.net.Uri a_renamed(android.content.Context context, android.content.ContentResolver contentResolver, android.content.ContentValues contentValues) {
        return contentResolver.insert(a_renamed(context), contentValues);
    }
}
