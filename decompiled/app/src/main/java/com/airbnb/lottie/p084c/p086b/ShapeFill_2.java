package com.airbnb.lottie.p084c.p086b;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.FillContent_2;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p084c.p085a.AnimatableColorValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableIntegerValue_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;

/* compiled from: ShapeFill.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public class ShapeFill_2 implements ContentModel_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final boolean f5567a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Path.FillType f5568b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String f5569c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableColorValue_2 f5570d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatableIntegerValue_2 f5571e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final boolean f5572f;

    public ShapeFill_2(String str, boolean z, Path.FillType fillType, AnimatableColorValue_2 c1089a, AnimatableIntegerValue_2 c1092d, boolean z2) {
        this.f5569c = str;
        this.f5567a = z;
        this.f5568b = fillType;
        this.f5570d = c1089a;
        this.f5571e = c1092d;
        this.f5572f = z2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5724a() {
        return this.f5569c;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableColorValue_2 m5725b() {
        return this.f5570d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableIntegerValue_2 m5726c() {
        return this.f5571e;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Path.FillType m5727d() {
        return this.f5568b;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m5728e() {
        return this.f5572f;
    }

    @Override // com.airbnb.lottie.p084c.p086b.ContentModel_2
    /* renamed from: PlatformImplementations.kt_3 */
    public Content_2 mo5651a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a) {
        return new FillContent_2(c1187f, abstractC1122a, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f5567a + '}';
    }
}
