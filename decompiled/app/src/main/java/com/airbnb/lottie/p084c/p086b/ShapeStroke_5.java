package com.airbnb.lottie.p084c.p086b;

import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.StrokeContent_2;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p084c.p085a.AnimatableColorValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableIntegerValue_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import java.util.List;

/* compiled from: ShapeStroke.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.p */
/* loaded from: classes.dex */
public class ShapeStroke_5 implements ContentModel_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f5580a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AnimatableFloatValue_2 f5581b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final List<AnimatableFloatValue_2> f5582c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableColorValue_2 f5583d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatableIntegerValue_2 f5584e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final AnimatableFloatValue_2 f5585f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final PlatformImplementations.kt_3 f5586g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final IntrinsicsJvm.kt_4 f5587h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final float f5588i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final boolean f5589j;

    /* compiled from: ShapeStroke.java */
    /* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.p$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f5590a[ordinal()];
            if (OplusGLSurfaceView_13 == 1) {
                return Paint.Cap.BUTT;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.SQUARE;
        }
    }

    /* compiled from: ShapeStroke.java */
    /* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.p$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f5590a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        static final /* synthetic */ int[] f5591b = new int[IntrinsicsJvm.kt_4.values().length];

        static {
            try {
                f5591b[IntrinsicsJvm.kt_4.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5591b[IntrinsicsJvm.kt_4.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5591b[IntrinsicsJvm.kt_4.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5590a = new int[PlatformImplementations.kt_3.values().length];
            try {
                f5590a[PlatformImplementations.kt_3.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5590a[PlatformImplementations.kt_3.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5590a[PlatformImplementations.kt_3.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: ShapeStroke.java */
    /* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.p$IntrinsicsJvm.kt_4 */
    public enum IntrinsicsJvm.kt_4 {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f5591b[ordinal()];
            if (OplusGLSurfaceView_13 == 1) {
                return Paint.Join.BEVEL;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return Paint.Join.MITER;
            }
            if (OplusGLSurfaceView_13 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public ShapeStroke_5(String str, AnimatableFloatValue_2 c1090b, List<AnimatableFloatValue_2> list, AnimatableColorValue_2 c1089a, AnimatableIntegerValue_2 c1092d, AnimatableFloatValue_2 c1090b2, PlatformImplementations.kt_3 aVar, IntrinsicsJvm.kt_4 bVar, float COUIBaseListPopupWindow_12, boolean z) {
        this.f5580a = str;
        this.f5581b = c1090b;
        this.f5582c = list;
        this.f5583d = c1089a;
        this.f5584e = c1092d;
        this.f5585f = c1090b2;
        this.f5586g = aVar;
        this.f5587h = bVar;
        this.f5588i = COUIBaseListPopupWindow_12;
        this.f5589j = z;
    }

    @Override // com.airbnb.lottie.p084c.p086b.ContentModel_2
    /* renamed from: PlatformImplementations.kt_3 */
    public Content_2 mo5651a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a) {
        return new StrokeContent_2(c1187f, abstractC1122a, this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5735a() {
        return this.f5580a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableColorValue_2 m5736b() {
        return this.f5583d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableIntegerValue_2 m5737c() {
        return this.f5584e;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableFloatValue_2 m5738d() {
        return this.f5585f;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public List<AnimatableFloatValue_2> m5739e() {
        return this.f5582c;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public AnimatableFloatValue_2 m5740f() {
        return this.f5581b;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public PlatformImplementations.kt_3 m5741g() {
        return this.f5586g;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public IntrinsicsJvm.kt_4 m5742h() {
        return this.f5587h;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public float m5743i() {
        return this.f5588i;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m5744j() {
        return this.f5589j;
    }
}
