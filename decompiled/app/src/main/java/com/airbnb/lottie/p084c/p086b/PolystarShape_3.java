package com.airbnb.lottie.p084c.p086b;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.PolystarContent_3;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableValue_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;

/* compiled from: PolystarShape.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class PolystarShape_3 implements ContentModel_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f5544a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PlatformImplementations.kt_3 f5545b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AnimatableFloatValue_2 f5546c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableValue_2<PointF, PointF> f5547d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatableFloatValue_2 f5548e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final AnimatableFloatValue_2 f5549f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final AnimatableFloatValue_2 f5550g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final AnimatableFloatValue_2 f5551h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final AnimatableFloatValue_2 f5552i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final boolean f5553j;

    /* compiled from: PolystarShape.java */
    /* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        STAR(1),
        POLYGON(2);

        private final int value;

        PlatformImplementations.kt_3(int OplusGLSurfaceView_13) {
            this.value = OplusGLSurfaceView_13;
        }

        public static PlatformImplementations.kt_3 forValue(int OplusGLSurfaceView_13) {
            for (PlatformImplementations.kt_3 aVar : values()) {
                if (aVar.value == OplusGLSurfaceView_13) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public PolystarShape_3(String str, PlatformImplementations.kt_3 aVar, AnimatableFloatValue_2 c1090b, AnimatableValue_2<PointF, PointF> interfaceC1101m, AnimatableFloatValue_2 c1090b2, AnimatableFloatValue_2 c1090b3, AnimatableFloatValue_2 c1090b4, AnimatableFloatValue_2 c1090b5, AnimatableFloatValue_2 c1090b6, boolean z) {
        this.f5544a = str;
        this.f5545b = aVar;
        this.f5546c = c1090b;
        this.f5547d = interfaceC1101m;
        this.f5548e = c1090b2;
        this.f5549f = c1090b3;
        this.f5550g = c1090b4;
        this.f5551h = c1090b5;
        this.f5552i = c1090b6;
        this.f5553j = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5699a() {
        return this.f5544a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public PlatformImplementations.kt_3 m5700b() {
        return this.f5545b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableFloatValue_2 m5701c() {
        return this.f5546c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableValue_2<PointF, PointF> m5702d() {
        return this.f5547d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public AnimatableFloatValue_2 m5703e() {
        return this.f5548e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public AnimatableFloatValue_2 m5704f() {
        return this.f5549f;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public AnimatableFloatValue_2 m5705g() {
        return this.f5550g;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public AnimatableFloatValue_2 m5706h() {
        return this.f5551h;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public AnimatableFloatValue_2 m5707i() {
        return this.f5552i;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m5708j() {
        return this.f5553j;
    }

    @Override // com.airbnb.lottie.p084c.p086b.ContentModel_2
    /* renamed from: PlatformImplementations.kt_3 */
    public Content_2 mo5651a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a) {
        return new PolystarContent_3(c1187f, abstractC1122a, this);
    }
}
