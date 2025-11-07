package com.airbnb.lottie.p084c.p086b;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.GradientFillContent_2;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableGradientColorValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableIntegerValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatablePointValue_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;

/* compiled from: GradientFill.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class GradientFill_2 implements ContentModel_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final GradientType_2 f5514a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Path.FillType f5515b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableGradientColorValue_2 f5516c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableIntegerValue_2 f5517d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatablePointValue_2 f5518e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final AnimatablePointValue_2 f5519f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final String f5520g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final AnimatableFloatValue_2 f5521h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final AnimatableFloatValue_2 f5522i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final boolean f5523j;

    public GradientFill_2(String str, GradientType_2 enumC1109f, Path.FillType fillType, AnimatableGradientColorValue_2 c1091c, AnimatableIntegerValue_2 c1092d, AnimatablePointValue_2 c1094f, AnimatablePointValue_2 c1094f2, AnimatableFloatValue_2 c1090b, AnimatableFloatValue_2 c1090b2, boolean z) {
        this.f5514a = enumC1109f;
        this.f5515b = fillType;
        this.f5516c = c1091c;
        this.f5517d = c1092d;
        this.f5518e = c1094f;
        this.f5519f = c1094f2;
        this.f5520g = str;
        this.f5521h = c1090b;
        this.f5522i = c1090b2;
        this.f5523j = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5671a() {
        return this.f5520g;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public GradientType_2 m5672b() {
        return this.f5514a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Path.FillType m5673c() {
        return this.f5515b;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableGradientColorValue_2 m5674d() {
        return this.f5516c;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public AnimatableIntegerValue_2 m5675e() {
        return this.f5517d;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public AnimatablePointValue_2 m5676f() {
        return this.f5518e;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public AnimatablePointValue_2 m5677g() {
        return this.f5519f;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m5678h() {
        return this.f5523j;
    }

    @Override // com.airbnb.lottie.p084c.p086b.ContentModel_2
    /* renamed from: PlatformImplementations.kt_3 */
    public Content_2 mo5651a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a) {
        return new GradientFillContent_2(c1187f, abstractC1122a, this);
    }
}
