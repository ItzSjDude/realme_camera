package com.airbnb.lottie.p080a.p081a;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p084c.p086b.ShapePath_2;
import com.airbnb.lottie.p084c.p086b.ShapeTrimPath_3;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import java.util.List;

/* compiled from: ShapeContent.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.q */
/* loaded from: classes.dex */
public class ShapeContent_2 implements PathContent_2, BaseKeyframeAnimation_3.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f5386b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final boolean f5387c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final LottieDrawable f5388d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final BaseKeyframeAnimation_3<?, Path> f5389e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f5390f;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Path f5385a = new Path();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CompoundTrimPathContent_2 f5391g = new CompoundTrimPathContent_2();

    public ShapeContent_2(LottieDrawable c1187f, BaseLayer_3 abstractC1122a, ShapePath_2 c1118o) {
        this.f5386b = c1118o.m5732a();
        this.f5387c = c1118o.m5734c();
        this.f5388d = c1187f;
        this.f5389e = c1118o.m5733b().mo5647a();
        abstractC1122a.m5774a(this.f5389e);
        this.f5389e.m5576a(this);
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5530a() {
        m5563c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m5563c() {
        this.f5390f = false;
        this.f5388d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5535a(List<Content_2> list, List<Content_2> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            Content_2 interfaceC1051c = list.get(OplusGLSurfaceView_13);
            if (interfaceC1051c instanceof TrimPathContent_2) {
                TrimPathContent_2 c1067s = (TrimPathContent_2) interfaceC1051c;
                if (c1067s.m5565c() == ShapeTrimPath_3.PlatformImplementations.kt_3.SIMULTANEOUSLY) {
                    this.f5391g.m5539a(c1067s);
                    c1067s.m5564a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.p080a.p081a.PathContent_2
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo5546e() {
        if (this.f5390f) {
            return this.f5385a;
        }
        this.f5385a.reset();
        if (this.f5387c) {
            this.f5390f = true;
            return this.f5385a;
        }
        this.f5385a.set(this.f5389e.mo5583g());
        this.f5385a.setFillType(Path.FillType.EVEN_ODD);
        this.f5391g.m5538a(this.f5385a);
        this.f5390f = true;
        return this.f5385a;
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo5540b() {
        return this.f5386b;
    }
}
