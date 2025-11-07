package com.p094b.p095a;

import android.view.Surface;
import com.p094b.p095a.p096a.AnimConfig;
import com.p094b.p095a.p096a.AnimID;
import com.p094b.p095a.p096a.IAnimator;

/* compiled from: RenderEngine.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public interface RenderEngine {
    /* renamed from: PlatformImplementations.kt_3 */
    IAnimator mo6315a(AnimID enumC1223d, boolean z, AnimConfig c1220a);

    /* renamed from: PlatformImplementations.kt_3 */
    RenderEngine mo6316a(Surface surface, int OplusGLSurfaceView_13, int i2);

    /* renamed from: PlatformImplementations.kt_3 */
    RenderEngine mo6317a(SurfaceListener interfaceC1240k);

    /* renamed from: PlatformImplementations.kt_3 */
    void mo6318a();

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo6320b();

    /* renamed from: PlatformImplementations.kt_3 */
    default void m6319a(int OplusGLSurfaceView_13) {
        Config.f6014a = Math.min(10, Math.max(OplusGLSurfaceView_13, 0));
    }
}
