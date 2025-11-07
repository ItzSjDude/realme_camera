package com.oplus.camera;

import android.util.Size;
import com.oplus.camera.CameraManager;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.ModeManager;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraPictureCallback;

/* compiled from: ModeFacade.java */
/* renamed from: com.oplus.camera.t */
/* loaded from: classes2.dex */
class ModeFacade {

    /* renamed from: PlatformImplementations.kt_3 */
    private ModeManager f16488a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CameraManager.C2586n f16489b;

    protected ModeFacade(ModeManager modeManager, CameraManager.C2586n c2586n) {
        this.f16488a = null;
        this.f16489b = null;
        this.f16488a = modeManager;
        this.f16489b = c2586n;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected synchronized void m17189a() {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            c2587oM17205g.f11189b.beforePreview();
        } else {
            this.f16488a.m12121r();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected synchronized String m17195b() {
        CameraManager.C2587o c2587oM11015i;
        BaseMode baseMode;
        if (this.f16489b == null || (c2587oM11015i = this.f16489b.m11015i()) == null || (baseMode = c2587oM11015i.f11189b) == null) {
            return null;
        }
        return baseMode.getCameraMode();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected synchronized void m17192a(boolean z) {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            c2587oM17205g.f11189b.afterStartPreview(z);
        } else {
            this.f16488a.m11959c(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected synchronized Size m17187a(OplusCameraCharacteristics c2698h) {
        return m17188a(c2698h, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected synchronized Size m17186a(Size size) {
        Size sizeM11795a;
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            sizeM11795a = c2587oM17205g.f11189b.getPreviewSurfaceSize(size);
        } else {
            sizeM11795a = this.f16488a.m11795a(size);
        }
        return sizeM11795a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected synchronized Size m17188a(OplusCameraCharacteristics c2698h, String str) {
        Size sizeM11798a;
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            sizeM11798a = c2587oM17205g.f11189b.getPreviewSize(c2698h, str);
        } else {
            sizeM11798a = this.f16488a.m11798a(c2698h, str);
        }
        return sizeM11798a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected synchronized Size m17194b(OplusCameraCharacteristics c2698h) {
        Size sizeM11956c;
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            sizeM11956c = c2587oM17205g.f11189b.getPictureSize(c2698h);
        } else {
            sizeM11956c = this.f16488a.m11956c(c2698h);
        }
        return sizeM11956c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected synchronized int m17199c() {
        int iM11786R;
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            iM11786R = c2587oM17205g.f11189b.getDefaultAFMode();
        } else {
            iM11786R = this.f16488a.m11786R();
        }
        return iM11786R;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected synchronized int m17202d() {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            return c2587oM17205g.f11189b.getOperatingMode();
        }
        return this.f16488a.m12067e();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected synchronized Size m17200c(OplusCameraCharacteristics c2698h) {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            return c2587oM17205g.f11189b.getPreviewFrameSize(c2698h);
        }
        return this.f16488a.m11892b(c2698h);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected synchronized boolean m17193a(String str) {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            return c2587oM17205g.f11189b.needSurface(str);
        }
        return this.f16488a.m12107n(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected synchronized void m17190a(CameraDeviceConfig.Builder builder) {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            c2587oM17205g.f11189b.setConfigureParameter(builder);
        } else if (this.f16488a != null) {
            this.f16488a.m11822a(builder);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected synchronized void m17203e() {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            c2587oM17205g.f11189b.onSessionConfigured();
        } else {
            this.f16488a.m11944bo();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected synchronized boolean m17204f() {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            return c2587oM17205g.f11189b.isShowBeauty3D();
        }
        return this.f16488a.m11946bq();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected synchronized boolean m17198b(String str) {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            return c2587oM17205g.f11189b.getSupportFunction(str);
        }
        return this.f16488a.m12091j(str);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected synchronized CameraManager.C2587o m17205g() {
        CameraManager.C2587o c2587oM11014h;
        if (this.f16489b != null && (c2587oM11014h = this.f16489b.m11014h()) != null) {
            if (c2587oM11014h.f11189b != null) {
                return c2587oM11014h;
            }
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected synchronized BaseMode m17206h() {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            return c2587oM17205g.f11189b;
        }
        return this.f16488a.m11800a(this.f16488a.m12105n());
    }

    /* renamed from: OplusGLSurfaceView_13 */
    protected synchronized String m17207i() {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            return c2587oM17205g.f11190c;
        }
        return this.f16488a.m12105n();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m17191a(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            c2587oM17205g.f11189b.onRawImageReceived(cameraPictureImage);
        } else {
            this.f16488a.m11823a(cameraPictureImage);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized boolean m17197b(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            return c2587oM17205g.f11189b.consumeImage(cameraPictureImage);
        }
        return this.f16488a.m11903b(cameraPictureImage);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public synchronized void m17208j() {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            c2587oM17205g.f11189b.beforeConfig();
        } else {
            this.f16488a.m12063dw();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized void m17196b(boolean z) {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            c2587oM17205g.f11189b.setFlashTemporaryDisabled(z);
        } else {
            this.f16488a.m12134v(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public synchronized boolean m17209k() {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            return c2587oM17205g.f11189b.isSatOpen();
        }
        return this.f16488a.isSatOpen();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public synchronized boolean m17210l() {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            return c2587oM17205g.f11189b.isMultiVideoMode();
        }
        return this.f16488a.m11982cQ();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public synchronized void m17211m() {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            c2587oM17205g.f11189b.closeImageReader();
        } else {
            this.f16488a.m11870ae();
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public synchronized boolean m17212n() {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            return c2587oM17205g.f11189b.isAutoFocus();
        }
        return this.f16488a.m12066dz();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public synchronized boolean m17201c(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        CameraManager.C2587o c2587oM17205g = m17205g();
        if (c2587oM17205g != null) {
            return c2587oM17205g.f11189b.onImageReceived(cameraPictureImage);
        }
        return this.f16488a.m11964c(cameraPictureImage);
    }
}
