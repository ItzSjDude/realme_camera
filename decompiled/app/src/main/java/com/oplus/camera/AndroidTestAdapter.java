package com.oplus.camera;

/* loaded from: classes2.dex */
public class AndroidTestAdapter {
    private static final int EXTEND_EXPOSURE_COMPENSATION_STEPS = 10;
    private static final java.lang.String TAG = "AndroidTestAdapter";
    private android.app.Activity mActivity;
    private com.oplus.camera.CameraManager mCameraManager;
    private com.oplus.camera.capmode.ModeManager mModeManager = null;
    private volatile com.oplus.camera.ui.d_renamed mCameraUIManager = null;
    protected com.oplus.camera.ui.CameraUIListener mCameraUIListener = null;
    private java.lang.String SUFFIX_MAKEUP = com.oplus.camera.statistics.model.MenuClickMsgData.KEY_MAKEUP;
    private java.lang.String SUFFIX_3D = "3d";

    public AndroidTestAdapter(android.app.Activity activity, com.oplus.camera.CameraManager cameraManager) throws java.lang.NoSuchFieldException {
        this.mActivity = null;
        this.mCameraManager = null;
        this.mActivity = activity;
        this.mCameraManager = cameraManager;
        getCameraUIManager();
        getCameraUIListener();
        getModeManager();
    }

    public boolean getSupportFunction(java.lang.String str) {
        return this.mCameraManager.b_renamed(str);
    }

    private void getCameraUIManager() throws java.lang.NoSuchFieldException {
        try {
            java.lang.reflect.Field declaredField = this.mCameraManager.getClass().getDeclaredField("mCameraUIManager");
            declaredField.setAccessible(true);
            this.mCameraUIManager = (com.oplus.camera.ui.d_renamed) declaredField.get(this.mCameraManager);
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchFieldException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    private void getCameraUIListener() throws java.lang.NoSuchFieldException {
        try {
            java.lang.reflect.Field declaredField = this.mCameraManager.getClass().getDeclaredField("mCameraUIListener");
            declaredField.setAccessible(true);
            this.mCameraUIListener = (com.oplus.camera.ui.CameraUIListener) declaredField.get(this.mCameraManager);
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchFieldException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    private void getModeManager() throws java.lang.NoSuchFieldException {
        try {
            java.lang.reflect.Field declaredField = this.mCameraManager.getClass().getDeclaredField("mModeManager");
            declaredField.setAccessible(true);
            this.mModeManager = (com.oplus.camera.capmode.ModeManager) declaredField.get(this.mCameraManager);
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchFieldException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    private com.oplus.camera.capmode.BaseMode getCurrentModeInstance() throws java.lang.NoSuchFieldException {
        try {
            java.lang.reflect.Field declaredField = com.oplus.camera.capmode.ModeManager.class.getDeclaredField("mCurrentMode");
            declaredField.setAccessible(true);
            return (com.oplus.camera.capmode.BaseMode) declaredField.get(this.mModeManager);
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchFieldException e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public void onVideoPauseResumeClick() {
        android.app.Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.AndroidTestAdapter.this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.video_pause_resume).callOnClick();
                }
            });
        }
    }

    public void onSwitchCameraButtonClick() {
        android.app.Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.4
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.AndroidTestAdapter.this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.switch_camera_button).callOnClick();
                }
            });
        }
    }

    public void processSlowVideoResolutionChange(com.oplus.camera.ComboPreferences comboPreferences, java.lang.String str) {
        android.content.SharedPreferences.Editor editorEdit = comboPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE, str);
        if ("video_size_1080p".equals(str)) {
            editorEdit.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE));
        } else if ("video_size_720p".equals(str)) {
            editorEdit.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE));
        }
        editorEdit.apply();
    }

    public void settingHeifFormat(com.oplus.camera.ComboPreferences comboPreferences, boolean z_renamed) {
        android.content.SharedPreferences.Editor editorEdit = comboPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_HEIF_FORMAT, z_renamed ? "on_renamed" : "off");
        if (!"on_renamed".equals(comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off"))) {
            java.lang.String str = z_renamed ? "HEIF" : "JPEG";
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, str);
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC_CLICK, str);
        } else if (z_renamed) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, "HEIF");
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC_CLICK, "HEIF");
        } else {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC, "JPEG");
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_CODEC_CLICK, "JPEG");
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off");
        }
        editorEdit.apply();
    }

    public boolean settingVideoSize(com.oplus.camera.ComboPreferences comboPreferences, java.lang.String str, int i_renamed) {
        if (!com.oplus.camera.util.Util.b_renamed(str, i_renamed)) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "settingVideoSize, not support size: " + str);
            return false;
        }
        comboPreferences.setLocalId(this.mActivity, i_renamed);
        comboPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, str).apply();
        return true;
    }

    public java.util.List<java.lang.String> getVideoFps() throws java.lang.NoSuchFieldException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.oplus.camera.ui.menu.setting.down.DrawerLayout drawerLayout = (com.oplus.camera.ui.menu.setting.down.DrawerLayout) this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_slide_downward);
        try {
            java.lang.reflect.Field declaredField = drawerLayout.getClass().getDeclaredField("mSubSettingView");
            declaredField.setAccessible(true);
            com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel cameraSettingMenuPanel = (com.oplus.camera.ui.menu.setting.CameraSettingMenuPanel) declaredField.get(drawerLayout);
            if (cameraSettingMenuPanel != null) {
                java.util.Iterator<com.oplus.camera.ui.menu.setting.CameraMenuOption> it = cameraSettingMenuPanel.getMenuList().iterator();
                while (it.hasNext()) {
                    com.oplus.camera.ui.menu.setting.CameraMenuOption next = it.next();
                    if (next.a_renamed().equals(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS)) {
                        java.util.Iterator<com.oplus.camera.ui.menu.e_renamed> it2 = next.Y_renamed().iterator();
                        while (it2.hasNext()) {
                            arrayList.add(it2.next().c_renamed());
                        }
                    }
                }
            }
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchFieldException e_renamed) {
            e_renamed.printStackTrace();
        }
        return arrayList;
    }

    protected boolean settingVideoFps(com.oplus.camera.ComboPreferences comboPreferences, int i_renamed) {
        if (120 == i_renamed && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_120_FPS)) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "settingVideoSize, not support fps: " + i_renamed);
            return false;
        }
        if (60 == i_renamed && "video_size_4kuhd".equals(comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p")) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60_FPS)) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "settingVideoSize, not support fps: " + i_renamed);
            return false;
        }
        comboPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, java.lang.String.valueOf(i_renamed)).apply();
        return true;
    }

    public void onClickThumbnail() {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.5
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.AndroidTestAdapter.this.mActivity != null) {
                    com.oplus.camera.AndroidTestAdapter.this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.thumbnail).callOnClick();
                }
            }
        });
    }

    public void settingSelfieMirror(com.oplus.camera.ComboPreferences comboPreferences, boolean z_renamed) {
        android.content.SharedPreferences.Editor editorEdit = comboPreferences.edit();
        if (z_renamed) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_MIRROR_SETTING, "on_renamed");
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_MIRROR, "off");
        } else {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_MIRROR_SETTING, "off");
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_MIRROR, "on_renamed");
        }
        editorEdit.apply();
        blurModeChanged();
    }

    public void blurModeChanged() {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.6
            @Override // java.lang.Runnable
            public void run() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                try {
                    java.lang.reflect.Method declaredMethod = com.oplus.camera.AndroidTestAdapter.this.mCameraManager.getClass().getDeclaredMethod("blurModeChanged", new java.lang.Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(com.oplus.camera.AndroidTestAdapter.this.mCameraManager, new java.lang.Object[0]);
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
        });
    }

    public void settingNightTripod(com.oplus.camera.ComboPreferences comboPreferences, boolean z_renamed) {
        if (this.mCameraManager.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE)) {
            comboPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE, z_renamed ? "on_renamed" : "off").apply();
            reloadSingleCameraSettingMenu(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE);
        }
    }

    public void settingNightStarBurst(com.oplus.camera.ComboPreferences comboPreferences, boolean z_renamed) {
        if (this.mCameraManager.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_STARBURST_MODE)) {
            comboPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_STARBURST_MODE, z_renamed ? "on_renamed" : "off").apply();
            reloadSingleCameraSettingMenu(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_STARBURST_MODE);
        }
    }

    public void reloadSingleCameraSettingMenu(final java.lang.String str) {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.7
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.AndroidTestAdapter.this.mCameraUIManager.f_renamed(str);
            }
        });
    }

    public void setMovieParameter(final int i_renamed, final java.lang.String str, final int i2) {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.8
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.filmvideomode.l_renamed lVar = (com.oplus.camera.filmvideomode.l_renamed) com.oplus.camera.AndroidTestAdapter.this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.movie_slide_bar_id);
                lVar.setManual(i_renamed);
                lVar.a_renamed(i_renamed, str, i2);
                lVar.a_renamed(false, i_renamed);
                com.oplus.camera.AndroidTestAdapter.this.blurModeChanged();
            }
        });
    }

    public void resetMovieParameter() {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.9
            @Override // java.lang.Runnable
            public void run() {
                ((com.oplus.camera.filmvideomode.l_renamed) com.oplus.camera.AndroidTestAdapter.this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.movie_slide_bar_id)).c_renamed();
                com.oplus.camera.AndroidTestAdapter.this.blurModeChanged();
            }
        });
    }

    public void setProfessionalParameter(final int i_renamed, final java.lang.String str, final int i2) {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.10
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.professional.p_renamed pVar = (com.oplus.camera.professional.p_renamed) com.oplus.camera.AndroidTestAdapter.this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.professional_param_slide_bar_container);
                pVar.a_renamed(i_renamed, str, i2);
                pVar.a_renamed(false, i_renamed);
                com.oplus.camera.AndroidTestAdapter.this.blurModeChanged();
            }
        });
    }

    public void resetProfessionalParameter() {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.11
            @Override // java.lang.Runnable
            public void run() {
                ((com.oplus.camera.professional.p_renamed) com.oplus.camera.AndroidTestAdapter.this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.professional_param_slide_bar_container)).b_renamed();
                com.oplus.camera.AndroidTestAdapter.this.blurModeChanged();
            }
        });
    }

    public void setHEVCVideoFormat(com.oplus.camera.ComboPreferences comboPreferences, boolean z_renamed) {
        java.lang.String str = z_renamed ? com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265 : com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264;
        android.content.SharedPreferences.Editor editorEdit = comboPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_HEVC_VIDEO_FORMAT, z_renamed ? "on_renamed" : "off");
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, str);
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) && !z_renamed) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HDR, "off");
        }
        editorEdit.apply();
    }

    public void setXpanEvWheelValue(final int i_renamed) {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.widget.XPanExposureWheel xPanExposureWheel = (com.oplus.camera.ui.widget.XPanExposureWheel) com.oplus.camera.AndroidTestAdapter.this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.xpan_exposure_wheel);
                xPanExposureWheel.setValue(xPanExposureWheel.getMaxValue() - (i_renamed * 10));
            }
        });
    }

    public void setXpanZoom(final int i_renamed) throws java.lang.InterruptedException {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.3
            @Override // java.lang.Runnable
            public void run() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                com.oplus.camera.ui.SwitchCameraBar switchCameraBar = (com.oplus.camera.ui.SwitchCameraBar) com.oplus.camera.AndroidTestAdapter.this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.switch_camera_bar);
                try {
                    java.lang.reflect.Method declaredMethod = switchCameraBar.getClass().getDeclaredMethod("moveAnimation", java.lang.Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(switchCameraBar, java.lang.Integer.valueOf(i_renamed));
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
        });
    }

    public float getCurrentZoom() {
        return this.mCameraManager.aO_renamed();
    }

    public float[] getZoomRange() throws java.lang.NumberFormatException {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ZOOM)) {
            return new float[]{1.0f};
        }
        float minZoomValue = this.mCameraManager.getMinZoomValue();
        float fAS = this.mCameraManager.aS_renamed();
        if (this.mCameraManager.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) {
            minZoomValue = java.lang.Float.parseFloat("0.6");
        }
        return new float[]{minZoomValue, fAS};
    }

    protected java.util.List<java.lang.String> getSupportFilterList(int i_renamed) throws java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.util.List list;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.oplus.camera.capmode.BaseMode currentModeInstance = getCurrentModeInstance();
        try {
            java.lang.reflect.Method declaredMethod = com.oplus.camera.capmode.BaseMode.class.getDeclaredMethod("getFilterTypeList", java.lang.Integer.TYPE);
            declaredMethod.setAccessible(true);
            if (this.mCameraManager.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS) && (list = (java.util.List) declaredMethod.invoke(currentModeInstance, java.lang.Integer.valueOf(i_renamed))) != null) {
                arrayList.addAll(list);
            }
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e_renamed) {
            e_renamed.printStackTrace();
        }
        return arrayList;
    }

    protected java.lang.String getCurrentFilter() {
        return this.mModeManager.dl_renamed();
    }

    protected boolean isSupportCommonFaceBeauty() {
        return this.mCameraManager.b_renamed(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_COMMON);
    }

    protected boolean isFaceBeautyOpen() throws java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.SecurityException {
        com.oplus.camera.capmode.BaseMode currentModeInstance = getCurrentModeInstance();
        try {
            java.lang.reflect.Method declaredMethod = com.oplus.camera.capmode.BaseMode.class.getDeclaredMethod("isFaceBeautyOpen", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            return ((java.lang.Boolean) declaredMethod.invoke(currentModeInstance, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e_renamed) {
            e_renamed.printStackTrace();
            return false;
        }
    }

    protected java.util.List<java.lang.String> getSupportCustomFaceBeautyKeys() throws java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.String[] strArr;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.oplus.camera.capmode.BaseMode currentModeInstance = getCurrentModeInstance();
        try {
            java.lang.reflect.Method declaredMethod = com.oplus.camera.capmode.BaseMode.class.getDeclaredMethod("getCustomBeautyKeys", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            if (this.mCameraManager.b_renamed(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_CUSTOM) && (strArr = (java.lang.String[]) declaredMethod.invoke(currentModeInstance, new java.lang.Object[0])) != null) {
                arrayList.addAll(java.util.Arrays.asList(strArr));
                java.util.Iterator it = arrayList.iterator();
                if (!this.mModeManager.bL_renamed()) {
                    while (it.hasNext()) {
                        java.lang.String str = (java.lang.String) it.next();
                        if (str.endsWith(this.SUFFIX_MAKEUP) || str.endsWith(this.SUFFIX_3D)) {
                            it.remove();
                        }
                    }
                }
            }
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e_renamed) {
            e_renamed.printStackTrace();
        }
        return arrayList;
    }

    protected java.util.List<java.lang.String> getSupportMakeupKeys() throws java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.String[] strArr;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.oplus.camera.capmode.BaseMode currentModeInstance = getCurrentModeInstance();
        try {
            java.lang.reflect.Method declaredMethod = com.oplus.camera.capmode.BaseMode.class.getDeclaredMethod("getMakeupKeys", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            if (this.mCameraManager.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_MAKEUP) && (strArr = (java.lang.String[]) declaredMethod.invoke(currentModeInstance, new java.lang.Object[0])) != null) {
                arrayList.addAll(java.util.Arrays.asList(strArr));
            }
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e_renamed) {
            e_renamed.printStackTrace();
        }
        return arrayList;
    }

    protected int getCurrentMakeupIndex() throws java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.SecurityException {
        com.oplus.camera.capmode.BaseMode currentModeInstance = getCurrentModeInstance();
        try {
            java.lang.reflect.Method declaredMethod = com.oplus.camera.capmode.BaseMode.class.getDeclaredMethod("getCurrMakeupIndex", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            if (this.mCameraManager.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_MAKEUP)) {
                return ((java.lang.Integer) declaredMethod.invoke(currentModeInstance, new java.lang.Object[0])).intValue();
            }
            return 0;
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e_renamed) {
            e_renamed.printStackTrace();
            return 0;
        }
    }
}
