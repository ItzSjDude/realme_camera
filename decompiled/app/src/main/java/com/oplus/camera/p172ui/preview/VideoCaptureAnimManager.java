package com.oplus.camera.p172ui.preview;

import android.graphics.Color;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;

/* compiled from: VideoCaptureAnimManager.java */
/* renamed from: com.oplus.camera.ui.preview.ad */
/* loaded from: classes2.dex */
public class VideoCaptureAnimManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Interpolator f21633a = new DecelerateInterpolator();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f21634b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private long f21635c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float f21636d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f21637e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f21638f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f21639g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f21640h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f21641i;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23033a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f21635c = SystemClock.uptimeMillis();
        this.f21639g = i3;
        this.f21640h = i4;
        this.f21636d = OplusGLSurfaceView_13;
        this.f21637e = i2;
        int i5 = this.f21634b;
        if (i5 == 0) {
            this.f21638f = i3;
            return;
        }
        if (i5 == 90) {
            this.f21638f = -i4;
        } else if (i5 == 180) {
            this.f21638f = -i3;
        } else {
            if (i5 != 270) {
                return;
            }
            this.f21638f = i4;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m23034a(GLCanvas interfaceC2757h, CameraScreenNail c3445h, RawTexture c2768s) {
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f21635c;
        if (this.f21641i == 2 && jUptimeMillis > 400) {
            return false;
        }
        if (this.f21641i == 0 && jUptimeMillis > 800) {
            return false;
        }
        int OplusGLSurfaceView_13 = this.f21641i;
        if (OplusGLSurfaceView_13 == 0) {
            OplusGLSurfaceView_13 = jUptimeMillis < 400 ? 1 : 2;
            if (OplusGLSurfaceView_13 == 2) {
                jUptimeMillis -= 400;
            }
        }
        if (OplusGLSurfaceView_13 == 1) {
            c2768s.m13928a(interfaceC2757h, (int) this.f21636d, (int) this.f21637e, this.f21639g, this.f21640h);
            if (jUptimeMillis < 200) {
                interfaceC2757h.mo13963a(this.f21636d, this.f21637e, this.f21639g, this.f21640h, Color.argb((int) ((0.3f - ((jUptimeMillis * 0.3f) / 200.0f)) * 255.0f), 255, 255, 255));
            }
        } else {
            if (OplusGLSurfaceView_13 != 2) {
                return false;
            }
            c3445h.m23465a(interfaceC2757h, (int) this.f21636d, (int) this.f21637e, this.f21639g, this.f21640h);
        }
        return true;
    }
}
