package com.p078a.p079a;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;

/* compiled from: AndroidSpringLooperFactory.java */
/* renamed from: com.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
abstract class AndroidSpringLooperFactory {
    /* renamed from: PlatformImplementations.kt_3 */
    public static SpringLooper m5430a() {
        if (Build.VERSION.SDK_INT >= 16) {
            return PlatformImplementations.kt_3.m5432a();
        }
        return IntrinsicsJvm.kt_4.m5440a();
    }

    /* compiled from: AndroidSpringLooperFactory.java */
    /* renamed from: com.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 extends SpringLooper {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Handler f5160b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final Runnable f5161c = new Runnable() { // from class: com.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.1
            @Override // java.lang.Runnable
            public void run() {
                if (!IntrinsicsJvm.kt_4.this.f5162d || IntrinsicsJvm.kt_4.this.f5195a == null) {
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                IntrinsicsJvm.kt_4.this.f5195a.m5450b(jUptimeMillis - IntrinsicsJvm.kt_4.this.f5163e);
                IntrinsicsJvm.kt_4.this.f5163e = jUptimeMillis;
                IntrinsicsJvm.kt_4.this.f5160b.post(IntrinsicsJvm.kt_4.this.f5161c);
            }
        };

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f5162d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private long f5163e;

        /* renamed from: PlatformImplementations.kt_3 */
        public static SpringLooper m5440a() {
            return new IntrinsicsJvm.kt_4(new Handler());
        }

        public IntrinsicsJvm.kt_4(Handler handler) {
            this.f5160b = handler;
        }

        @Override // com.p078a.p079a.SpringLooper
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo5437b() {
            if (this.f5162d) {
                return;
            }
            this.f5162d = true;
            this.f5163e = SystemClock.uptimeMillis();
            this.f5160b.removeCallbacks(this.f5161c);
            this.f5160b.post(this.f5161c);
        }

        @Override // com.p078a.p079a.SpringLooper
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo5438c() {
            this.f5162d = false;
            this.f5160b.removeCallbacks(this.f5161c);
        }
    }

    /* compiled from: AndroidSpringLooperFactory.java */
    @TargetApi(16)
    /* renamed from: com.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends SpringLooper {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Choreographer f5155b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final Choreographer.FrameCallback f5156c = new Choreographer.FrameCallback() { // from class: com.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long OplusGLSurfaceView_15) {
                if (!PlatformImplementations.kt_3.this.f5157d || PlatformImplementations.kt_3.this.f5195a == null) {
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                PlatformImplementations.kt_3.this.f5195a.m5450b(jUptimeMillis - PlatformImplementations.kt_3.this.f5158e);
                PlatformImplementations.kt_3.this.f5158e = jUptimeMillis;
                PlatformImplementations.kt_3.this.f5155b.postFrameCallback(PlatformImplementations.kt_3.this.f5156c);
            }
        };

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f5157d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private long f5158e;

        /* renamed from: PlatformImplementations.kt_3 */
        public static PlatformImplementations.kt_3 m5432a() {
            return new PlatformImplementations.kt_3(Choreographer.getInstance());
        }

        public PlatformImplementations.kt_3(Choreographer choreographer) {
            this.f5155b = choreographer;
        }

        @Override // com.p078a.p079a.SpringLooper
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo5437b() {
            if (this.f5157d) {
                return;
            }
            this.f5157d = true;
            this.f5158e = SystemClock.uptimeMillis();
            this.f5155b.removeFrameCallback(this.f5156c);
            this.f5155b.postFrameCallback(this.f5156c);
        }

        @Override // com.p078a.p079a.SpringLooper
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo5438c() {
            this.f5157d = false;
            this.f5155b.removeFrameCallback(this.f5156c);
        }
    }
}
