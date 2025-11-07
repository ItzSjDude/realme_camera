package com.oplus.camera.update;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p160q.DocumentUtil;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.util.Util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class UpdateUtil {
    public static final String APP_TO_UPDATE = "camera_update_app_operation";
    private static final String APP_UPDATE_TYPE_PREFERENCE_LATER = "update_sharePreference_later";
    private static final String APP_UPDATE_TYPE_PREFERENCE_NOW = "update_sharePreference_now";
    public static final String APS_TO_UPDATE = "apps_camera_update_aps_param";
    private static final String BACK_UP = "_BACK_UP";
    private static final String COLUMN_FIME_NAME = "filterName";
    private static final String COLUMN_MD5 = "md5";
    private static final String COLUMN_VERSION = "version";
    private static final String COLUMN_XML = "xml";
    private static final String EQUAL_TOKEN = "equal";
    public static final String FILE_NAME_TO_UPDATE = "camera_update_file_name";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_MD5 = "md5";
    private static final String KEY_UPDATE_STATE = "updateState";
    private static final String KEY_VERSION = "version";
    private static final int MAX_FILE_NUM = 50;
    private static final int MAX_TRY_TIME = 3;
    private static final String NEED_UPDATE_TOKEN = "needUpdate";
    private static final String PREFIX_DRIVER = "hardware";
    private static final String PREFIX_EFFECT = "quality";
    private static final String SPLIT_TOKEN = "\OplusGLSurfaceView_11";
    private static final String TAG = "UpdateUtil";
    private static final String UPDATED_TOKEN = "updated";
    private static final String VERSION = "_VERSION";
    private static UpdateUtil sUpdateUtil;
    private ArrayList<UpdateOperation> mAppLaterUpdateOperationList;
    private Context mContext;
    private Gson mGson;
    private int mNowTryTime = 0;
    private SharedPreferences mSharedPreferences;
    private ArrayList<UpdateOperation> mUpdateOperationList;
    private static final String TARGET_FOLDER = File.separator + "data" + File.separator + ".camera" + File.separator;
    private static final Object LOCK = new Object();
    private static final Uri UPDATE_URI = Uri.parse("content://com.oplus.romupdate.provider.db/update_list");

    public void onPause() {
    }

    private UpdateUtil(Context context) {
        this.mContext = context;
    }

    public static synchronized UpdateUtil getInstance(Context context) {
        if (sUpdateUtil == null) {
            sUpdateUtil = new UpdateUtil(context.getApplicationContext());
        }
        return sUpdateUtil;
    }

    public static synchronized void release() {
        sUpdateUtil = null;
    }

    private void resetList() {
        ArrayList<UpdateOperation> arrayList = this.mUpdateOperationList;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<UpdateOperation> arrayList2 = this.mAppLaterUpdateOperationList;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    public void startUpdateAllPara() {
        startUpdate(true, true);
    }

    public void startUpdate(final boolean z, final boolean z2) {
        Util.m24279a(new Runnable() { // from class: com.oplus.camera.update.UpdateUtil.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (UpdateUtil.LOCK) {
                    if (z) {
                        UpdateUtil.this.startUpdateAppParameter();
                    }
                    if (z2) {
                        UpdateUtil.this.startUpdateApsParameter();
                    }
                }
            }
        });
    }

    private boolean startUpdateDriverContent(String[] strArr) {
        boolean zStartUpdateParameter = true;
        do {
            int OplusGLSurfaceView_13 = this.mNowTryTime;
            if (OplusGLSurfaceView_13 >= 3) {
                break;
            }
            this.mNowTryTime = OplusGLSurfaceView_13 + 1;
            if (strArr != null && strArr.length > 0) {
                for (int i2 = 0; i2 < strArr.length && (zStartUpdateParameter = startUpdateParameter(strArr[i2])); i2++) {
                }
            }
        } while (!zStartUpdateParameter);
        return zStartUpdateParameter;
    }

    private boolean deleteFile(File file) {
        if (file.exists()) {
            return DocumentUtil.m16205c(file.getAbsolutePath());
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0074 A[PHI: r0 r3 r6 r8
      0x0074: PHI (r0v3 java.lang.String) = (r0v1 java.lang.String), (r0v8 java.lang.String) binds: [B:19:0x0082, B:13:0x0072] A[DONT_GENERATE, DONT_INLINE]
      0x0074: PHI (r3v4 java.lang.String) = (r3v2 java.lang.String), (r3v10 java.lang.String) binds: [B:19:0x0082, B:13:0x0072] A[DONT_GENERATE, DONT_INLINE]
      0x0074: PHI (r6v14 android.database.Cursor) = (r6v4 android.database.Cursor), (r6v15 android.database.Cursor) binds: [B:19:0x0082, B:13:0x0072] A[DONT_GENERATE, DONT_INLINE]
      0x0074: PHI (r8v3 int) = (r8v0 int), (r8v6 int) binds: [B:19:0x0082, B:13:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.Map<java.lang.String, java.lang.String> queryUpdateRomProvider(java.lang.String r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.update.UpdateUtil.queryUpdateRomProvider(java.lang.String):java.util.Map");
    }

    private SharedPreferences getSharedPreferences() {
        if (this.mSharedPreferences == null) {
            this.mSharedPreferences = this.mContext.getSharedPreferences("rom_update_info", 0);
        }
        return this.mSharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpdateApsParameter() throws Throwable {
        Map<String, String> mapQueryUpdateRomProvider = queryUpdateRomProvider(APS_TO_UPDATE);
        if (mapQueryUpdateRomProvider != null) {
            CameraLog.m12954a(TAG, "startUpdateApsParameter, content: " + mapQueryUpdateRomProvider.get(KEY_CONTENT));
            if (NEED_UPDATE_TOKEN.equals(mapQueryUpdateRomProvider.get(KEY_UPDATE_STATE))) {
                try {
                    ApsUpdateHelper.updateApsParamToFile(this.mContext, (ApsUpdateParam) new Gson().fromJson(mapQueryUpdateRomProvider.get(KEY_CONTENT), ApsUpdateParam.class));
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpdateAppParameter() throws Throwable {
        resetList();
        Map<String, String> mapQueryUpdateRomProvider = queryUpdateRomProvider(APP_TO_UPDATE);
        if (mapQueryUpdateRomProvider != null) {
            CameraLog.m12954a(TAG, "startUpdateAppParameter, content: " + mapQueryUpdateRomProvider.get(KEY_CONTENT));
            if (NEED_UPDATE_TOKEN.equals(mapQueryUpdateRomProvider.get(KEY_UPDATE_STATE)) && updateAppParameter(mapQueryUpdateRomProvider.get(KEY_CONTENT))) {
                updateSharePreference("camera_update_app_operation_VERSION", mapQueryUpdateRomProvider.get(CameraStatisticsUtil.RUS_FILE_VERSION));
            }
        }
    }

    private boolean startUpdateParameter(String str) throws IOException {
        Map<String, String> mapQueryUpdateRomProvider;
        CameraLog.m12954a(TAG, "startUpdateParameter, fileName: " + str);
        if (!TextUtils.isEmpty(str) && (mapQueryUpdateRomProvider = queryUpdateRomProvider(str)) != null) {
            CameraLog.m12954a(TAG, "startUpdateParameter, content: " + mapQueryUpdateRomProvider.get(KEY_CONTENT));
            if (str.contains(PREFIX_DRIVER) || str.contains(PREFIX_EFFECT)) {
                String str2 = TARGET_FOLDER + str;
                File file = new File(str2);
                if (!NEED_UPDATE_TOKEN.equals(mapQueryUpdateRomProvider.get(KEY_UPDATE_STATE))) {
                    if (!file.exists()) {
                        writeContentToTargetFile(str2, mapQueryUpdateRomProvider.get(KEY_CONTENT));
                        if (!mapQueryUpdateRomProvider.get("md5").equals(MD5Utils.md5Sum(str2))) {
                            CameraLog.m12954a(TAG, "startUpdateParameter, update fail");
                            deleteFile(file);
                            return false;
                        }
                        if (UPDATED_TOKEN.equals(mapQueryUpdateRomProvider.get(KEY_UPDATE_STATE))) {
                            updateSharePreference(str + VERSION, mapQueryUpdateRomProvider.get(CameraStatisticsUtil.RUS_FILE_VERSION));
                        }
                    }
                    return true;
                }
                File file2 = new File(str2 + BACK_UP);
                if (file.exists()) {
                    DocumentUtil.m16202b(str2, str2 + BACK_UP);
                }
                writeContentToTargetFile(str2, mapQueryUpdateRomProvider.get(KEY_CONTENT));
                if (!mapQueryUpdateRomProvider.get("md5").equals(MD5Utils.md5Sum(str2))) {
                    CameraLog.m12954a(TAG, "startUpdateParameter, update fail");
                    deleteFile(file);
                    File file3 = new File(str2);
                    if (file2.exists()) {
                        DocumentUtil.m16202b(file2.getAbsolutePath(), file3.getAbsolutePath());
                    }
                    return false;
                }
                deleteFile(file2);
                updateSharePreference(str + VERSION, mapQueryUpdateRomProvider.get(CameraStatisticsUtil.RUS_FILE_VERSION));
                return true;
            }
        }
        return false;
    }

    private void updateSharePreference(String str, String str2) {
        SharedPreferences.Editor editorEdit = getSharedPreferences().edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
        if (str.contains(VERSION)) {
            CameraStatisticsUtil.onCommon(this.mContext, CameraStatisticsUtil.EVENT_RUS, CameraStatisticsUtil.format(CameraStatisticsUtil.RUS_FILE_NAME, str) + " " + CameraStatisticsUtil.format(CameraStatisticsUtil.RUS_FILE_VERSION, str2));
        }
    }

    public boolean getBooleanValue(String str, boolean z) {
        String string;
        SharedPreferences sharedPreferences = getSharedPreferences();
        return (sharedPreferences == null || (string = sharedPreferences.getString(str, null)) == null) ? z : Boolean.valueOf(string).booleanValue();
    }

    private void writeContentToTargetFile(String str, String str2) throws IOException {
        CameraLog.m12954a(TAG, "writeContentToTargetFile, targetFile: " + str + ", content: " + str2);
        DocumentUtil.m16203b(str, "text/plain", str2.getBytes());
    }

    private boolean updateAppParameter(String str) {
        if (this.mGson == null) {
            this.mGson = new Gson();
        }
        try {
            this.mUpdateOperationList = (ArrayList) this.mGson.fromJson(str, new TypeToken<List<UpdateOperation>>() { // from class: com.oplus.camera.update.UpdateUtil.2
            }.getType());
            if (this.mUpdateOperationList == null) {
                CameraLog.m12967f(TAG, "updateAppParameter fail, mUpdateOperationList is null!");
                return false;
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mUpdateOperationList.size(); OplusGLSurfaceView_13++) {
                UpdateOperation updateOperation = this.mUpdateOperationList.get(OplusGLSurfaceView_13);
                if (APP_UPDATE_TYPE_PREFERENCE_NOW.equals(updateOperation.getOperation())) {
                    updateSharePreference(updateOperation.getKey(), updateOperation.getValue());
                }
                if (APP_UPDATE_TYPE_PREFERENCE_LATER.equals(updateOperation.getOperation())) {
                    if (this.mAppLaterUpdateOperationList == null) {
                        this.mAppLaterUpdateOperationList = new ArrayList<>();
                    }
                    this.mAppLaterUpdateOperationList.add(updateOperation);
                }
            }
            return true;
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f(TAG, "updateAppParameter fail, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8.getMessage());
            return false;
        }
    }
}
