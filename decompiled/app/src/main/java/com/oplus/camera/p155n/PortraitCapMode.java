package com.oplus.camera.p155n;

import android.app.Activity;
import android.content.SharedPreferences;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.MotionEvent;
import androidx.preference.PreferenceManager;
import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.PolarrRender;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.constant.CameraUnitKeys;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.p173a.HintManager;
import com.oplus.camera.p172ui.p173a.HintModel;
import com.oplus.camera.p172ui.preview.p177a.FaceBeautyHelp;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.ReminderMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPreviewCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PortraitCapMode.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_11.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class PortraitCapMode extends BaseMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f14725g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f14726h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f14727i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f14728j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f14729k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f14730l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f14731m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f14732n;

    /* renamed from: o */
    private int f14733o;

    /* renamed from: p */
    private int f14734p;

    /* renamed from: q */
    private String f14735q;

    /* renamed from: r */
    private boolean f14736r;

    /* renamed from: s */
    private boolean f14737s;

    /* renamed from: t */
    private Handler f14738t;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String m14757h() {
        return "default";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getBlurMenuKeyByMode() {
        return CameraUIInterface.KEY_PORTRAIT_BLUR_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return "portrait";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getExpectedFrameRate() {
        return 24;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getFaceBeautyKey() {
        return CameraUIInterface.KEY_PORTRAIT_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getFaceBeautyModeIndex() {
        return 2;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFilterTitleTexId() {
        return R.string.camera_fuji_style;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void hideViewWhileResume() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void resetMonoFilter() {
    }

    public PortraitCapMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f14725g = false;
        this.f14726h = true;
        this.f14727i = false;
        this.f14728j = false;
        this.f14729k = false;
        this.f14730l = false;
        this.f14731m = -1;
        this.f14732n = -1.0f;
        this.f14733o = FilterHelper.f21279a;
        this.f14734p = 0;
        this.f14735q = "";
        this.f14736r = false;
        this.f14737s = false;
        this.f14738t = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.OplusGLSurfaceView_11.PlatformImplementations.kt_3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1 && PortraitCapMode.this.f14727i) {
                    PortraitCapMode.this.f14726h = true;
                    PortraitCapMode c2814a = PortraitCapMode.this;
                    c2814a.m14721a(c2814a.f14731m, false);
                }
            }
        };
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getEnvironmentTipsThreshold() {
        if (this.mbFrontCamera) {
            return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SUPPORT_FRONT_DARK_TIPS_THRESHOLD);
        }
        return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SUPPORT_BACK_DARK_TIPS_THRESHOLD);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        if ((this.mCameraInterface == null || !this.mCameraInterface.mo10575i()) && !isNeonEnable() && (Util.m24169C() || !isStreamerEnable())) {
            return 1;
        }
        return super.getDefaultCaptureNumber();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getPreviewStreamNum() {
        if (getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA)) {
            return m14747e() ? 1 : 2;
        }
        return super.getPreviewStreamNum();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCaptureStreamNum() {
        if (getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA)) {
            return 2;
        }
        return super.getCaptureStreamNum();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFilterNoneIndex() {
        return this.mbFrontCamera ? FilterHelper.m22643q() : FilterHelper.m22642p();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        super.setOrientation(OplusGLSurfaceView_13);
        PolarrRender.updateGlobalScreenOrientation(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isBackPortraitCameraSwitching() {
        return this.f14728j;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCameraPermissionGranted() {
        FilterHelper.m22627c();
        m14739c();
        m14759i();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m14739c() {
        if (this.mPreferences instanceof ComboPreferences) {
            if (FilterHelper.f21319i.f21250d.size() == FilterHelper.f21319i.f21249c.size() && -1 == FilterHelper.m22634h() && -1 == FilterHelper.m22635i() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_NEON_SUPPORT) == CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_NEON_FRONT_SUPPORT) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_STREAMER_SUPPORT)) {
                ((ComboPreferences) this.mPreferences).m11076c(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_INDEX);
            } else {
                ((ComboPreferences) this.mPreferences).m11077d(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_INDEX);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA) ? (m14751f() || m14755g()) ? 32784 : 32785 : CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_SINGLE_BLUR_OPERATING) ? 32806 : 32769;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        CameraLog.m12954a("PortraitCapMode", "onInitCameraMode");
        this.f14736r = false;
        this.f14737s = false;
        this.f14735q = "";
        if (!InverseManager.INS.isInverseColor(this.mActivity.hashCode())) {
            this.mCameraUIInterface.mo18108a(false, true, true);
        }
        this.mCameraUIInterface.mo18187c(this.mActivity.getString(R.string.camera_description_common_shutter_button));
        this.f14727i = getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA);
        this.f14729k = m14769b();
        FilterHelper.m22627c();
        m14739c();
        m14759i();
        PolarrRender.updateGlobalScreenOrientation(this.mOrientation);
        if (this.f14729k) {
            m14766a("on");
        } else {
            m14766a("off");
        }
        m14744d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m14744d() {
        HintManager c3130aMo18233k = this.mCameraUIInterface.mo18233k();
        if (c3130aMo18233k != null) {
            c3130aMo18233k.m18484a(new HintManager.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.OplusGLSurfaceView_11.PlatformImplementations.kt_3.2
                @Override // com.oplus.camera.p172ui.p173a.HintManager.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo14771a(HintModel c3131b) {
                    if (R.string.camera_toast_unfold_palm_shutter == c3131b.f17456a) {
                        PortraitCapMode.this.f14730l = true;
                    }
                }

                @Override // com.oplus.camera.p172ui.p173a.HintManager.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo14770a(int OplusGLSurfaceView_13) {
                    if (R.string.camera_toast_unfold_palm_shutter == OplusGLSurfaceView_13) {
                        PortraitCapMode.this.f14730l = false;
                    }
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        CameraLog.m12954a("PortraitCapMode", "onDeInitCameraMode");
        boolean z = false;
        this.f14737s = false;
        updateFaceBeautyLevel(0, false);
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18067a(R.string.camera_half_body_better);
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22834g(0);
        }
        Handler handler = this.f14738t;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.mCameraInterface != null && !getSupportFunction(CameraUIInterface.KEY_TORCH_MODE)) {
            this.mCameraInterface.mo10465U();
            if (this.f14729k) {
                m14766a("on");
            } else {
                m14766a("off");
            }
        }
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18108a(true, false, true);
        }
        this.f14732n = -1.0f;
        if (2 == this.f14734p && m14746d(this.f14733o)) {
            z = true;
        }
        m14736b(z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMenuOptionAdded(String str) {
        CameraLog.m12954a("PortraitCapMode", "onMenuOptionAdded, key: " + str);
        if (CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU.equals(str) && this.mCameraUIInterface.mo18140ad()) {
            this.mCameraUIInterface.mo18102a(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU, true, (int) this.mActivity.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.mActivity.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_y));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFilterRedpotKey(String str) {
        if ("neon-2020.cube.rgb.bin".equals(str) && PreferenceManager.m3981a(this.mActivity).getBoolean("portrait_filter_neon_new", true)) {
            return "portrait_filter_neon_new";
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFilterMenuClicked() {
        if (this.mCameraUIInterface.mo18140ad()) {
            this.mCameraUIInterface.mo18102a(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU, false, (int) this.mActivity.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_x), (int) this.mActivity.getResources().getDimension(R.dimen.multicamera_setting_menu_reddot_offset_y));
            PreferenceManager.m3981a(this.mActivity).edit().putBoolean("portrait_filter_reddot_show", false).apply();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        CameraLog.m12954a("PortraitCapMode", "onResume");
        this.f14726h = getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA);
        PolarrRender.updateGlobalScreenOrientation(this.mOrientation);
        m14759i();
        if (this.mCameraEntry.m13339c() || this.mCameraEntry.m13327T()) {
            if (this.f14729k) {
                m14766a("on");
            } else {
                m14766a("off");
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        if (!getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SINGLE_CAMERA_USE_COMMOM_PORTRAIT_PREVIEW_SIZE)) {
            return super.getPreviewSize(c2698h);
        }
        if (this.mbFrontCamera) {
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_FRONT_PORTRAIT_PREVIEW_SIZE);
        }
        return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_REAR_PORTRAIT_PREVIEW_SIZE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h, String str) {
        double dM24196X;
        if ("type_sub_preview_frame".equals(str) && !Util.m24169C()) {
            List<Size> listM13258a = c2698h.m13258a(538982489);
            String strM24248a = Util.m24248a(getPictureSize(c2698h), this.mCameraId);
            if (DcsMsgData.FULL.equals(strM24248a)) {
                dM24196X = Util.m24196X();
            } else if ("16_9".equals(strM24248a)) {
                dM24196X = 1.7777777777777777d;
            } else {
                dM24196X = "square".equals(strM24248a) ? 1.0d : 1.3333333333333333d;
            }
            CameraLog.m12954a("PortraitCapMode", "getPreviewSize, depth size list: " + listM13258a);
            return Util.m24236a(listM13258a, dM24196X, 538982489);
        }
        return super.getPreviewSize(c2698h, str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        if (!getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA)) {
            List<Size> listM13258a = c2698h.m13258a(256);
            Size sizeM24378b = null;
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_FRONT_MAX_SIZE_SUPPORT)) {
                sizeM24378b = Util.m24378b(listM13258a, 1.3333333333333333d);
            } else {
                Size sizeM24239a = Util.m24239a(listM13258a, BaseMode.PICTURE_SIZE_8M, 0);
                if (sizeM24239a != null) {
                    sizeM24378b = sizeM24239a;
                }
            }
            if (sizeM24378b != null) {
                CameraLog.m12959b("PortraitCapMode", "getPictureSize, width: " + sizeM24378b.getWidth() + ", height: " + sizeM24378b.getHeight());
                return sizeM24378b;
            }
        }
        if (this.mbFrontCamera) {
            Size sizeConfigValue = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_FRONT_PORTRAIT_NORMAL_MODE_PIC_SIZE);
            if (sizeConfigValue != null) {
                CameraLog.m12959b("PortraitCapMode", "getPictureSize, front size: " + sizeConfigValue.getWidth() + "x" + sizeConfigValue.getHeight());
            }
            return sizeConfigValue;
        }
        Size surfaceSize = getSurfaceSize("type_still_capture_yuv_main", c2698h);
        if (surfaceSize != null) {
            CameraLog.m12959b("PortraitCapMode", "getPictureSize, use surfaceSize, rear size: " + surfaceSize.getWidth() + "x" + surfaceSize.getHeight());
            return surfaceSize;
        }
        Size sizeConfigValue2 = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_BACK_PORTRAIT_NORMAL_MODE_PIC_SIZE);
        if (sizeConfigValue2 != null) {
            CameraLog.m12959b("PortraitCapMode", "getPictureSize, rear size: " + sizeConfigValue2.getWidth() + "x" + sizeConfigValue2.getHeight());
        }
        return sizeConfigValue2;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected float getBlurValue() {
        return getBlurValue(m14748e(getCurrFilterIndex()) ? 100 : getBlurIndex());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isBlurOpen() {
        return getSupportFunction(CameraFunction.BOKEH) || getSupportFunction(CameraFunction.FACE_BLUR);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isStreamerOpen() {
        return m14768a(getCurrFilterIndex());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01b2  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 1422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p155n.PortraitCapMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFilterOpen(String str) {
        return ("portrait_retention".equals(str) || "portrait_streamer".equals(str) || (this.mbFrontCamera && "neon-2020.cube.rgb.bin".equals(str)) || !super.isFilterOpen(str)) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        CameraLog.m12967f("PortraitCapMode", "onStop");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public List<String> onGetSupportSettingList(String str, int OplusGLSurfaceView_13) {
        if (CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            List<String> supportedList = CameraConfig.getSupportedList(CameraUIInterface.KEY_PHOTO_RATIO, OplusGLSurfaceView_13);
            ArrayList arrayList = new ArrayList();
            if (supportedList != null && supportedList.contains("standard")) {
                arrayList.add("standard");
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        }
        return super.onGetSupportSettingList(str, OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        if (((this.mCameraInterface == null || !this.mCameraInterface.mo10575i()) && !Util.m24169C()) || !((30 == this.mApsDecisionFeatureType || 34 == this.mApsDecisionFeatureType) && AlgoSwitchConfig.getSupportCaptureAlgo(getCameraMode(), this.mCameraId, CameraUnitKeys.ALGO_NAME_SINGLE_PORTRAIT))) {
            return super.getZSLMode();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        String strM13305d = CameraEntry.m13305d(str);
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(strM13305d) || CameraUIInterface.KEY_SETTING.equals(strM13305d)) {
            return getSupportFunction(strM13305d);
        }
        if (CameraUIInterface.KEY_PORTRAIT_BLUR_MENU.equals(strM13305d)) {
            return (getSupportFunction(CameraFunction.BOKEH) || getSupportFunction(CameraFunction.FACE_BLUR)) && !m14746d(getCurrFilterIndex()) && !m14748e(getCurrFilterIndex()) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_BLUR_LEVEL_ENABLE);
        }
        return super.getSupportMenu(strM13305d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int OplusGLSurfaceView_13) {
        CameraLog.m12967f("PortraitCapMode", "onCameraIdChanged");
        m14736b(2 == this.f14734p && this.mbFrontCamera && isMonoIndex(this.f14733o));
        m14759i();
        this.f14735q = "";
        super.cameraIdChanged(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        CameraLog.m12954a("PortraitCapMode", "onPause");
        Handler handler = this.f14738t;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        boolean z = false;
        if (this.mCameraUIInterface != null && this.mCameraInterface.mo10575i()) {
            this.mCameraUIInterface.mo18092a(getShutterButtonInfo(), false);
        }
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10465U();
        }
        this.f14735q = "";
        this.f14736r = false;
        this.f14726h = false;
        this.f14728j = false;
        this.f14737s = false;
        this.mCameraEntry.m13361y();
        if (2 == this.f14734p && m14746d(this.f14733o)) {
            z = true;
        }
        m14736b(z);
        if (this.mCameraInterface == null || this.mCameraInterface.mo10544at() || !this.mCameraEntry.m13339c()) {
            return;
        }
        if (this.f14729k) {
            m14766a("on");
        } else {
            m14766a("off");
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        CameraLog.m12954a("PortraitCapMode", "onDestroy");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        if (Util.m24352ao()) {
            if (this.mCameraUIInterface.mo18265s() == 28 || this.mCameraUIInterface.mo18265s() == 29) {
                shutterButtonInfo.m19226a(26);
            } else {
                shutterButtonInfo.m19226a(23);
            }
        }
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        CameraLog.m12954a("PortraitCapMode", "onBeforePreview");
        if (this.mCameraUIInterface != null && !"portrait_streamer".equals(this.f14735q)) {
            this.mCameraUIInterface.mo18067a(R.string.camera_half_body_better);
        }
        updateRearAicolorEnable(false, m14752f(getCurrFilterIndex()));
        this.f14736r = false;
        if (this.f14728j) {
            this.f14728j = false;
            m14732a(getFilterType(this.f14733o), false);
        }
        if (getSupportFunction(CameraFunction.FACE_BEAUTY_PROCESS)) {
            int faceBeautyCurrIndex = getFaceBeautyCurrIndex();
            CameraLog.m12954a("PortraitCapMode", "onBeforePreview, level: " + faceBeautyCurrIndex);
            updateFaceBeautyLevel(faceBeautyCurrIndex, false);
            updateCustomBeautyValues(getCustomBeautyValues());
            if (this.mPreviewEffectProcess != null) {
                this.mPreviewEffectProcess.mo22834g(faceBeautyCurrIndex);
                this.mPreviewEffectProcess.mo22798a(getCustomBeautyValues());
                return;
            }
            return;
        }
        updateFaceBeautyLevel(0, false);
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22834g(0);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String[] getCustomBeautyKeys() {
        return getCurrentKeys(CameraUIInterface.KEY_PORTRAIT_CUSTOM_BEAUTY);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String[] getMakeupKeys() {
        return getCurrentKeys(FaceBeautyHelp.f21229d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getMakeupTypeKey() {
        return CameraEntry.m13302b(this.mCameraEntryType) ? CameraEntry.m13299b(CameraUIInterface.KEY_PORTRAIT_MAKEUP_TYPE, this.mCameraEntryType) : CameraUIInterface.KEY_PORTRAIT_MAKEUP_TYPE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getMakeupOpenState() {
        if (Util.m24169C()) {
            return super.getMakeupOpenState();
        }
        return 3;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean getSupportShowCustomAll() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MAKEUP_LOW_PERFORMANCE) && this.mCameraInterface.mo10575i()) {
            return false;
        }
        return super.getSupportShowCustomAll();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isFaceBeautyOrMakeupOpen() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_BOKEH_BEAUTY_SUPPORT) || !getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA)) {
            return super.isFaceBeautyOrMakeupOpen();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getDefaultCommonBeautyValue() {
        if (isFaceBeautyDefaultOff()) {
            return 0;
        }
        return (this.mbFrontCamera || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_BOKEH_BEAUTY_OPEN_DEFAULT)) ? 40 : 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        CameraLog.m12954a("PortraitCapMode", "onBeforeSnapping");
        if (!this.mCameraInterface.mo10575i() && this.mCameraUIInterface.mo18265s() == 1) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.OplusGLSurfaceView_11.PlatformImplementations.kt_3.3
                @Override // java.lang.Runnable
                public void run() {
                    if (PortraitCapMode.this.mbPaused) {
                        CameraLog.m12954a("PortraitCapMode", "onBeforeSnapping, return after pause");
                        return;
                    }
                    MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
                    c3200b.m19227a("button_color_inside_none");
                    c3200b.m19226a(4);
                    PortraitCapMode.this.mCameraUIInterface.mo18091a(c3200b);
                }
            });
        }
        if (8 == c2693c.f13385N.mApsDecisionFeatureType || 30 == c2693c.f13385N.mApsDecisionFeatureType || 34 == c2693c.f13385N.mApsDecisionFeatureType) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) true);
            this.mbResetAwbLockAfterCaptured = true;
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        super.onAfterStartPreview(z);
        if (this.f14736r) {
            return;
        }
        this.f14737s = false;
        this.f14736r = true;
        this.f14731m = -1;
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.OplusGLSurfaceView_11.PlatformImplementations.kt_3.4
            @Override // java.lang.Runnable
            public void run() {
                if (PortraitCapMode.this.mbPaused) {
                    return;
                }
                if (PortraitCapMode.this.mCameraUIInterface != null && "portrait_streamer".equals(PortraitCapMode.this.f14735q)) {
                    PortraitCapMode.this.mCameraUIInterface.mo18070a(R.string.camera_half_body_better, -1, true, false, false);
                }
                PortraitCapMode.this.onUpdateCameraSettingMenu();
                PortraitCapMode c2814a = PortraitCapMode.this;
                c2814a.f14727i = c2814a.getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA);
                if (PortraitCapMode.this.f14727i) {
                    PortraitCapMode.this.f14738t.removeMessages(1);
                    PortraitCapMode.this.f14738t.sendEmptyMessageDelayed(1, 400L);
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z) {
        MainShutterButtonInfo shutterButtonInfo = getShutterButtonInfo();
        if (z) {
            shutterButtonInfo.m19226a(Util.m24352ao() ? 23 : 8);
            shutterButtonInfo.m19227a("button_color_inside_none");
        } else {
            shutterButtonInfo.m19226a(Util.m24352ao() ? 23 : 11);
            shutterButtonInfo.m19227a("button_color_inside_none");
        }
        this.mCameraUIInterface.mo18091a(shutterButtonInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14734b(int OplusGLSurfaceView_13) {
        if (this.f14726h) {
            this.mCameraUIInterface.mo18070a(OplusGLSurfaceView_13, 0, false, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m14728a(boolean z) {
        this.mCameraUIInterface.mo18108a(true, false, z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z, boolean z2) {
        super.onShutterCallback(z, z2);
        if (z2) {
            this.mCameraInterface.mo10558c(0);
            this.mCameraInterface.mo10572h();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z) {
        CameraLog.m12962c("PortraitCapMode", "onBeforePictureTaken");
        if (this.mbPaused) {
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        CameraLog.m12954a("PortraitCapMode", "onAfterPictureTaken");
        if (this.mCameraInterface.mo10575i()) {
            if (!getZSLMode()) {
                this.mCameraInterface.mo10584n();
            }
            this.mCameraUIInterface.mo18200d(true, false);
        }
        this.mCameraUIInterface.mo18092a(getShutterButtonInfo(), false);
        resetAeLockAfterCaptured();
        resetAwbLockAfterCaptured();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(String str) {
        if (CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return false;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int OplusGLSurfaceView_13, boolean z) {
        super.changeModeAllViewWhenAnimation(OplusGLSurfaceView_13, z);
        if (OplusGLSurfaceView_13 != 4) {
            if (OplusGLSurfaceView_13 == 5) {
                this.f14726h = z;
                if (z) {
                    if (this.mCameraUIInterface.mo18265s() == 4) {
                        this.mCameraUIInterface.mo18092a(getShutterButtonInfo(), false);
                    }
                } else {
                    this.mCameraUIInterface.mo18108a(true, false, false);
                }
            } else if (OplusGLSurfaceView_13 == 18 && !z) {
                this.f14726h = false;
                Handler handler = this.f14738t;
                if (handler != null) {
                    handler.removeMessages(1);
                }
                this.mCameraUIInterface.mo18108a(true, false, true);
            }
        } else if (this.f14727i) {
            m14721a(0, false);
        }
        if (4 == OplusGLSurfaceView_13 || 7 == OplusGLSurfaceView_13 || 8 == OplusGLSurfaceView_13 || 9 == OplusGLSurfaceView_13 || z || 3 == OplusGLSurfaceView_13) {
            return;
        }
        this.f14726h = false;
        Handler handler2 = this.f14738t;
        if (handler2 != null) {
            handler2.removeMessages(1);
        }
        this.mCameraUIInterface.mo18108a(true, false, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void resetMetadataBokehCode() {
        if (CameraEntry.m13302b(this.mCameraEntryType)) {
            this.f14731m = -1;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFilterItemChange(int OplusGLSurfaceView_13) {
        if (m14729a(this.f14733o, OplusGLSurfaceView_13)) {
            this.f14728j = true;
        } else {
            this.f14728j = false;
        }
        if (this.mPreviewEffectProcess != null) {
            String filterType = getFilterType(OplusGLSurfaceView_13);
            String filterRedpotKey = getFilterRedpotKey(filterType);
            if (filterRedpotKey != null) {
                this.mCameraUIInterface.mo18238l(OplusGLSurfaceView_13);
                PreferenceManager.m3981a(this.mActivity).edit().putBoolean(filterRedpotKey, false).apply();
            }
            this.f14737s = m14732a(filterType, true);
        }
        super.onFilterItemChange(OplusGLSurfaceView_13);
        if (this.f14737s) {
            this.f14737s = this.f14728j;
            updateBlurValue();
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.OplusGLSurfaceView_11.PlatformImplementations.kt_3.5
                @Override // java.lang.Runnable
                public void run() {
                    PortraitCapMode.this.mCameraUIInterface.mo18258q();
                }
            });
        }
        if (this.mbFrontCamera || this.f14733o == OplusGLSurfaceView_13) {
            return;
        }
        if (this.f14728j) {
            this.f14726h = false;
            m14728a(true);
            this.mCameraInterface.mo10468X();
            m14736b(2 == this.f14734p && m14746d(this.f14733o));
        }
        this.f14733o = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateFilterParam(int OplusGLSurfaceView_13) {
        if (this.mPreviewEffectProcess != null) {
            if (isVividEffectOpen() && OplusGLSurfaceView_13 != FilterHelper.f21279a) {
                forceCloseVividEffect();
            }
            String filterType = getFilterType(OplusGLSurfaceView_13);
            if (!this.f14728j) {
                m14732a(filterType, false);
            }
            if (this.mOneCamera != null) {
                this.mOneCamera.mo13046a(filterType, isFilterOpen(filterType), false);
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.PORTRAIT_NEON_ENABLE, (CameraParameter.PreviewKey<String>) (isNeonEnable() ? "on" : "off"));
                return;
            } else {
                CameraLog.m12967f("PortraitCapMode", "updateFilterParam, mOneCamera is null ! ");
                return;
            }
        }
        CameraLog.m12967f("PortraitCapMode", "updateFilterParam, mPreviewEffectProcess: " + this.mPreviewEffectProcess + ", mPreferences: " + this.mPreferences);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected List<Integer> getFilterNameIdList(int OplusGLSurfaceView_13) {
        if (getSupportFunction(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU)) {
            return FilterHelper.f21319i.m22566b(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
        }
        return super.getFilterNameIdList(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected List<String> getFilterTypeList(int OplusGLSurfaceView_13) {
        if (getSupportFunction(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU)) {
            return FilterHelper.f21319i.m22561a(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
        }
        return super.getFilterTypeList(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return getSupportFunction(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU) ? CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_INDEX : super.getFilterEffectMenuPreferenceKey();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFilterType(int OplusGLSurfaceView_13) {
        return getFilterTypeList(this.mCameraId).get(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateHintView() {
        m14721a(this.f14731m, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        int iIntValue;
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null) {
            CameraLog.m12967f("PortraitCapMode", "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
        if (this.f14726h && getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA)) {
            if (2 == AlgoSwitchConfig.getApsVersion() || m14747e()) {
                iIntValue = m14720a(captureResult);
            } else {
                iIntValue = cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_BOKEN_STATE) != null ? ((Integer) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_BOKEN_STATE)).intValue() : -1;
            }
            if (this.f14731m != iIntValue) {
                CameraLog.m12954a("PortraitCapMode", "onPreviewCaptureResult, bokehState: " + this.f14731m + " > " + iIntValue);
                this.f14731m = iIntValue;
                m14721a(this.f14731m, true);
            }
        }
        if (this.mOneCamera.mo13061a((CaptureResult.Key<?>) CameraMetadataKey.f13292ae, captureResult) != null && Float.compare(r6[0], 0.0f) > 0) {
            this.f14732n = 1000.0f / r6[0];
        }
        if ("portrait_retention".equals(this.f14735q) || "portrait_streamer".equals(this.f14735q) || "neon-2020.cube.rgb.bin".equals(this.f14735q)) {
            processFaceCount();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m14720a(CaptureResult captureResult) {
        Object objM13005a = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13298ak);
        if (objM13005a == null || !(objM13005a instanceof int[])) {
            return -1;
        }
        return ((int[]) objM13005a)[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14740c(int OplusGLSurfaceView_13) {
        if (7 == OplusGLSurfaceView_13 && 2 != this.f14734p) {
            this.f14734p = 2;
            if (!m14746d(this.f14733o) || this.mPreviewEffectProcess == null) {
                return;
            }
            String strM14757h = m14757h();
            this.mPreviewEffectProcess.mo22792a(strM14757h);
            this.mCameraUIInterface.mo18076a(this.f14733o, strM14757h);
            m14767a(true, this.f14733o);
            return;
        }
        if (7 == OplusGLSurfaceView_13 || 1 == this.f14734p) {
            return;
        }
        this.f14734p = 1;
        if (!m14746d(this.f14733o) || this.mPreviewEffectProcess == null) {
            return;
        }
        String strM14753g = m14753g(this.f14733o);
        this.mPreviewEffectProcess.mo22792a(strM14753g);
        this.mCameraUIInterface.mo18076a(this.f14733o, strM14753g);
        m14767a(false, this.f14733o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m14721a(final int OplusGLSurfaceView_13, final boolean z) {
        if (this.mActivity == null) {
            return;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.OplusGLSurfaceView_11.PlatformImplementations.kt_3.6
            @Override // java.lang.Runnable
            public void run() {
                if (PortraitCapMode.this.mbPaused) {
                    return;
                }
                if (PortraitCapMode.this.mCameraUIInterface.mo18059T() || PortraitCapMode.this.mCameraUIInterface.mo18057R()) {
                    if (z) {
                        PortraitCapMode.this.m14740c(OplusGLSurfaceView_13);
                        return;
                    }
                    return;
                }
                switch (OplusGLSurfaceView_13) {
                    case 1:
                        if (!PortraitCapMode.this.getSupportFunction(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER) || !PortraitCapMode.this.f14730l) {
                            PortraitCapMode.this.m14728a(true);
                            break;
                        }
                        break;
                    case 2:
                        if (!PortraitCapMode.this.getSupportFunction(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER) || !PortraitCapMode.this.f14730l) {
                            PortraitCapMode.this.m14734b(R.string.camera_bokeh_move_farther_away);
                        }
                        PortraitCapMode.this.m14726a("bokeh_code", String.valueOf(2));
                        break;
                    case 3:
                        PortraitCapMode.this.m14734b(R.string.camera_bokeh_move_closer);
                        PortraitCapMode.this.m14726a("bokeh_code", String.valueOf(3));
                        break;
                    case 4:
                        PortraitCapMode.this.m14734b(R.string.camera_id_photo_mode_need_more_light);
                        PortraitCapMode.this.m14726a("bokeh_code", String.valueOf(4));
                        break;
                    case 5:
                        PortraitCapMode.this.m14734b(R.string.camera_bokeh_place_subject_not_found);
                        PortraitCapMode.this.m14726a("bokeh_code", String.valueOf(5));
                        break;
                    case 6:
                    case 8:
                    default:
                        PortraitCapMode.this.m14728a(true);
                        break;
                    case 7:
                        PortraitCapMode.this.m14734b(R.string.camera_bokeh_camera_do_not_occlusion);
                        PortraitCapMode.this.m14727a("bokeh_code", String.valueOf(7), PortraitCapMode.this.getCurrFilterType());
                        break;
                    case 9:
                        PortraitCapMode.this.m14734b(R.string.camera_bokeh_single);
                        PortraitCapMode.this.m14726a("bokeh_code", String.valueOf(9));
                        break;
                    case 10:
                        PortraitCapMode.this.m14734b(R.string.camera_bokeh_camera_do_not_occlusion);
                        PortraitCapMode.this.m14727a("bokeh_code", String.valueOf(10), PortraitCapMode.this.getCurrFilterType());
                        break;
                }
                if (z) {
                    PortraitCapMode.this.m14740c(OplusGLSurfaceView_13);
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        CaptureMsgData captureMsgData = (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) ? null : (CaptureMsgData) dcsMsgData;
        if (captureMsgData == null) {
            return null;
        }
        captureMsgData.mBokehCode = this.f14731m;
        return captureMsgData;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m14747e() {
        return !this.mbFrontCamera && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_BACK_PURE_3RD_BOKEH_PREVIEW);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if ("type_sub_preview_frame".equals(str)) {
            return 3 == AlgoSwitchConfig.getApsVersion() && getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA) && !m14747e();
        }
        if ("type_preview_frame".equals(str)) {
            return getSupportFunction(CameraFunction.FACE_BLUR) || getSupportFunction(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER);
        }
        if ("type_still_capture_yuv_sub".equals(str)) {
            return getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA);
        }
        if ("type_still_capture_jpeg".equals(str)) {
            return !AlgoSwitchConfig.getSupportApsCapture();
        }
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getPhotoRatio() {
        return this.mActivity.getString(R.string.camera_picture_size_standard);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m14726a(String str, String str2) {
        m14727a(str, str2, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m14727a(String str, String str2, String str3) {
        ReminderMsgData reminderMsgData = new ReminderMsgData(this.mActivity, true);
        if (this.mCameraInterface != null) {
            if (!this.mCameraInterface.mo10575i()) {
                reminderMsgData.mCameraEnterType = String.valueOf(2);
            }
            reminderMsgData.mCameraId = this.mCameraInterface.mo10547aw();
        }
        reminderMsgData.mCaptureMode = getCameraMode();
        reminderMsgData.mCaptureType = 0;
        reminderMsgData.mOrientation = this.mOrientation;
        reminderMsgData.mPortraitNewStyleType = str3;
        reminderMsgData.mReminderTypeValue = str;
        reminderMsgData.mReminderCodeValue = str2;
        reminderMsgData.mRearOrFront = this.mbFrontCamera ? DcsMsgData.FRONT : DcsMsgData.REAR;
        reminderMsgData.report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getEffectMenuKeyByMode() {
        return CameraEntry.m13299b(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU, this.mCameraEntryType);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (CameraUIInterface.KEY_PORTRAIT_HALF_BODY.equals(str) && !this.mbForbidPreferenceChange) {
            if (this.mCameraInterface != null) {
                this.mCameraInterface.mo10545au();
            }
        } else if (CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC.equals(str) && !this.mbForbidPreferenceChange) {
            if (this.mCameraInterface != null) {
                this.mCameraInterface.mo10546av();
            }
        } else {
            if (CameraUIInterface.KEY_CAMERA_ID.equals(str)) {
                if (this.f14729k) {
                    m14766a("on");
                    return;
                } else {
                    m14766a("off");
                    return;
                }
            }
            super.onSharedPreferenceChanged(sharedPreferences, str);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11348j(getSupportFunction(CameraUIInterface.KEY_PORTRAIT_HALF_BODY));
        zoomConfigure.m11350k(getSupportFunction(CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC));
        return zoomConfigure;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m14751f() {
        if (!getSupportFunction(CameraUIInterface.KEY_PORTRAIT_HALF_BODY) || this.mPreferences == null) {
            return false;
        }
        return "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_PORTRAIT_HALF_BODY, "off"));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m14755g() {
        if (!getSupportFunction(CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC) || this.mPreferences == null) {
            return false;
        }
        return "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC, "off"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onHomeKeyClick() {
        if (this.mCameraEntry.m13339c()) {
            if (this.f14729k) {
                m14766a("on");
            } else {
                m14766a("off");
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public float getDefaultZoomValue(OplusCameraCharacteristics c2698h) {
        if (32784 == getOperatingMode()) {
            return 2.0f;
        }
        if (c2698h != null) {
            return c2698h.m13263b(getZoomConfigure());
        }
        return 1.0f;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needConfigPhysicalStream(String str) {
        if ("type_main_preview_frame".equals(str)) {
            if (m14747e()) {
                return false;
            }
            return (!Util.m24169C() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA);
        }
        if ("type_sub_preview_frame".equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT) && getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA);
        }
        if ("type_still_capture_yuv_main".equals(str) || "type_still_capture_yuv_sub".equals(str) || "type_tuning_data_yuv".equals(str)) {
            return (!Util.m24169C() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUALCOMM_PHYSICAL_ID_SUPPORT)) && getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA);
        }
        return super.needConfigPhysicalStream(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isMonoIndex(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == FilterHelper.m22634h() || OplusGLSurfaceView_13 == FilterHelper.m22635i();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m14746d(int OplusGLSurfaceView_13) {
        return !this.mbFrontCamera && isMonoIndex(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m14768a(int OplusGLSurfaceView_13) {
        return !this.mbFrontCamera && OplusGLSurfaceView_13 == FilterHelper.m22638l();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m14748e(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == (this.mbFrontCamera ? FilterHelper.m22639m() : FilterHelper.m22640n());
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m14752f(int OplusGLSurfaceView_13) {
        return !this.mbFrontCamera && OplusGLSurfaceView_13 == FilterHelper.m22641o();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14736b(boolean z) {
        if (z && this.mCameraUIInterface != null) {
            CameraUIInterface cameraUIInterface = this.mCameraUIInterface;
            int OplusGLSurfaceView_13 = this.f14733o;
            cameraUIInterface.mo18076a(OplusGLSurfaceView_13, m14753g(OplusGLSurfaceView_13));
            m14767a(false, this.f14733o);
        }
        this.f14734p = 0;
        this.f14731m = -1;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String m14753g(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == FilterHelper.m22634h() ? FilterPackageUtil.PORTRAIT4_1 : OplusGLSurfaceView_13 == FilterHelper.m22635i() ? FilterPackageUtil.PORTRAIT4_3 : "default";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m14767a(boolean z, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("PortraitCapMode", "setIsShelterByIndex, isShelter: " + z + ", index: " + OplusGLSurfaceView_13);
        FilterHelper.f21319i.f21248b.set(OplusGLSurfaceView_13, z ? m14757h() : m14753g(OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m14729a(int OplusGLSurfaceView_13, int i2) {
        return (!this.mbFrontCamera && (isMonoIndex(OplusGLSurfaceView_13) || isMonoIndex(i2))) || m14768a(OplusGLSurfaceView_13) || m14768a(i2);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean disableBokehHDR(CameraApsDecision cameraApsDecision) {
        synchronized (this.mApsDecisionResultLock) {
            boolean z = false;
            if (cameraApsDecision == null) {
                CameraLog.m12954a("PortraitCapMode", "disableBokehHDR, decisionResult null");
                return false;
            }
            if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_BOKEH_HDR)) {
                return false;
            }
            if (1 == getDefaultCaptureNumber() && (12 == cameraApsDecision.mApsDecisionSceneMode || 13 == cameraApsDecision.mApsDecisionSceneMode || 30 == cameraApsDecision.mApsDecisionSceneMode)) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m14732a(String str, boolean z) {
        boolean z2 = false;
        if (this.f14735q.equals(str) || this.mCameraUIInterface == null) {
            return false;
        }
        char c2 = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != -928591791) {
            if (iHashCode != -404148440) {
                if (iHashCode == 205787002 && str.equals("portrait_retention")) {
                    c2 = 0;
                }
            } else if (str.equals("neon-2020.cube.rgb.bin")) {
                c2 = 2;
            }
        } else if (str.equals("portrait_streamer")) {
            c2 = 1;
        }
        if (c2 == 0) {
            this.mPreviewEffectProcess.mo22792a("default");
            this.mPreviewEffectProcess.mo22813b(true);
        } else if (c2 == 1) {
            this.mPreviewEffectProcess.mo22792a("default");
            this.mPreviewEffectProcess.mo22813b(false);
        } else if (c2 == 2) {
            this.mPreviewEffectProcess.mo22792a(this.mbFrontCamera ? "default" : str);
            this.mPreviewEffectProcess.mo22813b(false);
        } else {
            this.mPreviewEffectProcess.mo22792a(str);
            this.mPreviewEffectProcess.mo22813b(false);
        }
        boolean z3 = z && (m14738b("neon-2020.cube.rgb.bin", this.f14735q, str) || m14738b(FilterPackageUtil.PORTRAIT4_1, this.f14735q, str) || m14738b(FilterPackageUtil.PORTRAIT4_3, this.f14735q, str));
        if (z && m14738b("portrait_retention", this.f14735q, str)) {
            z2 = true;
        }
        this.f14735q = str;
        if (!Util.m24169C() && z3 && this.mOneCamera != null) {
            this.mOneCamera.mo13014C(isNeonEnable());
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        if (z2 && !this.mbFrontCamera) {
            updateRearAicolorEnable(true, "portrait_retention".equals(this.f14735q));
        }
        return z3;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m14759i() {
        if (this.mbFrontCamera || this.mPreferences == null) {
            return;
        }
        this.f14733o = this.mPreferences.getInt(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_INDEX, FilterHelper.f21279a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m14738b(String str, String str2, String str3) {
        return (!str.equals(str2) && str.equals(str3)) || (str.equals(str2) && !str.equals(str3));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeonEnable() {
        return "neon-2020.cube.rgb.bin".equals(this.f14735q);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isStreamerEnable() {
        return "portrait_streamer".equals(this.f14735q);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        if ("portrait_streamer".equals(getCurrFilterType())) {
            return ApsConstant.FEATURE_STREAMER_PORTRAIT;
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float m14765a() {
        return CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_PORTRAIT_ZOOM_VALUE_DEFAULT);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m14769b() {
        return Float.compare(2.0f, m14765a()) == 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14766a(String str) {
        if (this.mPreferences != null) {
            if (getSupportFunction(CameraUIInterface.KEY_PORTRAIT_HALF_BODY)) {
                this.mbForbidPreferenceChange = true;
                this.mPreferences.edit().putString(CameraUIInterface.KEY_PORTRAIT_HALF_BODY, str).apply();
                if (this.mCameraInterface != null) {
                    this.mCameraInterface.mo10557c("off".equals(str) ? 1.0f : 2.0f);
                }
                this.mbForbidPreferenceChange = false;
            }
            if (getSupportFunction(CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC)) {
                this.mbForbidPreferenceChange = true;
                this.mPreferences.edit().putString(CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC, str).apply();
                this.mbForbidPreferenceChange = false;
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setConfigureParameter(CameraDeviceConfig.Builder builder) {
        super.setConfigureParameter(builder);
        if (getSupportFunction(CameraUIInterface.KEY_DUAL_CAMERA)) {
            if (m14751f() || m14755g()) {
                builder.setParameter(CameraParameter.PORTAIT_BODY_TYPE, "half_body");
            } else {
                builder.setParameter(CameraParameter.PORTAIT_BODY_TYPE, CameraParameter.PortraitBodyType.FULL_BODY);
            }
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_SINGLE_BLUR_OPERATING)) {
            builder.setParameter(CameraParameter.PORTAIT_BOKEH_TYPE, CameraParameter.BokehType.SINGLE_BOKEH);
        }
        builder.setParameter(CameraParameter.PORTRAIT_STREAMER_ENABLE, isStreamerOpen() ? "on" : "off");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        BaseScreenMode currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode != null && currentScreenMode.mo16631r()) {
            this.mCameraUIInterface.mo18176b(true, true, false, false);
        }
        return super.onSingleTapUp(motionEvent);
    }
}
