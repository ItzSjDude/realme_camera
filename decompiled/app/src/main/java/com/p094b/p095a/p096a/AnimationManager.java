package com.p094b.p095a.p096a;

import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.p094b.p095a.Log;
import com.p094b.p095a.ModelActivity;
import com.p094b.p095a.ModelSurfaceView;
import com.p094b.p095a.U;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

/* compiled from: AnimationManager.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class AnimationManager {

    /* renamed from: PlatformImplementations.kt_3 */
    boolean f6032a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean f6033b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    long f6034c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    long f6035d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    long f6036e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Map<Integer, AnimGroup> f6037f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f6038g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f6039h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f6040i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f6041j;

    /* renamed from: PlatformImplementations.kt_3 */
    public AnimationManager m6260a(boolean z) {
        return this;
    }

    public AnimationManager() {
        this(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    public AnimationManager(long OplusGLSurfaceView_15) {
        this.f6037f = new HashMap();
        this.f6038g = false;
        this.f6039h = false;
        this.f6032a = false;
        this.f6033b = false;
        this.f6034c = 0L;
        this.f6035d = 0L;
        this.f6036e = 0L;
        this.f6040i = 0;
        this.f6041j = 0;
        this.f6036e = OplusGLSurfaceView_15 < 1 ? DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS : OplusGLSurfaceView_15;
        this.f6041j = (int) ((OplusGLSurfaceView_15 * 30.0f) / 1000.0f);
        m6256d();
        this.f6037f.put(0, new AnimGroup(this, 0));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6262a(long OplusGLSurfaceView_15) {
        this.f6036e = OplusGLSurfaceView_15;
        this.f6041j = (int) ((OplusGLSurfaceView_15 * 30.0f) / 1000.0f);
        m6256d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m6256d() {
        this.f6041j += 5;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public AnimationManager m6259a(IAnimator interfaceC1229j) {
        if (interfaceC1229j instanceof AnimGroup) {
            AnimGroup c1222c = (AnimGroup) interfaceC1229j;
            U.m6362a(!this.f6037f.containsKey(Integer.valueOf(c1222c.f6024c)));
            this.f6037f.put(Integer.valueOf(c1222c.f6024c), c1222c);
        } else {
            m6258a(0).m6244a(interfaceC1229j);
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public AnimGroup m6258a(int OplusGLSurfaceView_13) {
        if (this.f6037f.containsKey(Integer.valueOf(OplusGLSurfaceView_13))) {
            return this.f6037f.get(Integer.valueOf(OplusGLSurfaceView_13));
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6261a() {
        m6265c();
        this.f6033b = false;
        m6263a(new Consumer() { // from class: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.-$$Lambda$COUIBaseListPopupWindow_8$LmysiJgAgWlX4SySnezuoPDoFP0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.COUIBaseListPopupWindow_12$0.m6257d((AnimGroup) obj);
            }
        });
        this.f6034c = System.currentTimeMillis();
        this.f6035d = 0L;
        m6263a(new Consumer() { // from class: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.-$$Lambda$COUIBaseListPopupWindow_8$0r82rxXMXqBv6jbljtNdkTESh-Q
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((AnimGroup) obj).mo6248b();
            }
        });
        this.f6039h = false;
        if (ModelActivity.m6280a() != null) {
            ModelActivity.m6280a().m6284c().m6332a(this);
            this.f6038g = true;
            m6253b(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m6257d(AnimGroup c1222c) {
        this.f6036e = Math.max(this.f6036e, c1222c.m6243a());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6263a(Consumer<AnimGroup> consumer) {
        Iterator<AnimGroup> it = this.f6037f.values().iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m6264b() {
        if (this.f6038g && !this.f6039h) {
            this.f6035d = Math.min(System.currentTimeMillis() - this.f6034c, this.f6036e);
            m6263a(new Consumer() { // from class: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.-$$Lambda$COUIBaseListPopupWindow_8$urz0deaNPxIS6_YTT3SiVoVX8C4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.COUIBaseListPopupWindow_12$0.m6254b((AnimGroup) obj);
                }
            });
            int OplusGLSurfaceView_13 = this.f6040i;
            if (OplusGLSurfaceView_13 == this.f6041j) {
                this.f6039h = true;
            } else {
                this.f6040i = OplusGLSurfaceView_13 + 1;
            }
        }
        return this.f6039h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m6254b(AnimGroup c1222c) {
        c1222c.mo6246a(this.f6040i / this.f6041j);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6265c() {
        this.f6040i = 0;
        if (this.f6038g) {
            m6263a(new Consumer() { // from class: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.-$$Lambda$COUIBaseListPopupWindow_8$qRJZYqrm_kkhdIKfvvLKWkcvAnA
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((AnimGroup) obj).mo6251d();
                }
            });
            this.f6038g = false;
            m6253b(2);
        }
        if (ModelActivity.m6280a() != null) {
            ModelActivity.m6280a().m6284c().m6338b(this);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m6253b(int OplusGLSurfaceView_13) {
        ModelSurfaceView c1234eM6285d;
        if (ModelActivity.m6280a() == null || (c1234eM6285d = ModelActivity.m6280a().m6285d()) == null || c1234eM6285d.f6173a == null) {
            return;
        }
        if (OplusGLSurfaceView_13 == 0) {
            Log.m6277c("SurfaceListener", "Calling onAnimationStart on " + c1234eM6285d.f6173a);
            c1234eM6285d.f6173a.mo6354a(this);
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            Log.m6277c("SurfaceListener", "Calling onAnimationComplete on " + c1234eM6285d.f6173a);
            c1234eM6285d.f6173a.mo6357b(this);
            return;
        }
        if (OplusGLSurfaceView_13 != 2) {
            return;
        }
        Log.m6277c("SurfaceListener", "Calling onAnimationFinish on " + c1234eM6285d.f6173a);
        c1234eM6285d.f6173a.mo6358c(this);
    }
}
