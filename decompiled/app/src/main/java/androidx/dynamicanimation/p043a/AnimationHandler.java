package androidx.dynamicanimation.p043a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: AnimationHandler.java */
/* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
class AnimationHandler {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final ThreadLocal<AnimationHandler> f3265a = new ThreadLocal<>();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private IntrinsicsJvm.kt_3 f3270f;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final SimpleArrayMap<IntrinsicsJvm.kt_4, Long> f3268d = new SimpleArrayMap<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    final ArrayList<IntrinsicsJvm.kt_4> f3266b = new ArrayList<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final PlatformImplementations.kt_3 f3269e = new PlatformImplementations.kt_3();

    /* renamed from: IntrinsicsJvm.kt_3 */
    long f3267c = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f3271g = false;

    /* compiled from: AnimationHandler.java */
    /* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo3188a(long OplusGLSurfaceView_15);
    }

    AnimationHandler() {
    }

    /* compiled from: AnimationHandler.java */
    /* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    class PlatformImplementations.kt_3 {
        PlatformImplementations.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m3187a() {
            AnimationHandler.this.f3267c = SystemClock.uptimeMillis();
            AnimationHandler c0547a = AnimationHandler.this;
            c0547a.m3183a(c0547a.f3267c);
            if (AnimationHandler.this.f3266b.size() > 0) {
                AnimationHandler.this.m3186b().mo3189a();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static AnimationHandler m3180a() {
        if (f3265a.get() == null) {
            f3265a.set(new AnimationHandler());
        }
        return f3265a.get();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    IntrinsicsJvm.kt_3 m3186b() {
        if (this.f3270f == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f3270f = new COUIBaseListPopupWindow_8(this.f3269e);
            } else {
                this.f3270f = new IntrinsicsJvm.kt_5(this.f3269e);
            }
        }
        return this.f3270f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3185a(IntrinsicsJvm.kt_4 bVar, long OplusGLSurfaceView_15) {
        if (this.f3266b.size() == 0) {
            m3186b().mo3189a();
        }
        if (!this.f3266b.contains(bVar)) {
            this.f3266b.add(bVar);
        }
        if (OplusGLSurfaceView_15 > 0) {
            this.f3268d.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + OplusGLSurfaceView_15));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3184a(IntrinsicsJvm.kt_4 bVar) {
        this.f3268d.remove(bVar);
        int iIndexOf = this.f3266b.indexOf(bVar);
        if (iIndexOf >= 0) {
            this.f3266b.set(iIndexOf, null);
            this.f3271g = true;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3183a(long OplusGLSurfaceView_15) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3266b.size(); OplusGLSurfaceView_13++) {
            IntrinsicsJvm.kt_4 bVar = this.f3266b.get(OplusGLSurfaceView_13);
            if (bVar != null && m3181b(bVar, jUptimeMillis)) {
                bVar.mo3188a(OplusGLSurfaceView_15);
            }
        }
        m3182c();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m3181b(IntrinsicsJvm.kt_4 bVar, long OplusGLSurfaceView_15) {
        Long OplusGLSurfaceView_14 = this.f3268d.get(bVar);
        if (OplusGLSurfaceView_14 == null) {
            return true;
        }
        if (OplusGLSurfaceView_14.longValue() >= OplusGLSurfaceView_15) {
            return false;
        }
        this.f3268d.remove(bVar);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m3182c() {
        if (this.f3271g) {
            for (int size = this.f3266b.size() - 1; size >= 0; size--) {
                if (this.f3266b.get(size) == null) {
                    this.f3266b.remove(size);
                }
            }
            this.f3271g = false;
        }
    }

    /* compiled from: AnimationHandler.java */
    /* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.PlatformImplementations.kt_3$COUIBaseListPopupWindow_8 */
    private static class COUIBaseListPopupWindow_8 extends IntrinsicsJvm.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Choreographer f3278b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final Choreographer.FrameCallback f3279c;

        COUIBaseListPopupWindow_8(PlatformImplementations.kt_3 aVar) {
            super(aVar);
            this.f3278b = Choreographer.getInstance();
            this.f3279c = new Choreographer.FrameCallback() { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long OplusGLSurfaceView_15) {
                    COUIBaseListPopupWindow_8.this.f3273a.m3187a();
                }
            };
        }

        @Override // androidx.dynamicanimation.p043a.AnimationHandler.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        void mo3189a() {
            this.f3278b.postFrameCallback(this.f3279c);
        }
    }

    /* compiled from: AnimationHandler.java */
    /* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_5 */
    private static class IntrinsicsJvm.kt_5 extends IntrinsicsJvm.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        long f3274b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final Runnable f3275c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final Handler f3276d;

        IntrinsicsJvm.kt_5(PlatformImplementations.kt_3 aVar) {
            super(aVar);
            this.f3274b = -1L;
            this.f3275c = new Runnable() { // from class: androidx.dynamicanimation.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.1
                @Override // java.lang.Runnable
                public void run() {
                    IntrinsicsJvm.kt_5.this.f3274b = SystemClock.uptimeMillis();
                    IntrinsicsJvm.kt_5.this.f3273a.m3187a();
                }
            };
            this.f3276d = new Handler(Looper.myLooper());
        }

        @Override // androidx.dynamicanimation.p043a.AnimationHandler.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        void mo3189a() {
            this.f3276d.postDelayed(this.f3275c, Math.max(10 - (SystemClock.uptimeMillis() - this.f3274b), 0L));
        }
    }

    /* compiled from: AnimationHandler.java */
    /* renamed from: androidx.dynamicanimation.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    static abstract class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final PlatformImplementations.kt_3 f3273a;

        /* renamed from: PlatformImplementations.kt_3 */
        abstract void mo3189a();

        IntrinsicsJvm.kt_3(PlatformImplementations.kt_3 aVar) {
            this.f3273a = aVar;
        }
    }
}
