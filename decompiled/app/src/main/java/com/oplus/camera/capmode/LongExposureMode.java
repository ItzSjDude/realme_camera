package com.oplus.camera.capmode;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.os.Message;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.longexposure.LongExposureIcon;
import com.oplus.camera.longexposure.LongExposureMenu;
import com.oplus.camera.longexposure.LongExposureSceneItem;
import com.oplus.camera.longexposure.LongExposureTimeControl;
import com.oplus.camera.longexposure.LongExposureListener;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CountDownTimer;
import com.oplus.camera.p172ui.CountUpTimer;
import com.oplus.camera.p172ui.LongExposureCountDownTimer;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraPreviewCallback;
import com.oplus.tblplayer.monitor.ErrorCode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LongExposureMode.java */
/* renamed from: com.oplus.camera.capmode.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class LongExposureMode extends BaseMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Object f12917g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private LongExposureCountDownTimer f12918h;

    /* renamed from: OplusGLSurfaceView_13 */
    private CountUpTimer f12919i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Handler f12920j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f12921k;

    /* renamed from: OplusGLSurfaceView_14 */
    private long f12922l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f12923m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f12924n;

    /* renamed from: o */
    private boolean f12925o;

    /* renamed from: p */
    private LongExposureMenu f12926p;

    /* renamed from: q */
    private LongExposureIcon f12927q;

    /* renamed from: r */
    private RotateImageView f12928r;

    /* renamed from: s */
    private LongExposureTimeControl f12929s;

    /* renamed from: t */
    private LongExposureListener f12930t;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0000. Please report as an issue. */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12500a(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean checkPreviewResult(CameraApsDecision cameraApsDecision) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_LONG_EXPOSURE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        return 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32938;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedShowMenuOnTimeSnapShotEnd() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDelayCloseForCapture() {
        return false;
    }

    public LongExposureMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f12917g = new Object();
        this.f12918h = null;
        this.f12919i = null;
        this.f12920j = null;
        this.f12921k = 0;
        this.f12922l = 0L;
        this.f12923m = false;
        this.f12924n = false;
        this.f12925o = false;
        this.f12926p = null;
        this.f12927q = null;
        this.f12928r = null;
        this.f12929s = null;
        this.f12930t = new LongExposureListener() { // from class: com.oplus.camera.capmode.OplusGLSurfaceView_6.5
            @Override // com.oplus.camera.longexposure.LongExposureListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12538a(LongExposureSceneItem c2806j) {
                CameraLog.m12954a("LongExposureMode", "onSceneMenuItemClick, type：" + c2806j.m14642a());
                LongExposureMode.this.f12929s.m14650b(c2806j.m14642a());
                LongExposureMode.this.f12929s.m14648a(c2806j.m14642a(), true);
                LongExposureMode.this.mPreferences.edit().putInt("pref_long_exposure_effect_type", c2806j.m14642a()).apply();
                if (LongExposureMode.this.mOneCamera != null) {
                    LongExposureMode.this.mOneCamera.mo13114m(c2806j.m14642a());
                    LongExposureMode.this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                }
                LongExposureMode.this.m12513b(c2806j.m14642a());
            }

            @Override // com.oplus.camera.longexposure.LongExposureListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12537a() {
                int iM14616c = LongExposureMode.this.f12926p.m14616c();
                CameraLog.m12954a("LongExposureMode", "onSceneMenuStateClick, type：" + iM14616c);
                LongExposureMode.this.m12509a(true, true);
                LongExposureMode.this.f12929s.m14649a(true);
                LongExposureMode.this.f12929s.m14648a(iM14616c, false);
                LongExposureMode.this.m12514b(true);
                LongExposureMode.this.mCameraUIInterface.mo18232j(true, true);
                LongExposureMode.this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, true).apply();
                LongExposureMode.this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, true);
                LongExposureMode.this.m12524h();
            }
        };
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected List<Integer> getFilterNameIdList(int OplusGLSurfaceView_13) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT)) {
            return FilterHelper.f21324n.f21252f;
        }
        return FilterHelper.f21326p.m22566b(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected List<String> getFilterTypeList(int OplusGLSurfaceView_13) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT)) {
            return FilterHelper.f21324n.m22561a(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
        }
        return FilterHelper.f21326p.m22561a(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCurrFilterIndex() {
        if (this.mPreferences == null) {
            return FilterHelper.f21279a;
        }
        int OplusGLSurfaceView_13 = this.mPreferences.getInt(getFilterEffectMenuPreferenceKey(), getFilterNoneIndex());
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT)) {
            String configStringValue = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_STREET_FILTER_TYPE_DEFAULT);
            List<String> filterTypeList = getFilterTypeList(this.mCameraId);
            if (filterTypeList != null && filterTypeList.contains(configStringValue)) {
                OplusGLSurfaceView_13 = this.mPreferences.getInt(getFilterEffectMenuPreferenceKey(), filterTypeList.indexOf(configStringValue));
            }
        }
        return Util.m24205a(OplusGLSurfaceView_13, 0, getFilterTypeList(this.mCameraId).size() - 1);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        return Util.m24378b(c2698h.m13258a(256), 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() throws Resources.NotFoundException {
        CameraLog.m12954a("LongExposureMode", "onInitCameraMode");
        if (this.mPreferences.getBoolean(CameraUIInterface.KEY_RESTORE_LONG_EXPOSURE_PARAMS, false)) {
            m12521f();
        }
        if (this.f12918h == null) {
            this.f12918h = new LongExposureCountDownTimer(this.mCameraUIInterface, new CountDownTimer.PlatformImplementations.kt_3() { // from class: com.oplus.camera.capmode.OplusGLSurfaceView_6.1
                @Override // com.oplus.camera.p172ui.CountDownTimer.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo12534a(boolean z) {
                    LongExposureMode.this.m12530b();
                }

                @Override // com.oplus.camera.p172ui.CountDownTimer.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo12533a() {
                    if (LongExposureMode.this.mbPaused) {
                        return;
                    }
                    LongExposureMode.this.f12918h.mo20097e();
                }
            });
        }
        if (this.f12919i == null) {
            this.f12919i = new CountUpTimer(this.mCameraUIInterface, new CountUpTimer.PlatformImplementations.kt_3() { // from class: com.oplus.camera.capmode.OplusGLSurfaceView_6.2
                @Override // com.oplus.camera.p172ui.CountUpTimer.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo12536a(boolean z) {
                    LongExposureMode.this.m12530b();
                }

                @Override // com.oplus.camera.p172ui.CountUpTimer.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo12535a() {
                    CameraLog.m12954a("LongExposureMode", "onUpdate");
                    if (LongExposureMode.this.mbPaused) {
                        return;
                    }
                    long jM20111b = LongExposureMode.this.f12919i.m20111b() + 100;
                    if (jM20111b > 360000) {
                        LongExposureMode.this.f12919i.m20110a();
                        return;
                    }
                    if (jM20111b <= 350000 || R.string.long_exposure_keep_phone_steady != LongExposureMode.this.f12921k) {
                        LongExposureMode.this.f12919i.m20115e();
                        return;
                    }
                    LongExposureMode.this.m12524h();
                    LongExposureMode.this.m12502a(R.string.long_exposure_capture_coming_to_an_end, false, 0, 0);
                    LongExposureMode.this.f12919i.m20115e();
                }
            });
        }
        if (this.f12926p == null) {
            this.f12926p = new LongExposureMenu(this.mActivity, this.mPreferences);
            this.f12926p.m14612a(this.f12930t);
        }
        if (this.f12927q == null) {
            this.f12927q = new LongExposureIcon(this.mActivity);
            this.f12927q.m14573a(this.f12930t);
        }
        this.f12927q.m14572a(this.mCameraInterface.mo10591u());
        if (this.f12920j == null) {
            this.f12920j = new Handler() { // from class: com.oplus.camera.capmode.OplusGLSurfaceView_6.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    int OplusGLSurfaceView_13 = message.what;
                    if (OplusGLSurfaceView_13 != 1) {
                        if (OplusGLSurfaceView_13 != 2) {
                            return;
                        }
                        if (LongExposureMode.this.mCameraUIInterface != null && LongExposureMode.this.f12921k != 0) {
                            LongExposureMode.this.mCameraUIInterface.mo18067a(LongExposureMode.this.f12921k);
                        }
                        LongExposureMode.this.f12921k = 0;
                        return;
                    }
                    boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                    int i2 = message.arg1;
                    LongExposureMode.this.m12501a(i2, zBooleanValue, message.arg2);
                    if (zBooleanValue) {
                        return;
                    }
                    LongExposureMode.this.m12500a(i2);
                }
            };
        }
        m12523g();
        m12518e();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        CameraLog.m12954a("LongExposureMode", "onSharedPreferenceChanged, key: " + str);
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int OplusGLSurfaceView_13, boolean z) {
        super.changeModeAllViewWhenAnimation(OplusGLSurfaceView_13, z);
        CameraLog.m12954a("LongExposureMode", "changeModeAllViewWhenAnimation, animationType: " + OplusGLSurfaceView_13 + ", isShow: " + z);
        if (OplusGLSurfaceView_13 != 3) {
            if (OplusGLSurfaceView_13 == 18 && z && !isLongExposureSceneMenuOpen()) {
                m12510a(false, false, false);
                return;
            }
            return;
        }
        if (z) {
            this.f12928r.setVisibility(0);
            m12510a(false, false, true);
            this.mCameraUIInterface.mo18240l(true, false);
            m12502a(this.f12926p.m14618d(), false, 0, 0);
            return;
        }
        this.f12928r.setVisibility(8);
        if (isLongExposureSceneMenuOpen()) {
            m12508a(true);
            this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
            this.f12929s.m14651b(true);
        } else {
            m12509a(true, false);
            m12524h();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z) {
        MainShutterButtonInfo shutterButtonInfo = getShutterButtonInfo();
        shutterButtonInfo.m19230b(0);
        this.mCameraUIInterface.mo18091a(shutterButtonInfo);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12508a(boolean z) {
        CameraLog.m12954a("LongExposureMode", "hideLongExposureMenu");
        LongExposureMenu c2803g = this.f12926p;
        if (c2803g != null) {
            c2803g.m14613a(false);
            this.f12926p.m14614b(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12514b(boolean z) {
        LongExposureMenu c2803g;
        CameraLog.m12954a("LongExposureMode", "showLongExposureMenu  isMoreModeShown: " + this.mCameraUIInterface.mo18057R());
        if (this.mCameraUIInterface.mo18057R() || this.mCameraUIInterface.mo18023A() || (c2803g = this.f12926p) == null) {
            return;
        }
        c2803g.m14613a(true);
        this.f12926p.m14617c(z);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m12518e() {
        if (this.f12929s == null) {
            this.f12929s = new LongExposureTimeControl(this.mActivity, this.mPreferences, this.f12920j, this.mCameraInterface, this.mCameraUIInterface);
            this.f12929s.m14647a(this.f12926p.m14616c());
        }
        this.f12929s.m14653d(this.mCameraInterface.mo10591u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12509a(boolean z, boolean z2) {
        CameraLog.m12954a("LongExposureMode", "hideLongExposureIcon");
        LongExposureIcon c2800d = this.f12927q;
        if (c2800d != null) {
            c2800d.m14575a(z, z2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12510a(boolean z, boolean z2, boolean z3) {
        LongExposureIcon c2800d;
        CameraLog.m12954a("LongExposureMode", "showLongExposureIcon, isMoreModeShown: " + this.mCameraUIInterface.mo18057R());
        if (this.mCameraUIInterface.mo18057R() || this.mCameraUIInterface.mo18023A() || (c2800d = this.f12927q) == null) {
            return;
        }
        c2800d.m14576a(z, z2, z3);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        CameraLog.m12954a("LongExposureMode", "onBeforePreview");
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13114m(this.f12926p.m14616c());
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean supportBeautyButton() {
        if (isLongExposureSceneMenuOpen()) {
            return false;
        }
        return super.supportBeautyButton();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m12521f() {
        this.mPreferences.edit().remove("pref_long_exposure_effect_type").apply();
        this.mPreferences.edit().remove("pref_long_exposure_streamer_portrait_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_busy_traffic_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_flowing_clouds_and_water_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_light_painting_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_moving_crowd_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_streamer_portrait_auto_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_busy_traffic_auto_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_flowing_clouds_and_water_auto_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_light_painting_auto_key").apply();
        this.mPreferences.edit().remove("pref_long_exposure_moving_crowd_auto_key").apply();
        this.mPreferences.edit().remove("pref_key_long_exposure_exposure_time").apply();
        this.mPreferences.edit().remove(CameraUIInterface.KEY_RESTORE_LONG_EXPOSURE_PARAMS).apply();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        super.onAfterStartPreview(z);
        CameraLog.m12954a("LongExposureMode", "onAfterStartPreview");
        if (isLongExposureSceneMenuOpen()) {
            this.f12929s.m14648a(this.f12926p.m14616c(), false);
            m12514b(false);
            this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, true).apply();
            this.f12929s.m14649a(false);
            return;
        }
        this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
        this.f12927q.m14574a(true);
        this.mCameraUIInterface.mo18240l(true, false);
        this.mCameraInterface.mo10563d(true);
        m12502a(this.f12926p.m14618d(), false, 0, 0);
        if (this.mCameraUIInterface.mo18023A()) {
            return;
        }
        this.mCameraInterface.mo10492a(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        CameraLog.m12954a("LongExposureMode", "onBeforeSnapping");
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.OplusGLSurfaceView_6.4
            @Override // java.lang.Runnable
            public void run() {
                if (!LongExposureMode.this.mbPaused) {
                    LongExposureMode.this.m12526j();
                    LongExposureMode.this.mCameraUIInterface.mo18195d(0, true);
                    MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
                    c3200b.m19227a("button_color_inside_none");
                    if (LongExposureMode.this.m12531c()) {
                        LongExposureMode.this.m12502a(R.string.camera_scene_night_keep_phone_steady, false, 0, 0);
                        int iM14652c = (int) (LongExposureMode.this.f12929s.m14652c(LongExposureMode.this.f12926p.m14616c()) * 1000.0f);
                        LongExposureMode.this.mCameraUIInterface.mo18221h(iM14652c);
                        LongExposureMode.this.f12918h.m20093a(iM14652c);
                        LongExposureMode.this.f12918h.m20095c();
                        LongExposureMode.this.f12918h.mo20097e();
                        c3200b.m19226a(Util.m24352ao() ? 33 : 7);
                    } else {
                        LongExposureMode.this.m12502a(R.string.long_exposure_keep_phone_steady, false, 0, 0);
                        LongExposureMode.this.mCameraUIInterface.mo18221h(ErrorCode.REASON_DS_FILE);
                        LongExposureMode.this.f12919i.m20112b(100L);
                        LongExposureMode.this.f12919i.m20113c();
                        c3200b.m19226a(Util.m24352ao() ? 35 : 30);
                    }
                    LongExposureMode.this.mCameraUIInterface.mo18091a(c3200b);
                    return;
                }
                CameraLog.m12954a("LongExposureMode", "onBeforeSnapping, return after pause");
            }
        });
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) true);
            this.mOneCamera.mo13071b(true, false);
            this.mOneCamera.mo13029a(1, AEAFHelp.m11154b(), AEAFHelp.m11154b(), false);
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22853n(true);
        }
        this.f12923m = false;
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        LongExposureTimeControl c2807k = this.f12929s;
        if (c2807k != null) {
            c2807k.m14653d(OplusGLSurfaceView_13);
        }
        LongExposureIcon c2800d = this.f12927q;
        if (c2800d != null) {
            c2800d.m14572a(OplusGLSurfaceView_13);
        }
        this.f12928r.m18348a(OplusGLSurfaceView_13, true);
        super.setOrientation(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        if (Util.m24352ao()) {
            this.mCameraInterface.mo10558c(6);
        } else {
            this.mCameraInterface.mo10558c(4);
        }
        return super.onAfterSnapping();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPictureCallback(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, boolean z, int i4) {
        if (this.f12918h.m20096d()) {
            this.f12918h.m20092a();
        } else if (this.f12919i.m20114d()) {
            this.f12919i.m20110a();
        }
        super.onPictureCallback(bArr, OplusGLSurfaceView_13, i2, i3, z, i4);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureFailed(CaptureRequest captureRequest, CameraRequestTag c2693c) {
        super.onCaptureFailed(captureRequest, c2693c);
        this.f12925o = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c) {
        super.onCaptureCompleted(cameraCaptureResult, c2693c);
        this.f12925o = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        CameraLog.m12954a("LongExposureMode", "onAfterPictureTaken");
        this.mCameraInterface.mo10508aJ();
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22853n(false);
        }
        m12525i();
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) false);
            this.mOneCamera.mo13071b(false, false);
            this.mOneCamera.mo13029a(4, AEAFHelp.m11154b(), AEAFHelp.m11154b(), false);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onFirstCaptureFrameAdd() {
        CameraLog.m12954a("LongExposureMode", "onFirstCaptureFrameAdd");
        this.f12923m = true;
        this.mCameraUIInterface.mo18107a(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        CameraLog.m12954a("LongExposureMode", "onStopTakePicture, mbFirstCaptureFrameAdd: " + this.f12923m);
        if (this.f12918h.m20096d()) {
            if (this.f12923m) {
                this.f12918h.m20092a();
            }
            return true;
        }
        if (this.f12919i.m20114d()) {
            if (this.f12923m) {
                this.f12919i.m20110a();
            }
            return true;
        }
        m12524h();
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        CameraLog.m12954a("LongExposureMode", "onPause");
        this.f12924n = false;
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13045a("type_still_capture_raw", false);
        }
        this.f12923m = false;
        this.mCameraUIInterface.mo18195d(8, false);
        if (this.f12918h.m20096d()) {
            this.f12918h.m20092a();
        } else if (this.f12919i.m20114d()) {
            this.f12919i.m20110a();
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22853n(false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        CameraLog.m12954a("LongExposureMode", "OnStop");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        CameraLog.m12954a("LongExposureMode", "onDeInitCameraMode");
        if (this.f12920j.hasMessages(1)) {
            this.f12920j.removeMessages(1);
        }
        m12524h();
        this.f12929s.m14651b(true);
        m12508a(true);
        m12509a(false, false);
        m12524h();
        this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT)).apply();
        this.mCameraUIInterface.mo18203e(8, true);
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13114m(0);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        CameraLog.m12954a("LongExposureMode", "onDestroy");
        this.f12926p = null;
        this.f12927q = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e9  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.LongExposureMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_FLASH_MODE.equals(str) || CameraUIInterface.KEY_FILTER_MENU.equals(str) || CameraUIInterface.KEY_SETTING.equals(str)) {
            return true;
        }
        if (CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
            return getSupportFunction(CameraUIInterface.KEY_SUB_SETTING);
        }
        if (CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            return getSupportFunction(CameraUIInterface.KEY_FLASH_MODE);
        }
        return super.getSupportMenu(str);
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
        shutterButtonInfo.m19235c("button_shape_ring_none");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            CameraLog.m12967f("LongExposureMode", "onPreviewCaptureResult, invalid totalResult: " + cameraPreviewResult);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11346i(getSupportFunction(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE));
        zoomConfigure.m11314J(false);
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if ("type_tuning_data_raw".equals(str) || "type_tuning_data_yuv".equals(str)) {
            return false;
        }
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        CameraLog.m12954a("LongExposureMode", "onSingleTapUp");
        Rect rect = new Rect();
        this.mCameraUIInterface.mo18253p().getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return m12529a();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        CameraLog.m12954a("LongExposureMode", "onMoreModeShown");
        this.f12929s.m14651b(false);
        m12508a(false);
        m12509a(false, false);
        this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
        RotateImageView rotateImageView = this.f12928r;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(8);
        }
        this.mCameraUIInterface.mo18203e(8, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        CameraLog.m12954a("LongExposureMode", "onMoreModeHidden");
        if (isLongExposureSceneMenuOpen()) {
            this.f12929s.m14651b(false);
            this.f12926p.m14614b(false);
        }
        this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
        m12510a(false, false, true);
        this.mCameraUIInterface.mo18240l(true, false);
        this.mCameraInterface.mo10492a(true, false);
        this.mCameraInterface.mo10563d(true);
        m12502a(this.f12926p.m14618d(), false, 100, 0);
        RotateImageView rotateImageView = this.f12928r;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(0);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopUp() {
        m12509a(true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT) ? CameraUIInterface.KEY_STREET_FILTER_INDEX : CameraUIInterface.KEY_LONG_EXPOSURE_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z) {
        CameraLog.m12954a("LongExposureMode", "onEffectMenuPopDown");
        m12510a(true, true, true);
        this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public List<String> onGetSupportSettingList(String str, int OplusGLSurfaceView_13) {
        if (CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            List<String> supportSettingList = getSupportSettingList(CameraUIInterface.KEY_FLASH_MODE, this.mCameraId);
            ArrayList arrayList = new ArrayList();
            if (supportSettingList != null) {
                for (String str2 : supportSettingList) {
                    if (!"on".equals(str2) && !"auto".equals(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        }
        return super.onGetSupportSettingList(str, OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m12523g() throws Resources.NotFoundException {
        if (this.f12928r == null) {
            this.f12928r = new RotateImageView(this.mActivity);
            this.f12928r.setId(R.id_renamed.long_exposure_parameter_bottom_guide_entry);
            this.f12928r.setImageResource(R.drawable.professional_guide_tip);
            int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.long_exposure_bottom_guide_entry_size);
            int settingMenuPanelHeight = Util.getSettingMenuPanelHeight() + this.mActivity.getResources().getDimensionPixelSize(R.dimen.long_exposure_bottom_guide_entry_margin_top);
            int dimensionPixelSize2 = this.mActivity.getResources().getDimensionPixelSize(R.dimen.long_exposure_bottom_guide_entry_margin_end);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.setMargins(0, settingMenuPanelHeight, 0, 0);
            layoutParams.setMarginEnd(dimensionPixelSize2);
            this.f12928r.setLayoutParams(layoutParams);
            this.f12928r.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.capmode.-$$Lambda$xx5HLlaTKn40VIrUcJgimvowXQ0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.COUIBaseListPopupWindow_12$0.m12528a(view);
                }
            });
        }
        this.f12928r.m18348a(this.mCameraInterface.mo10591u(), false);
        this.mCameraUIInterface.mo18087a((View) this.f12928r, ApsConstant.CAPTURE_MODE_LONG_EXPOSURE, 2, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12528a(View view) {
        if (view.getId() != R.id_renamed.long_exposure_parameter_bottom_guide_entry || this.mCameraUIInterface == null || this.mCameraInterface == null || this.mCameraInterface.mo10450F()) {
            return;
        }
        this.mCameraUIInterface.mo18157au();
        m12527k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12501a(int OplusGLSurfaceView_13, boolean z, int i2) {
        if (this.mCameraUIInterface != null) {
            this.f12921k = OplusGLSurfaceView_13;
            this.mCameraUIInterface.mo18072a(OplusGLSurfaceView_13, 0, z, true, false, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12502a(int OplusGLSurfaceView_13, boolean z, int i2, int i3) {
        Message messageObtainMessage = this.f12920j.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.arg1 = OplusGLSurfaceView_13;
        messageObtainMessage.arg2 = i3;
        messageObtainMessage.obj = Boolean.valueOf(z);
        this.f12920j.sendMessageDelayed(messageObtainMessage, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m12524h() {
        Message messageObtainMessage = this.f12920j.obtainMessage();
        messageObtainMessage.what = 2;
        this.f12920j.sendMessage(messageObtainMessage);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m12529a() {
        if (!this.f12926p.m14615b()) {
            return false;
        }
        this.f12929s.m14651b(true);
        m12508a(true);
        this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
        m12510a(true, true, true);
        this.mCameraUIInterface.mo18240l(true, true);
        this.mCameraInterface.mo10492a(true, true);
        this.mCameraInterface.mo10563d(true);
        m12502a(this.f12926p.m14618d(), false, 0, 0);
        return true;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m12525i() {
        CameraLog.m12954a("LongExposureMode", "resetAfterPictureTaken");
        m12524h();
        this.mCameraUIInterface.mo18092a(getShutterButtonInfo(), getSupportFunction(CameraUIInterface.KEY_BURST_SHOT));
        this.mCameraUIInterface.mo18195d(8, false);
        this.mCameraUIInterface.mo18215g(0);
        this.mCameraUIInterface.mo18167b(0, Util.m24420c(getPreviewSize(CameraCharacteristicsUtil.m12971a(getCameraMode(), this.mCameraId))));
        if (getSupportFunction(CameraUIInterface.KEY_SUPPORT_SWITCH_CAMERA)) {
            this.mCameraUIInterface.mo18193d(0);
        }
        this.mCameraUIInterface.mo18209f(0);
        this.mCameraInterface.mo10550az();
        if (this.f12925o) {
            this.mCameraUIInterface.mo18155as();
            this.f12925o = false;
        }
        this.mCameraUIInterface.mo18200d(true, false);
        RotateImageView rotateImageView = this.f12928r;
        if (rotateImageView != null) {
            Util.m24270a(rotateImageView, 0, (Animation.AnimationListener) null, 250L);
        }
        if (this.f12924n) {
            this.mCameraUIInterface.mo18275u(true);
            this.f12924n = false;
            return;
        }
        if (isPanelMode()) {
            this.mCameraUIInterface.mo18077a(0, true);
        } else if (!isShowProPanelMenu()) {
            this.mCameraUIInterface.mo18068a(0, 1);
        }
        if (isLongExposureSceneMenuOpen()) {
            m12514b(true);
            this.mCameraUIInterface.mo18232j(true, false);
            this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, true).apply();
            this.f12929s.m14649a(true);
            this.f12929s.m14648a(this.f12926p.m14616c(), false);
            return;
        }
        this.mCameraUIInterface.mo18240l(true, false);
        this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, false).apply();
        m12510a(false, false, true);
        this.mCameraUIInterface.mo18240l(true, false);
        this.mCameraInterface.mo10492a(true, false);
        this.mCameraInterface.mo10563d(true);
        m12502a(this.f12926p.m14618d(), false, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public void m12526j() {
        if (getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS) && this.mCameraUIInterface.mo18023A()) {
            this.f12924n = true;
        }
        this.mCameraUIInterface.mo18232j(true, false);
        this.mCameraUIInterface.mo18215g(4);
        this.mCameraUIInterface.mo18167b(4, Util.m24420c(getPreviewSize(CameraCharacteristicsUtil.m12971a(getCameraMode(), this.mCameraId))));
        this.mCameraUIInterface.mo18209f(4);
        if (!this.f12924n) {
            if (isPanelMode()) {
                this.mCameraUIInterface.mo18077a(4, true);
            } else {
                this.mCameraUIInterface.mo18068a(4, 1);
            }
        }
        m12509a(true, false);
        m12508a(true);
        this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
        this.f12929s.m14651b(true);
        RotateImageView rotateImageView = this.f12928r;
        if (rotateImageView != null) {
            Util.m24270a(rotateImageView, 8, (Animation.AnimationListener) null, 250L);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m12530b() {
        if (this.mbPaused) {
            CameraLog.m12954a("LongExposureMode", "captureRawDone, cancel capture after pause");
            return;
        }
        CameraLog.m12954a("LongExposureMode", "captureRawDone");
        synchronized (this.f12917g) {
            if (this.mOneCamera != null) {
                this.mOneCamera.mo13106j();
            }
        }
        if (m12531c()) {
            this.f12922l = m12532d() - this.f12918h.m20094b();
        } else {
            this.f12922l = this.f12919i.m20111b();
        }
        this.mCameraUIInterface.mo18107a(false, false);
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13045a("type_still_capture_raw", true);
        }
        if (Util.m24352ao()) {
            this.mCameraInterface.mo10558c(7);
        } else {
            this.mCameraInterface.mo10558c(5);
        }
        m12524h();
        int OplusGLSurfaceView_13 = Util.m24352ao() ? 28 : 4;
        MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
        c3200b.m19227a("button_color_inside_none");
        c3200b.m19226a(OplusGLSurfaceView_13);
        this.mCameraUIInterface.mo18091a(c3200b);
        this.mCameraUIInterface.mo18195d(8, false);
        m12502a(R.string.camera_scene_night_process_image_after_capture, false, 0, 0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isLongExposureSceneMenuOpen() {
        return this.mPreferences.getBoolean(CameraUIInterface.KEY_LONG_EXPOSURE_SCENE_MENU_STATE, true);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m12531c() {
        return "auto".equals(this.mPreferences.getString("pref_key_long_exposure_exposure_time", "auto"));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m12532d() {
        LongExposureMenu c2803g;
        LongExposureTimeControl c2807k = this.f12929s;
        if (c2807k == null || (c2803g = this.f12926p) == null) {
            return 0;
        }
        return (int) (c2807k.m14652c(c2803g.m14616c()) * 1000.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12513b(int OplusGLSurfaceView_13) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(true);
        if (OplusGLSurfaceView_13 == 1) {
            menuClickMsgData.mFuncKeyId = 72;
        } else if (OplusGLSurfaceView_13 == 2) {
            menuClickMsgData.mFuncKeyId = 73;
        } else if (OplusGLSurfaceView_13 == 3) {
            menuClickMsgData.mFuncKeyId = 74;
        } else if (OplusGLSurfaceView_13 == 4) {
            menuClickMsgData.mFuncKeyId = 75;
        } else if (OplusGLSurfaceView_13 == 5) {
            menuClickMsgData.mFuncKeyId = 87;
        }
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mCameraId = this.mCameraInterface.mo10547aw();
        menuClickMsgData.mOrientation = this.mOrientation;
        if (m12531c()) {
            menuClickMsgData.mItemValue = String.valueOf(m12532d());
        } else {
            menuClickMsgData.mItemValue = "manual";
        }
        menuClickMsgData.report();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m12527k() {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(false);
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mFuncKeyId = 76;
        menuClickMsgData.mFuncKeyResult = 1;
        menuClickMsgData.report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetAfterCaptureMsgCommonData(DcsMsgData dcsMsgData, Storage.CameraPicture cameraPicture) {
        if (!this.mbPaused) {
            CaptureMsgData captureMsgData = (CaptureMsgData) dcsMsgData;
            LongExposureMenu c2803g = this.f12926p;
            if (c2803g != null) {
                captureMsgData.mLongExposureType = String.valueOf(c2803g.m14616c());
            }
            if (m12531c()) {
                captureMsgData.mLongExposureSettingTime = String.valueOf(m12532d());
            } else {
                captureMsgData.mLongExposureSettingTime = "manual";
            }
            captureMsgData.mLongExposureTotalCaptureTime = String.valueOf(this.f12922l);
        }
        return dcsMsgData;
    }
}
