package com.oplus.camera;

import android.app.Activity;
import android.content.SharedPreferences;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.ModeManager;
import com.oplus.camera.filmvideomode.FilmSlideBarContainer;
import com.oplus.camera.p172ui.CameraUIManager;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.SwitchCameraBar;
import com.oplus.camera.p172ui.menu.OptionItemInfo;
import com.oplus.camera.p172ui.menu.setting.CameraMenuOption;
import com.oplus.camera.p172ui.menu.setting.CameraSettingMenuPanel;
import com.oplus.camera.p172ui.menu.setting.down.DrawerLayout;
import com.oplus.camera.p172ui.widget.XPanExposureWheel;
import com.oplus.camera.professional.PanelContainer;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class AndroidTestAdapter {
    private static final int EXTEND_EXPOSURE_COMPENSATION_STEPS = 10;
    private static final String TAG = "AndroidTestAdapter";
    private Activity mActivity;
    private CameraManager mCameraManager;
    private ModeManager mModeManager = null;
    private volatile CameraUIManager mCameraUIManager = null;
    protected CameraUIListener mCameraUIListener = null;
    private String SUFFIX_MAKEUP = MenuClickMsgData.KEY_MAKEUP;
    private String SUFFIX_3D = "3d";

    public AndroidTestAdapter(Activity activity, CameraManager cameraManager) throws NoSuchFieldException {
        this.mActivity = null;
        this.mCameraManager = null;
        this.mActivity = activity;
        this.mCameraManager = cameraManager;
        getCameraUIManager();
        getCameraUIListener();
        getModeManager();
    }

    public boolean getSupportFunction(String str) {
        return this.mCameraManager.m10327b(str);
    }

    private void getCameraUIManager() throws NoSuchFieldException {
        try {
            Field declaredField = this.mCameraManager.getClass().getDeclaredField("mCameraUIManager");
            declaredField.setAccessible(true);
            this.mCameraUIManager = (CameraUIManager) declaredField.get(this.mCameraManager);
        } catch (IllegalAccessException | NoSuchFieldException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    private void getCameraUIListener() throws NoSuchFieldException {
        try {
            Field declaredField = this.mCameraManager.getClass().getDeclaredField("mCameraUIListener");
            declaredField.setAccessible(true);
            this.mCameraUIListener = (CameraUIListener) declaredField.get(this.mCameraManager);
        } catch (IllegalAccessException | NoSuchFieldException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    private void getModeManager() throws NoSuchFieldException {
        try {
            Field declaredField = this.mCameraManager.getClass().getDeclaredField("mModeManager");
            declaredField.setAccessible(true);
            this.mModeManager = (ModeManager) declaredField.get(this.mCameraManager);
        } catch (IllegalAccessException | NoSuchFieldException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    private BaseMode getCurrentModeInstance() throws NoSuchFieldException {
        try {
            Field declaredField = ModeManager.class.getDeclaredField("mCurrentMode");
            declaredField.setAccessible(true);
            return (BaseMode) declaredField.get(this.mModeManager);
        } catch (IllegalAccessException | NoSuchFieldException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public void onVideoPauseResumeClick() {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    AndroidTestAdapter.this.mActivity.findViewById(R.id_renamed.video_pause_resume).callOnClick();
                }
            });
        }
    }

    public void onSwitchCameraButtonClick() {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.4
                @Override // java.lang.Runnable
                public void run() {
                    AndroidTestAdapter.this.mActivity.findViewById(R.id_renamed.switch_camera_button).callOnClick();
                }
            });
        }
    }

    public void processSlowVideoResolutionChange(ComboPreferences comboPreferences, String str) {
        SharedPreferences.Editor editorEdit = comboPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_SLOW_VIDEO_SIZE, str);
        if ("video_size_1080p".equals(str)) {
            editorEdit.putInt(CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE));
        } else if ("video_size_720p".equals(str)) {
            editorEdit.putInt(CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE));
        }
        editorEdit.apply();
    }

    public void settingHeifFormat(ComboPreferences comboPreferences, boolean z) {
        SharedPreferences.Editor editorEdit = comboPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_HEIF_FORMAT, z ? "on" : "off");
        if (!"on".equals(comboPreferences.getString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off"))) {
            String str = z ? "HEIF" : "JPEG";
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC, str);
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC_CLICK, str);
        } else if (z) {
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC, "HEIF");
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC_CLICK, "HEIF");
        } else {
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC, "JPEG");
            editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC_CLICK, "JPEG");
            editorEdit.putString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off");
        }
        editorEdit.apply();
    }

    public boolean settingVideoSize(ComboPreferences comboPreferences, String str, int OplusGLSurfaceView_13) {
        if (!Util.m24392b(str, OplusGLSurfaceView_13)) {
            CameraLog.m12967f(TAG, "settingVideoSize, not support size: " + str);
            return false;
        }
        comboPreferences.setLocalId(this.mActivity, OplusGLSurfaceView_13);
        comboPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_SIZE, str).apply();
        return true;
    }

    public List<String> getVideoFps() throws NoSuchFieldException {
        ArrayList arrayList = new ArrayList();
        DrawerLayout drawerLayout = (DrawerLayout) this.mActivity.findViewById(R.id_renamed.oplus_slide_downward);
        try {
            Field declaredField = drawerLayout.getClass().getDeclaredField("mSubSettingView");
            declaredField.setAccessible(true);
            CameraSettingMenuPanel cameraSettingMenuPanel = (CameraSettingMenuPanel) declaredField.get(drawerLayout);
            if (cameraSettingMenuPanel != null) {
                Iterator<CameraMenuOption> it = cameraSettingMenuPanel.getMenuList().iterator();
                while (it.hasNext()) {
                    CameraMenuOption next = it.next();
                    if (next.mo20300a().equals(CameraUIInterface.KEY_VIDEO_FPS)) {
                        Iterator<OptionItemInfo> it2 = next.m21096Y().iterator();
                        while (it2.hasNext()) {
                            arrayList.add(it2.next().m20483c());
                        }
                    }
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return arrayList;
    }

    protected boolean settingVideoFps(ComboPreferences comboPreferences, int OplusGLSurfaceView_13) {
        if (120 == OplusGLSurfaceView_13 && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_120_FPS)) {
            CameraLog.m12967f(TAG, "settingVideoSize, not support fps: " + OplusGLSurfaceView_13);
            return false;
        }
        if (60 == OplusGLSurfaceView_13 && "video_size_4kuhd".equals(comboPreferences.getString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p")) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60_FPS)) {
            CameraLog.m12967f(TAG, "settingVideoSize, not support fps: " + OplusGLSurfaceView_13);
            return false;
        }
        comboPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(OplusGLSurfaceView_13)).apply();
        return true;
    }

    public void onClickThumbnail() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.5
            @Override // java.lang.Runnable
            public void run() {
                if (AndroidTestAdapter.this.mActivity != null) {
                    AndroidTestAdapter.this.mActivity.findViewById(R.id_renamed.thumbnail).callOnClick();
                }
            }
        });
    }

    public void settingSelfieMirror(ComboPreferences comboPreferences, boolean z) {
        SharedPreferences.Editor editorEdit = comboPreferences.edit();
        if (z) {
            editorEdit.putString(CameraUIInterface.KEY_MIRROR_SETTING, "on");
            editorEdit.putString(CameraUIInterface.KEY_MIRROR, "off");
        } else {
            editorEdit.putString(CameraUIInterface.KEY_MIRROR_SETTING, "off");
            editorEdit.putString(CameraUIInterface.KEY_MIRROR, "on");
        }
        editorEdit.apply();
        blurModeChanged();
    }

    public void blurModeChanged() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.6
            @Override // java.lang.Runnable
            public void run() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                try {
                    Method declaredMethod = AndroidTestAdapter.this.mCameraManager.getClass().getDeclaredMethod("blurModeChanged", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(AndroidTestAdapter.this.mCameraManager, new Object[0]);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        });
    }

    public void settingNightTripod(ComboPreferences comboPreferences, boolean z) {
        if (this.mCameraManager.m10327b(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE)) {
            comboPreferences.edit().putString(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE, z ? "on" : "off").apply();
            reloadSingleCameraSettingMenu(CameraUIInterface.KEY_NIGHT_TRIPOD_MODE);
        }
    }

    public void settingNightStarBurst(ComboPreferences comboPreferences, boolean z) {
        if (this.mCameraManager.m10327b(CameraUIInterface.KEY_NIGHT_STARBURST_MODE)) {
            comboPreferences.edit().putString(CameraUIInterface.KEY_NIGHT_STARBURST_MODE, z ? "on" : "off").apply();
            reloadSingleCameraSettingMenu(CameraUIInterface.KEY_NIGHT_STARBURST_MODE);
        }
    }

    public void reloadSingleCameraSettingMenu(final String str) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.7
            @Override // java.lang.Runnable
            public void run() {
                AndroidTestAdapter.this.mCameraUIManager.mo18211f(str);
            }
        });
    }

    public void setMovieParameter(final int OplusGLSurfaceView_13, final String str, final int i2) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.8
            @Override // java.lang.Runnable
            public void run() {
                FilmSlideBarContainer c2717l = (FilmSlideBarContainer) AndroidTestAdapter.this.mActivity.findViewById(R.id_renamed.movie_slide_bar_id);
                c2717l.setManual(OplusGLSurfaceView_13);
                c2717l.m13624a(OplusGLSurfaceView_13, str, i2);
                c2717l.m13632a(false, OplusGLSurfaceView_13);
                AndroidTestAdapter.this.blurModeChanged();
            }
        });
    }

    public void resetMovieParameter() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.9
            @Override // java.lang.Runnable
            public void run() {
                ((FilmSlideBarContainer) AndroidTestAdapter.this.mActivity.findViewById(R.id_renamed.movie_slide_bar_id)).m13638c();
                AndroidTestAdapter.this.blurModeChanged();
            }
        });
    }

    public void setProfessionalParameter(final int OplusGLSurfaceView_13, final String str, final int i2) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.10
            @Override // java.lang.Runnable
            public void run() {
                PanelContainer c2898p = (PanelContainer) AndroidTestAdapter.this.mActivity.findViewById(R.id_renamed.professional_param_slide_bar_container);
                c2898p.m15810a(OplusGLSurfaceView_13, str, i2);
                c2898p.m15817a(false, OplusGLSurfaceView_13);
                AndroidTestAdapter.this.blurModeChanged();
            }
        });
    }

    public void resetProfessionalParameter() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.11
            @Override // java.lang.Runnable
            public void run() {
                ((PanelContainer) AndroidTestAdapter.this.mActivity.findViewById(R.id_renamed.professional_param_slide_bar_container)).m15819b();
                AndroidTestAdapter.this.blurModeChanged();
            }
        });
    }

    public void setHEVCVideoFormat(ComboPreferences comboPreferences, boolean z) {
        String str = z ? CameraParameter.VideoEncoder.H265 : CameraParameter.VideoEncoder.H264;
        SharedPreferences.Editor editorEdit = comboPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_HEVC_VIDEO_FORMAT, z ? "on" : "off");
        editorEdit.putString(CameraUIInterface.KEY_VIDEO_CODEC, str);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) && !z) {
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_HDR, "off");
        }
        editorEdit.apply();
    }

    public void setXpanEvWheelValue(final int OplusGLSurfaceView_13) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                XPanExposureWheel xPanExposureWheel = (XPanExposureWheel) AndroidTestAdapter.this.mActivity.findViewById(R.id_renamed.xpan_exposure_wheel);
                xPanExposureWheel.setValue(xPanExposureWheel.getMaxValue() - (OplusGLSurfaceView_13 * 10));
            }
        });
    }

    public void setXpanZoom(final int OplusGLSurfaceView_13) throws InterruptedException {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.AndroidTestAdapter.3
            @Override // java.lang.Runnable
            public void run() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                SwitchCameraBar switchCameraBar = (SwitchCameraBar) AndroidTestAdapter.this.mActivity.findViewById(R.id_renamed.switch_camera_bar);
                try {
                    Method declaredMethod = switchCameraBar.getClass().getDeclaredMethod("moveAnimation", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(switchCameraBar, Integer.valueOf(OplusGLSurfaceView_13));
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        });
    }

    public float getCurrentZoom() {
        return this.mCameraManager.m10279aO();
    }

    public float[] getZoomRange() throws NumberFormatException {
        if (!getSupportFunction(CameraUIInterface.KEY_ZOOM)) {
            return new float[]{1.0f};
        }
        float minZoomValue = this.mCameraManager.getMinZoomValue();
        float fM10283aS = this.mCameraManager.m10283aS();
        if (this.mCameraManager.m10327b(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) {
            minZoomValue = Float.parseFloat("0.6");
        }
        return new float[]{minZoomValue, fM10283aS};
    }

    protected List<String> getSupportFilterList(int OplusGLSurfaceView_13) throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        List list;
        ArrayList arrayList = new ArrayList();
        BaseMode currentModeInstance = getCurrentModeInstance();
        try {
            Method declaredMethod = BaseMode.class.getDeclaredMethod("getFilterTypeList", Integer.TYPE);
            declaredMethod.setAccessible(true);
            if (this.mCameraManager.m10327b(CameraUIInterface.KEY_FILTER_PROCESS) && (list = (List) declaredMethod.invoke(currentModeInstance, Integer.valueOf(OplusGLSurfaceView_13))) != null) {
                arrayList.addAll(list);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return arrayList;
    }

    protected String getCurrentFilter() {
        return this.mModeManager.m12052dl();
    }

    protected boolean isSupportCommonFaceBeauty() {
        return this.mCameraManager.m10327b(CameraFunction.FACE_BEAUTY_COMMON);
    }

    protected boolean isFaceBeautyOpen() throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        BaseMode currentModeInstance = getCurrentModeInstance();
        try {
            Method declaredMethod = BaseMode.class.getDeclaredMethod("isFaceBeautyOpen", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(currentModeInstance, new Object[0])).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    protected List<String> getSupportCustomFaceBeautyKeys() throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        BaseMode currentModeInstance = getCurrentModeInstance();
        try {
            Method declaredMethod = BaseMode.class.getDeclaredMethod("getCustomBeautyKeys", new Class[0]);
            declaredMethod.setAccessible(true);
            if (this.mCameraManager.m10327b(CameraFunction.FACE_BEAUTY_CUSTOM) && (strArr = (String[]) declaredMethod.invoke(currentModeInstance, new Object[0])) != null) {
                arrayList.addAll(Arrays.asList(strArr));
                Iterator it = arrayList.iterator();
                if (!this.mModeManager.m11915bL()) {
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (str.endsWith(this.SUFFIX_MAKEUP) || str.endsWith(this.SUFFIX_3D)) {
                            it.remove();
                        }
                    }
                }
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return arrayList;
    }

    protected List<String> getSupportMakeupKeys() throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        BaseMode currentModeInstance = getCurrentModeInstance();
        try {
            Method declaredMethod = BaseMode.class.getDeclaredMethod("getMakeupKeys", new Class[0]);
            declaredMethod.setAccessible(true);
            if (this.mCameraManager.m10327b(CameraUIInterface.KEY_SUPPORT_MAKEUP) && (strArr = (String[]) declaredMethod.invoke(currentModeInstance, new Object[0])) != null) {
                arrayList.addAll(Arrays.asList(strArr));
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return arrayList;
    }

    protected int getCurrentMakeupIndex() throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        BaseMode currentModeInstance = getCurrentModeInstance();
        try {
            Method declaredMethod = BaseMode.class.getDeclaredMethod("getCurrMakeupIndex", new Class[0]);
            declaredMethod.setAccessible(true);
            if (this.mCameraManager.m10327b(CameraUIInterface.KEY_SUPPORT_MAKEUP)) {
                return ((Integer) declaredMethod.invoke(currentModeInstance, new Object[0])).intValue();
            }
            return 0;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return 0;
        }
    }
}
