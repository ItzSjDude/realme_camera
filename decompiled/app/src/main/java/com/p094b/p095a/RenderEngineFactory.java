package com.p094b.p095a;

import android.app.Activity;
import android.view.Surface;
import com.p094b.p095a.p096a.AnimConfig;
import com.p094b.p095a.p096a.AnimID;
import com.p094b.p095a.p096a.IAnimator;
import java.net.URL;
import org.andresoviedo.p225a.p226a.AndroidURLStreamHandlerFactory;

/* compiled from: RenderEngineFactory.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class RenderEngineFactory {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f6198a = "OplusGLSurfaceView_13";

    /* renamed from: PlatformImplementations.kt_3 */
    public static RenderEngine m6321a(Activity activity, O3DPHOTO_MODEL c1236g) {
        return new PlatformImplementations.kt_3(activity, c1236g);
    }

    /* compiled from: RenderEngineFactory.java */
    /* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 implements RenderEngine {

        /* renamed from: PlatformImplementations.kt_3 */
        Activity f6200a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        O3DPHOTO_MODEL f6201b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        Surface f6202c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f6203d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        int f6204e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        SurfaceListener f6205f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        ModelViewConnection f6206g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        ModelViewConnection f6207h;

        PlatformImplementations.kt_3(Activity activity, O3DPHOTO_MODEL c1236g) {
            this.f6200a = activity;
            this.f6201b = c1236g;
            m6323c();
        }

        @Override // com.p094b.p095a.RenderEngine
        /* renamed from: PlatformImplementations.kt_3 */
        public RenderEngine mo6316a(Surface surface, int OplusGLSurfaceView_13, int i2) {
            this.f6202c = surface;
            this.f6203d = OplusGLSurfaceView_13;
            this.f6204e = i2;
            return this;
        }

        @Override // com.p094b.p095a.RenderEngine
        /* renamed from: PlatformImplementations.kt_3 */
        public RenderEngine mo6317a(SurfaceListener interfaceC1240k) {
            this.f6205f = interfaceC1240k;
            return this;
        }

        @Override // com.p094b.p095a.RenderEngine
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo6318a() {
            if (this.f6200a != null && this.f6201b != null) {
                ModelActivity.m6280a();
                ModelActivity.f6104b = this.f6201b;
                ModelActivity.m6280a().m6283a(this.f6207h, this.f6202c, this.f6203d, this.f6204e, this.f6205f);
                ModelActivity.m6280a().m6286e();
                return;
            }
            throw new RuntimeException("Not initialized");
        }

        @Override // com.p094b.p095a.RenderEngine
        /* renamed from: PlatformImplementations.kt_3 */
        public IAnimator mo6315a(AnimID enumC1223d, boolean z, AnimConfig c1220a) {
            SceneLoader c1239jM6284c;
            if (ModelActivity.m6280a() == null || (c1239jM6284c = ModelActivity.m6280a().m6284c()) == null) {
                return null;
            }
            int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f6199a[enumC1223d.ordinal()];
            if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 4) {
                if (c1220a == null) {
                    return c1239jM6284c.m6328a(enumC1223d, z);
                }
                return c1239jM6284c.m6329a(enumC1223d, z, c1220a);
            }
            Log.m6274a(RenderEngineFactory.f6198a, "Invalid animationID:" + enumC1223d);
            return null;
        }

        @Override // com.p094b.p095a.RenderEngine
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo6320b() {
            ModelActivity.m6280a().m6287f();
            this.f6200a = null;
            this.f6201b = null;
            this.f6202c = null;
            this.f6203d = 0;
            this.f6204e = 0;
            this.f6205f = null;
            this.f6206g = null;
            this.f6207h = null;
            ModelActivity.m6281b();
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private void m6323c() {
            this.f6207h = new ModelViewConnection() { // from class: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.OplusGLSurfaceView_13.PlatformImplementations.kt_3.1
                @Override // com.p094b.p095a.ModelViewConnection
                /* renamed from: PlatformImplementations.kt_3 */
                public Activity mo6314a() {
                    return PlatformImplementations.kt_3.this.f6206g == null ? PlatformImplementations.kt_3.this.f6200a : PlatformImplementations.kt_3.this.f6206g.mo6314a();
                }
            };
        }
    }

    /* compiled from: RenderEngineFactory.java */
    /* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.OplusGLSurfaceView_13$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f6199a = new int[AnimID.values().length];

        static {
            try {
                f6199a[AnimID.FixedGaze.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6199a[AnimID.DollyZoom.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6199a[AnimID.Circle.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6199a[AnimID.Swing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        System.setProperty("java.protocol.handler.pkgs", "org.andresoviedo.util.android");
        URL.setURLStreamHandlerFactory(new AndroidURLStreamHandlerFactory());
    }
}
