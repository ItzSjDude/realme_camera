package com.p094b.p095a;

import android.view.Surface;
import com.p094b.p095a.p096a.AnimationManager;

/* compiled from: SurfaceListener.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public interface SurfaceListener {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String f6238a = "OplusGLSurfaceView_5";

    /* renamed from: PlatformImplementations.kt_3 */
    void mo6353a(Surface surface);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo6354a(AnimationManager c1224e);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo6356b(Surface surface);

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo6357b(AnimationManager c1224e);

    /* renamed from: IntrinsicsJvm.kt_3 */
    void mo6358c(AnimationManager c1224e);

    /* renamed from: PlatformImplementations.kt_3 */
    default boolean m6355a(long OplusGLSurfaceView_15) throws InterruptedException {
        if (OplusGLSurfaceView_15 <= 0) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - OplusGLSurfaceView_15;
        if (jCurrentTimeMillis <= 0 || jCurrentTimeMillis >= 33) {
            return true;
        }
        try {
            Thread.sleep(33 - jCurrentTimeMillis);
            return true;
        } catch (InterruptedException COUIBaseListPopupWindow_8) {
            Log.m6274a(f6238a, "onFrameRenderFinished InterruptedException COUIBaseListPopupWindow_8 : " + COUIBaseListPopupWindow_8);
            return true;
        }
    }
}
