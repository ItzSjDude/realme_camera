package com.oplus.anim.p111a.p112a;

import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p115c.p117b.ShapeTrimPath;
import com.oplus.anim.p115c.p118c.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.s */
/* loaded from: classes2.dex */
public class TrimPathContent implements Content, BaseKeyframeAnimation.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f9990a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final boolean f9991b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final List<BaseKeyframeAnimation.PlatformImplementations.kt_3> f9992c = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final ShapeTrimPath.PlatformImplementations.kt_3 f9993d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final BaseKeyframeAnimation<?, Float> f9994e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final BaseKeyframeAnimation<?, Float> f9995f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final BaseKeyframeAnimation<?, Float> f9996g;

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8811a(List<Content> list, List<Content> list2) {
    }

    public TrimPathContent(BaseLayer abstractC2347a, ShapeTrimPath c2345q) {
        this.f9990a = c2345q.m9056a();
        this.f9991b = c2345q.m9061f();
        this.f9993d = c2345q.m9057b();
        this.f9994e = c2345q.m9059d().mo8957a();
        this.f9995f = c2345q.m9058c().mo8957a();
        this.f9996g = c2345q.m9060e().mo8957a();
        abstractC2347a.m9082a(this.f9994e);
        abstractC2347a.m9082a(this.f9995f);
        abstractC2347a.m9082a(this.f9996g);
        this.f9994e.m8847a(this);
        this.f9995f.m8847a(this);
        this.f9996g.m8847a(this);
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8806a() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f9992c.size(); OplusGLSurfaceView_13++) {
            this.f9992c.get(OplusGLSurfaceView_13).mo8806a();
        }
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo8816b() {
        return this.f9990a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m8837a(BaseKeyframeAnimation.PlatformImplementations.kt_3 aVar) {
        this.f9992c.add(aVar);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    ShapeTrimPath.PlatformImplementations.kt_3 m8838c() {
        return this.f9993d;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public BaseKeyframeAnimation<?, Float> m8839d() {
        return this.f9994e;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public BaseKeyframeAnimation<?, Float> m8840e() {
        return this.f9995f;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public BaseKeyframeAnimation<?, Float> m8841f() {
        return this.f9996g;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m8842g() {
        return this.f9991b;
    }
}
