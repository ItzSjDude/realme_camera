package com.airbnb.lottie.p084c.p086b;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.GradientStrokeContent_2;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableGradientColorValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableIntegerValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatablePointValue_2;
import com.airbnb.lottie.p084c.p086b.ShapeStroke_5;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import java.util.List;

/* compiled from: GradientStroke.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class GradientStroke_2 implements ContentModel_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f5524a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final GradientType_2 f5525b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableGradientColorValue_2 f5526c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableIntegerValue_2 f5527d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatablePointValue_2 f5528e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final AnimatablePointValue_2 f5529f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final AnimatableFloatValue_2 f5530g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final ShapeStroke_5.PlatformImplementations.kt_3 f5531h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final ShapeStroke_5.IntrinsicsJvm.kt_4 f5532i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final float f5533j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final List<AnimatableFloatValue_2> f5534k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final AnimatableFloatValue_2 f5535l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final boolean f5536m;

    public GradientStroke_2(String str, GradientType_2 enumC1109f, AnimatableGradientColorValue_2 c1091c, AnimatableIntegerValue_2 c1092d, AnimatablePointValue_2 c1094f, AnimatablePointValue_2 c1094f2, AnimatableFloatValue_2 c1090b, ShapeStroke_5.PlatformImplementations.kt_3 aVar, ShapeStroke_5.IntrinsicsJvm.kt_4 bVar, float COUIBaseListPopupWindow_12, List<AnimatableFloatValue_2> list, AnimatableFloatValue_2 c1090b2, boolean z) {
        this.f5524a = str;
        this.f5525b = enumC1109f;
        this.f5526c = c1091c;
        this.f5527d = c1092d;
        this.f5528e = c1094f;
        this.f5529f = c1094f2;
        this.f5530g = c1090b;
        this.f5531h = aVar;
        this.f5532i = bVar;
        this.f5533j = COUIBaseListPopupWindow_12;
        this.f5534k = list;
        this.f5535l = c1090b2;
        this.f5536m = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5679a() {
        return this.f5524a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public GradientType_2 m5680b() {
        return this.f5525b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableGradientColorValue_2 m5681c() {
        return this.f5526c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableIntegerValue_2 m5682d() {
        return this.f5527d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public AnimatablePointValue_2 m5683e() {
        return this.f5528e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public AnimatablePointValue_2 m5684f() {
        return this.f5529f;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public AnimatableFloatValue_2 m5685g() {
        return this.f5530g;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public ShapeStroke_5.PlatformImplementations.kt_3 m5686h() {
        return this.f5531h;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public ShapeStroke_5.IntrinsicsJvm.kt_4 m5687i() {
        return this.f5532i;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public List<AnimatableFloatValue_2> m5688j() {
        return this.f5534k;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public AnimatableFloatValue_2 m5689k() {
        return this.f5535l;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public float m5690l() {
        return this.f5533j;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m5691m() {
        return this.f5536m;
    }

    @Override // com.airbnb.lottie.p084c.p086b.ContentModel_2
    /* renamed from: PlatformImplementations.kt_3 */
    public Content_2 mo5651a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a) {
        return new GradientStrokeContent_2(c1187f, abstractC1122a, this);
    }
}
