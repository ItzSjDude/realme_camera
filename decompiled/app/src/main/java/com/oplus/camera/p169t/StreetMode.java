package com.oplus.camera.p169t;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.SharedPreferences;
import android.hardware.camera2.CaptureResult;
import android.view.MotionEvent;
import android.view.View;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.capmode.CommonCapMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p144g.p145a.ExifModel;
import com.oplus.camera.p169t.StreetFixFocusHelper;
import com.oplus.camera.p169t.StreetTrackHelper;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPictureCallback;
import com.oplus.ocs.camera.CameraPreviewCallback;
import java.util.List;

/* compiled from: StreetMode.java */
/* renamed from: com.oplus.camera.t.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class StreetMode extends CommonCapMode implements StreetFixFocusHelper.IntrinsicsJvm.kt_4, StreetTrackHelper.PlatformImplementations.kt_3 {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f16592g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String f16593h;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f16594i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f16595j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f16596k;

    /* renamed from: OplusGLSurfaceView_14 */
    private String[] f16597l;

    /* renamed from: OplusGLSurfaceView_6 */
    private StreetFixFocusHelper f16598m;

    /* renamed from: OplusGLSurfaceView_11 */
    private StreetTrackHelper f16599n;

    /* renamed from: o */
    private CameraInterface f16600o;

    /* renamed from: p */
    private boolean f16601p;

    /* renamed from: q */
    private boolean f16602q;

    /* renamed from: r */
    private int f16603r;

    /* renamed from: s */
    private float f16604s;

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m17304a(int OplusGLSurfaceView_13, boolean z) {
        return 3 == OplusGLSurfaceView_13 && !z;
    }

    @Override // com.oplus.camera.p169t.StreetTrackHelper.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17314a(int OplusGLSurfaceView_13) {
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_STREET;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getEffectMenuKeyByMode() {
        return CameraUIInterface.KEY_STREET_FILTER_MENU;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return CameraUIInterface.KEY_STREET_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32937;
    }

    @Override // com.oplus.camera.p169t.StreetTrackHelper.PlatformImplementations.kt_3
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo17320i() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isStreetOpen() {
        return true;
    }

    public StreetMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f16592g = "1";
        this.f16593h = "28";
        this.f16594i = "169";
        this.f16595j = true;
        this.f16596k = false;
        this.f16598m = null;
        this.f16599n = null;
        this.f16600o = null;
        this.f16601p = false;
        this.f16602q = false;
        this.f16603r = FilterHelper.f21279a;
        this.f16604s = 1.0f;
        this.f16600o = interfaceC2646a;
        this.f16603r = getCurrFilterIndex();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        super.onInitCameraMode();
        this.f16598m = new StreetFixFocusHelper(this.mActivity, this.mCameraUIInterface, this.f16600o, true, this.mOneCamera);
        this.f16598m.m17268a(this);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            this.f16599n = new StreetTrackHelper(this.mActivity, this.mCameraUIInterface, this.f16600o, this.mOneCamera);
            this.f16599n.m17353a(this);
        }
        m17308n();
        m17309o();
        m17317f();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        super.onDeInitCameraMode(str);
        m17310p();
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_STREET_ROCKER_SHUTTER)) {
            this.mCameraUIInterface.mo18210f(20, true);
        }
        this.f16598m.m17285i();
        this.f16598m.m17279e();
        StreetTrackHelper c3027g = this.f16599n;
        if (c3027g != null) {
            c3027g.m17357d();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportMenu(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r6 = com.oplus.camera.entry.CameraEntry.m13305d(r6)
            int r0 = r6.hashCode()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1995250906: goto L2e;
                case -1973476532: goto L24;
                case -1063289942: goto L1a;
                case 1063692490: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L38
        L10:
            java.lang.String r0 = "pref_raw_control_key"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L38
            r0 = r3
            goto L39
        L1a:
            java.lang.String r0 = "pref_camera_hdr_mode_key"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L38
            r0 = r1
            goto L39
        L24:
            java.lang.String r0 = "pref_street_fix_focus_control_key"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L38
            r0 = r4
            goto L39
        L2e:
            java.lang.String r0 = "pref_street_filter_menu"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L38
            r0 = r2
            goto L39
        L38:
            r0 = -1
        L39:
            if (r0 == 0) goto L59
            if (r0 == r4) goto L52
            if (r0 == r3) goto L4b
            if (r0 == r2) goto L46
            boolean r5 = super.getSupportMenu(r6)
            return r5
        L46:
            boolean r5 = r5.getSupportFunction(r6)
            return r5
        L4b:
            java.lang.String r5 = "com.oplus.feature.street.raw.support"
            boolean r5 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r5)
            return r5
        L52:
            java.lang.String r5 = "com.oplus.feature.street.lock.focus.support"
            boolean r5 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r5)
            return r5
        L59:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p169t.StreetMode.getSupportMenu(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p169t.StreetMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public int getCurrFilterIndex() {
        int OplusGLSurfaceView_13 = this.mPreferences.getInt(getFilterEffectMenuPreferenceKey(), FilterHelper.f21279a);
        String configStringValue = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_STREET_FILTER_TYPE_DEFAULT);
        List<String> filterTypeList = getFilterTypeList(this.mCameraId);
        if (filterTypeList != null && filterTypeList.contains(configStringValue)) {
            OplusGLSurfaceView_13 = this.mPreferences.getInt(getFilterEffectMenuPreferenceKey(), filterTypeList.indexOf(configStringValue));
        }
        return Util.m24205a(OplusGLSurfaceView_13, 0, getFilterTypeList(this.mCameraId).size() - 1);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean m17306l() {
        StreetTrackHelper c3027g = this.f16599n;
        if (c3027g != null) {
            return c3027g.m17355b();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        this.mbCheckTakeAnimateDelay = false;
        setRawRequestTag(false);
        if (isRawOpen()) {
            setRawRequestTag(true);
            this.f16595j = false;
        }
        m17313s();
        return super.onBeforeSnapping(c2693c);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            return;
        }
        this.f16598m.m17266a(((Float) cameraPreviewResult.getCaptureResult().get(CaptureResult.LENS_FOCUS_DISTANCE)).floatValue());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f16598m.m17271a(motionEvent);
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        CameraLog.m12954a("StreetMode", "onAfterPictureTaken");
        if (!this.f16595j && isRawRequestTag()) {
            this.f16595j = true;
        } else {
            super.onAfterPictureTaken(bArr, z);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (2 != motionEvent.getAction() || !this.f16598m.m17291o()) {
            return false;
        }
        this.f16598m.m17285i();
        return true;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        m17310p();
        this.f16596k = false;
        StreetFixFocusHelper c3023c = this.f16598m;
        if (c3023c != null) {
            c3023c.m17296t();
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (CameraUIInterface.KEY_SUB_SETTING.equals(str) && "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_SUB_SETTING, "off"))) {
            m17310p();
            return;
        }
        if (CameraUIInterface.KEY_RAW_CONTROL.equals(str) && getSupportFunction(CameraUIInterface.KEY_RAW_CONTROL)) {
            m17311q();
            return;
        }
        if (CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL.equals(str) && !this.f16601p) {
            m17317f();
            return;
        }
        if (CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE.equals(str) && "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off"))) {
            m17310p();
            m17307m();
        } else {
            if (CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU.equals(str)) {
                this.f16600o.mo10479a((AnimatorListenerAdapter) null, false, false);
                this.f16598m.m17285i();
                this.mCameraUIInterface.mo18278v(27);
                return;
            }
            super.onSharedPreferenceChanged(sharedPreferences, str);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m17307m() {
        this.f16598m.m17285i();
        m17305b(false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17305b(boolean z) {
        this.f16596k = z;
        this.mOneCamera.mo13016E(this.f16596k);
        this.mOneCamera.mo13059a(this.f16597l);
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        m17309o();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSupportAutoFocus() {
        return !this.f16598m.m17282f();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isRawOpen() {
        return getSupportFunction(CameraUIInterface.KEY_RAW_CONTROL) && !"off".equals(this.mPreferences.getString(CameraUIInterface.KEY_RAW_CONTROL, "off"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFixFocusOpen() {
        return getSupportFunction(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL) && !"off".equals(this.mPreferences.getString(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, "off"));
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if ("type_still_capture_raw".equals(str)) {
            return getSupportFunction(CameraUIInterface.KEY_RAW_CONTROL) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_RAW);
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isRawRequestTag() {
        return this.mbRawRequestTag;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean isCameraSettingMenuOptionEnable(String str) {
        if ((CameraUIInterface.KEY_RAW_CONTROL.equals(str) && getSupportFunction(CameraUIInterface.KEY_RAW_CONTROL)) || (CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL.equals(str) && getSupportFunction(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL))) {
            return (m17315a(getZoomValue()) || isNoneSatUltraWideAngleOpen()) ? false : true;
        }
        return super.isCameraSettingMenuOptionEnable(str);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onZoomChanged() {
        if (this.f16600o.mo10496a(this.f16604s, getZoomValue())) {
            if (this.f16598m.m17278d() && m17315a(getZoomValue())) {
                this.mPreferences.edit().putString(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, "off").apply();
                this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL);
            }
            this.mCameraUIInterface.mo18258q();
        }
        this.f16604s = getZoomValue();
        super.onZoomChanged();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m17315a(float COUIBaseListPopupWindow_12) {
        return Float.compare(COUIBaseListPopupWindow_12, 1.0f) < 0;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11336d(true);
        zoomConfigure.m11316K(isRawOpen());
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected List<String> getFilterTypeList(int OplusGLSurfaceView_13) {
        if (getSupportFunction(CameraUIInterface.KEY_STREET_FILTER_MENU)) {
            return FilterHelper.f21324n.m22561a(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
        }
        return super.getFilterTypeList(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getFilterType(int OplusGLSurfaceView_13) {
        return getFilterTypeList(this.mCameraId).get(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected List<Integer> getFilterNameIdList(int OplusGLSurfaceView_13) {
        if (getSupportFunction(CameraUIInterface.KEY_STREET_FILTER_MENU)) {
            return FilterHelper.f21324n.f21252f;
        }
        return super.getFilterNameIdList(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected long getHalMemory() {
        return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HAL_MEMORY_STREET);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m17308n() {
        String[] strArrM24402b;
        this.f16592g = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_EDGE_FILTER_LINE_SIZE);
        int[] configIntArrayValue = CameraConfig.getConfigIntArrayValue(ConfigDataBase.KEY_EDGE_FILTER_COLOR);
        if (configIntArrayValue != null && 3 == configIntArrayValue.length && (strArrM24402b = Util.m24402b(configIntArrayValue[0], configIntArrayValue[1], configIntArrayValue[2])) != null && strArrM24402b.length == 2) {
            this.f16593h = strArrM24402b[0];
            this.f16594i = strArrM24402b[1];
        }
        this.f16597l = new String[]{this.f16592g, this.f16593h, this.f16594i};
    }

    /* renamed from: o */
    private void m17309o() {
        if (this.mCameraUIInterface.mo18059T() || isNoneSatUltraWideAngleOpen()) {
            return;
        }
        this.mCameraUIInterface.mo18070a(R.string.camera_mode_ice_on_hint, -1, true, true, false);
    }

    /* renamed from: p */
    private void m17310p() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18067a(R.string.camera_mode_ice_on_hint);
        }
    }

    /* renamed from: q */
    private void m17311q() {
        if ("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_RAW_CONTROL, "off"))) {
            this.mCameraUIInterface.mo18070a(R.string.camera_raw_control_on_hint, -1, true, false, false);
        } else {
            this.mCameraUIInterface.mo18070a(R.string.camera_raw_control_off_hint, -1, true, false, false);
        }
        this.mOneCamera.mo13115m(getZSLMode());
        if (this.f16600o != null) {
            if (getSupportFunction(CameraUIInterface.KEY_ZOOM) && !this.mCameraUIInterface.mo18023A()) {
                this.f16600o.mo10492a(true, false);
                this.f16600o.mo10563d(true);
            } else {
                this.f16600o.mo10479a((AnimatorListenerAdapter) null, true, false);
            }
            if (m17316e()) {
                this.f16600o.mo10506aH();
            }
        }
        this.mCameraUIInterface.mo18107a(true, false);
        m17313s();
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m17316e() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_RAW_ZOOM_MUTEX_SUPPORT);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m17317f() {
        if (!getSupportFunction(CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL) || this.mPreferences == null) {
            return;
        }
        this.f16598m.m17273b(isPanelMode());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultAFMode() {
        if (getIsCapturingState()) {
            return this.mOneCamera.mo13122p();
        }
        return super.getDefaultAFMode();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        if (this.mCameraUIInterface.mo18265s() != 3 && this.mCameraUIInterface.mo18265s() != 14) {
            return false;
        }
        this.mbInCapturing = false;
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFilterMenuClicked() {
        super.onFilterMenuClicked();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopUp() {
        this.f16598m.m17290n();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z) {
        this.f16598m.m17280e(isPanelMode());
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        this.f16598m.m17294r();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsed() {
        this.f16598m.m17295s();
    }

    @Override // com.oplus.camera.p169t.StreetFixFocusHelper.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17298a() {
        m17305b(true);
    }

    @Override // com.oplus.camera.p169t.StreetFixFocusHelper.IntrinsicsJvm.kt_4
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo17300b() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            return;
        }
        m17305b(false);
    }

    @Override // com.oplus.camera.p169t.StreetFixFocusHelper.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17299a(boolean z) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            return;
        }
        m17305b(z);
    }

    @Override // com.oplus.camera.p169t.StreetFixFocusHelper.IntrinsicsJvm.kt_4
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo17301c() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            m17305b(false);
        }
    }

    @Override // com.oplus.camera.p169t.StreetFixFocusHelper.IntrinsicsJvm.kt_4
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo17302d() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            m17305b(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowFixFocusMenu() {
        boolean zM17291o = this.f16598m.m17291o();
        StreetTrackHelper c3027g = this.f16599n;
        if (c3027g != null) {
            return zM17291o || c3027g.m17354a();
        }
        return zM17291o;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (isShowFixFocusMenu()) {
            m17307m();
            return true;
        }
        if (this.f16595j) {
            return super.onBackPressed();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAfFixFocuse() {
        return this.f16598m.m17292p();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        m17317f();
        super.onResume(z);
        m17312r();
    }

    /* renamed from: r */
    private void m17312r() {
        View viewFindViewById = this.mActivity.findViewById(R.id_renamed.google_lens_icon_view);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onSessionConfigured() {
        this.f16598m.m17293q();
        setBurstShotCapturing(false);
        super.onSessionConfigured();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int OplusGLSurfaceView_13, boolean z) {
        super.changeModeAllViewWhenAnimation(OplusGLSurfaceView_13, z);
        if (m17304a(OplusGLSurfaceView_13, z)) {
            this.f16601p = true;
            m17307m();
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z) {
        this.f16601p = false;
        m17317f();
        super.onTimeSnapShotEnd(z);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        super.onAfterStartPreview(z);
        m17317f();
        this.f16604s = getZoomValue();
        this.f16598m.m17293q();
        m17313s();
        StreetTrackHelper c3027g = this.f16599n;
        if (c3027g != null) {
            c3027g.m17356c();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        super.setOrientation(OplusGLSurfaceView_13);
        StreetFixFocusHelper c3023c = this.f16598m;
        if (c3023c != null) {
            c3023c.m17275c(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void saveAndClearEffectBeforeBurstShot() {
        this.f16603r = getCurrFilterIndex();
        onFilterItemChange(FilterHelper.f21279a);
        updateEffectMenuNames();
        this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_FILTER_MENU);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void restoreEffectAfterBurstShot() {
        onFilterItemChange(this.f16603r);
        updateEffectMenuNames();
        this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_FILTER_MENU);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void showNextTip() {
        super.showNextTip();
        if (this.mCameraUIInterface == null || this.mCameraUIInterface.mo18057R() || this.mCameraUIInterface.mo18058S()) {
            return;
        }
        if (this.mPreferences != null && !this.mPreferences.getBoolean(CameraUIInterface.KEY_PERMISSION_DIALOG_DISPLAYED, false)) {
            CameraLog.m12967f("StreetMode", "showNextTip, return");
        } else if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_STREET_ROCKER_SHUTTER)) {
            this.mCameraUIInterface.mo18086a((View) null, 20, getBubbleOffsetX(20), getBubbleOffsetY(20));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onRawImageReceived(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        m17303a(cameraPictureImage);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17303a(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        byte[] image = cameraPictureImage.getImage();
        ExifModel c2731eM13747a = ExifModel.m13747a(image);
        final long OplusGLSurfaceView_15 = this.mCaptureDate - 10;
        if (c2731eM13747a != null) {
            c2731eM13747a.m13761a();
            c2731eM13747a.m13762a(c2731eM13747a.f13793f, OplusGLSurfaceView_15);
            c2731eM13747a.m13762a(c2731eM13747a.f13794g, OplusGLSurfaceView_15);
            c2731eM13747a.m13766d();
            image = c2731eM13747a.f13797j.array();
        }
        final byte[] bArr = image;
        final int format = cameraPictureImage.getFormat();
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.t.COUIBaseListPopupWindow_8.1
                @Override // java.lang.Runnable
                public void run() {
                    StreetMode.this.pictureTakenCallback(bArr, 0, 0, Util.m24243a(format), true, false, false, OplusGLSurfaceView_15, 0);
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void closeImageReader() {
        this.f16595j = true;
    }

    /* renamed from: s */
    private void m17313s() {
        if (this.mPreferences == null || this.mOneCamera == null) {
            return;
        }
        if ("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_RAW_CONTROL, "off"))) {
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "raw");
        } else {
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "none");
        }
    }

    @Override // com.oplus.camera.p169t.StreetTrackHelper.PlatformImplementations.kt_3
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo17318g() {
        this.f16602q = true;
        this.f16598m.m17281f(false);
        this.f16598m.m17286j();
    }

    @Override // com.oplus.camera.p169t.StreetTrackHelper.PlatformImplementations.kt_3
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo17319h() {
        this.f16602q = false;
        this.f16598m.m17281f(true);
        this.f16598m.m17280e(isPanelMode());
        if (this.f16598m.m17282f()) {
            this.f16598m.m17297u();
        } else {
            this.f16598m.m17277d(false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean supportMenuLeftButton() {
        if (this.f16602q) {
            return false;
        }
        return super.supportMenuLeftButton();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean supportBeautyButton() {
        if (this.f16602q) {
            return false;
        }
        return super.supportBeautyButton();
    }

    @Override // com.oplus.camera.p169t.StreetTrackHelper.PlatformImplementations.kt_3
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo17321j() {
        if (m17315a(getZoomValue()) || isNoneSatUltraWideAngleOpen()) {
            this.mCameraUIInterface.mo18070a(R.string.disabled_street_track_hint, -1, true, true, false);
            return true;
        }
        if (this.mCameraUIInterface == null) {
            return false;
        }
        this.mCameraUIInterface.mo18067a(R.string.disabled_street_track_hint);
        return false;
    }

    @Override // com.oplus.camera.p169t.StreetTrackHelper.PlatformImplementations.kt_3
    /* renamed from: OplusGLSurfaceView_5 */
    public boolean mo17322k() {
        if (this.mCameraUIInterface == null) {
            return false;
        }
        this.mCameraUIInterface.mo18067a(R.string.disabled_street_track_hint);
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected boolean isHideHeadLine() {
        return this.f16598m.m17291o();
    }
}
