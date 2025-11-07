package com.oplus.camera.capmode.p139a;

import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.ocs.camera.CameraUnitClient;

/* compiled from: MultiCameraDecision.java */
/* renamed from: com.oplus.camera.capmode.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class MultiCameraDecision {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f12688a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f12689b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f12690c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f12691d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f12692e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f12693f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f12694g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String f12695h;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f12696i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f12697j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f12698k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f12699l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f12700m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f12701n;

    /* renamed from: o */
    private String f12702o;

    /* renamed from: p */
    private String f12703p;

    /* renamed from: q */
    private boolean f12704q;

    public MultiCameraDecision() {
        this.f12688a = 0;
        this.f12689b = 1;
        this.f12690c = 1;
        this.f12691d = 0;
        this.f12692e = 0;
        this.f12693f = 1;
        this.f12694g = "";
        this.f12695h = "";
        this.f12696i = "";
        this.f12697j = -1;
        this.f12698k = -1;
        this.f12699l = -1;
        this.f12700m = -1;
        this.f12701n = -1;
        this.f12702o = null;
        this.f12703p = null;
        this.f12704q = false;
    }

    public MultiCameraDecision(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f12688a = 0;
        this.f12689b = 1;
        this.f12690c = 1;
        this.f12691d = 0;
        this.f12692e = 0;
        this.f12693f = 1;
        this.f12694g = "";
        this.f12695h = "";
        this.f12696i = "";
        this.f12697j = -1;
        this.f12698k = -1;
        this.f12699l = -1;
        this.f12700m = -1;
        this.f12701n = -1;
        this.f12702o = null;
        this.f12703p = null;
        this.f12704q = false;
        this.f12688a = OplusGLSurfaceView_13;
        this.f12689b = i2;
        this.f12690c = i3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public MultiCameraDecision m12146a(String str) {
        this.f12694g = str;
        CameraLog.m12959b("MultiCameraDecision", "setBeforeModeName, beforeModeName: " + str);
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public MultiCameraDecision m12150b(String str) {
        this.f12695h = str;
        CameraLog.m12959b("MultiCameraDecision", "setAfterModeName, afterModeName: " + str);
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public MultiCameraDecision m12145a(int OplusGLSurfaceView_13) {
        this.f12697j = OplusGLSurfaceView_13;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public MultiCameraDecision m12149b(int OplusGLSurfaceView_13) {
        this.f12698k = OplusGLSurfaceView_13;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public MultiCameraDecision m12151c(int OplusGLSurfaceView_13) {
        this.f12699l = OplusGLSurfaceView_13;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public MultiCameraDecision m12154d(int OplusGLSurfaceView_13) {
        this.f12700m = OplusGLSurfaceView_13;
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public MultiCameraDecision m12144a() {
        int OplusGLSurfaceView_13 = this.f12691d;
        if (OplusGLSurfaceView_13 == 0) {
            this.f12697j = 0;
            this.f12699l = 1;
        } else if (OplusGLSurfaceView_13 != 1) {
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public MultiCameraDecision m12148b() {
        int OplusGLSurfaceView_13 = this.f12691d;
        if (OplusGLSurfaceView_13 == 0) {
            this.f12697j = 0;
            this.f12699l = 1;
        } else if (OplusGLSurfaceView_13 != 1) {
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m12153c() {
        return (ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(this.f12694g) && !(this.f12697j == this.f12698k && -1 == this.f12699l)) || ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(this.f12695h);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public MultiCameraDecision m12147a(boolean z) {
        this.f12704q = z;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12152c(String str) {
        this.f12696i = str;
        CameraLog.m12959b("MultiCameraDecision", "setCurrentModeName, currentModeName: " + str);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12155d() {
        this.f12694g = null;
        this.f12696i = null;
        this.f12695h = null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m12157e(int OplusGLSurfaceView_13) {
        this.f12701n = OplusGLSurfaceView_13;
        if (CameraUnitClient.CameraType.REAR_MAIN_FRONT_MAIN.equals(CameraCharacteristicsUtil.m12978b(OplusGLSurfaceView_13))) {
            this.f12702o = CameraUnitClient.CameraType.REAR_MAIN;
            this.f12703p = CameraUnitClient.CameraType.FRONT_MAIN;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public String m12156e() {
        return this.f12703p;
    }

    public String toString() {
        return "MultiCameraDecision{mFirstCameraType=" + this.f12688a + ", mSecondCameraType=" + this.f12689b + ", mBottomCameraType=" + this.f12690c + ", mMultiCameraType=" + this.f12691d + ", mMainLogicId=" + this.f12692e + ", mSubLogicId=" + this.f12693f + ", mBeforeModeName='" + this.f12694g + "', mAfterModeName='" + this.f12695h + "', mCurrentModeName='" + this.f12696i + "', mMainBeforeLogicId=" + this.f12697j + ", mMainAfterLogicId=" + this.f12698k + ", mSubBeforeLogicId=" + this.f12699l + ", mSubAfterLogicId=" + this.f12700m + ", mMultiCameraId=" + this.f12701n + ", mMainCameraType=" + this.f12702o + ", mSubCameraType=" + this.f12703p + '}';
    }
}
