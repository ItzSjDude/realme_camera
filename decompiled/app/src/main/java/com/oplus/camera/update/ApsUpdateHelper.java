package com.oplus.camera.update;

/* loaded from: classes2.dex */
public class ApsUpdateHelper {
    private static final int NUM_TWO = 2;
    private static final java.lang.String TAG = "ApsUpdateHelper";

    private ApsUpdateHelper() {
    }

    public static void updateApsParamToFile(android.content.Context context, com.oplus.camera.update.ApsUpdateParam apsUpdateParam) throws java.io.IOException {
        if (apsUpdateParam == null || !apsUpdateParam.isValid()) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "updateApsParamToFile, apsUpdateParam is_renamed null");
            return;
        }
        java.io.File filesDir = context.getFilesDir();
        if (ensurePathExist(filesDir, apsUpdateParam.getUpdateFilePath())) {
            java.lang.String str = filesDir.toString() + apsUpdateParam.getUpdateFilePath();
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                file.delete();
            }
            com.oplus.camera.q_renamed.a_renamed.b_renamed(str, "text/plain", apsUpdateParam.getUpdateContent().getBytes());
        }
    }

    private static boolean ensurePathExist(java.io.File file, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "ensurePathExist, updateFilePath is_renamed null");
            return false;
        }
        java.lang.String[] strArrSplit = str.split("/");
        if (strArrSplit.length < 2) {
            return true;
        }
        if (!file.exists()) {
            return false;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(file.getAbsolutePath());
        for (int i_renamed = 0; i_renamed < strArrSplit.length - 1; i_renamed++) {
            if (!android.text.TextUtils.isEmpty(strArrSplit[i_renamed])) {
                sb.append(java.io.File.separator);
                sb.append(strArrSplit[i_renamed]);
            }
        }
        java.io.File file2 = new java.io.File(sb.toString());
        if (file2.exists()) {
            return true;
        }
        return file2.mkdirs();
    }
}
