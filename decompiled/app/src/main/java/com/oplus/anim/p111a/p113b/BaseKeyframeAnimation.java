package com.oplus.anim.p111a.p113b;

import com.oplus.anim.p122g.EffectiveValueCallback;
import com.oplus.anim.p122g.Keyframe;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class BaseKeyframeAnimation<K, A> {

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected EffectiveValueCallback<A> f9998b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final List<? extends Keyframe<K>> f9999c;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Keyframe<K> f10002f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Keyframe<K> f10003g;

    /* renamed from: PlatformImplementations.kt_3 */
    final List<PlatformImplementations.kt_3> f9997a = new ArrayList(1);

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f10000d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f10001e = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f10004h = -1.0f;

    /* renamed from: OplusGLSurfaceView_13 */
    private A f10005i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f10006j = -1.0f;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f10007k = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo8806a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    abstract A mo8844a(Keyframe<K> c2413c, float COUIBaseListPopupWindow_12);

    BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        this.f9999c = list;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8845a() {
        this.f10000d = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8847a(PlatformImplementations.kt_3 aVar) {
        this.f9997a.add(aVar);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo8849b() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f9997a.size(); OplusGLSurfaceView_13++) {
            this.f9997a.get(OplusGLSurfaceView_13).mo8806a();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected Keyframe<K> m8850c() {
        Keyframe<K> c2413c = this.f10002f;
        if (c2413c != null && c2413c.m9327a(this.f10001e)) {
            return this.f10002f;
        }
        Keyframe<K> c2413c2 = this.f9999c.get(r0.size() - 1);
        if (this.f10001e < c2413c2.m9328c()) {
            for (int size = this.f9999c.size() - 1; size >= 0; size--) {
                c2413c2 = this.f9999c.get(size);
                if (c2413c2.m9327a(this.f10001e)) {
                    break;
                }
            }
        }
        this.f10002f = c2413c2;
        return c2413c2;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    float m8851d() {
        if (this.f10000d) {
            return 0.0f;
        }
        Keyframe<K> c2413cM8850c = m8850c();
        if (c2413cM8850c.m9330e()) {
            return 0.0f;
        }
        return (this.f10001e - c2413cM8850c.m9328c()) / (c2413cM8850c.m9329d() - c2413cM8850c.m9328c());
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected float m8852e() {
        Keyframe<K> c2413cM8850c = m8850c();
        if (c2413cM8850c.m9330e()) {
            return 0.0f;
        }
        return c2413cM8850c.f10422b.getInterpolation(m8851d());
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private float m8843i() {
        if (this.f10006j == -1.0f) {
            this.f10006j = this.f9999c.isEmpty() ? 0.0f : this.f9999c.get(0).m9328c();
        }
        return this.f10006j;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    float mo8853f() {
        float fM9329d;
        if (this.f10007k == -1.0f) {
            if (this.f9999c.isEmpty()) {
                fM9329d = 1.0f;
            } else {
                fM9329d = this.f9999c.get(r0.size() - 1).m9329d();
            }
            this.f10007k = fM9329d;
        }
        return this.f10007k;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public A mo8854g() {
        Keyframe<K> c2413cM8850c = m8850c();
        float fM8852e = m8852e();
        if (this.f9998b == null && c2413cM8850c == this.f10003g && this.f10004h == fM8852e) {
            return this.f10005i;
        }
        this.f10003g = c2413cM8850c;
        this.f10004h = fM8852e;
        A aMo8844a = mo8844a(c2413cM8850c, fM8852e);
        this.f10005i = aMo8844a;
        return aMo8844a;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public float m8855h() {
        return this.f10001e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8846a(float COUIBaseListPopupWindow_12) {
        if (this.f9999c.isEmpty()) {
            return;
        }
        Keyframe<K> c2413cM8850c = m8850c();
        if (COUIBaseListPopupWindow_12 < m8843i()) {
            COUIBaseListPopupWindow_12 = m8843i();
        } else if (COUIBaseListPopupWindow_12 > mo8853f()) {
            COUIBaseListPopupWindow_12 = mo8853f();
        }
        if (COUIBaseListPopupWindow_12 == this.f10001e) {
            return;
        }
        this.f10001e = COUIBaseListPopupWindow_12;
        Keyframe<K> c2413cM8850c2 = m8850c();
        if (c2413cM8850c == c2413cM8850c2 && c2413cM8850c2.m9330e()) {
            return;
        }
        mo8849b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8848a(EffectiveValueCallback<A> c2412b) {
        EffectiveValueCallback<A> c2412b2 = this.f9998b;
        if (c2412b2 != null) {
            c2412b2.m9326a((BaseKeyframeAnimation<?, ?>) null);
        }
        this.f9998b = c2412b;
        if (c2412b != null) {
            c2412b.m9326a((BaseKeyframeAnimation<?, ?>) this);
        }
    }
}
