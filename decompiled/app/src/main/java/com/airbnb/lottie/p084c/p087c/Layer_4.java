package com.airbnb.lottie.p084c.p087c;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p084c.p085a.AnimatableFloatValue_2;
import com.airbnb.lottie.p084c.p085a.AnimatableTextFrame_2;
import com.airbnb.lottie.p084c.p085a.AnimatableTextProperties_2;
import com.airbnb.lottie.p084c.p085a.AnimatableTransform_2;
import com.airbnb.lottie.p084c.p086b.Mask_3;
import com.airbnb.lottie.p084c.p086b.ContentModel_2;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.util.List;
import java.util.Locale;

/* compiled from: Layer.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class Layer_4 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<ContentModel_2> f5640a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final LottieComposition f5641b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String f5642c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final long f5643d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final PlatformImplementations.kt_3 f5644e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final long f5645f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final String f5646g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final List<Mask_3> f5647h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final AnimatableTransform_2 f5648i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final int f5649j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final int f5650k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final int f5651l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final float f5652m;

    /* renamed from: OplusGLSurfaceView_11 */
    private final float f5653n;

    /* renamed from: o */
    private final int f5654o;

    /* renamed from: p */
    private final int f5655p;

    /* renamed from: q */
    private final AnimatableTextFrame_2 f5656q;

    /* renamed from: r */
    private final AnimatableTextProperties_2 f5657r;

    /* renamed from: s */
    private final AnimatableFloatValue_2 f5658s;

    /* renamed from: t */
    private final List<Keyframe_2<Float>> f5659t;

    /* renamed from: u */
    private final IntrinsicsJvm.kt_4 f5660u;

    /* renamed from: v */
    private final boolean f5661v;

    /* compiled from: Layer.java */
    /* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* compiled from: Layer.java */
    /* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    public enum IntrinsicsJvm.kt_4 {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer_4(List<ContentModel_2> list, LottieComposition c1136d, String str, long OplusGLSurfaceView_15, PlatformImplementations.kt_3 aVar, long j2, String str2, List<Mask_3> list2, AnimatableTransform_2 c1100l, int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12, float f2, int i4, int i5, AnimatableTextFrame_2 c1098j, AnimatableTextProperties_2 c1099k, List<Keyframe_2<Float>> list3, IntrinsicsJvm.kt_4 bVar, AnimatableFloatValue_2 c1090b, boolean z) {
        this.f5640a = list;
        this.f5641b = c1136d;
        this.f5642c = str;
        this.f5643d = OplusGLSurfaceView_15;
        this.f5644e = aVar;
        this.f5645f = j2;
        this.f5646g = str2;
        this.f5647h = list2;
        this.f5648i = c1100l;
        this.f5649j = OplusGLSurfaceView_13;
        this.f5650k = i2;
        this.f5651l = i3;
        this.f5652m = COUIBaseListPopupWindow_12;
        this.f5653n = f2;
        this.f5654o = i4;
        this.f5655p = i5;
        this.f5656q = c1098j;
        this.f5657r = c1099k;
        this.f5659t = list3;
        this.f5660u = bVar;
        this.f5658s = c1090b;
        this.f5661v = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    LottieComposition m5785a() {
        return this.f5641b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    float m5787b() {
        return this.f5652m;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    float m5788c() {
        return this.f5653n / this.f5641b.m5860m();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    List<Keyframe_2<Float>> m5789d() {
        return this.f5659t;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public long m5790e() {
        return this.f5643d;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    String m5791f() {
        return this.f5642c;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    String m5792g() {
        return this.f5646g;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    int m5793h() {
        return this.f5654o;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    int m5794i() {
        return this.f5655p;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    List<Mask_3> m5795j() {
        return this.f5647h;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public PlatformImplementations.kt_3 m5796k() {
        return this.f5644e;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    IntrinsicsJvm.kt_4 m5797l() {
        return this.f5660u;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    long m5798m() {
        return this.f5645f;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    List<ContentModel_2> m5799n() {
        return this.f5640a;
    }

    /* renamed from: o */
    AnimatableTransform_2 m5800o() {
        return this.f5648i;
    }

    /* renamed from: p */
    int m5801p() {
        return this.f5651l;
    }

    /* renamed from: q */
    int m5802q() {
        return this.f5650k;
    }

    /* renamed from: r */
    int m5803r() {
        return this.f5649j;
    }

    /* renamed from: s */
    AnimatableTextFrame_2 m5804s() {
        return this.f5656q;
    }

    /* renamed from: t */
    AnimatableTextProperties_2 m5805t() {
        return this.f5657r;
    }

    /* renamed from: u */
    AnimatableFloatValue_2 m5806u() {
        return this.f5658s;
    }

    public String toString() {
        return m5786a("");
    }

    /* renamed from: v */
    public boolean m5807v() {
        return this.f5661v;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5786a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(m5791f());
        sb.append("\OplusGLSurfaceView_11");
        Layer_4 c1125dM5840a = this.f5641b.m5840a(m5798m());
        if (c1125dM5840a != null) {
            sb.append("\t\tParents: ");
            sb.append(c1125dM5840a.m5791f());
            Layer_4 c1125dM5840a2 = this.f5641b.m5840a(c1125dM5840a.m5798m());
            while (c1125dM5840a2 != null) {
                sb.append("->");
                sb.append(c1125dM5840a2.m5791f());
                c1125dM5840a2 = this.f5641b.m5840a(c1125dM5840a2.m5798m());
            }
            sb.append(str);
            sb.append("\OplusGLSurfaceView_11");
        }
        if (!m5795j().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(m5795j().size());
            sb.append("\OplusGLSurfaceView_11");
        }
        if (m5803r() != 0 && m5802q() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%IntrinsicsJvm.kt_5 %X\OplusGLSurfaceView_11", Integer.valueOf(m5803r()), Integer.valueOf(m5802q()), Integer.valueOf(m5801p())));
        }
        if (!this.f5640a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\OplusGLSurfaceView_11");
            for (ContentModel_2 interfaceC1105b : this.f5640a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(interfaceC1105b);
                sb.append("\OplusGLSurfaceView_11");
            }
        }
        return sb.toString();
    }
}
