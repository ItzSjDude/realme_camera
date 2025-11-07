package com.oplus.camera.update;

/* loaded from: classes2.dex */
public class UpdateUtil {
    public static final java.lang.String APP_TO_UPDATE = "camera_update_app_operation";
    private static final java.lang.String APP_UPDATE_TYPE_PREFERENCE_LATER = "update_sharePreference_later";
    private static final java.lang.String APP_UPDATE_TYPE_PREFERENCE_NOW = "update_sharePreference_now";
    public static final java.lang.String APS_TO_UPDATE = "apps_camera_update_aps_param";
    private static final java.lang.String BACK_UP = "_BACK_UP";
    private static final java.lang.String COLUMN_FIME_NAME = "filterName";
    private static final java.lang.String COLUMN_MD5 = "md5";
    private static final java.lang.String COLUMN_VERSION = "version";
    private static final java.lang.String COLUMN_XML = "xml";
    private static final java.lang.String EQUAL_TOKEN = "equal";
    public static final java.lang.String FILE_NAME_TO_UPDATE = "camera_update_file_name";
    private static final java.lang.String KEY_CONTENT = "content";
    private static final java.lang.String KEY_MD5 = "md5";
    private static final java.lang.String KEY_UPDATE_STATE = "updateState";
    private static final java.lang.String KEY_VERSION = "version";
    private static final int MAX_FILE_NUM = 50;
    private static final int MAX_TRY_TIME = 3;
    private static final java.lang.String NEED_UPDATE_TOKEN = "needUpdate";
    private static final java.lang.String PREFIX_DRIVER = "hardware";
    private static final java.lang.String PREFIX_EFFECT = "quality";
    private static final java.lang.String SPLIT_TOKEN = "\n_renamed";
    private static final java.lang.String TAG = "UpdateUtil";
    private static final java.lang.String UPDATED_TOKEN = "updated";
    private static final java.lang.String VERSION = "_VERSION";
    private static com.oplus.camera.update.UpdateUtil sUpdateUtil;
    private java.util.ArrayList<com.oplus.camera.update.UpdateOperation> mAppLaterUpdateOperationList;
    private android.content.Context mContext;
    private com.google.gson.Gson mGson;
    private int mNowTryTime = 0;
    private android.content.SharedPreferences mSharedPreferences;
    private java.util.ArrayList<com.oplus.camera.update.UpdateOperation> mUpdateOperationList;
    private static final java.lang.String TARGET_FOLDER = java.io.File.separator + "data" + java.io.File.separator + ".camera" + java.io.File.separator;
    private static final java.lang.Object LOCK = new java.lang.Object();
    private static final android.net.Uri UPDATE_URI = android.net.Uri.parse("content://com.oplus.romupdate.provider.db_renamed/update_list");

    public void onPause() {
    }

    private UpdateUtil(android.content.Context context) {
        this.mContext = context;
    }

    public static synchronized com.oplus.camera.update.UpdateUtil getInstance(android.content.Context context) {
        if (sUpdateUtil == null) {
            sUpdateUtil = new com.oplus.camera.update.UpdateUtil(context.getApplicationContext());
        }
        return sUpdateUtil;
    }

    public static synchronized void release() {
        sUpdateUtil = null;
    }

    private void resetList() {
        java.util.ArrayList<com.oplus.camera.update.UpdateOperation> arrayList = this.mUpdateOperationList;
        if (arrayList != null) {
            arrayList.clear();
        }
        java.util.ArrayList<com.oplus.camera.update.UpdateOperation> arrayList2 = this.mAppLaterUpdateOperationList;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    public void startUpdateAllPara() {
        startUpdate(true, true);
    }

    public void startUpdate(final boolean z_renamed, final boolean z2) {
        com.oplus.camera.util.Util.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.update.UpdateUtil.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.update.UpdateUtil.LOCK) {
                    if (z_renamed) {
                        com.oplus.camera.update.UpdateUtil.this.startUpdateAppParameter();
                    }
                    if (z2) {
                        com.oplus.camera.update.UpdateUtil.this.startUpdateApsParameter();
                    }
                }
            }
        });
    }

    private boolean startUpdateDriverContent(java.lang.String[] strArr) {
        boolean zStartUpdateParameter = true;
        do {
            int i_renamed = this.mNowTryTime;
            if (i_renamed >= 3) {
                break;
            }
            this.mNowTryTime = i_renamed + 1;
            if (strArr != null && strArr.length > 0) {
                for (int i2 = 0; i2 < strArr.length && (zStartUpdateParameter = startUpdateParameter(strArr[i2])); i2++) {
                }
            }
        } while (!zStartUpdateParameter);
        return zStartUpdateParameter;
    }

    private boolean deleteFile(java.io.File file) {
        if (file.exists()) {
            return com.oplus.camera.q_renamed.a_renamed.c_renamed(file.getAbsolutePath());
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:12:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:14:0x0074 A_renamed[PHI: r0 r3 r6 r8
      0x0074: PHI (r0v3 java.lang.String) = (r0v1 java.lang.String), (r0v8 java.lang.String) binds: [B_renamed:19:0x0082, B_renamed:13:0x0072] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x0074: PHI (r3v4 java.lang.String) = (r3v2 java.lang.String), (r3v10 java.lang.String) binds: [B_renamed:19:0x0082, B_renamed:13:0x0072] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x0074: PHI (r6v14 android.database.Cursor) = (r6v4 android.database.Cursor), (r6v15 android.database.Cursor) binds: [B_renamed:19:0x0082, B_renamed:13:0x0072] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x0074: PHI (r8v3 int) = (r8v0 int), (r8v6 int) binds: [B_renamed:19:0x0082, B_renamed:13:0x0072] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:44:0x014b  */
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

    private android.content.SharedPreferences getSharedPreferences() {
        if (this.mSharedPreferences == null) {
            this.mSharedPreferences = this.mContext.getSharedPreferences("rom_update_info", 0);
        }
        return this.mSharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpdateApsParameter() throws java.lang.Throwable {
        java.util.Map<java.lang.String, java.lang.String> mapQueryUpdateRomProvider = queryUpdateRomProvider(APS_TO_UPDATE);
        if (mapQueryUpdateRomProvider != null) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "startUpdateApsParameter, content: " + mapQueryUpdateRomProvider.get(KEY_CONTENT));
            if (NEED_UPDATE_TOKEN.equals(mapQueryUpdateRomProvider.get(KEY_UPDATE_STATE))) {
                try {
                    com.oplus.camera.update.ApsUpdateHelper.updateApsParamToFile(this.mContext, (com.oplus.camera.update.ApsUpdateParam) new com.google.gson.Gson().fromJson(mapQueryUpdateRomProvider.get(KEY_CONTENT), com.oplus.camera.update.ApsUpdateParam.class));
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpdateAppParameter() throws java.lang.Throwable {
        resetList();
        java.util.Map<java.lang.String, java.lang.String> mapQueryUpdateRomProvider = queryUpdateRomProvider(APP_TO_UPDATE);
        if (mapQueryUpdateRomProvider != null) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "startUpdateAppParameter, content: " + mapQueryUpdateRomProvider.get(KEY_CONTENT));
            if (NEED_UPDATE_TOKEN.equals(mapQueryUpdateRomProvider.get(KEY_UPDATE_STATE)) && updateAppParameter(mapQueryUpdateRomProvider.get(KEY_CONTENT))) {
                updateSharePreference("camera_update_app_operation_VERSION", mapQueryUpdateRomProvider.get(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_VERSION));
            }
        }
    }

    private boolean startUpdateParameter(java.lang.String str) throws java.io.IOException {
        java.util.Map<java.lang.String, java.lang.String> mapQueryUpdateRomProvider;
        com.oplus.camera.e_renamed.a_renamed(TAG, "startUpdateParameter, fileName: " + str);
        if (!android.text.TextUtils.isEmpty(str) && (mapQueryUpdateRomProvider = queryUpdateRomProvider(str)) != null) {
            com.oplus.camera.e_renamed.a_renamed(TAG, "startUpdateParameter, content: " + mapQueryUpdateRomProvider.get(KEY_CONTENT));
            if (str.contains(PREFIX_DRIVER) || str.contains(PREFIX_EFFECT)) {
                java.lang.String str2 = TARGET_FOLDER + str;
                java.io.File file = new java.io.File(str2);
                if (!NEED_UPDATE_TOKEN.equals(mapQueryUpdateRomProvider.get(KEY_UPDATE_STATE))) {
                    if (!file.exists()) {
                        writeContentToTargetFile(str2, mapQueryUpdateRomProvider.get(KEY_CONTENT));
                        if (!mapQueryUpdateRomProvider.get("md5").equals(com.oplus.camera.update.MD5Utils.md5Sum(str2))) {
                            com.oplus.camera.e_renamed.a_renamed(TAG, "startUpdateParameter, update fail");
                            deleteFile(file);
                            return false;
                        }
                        if (UPDATED_TOKEN.equals(mapQueryUpdateRomProvider.get(KEY_UPDATE_STATE))) {
                            updateSharePreference(str + VERSION, mapQueryUpdateRomProvider.get(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_VERSION));
                        }
                    }
                    return true;
                }
                java.io.File file2 = new java.io.File(str2 + BACK_UP);
                if (file.exists()) {
                    com.oplus.camera.q_renamed.a_renamed.b_renamed(str2, str2 + BACK_UP);
                }
                writeContentToTargetFile(str2, mapQueryUpdateRomProvider.get(KEY_CONTENT));
                if (!mapQueryUpdateRomProvider.get("md5").equals(com.oplus.camera.update.MD5Utils.md5Sum(str2))) {
                    com.oplus.camera.e_renamed.a_renamed(TAG, "startUpdateParameter, update fail");
                    deleteFile(file);
                    java.io.File file3 = new java.io.File(str2);
                    if (file2.exists()) {
                        com.oplus.camera.q_renamed.a_renamed.b_renamed(file2.getAbsolutePath(), file3.getAbsolutePath());
                    }
                    return false;
                }
                deleteFile(file2);
                updateSharePreference(str + VERSION, mapQueryUpdateRomProvider.get(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_VERSION));
                return true;
            }
        }
        return false;
    }

    private void updateSharePreference(java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences.Editor editorEdit = getSharedPreferences().edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
        if (str.contains(VERSION)) {
            com.oplus.camera.statistics.CameraStatisticsUtil.onCommon(this.mContext, com.oplus.camera.statistics.CameraStatisticsUtil.EVENT_RUS, com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_NAME, str) + " " + com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_VERSION, str2));
        }
    }

    public boolean getBooleanValue(java.lang.String str, boolean z_renamed) {
        java.lang.String string;
        android.content.SharedPreferences sharedPreferences = getSharedPreferences();
        return (sharedPreferences == null || (string = sharedPreferences.getString(str, null)) == null) ? z_renamed : java.lang.Boolean.valueOf(string).booleanValue();
    }

    private void writeContentToTargetFile(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        com.oplus.camera.e_renamed.a_renamed(TAG, "writeContentToTargetFile, targetFile: " + str + ", content: " + str2);
        com.oplus.camera.q_renamed.a_renamed.b_renamed(str, "text/plain", str2.getBytes());
    }

    private boolean updateAppParameter(java.lang.String str) {
        if (this.mGson == null) {
            this.mGson = new com.google.gson.Gson();
        }
        try {
            this.mUpdateOperationList = (java.util.ArrayList) this.mGson.fromJson(str, new com.google.gson.reflect.TypeToken<java.util.List<com.oplus.camera.update.UpdateOperation>>() { // from class: com.oplus.camera.update.UpdateUtil.2
            }.getType());
            if (this.mUpdateOperationList == null) {
                com.oplus.camera.e_renamed.f_renamed(TAG, "updateAppParameter fail, mUpdateOperationList is_renamed null!");
                return false;
            }
            for (int i_renamed = 0; i_renamed < this.mUpdateOperationList.size(); i_renamed++) {
                com.oplus.camera.update.UpdateOperation updateOperation = this.mUpdateOperationList.get(i_renamed);
                if (APP_UPDATE_TYPE_PREFERENCE_NOW.equals(updateOperation.getOperation())) {
                    updateSharePreference(updateOperation.getKey(), updateOperation.getValue());
                }
                if (APP_UPDATE_TYPE_PREFERENCE_LATER.equals(updateOperation.getOperation())) {
                    if (this.mAppLaterUpdateOperationList == null) {
                        this.mAppLaterUpdateOperationList = new java.util.ArrayList<>();
                    }
                    this.mAppLaterUpdateOperationList.add(updateOperation);
                }
            }
            return true;
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "updateAppParameter fail, e_renamed: " + e_renamed.getMessage());
            return false;
        }
    }
}
