package com.oplus.camera.p172ui.preview;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;

/* compiled from: PreviewAnimManager.java */
/* renamed from: com.oplus.camera.ui.preview.v */
/* loaded from: classes2.dex */
public class PreviewAnimManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f22443a = true;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f22444b = true;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f22445c = true;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Interpolator f22446d = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: COUIBaseListPopupWindow_8 */
    private long f22447e = Long.MAX_VALUE;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private long f22448f = 180;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private long f22449g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final float f22450h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final float f22451i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f22452j;

    public PreviewAnimManager(float COUIBaseListPopupWindow_12, float f2) {
        this.f22452j = 0.0f;
        this.f22450h = COUIBaseListPopupWindow_12;
        this.f22451i = f2;
        this.f22452j = this.f22450h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23881a(boolean z) {
        this.f22443a = z;
        CameraLog.m12954a("PreviewAnimManager", "setNeedAnim, needAnim: " + z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m23882a() {
        if (!this.f22443a) {
            return false;
        }
        if (this.f22445c) {
            this.f22447e = SystemClock.uptimeMillis();
            this.f22445c = false;
        }
        if (!this.f22444b) {
            return false;
        }
        this.f22449g = SystemClock.uptimeMillis();
        float COUIBaseListPopupWindow_12 = (this.f22449g - this.f22447e) / this.f22448f;
        if (COUIBaseListPopupWindow_12 > 1.0f) {
            this.f22444b = false;
            this.f22452j = this.f22451i;
            return true;
        }
        float interpolation = this.f22446d.getInterpolation(COUIBaseListPopupWindow_12);
        float f2 = this.f22450h;
        this.f22452j = f2 + ((this.f22451i - f2) * interpolation);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m23883b() {
        return this.f22452j;
    }
}
