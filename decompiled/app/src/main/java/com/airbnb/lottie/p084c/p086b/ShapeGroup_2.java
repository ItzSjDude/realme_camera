package com.airbnb.lottie.p084c.p086b;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.ContentGroup_2;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
public class ShapeGroup_2 implements ContentModel_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f5573a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final List<ContentModel_2> f5574b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final boolean f5575c;

    public ShapeGroup_2(String str, List<ContentModel_2> list, boolean z) {
        this.f5573a = str;
        this.f5574b = list;
        this.f5575c = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5729a() {
        return this.f5573a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<ContentModel_2> m5730b() {
        return this.f5574b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m5731c() {
        return this.f5575c;
    }

    @Override // com.airbnb.lottie.p084c.p086b.ContentModel_2
    /* renamed from: PlatformImplementations.kt_3 */
    public Content_2 mo5651a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a) {
        return new ContentGroup_2(c1187f, abstractC1122a, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f5573a + "' Shapes: " + Arrays.toString(this.f5574b.toArray()) + '}';
    }
}
