package com.oplus.camera.update;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p160q.DocumentUtil;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public class ApsUpdateHelper {
    private static final int NUM_TWO = 2;
    private static final String TAG = "ApsUpdateHelper";

    private ApsUpdateHelper() {
    }

    public static void updateApsParamToFile(Context context, ApsUpdateParam apsUpdateParam) throws IOException {
        if (apsUpdateParam == null || !apsUpdateParam.isValid()) {
            CameraLog.m12967f(TAG, "updateApsParamToFile, apsUpdateParam is null");
            return;
        }
        File filesDir = context.getFilesDir();
        if (ensurePathExist(filesDir, apsUpdateParam.getUpdateFilePath())) {
            String str = filesDir.toString() + apsUpdateParam.getUpdateFilePath();
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            DocumentUtil.m16203b(str, "text/plain", apsUpdateParam.getUpdateContent().getBytes());
        }
    }

    private static boolean ensurePathExist(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            CameraLog.m12967f(TAG, "ensurePathExist, updateFilePath is null");
            return false;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length < 2) {
            return true;
        }
        if (!file.exists()) {
            return false;
        }
        StringBuilder sb = new StringBuilder(file.getAbsolutePath());
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArrSplit.length - 1; OplusGLSurfaceView_13++) {
            if (!TextUtils.isEmpty(strArrSplit[OplusGLSurfaceView_13])) {
                sb.append(File.separator);
                sb.append(strArrSplit[OplusGLSurfaceView_13]);
            }
        }
        File file2 = new File(sb.toString());
        if (file2.exists()) {
            return true;
        }
        return file2.mkdirs();
    }
}
