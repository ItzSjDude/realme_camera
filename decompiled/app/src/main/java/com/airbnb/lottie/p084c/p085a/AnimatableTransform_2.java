package com.airbnb.lottie.p084c.p085a;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p080a.p082b.TransformKeyframeAnimation_2;
import com.airbnb.lottie.p084c.p086b.ContentModel_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;

/* compiled from: AnimatableTransform.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class AnimatableTransform_2 implements ContentModel_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final AnimatablePathValue_2 f5486a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AnimatableValue_2<PointF, PointF> f5487b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableScaleValue_2 f5488c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableFloatValue_2 f5489d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatableIntegerValue_2 f5490e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final AnimatableFloatValue_2 f5491f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final AnimatableFloatValue_2 f5492g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final AnimatableFloatValue_2 f5493h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final AnimatableFloatValue_2 f5494i;

    @Override // com.airbnb.lottie.p084c.p086b.ContentModel_2
    /* renamed from: PlatformImplementations.kt_3 */
    public Content_2 mo5651a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a) {
        return null;
    }

    public AnimatableTransform_2() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public AnimatableTransform_2(AnimatablePathValue_2 c1093e, AnimatableValue_2<PointF, PointF> interfaceC1101m, AnimatableScaleValue_2 c1095g, AnimatableFloatValue_2 c1090b, AnimatableIntegerValue_2 c1092d, AnimatableFloatValue_2 c1090b2, AnimatableFloatValue_2 c1090b3, AnimatableFloatValue_2 c1090b4, AnimatableFloatValue_2 c1090b5) {
        this.f5486a = c1093e;
        this.f5487b = interfaceC1101m;
        this.f5488c = c1095g;
        this.f5489d = c1090b;
        this.f5490e = c1092d;
        this.f5493h = c1090b2;
        this.f5494i = c1090b3;
        this.f5491f = c1090b4;
        this.f5492g = c1090b5;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public AnimatablePathValue_2 m5652a() {
        return this.f5486a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableValue_2<PointF, PointF> m5653b() {
        return this.f5487b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableScaleValue_2 m5654c() {
        return this.f5488c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableFloatValue_2 m5655d() {
        return this.f5489d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public AnimatableIntegerValue_2 m5656e() {
        return this.f5490e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public AnimatableFloatValue_2 m5657f() {
        return this.f5493h;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public AnimatableFloatValue_2 m5658g() {
        return this.f5494i;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public AnimatableFloatValue_2 m5659h() {
        return this.f5491f;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public AnimatableFloatValue_2 m5660i() {
        return this.f5492g;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public TransformKeyframeAnimation_2 m5661j() {
        return new TransformKeyframeAnimation_2(this);
    }
}
