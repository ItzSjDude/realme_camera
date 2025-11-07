package com.airbnb.lottie.p084c.p086b;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.TrimPathContent_2;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;

/* compiled from: ShapeTrimPath.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.q */
/* loaded from: classes.dex */
public class ShapeTrimPath_3 implements ContentModel_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f5592a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PlatformImplementations.kt_3 f5593b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableFloatValue_2 f5594c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableFloatValue_2 f5595d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatableFloatValue_2 f5596e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final boolean f5597f;

    /* compiled from: ShapeTrimPath.java */
    /* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.q$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static PlatformImplementations.kt_3 forId(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 1) {
                return SIMULTANEOUSLY;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + OplusGLSurfaceView_13);
        }
    }

    public ShapeTrimPath_3(String str, PlatformImplementations.kt_3 aVar, AnimatableFloatValue_2 c1090b, AnimatableFloatValue_2 c1090b2, AnimatableFloatValue_2 c1090b3, boolean z) {
        this.f5592a = str;
        this.f5593b = aVar;
        this.f5594c = c1090b;
        this.f5595d = c1090b2;
        this.f5596e = c1090b3;
        this.f5597f = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5745a() {
        return this.f5592a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public PlatformImplementations.kt_3 m5746b() {
        return this.f5593b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableFloatValue_2 m5747c() {
        return this.f5595d;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableFloatValue_2 m5748d() {
        return this.f5594c;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public AnimatableFloatValue_2 m5749e() {
        return this.f5596e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m5750f() {
        return this.f5597f;
    }

    @Override // com.airbnb.lottie.p084c.p086b.ContentModel_2
    /* renamed from: PlatformImplementations.kt_3 */
    public Content_2 mo5651a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a) {
        return new TrimPathContent_2(abstractC1122a, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.f5594c + ", end: " + this.f5595d + ", offset: " + this.f5596e + "}";
    }
}
