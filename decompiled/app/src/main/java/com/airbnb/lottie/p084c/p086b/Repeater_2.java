package com.airbnb.lottie.p084c.p086b;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.RepeaterContent_2;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableTransform_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;

/* compiled from: Repeater.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class Repeater_2 implements ContentModel_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f5559a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AnimatableFloatValue_2 f5560b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableFloatValue_2 f5561c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableTransform_2 f5562d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean f5563e;

    public Repeater_2(String str, AnimatableFloatValue_2 c1090b, AnimatableFloatValue_2 c1090b2, AnimatableTransform_2 c1100l, boolean z) {
        this.f5559a = str;
        this.f5560b = c1090b;
        this.f5561c = c1090b2;
        this.f5562d = c1100l;
        this.f5563e = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5714a() {
        return this.f5559a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableFloatValue_2 m5715b() {
        return this.f5560b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableFloatValue_2 m5716c() {
        return this.f5561c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableTransform_2 m5717d() {
        return this.f5562d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m5718e() {
        return this.f5563e;
    }

    @Override // com.airbnb.lottie.p084c.p086b.ContentModel_2
    /* renamed from: PlatformImplementations.kt_3 */
    public Content_2 mo5651a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a) {
        return new RepeaterContent_2(c1187f, abstractC1122a, this);
    }
}
