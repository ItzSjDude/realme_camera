package com.oplus.camera.capmode;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.View;
import androidx.preference.PreferenceManager;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.menu.setting.CameraMenuOption;
import com.oplus.camera.p172ui.p173a.HintManager;
import com.oplus.camera.p172ui.preview.p177a.FaceBeautyHelp;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.AiVideoSceneDetector;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPreviewCallback;
import java.lang.reflect.InvocationTargetException;

/* compiled from: CommonVideoMode.java */
/* renamed from: com.oplus.camera.capmode.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class CommonVideoMode extends VideoMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f12838g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f12839h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f12840i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f12841j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f12842k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f12843l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f12844m;

    /* renamed from: OplusGLSurfaceView_11 */
    private CameraMenuOption f12845n;

    /* renamed from: o */
    private boolean f12846o;

    /* renamed from: p */
    private boolean f12847p;

    /* renamed from: q */
    private boolean f12848q;

    /* renamed from: r */
    private Range<Integer> f12849r;

    /* renamed from: s */
    private Range<Integer> f12850s;

    /* renamed from: t */
    private Range<Integer> f12851t;

    /* renamed from: u */
    private Range<Integer> f12852u;

    /* renamed from: v */
    private AiVideoSceneDetector f12853v;

    /* renamed from: w */
    private int f12854w;

    /* renamed from: x */
    private String f12855x;

    /* renamed from: y */
    private boolean f12856y;

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getBackUpFaceBeautyKey() {
        return CameraUIInterface.KEY_VIDEO_FACEBEAUTY_LEVEL_MENU_BACKUP;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.REC_MODE_COMMON;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        return 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getEffectMenuKeyByMode() {
        return CameraUIInterface.KEY_VIDEO_FILTER_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getFaceBeautyKey() {
        return CameraUIInterface.KEY_VIDEO_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFilterTitleTexId() {
        return R.string.camera_fuji_style;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getHDRKey() {
        return CameraUIInterface.KEY_VIDEO_HDR;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isCameraSettingMenuOptionEnable(String str) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isCommonVideoMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHFR() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isSalientObjectDetectionEnabled() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public CommonVideoMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f12838g = true;
        this.f12839h = false;
        this.f12840i = false;
        this.f12841j = false;
        this.f12842k = false;
        this.f12843l = -1;
        this.f12844m = 0;
        this.f12845n = null;
        this.f12846o = false;
        this.f12847p = false;
        this.f12848q = false;
        this.f12849r = Range.create(120, 120);
        this.f12850s = Range.create(60, 60);
        this.f12851t = Range.create(30, 30);
        this.f12852u = Range.create(20, 30);
        this.f12853v = null;
        this.f12854w = FilterHelper.f21279a;
        this.f12855x = "";
        this.f12856y = false;
        if (getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO)) {
            this.f12853v = new AiVideoSceneDetector();
        }
        if (this.mPreviewEffectProcess != null) {
            if (getSupportFunction(CameraUIInterface.KEY_VIDEO_BLUR_MENU) || getSupportFunction(CameraFunction.VIDEO_BLUR_PROCESS)) {
                setVideoBlurEffect(isBlurOpen());
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getEnvironmentTipsThreshold() {
        if (this.mbFrontCamera) {
            return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SUPPORT_FRONT_DARK_TIPS_THRESHOLD);
        }
        return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SUPPORT_BACK_DARK_TIPS_THRESHOLD);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void showRecordingTimeUI() {
        super.showRecordingTimeUI();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setFocusingSoundVolume(int OplusGLSurfaceView_13) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.mVideoRecorder != null) {
            this.mVideoRecorder.m12704a(OplusGLSurfaceView_13, getZoomValue());
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setVideoSoundValue(float COUIBaseListPopupWindow_12) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if ("all_around".equals(this.mPreferences.getString(m12358f(), "all_around"))) {
            String str = Float.compare(COUIBaseListPopupWindow_12, 1.0f) != 0 ? "focusing" : ApsConstant.CAPTURE_MODE_PANORAMA;
            if (this.mVideoRecorder != null) {
                this.mVideoRecorder.m12715a(str);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setFocusTrackingState(boolean z) {
        if ("all_around".equals(this.mPreferences.getString(m12358f(), "all_around")) && this.mVideoRecorder != null && isVideoRecordStarted() && Util.m24175F()) {
            this.mVideoRecorder.m12747g(z);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setFocusTrackingLocation(float COUIBaseListPopupWindow_12, float f2) {
        if ("all_around".equals(this.mPreferences.getString(m12358f(), "all_around")) && this.mVideoRecorder != null && isVideoRecordStarted() && Util.m24175F()) {
            this.mVideoRecorder.m12724b(COUIBaseListPopupWindow_12, f2);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String m12358f() {
        return this.mbFrontCamera ? CameraUIInterface.KEY_VIDEO_SOUND_FRONT : CameraUIInterface.KEY_VIDEO_SOUND_REAR;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayFixedUpModeHint() {
        super.displayFixedUpModeHint();
        if (this.mActivity == null) {
            return;
        }
        CameraLog.m12954a("CommonVideoMode", "displayFixedUpModeHint");
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean isQualcommEndOfStreamNeed() {
        if ((isSuperEISOpen() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_END_VIDEO_EIS_STREAM)) || !m12324T() || !Util.m24169C()) {
            return false;
        }
        byte[] bArrM13276k = this.mOneCamera.mo13086e().m13276k();
        CameraLog.m12954a("CommonVideoMode", "isQualcommEndOfStreamNeed, endOfStreamValue: " + bArrM13276k);
        return bArrM13276k != null && bArrM13276k.length > 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        int OplusGLSurfaceView_13;
        if (this.mbFrontCamera || !getSupportFunction(CameraUIInterface.KEY_SUPPORT_FOVC)) {
            OplusGLSurfaceView_13 = 32779;
        } else {
            OplusGLSurfaceView_13 = 33547;
            if (Util.m24169C() && getSupportFunction(CameraUIInterface.KEY_VIDEO_HIGH_FPS) && 60 == m12377t()) {
                OplusGLSurfaceView_13 = 32801;
            }
        }
        if (!Util.m24169C() && getSupportFunction(CameraUIInterface.KEY_VIDEO_HIGH_FPS) && 60 == m12377t()) {
            OplusGLSurfaceView_13 = 32801;
        }
        if (getSupportFunction(CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS)) {
            OplusGLSurfaceView_13 = this.mbFrontCamera ? 32811 : 32808;
        }
        if (isVideoHdrOpen()) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR)) {
                OplusGLSurfaceView_13 |= 1024;
            } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR)) {
                OplusGLSurfaceView_13 = 32929;
            }
        }
        if (getSupportFunction(CameraFunction.ULTRA_NIGHT_VIDEO) && !this.mbFrontCamera && isUltraNightVideoOpen()) {
            OplusGLSurfaceView_13 = 32930;
        }
        if (getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen()) {
            OplusGLSurfaceView_13 = 32935;
        }
        return (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT) && isSloganOpen()) ? OplusGLSurfaceView_13 | 1024 : OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        readProfile();
        String videoSizeType = getVideoSizeType();
        Size sizeFromConfig = getSizeFromConfig(getCameraFeature(), "type_main_preview_frame", BaseMode.EnumC2645a.INPUT);
        return sizeFromConfig != null ? sizeFromConfig : getVideoPreviewSize(videoSizeType) != null ? getVideoPreviewSize(videoSizeType) : super.getPreviewSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSurfaceSize(Size size) {
        return (isVideoSuperEisWideOpen() || isRearSuperEISOpen()) ? CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_VIDEO_EIS_SURFACE_SIZE) : size;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if ("type_still_capture_jpeg".equals(str)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR)) {
                return false;
            }
            return !AlgoSwitchConfig.getSupportApsCapture();
        }
        if ("type_still_capture_yuv_main".equals(str)) {
            return (2 == AlgoSwitchConfig.getApsVersion() || is4k() || (isVideo10BitOpen() && isVideoHdrOpen())) && (this.mCameraInterface.mo10575i() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREAM_SUPPORT_PREVERSION));
        }
        if ("type_video_frame".equals(str)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_APS_SUPPORT_VIDEO_SUPER_EIS) && isRearSuperEISOpen() && Util.m24169C() && this.mCameraInterface.mo10575i()) {
                return true;
            }
            return getSupportFunction(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen();
        }
        if ("type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str)) {
            return 3 == AlgoSwitchConfig.getApsVersion() && isSatOpen() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL);
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        super.onResume(z);
        String string = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_SIZE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_VIDEO_SIZE, this.mCameraId));
        if (m12382y() && !"video_size_1080p".equals(string)) {
            this.mCameraInterface.mo10559c(true);
            this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            this.mCameraInterface.mo10559c(false);
        }
        if (isNoneSatUltraWideAngleOpen() && !m12305A() && !m12306B()) {
            boolean z2 = !isAiEnhancementVideoOpen() && 60 == Integer.parseInt(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS));
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.f12544x95833f71);
            boolean z3 = configIntValue > 0 && configIntValue < getResolutionBySizeType(string);
            if ("video_size_4kuhd".equals(string) || z2 || z3 || m12386a(string) || ("video_size_1080p".equals(string) && m12320P())) {
                this.mCameraInterface.mo10559c(true);
                this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                this.mCameraInterface.mo10559c(false);
                this.mbFlashTemporaryDisabled = false;
            }
        }
        if (getSupportFunction(CameraFunction.VIDEO_HDR)) {
            m12373p();
        }
        if (getSupportFunction(CameraFunction.ULTRA_NIGHT_VIDEO)) {
            m12374q();
        }
        if (getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO)) {
            checkAiEnhancementVideoState();
        }
        if (getSupportFunction(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE)) {
            m12387b();
        }
        if (isAiEnhancementVideoOpen() && m12322R()) {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
        }
        m12314J();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void hideBubble(String str) {
        if (!getCameraMode().equals(str) && isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
            this.mCameraUIInterface.mo18210f(7, true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onSwitchCameraButtonClick() {
        super.onSwitchCameraButtonClick();
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
            this.mCameraUIInterface.mo18210f(7, false);
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        if (this.mPreferences != null && this.mPreferences.getBoolean("pref_camera_statement_key", false) && isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
            this.mCameraUIInterface.mo18210f(7, true);
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        this.f12855x = "";
        if (this.mPreferences != null) {
            if ("off".equals(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_BLUR_MENU, "off")) && this.mPreferences.getBoolean(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false)) {
                this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false).apply();
            }
            m12361g();
        }
        this.f12843l = -1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m12344b(String str) {
        if (CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU.equals(str) || CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str) || CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE.equals(str)) {
            return getSupportFunction(str);
        }
        if (CameraUIInterface.KEY_VIDEO_HDR.equals(str)) {
            return getSupportFunction(CameraFunction.VIDEO_HDR);
        }
        if (CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO.equals(str)) {
            return getSupportFunction(CameraFunction.ULTRA_NIGHT_VIDEO);
        }
        if (CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(str)) {
            return getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO);
        }
        return CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE.equals(str);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m12361g() {
        if (!this.mCameraInterface.mo10575i() || isVideoRecording() || this.mPreferences == null || isDoubleExposureOpen()) {
            return;
        }
        boolean zM12366i = m12366i();
        boolean z = this.mPreferences.getBoolean(CameraUIInterface.KEY_LASTED_VIDEO_SAVE_STATUS, false);
        CameraLog.m12954a("CommonVideoMode", "restoreSpecialEffectStatus, isAnySwitchOn: " + zM12366i + ", isSavedStatus: " + z);
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        if (zM12366i && !z) {
            editorEdit.putBoolean(CameraUIInterface.KEY_LASTED_VIDEO_SAVE_STATUS, true);
            editorEdit.putString(CameraUIInterface.KEY_LASTED_VIDEO_FPS, String.valueOf(getVideoFps()));
            editorEdit.putString(CameraUIInterface.KEY_LASTED_VIDEO_SIZE, getVideoSizeType());
            editorEdit.putString(CameraUIInterface.KEY_LASTED_VIDEO_CODEC, getVideoCodec());
            editorEdit.apply();
            CameraLog.m12954a("CommonVideoMode", "restoreSpecialEffectStatus, save status");
            return;
        }
        if (zM12366i || !z) {
            return;
        }
        editorEdit.putBoolean(CameraUIInterface.KEY_LASTED_VIDEO_SAVE_STATUS, false).apply();
        String string = this.mPreferences.getString(CameraUIInterface.KEY_LASTED_VIDEO_CODEC, "");
        if (!"".equals(string)) {
            if (!TextUtils.equals(string, getVideoCodec())) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_CODEC, string);
            }
            editorEdit.putString(CameraUIInterface.KEY_LASTED_VIDEO_CODEC, "");
            editorEdit.apply();
        }
        if (m12367j()) {
            if (this.mCameraInterface.mo10449E()) {
                this.mCameraInterface.mo10559c(true);
            }
            String string2 = this.mPreferences.getString(CameraUIInterface.KEY_LASTED_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS);
            String string3 = this.mPreferences.getString(CameraUIInterface.KEY_LASTED_VIDEO_SIZE, getDefaultVideoSize());
            boolean zM12336a = m12336a(string2, string3, this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(getVideoFps())), getVideoSizeType());
            CameraLog.m12954a("CommonVideoMode", "restoreSpecialEffectStatus, read status, videoSizeAndFpsSame: " + zM12336a + ", VideoFps: " + string2 + ", VideoSize: " + string3);
            if (!zM12336a) {
                if (!TextUtils.isEmpty(string2)) {
                    editorEdit.putString(CameraUIInterface.KEY_VIDEO_FPS, string2);
                }
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, string3);
            }
            editorEdit.putString(CameraUIInterface.KEY_LASTED_VIDEO_FPS, "");
            editorEdit.putString(CameraUIInterface.KEY_LASTED_VIDEO_SIZE, "");
            editorEdit.apply();
            if (this.mCameraInterface.mo10449E()) {
                this.mCameraInterface.mo10559c(false);
            }
            m12308D();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m12364h() {
        if (isRearSuperEISOpen()) {
            this.mCameraInterface.mo10559c(true);
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            if (isBlurOpen()) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_BLUR_MENU, "off");
            }
            if (isFaceBeautyOrMakeupOpen()) {
                editorEdit.putInt(getFaceBeautyKey(), 0);
            }
            if (isFilterEffectOpen()) {
                m12309E();
            }
            editorEdit.apply();
            this.mCameraInterface.mo10559c(false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m12336a(String str, String str2, String str3, String str4) {
        return TextUtils.equals(str, str3) && TextUtils.equals(str2, str4);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean m12366i() {
        if (getCurrFilterIndex() != FilterHelper.f21279a) {
            CameraLog.m12954a("CommonVideoMode", "checkSpecialEffectSwitch, filter is open");
            return true;
        }
        if (isRearSuperEISOpen() || m12382y()) {
            CameraLog.m12954a("CommonVideoMode", "checkSpecialEffectSwitch, super EIS is open");
            return true;
        }
        if (getSupportFunction(CameraFunction.FACE_BEAUTY_PROCESS)) {
            if (this.mbPaused && this.f12839h && getFaceBeautyCurrIndex() == 0) {
                this.f12839h = false;
            }
            if (this.f12839h || getFaceBeautyCurrIndex() != 0) {
                CameraLog.m12954a("CommonVideoMode", "checkSpecialEffectSwitch, face beauty is open");
                return true;
            }
        }
        if (getSupportFunction(CameraUIInterface.KEY_VIDEO_BLUR_MENU)) {
            if ((!this.mCameraInterface.mo10449E() && this.mCameraUIInterface.mo18051O()) || this.mPreferences.getBoolean(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false)) {
                CameraLog.m12954a("CommonVideoMode", "checkSpecialEffectSwitch, blur is open");
                return true;
            }
        }
        if (getSupportFunction(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) && isNoneSatUltraWideAngleOpen()) {
            CameraLog.m12954a("CommonVideoMode", "checkSpecialEffectSwitch, NoneSatUltraWideAngle is Open");
            return true;
        }
        if (isVideoHdrOpen()) {
            CameraLog.m12954a("CommonVideoMode", "checkSpecialEffectSwitch, 3hdr is open");
            return true;
        }
        if (isUltraNightVideoOpen()) {
            CameraLog.m12954a("CommonVideoMode", "checkSpecialEffectSwitch, night video is open.");
            return true;
        }
        if (!isAiEnhancementVideoOpen()) {
            return false;
        }
        CameraLog.m12954a("CommonVideoMode", "checkSpecialEffectSwitch, ai enhancement video is open.");
        return true;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean m12367j() {
        return ("".equals(this.mPreferences.getString(CameraUIInterface.KEY_LASTED_VIDEO_FPS, "")) || "".equals(this.mPreferences.getString(CameraUIInterface.KEY_LASTED_VIDEO_SIZE, ""))) ? false : true;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeSwitchToMode(boolean z) {
        super.beforeSwitchToMode(z);
        enableVideoRecordingSound(true);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeSwitchCamera() {
        m12361g();
        super.beforeSwitchCamera();
        if (this.mCameraUIInterface.mo18059T() && !this.f12840i) {
            this.mCameraUIInterface.mo18060U();
        }
        if (m12382y()) {
            this.mCameraUIInterface.mo18046M();
        }
        this.mCameraUIInterface.mo18067a(R.string.camera_ai_enhancement_video_hint_on);
        this.mCameraUIInterface.mo18067a(R.string.camera_ai_enhancement_video_hint_off);
        m12364h();
        m12378u();
        m12380w();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int OplusGLSurfaceView_13) {
        this.f12855x = "";
        super.cameraIdChanged(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCameraIdChangedAnimationEnd() {
        this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_SIZE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFilterNoneIndex() {
        return this.mbFrontCamera ? FilterHelper.m22646t() : FilterHelper.m22644r();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        super.setOrientation(OplusGLSurfaceView_13);
        if (3 == AlgoSwitchConfig.getApsVersion() && this.mCameraInterface.mo10575i() && this.mOneCamera != null) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_ORIENTATION, (CaptureRequest.Key) Integer.valueOf(getJpegOrientation(this.mCameraId, this.mOrientation)));
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_QUALITY, (CaptureRequest.Key) (byte) 95);
            this.mOneCamera.mo13067b((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_GPS_LOCATION, (CaptureRequest.Key) this.mCameraInterface.mo10595y());
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00fb  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m12333a(boolean r12) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.CommonVideoMode.m12333a(boolean):void");
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        super.onInitCameraMode();
        this.f12855x = "";
        if (this.mPreferences instanceof ComboPreferences) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_COLOR_EXTRACTION_SUPPORT) && ((!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_NEON_SUPPORT) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_BLUR_SUPPORT_WITHOUT_NEON)) && FilterHelper.f21320j.f21250d.size() == FilterHelper.f21320j.f21249c.size())) {
                ((ComboPreferences) this.mPreferences).m11076c(CameraUIInterface.KEY_VIDEO_FILTER_INDEX);
            } else {
                ((ComboPreferences) this.mPreferences).m11077d(CameraUIInterface.KEY_VIDEO_FILTER_INDEX);
            }
        }
        this.mCameraUIInterface.mo18110a(R.string.camera_10bit_hint);
        m12361g();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        super.onDeInitCameraMode(str);
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18067a(R.string.camera_video_fps_60);
            this.mCameraUIInterface.mo18110a(R.string.camera_10bit_hint);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void doAfterStartPreview() {
        super.doAfterStartPreview();
        if (this.mbPaused || this.mPreferences == null || !"on".equals(this.mPreferences.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off"))) {
            return;
        }
        this.mCameraUIInterface.mo18110a(R.string.hint_video_size_4KUHD);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void disableRedDotHintOnModes() {
        if (PreferenceManager.m3981a(this.mActivity).getBoolean("video_mode_reddot_show", true)) {
            this.mCameraUIInterface.mo18177b(R.string.camera_mode_video);
            PreferenceManager.m3981a(this.mActivity).edit().putBoolean("video_mode_reddot_show", false).apply();
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean m12368k() {
        return isVideoNeonOpen() && !isFaceBeautyOrMakeupOpen();
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x011f  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m12332a(java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.CommonVideoMode.m12332a(java.lang.String, java.lang.String):void");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m12343b(String str, String str2) {
        int currFilterIndex = getCurrFilterIndex();
        String filterType = getFilterType(currFilterIndex);
        boolean z = 60 == m12377t() && !this.mbFrontCamera;
        boolean zEquals = "oplus_video_filter_portrait_retention".equals(filterType);
        boolean zEquals2 = "oplus_video_filter_neon".equals(filterType);
        if ("video_size_4kuhd".equals(str) || "video_size_8k".equals(str) || z || ((isUltraNightVideoOpen() && !zEquals) || m12382y() || ((isAiEnhancementVideoOpen() && !zEquals && m12317M()) || is10bitsHeicEncodeEnable() || ((isVideoHdrOpen() && currFilterIndex != getFilterNoneIndex()) || ((zEquals && !"video_size_720p".equals(str)) || (zEquals2 && ("video_size_4kuhd".equals(str) || ("video_size_1080p".equals(str) && !m12325U())))))))) {
            m12362g(false);
            currFilterIndex = getFilterNoneIndex();
            updateFilterParam(getFilterNoneIndex());
            this.mPreviewEffectProcess.mo22848l(false);
            this.mPreviewEffectProcess.mo22851m(false);
        } else {
            this.mPreviewEffectProcess.mo22848l(zEquals);
            this.mPreviewEffectProcess.mo22851m(zEquals2);
        }
        this.f12854w = currFilterIndex;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m12348c(String str, String str2) {
        if (m12353d(str, str2)) {
            boolean zMo10499aA = this.mCameraInterface.mo10499aA();
            this.mCameraInterface.mo10559c(true);
            if (isVideoNeonOpen()) {
                m12362g(false);
            } else {
                m12310F();
            }
            this.mCameraInterface.mo10559c(zMo10499aA);
            boolean z = isFaceBeautyOrMakeupOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_BEAUTY_FRONT_VIDEO);
            if ("video_size_4kuhd".equals(str) || "video_size_8k".equals(str) || 60 == Integer.parseInt(str2) || (this.mHandler != null && "video_size_1080p".equals(str) && (!m12325U() || z))) {
                this.mHandler.post(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_8$RHRPrx8S3p1xoEnpyhV_gc04HgQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m12341ae();
                    }
                });
            }
        }
        this.f12856y = false;
        boolean z2 = isBlurOpen() || this.mCameraUIInterface.mo18051O();
        if (isVideoNeonOpen() && z2) {
            this.mCameraInterface.mo10559c(true);
            m12310F();
            setVideoBlurEffect(false);
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_8$7P5GG-dmuxPNxGowCyLuZrfySVY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m12340ad();
                    }
                });
            }
        } else if (this.mPreviewEffectProcess != null) {
            setVideoBlurEffect(z2);
            if (z2) {
                this.mPreviewEffectProcess.mo22808b(getBlurValue());
            }
        }
        if (isBlurOpen() || isMakeupOpen() || this.mPreferences.getInt(CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, 0) == 0 || "oplus_video_filter_neon".equals(getCurrFilterType()) || m12372o()) {
            return;
        }
        m12370m();
        if (this.mPreferences.getBoolean(CameraUIInterface.KEY_FACE_BEAUTY_CLOSE_BY_RESOLUTION, false)) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.remove(CameraUIInterface.KEY_FACE_BEAUTY_CLOSE_BY_RESOLUTION);
            if (!isVideoRecording()) {
                editorEdit.putInt(getFaceBeautyKey(), 102);
                if (this.mPreviewEffectProcess != null) {
                    this.mPreviewEffectProcess.mo22834g(102);
                    this.mPreviewEffectProcess.mo22798a(getCustomBeautyValues());
                }
            }
            editorEdit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ae */
    public /* synthetic */ void m12341ae() {
        this.mCameraUIInterface.mo18176b(true, true, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ad */
    public /* synthetic */ void m12340ad() {
        this.mCameraUIInterface.mo18198d(CameraUIInterface.KEY_VIDEO_BLUR_MENU, false);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m12353d(String str, String str2) {
        return !this.f12856y && ("video_size_4kuhd".equals(str) || "video_size_8k".equals(str) || isVideoHdrOpen() || isVideoRetentionOpen() || isUltraNightVideoOpen() || isAiEnhancementVideoOpen() || is10bitsHeicEncodeEnable() || (("video_size_1080p".equals(str) && (!m12325U() || (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_BEAUTY_FRONT_VIDEO) && isFaceBeautyOrMakeupOpen()))) || 60 == Integer.parseInt(str2)));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m12347c(String str) {
        if (("video_size_4kuhd".equals(str) || isRearSuperEISOpen() || isFaceBeautyOrMakeupOpen() || isFilterEffectOpen() || isBlurOpen()) && !this.mbFrontCamera) {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off").apply();
            m12323S();
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m12369l() {
        if (is10bitsHeicEncodeEnable()) {
            if (isCommonFaceBeautyOpen() || isFilterEffectOpen() || isBlurOpen() || isVideoNeonOpen() || is4k() || isSuperEISOpen()) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off").apply();
                m12323S();
                if (this.mCameraUIInterface != null) {
                    this.mCameraUIInterface.mo18110a(R.string.camera_10bit_hint);
                }
                this.f12841j = true;
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onMakeupTypeChanged(int OplusGLSurfaceView_13, boolean z) {
        super.onMakeupTypeChanged(OplusGLSurfaceView_13, z);
        if (OplusGLSurfaceView_13 != 0 && m12372o()) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            if (z) {
                editorEdit.remove(CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX);
            }
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU);
        }
        if (isMakeupOpen()) {
            SharedPreferences.Editor editorEdit2 = this.mPreferences.edit();
            editorEdit2.putInt(CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, 0);
            if (FilterHelper.m22591a(this.mbFrontCamera) == getCurrFilterIndex()) {
                onFilterItemChange(getFilterNoneIndex());
            }
            if ("video_size_1080p".equals(getVideoSizeType()) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MAKEUP_LOW_PERFORMANCE)) {
                editorEdit2.putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_720p");
            }
            if (z) {
                editorEdit2.remove(CameraUIInterface.KEY_FACE_BEAUTY_CLOSE_BY_RESOLUTION);
            }
            editorEdit2.apply();
            if (isBlurOpen()) {
                m12313I();
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m12370m() {
        int OplusGLSurfaceView_13 = this.mPreferences.getInt(CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, 0);
        if (OplusGLSurfaceView_13 != 0) {
            this.mPreferences.edit().remove(CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX).apply();
            if (isVideoRecording()) {
                return;
            }
            this.mCameraUIInterface.mo18274u(OplusGLSurfaceView_13);
            Util.m24416c(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_8$NypIVyXfQqtaV0d7wYKVEWO2nwc
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m12339ac();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ac */
    public /* synthetic */ void m12339ac() {
        this.mCameraInterface.mo10546av();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m12371n() {
        if (isMakeupOpen()) {
            this.mPreferences.edit().putInt(CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, getCurrMakeupIndex()).apply();
            super.onMakeupTypeChanged(0, false);
            this.mCameraUIInterface.mo18274u(0);
            this.mCameraInterface.mo10546av();
        }
    }

    /* renamed from: o */
    private boolean m12372o() {
        return isSuperEISOpen() && this.mbFrontCamera;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean isRearSuperEISOpen() {
        return isSuperEISOpen() && !this.mbFrontCamera;
    }

    /* renamed from: p */
    private void m12373p() {
        if (!isVideoHdrOpen() || checkVideoHdrPreCondition()) {
            return;
        }
        this.mCameraInterface.mo10559c(true);
        this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_HDR, "off").apply();
        this.mCameraInterface.mo10559c(false);
    }

    /* renamed from: q */
    private void m12374q() {
        if (!isUltraNightVideoOpen() || m12318N()) {
            return;
        }
        this.mCameraInterface.mo10559c(true);
        this.mPreferences.edit().putString(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off").apply();
        this.mCameraInterface.mo10559c(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void checkAiEnhancementVideoState() {
        if (isAiEnhancementVideoOpen() && !m12319O()) {
            this.mCameraInterface.mo10559c(true);
            this.mPreferences.edit().putString(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
            this.mCameraInterface.mo10559c(false);
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_8$kYjIE-HADn5ZuZiVCfq_NcldSoE
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m12338ab();
                }
            });
        }
        if (isAiEnhancementVideoOpen() && m12376s()) {
            this.f12843l = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ab */
    public /* synthetic */ void m12338ab() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12335a(boolean z, boolean z2) {
        if (this.mActivity == null || this.mPreferences == null || this.mCameraInterface == null || !m12316L() || isAiEnhancementVideoOpen() || !this.mPreferences.getBoolean(CameraUIInterface.KEY_SHOULD_REOPEN_AI_ENHANCEMENT_VIDEO, false)) {
            return;
        }
        if ((z2 && !m12319O()) || isBlurOpen() || isMakeupOpen()) {
            return;
        }
        if (isSuperEISOpen() && m12375r()) {
            return;
        }
        if (isFilterEffectOpen() && m12317M()) {
            return;
        }
        boolean zMo10499aA = this.mCameraInterface.mo10499aA();
        if (!z) {
            this.mCameraInterface.mo10559c(true);
        }
        String string = this.mPreferences.getString(CameraUIInterface.KEY_STORED_AI_ENHANCEMENT_VIDEO_SIZE, null);
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        CameraLog.m12959b("CommonVideoMode", "checkReopenAiEnhancementVideo, reopen ai enhancement video, change video size to: " + string + ", oldForceChangeRecSize: " + zMo10499aA + ", isListenPreference: " + z);
        if (string != null) {
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, string);
            editorEdit.putString(CameraUIInterface.KEY_STORED_AI_ENHANCEMENT_VIDEO_SIZE, null);
        }
        editorEdit.putString(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "on");
        editorEdit.apply();
        if (!z) {
            this.mCameraInterface.mo10559c(zMo10499aA);
        }
        if (m12363g(CameraUIInterface.KEY_CAMERA_MODE)) {
            return;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_8$yaZT1FNQDWUHmfyxxRfDU6qBnkg
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m12337aa();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aa */
    public /* synthetic */ void m12337aa() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
        }
    }

    /* renamed from: r */
    private boolean m12375r() {
        return !this.mbFrontCamera;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m12355e(String str, String str2) {
        if (this.mbFrontCamera) {
            if (!m12382y() || "video_size_1080p".equals(str)) {
                return;
            }
            this.mCameraInterface.mo10559c(true);
            this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            this.mCameraInterface.mo10559c(false);
            return;
        }
        int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_EIS_FPS);
        boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE_60_FPS);
        boolean zIsSuperEISProOpen = isSuperEISProOpen();
        boolean zIsSuperEISOpen = isSuperEISOpen();
        if (!Util.m24479m(str) || ((zIsSuperEISProOpen && configBooleanValue && Integer.parseInt(str2) != 60) || ((zIsSuperEISProOpen && !configBooleanValue && Integer.parseInt(str2) == 60) || !(zIsSuperEISProOpen || !zIsSuperEISOpen || Integer.parseInt(str2) == configIntValue)))) {
            this.mCameraInterface.mo10559c(true);
            this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false).apply();
            this.mCameraInterface.mo10559c(false);
            if (zIsSuperEISProOpen) {
                CameraLog.m12966e("CommonVideoMode", "setSuperEisBeforePreview, reopen camera");
                this.mCameraInterface.mo10467W();
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public CameraRequestTag getCaptureRequestTag(CameraApsDecision cameraApsDecision, boolean z) {
        CameraRequestTag captureRequestTag = super.getCaptureRequestTag(cameraApsDecision, z);
        captureRequestTag.f13401ac = !needSurface("type_still_capture_yuv_main") || (is4k() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FORCE_4k_VIDEO_SNAPSHOT_BY_APS));
        return captureRequestTag;
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c) {
        super.onCaptureCompleted(cameraCaptureResult, c2693c);
        if (!c2693c.f13401ac || this.mCameraInterface == null) {
            return;
        }
        this.mCameraInterface.mo10478a(cameraCaptureResult.mIdentity, Util.m24246a(System.currentTimeMillis()), false, false, false);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        CameraLog.m12962c("CommonVideoMode", "setConfigureParameter");
        if (!this.mbFrontCamera && getSupportFunction(CameraUIInterface.KEY_SUPPORT_FOVC)) {
            builder.setParameter(CameraParameter.VIDEO_FOVC_MODE, "on");
        }
        if (isUltraNightVideoOpen()) {
            builder.setParameter(CameraParameter.VIDEO_NIGHT_MODE, CameraParameter.NightVideo.ULTRA_NIGHT_VIDEO);
        }
        if (getSupportFunction(CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS)) {
            builder.setParameter(CameraParameter.VIDEO_STABILIZATION_MODE, this.mbFrontCamera ? CameraParameter.VideoStabilizationMode.SUPER_STABILIZATION_FRONT : CameraParameter.VideoStabilizationMode.SUPER_STABILIZATION);
        }
        if (isHighFps()) {
            builder.setParameter(CameraParameter.VIDEO_FPS, CameraParameter.VideoFpsValue.VIDEO_FPS_60);
        } else if (is4k120fps()) {
            builder.setParameter(CameraParameter.VIDEO_FPS, CameraParameter.VideoFpsValue.VIDEO_FPS_120);
        } else {
            builder.setParameter(CameraParameter.VIDEO_FPS, CameraParameter.VideoFpsValue.VIDEO_FPS_30);
        }
        builder.setVideoSize(new Size(this.mProfile.videoFrameWidth, this.mProfile.videoFrameHeight));
        if (isVideo10BitOpen()) {
            builder.setParameter(CameraParameter.VIDEO_10BIT_ENABLE, "on");
        }
        if (isVideoHdrOpen()) {
            builder.setParameter(CameraParameter.VIDEO_3HDR_MODE, "on");
        }
        if (getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen()) {
            builder.setParameter(CameraParameter.AI_NIGHT_VIDEO_MODE, 1);
        }
        if (getSupportFunction(CameraFunction.BLUR_NOT_SUPPORT_EXPLORER) && isBlurOpen()) {
            builder.setParameter(CameraParameter.VIDEO_BLUR, "on");
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        if (this.mPreferences == null) {
            return;
        }
        if (!Util.m24169C()) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TRACK_FOCUS_SUPPORT) && this.mOneCamera != null) {
                this.mOneCamera.mo13121o(m12345b(true) && "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_TRACK_FOCUS, this.mActivity.getString(R.string.camera_face_rectify_default_value))));
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_RETENTION_SUPPORT) && this.mOneCamera != null) {
                this.mOneCamera.mo13015D(isVideoRetentionOpen());
            }
        }
        if (getSupportFunction(CameraFunction.VIDEO_BLUR_PROCESS) && isBlurOpen() && this.mOneCamera != null) {
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.VIDEO_BLUR_ENABLE, (CameraParameter.PreviewKey<String>) "on");
        }
        if (getSupportFunction(CameraFunction.FACE_BEAUTY_PROCESS) && this.mOneCamera != null) {
            int faceBeautyCurrIndex = getFaceBeautyCurrIndex();
            this.mOneCamera.mo13099h(faceBeautyCurrIndex);
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FACE_BEAUTY_ENABLE, (CameraParameter.PreviewKey<String>) (faceBeautyCurrIndex == 0 ? "off" : "on"));
        }
        super.onBeforePreview();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void checkFunction() {
        CameraLog.m12967f("CommonVideoMode", "checkFunction");
        if (this.mCameraInterface.mo10575i()) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_SIZE, CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_VIDEO_SIZE, this.mCameraId));
            String string2 = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS);
            CameraLog.m12954a("CommonVideoMode", "checkFunction, videoSizeType: " + string + ", videoFps: " + string2);
            if (getSupportFunction(CameraFunction.VIDEO_BLUR_PROCESS)) {
                m12348c(string, string2);
            }
            if (getSupportFunction(CameraFunction.FACE_BEAUTY_PROCESS)) {
                m12332a(string, string2);
            }
            if (getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS)) {
                m12343b(string, string2);
            }
            if (getSupportFunction(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU)) {
                m12355e(string, string2);
            }
            if (getSupportFunction(CameraFunction.VIDEO_HDR)) {
                m12373p();
            }
            if (getSupportFunction(CameraFunction.ULTRA_NIGHT_VIDEO)) {
                m12374q();
            }
            if (getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen() && m12316L()) {
                CameraLog.m12954a("CommonVideoMode", "onBeforePreview, ai enhancement on video size : " + string);
                this.mPreferences.edit().putString(CameraUIInterface.KEY_AI_ENHANCEMENT_ON_VIDEO_SIZE, string).apply();
            }
            if (getSupportFunction(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE)) {
                m12347c(string);
                m12387b();
            }
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected int getVideoFrameRate() {
        if (is4k120fps()) {
            return 120;
        }
        return isHighFps() ? 60 : 30;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected Double getRealCaptureRate() {
        if (is4k120fps()) {
            return Double.valueOf(120.0d);
        }
        if (isHighFps()) {
            return Double.valueOf(60.0d);
        }
        return Double.valueOf(30.0d);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        View viewFindViewById;
        super.onAfterStartPreview(z);
        this.f12840i = false;
        m12314J();
        if (this.f12839h && !this.mCameraUIInterface.mo18043K()) {
            this.mCameraUIInterface.mo18275u(true);
        }
        if (isOpenFrontTorch() && isBlurOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SCREEN_BRIGHTNESS_VIDEO)) {
            m12313I();
        }
        BaseScreenMode currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode == null || !currentScreenMode.mo16631r()) {
            if (showBeautyButton()) {
                this.mCameraUIInterface.mo18240l(true, false);
            } else {
                this.mCameraUIInterface.mo18236k(true, false);
            }
            if (showMenuLeftButton()) {
                this.mCameraUIInterface.mo18228i(true, false);
            } else {
                this.mCameraUIInterface.mo18223h(true, false);
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_SUPER_EIS_WIDE_TIPS) && !this.mbFrontCamera && isSuperEISOpen() && getSupportFunction(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE) && getSupportFunction(CameraUIInterface.KEY_SUPPORT_SUPER_EIS_WIDE_MENU) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_SUPER_EIS_WIDE_OPEN_DEFAULT)) {
                CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
                if (!isBubbleOpen(CameraUIInterface.KEY_SUPER_EIS_WIDE_TIPS) || (viewFindViewById = this.mActivity.findViewById(R.id_renamed.zoom_seek_anchor_view)) == null) {
                    return;
                }
                this.mCameraUIInterface.mo18086a(viewFindViewById, 19, getBubbleOffsetX(19), getBubbleOffsetY(19));
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        if (1 == OplusGLSurfaceView_13 || 2 == OplusGLSurfaceView_13) {
            return;
        }
        showNextTip();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void showNextTip() {
        super.showNextTip();
        if (this.mCameraUIInterface == null || this.mCameraUIInterface.mo18057R() || this.mCameraUIInterface.mo18058S()) {
            return;
        }
        if (this.mPreferences != null && !this.mPreferences.getBoolean(CameraUIInterface.KEY_PERMISSION_DIALOG_DISPLAYED, false)) {
            CameraLog.m12967f("CommonVideoMode", "showNextTip, return");
        } else if (getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO) && isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
            this.mCameraUIInterface.mo18086a((View) null, 7, getBubbleOffsetX(7), getBubbleOffsetY(7));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getBubbleOffsetX(int OplusGLSurfaceView_13) {
        int[] iArrMo10498a;
        if (7 == OplusGLSurfaceView_13 && 1 == this.mCameraInterface.mo10519aU().mo16539j() && (iArrMo10498a = this.mCameraInterface.mo10498a(this.mActivity, 7)) != null) {
            return iArrMo10498a[0];
        }
        if (19 == OplusGLSurfaceView_13) {
            return this.mActivity.getResources().getDimensionPixelOffset(R.dimen.bubble_super_eis_wide_tip_tip_offset_x);
        }
        return 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getBubbleOffsetY(int OplusGLSurfaceView_13) {
        int[] iArrMo10498a;
        if (7 == OplusGLSurfaceView_13 && 1 == this.mCameraInterface.mo10519aU().mo16539j() && (iArrMo10498a = this.mCameraInterface.mo10498a(this.mActivity, 7)) != null) {
            return iArrMo10498a[1];
        }
        if (19 == OplusGLSurfaceView_13) {
            return this.mActivity.getResources().getDimensionPixelOffset(R.dimen.bubble_super_eis_wide_tip_tip_offset_y);
        }
        return this.mActivity.getResources().getDimensionPixelOffset(R.dimen.setting_menu_tip_offset_y);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateInversePositionRatio(boolean z) {
        InverseManager.INS.setPositionRatio(this.mActivity, 0.87f, z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected float getHighBrightnessValue() {
        return InverseManager.INS.getVideoBrightness();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOpenFaceBeautyMenu(boolean z) {
        this.f12839h = z;
    }

    /* renamed from: s */
    private boolean m12376s() {
        return getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO) && (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_AI_VIDEO_SCENE) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_ENHANCEMENT_FRONT_VIDEO) || 1 != this.mCameraId);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private synchronized void m12331a(CaptureResult captureResult) {
        Integer numValueOf = -1;
        if (Util.m24169C()) {
            float[] fArr = (float[]) captureResult.get(CameraMetadataKey.f13256V);
            float[] fArr2 = (float[]) captureResult.get(CameraMetadataKey.f13335bp);
            if (fArr != null && fArr.length > 0 && fArr2 != null && fArr2.length > 0) {
                numValueOf = isAiEnhancementVideoOpen() ? Integer.valueOf(this.f12853v.m24514a(fArr[0], fArr2[0])) : Integer.valueOf(this.f12853v.m24515b(fArr[0], fArr2[0]));
            }
        } else {
            this.f12844m++;
            if (30 != this.f12844m) {
                return;
            }
            this.f12844m = 0;
            try {
                numValueOf = (Integer) captureResult.get(CameraMetadataKey.f13301an);
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                return;
            }
        }
        if (numValueOf == null) {
            return;
        }
        if (isAiEnhancementVideoOpen()) {
            m12342b(numValueOf.intValue());
        } else if (!isSuperEISOpen() && !isBlurOpen() && !isVideoFlashTorchOpen() && !isFilterEffectOpen() && !m12322R()) {
            m12346c(numValueOf.intValue());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m12342b(int OplusGLSurfaceView_13) {
        boolean zIsVideoRecording = isVideoRecording();
        boolean z = !this.f12846o && zIsVideoRecording;
        this.f12846o = zIsVideoRecording;
        if (z) {
            this.mAiEnhanceSceneChangeCount = 0;
            this.mAiEnhanceSceneStart = OplusGLSurfaceView_13;
        }
        if (this.f12846o) {
            this.mAiEnhanceSceneEnd = OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 == this.f12843l && this.mCameraUIInterface.mo18131aU()) {
            return;
        }
        if (!z) {
            this.mAiEnhanceSceneChangeCount++;
        }
        this.f12843l = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 == 1) {
            this.mCameraInterface.mo10565e(26);
        } else if (OplusGLSurfaceView_13 == 2) {
            this.mCameraInterface.mo10565e(12);
        } else {
            this.mCameraInterface.mo10565e(0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m12346c(int OplusGLSurfaceView_13) {
        if (-1 == OplusGLSurfaceView_13) {
            return;
        }
        boolean zMo18064Y = false;
        int i2 = this.mPreferences.getInt(CameraUIInterface.KEY_AI_ENHANCEMENT_GUIDE_REMINDER_TIMES, 0);
        if (OplusGLSurfaceView_13 == 1) {
            zMo18064Y = this.mCameraUIInterface.mo18064Y();
        } else if (OplusGLSurfaceView_13 == 2) {
            zMo18064Y = this.mCameraUIInterface.mo18063X();
        }
        if (i2 >= 3 || !zMo18064Y) {
            return;
        }
        this.mPreferences.edit().putInt(CameraUIInterface.KEY_AI_ENHANCEMENT_GUIDE_REMINDER_TIMES, i2 + 1).apply();
        if (this.f12845n == null) {
            this.f12845n = this.mCameraUIInterface.mo18220h(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_8$rCkeR65Z_BZgQ08SL0xwqstoGeY
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m12330Z();
            }
        }, 170L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public /* synthetic */ void m12330Z() {
        this.f12845n.mo21187y();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onReceivePreviewCaptureResult(CaptureResult captureResult) {
        super.onReceivePreviewCaptureResult(captureResult);
        boolean z = 10 < captureResult.getFrameNumber();
        if (!m12327W() && z && m12376s()) {
            m12331a(captureResult);
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            CameraLog.m12967f("CommonVideoMode", "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        boolean z = 10 < cameraPreviewResult.getCaptureResult().getFrameNumber();
        if (z && m12376s()) {
            m12331a(cameraPreviewResult.getCaptureResult());
        }
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (z && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_EIS_PRO_LOW_LIGHT_HINT) && isVideoSuperEisWideOpen() && 1 == this.mFlashTrigger) {
            this.mCameraUIInterface.mo18273u();
        }
        int[] iArr = (int[]) CameraMetadataKey.m13005a(cameraPreviewResult.getCaptureResult(), CameraMetadataKey.f13305ar);
        if (iArr != null && this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22814b(iArr);
        }
        int[] iArr2 = (int[]) CameraMetadataKey.m13005a(cameraPreviewResult.getCaptureResult(), CameraMetadataKey.f13306as);
        if (iArr2 != null && this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22821c(iArr2);
        }
        if (isBlurOpen() || isVideoNeonOpen() || "oplus_video_filter_portrait_retention".equals(this.f12855x)) {
            processFaceCount();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return this.mCameraInterface != null && this.mCameraInterface.mo10575i() && (isFilterEffectOpen() || isFaceBeautyOrMakeupOpen() || isBlurOpen() || isVideoRetentionOpen() || isVideoNeonOpen() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_DEFAULT_VIDEO_FRAME_RECORD) || (isNoneSatUltraWideAngleOpen() && (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WIDE_ONLY_MEDIACODEC_SUPPORT) || (AlgoSwitchConfig.getSupportApsPreview() && AlgoSwitchConfig.getSupportPreviewAlgo(getCameraMode(), this.mCameraId, "preview", "preview_rectify")))));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaRecorderNotUseAPS() {
        String cameraFeature = getCameraFeature();
        if (cameraFeature == null) {
            cameraFeature = getCameraMode();
        }
        String str = cameraFeature;
        if (getSupportFunction(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION)) {
            if (isSloganOpen()) {
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT)) {
                    return !isUseMediaCodec();
                }
                return !needApsToProcessVideoWatermark();
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_APS_SUPPORT_VIDEO_SUPER_EIS)) {
                return (isRearSuperEISOpen() || isVideoSuperEisWideOpen()) ? false : true;
            }
            return true;
        }
        AlgoSwitchConfig.PreviewConfig previewConfig = AlgoSwitchConfig.getPreviewConfig(str, this.mCameraId, null, null, needApsToProcessVideoWatermark(), ApsConstant.FEATURE_REC_SAT_HAL.equals(str) || ApsConstant.FEATURE_REC_4KUHD.equals(str) || ApsConstant.FEATURE_REC_LIVE_HDR.equals(str) || ApsConstant.FEATURE_REC_ULTRA_NIGHT.equals(str) || (ApsConstant.REC_MODE_COMMON.equals(str) && 1 == this.mCameraId) || (ApsConstant.REC_MODE_FAST_VIDEO.equals(str) && 1 == this.mCameraId), ApsConstant.REC_MODE_SLOW_VIDEO.equals(str) && this.mCameraId == 0);
        AlgoSwitchConfig.PreviewConfig.Component component = previewConfig != null ? previewConfig.mComponentMap.get("video") : null;
        return previewConfig == null || component == null || !component.mbEnable;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11358o((isUltraNightVideoOpen() || isAiEnhancementVideoOpen()) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE));
        zoomConfigure.m11307F(getSupportFunction(CameraUIInterface.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT));
        boolean z = zoomConfigure.m11343g() && !isSuperEISOpen();
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_ULTAR_WIDE_VIDEO_4K_OR_60FPS) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_ANGLE_SUPPORT)) {
            z &= (!this.mCameraInterface.mo10575i() || isHighFps() || "video_size_4kuhd".equals(getVideoSizeType())) ? false : true;
        }
        zoomConfigure.m11340f(z);
        zoomConfigure.m11310H(getSupportFunction(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE));
        if ("video_size_1080p".equals(getVideoSizeType()) && 30 == getVideoFps()) {
            zoomConfigure.m11329b(CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_SECOND_ZOOM_POINT_SPECIFIC_VALUE));
        }
        zoomConfigure.m11312I("video_size_8k".equals(getVideoSizeType()));
        zoomConfigure.m11304E(isSuperEISOpen());
        zoomConfigure.m11302D(isBlurOpen());
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needUploadOplusStatistics(String str) {
        if (CameraUIInterface.KEY_FACE_DETECTION.equals(str) && isVideoRecording()) {
            return false;
        }
        return super.needUploadOplusStatistics(str);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return getSupportFunction(CameraFunction.ULTRA_NIGHT_VIDEO) || getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO) || getSupportSubMenu(CameraUIInterface.KEY_VIDEO_SIZE) || getSupportSubMenu(CameraUIInterface.KEY_VIDEO_FPS) || getSupportFunction(CameraUIInterface.KEY_TORCH_MODE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowFaceBeautyMenu() {
        if (this.mPreferences == null) {
            return false;
        }
        return this.mbFrontCamera || ("off".equals(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off")) && "off".equals(this.mPreferences.getString(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off")) && "off".equals(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_HDR, "off")));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:149:0x023d  */
    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 2220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.CommonVideoMode.getSupportFunction(java.lang.String):boolean");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m12345b(boolean z) {
        return (this.mbFrontCamera || isBlurOpen() || isVideoNeonOpen() || isVideoRetentionOpen() || isSuperEISOpen() || this.mCameraInterface == null || (!z && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TRACK_FOCUS_ULTRA_WIDE_SUPPORT) && Float.compare(this.mCameraInterface.mo10535ak(), 1.0f) < 0) || ((!z && Float.compare(this.mCameraInterface.mo10535ak(), 1.1f) >= 0) || !this.mCameraInterface.mo10575i() || ((!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_4K_TRACK_FOCUS_SUPPORT) && is4k()) || ((!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_AI_ENHANCEMENT_TRACK_FOCUS_SUPPORT) && isAiEnhancementVideoOpen()) || ((!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_60FPS_TRACK_FOCUS_SUPPORT) && 60 == m12377t()) || 120 == m12377t() || m12390e() || isUltraNightVideoOpen() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TRACK_FOCUS_SUPPORT)))))) ? false : true;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        String strM13305d = CameraEntry.m13305d(str);
        if (CameraUIInterface.KEY_SETTING.equals(strM13305d)) {
            return true;
        }
        if (m12322R() && getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO)) {
            if (CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(strM13305d)) {
                return false;
            }
            if (CameraUIInterface.KEY_DISABLE_AI_ENHANCEMENT_VIDEO.equals(strM13305d)) {
                return true;
            }
        }
        if (CameraUIInterface.KEY_SUB_SETTING.equals(strM13305d)) {
            return getSupportFunction(CameraUIInterface.KEY_SUB_SETTING);
        }
        if (!CameraUIInterface.KEY_VIDEO_SIZE.equals(strM13305d) || this.mCameraInterface == null || this.mCameraInterface.mo10583m()) {
            return super.getSupportMenu(strM13305d);
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        if (CameraUIInterface.KEY_VIDEO_SIZE.equals(str)) {
            return true;
        }
        if (CameraUIInterface.KEY_VIDEO_FPS.equals(str)) {
            if (this.mbFrontCamera) {
                return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_1080_60_FPS);
            }
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_720_60_FPS) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_1080_60_FPS) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60_FPS) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_120_FPS);
        }
        return super.getSupportSubMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setVideoBlurOpen(boolean z) {
        CameraLog.m12954a("CommonVideoMode", "setVideoBlurOpen, open: " + z);
        this.f12838g = z;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getVideoOrientation(int OplusGLSurfaceView_13) {
        if (this.mbFrontCamera) {
            if (OplusGLSurfaceView_13 != 0) {
                if (OplusGLSurfaceView_13 != 90) {
                    if (OplusGLSurfaceView_13 != 180) {
                        return 0;
                    }
                    return 270;
                }
                return 180;
            }
            return 90;
        }
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 != 90) {
                if (OplusGLSurfaceView_13 != 180) {
                    return 0;
                }
                return 90;
            }
            return 180;
        }
        return 270;
    }

    /* renamed from: t */
    private int m12377t() {
        SharedPreferences sharedPreferences = this.mPreferences;
        String string = VideoMode.VIDEO_DEFAULT_FPS;
        if (sharedPreferences != null) {
            string = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS);
        }
        return Integer.valueOf(string).intValue();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public int getVideoFps() {
        if (getSupportFunction(CameraUIInterface.KEY_VIDEO_HIGH_FPS)) {
            return m12377t();
        }
        return Integer.valueOf(VideoMode.VIDEO_DEFAULT_FPS).intValue();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m12351d(int OplusGLSurfaceView_13) {
        if (this.mPreviewEffectProcess == null || OplusGLSurfaceView_13 == this.f12854w) {
            return;
        }
        String filterType = getFilterType(OplusGLSurfaceView_13);
        String filterRedpotKey = getFilterRedpotKey(filterType);
        if (TextUtils.isEmpty(filterType)) {
            this.mCameraUIInterface.mo18067a(R.string.hint_function_not_support_1080_60);
        }
        if (filterRedpotKey != null) {
            this.mCameraUIInterface.mo18238l(OplusGLSurfaceView_13);
            PreferenceManager.m3981a(this.mActivity).edit().putBoolean(filterRedpotKey, false).apply();
        }
        if ((this.f12854w != getFilterNoneIndex()) != (OplusGLSurfaceView_13 != getFilterNoneIndex())) {
            m12361g();
        }
        String filterType2 = getFilterType(this.f12854w);
        this.f12854w = OplusGLSurfaceView_13;
        this.f12847p = "oplus_video_filter_portrait_retention".equals(filterType) || "oplus_video_filter_portrait_retention".equals(filterType2);
        this.f12848q = "oplus_video_filter_neon".equals(filterType) || "oplus_video_filter_neon".equals(filterType2);
        if (this.f12848q && this.mCameraInterface != null && !isBlurOpen()) {
            this.mCameraInterface.mo10513aO();
        }
        if (this.f12847p || this.f12848q) {
            if ((this.f12847p || ((getSupportFunction(CameraFunction.SAT_CAMERA) && !isBlurOpen()) || (this.f12848q && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_1080P)))) && this.mCameraInterface != null) {
                this.mCameraInterface.mo10546av();
            } else {
                updateTrackEnable();
            }
            this.mCameraUIInterface.mo18067a(R.string.hint_function_not_support_1080_60);
            if ("oplus_video_filter_portrait_retention".equals(filterType)) {
                this.mCameraUIInterface.mo18067a(R.string.camera_one_subject_hint);
                m12352d(this.f12848q);
            } else if ("oplus_video_filter_neon".equals(filterType)) {
                updateVideoBlurEnable(false, false);
                updateVideoNeonEnable(true, true);
                m12356e(this.f12847p);
            } else {
                updateVideoNeonEnable(true, false);
                m12349c(this.f12847p);
            }
        }
        this.f12855x = filterType;
        this.mPreviewEffectProcess.mo22848l("oplus_video_filter_portrait_retention".equals(filterType));
        this.mPreviewEffectProcess.mo22851m("oplus_video_filter_neon".equals(filterType));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(String str) {
        if (CameraUIInterface.KEY_DRAWER_ANCHOR_TIPS.equals(str)) {
            return isBubbleOpen(CameraUIInterface.KEY_DRAWER_ANCHOR_TIPS);
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isVideoRetentionOpen() {
        return isFilterEffectOpen() && "oplus_video_filter_portrait_retention".equals(getCurrFilterType());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isVideoNeonOpen() {
        return isFilterEffectOpen() && "oplus_video_filter_neon".equals(getCurrFilterType());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isBlurOpen() {
        return getSupportFunction(CameraFunction.VIDEO_BLUR_PROCESS) && this.mPreferences.getBoolean(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isShowUltraWide() {
        if (isAiEnhancementVideoOpen() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_ZOOM_SUPPORT)) {
            return false;
        }
        if (isBlurOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_ULTRA_WIDE)) {
            return true;
        }
        if (isVideoNeonOpen()) {
            return false;
        }
        return !isBlurOpen() || m12390e();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFilterItemChange(int OplusGLSurfaceView_13) {
        super.onFilterItemChange(OplusGLSurfaceView_13, m12385a(OplusGLSurfaceView_13));
        m12351d(OplusGLSurfaceView_13);
        boolean z = true;
        if (FilterHelper.f21279a != getCurrFilterIndex()) {
            if (isVideoHdrOpen()) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_HDR, "off").apply();
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_HDR);
            }
            if (isRearSuperEISOpen() || m12382y()) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            }
            if (isUltraNightVideoOpen()) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off").apply();
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO);
            }
            if (isAiEnhancementVideoOpen() && m12317M()) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
            }
            if (getSupportFunction(CameraFunction.FACE_BEAUTY_CUSTOM) && isSuperEISOpen() && this.mbFrontCamera && isBlurOpen() && isFaceBeautyOrMakeupOpen()) {
                m12310F();
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_BLUR_MENU);
                this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            }
            String videoSizeType = getVideoSizeType();
            String string = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS);
            boolean z2 = (Integer.parseInt(string) == 60 || Integer.parseInt(string) == 120) && !this.mbFrontCamera;
            CameraLog.m12954a("CommonVideoMode", "onFilterItemChange, index: " + OplusGLSurfaceView_13 + ", videoSizeType: " + videoSizeType + ", isHighFps: " + z2);
            boolean zEquals = "video_size_4kuhd".equals(videoSizeType);
            if ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE) && zEquals && z2) || m12386a(videoSizeType)) {
                this.mCameraInterface.mo10559c(true);
                this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                this.mCameraInterface.mo10559c(false);
            }
            if (z2 && getCurrFilterIndex() != FilterHelper.f21279a) {
                if (!zEquals && !m12390e()) {
                    z = false;
                }
                m12360f(z);
                m12308D();
            }
            boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_30FPS_Filter);
            if (this.mCameraInterface.mo10575i()) {
                if (!((zEquals && !configBooleanValue) || z2 || m12390e()) || getCurrFilterIndex() == FilterHelper.f21279a) {
                    return;
                }
                if (zEquals || m12390e()) {
                    this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p").apply();
                }
                m12311G();
                return;
            }
            return;
        }
        m12378u();
        m12335a(!this.mCameraInterface.mo10449E(), m12381x());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m12385a(int OplusGLSurfaceView_13) {
        boolean z = Integer.parseInt(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS)) == 60 && !this.mbFrontCamera;
        String videoSizeType = getVideoSizeType();
        String filterType = getFilterType(OplusGLSurfaceView_13);
        String filterType2 = getFilterType(this.f12854w);
        return (("oplus_video_filter_portrait_retention".equals(filterType) || "oplus_video_filter_portrait_retention".equals(filterType2)) || ((("oplus_video_filter_neon".equals(filterType) || "oplus_video_filter_neon".equals(filterType2)) && getSupportFunction(CameraFunction.SAT_CAMERA) && !isBlurOpen()) || (OplusGLSurfaceView_13 != FilterHelper.f21279a && (z || (this.mCameraInterface.mo10575i() && "video_size_4kuhd".equals(videoSizeType)))))) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_30FPS_Filter);
    }

    /* renamed from: u */
    private void m12378u() {
        if (!getSupportFunction(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE) || !this.f12841j || isFilterEffectOpen() || isBlurOpen() || isVideoNeonOpen() || m12379v() || is4k() || isRearSuperEISOpen()) {
            return;
        }
        if (this.mCameraInterface.mo10449E()) {
            this.mCameraInterface.mo10559c(true);
        }
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "on");
        editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC, "HEIF");
        editorEdit.putString(CameraUIInterface.KEY_VIDEO_CODEC, CameraParameter.VideoEncoder.H265);
        editorEdit.apply();
        this.mCameraUIInterface.mo18166b(R.string.camera_10bit_hint, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
        if (this.mCameraInterface.mo10449E()) {
            this.mCameraInterface.mo10559c(false);
        }
        CameraLog.m12954a("CommonVideoMode", "checkAndRestore10bit");
    }

    /* renamed from: v */
    private boolean m12379v() {
        return this.mCameraUIInterface.mo18043K() || isFaceBeautyOrMakeupOpen();
    }

    /* renamed from: w */
    private void m12380w() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) && this.f12842k && (m12307C() || ((getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_SAT_SUPPORT)) || m12390e()))) {
            this.mCameraInterface.mo10559c(true);
            this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on").apply();
            this.mCameraInterface.mo10559c(false);
        }
        this.f12842k = false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m12349c(boolean z) {
        boolean z2 = this.mPreferences.getBoolean(CameraUIInterface.KEY_OLD_VIDEO_STATUS_FOR_SPECIAL, false);
        if ((!m12366i() || z) && z2) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_OLD_VIDEO_SIZE, getDefaultVideoSize());
            String string2 = this.mPreferences.getString(CameraUIInterface.KEY_OLD_VIDEO_FPS, String.valueOf(getVideoFps()));
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putBoolean(CameraUIInterface.KEY_OLD_VIDEO_STATUS_FOR_SPECIAL, false);
            if (!"".equals(string2)) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_FPS, string2);
            }
            if (!"".equals(string)) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, string);
            }
            editorEdit.putString(CameraUIInterface.KEY_OLD_VIDEO_FPS, "");
            editorEdit.putString(CameraUIInterface.KEY_OLD_VIDEO_SIZE, "");
            editorEdit.apply();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m12352d(boolean z) {
        String videoSizeType = getVideoSizeType();
        String string = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS);
        boolean zIsBlurOpen = isBlurOpen();
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        if (!"video_size_720p".equals(videoSizeType) || Integer.parseInt(string) != 30) {
            if (!z && !zIsBlurOpen && !m12382y() && !isSuperEISOpen()) {
                editorEdit.putBoolean(CameraUIInterface.KEY_OLD_VIDEO_STATUS_FOR_SPECIAL, true);
                editorEdit.putString(CameraUIInterface.KEY_OLD_VIDEO_FPS, string);
                editorEdit.putString(CameraUIInterface.KEY_OLD_VIDEO_SIZE, videoSizeType);
            }
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_720p");
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(30));
            editorEdit.apply();
            m12311G();
        } else if (!z) {
            editorEdit.putBoolean(CameraUIInterface.KEY_OLD_VIDEO_STATUS_FOR_SPECIAL, false);
            editorEdit.putString(CameraUIInterface.KEY_OLD_VIDEO_FPS, "");
            editorEdit.putString(CameraUIInterface.KEY_OLD_VIDEO_SIZE, "");
            editorEdit.apply();
        }
        if (isNoneSatUltraWideAngleOpen()) {
            this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
        }
        if (zIsBlurOpen) {
            this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, false).apply();
        }
        this.mCameraUIInterface.mo18200d(true, false);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m12356e(boolean z) {
        String videoSizeType = getVideoSizeType();
        String string = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS);
        boolean zIsBlurOpen = isBlurOpen();
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        String str = "video_size_720p";
        if (Integer.parseInt(string) != 30 || "video_size_4kuhd".equals(videoSizeType) || ("video_size_1080p".equals(videoSizeType) && !m12325U())) {
            if (!z && !zIsBlurOpen && !isSuperEISOpen()) {
                editorEdit.putBoolean(CameraUIInterface.KEY_OLD_VIDEO_STATUS_FOR_SPECIAL, true);
                editorEdit.putString(CameraUIInterface.KEY_OLD_VIDEO_FPS, string);
                editorEdit.putString(CameraUIInterface.KEY_OLD_VIDEO_SIZE, videoSizeType);
            }
            if (!"video_size_720p".equals(videoSizeType) && m12325U()) {
                str = "video_size_1080p";
            }
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, str);
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(30));
            editorEdit.apply();
            m12311G();
        } else if (!z) {
            editorEdit.putBoolean(CameraUIInterface.KEY_OLD_VIDEO_STATUS_FOR_SPECIAL, false);
            editorEdit.putString(CameraUIInterface.KEY_OLD_VIDEO_FPS, "");
            editorEdit.putString(CameraUIInterface.KEY_OLD_VIDEO_SIZE, "");
            editorEdit.apply();
        } else if (m12325U() && !"video_size_720p".equals(this.mPreferences.getString(CameraUIInterface.KEY_OLD_VIDEO_SIZE, getDefaultVideoSize()))) {
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p");
            editorEdit.apply();
        }
        if (zIsBlurOpen) {
            this.mCameraInterface.mo10559c(true);
            m12310F();
            this.mCameraInterface.mo10559c(false);
            setVideoBlurEffect(false);
            this.mCameraUIInterface.mo18198d(CameraUIInterface.KEY_VIDEO_BLUR_MENU, false);
        }
        m12371n();
        this.mbFlashTemporaryDisabled = false;
        m12333a(getSupportFunction(CameraFunction.SAT_CAMERA));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSuperEISChange() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int OplusGLSurfaceView_13;
        String string;
        boolean z5;
        boolean zIsSuperEISOpen = isSuperEISOpen();
        boolean z6 = this.mbFrontCamera;
        boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE);
        String videoSizeType = getVideoSizeType();
        String string2 = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS);
        int configIntValue = m12382y() ? 30 : CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_EIS_FPS);
        CameraLog.m12954a("CommonVideoMode", "onSuperEISChange, isOpen: " + zIsSuperEISOpen + ", videoSizeType: " + videoSizeType + ", isHighFps: " + (Integer.valueOf(string2).intValue() == 60 && !this.mbFrontCamera) + ", videoEisFps: " + configIntValue);
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        this.mCameraInterface.mo10559c(true);
        if (!zIsSuperEISOpen && !this.f12839h && !isBlurOpen() && !isVideoRetentionOpen()) {
            this.mCameraUIInterface.mo18067a(R.string.hint_function_not_support_1080_60);
        }
        if (!zIsSuperEISOpen) {
            z = zIsSuperEISOpen;
            z2 = z6;
            z3 = false;
        } else if (z6 && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FRONT_SUPER_EIS_AND_AI_VIDEO_ENHANCE_COEXIST) && getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen()) {
            editorEdit.putString(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
            z = zIsSuperEISOpen;
            z2 = z6;
            z3 = false;
        } else if (z6) {
            z = zIsSuperEISOpen;
            z2 = z6;
            if (configBooleanValue) {
                if (isBlurOpen()) {
                    m12310F();
                }
                if (isFaceBeautyOrMakeupOpen()) {
                    editorEdit.putInt(getFaceBeautyKey(), 0);
                }
                if (isFilterEffectOpen()) {
                    m12309E();
                }
                if (!"video_size_1080p".equals(videoSizeType)) {
                    editorEdit.putString(CameraUIInterface.KEY_LASTED_VIDEO_SIZE, videoSizeType);
                    editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p");
                }
                editorEdit.apply();
            } else if (getSupportFunction(CameraFunction.FACE_BEAUTY_CUSTOM) && isBlurOpen() && isFilterEffectOpen() && isFaceBeautyOrMakeupOpen()) {
                m12310F();
                this.mCameraUIInterface.mo18067a(R.string.camera_one_subject_hint);
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_BLUR_MENU);
                this.mCameraUIInterface.mo18176b(true, false, true, false);
                m12309E();
            } else if (z2 && 30 != Integer.valueOf(string2).intValue()) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(30)).apply();
                z3 = true;
            }
            z3 = false;
        } else {
            if (getSupportFunction(CameraFunction.VIDEO_HDR) && isVideoHdrOpen()) {
                z = zIsSuperEISOpen;
                this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_HDR, "off").apply();
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_HDR);
            } else {
                z = zIsSuperEISOpen;
            }
            if (isBlurOpen()) {
                m12310F();
                z2 = z6;
                this.mCameraUIInterface.mo18176b(true, true, true, false);
                this.mCameraUIInterface.mo18240l(true, true);
            } else {
                z2 = z6;
            }
            if (getSupportFunction(CameraFunction.ULTRA_NIGHT_VIDEO) && isUltraNightVideoOpen()) {
                editorEdit.putString(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off").apply();
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO);
            }
            if (getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen()) {
                editorEdit.putString(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
            }
            if (isFilterEffectOpen()) {
                m12309E();
            }
            if (Util.m24479m(videoSizeType)) {
                z5 = false;
            } else {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p");
                z5 = true;
            }
            if (Integer.valueOf(string2).intValue() != configIntValue) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(configIntValue));
                z3 = true;
            } else {
                z3 = z5;
            }
            if (getSupportFunction(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
                editorEdit.putBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_SUPER_EIS_WIDE_OPEN_DEFAULT));
            }
            editorEdit.apply();
        }
        if (configBooleanValue && z2 && !z && (string = this.mPreferences.getString(CameraUIInterface.KEY_LASTED_VIDEO_SIZE, null)) != null && !string.isEmpty() && !string.equals(videoSizeType)) {
            editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, string).apply();
        }
        this.mCameraInterface.mo10559c(false);
        if (z) {
            this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_FIRST_CHANGE_EIS, false).apply();
            if (!z2) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
                if (this.mCameraUIInterface.mo18023A() && MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                    this.mCameraUIInterface.mo18267s(true);
                    this.mCameraInterface.mo10492a(true, false);
                    this.mCameraInterface.mo10563d(true);
                } else {
                    this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_VIDEO_FILTER_MENU);
                }
                if (this.mCameraUIInterface.mo18043K()) {
                    OplusGLSurfaceView_13 = 0;
                    this.mCameraUIInterface.mo18109a(true, true, true, false);
                } else {
                    OplusGLSurfaceView_13 = 0;
                }
                if (getSupportFunction(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU)) {
                    this.mCameraUIInterface.mo18046M();
                }
                this.mCameraUIInterface.mo18230j(OplusGLSurfaceView_13);
                String string3 = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off");
                if (isVideoSuperEisWideOpen() && !"off".equals(string3) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                    this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off").apply();
                }
            } else if (configBooleanValue) {
                this.mCameraUIInterface.mo18046M();
                this.mCameraUIInterface.mo18230j(0);
                if (this.mCameraUIInterface.mo18051O()) {
                    z4 = true;
                    this.mCameraUIInterface.mo18176b(true, false, true, false);
                } else {
                    z4 = true;
                }
                if (this.mCameraUIInterface.mo18043K()) {
                    this.mCameraUIInterface.mo18109a(z4, z4, z4, false);
                }
                if (this.mCameraUIInterface.mo18023A() && MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                    this.mCameraUIInterface.mo18267s(z4);
                }
            }
        } else {
            this.mCameraUIInterface.mo18048N();
            if (!this.mPreferences.getBoolean(CameraUIInterface.KEY_FIRST_CHANGE_EIS, true) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
                this.mCameraInterface.mo10538an();
            }
            this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_FIRST_CHANGE_EIS, false).apply();
        }
        if (z3) {
            m12311G();
        }
        if (!getSupportFunction(CameraFunction.SAT_CAMERA)) {
            this.mCameraUIInterface.mo18258q();
        }
        if (z || !m12363g(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU)) {
            return;
        }
        m12335a(false, m12381x());
    }

    /* renamed from: x */
    private boolean m12381x() {
        return this.mPreferences != null && this.mPreferences.getBoolean(CameraUIInterface.KEY_AI_ENHANCEMENT_CLOSED_BY_VIDEO_SIZE_FPS, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoSuperEisWideOpen() {
        return getSupportFunction(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE) && this.mPreferences != null && this.mPreferences.getBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false);
    }

    /* renamed from: y */
    private boolean m12382y() {
        return Boolean.valueOf(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE)).booleanValue() && this.mbFrontCamera && isSuperEISOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Range<Integer> getVideoFpsRange() {
        int[] iArrM13265b;
        if (!getSupportFunction(CameraUIInterface.KEY_VIDEO_HIGH_FPS) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_DYNAMIC_FPS_RANGE)) {
            return null;
        }
        if (is4k120fps()) {
            return this.f12849r;
        }
        if (isHighFps()) {
            if (isRearSuperEISOpen() && (iArrM13265b = this.mOneCamera.mo13086e().m13265b((CameraCharacteristics.Key<?>) CameraMetadataKey.f13369z)) != null && iArrM13265b.length >= 2) {
                return Range.create(Integer.valueOf(iArrM13265b[0]), Integer.valueOf(iArrM13265b[1]));
            }
            return this.f12850s;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_DYNAMIC_FPS_RANGE) && (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FIXED_FPS_IN_4K) || !is4k())) {
            return this.f12852u;
        }
        return this.f12851t;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getFrontDefaultCommonBeautyValue() {
        int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_FRONT_FACE_BEAUTY_LEVEL);
        return configIntValue >= 0 ? configIntValue : super.getFrontDefaultCommonBeautyValue();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String[] getMakeupKeys() {
        return getCurrentKeys(FaceBeautyHelp.f21230e);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getMakeupTypeKey() {
        return CameraEntry.m13302b(this.mCameraEntryType) ? CameraEntry.m13299b(CameraUIInterface.KEY_COMMON_VIDEO_MAKEUP_TYPE, this.mCameraEntryType) : CameraUIInterface.KEY_COMMON_VIDEO_MAKEUP_TYPE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFaceBeautyItemChange(int OplusGLSurfaceView_13) {
        int faceBeautyCurrIndex;
        if (this.mbPaused || (faceBeautyCurrIndex = getFaceBeautyCurrIndex()) == OplusGLSurfaceView_13 || this.mCameraInterface.mo10570g() != 1 || isVideoRecording()) {
            return;
        }
        if (faceBeautyCurrIndex != 0) {
            this.mPreferences.edit().remove(CameraUIInterface.KEY_FACE_BEAUTY_CLOSE_BY_RESOLUTION).apply();
        }
        super.onFaceBeautyItemChange(OplusGLSurfaceView_13);
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x01de  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onFaceBeautyMenuClick() {
        /*
            Method dump skipped, instructions count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.CommonVideoMode.onFaceBeautyMenuClick():boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFaceBeautyMenuClose() {
        m12378u();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        return isVideoRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getTrackHalAlgoSize() {
        return getSurfaceSize("type_video_frame", this.mOneCamera.mo13086e());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateFilterParam(int OplusGLSurfaceView_13) {
        if (isVividEffectOpen() && OplusGLSurfaceView_13 != FilterHelper.f21279a) {
            forceCloseVividEffect();
        }
        m12365h(getFilterType(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        return isVideoRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean exclusiveInverse() {
        return isBlurOpen();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        beforeStartRecording(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording(boolean z) {
        MainShutterButtonInfo c3200b = new MainShutterButtonInfo(5, "button_color_inside_red", "button_shape_ring_none", 1);
        c3200b.m19232b(z);
        this.mCameraUIInterface.mo18091a(c3200b);
        if (getSupportFunction(CameraUIInterface.KEY_INERTIAL_ZOOM)) {
            this.mCameraInterface.mo10526ab();
            if (!m12390e()) {
                this.mCameraInterface.mo10577j(true);
            }
        } else if (getSupportFunction(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
            this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
        }
        super.beforeStartRecording();
        if (this.mOneCamera != null) {
            if (this.mCameraInterface != null) {
                this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.JPEG_ORIENTATION, (CaptureRequest.Key) Integer.valueOf(getJpegOrientation(this.mCameraId, this.mCameraInterface.mo10591u())));
            }
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        m12326V();
        super.beforeStartRecording(z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void afterStartRecording() {
        super.afterStartRecording();
        if (m12383z()) {
            this.mHandler.removeMessages(11);
            this.mHandler.sendEmptyMessageDelayed(11, 300000L);
        }
        if (Util.m24169C() && isVideoSuperEisWideOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_EIS_AF_AUTO_LOCK)) {
            this.mOneCamera.mo13029a(1, AEAFHelp.m11154b(), AEAFHelp.m11154b(), false);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    /* renamed from: z */
    private boolean m12383z() {
        return isSuperEISOpen() || isBlurOpen() || isVideoRetentionOpen() || isVideoNeonOpen();
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void onStopVideoRecording(boolean z) {
        if (!isDoubleExposureOpen() && !getSupportFunction(CameraUIInterface.KEY_QUICK_VIDEO)) {
            this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(6, "button_color_inside_red", "button_shape_ring_none", 1));
        }
        if (m12383z()) {
            this.mHandler.removeMessages(11);
        }
        if (getSupportFunction(CameraUIInterface.KEY_INERTIAL_ZOOM)) {
            this.mCameraInterface.mo10578k(true);
            if (!this.mCameraUIInterface.mo18224h()) {
                this.mCameraInterface.mo10525aa();
            }
        } else if (getSupportFunction(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
            this.mCameraInterface.mo10492a(true, false);
        }
        super.onStopVideoRecording(z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getHeicCodecFormat() {
        if (this.mPreferences != null && this.mCameraInterface.mo10575i() && !isUltraNightVideoOpen() && !this.mbFrontCamera) {
            if (is10bitsHeicEncodeEnable()) {
                return "heic_10bits";
            }
            CameraLog.m12954a("CommonVideoMode", "getHeicCodecFormat return null");
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void afterStopRecording() {
        if (is4k60fps()) {
            this.mCameraInterface.mo10578k(false);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_EIS_AF_AUTO_LOCK)) {
            this.mOneCamera.mo13029a(3, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        super.afterStopRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean check3HDRPreCondition() {
        return "video_size_1080p".equals(getVideoSizeType()) && 30 == m12377t();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (isVideoHdrOpen() && checkVideoHdrPreCondition() && isVideoRecordStopped()) {
            this.mCameraUIInterface.mo18108a(false, true, true);
            this.mCameraUIInterface.mo18166b(R.string.camera_video_hdr, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
            return;
        }
        if (isUltraNightVideoOpen() && isVideoRecordStopped() && check3HDRPreCondition()) {
            this.mCameraUIInterface.mo18108a(false, true, true);
            this.mCameraUIInterface.mo18166b(R.string.camera_ultra_video_night, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
            return;
        }
        if (is10bitsHeicEncodeEnable()) {
            this.mCameraUIInterface.mo18108a(false, true, true);
            this.mCameraUIInterface.mo18110a(R.string.camera_video_hdr);
            this.mCameraUIInterface.mo18110a(R.string.camera_ultra_video_night);
            if (isVideoRecordStarted()) {
                return;
            }
            this.mCameraUIInterface.mo18166b(R.string.camera_10bit_hint, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
            return;
        }
        this.mCameraUIInterface.mo18108a(false, true, true);
        this.mCameraUIInterface.mo18110a(R.string.camera_video_hdr);
        this.mCameraUIInterface.mo18110a(R.string.camera_ultra_video_night);
        this.mCameraUIInterface.mo18110a(R.string.camera_10bit_hint);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayAllIcon(boolean z, boolean z2) {
        if (isVideoFlashTorchOpen() || isVideoHdrOpen() || InverseManager.INS.isInverseColor(this.mActivity.hashCode())) {
            return;
        }
        this.mCameraUIInterface.mo18108a(false, true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFlashState() {
        return isVideoFlashTorchOpen();
    }

    @Override // com.oplus.camera.capmode.VideoMode
    public String getDefaultVideoSize() {
        return CameraConfig.getOptionKeyDefaultValue(CameraUIInterface.KEY_VIDEO_SIZE, this.mCameraId);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoHighFps() {
        return isHighFps();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z) {
        CameraLog.m12954a("CommonVideoMode", "onEffectMenuPopDown");
        if (!z) {
            m12308D();
        }
        m12361g();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFaceBeautyItemValueChange(int OplusGLSurfaceView_13, int i2, boolean z) {
        super.onFaceBeautyItemValueChange(OplusGLSurfaceView_13, i2, z);
        CameraLog.m12954a("CommonVideoMode", "onFaceBeautyItemValueChange");
        m12308D();
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean isHighFps() {
        if ((1 == this.mCameraId && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_1080_60_FPS)) || 30 == m12377t()) {
            return false;
        }
        String videoSizeType = getVideoSizeType();
        if ((!"video_size_720p".equals(videoSizeType) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_720_60_FPS)) && ((!"video_size_1080p".equals(videoSizeType) || (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_1080_60_FPS) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_1080_60_FPS))) && (!"video_size_4kuhd".equals(videoSizeType) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60_FPS)))) {
            return false;
        }
        boolean z = 60 == m12377t();
        CameraLog.m12954a("CommonVideoMode", "isHighFps, isHighFps: " + z);
        return z;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean is4k120fps() {
        return 1 != this.mCameraId && "video_size_4kuhd".equals(getVideoSizeType()) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_120_FPS) && 120 == m12377t();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean is4k60fps() {
        return isHighFps() && is4k();
    }

    /* renamed from: A */
    private boolean m12305A() {
        return is4k60fps() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE) && "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off"));
    }

    /* renamed from: B */
    private boolean m12306B() {
        return m12390e() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_8K_30FPS_ULTRA_WIDE) && "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off"));
    }

    /* renamed from: C */
    private boolean m12307C() {
        return is4k60fps() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE);
    }

    /* renamed from: D */
    private void m12308D() {
        CameraLog.m12954a("CommonVideoMode", "onHighFpsStateChange");
        if (this.mCameraUIInterface != null && isHighFps() && !isSuperEISOpen() && !this.mCameraUIInterface.mo18057R() && this.mCameraUIInterface.mo18062W()) {
            this.mCameraUIInterface.mo18070a(R.string.camera_video_fps_60, -1, true, false, false);
        } else {
            if (this.mCameraUIInterface == null || isHighFps()) {
                return;
            }
            this.mCameraUIInterface.mo18067a(R.string.camera_video_fps_60);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void switchVideoBlur(boolean z, boolean z2) {
        CameraLog.m12954a("CommonVideoMode", "switchVideoBlur, isOpen: " + z + ", changeByClick: " + z2);
        if (!z) {
            this.mCameraUIInterface.mo18067a(R.string.hint_function_not_support_1080_60);
            if (this.mCameraUIInterface.mo18051O()) {
                this.mCameraUIInterface.mo18176b(true, false, true, false);
            }
        }
        if (getSupportFunction(CameraFunction.SAT_CAMERA) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_ULTRA_WIDE)) {
            if (z && this.mCameraInterface.mo10495a(getZoomValue())) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on").apply();
            } else if (!z) {
                if (isNoneSatUltraWideAngleOpen()) {
                    this.mCameraInterface.mo10538an();
                }
                this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
            }
        }
        m12334a(true, CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
        this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE, z).apply();
        m12334a(false, (String) null);
        boolean zIsVideoNeonOpen = isVideoNeonOpen();
        if (z && (isVideoRetentionOpen() || zIsVideoNeonOpen)) {
            m12309E();
        }
        if (getSupportFunction(CameraFunction.SAT_CAMERA)) {
            if (z) {
                this.mbFlashTemporaryDisabled = false;
                m12333a(true);
            }
            if (zIsVideoNeonOpen) {
                setVideoBlurEffect(z);
            }
        } else {
            if (z) {
                this.mbFlashTemporaryDisabled = false;
                m12333a(false);
            }
            setVideoBlurEffect(z);
            if (z && this.mPreviewEffectProcess != null) {
                this.mPreviewEffectProcess.mo22808b(getBlurValue());
            }
        }
        if (z) {
            updateVideoNeonEnable(false, false);
        }
        updateVideoBlurEnable(true, z);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m12360f(boolean z) {
        String string = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS);
        CameraLog.m12959b("CommonVideoMode", "setFpsToDefault, nowVideoFPS: " + string + ", executeBeforePreview: " + z);
        if (TextUtils.equals(string, VideoMode.VIDEO_DEFAULT_FPS)) {
            return;
        }
        if (z) {
            this.mCameraInterface.mo10559c(true);
        }
        this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS).apply();
        if (z) {
            this.mCameraInterface.mo10559c(false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isSuperEISProOpen() {
        if (!getSupportFunction(CameraUIInterface.KEY_SUPPORT_SUPER_EIS_WIDE_MENU) || this.mPreferences == null) {
            return false;
        }
        return this.mPreferences.getBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected boolean isSuperEISOpen() {
        if (!getSupportFunction(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU) || this.mPreferences == null) {
            return false;
        }
        return "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSatOpen() {
        if (!getSupportFunction(CameraFunction.SAT_CAMERA) || isBlurOpen() || isVideoNeonOpen() || isVideoRetentionOpen() || isSuperEISOpen()) {
            return false;
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR_SAT) && isVideoHdrOpen() && checkVideoHdrPreCondition()) {
            return false;
        }
        if (isUltraNightVideoOpen() && m12318N()) {
            return false;
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_SAT_SUPPORT) && isAiEnhancementVideoOpen() && m12318N()) {
            return false;
        }
        String videoSizeType = getVideoSizeType();
        boolean z = Integer.parseInt(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS)) == 60 && !this.mbFrontCamera;
        if ((CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_SAT_MASK) & 1) == 0 && z) {
            return false;
        }
        if ((CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_SAT_MASK) & 2) == 0 && "video_size_4kuhd".equals(videoSizeType)) {
            return false;
        }
        if ((CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_SAT_MASK) & 4) == 0 && z && "video_size_4kuhd".equals(videoSizeType)) {
            return false;
        }
        return ((CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_SAT_MASK) & 16) == 0 && "video_size_8k".equals(videoSizeType)) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onUltraWideAngleOpened() {
        if (isSuperEISOpen()) {
            this.mCameraInterface.mo10559c(true);
            this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            this.mCameraInterface.mo10559c(false);
        }
        if (isVideoHdrOpen()) {
            this.mCameraInterface.mo10559c(true);
            this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_HDR, "off").apply();
            this.mCameraInterface.mo10559c(false);
        }
        if (isBlurOpen() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_ULTRA_WIDE)) {
            this.mCameraInterface.mo10559c(true);
            m12310F();
            this.mCameraInterface.mo10559c(false);
        }
        if (isVideoRetentionOpen() || isVideoNeonOpen()) {
            this.mCameraInterface.mo10559c(true);
            m12309E();
            this.mCameraInterface.mo10559c(false);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_ZOOM_SUPPORT) && isAiEnhancementVideoOpen() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE)) {
            this.mCameraInterface.mo10559c(true);
            this.mPreferences.edit().putString(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
            this.mCameraInterface.mo10559c(false);
        }
        String videoSizeType = getVideoSizeType();
        boolean z = Integer.parseInt(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS)) == 60 && !this.mbFrontCamera;
        boolean zM12320P = m12320P();
        CameraLog.m12954a("CommonVideoMode", "onUltraWideAngleOpened, videoSizeType: " + videoSizeType + ", isHighFps: " + z + ", isWideVideoOnly720P: " + zM12320P);
        if ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE) && "video_size_4kuhd".equals(videoSizeType) && z) || m12386a(videoSizeType)) {
            return;
        }
        if ("video_size_4kuhd".equals(videoSizeType) || ("video_size_1080p".equals(videoSizeType) && zM12320P)) {
            this.mCameraInterface.mo10559c(true);
            if (zM12320P) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_720p").apply();
            } else {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p").apply();
            }
            this.mCameraInterface.mo10559c(false);
        }
        if (!z || isAiEnhancementVideoOpen()) {
            return;
        }
        m12360f(true);
        m12308D();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMenuOptionAdded(String str) {
        if (CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str) && this.mCameraUIInterface.mo18141ae()) {
            this.mCameraUIInterface.mo18102a(CameraUIInterface.KEY_VIDEO_FILTER_MENU, true, (int) this.mActivity.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.mActivity.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_y));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFilterRedpotKey(String str) {
        if ("oplus_video_filter_neon".equals(str) && PreferenceManager.m3981a(this.mActivity).getBoolean("video_filter_neon_show", true)) {
            return "video_filter_neon_show";
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFilterMenuClicked() {
        if (this.mCameraUIInterface.mo18141ae()) {
            this.mCameraUIInterface.mo18102a(CameraUIInterface.KEY_VIDEO_FILTER_MENU, false, (int) this.mActivity.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.mActivity.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_y));
            PreferenceManager.m3981a(this.mActivity).edit().putBoolean("video_filter_reddot_show", false).apply();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFilterOpen(String str) {
        return ("oplus_video_filter_portrait_retention".equals(str) || "oplus_video_filter_neon".equals(str) || !super.isFilterOpen(str)) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getHintTextId() {
        if (!isNoneSatUltraWideAngleOpen()) {
            return -1;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_IS_UW_FIXED_FOCUS) || Float.compare(this.mOneCamera.mo13086e().m13279n(), 0.0f) == 0) {
            return R.string.toast_ultra_wide_angel_lens;
        }
        if (isAiEnhancementVideoOpen() || isSuperEISOpen()) {
            return -1;
        }
        return Util.m24445f(R.string.toast_ultra_wide_micro_lens);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResumeFromSetting() {
        super.onResumeFromSetting();
        if (!is10bitsHeicEncodeEnable() && !isFilterEffectOpen() && !isBlurOpen() && !isFaceBeautyOrMakeupOpen() && !is4k() && !isSuperEISOpen()) {
            this.f12841j = false;
        } else if (is10bitsHeicEncodeEnable()) {
            this.f12841j = true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onTopSubMenuCollapse() {
        if (this.mCameraInterface.mo10575i() && this.mbCapModeInit && this.mbModePreInit) {
            m12308D();
            if (is4k()) {
                Util.m24441e(this.mActivity, "camera_mode_changed");
            }
        }
    }

    /* renamed from: E */
    private void m12309E() {
        m12362g(true);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m12362g(boolean z) {
        boolean z2 = isVideoNeonOpen() || isVideoRetentionOpen();
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putInt(getFilterEffectMenuPreferenceKey(), getFilterNoneIndex());
        editorEdit.apply();
        this.f12854w = getFilterNoneIndex();
        this.mPreviewEffectProcess.mo22848l(false);
        this.mPreviewEffectProcess.mo22851m(false);
        if (z2 && this.mCameraInterface != null) {
            this.mCameraInterface.mo10513aO();
        }
        if (this.mHandler == null || !z) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_8$oXjXFYFTGkKnkaoBTBphO8jVpaE
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m12329Y();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public /* synthetic */ void m12329Y() {
        this.mCameraUIInterface.mo18188c(getFilterCurrName(), getFilterNoneIndex());
        this.mCameraUIInterface.mo18106a(this.mCameraUIInterface.mo18023A(), getEffectMenuKeyByMode());
    }

    /* renamed from: F */
    private void m12310F() {
        CameraLog.m12962c("CommonVideoMode", "resetCurrentVideoBlurPreference");
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX);
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        editorEdit.apply();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void switchSuperEISWide(boolean z) {
        if (z) {
            this.mCameraUIInterface.mo18210f(19, true);
        }
        this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, z).apply();
        String string = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off");
        if (z && !"off".equals(string) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
            this.mCameraUIInterface.mo18108a(false, true, true);
            this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off").apply();
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE_60_FPS) && 60 == CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_EIS_FPS)) {
            boolean z2 = Integer.parseInt(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS)) == 60;
            if (z && z2) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(30)).apply();
                m12311G();
            } else if (!z && !z2) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(60)).apply();
            }
        }
        this.mCameraUIInterface.mo18046M();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String m12350d(String str) {
        if ("video_size_8k".equals(str)) {
            return Util.m24472l().getString(R.string.camera_video_size_8k);
        }
        if ("video_size_4kuhd".equals(str)) {
            return Util.m24472l().getString(R.string.camera_video_size_4kuhd);
        }
        if ("video_size_1080p".equals(str)) {
            return Util.m24472l().getString(R.string.camera_video_size_1080p);
        }
        if ("video_size_720p".equals(str)) {
            return Util.m24472l().getString(R.string.camera_video_size_720p);
        }
        return Util.m24472l().getString(R.string.camera_video_size_1080p);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String m12354e(String str) {
        if (String.valueOf(120).equals(str)) {
            return Util.m24472l().getString(R.string.camera_video_fps_120_fps);
        }
        if (String.valueOf(60).equals(str)) {
            return Util.m24472l().getString(R.string.camera_video_fps_60_fps);
        }
        if (String.valueOf(30).equals(str)) {
            return Util.m24472l().getString(R.string.camera_video_fps_30_fps);
        }
        if (String.valueOf(24).equals(str)) {
            return Util.m24472l().getString(R.string.camera_video_fps_24_fps);
        }
        return Util.m24472l().getString(R.string.camera_video_fps_30_fps);
    }

    /* renamed from: G */
    private void m12311G() {
        String videoSizeType = getVideoSizeType();
        String strValueOf = this.mbFrontCamera ? String.valueOf(30) : this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS);
        this.mCameraUIInterface.mo18067a(R.string.camera_ai_video_low_ambient_light_hint);
        this.mCameraUIInterface.mo18074a(R.string.hint_function_not_support_1080_60, 2800, m12350d(videoSizeType), m12354e(strValueOf));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU.equals(str) && getSupportFunction(str) && sharedPreferences != null) {
            boolean zEquals = "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off"));
            if (!zEquals) {
                if (sharedPreferences.getBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false)) {
                    m12369l();
                    sharedPreferences.edit().putBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false).apply();
                } else if (this.mbFrontCamera && !isBlurOpen() && FilterHelper.m22591a(this.mbFrontCamera) != getCurrFilterIndex()) {
                    int OplusGLSurfaceView_13 = this.mPreferences.getInt(CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, 0);
                    CameraLog.m12962c("CommonVideoMode", "onSharedPreferenceChanged, lastMakeupIndex: " + OplusGLSurfaceView_13);
                    if (OplusGLSurfaceView_13 != 0) {
                        this.mCameraUIInterface.mo18274u(OplusGLSurfaceView_13);
                        this.mPreferences.edit().remove(CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX).apply();
                    }
                }
            } else if (m12372o() && isMakeupOpen()) {
                int currMakeupIndex = getCurrMakeupIndex();
                CameraLog.m12962c("CommonVideoMode", "onSharedPreferenceChanged, currentMakeupIndex: " + currMakeupIndex);
                if (currMakeupIndex != 0) {
                    this.mPreferences.edit().putInt(CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, currMakeupIndex).apply();
                    this.mCameraUIInterface.mo18274u(0);
                }
            }
            if (isRearSuperEISOpen()) {
                this.mCameraUIInterface.mo18109a(true, this.mCameraUIInterface.mo18043K(), false, false);
                this.mCameraUIInterface.mo18232j(true, false);
            } else if (supportBeautyButton()) {
                this.mCameraUIInterface.mo18240l(true, false);
            }
            if (supportMenuLeftButton()) {
                if (zEquals && !this.mbFrontCamera) {
                    this.mCameraUIInterface.mo18176b(true, true, true, false);
                    this.mCameraUIInterface.mo18223h(true, false);
                } else {
                    this.mCameraUIInterface.mo18228i(true, false);
                }
            }
        }
        if (CameraUIInterface.KEY_VIDEO_FILTER_INDEX.equals(str)) {
            int i2 = sharedPreferences != null ? sharedPreferences.getInt(CameraUIInterface.KEY_VIDEO_FILTER_INDEX, getFilterNoneIndex()) : getFilterNoneIndex();
            int iM22591a = FilterHelper.m22591a(true);
            if (iM22591a == this.f12854w && iM22591a != i2 && !isBlurOpen() && !m12372o() && getSupportFunction(CameraUIInterface.KEY_SUPPORT_MAKEUP)) {
                CameraLog.m12962c("CommonVideoMode", "onSharedPreferenceChanged, need to force reopen makeup ");
                this.mCameraUIInterface.mo18129aS();
                m12370m();
            }
        }
        if (m12344b(str)) {
            m12359f(str);
            m12361g();
        }
        if (CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE.equals(str) && !this.mCameraInterface.mo10499aA()) {
            this.f12840i = true;
        }
        if (CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO.equals(str)) {
            m12384a();
            m12315K();
        }
        if (CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(str)) {
            m12388c();
        }
        if (CameraUIInterface.KEY_EXPLORER_CHIP_STATE.equals(str)) {
            this.mCameraUIInterface.mo18258q();
        }
        if (CameraUIInterface.KEY_DISABLE_AI_ENHANCEMENT_VIDEO.equals(str)) {
            this.mCameraUIInterface.mo18074a(R.string.explorer_chip_damage_tip, 2000, new Object[0]);
        }
        if (CameraUIInterface.KEY_TORCH_MODE.equals(str) && isOpenFrontTorch() && isBlurOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SCREEN_BRIGHTNESS_VIDEO)) {
            m12313I();
        }
        if (CameraUIInterface.KEY_VIDEO_BLUR_MENU.equals(str)) {
            boolean z = this.mPreferences != null && "on".equals(this.mPreferences.getString(str, "off"));
            int i3 = this.mPreferences.getInt(CameraUIInterface.KEY_MAKEUP_LAST_CLOSE_INDEX, 0);
            if (z) {
                updateVideoNeonEnable(false, false);
                m12371n();
            } else if (i3 != 0 && !"oplus_video_filter_neon".equals(getCurrFilterType()) && !m12372o() && !isVideoRecording()) {
                this.mCameraInterface.mo10546av();
            }
            updateVideoBlurEnable(true, z);
            if (isOpenFrontTorch() && isBlurOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SCREEN_BRIGHTNESS_VIDEO)) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_TORCH_MODE, "off").apply();
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_TORCH_MODE);
            }
        }
        if (CameraUIInterface.KEY_10_BITS_HEIC_ENCODE.equals(str)) {
            m12387b();
        }
        if (CameraUIInterface.KEY_VIDEO_BLUR_MENU.equals(str)) {
            m12369l();
            if (!isBlurOpen()) {
                m12378u();
            }
        }
        if (CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str)) {
            m12369l();
            if (!isFilterEffectOpen()) {
                m12378u();
            }
        }
        if (CameraUIInterface.KEY_CAMERA_ID.equals(str)) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_ID, String.valueOf(0));
            if (Integer.parseInt(string) == 0 && this.mCameraId != Integer.parseInt(string)) {
                this.f12842k = true;
            }
        }
        if (CameraUIInterface.KEY_VIDEO_SIZE.equals(str) && this.mPreferences.contains(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE)) {
            String string2 = this.mPreferences.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off");
            if (!getSupportFunction(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) && "on".equals(string2) && !isRearSuperEISOpen()) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
            }
        }
        if (CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE.equals(str)) {
            if (!getSupportFunction(CameraFunction.SAT_CAMERA)) {
                updateTrackEnable();
            }
            if (m12316L() && !this.mCameraInterface.mo10499aA()) {
                if (isBlurOpen()) {
                    if (isAiEnhancementVideoOpen()) {
                        m12333a(false);
                        this.mPreferences.edit().putString(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
                        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_8$6rBNUu5_cT-43Nogc2lmUdsd7ZI
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.COUIBaseListPopupWindow_12$0.m12328X();
                            }
                        });
                    }
                } else if (m12312H()) {
                    m12335a(true, m12381x());
                }
            }
        }
        if (CameraUIInterface.KEY_VIDEO_SIZE.equals(str)) {
            m12369l();
            if (!is4k()) {
                m12378u();
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_8K_24_FPS) && "video_size_8k".equals(this.mVideoSizeType) && !m12390e() && String.valueOf(24).equals(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS))) {
                m12360f(true);
            }
            if (!isAiEnhancementVideoOpen() && !this.mPreferences.getBoolean(CameraUIInterface.KEY_AI_ENHANCEMENT_CLOSED_BY_VIDEO_SIZE_FPS, false)) {
                this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_AI_ENHANCEMENT_CLOSED_BY_VIDEO_SIZE_FPS, m12363g(CameraUIInterface.KEY_VIDEO_SIZE)).apply();
            }
            if (m12316L() && m12363g(CameraUIInterface.KEY_VIDEO_SIZE)) {
                m12335a(false, true);
            }
        }
        if (CameraUIInterface.KEY_VIDEO_FPS.equals(str)) {
            if (!isAiEnhancementVideoOpen() && !this.mPreferences.getBoolean(CameraUIInterface.KEY_AI_ENHANCEMENT_CLOSED_BY_VIDEO_SIZE_FPS, false)) {
                this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_AI_ENHANCEMENT_CLOSED_BY_VIDEO_SIZE_FPS, m12363g(CameraUIInterface.KEY_VIDEO_FPS)).apply();
            }
            if (m12316L() && m12363g(CameraUIInterface.KEY_VIDEO_FPS)) {
                m12335a(false, true);
            }
        }
        if ((CameraUIInterface.KEY_VIDEO_SIZE.equals(str) || CameraUIInterface.KEY_VIDEO_FPS.equals(str)) && this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18056R(getSupportFunction(CameraFunction.OUT_PREVIEW_ENABLE));
            this.mCameraUIInterface.mo18052P(!is4k60fps());
        }
        if (CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU.equals(str) && getSupportFunction(str)) {
            if (sharedPreferences != null && ("on".equals(sharedPreferences.getString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off")) || sharedPreferences.getBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false))) {
                m12369l();
            } else {
                m12378u();
            }
        }
        if (CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE.equals(str) && m12316L() && sharedPreferences != null && "off".equals(sharedPreferences.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, ""))) {
            m12335a(false, m12381x());
        }
        if (CameraUIInterface.KEY_SUB_SETTING.equals(str) && "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_SUB_SETTING, "off")) && isBubbleOpen(CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO)) {
            this.mCameraUIInterface.mo18210f(7, true);
        }
        m12314J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public /* synthetic */ void m12328X() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
        }
    }

    /* renamed from: H */
    private boolean m12312H() {
        return m12363g(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE) || m12363g(CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean showMenuLeftButton() {
        return super.showMenuLeftButton() && !((!this.mbFrontCamera && isSuperEISOpen()) || isVideoRecording() || this.mCameraInterface.mo10454J() || this.mCameraUIInterface.mo18051O() || this.mCameraUIInterface.mo18043K());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean showBeautyButton() {
        return super.showBeautyButton() && !((!this.mbFrontCamera && isSuperEISOpen()) || this.mCameraUIInterface.mo18051O() || this.mCameraUIInterface.mo18043K());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean needSetMakeupToAlgo() {
        return super.needSetMakeupToAlgo() && !m12372o();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m12359f(String str) {
        if (CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO.equals(str) && !isAiEnhancementVideoOpen() && "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off")) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
            this.mCameraInterface.mo10538an();
        }
    }

    /* renamed from: I */
    private void m12313I() {
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX);
        editorEdit.remove(CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        editorEdit.apply();
        setBlurIndex(0);
        setVideoBlurEffect(false);
        this.mCameraUIInterface.mo18067a(R.string.camera_one_subject_hint);
        this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        this.mCameraUIInterface.mo18176b(true, false, true, false);
    }

    /* renamed from: J */
    private void m12314J() {
        if (this.mCameraUIInterface == null || this.mPreferences == null || this.mCameraUIInterface.mo18043K() || this.mCameraUIInterface.mo18051O() || this.mCameraInterface.mo10454J() || isVideoRecording() || !supportBeautyButton()) {
            return;
        }
        this.mCameraUIInterface.mo18240l(true, Util.m24498u() && (this.mCameraUIInterface.mo18053P() || this.mCameraUIInterface.mo18055Q()));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getDefaultHDRValue() {
        return this.mActivity != null ? this.mActivity.getResources().getString(R.string.camera_video_hdr_default_value) : "off";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onHDRModeChanged(String str) {
        if (CameraUIInterface.KEY_VIDEO_HDR.equals(str)) {
            m12389d();
            m12315K();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12384a() {
        boolean z;
        boolean zIsUltraNightVideoOpen = isUltraNightVideoOpen();
        String videoSizeType = getVideoSizeType();
        String string = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS);
        CameraLog.m12954a("CommonVideoMode", "onUltraNightVideoChanged, isUltraNightVideoOpen: " + zIsUltraNightVideoOpen + ", videoSizeType: " + videoSizeType + ", videoFps: " + string);
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        this.mCameraInterface.mo10559c(true);
        if (!zIsUltraNightVideoOpen) {
            this.mCameraUIInterface.mo18067a(R.string.hint_function_not_support_1080_60);
        }
        if (zIsUltraNightVideoOpen) {
            if (isBlurOpen()) {
                m12313I();
                this.mCameraUIInterface.mo18067a(R.string.camera_one_subject_hint);
            }
            if (isFaceBeautyOrMakeupOpen()) {
                editorEdit.putInt(getFaceBeautyKey(), 0);
            }
            if (isFilterEffectOpen()) {
                m12309E();
            }
            if (isSuperEISOpen()) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
            }
            if (getSupportFunction(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
                editorEdit.putBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false);
            }
            if (getSupportFunction(CameraFunction.VIDEO_HDR) && isVideoHdrOpen()) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_HDR, "off").apply();
            }
            if ("video_size_1080p".equals(videoSizeType)) {
                z = false;
            } else {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p");
                z = true;
            }
            if (!"video_size_1080p".equals(videoSizeType)) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p");
                z = true;
            }
            if (30 != Integer.parseInt(string)) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(30));
                z = true;
            }
            editorEdit.apply();
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU);
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_HDR);
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        } else {
            z = false;
        }
        this.mCameraInterface.mo10559c(false);
        if (zIsUltraNightVideoOpen) {
            if (isNoneSatUltraWideAngleOpen()) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
            } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT) && !isNoneSatUltraWideAngleOpen() && this.mCameraInterface.mo10495a(getZoomValue())) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on").apply();
            }
            if (this.mCameraUIInterface.mo18023A() && MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                this.mCameraUIInterface.mo18267s(true);
            } else {
                this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_VIDEO_FILTER_MENU);
            }
            if (this.mCameraUIInterface.mo18043K()) {
                this.mCameraUIInterface.mo18232j(true, false);
            }
            if (isVideoRecordStopped() && check3HDRPreCondition()) {
                this.mCameraUIInterface.mo18108a(false, true, true);
                this.mCameraUIInterface.mo18166b(R.string.camera_ultra_video_night, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
            }
            this.mCameraUIInterface.mo18067a(R.string.camera_ai_enhancement_video_hint_off);
            this.mCameraUIInterface.mo18230j(0);
        } else {
            this.mCameraUIInterface.mo18110a(R.string.camera_ultra_video_night);
            if ("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off"))) {
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
                    this.mCameraInterface.mo10538an();
                }
                this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
            }
        }
        if (z) {
            m12311G();
        }
    }

    /* renamed from: K */
    private void m12315K() {
        if (showBeautyButton()) {
            if (isPanelMode()) {
                this.mCameraUIInterface.mo18077a(0, true);
            } else {
                this.mCameraUIInterface.mo18068a(0, 1);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12387b() {
        boolean zIs10bitsHeicEncodeEnable = is10bitsHeicEncodeEnable();
        String videoSizeType = getVideoSizeType();
        CameraLog.m12954a("CommonVideoMode", "on10bitChanged, is10bitOpen: " + zIs10bitsHeicEncodeEnable + ", videoSizeType: " + videoSizeType + ", videoFps: " + this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS));
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        if (zIs10bitsHeicEncodeEnable) {
            if (isBlurOpen()) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_BLUR_MENU, "off");
                this.mCameraUIInterface.mo18067a(R.string.camera_one_subject_hint);
            }
            if (isFilterEffectOpen()) {
                m12309E();
            }
            if (isFaceBeautyOrMakeupOpen()) {
                editorEdit.putInt(getFaceBeautyKey(), 0);
            }
            if ("video_size_4kuhd".equals(videoSizeType) && !"video_size_1080p".equals(videoSizeType)) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p").apply();
            }
            if (isRearSuperEISOpen()) {
                this.mCameraInterface.mo10559c(true);
                this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
            }
            editorEdit.apply();
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_BLUR_MENU);
        }
        if (zIs10bitsHeicEncodeEnable) {
            if (!this.mCameraUIInterface.mo18023A() || !MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_VIDEO_FILTER_MENU);
            }
            if (this.mPreferences.getInt(getFaceBeautyKey(), 0) == 0) {
                onFaceBeautyItemChange(0);
                this.mCameraUIInterface.mo18230j(0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d1  */
    /* renamed from: IntrinsicsJvm.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m12388c() {
        /*
            Method dump skipped, instructions count: 855
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.CommonVideoMode.m12388c():void");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needClearFocusView() {
        return !CameraCharacteristicsUtil.m12974a(this.mCameraId);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12334a(boolean z, String str) {
        HintManager c3130aMo18233k;
        if (this.mCameraUIInterface == null || (c3130aMo18233k = this.mCameraUIInterface.mo18233k()) == null) {
            return;
        }
        c3130aMo18233k.m18488a(z);
        c3130aMo18233k.m18492b(str);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m12363g(String str) {
        HintManager c3130aMo18233k = this.mCameraUIInterface != null ? this.mCameraUIInterface.mo18233k() : null;
        return c3130aMo18233k != null && c3130aMo18233k.m18490a(str);
    }

    /* renamed from: L */
    private boolean m12316L() {
        return getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_V3);
    }

    /* renamed from: M */
    private boolean m12317M() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_AI_ENHANCEMENT_VIDEO_FILTER_MUTEX_SUPPORT);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12389d() {
        boolean z;
        boolean zIsVideoHdrOpen = isVideoHdrOpen();
        String videoSizeType = getVideoSizeType();
        String string = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS);
        CameraLog.m12954a("CommonVideoMode", "onVideoHdrModeChanged, isVideHdrOpen: " + zIsVideoHdrOpen + ", videoSizeType: " + videoSizeType + ", videoFps: " + string);
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        this.mCameraInterface.mo10559c(true);
        if (!zIsVideoHdrOpen) {
            this.mCameraUIInterface.mo18067a(R.string.hint_function_not_support_1080_60);
        }
        if (zIsVideoHdrOpen) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) && !CameraParameter.VideoEncoder.H265.equals(getVideoCodec())) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_CODEC, CameraParameter.VideoEncoder.H265);
            }
            if (isBlurOpen()) {
                m12313I();
            }
            if (isFaceBeautyOrMakeupOpen()) {
                editorEdit.putInt(getFaceBeautyKey(), 0);
            }
            if (isFilterEffectOpen()) {
                m12309E();
            }
            if (isSuperEISOpen()) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off").apply();
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU);
            }
            if (getSupportFunction(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
                editorEdit.putBoolean(CameraUIInterface.KEY_SUPER_EIS_WIDE, false);
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR)) {
                if (!"video_size_4kuhd".equals(videoSizeType)) {
                    editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_4kuhd");
                    z = true;
                }
                z = false;
            } else {
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR)) {
                    boolean zEquals = "video_size_1080p".equals(videoSizeType);
                    if (!zEquals && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR_EXCEPT_8K)) {
                        zEquals = !"video_size_8k".equals(videoSizeType);
                    }
                    if (!zEquals) {
                        editorEdit.putString(CameraUIInterface.KEY_VIDEO_SIZE, "video_size_1080p");
                        z = true;
                    }
                }
                z = false;
            }
            if (30 != Integer.parseInt(string)) {
                editorEdit.putString(CameraUIInterface.KEY_VIDEO_FPS, String.valueOf(30));
                z = true;
            }
            if (getSupportFunction(CameraFunction.ULTRA_NIGHT_VIDEO) && isUltraNightVideoOpen()) {
                editorEdit.putString(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off").apply();
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO);
            }
            if (getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO) && isAiEnhancementVideoOpen()) {
                editorEdit.putString(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, "off").apply();
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
            }
            editorEdit.apply();
        } else {
            z = false;
        }
        this.mCameraInterface.mo10559c(false);
        if (zIsVideoHdrOpen) {
            if (isNoneSatUltraWideAngleOpen()) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
            }
            if (this.mCameraUIInterface.mo18023A() && MenuClickMsgData.KEY_FILTER.equals(getCurrEffectMenuName())) {
                this.mCameraUIInterface.mo18267s(true);
            } else {
                this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_VIDEO_FILTER_MENU);
            }
            if (this.mCameraUIInterface.mo18043K()) {
                this.mCameraUIInterface.mo18232j(true, false);
            }
            if (checkVideoHdrPreCondition() && isVideoRecordStopped()) {
                this.mCameraUIInterface.mo18108a(false, true, true);
                this.mCameraUIInterface.mo18166b(R.string.camera_video_hdr, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, new Object[0]);
            }
            this.mCameraUIInterface.mo18230j(0);
        } else {
            this.mCameraUIInterface.mo18110a(R.string.camera_video_hdr);
        }
        if (z) {
            m12311G();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean checkVideoHdrPreCondition() {
        boolean zEquals;
        String videoSizeType = getVideoSizeType();
        int iM12377t = m12377t();
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR)) {
            zEquals = "video_size_4kuhd".equals(videoSizeType);
        } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR_EXCEPT_8K)) {
            zEquals = !"video_size_8k".equals(videoSizeType);
        } else {
            zEquals = "video_size_1080p".equals(videoSizeType);
        }
        return zEquals && 30 == iM12377t;
    }

    /* renamed from: N */
    private boolean m12318N() {
        return "video_size_1080p".equals(getVideoSizeType()) && 30 == m12377t();
    }

    /* renamed from: O */
    private boolean m12319O() {
        String videoSizeType = getVideoSizeType();
        int iM12377t = m12377t();
        String[] configStringArrayValue = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AI_VIDEO_ENHANCE_FRONT_RESOLUTION);
        String[] configStringArrayValue2 = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AI_VIDEO_ENHANCE_REAR_RESOLUTION);
        return (!this.mbFrontCamera || configStringArrayValue == null || configStringArrayValue.length <= 0) ? (this.mbFrontCamera || configStringArrayValue2 == null || configStringArrayValue2.length <= 0) ? getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO) ? "video_size_1080p".equals(videoSizeType) && 30 == iM12377t : 30 == iM12377t && ("video_size_1080p".equals(videoSizeType) || "video_size_720p".equals(videoSizeType)) : Util.m24397b(configStringArrayValue2, videoSizeType) && 30 == iM12377t : Util.m24397b(configStringArrayValue, videoSizeType) && 30 == iM12377t;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoHdrOpen() {
        if (getSupportFunction(CameraFunction.VIDEO_HDR)) {
            return "on".equals(getHDRModeValue(getHDRKey()));
        }
        return false;
    }

    /* renamed from: P */
    private boolean m12320P() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_WIDE_VIDEO_ONLY_720P_SUPPORT);
    }

    /* renamed from: Q */
    private boolean m12321Q() {
        return this.mPreferences != null && this.mPreferences.getString(CameraUIInterface.KEY_LINE_VIDEO, "off").equals("grid");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        VideoRecordMsgData videoRecordMsgData;
        if (dcsMsgData instanceof VideoRecordMsgData) {
            VideoRecordMsgData videoRecordMsgData2 = (VideoRecordMsgData) dcsMsgData;
            videoRecordMsgData2.mLux = String.valueOf(this.mDcsLux);
            videoRecordMsgData2.mCct = String.valueOf(this.mDcsCCT);
            videoRecordMsgData2.mIso = String.valueOf(this.mDcsIso);
            videoRecordMsgData2.mExp = String.valueOf(this.mDcsExp);
            videoRecordMsgData2.mIsAssistantLine = Boolean.toString(m12321Q());
            videoRecordMsgData = videoRecordMsgData2;
        } else {
            videoRecordMsgData = null;
        }
        return videoRecordMsgData == null ? dcsMsgData : videoRecordMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isUltraNightVideoOpen() {
        if (!getSupportFunction(CameraFunction.ULTRA_NIGHT_VIDEO) || this.mPreferences == null) {
            return false;
        }
        return "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAiEnhancementVideoOpen() {
        if (!getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO) || this.mPreferences == null) {
            return false;
        }
        return "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, Util.m24438e(this.mbFrontCamera)));
    }

    /* renamed from: R */
    private boolean m12322R() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_EXPLORER_SUPPORT) && this.mPreferences.getInt(CameraUIInterface.KEY_EXPLORER_CHIP_STATE, 1) == 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHDRState() {
        return isVideoHdrOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideo10BitOpen() {
        return getSupportFunction(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE) ? (isFaceBeautyOrMakeupOpen() || isBlurOpen() || isFilterEffectOpen() || !is10bitsHeicEncodeEnable() || 120 == getVideoFps()) ? false : true : isVideoHdrOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR_10BIT) && 120 != getVideoFps();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        if (this.mbDestroyed) {
            return null;
        }
        return (((this.mCameraInterface == null || this.mCameraInterface.mo10575i()) && (isSuperEISOpen() || isSatOpen() || !isHighFps())) || needApsToProcessVideoWatermark()) ? (this.mbFrontCamera || !isVideoRetentionOpen()) ? isRearSuperEISOpen() ? isVideoSuperEisWideOpen() ? ApsConstant.FEATURE_REC_SUPER_EIS_PRO : ApsConstant.FEATURE_REC_SUPER_EIS : (isSatOpen() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) ? ApsConstant.FEATURE_REC_SAT_HAL : isVideoHdrOpen() ? ApsConstant.FEATURE_REC_LIVE_HDR : isUltraNightVideoOpen() ? ApsConstant.FEATURE_REC_ULTRA_NIGHT : isAiEnhancementVideoOpen() ? ApsConstant.FEATURE_REC_AI_ENHANCEMENT : super.getCameraFeature() : AlgoSwitchConfig.getSupportCameraFeature(ApsConstant.FEATURE_VIDEO_RETENTION, this.mCameraId) ? ApsConstant.FEATURE_VIDEO_RETENTION : AlgoSwitchConfig.getSupportCameraFeature(ApsConstant.FEATURE_COMMON_VIDEO_DUMMY, this.mCameraId) ? ApsConstant.FEATURE_COMMON_VIDEO_DUMMY : ApsConstant.FEATURE_COMMON_DUMMY : AlgoSwitchConfig.getSupportCameraFeature(ApsConstant.FEATURE_COMMON_VIDEO_DUMMY, this.mCameraId) ? ApsConstant.FEATURE_COMMON_VIDEO_DUMMY : ApsConstant.FEATURE_COMMON_DUMMY;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean is4k() {
        return this.mPreferences != null && "video_size_4kuhd".equals(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_SIZE, getDefaultVideoSize()));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m12390e() {
        if (this.mPreferences != null) {
            return m12386a(getVideoSizeType());
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m12386a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "video_size_8k".equals(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAntibandingEnable() {
        return (isBlurOpen() || isVideoNeonOpen() || isHighFps()) ? false : true;
    }

    /* renamed from: S */
    private void m12323S() {
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        String string = this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_CODEC_BACKUP, "JPEG");
        String string2 = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_CODEC_BACKUP, CameraParameter.VideoEncoder.H264);
        editorEdit.putString(CameraUIInterface.KEY_PHOTO_CODEC, string);
        editorEdit.putString(CameraUIInterface.KEY_VIDEO_CODEC, string2);
        editorEdit.apply();
    }

    /* renamed from: T */
    private boolean m12324T() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_SUPPORT_PREVERSION) || isSuperEISOpen()) {
            return true;
        }
        return (is4k() || isHighFps()) ? false : true;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m12365h(String str) {
        if (this.mPreviewEffectProcess != null) {
            if ("oplus_video_filter_portrait_retention".equals(str) || "oplus_video_filter_neon".equals(str)) {
                this.mPreviewEffectProcess.mo22792a("default");
            } else {
                this.mPreviewEffectProcess.mo22792a(str);
            }
            this.f12855x = str;
            this.mPreviewEffectProcess.mo22820c(getSupportFunction(CameraFunction.FILTER_VIGNETTE) && "oplus_video_filter_olympus".equals(str));
        }
    }

    /* renamed from: U */
    private boolean m12325U() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_1080P) && (this.mbFrontCamera || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_1080P_DISABLE_REAR));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeConfig() {
        if (getSupportFunction(CameraFunction.AI_ENHANCEMENT_VIDEO)) {
            checkAiEnhancementVideoState();
        }
        if (this.mCameraInterface == null || !this.mCameraInterface.mo10575i()) {
            return;
        }
        m12361g();
    }

    /* renamed from: V */
    private void m12326V() {
        int iM12357f;
        if (this.mbFrontCamera) {
            return;
        }
        String str = this.mVideoSizeType;
        String string = this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FPS, VideoMode.VIDEO_DEFAULT_FPS);
        int recordingMaxDuration = getRecordingMaxDuration(str, string) / 60;
        if (recordingMaxDuration > 0 && (iM12357f = m12357f(str, string)) >= 0) {
            this.mCameraUIInterface.mo18069a(iM12357f, 2800, recordingMaxDuration, Integer.valueOf(recordingMaxDuration));
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int m12357f(String str, String str2) {
        if ("video_size_8k".equals(str) && String.valueOf(30).equals(str2)) {
            return R.plurals.video_message_max_duration_8k_30fps;
        }
        if ("video_size_8k".equals(str) && String.valueOf(24).equals(str2)) {
            return R.plurals.video_message_max_duration_8k_24fps;
        }
        if ("video_size_4kuhd".equals(str) && String.valueOf(120).equals(str2)) {
            return R.plurals.video_message_max_duration_4k_120fps;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
    
        r3 = com.oplus.camera.aps.config.CameraConfig.getConfigStringArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_MAX_DURATION_VALUE);
     */
    @Override // com.oplus.camera.capmode.VideoMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int getRecordingMaxDuration(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            boolean r3 = r3.mbFrontCamera
            r0 = -1
            if (r3 != 0) goto L56
            if (r4 == 0) goto L56
            if (r5 != 0) goto La
            goto L56
        La:
            java.lang.String r3 = "com.oplus.video.max.duration.value"
            java.lang.String[] r3 = com.oplus.camera.aps.config.CameraConfig.getConfigStringArrayValue(r3)
            if (r3 == 0) goto L56
            int r1 = r3.length
            r2 = 3
            if (r1 < r2) goto L56
            int r1 = r3.length
            int r1 = r1 % r2
            if (r1 == 0) goto L1b
            goto L56
        L1b:
            r1 = 0
        L1c:
            int r2 = r3.length
            if (r1 >= r2) goto L56
            r2 = r3[r1]
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L53
            int r2 = r1 + 1
            r2 = r3[r2]
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L53
            int r1 = r1 + 2
            r4 = r3[r1]     // Catch: java.lang.NumberFormatException -> L3a
            int r3 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.NumberFormatException -> L3a
            return r3
        L3a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getRecordingMaxDuration, parse int error value:"
            r4.append(r5)
            r3 = r3[r1]
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.String r4 = "CommonVideoMode"
            com.oplus.camera.CameraLog.m12967f(r4, r3)
            return r0
        L53:
            int r1 = r1 + 1
            goto L1c
        L56:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.CommonVideoMode.getRecordingMaxDuration(java.lang.String, java.lang.String):int");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean supportBeautyButton() {
        if (isRearSuperEISOpen()) {
            return false;
        }
        return super.supportBeautyButton();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean checkPreviewResult(CameraApsDecision cameraApsDecision) {
        if (m12327W()) {
            return super.checkPreviewResult(cameraApsDecision);
        }
        return true;
    }

    /* renamed from: W */
    private boolean m12327W() {
        if (getSupportFunction(CameraFunction.KEY_VIDEO_SUPER_EIS_PROCESS) || isSloganOpen()) {
            return true;
        }
        return (isHighFps() || is4k120fps() || (!is4k() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_LOW_FPS_PREVIEW_PROCESS_BY_APS))) ? false : true;
    }
}
