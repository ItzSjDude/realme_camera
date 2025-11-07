package com.oplus.tblplayer.utils;

/* loaded from: classes2.dex */
public class FileUtil {
    public static java.io.File getDirectoryByName(android.content.Context context, java.lang.String str) {
        android.content.Context applicationContext = context.getApplicationContext();
        java.io.File externalFilesDir = "mounted".equals(android.os.Environment.getExternalStorageState()) ? applicationContext.getExternalFilesDir(str) : null;
        return externalFilesDir == null ? applicationContext.getDir(str, 0) : externalFilesDir;
    }

    public static java.io.File getDirectoryByPath(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists() || file.mkdir()) {
            return file;
        }
        return null;
    }
}
