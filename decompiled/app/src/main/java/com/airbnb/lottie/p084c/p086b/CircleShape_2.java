package com.airbnb.lottie.p084c.p086b;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.EllipseContent_2;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p084c.p085a.AnimatablePointValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableValue_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;

/* compiled from: CircleShape.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class CircleShape_2 implements ContentModel_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f5507a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AnimatableValue_2<PointF, PointF> f5508b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatablePointValue_2 f5509c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final boolean f5510d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean f5511e;

    public CircleShape_2(String str, AnimatableValue_2<PointF, PointF> interfaceC1101m, AnimatablePointValue_2 c1094f, boolean z, boolean z2) {
        this.f5507a = str;
        this.f5508b = interfaceC1101m;
        this.f5509c = c1094f;
        this.f5510d = z;
        this.f5511e = z2;
    }

    @Override // com.airbnb.lottie.p084c.p086b.ContentModel_2
    /* renamed from: PlatformImplementations.kt_3 */
    public Content_2 mo5651a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a) {
        return new EllipseContent_2(c1187f, abstractC1122a, this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5662a() {
        return this.f5507a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableValue_2<PointF, PointF> m5663b() {
        return this.f5508b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatablePointValue_2 m5664c() {
        return this.f5509c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m5665d() {
        return this.f5510d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m5666e() {
        return this.f5511e;
    }
}
