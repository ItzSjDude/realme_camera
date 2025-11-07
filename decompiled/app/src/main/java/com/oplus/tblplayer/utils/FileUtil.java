package com.oplus.tblplayer.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes2.dex */
public class FileUtil {
    public static File getDirectoryByName(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        File externalFilesDir = "mounted".equals(Environment.getExternalStorageState()) ? applicationContext.getExternalFilesDir(str) : null;
        return externalFilesDir == null ? applicationContext.getDir(str, 0) : externalFilesDir;
    }

    public static File getDirectoryByPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() || file.mkdir()) {
            return file;
        }
        return null;
    }
}
