package com.oplus.camera.p172ui.preview;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.BasicTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.CameraScreenNail;

/* compiled from: SwitchAnimManager.java */
/* renamed from: com.oplus.camera.ui.preview.aa */
/* loaded from: classes2.dex */
public class SwitchAnimManager implements AnimManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final float[] f21563a = {70.0f, 110.0f};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final float[] f21564b = {0.2f, 0.25f};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static float f21565c = 600.0f;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private long f21566d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f21567e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f21568f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f21569g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private PlatformImplementations.kt_3 f21570h = new PlatformImplementations.kt_3(0.27f, 0.5f, 0.25f, 1.0f);

    /* renamed from: OplusGLSurfaceView_13 */
    private float f21571i = 0.0f;

    /* renamed from: OplusGLSurfaceView_15 */
    private Context f21572j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f21573k = 0.0f;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f21574l = 0.0f;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f21575m = 0.0f;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f21576n = 1.0f;

    /* renamed from: o */
    private CameraScreenNail.IntrinsicsJvm.kt_5 f21577o;

    @Override // com.oplus.camera.p172ui.preview.AnimManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22972a(int OplusGLSurfaceView_13) {
        f21565c = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.AnimManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22973a(int OplusGLSurfaceView_13, int i2) {
        this.f21567e = OplusGLSurfaceView_13;
        this.f21568f = i2;
    }

    @Override // com.oplus.camera.p172ui.preview.AnimManager
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22976b(int OplusGLSurfaceView_13, int i2) {
        this.f21569g = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.AnimManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22974a(Context context, CameraScreenNail.IntrinsicsJvm.kt_5 dVar) {
        this.f21566d = SystemClock.uptimeMillis();
        this.f21571i = context.getResources().getDisplayMetrics().density;
        this.f21572j = context;
        float[] fArr = f21563a;
        this.f21573k = (fArr[1] - fArr[0]) / 2.0f;
        float[] fArr2 = f21564b;
        this.f21574l = (fArr2[1] - fArr2[0]) / this.f21573k;
        this.f21577o = dVar;
    }

    @Override // com.oplus.camera.p172ui.preview.AnimManager
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo22977b() {
        return ((float) (SystemClock.uptimeMillis() - this.f21566d)) > f21565c;
    }

    @Override // com.oplus.camera.p172ui.preview.AnimManager
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22975a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, BasicTexture abstractC2752c) {
        Context context;
        float fUptimeMillis = SystemClock.uptimeMillis() - this.f21566d;
        float COUIBaseListPopupWindow_12 = f21565c;
        if (fUptimeMillis > COUIBaseListPopupWindow_12) {
            return false;
        }
        float interpolation = this.f21570h.getInterpolation(fUptimeMillis / COUIBaseListPopupWindow_12);
        if (this.f21575m <= 0.5f && interpolation > 0.5f && (context = this.f21572j) != null) {
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.preview.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SwitchAnimManager.this.f21577o != null) {
                        SwitchAnimManager.this.f21577o.mo11051b();
                    }
                }
            });
        }
        this.f21575m = interpolation;
        m22970a(interfaceC2757h, interpolation, 180.0f * interpolation);
        float f2 = i3;
        float f3 = OplusGLSurfaceView_13 + (f2 / 2.0f);
        float f4 = i4;
        float f5 = i2 + (f4 / 2.0f);
        if (interpolation < 0.1f) {
            float f6 = 1.0f - ((interpolation / 0.1f) * 0.1f);
            float f7 = f2 * f6;
            float f8 = f6 * f4;
            abstractC2752c.m13928a(interfaceC2757h, Math.round(f3 - (f7 / 2.0f)), Math.round(f5 - (f8 / 2.0f)), Math.round(f7), Math.round(f8));
            return true;
        }
        float f9 = interpolation - 0.1f;
        if (f9 < 0.8f) {
            float f10 = f2 * 0.9f;
            float f11 = f4 * 0.9f;
            int iRound = Math.round(f3 - (f10 / 2.0f));
            int iRound2 = Math.round(f5 - (f11 / 2.0f));
            if (f9 < 0.4f) {
                interfaceC2757h.mo13959a(f3, 0.0f);
                interfaceC2757h.mo13962a((f9 / 0.4f) * 90.0f, 0.0f, 1.0f, 0.0f, 0.0f, i4 / 2, f4 * this.f21571i);
                interfaceC2757h.mo13959a(-f3, 0.0f);
                abstractC2752c.m13928a(interfaceC2757h, iRound, iRound2, Math.round(f10), Math.round(f11));
                return true;
            }
            interfaceC2757h.mo13959a(f3, 0.0f);
            interfaceC2757h.mo13962a(270.0f + (((f9 - 0.4f) / 0.4f) * 90.0f), 0.0f, 1.0f, 0.0f, 0.0f, i4 / 2, f4 * this.f21571i);
            interfaceC2757h.mo13959a(-f3, 0.0f);
            abstractC2752c.m13928a(interfaceC2757h, iRound, iRound2, Math.round(f10), Math.round(f11));
            return true;
        }
        float f12 = 1.0f - (((1.0f - interpolation) / 0.1f) * 0.1f);
        float f13 = f2 * f12;
        float f14 = f12 * f4;
        abstractC2752c.m13928a(interfaceC2757h, Math.round(f3 - (f13 / 2.0f)), Math.round(f5 - (f14 / 2.0f)), Math.round(f13), Math.round(f14));
        return true;
    }

    @Override // com.oplus.camera.p172ui.preview.AnimManager
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo22978b(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, BasicTexture abstractC2752c) {
        float COUIBaseListPopupWindow_12;
        float f2 = i3;
        float f3 = OplusGLSurfaceView_13 + (f2 / 2.0f);
        float f4 = i2 + (i4 / 2.0f);
        int i5 = this.f21569g;
        if (i5 != 0) {
            COUIBaseListPopupWindow_12 = f2 / i5;
        } else {
            CameraLog.m12967f("SwitchAnimManager", "mPreviewFrameLayoutWidth is 0.");
            COUIBaseListPopupWindow_12 = 1.0f;
        }
        float f5 = this.f21567e * COUIBaseListPopupWindow_12;
        float f6 = this.f21568f * COUIBaseListPopupWindow_12;
        int iRound = Math.round(f3 - (f5 / 2.0f));
        int iRound2 = Math.round(f4 - (f6 / 2.0f));
        float fMo13979b = interfaceC2757h.mo13979b();
        interfaceC2757h.mo13958a(0.8f);
        abstractC2752c.m13928a(interfaceC2757h, iRound, iRound2, Math.round(f5), Math.round(f6));
        interfaceC2757h.mo13958a(fMo13979b);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22970a(GLCanvas interfaceC2757h, float COUIBaseListPopupWindow_12, float f2) {
        float f3 = (1.0f - (COUIBaseListPopupWindow_12 * COUIBaseListPopupWindow_12)) + 0.4f;
        if (COUIBaseListPopupWindow_12 >= 0.7f) {
            interfaceC2757h.mo13958a(f3);
            this.f21576n = f3;
        }
        float[] fArr = f21563a;
        if (fArr[0] > f2 || f2 > fArr[1]) {
            return;
        }
        float fAbs = (Math.abs(90.0f - f2) * this.f21574l) + f21564b[0];
        interfaceC2757h.mo13958a(fAbs);
        this.f21576n = fAbs;
    }

    @Override // com.oplus.camera.p172ui.preview.AnimManager
    /* renamed from: PlatformImplementations.kt_3 */
    public float mo22971a() {
        return this.f21576n;
    }

    /* compiled from: SwitchAnimManager.java */
    /* renamed from: com.oplus.camera.ui.preview.aa$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends PathInterpolator {
        PlatformImplementations.kt_3(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
            super(COUIBaseListPopupWindow_12, f2, f3, f4);
        }
    }
}
