package com.airbnb.lottie.p084c.p086b;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.RectangleContent_2;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableValue_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;

/* compiled from: RectangleShape.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public class RectangleShape_2 implements ContentModel_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f5554a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AnimatableValue_2<PointF, PointF> f5555b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableValue_2<PointF, PointF> f5556c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableFloatValue_2 f5557d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean f5558e;

    public RectangleShape_2(String str, AnimatableValue_2<PointF, PointF> interfaceC1101m, AnimatableValue_2<PointF, PointF> interfaceC1101m2, AnimatableFloatValue_2 c1090b, boolean z) {
        this.f5554a = str;
        this.f5555b = interfaceC1101m;
        this.f5556c = interfaceC1101m2;
        this.f5557d = c1090b;
        this.f5558e = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5709a() {
        return this.f5554a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableFloatValue_2 m5710b() {
        return this.f5557d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableValue_2<PointF, PointF> m5711c() {
        return this.f5556c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableValue_2<PointF, PointF> m5712d() {
        return this.f5555b;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m5713e() {
        return this.f5558e;
    }

    @Override // com.airbnb.lottie.p084c.p086b.ContentModel_2
    /* renamed from: PlatformImplementations.kt_3 */
    public Content_2 mo5651a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a) {
        return new RectangleContent_2(c1187f, abstractC1122a, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.f5555b + ", size=" + this.f5556c + '}';
    }
}
