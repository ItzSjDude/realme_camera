package com.airbnb.lottie.p080a.p082b;

import com.airbnb.lottie.L_2;
import com.airbnb.lottie.p092g.Keyframe_2;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class BaseKeyframeAnimation_3<K, A> {

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected LottieValueCallback<A> f5406c;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final IntrinsicsJvm.kt_3<K> f5408e;

    /* renamed from: PlatformImplementations.kt_3 */
    final List<PlatformImplementations.kt_3> f5404a = new ArrayList(1);

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f5407d = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected float f5405b = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private A f5409f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f5410g = -1.0f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f5411h = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo5530a();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    private interface IntrinsicsJvm.kt_3<T> {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo5585a();

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo5586a(float COUIBaseListPopupWindow_12);

        /* renamed from: IntrinsicsJvm.kt_4 */
        Keyframe_2<T> mo5587b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo5588b(float COUIBaseListPopupWindow_12);

        /* renamed from: IntrinsicsJvm.kt_3 */
        float mo5589c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        float mo5590d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    abstract A mo5572a(Keyframe_2<K> c1197a, float COUIBaseListPopupWindow_12);

    BaseKeyframeAnimation_3(List<? extends Keyframe_2<K>> list) {
        this.f5408e = m5570a(list);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5574a() {
        this.f5407d = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5576a(PlatformImplementations.kt_3 aVar) {
        this.f5404a.add(aVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5575a(float COUIBaseListPopupWindow_12) {
        if (this.f5408e.mo5585a()) {
            return;
        }
        if (COUIBaseListPopupWindow_12 < m5571i()) {
            COUIBaseListPopupWindow_12 = m5571i();
        } else if (COUIBaseListPopupWindow_12 > mo5582f()) {
            COUIBaseListPopupWindow_12 = mo5582f();
        }
        if (COUIBaseListPopupWindow_12 == this.f5405b) {
            return;
        }
        this.f5405b = COUIBaseListPopupWindow_12;
        if (this.f5408e.mo5586a(COUIBaseListPopupWindow_12)) {
            mo5578b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo5578b() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5404a.size(); OplusGLSurfaceView_13++) {
            this.f5404a.get(OplusGLSurfaceView_13).mo5530a();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected Keyframe_2<K> m5579c() {
        L_2.m5637a("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe_2<K> c1197aMo5587b = this.f5408e.mo5587b();
        L_2.m5638b("BaseKeyframeAnimation#getCurrentKeyframe");
        return c1197aMo5587b;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    float m5580d() {
        if (this.f5407d) {
            return 0.0f;
        }
        Keyframe_2<K> c1197aM5579c = m5579c();
        if (c1197aM5579c.m6166e()) {
            return 0.0f;
        }
        return (this.f5405b - c1197aM5579c.m6164c()) / (c1197aM5579c.m6165d() - c1197aM5579c.m6164c());
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected float m5581e() {
        Keyframe_2<K> c1197aM5579c = m5579c();
        if (c1197aM5579c.m6166e()) {
            return 0.0f;
        }
        return c1197aM5579c.f5896c.getInterpolation(m5580d());
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private float m5571i() {
        if (this.f5410g == -1.0f) {
            this.f5410g = this.f5408e.mo5589c();
        }
        return this.f5410g;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    float mo5582f() {
        if (this.f5411h == -1.0f) {
            this.f5411h = this.f5408e.mo5590d();
        }
        return this.f5411h;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public A mo5583g() {
        A aMo5572a;
        float fM5580d = m5580d();
        if (this.f5406c == null && this.f5408e.mo5588b(fM5580d)) {
            return this.f5409f;
        }
        Keyframe_2<K> c1197aM5579c = m5579c();
        if (c1197aM5579c.f5897d != null && c1197aM5579c.f5898e != null) {
            aMo5572a = mo5573a(c1197aM5579c, fM5580d, c1197aM5579c.f5897d.getInterpolation(fM5580d), c1197aM5579c.f5898e.getInterpolation(fM5580d));
        } else {
            aMo5572a = mo5572a(c1197aM5579c, m5581e());
        }
        this.f5409f = aMo5572a;
        return aMo5572a;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public float m5584h() {
        return this.f5405b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5577a(LottieValueCallback<A> c1199c) {
        LottieValueCallback<A> c1199c2 = this.f5406c;
        if (c1199c2 != null) {
            c1199c2.m6173a((BaseKeyframeAnimation_3<?, ?>) null);
        }
        this.f5406c = c1199c;
        if (c1199c != null) {
            c1199c.m6173a((BaseKeyframeAnimation_3<?, ?>) this);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected A mo5573a(Keyframe_2<K> c1197a, float COUIBaseListPopupWindow_12, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> IntrinsicsJvm.kt_3<T> m5570a(List<? extends Keyframe_2<T>> list) {
        if (list.isEmpty()) {
            return new IntrinsicsJvm.kt_4();
        }
        if (list.size() == 1) {
            return new COUIBaseListPopupWindow_8(list);
        }
        return new IntrinsicsJvm.kt_5(list);
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private static final class IntrinsicsJvm.kt_4<T> implements IntrinsicsJvm.kt_3<T> {
        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo5585a() {
            return true;
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo5586a(float COUIBaseListPopupWindow_12) {
            return false;
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public float mo5589c() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_5 */
        public float mo5590d() {
            return 1.0f;
        }

        private IntrinsicsJvm.kt_4() {
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public Keyframe_2<T> mo5587b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo5588b(float COUIBaseListPopupWindow_12) {
            throw new IllegalStateException("not implemented");
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$COUIBaseListPopupWindow_8 */
    private static final class COUIBaseListPopupWindow_8<T> implements IntrinsicsJvm.kt_3<T> {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Keyframe_2<T> f5416a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private float f5417b = -1.0f;

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo5585a() {
            return false;
        }

        COUIBaseListPopupWindow_8(List<? extends Keyframe_2<T>> list) {
            this.f5416a = list.get(0);
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo5586a(float COUIBaseListPopupWindow_12) {
            return !this.f5416a.m6166e();
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public Keyframe_2<T> mo5587b() {
            return this.f5416a;
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public float mo5589c() {
            return this.f5416a.m6164c();
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_5 */
        public float mo5590d() {
            return this.f5416a.m6165d();
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo5588b(float COUIBaseListPopupWindow_12) {
            if (this.f5417b == COUIBaseListPopupWindow_12) {
                return true;
            }
            this.f5417b = COUIBaseListPopupWindow_12;
            return false;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_5 */
    private static final class IntrinsicsJvm.kt_5<T> implements IntrinsicsJvm.kt_3<T> {

        /* renamed from: PlatformImplementations.kt_3 */
        private final List<? extends Keyframe_2<T>> f5412a;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Keyframe_2<T> f5414c = null;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private float f5415d = -1.0f;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Keyframe_2<T> f5413b = m5591c(0.0f);

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo5585a() {
            return false;
        }

        IntrinsicsJvm.kt_5(List<? extends Keyframe_2<T>> list) {
            this.f5412a = list;
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo5586a(float COUIBaseListPopupWindow_12) {
            if (this.f5413b.m6163a(COUIBaseListPopupWindow_12)) {
                return !this.f5413b.m6166e();
            }
            this.f5413b = m5591c(COUIBaseListPopupWindow_12);
            return true;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Keyframe_2<T> m5591c(float COUIBaseListPopupWindow_12) {
            List<? extends Keyframe_2<T>> list = this.f5412a;
            Keyframe_2<T> c1197a = list.get(list.size() - 1);
            if (COUIBaseListPopupWindow_12 >= c1197a.m6164c()) {
                return c1197a;
            }
            for (int size = this.f5412a.size() - 2; size >= 1; size--) {
                Keyframe_2<T> c1197a2 = this.f5412a.get(size);
                if (this.f5413b != c1197a2 && c1197a2.m6163a(COUIBaseListPopupWindow_12)) {
                    return c1197a2;
                }
            }
            return this.f5412a.get(0);
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public Keyframe_2<T> mo5587b() {
            return this.f5413b;
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public float mo5589c() {
            return this.f5412a.get(0).m6164c();
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_5 */
        public float mo5590d() {
            return this.f5412a.get(r1.size() - 1).m6165d();
        }

        @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.IntrinsicsJvm.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo5588b(float COUIBaseListPopupWindow_12) {
            if (this.f5414c == this.f5413b && this.f5415d == COUIBaseListPopupWindow_12) {
                return true;
            }
            this.f5414c = this.f5413b;
            this.f5415d = COUIBaseListPopupWindow_12;
            return false;
        }
    }
}
