package com.airbnb.lottie.p084c.p086b;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.ShapeContent_2;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p084c.p085a.AnimatableShapeValue_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;

/* compiled from: ShapePath.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.o */
/* loaded from: classes.dex */
public class ShapePath_2 implements ContentModel_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f5576a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f5577b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableShapeValue_2 f5578c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final boolean f5579d;

    public ShapePath_2(String str, int OplusGLSurfaceView_13, AnimatableShapeValue_2 c1096h, boolean z) {
        this.f5576a = str;
        this.f5577b = OplusGLSurfaceView_13;
        this.f5578c = c1096h;
        this.f5579d = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5732a() {
        return this.f5576a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableShapeValue_2 m5733b() {
        return this.f5578c;
    }

    @Override // com.airbnb.lottie.p084c.p086b.ContentModel_2
    /* renamed from: PlatformImplementations.kt_3 */
    public Content_2 mo5651a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a) {
        return new ShapeContent_2(c1187f, abstractC1122a, this);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m5734c() {
        return this.f5579d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f5576a + ", index=" + this.f5577b + '}';
    }
}
