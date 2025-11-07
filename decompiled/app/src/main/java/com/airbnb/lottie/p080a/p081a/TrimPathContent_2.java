package com.airbnb.lottie.p080a.p081a;

import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p084c.p086b.ShapeTrimPath_3;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.s */
/* loaded from: classes.dex */
public class TrimPathContent_2 implements Content_2, BaseKeyframeAnimation_3.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f5397a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final boolean f5398b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final List<BaseKeyframeAnimation_3.PlatformImplementations.kt_3> f5399c = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final ShapeTrimPath_3.PlatformImplementations.kt_3 f5400d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final BaseKeyframeAnimation_3<?, Float> f5401e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final BaseKeyframeAnimation_3<?, Float> f5402f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final BaseKeyframeAnimation_3<?, Float> f5403g;

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5535a(List<Content_2> list, List<Content_2> list2) {
    }

    public TrimPathContent_2(BaseLayer_3 abstractC1122a, ShapeTrimPath_3 c1120q) {
        this.f5397a = c1120q.m5745a();
        this.f5398b = c1120q.m5750f();
        this.f5400d = c1120q.m5746b();
        this.f5401e = c1120q.m5748d().mo5647a();
        this.f5402f = c1120q.m5747c().mo5647a();
        this.f5403g = c1120q.m5749e().mo5647a();
        abstractC1122a.m5774a(this.f5401e);
        abstractC1122a.m5774a(this.f5402f);
        abstractC1122a.m5774a(this.f5403g);
        this.f5401e.m5576a(this);
        this.f5402f.m5576a(this);
        this.f5403g.m5576a(this);
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5530a() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5399c.size(); OplusGLSurfaceView_13++) {
            this.f5399c.get(OplusGLSurfaceView_13).mo5530a();
        }
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo5540b() {
        return this.f5397a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5564a(BaseKeyframeAnimation_3.PlatformImplementations.kt_3 aVar) {
        this.f5399c.add(aVar);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    ShapeTrimPath_3.PlatformImplementations.kt_3 m5565c() {
        return this.f5400d;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public BaseKeyframeAnimation_3<?, Float> m5566d() {
        return this.f5401e;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public BaseKeyframeAnimation_3<?, Float> m5567e() {
        return this.f5402f;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public BaseKeyframeAnimation_3<?, Float> m5568f() {
        return this.f5403g;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m5569g() {
        return this.f5398b;
    }
}
