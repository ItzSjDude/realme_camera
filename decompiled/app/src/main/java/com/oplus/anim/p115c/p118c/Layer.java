package com.oplus.anim.p115c.p118c;

import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatableTextFrame;
import com.oplus.anim.p115c.p116a.AnimatableTextProperties;
import com.oplus.anim.p115c.p116a.AnimatableTransform;
import com.oplus.anim.p115c.p117b.Mask;
import com.oplus.anim.p115c.p117b.ContentModel;
import com.oplus.anim.p122g.Keyframe;
import java.util.List;
import java.util.Locale;

/* compiled from: Layer.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class Layer {

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<ContentModel> f10257a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final EffectiveAnimationComposition f10258b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String f10259c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final long f10260d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final PlatformImplementations.kt_3 f10261e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final long f10262f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final String f10263g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final List<Mask> f10264h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final AnimatableTransform f10265i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final int f10266j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final int f10267k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final int f10268l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final float f10269m;

    /* renamed from: OplusGLSurfaceView_11 */
    private final float f10270n;

    /* renamed from: o */
    private final int f10271o;

    /* renamed from: p */
    private final int f10272p;

    /* renamed from: q */
    private final AnimatableTextFrame f10273q;

    /* renamed from: r */
    private final AnimatableTextProperties f10274r;

    /* renamed from: s */
    private final AnimatableFloatValue f10275s;

    /* renamed from: t */
    private final List<Keyframe<Float>> f10276t;

    /* renamed from: u */
    private final IntrinsicsJvm.kt_4 f10277u;

    /* renamed from: v */
    private final boolean f10278v;

    /* compiled from: Layer.java */
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
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
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    public enum IntrinsicsJvm.kt_4 {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, EffectiveAnimationComposition c2272a, String str, long OplusGLSurfaceView_15, PlatformImplementations.kt_3 aVar, long j2, String str2, List<Mask> list2, AnimatableTransform c2325l, int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12, float f2, int i4, int i5, AnimatableTextFrame c2323j, AnimatableTextProperties c2324k, List<Keyframe<Float>> list3, IntrinsicsJvm.kt_4 bVar, AnimatableFloatValue c2315b, boolean z) {
        this.f10257a = list;
        this.f10258b = c2272a;
        this.f10259c = str;
        this.f10260d = OplusGLSurfaceView_15;
        this.f10261e = aVar;
        this.f10262f = j2;
        this.f10263g = str2;
        this.f10264h = list2;
        this.f10265i = c2325l;
        this.f10266j = OplusGLSurfaceView_13;
        this.f10267k = i2;
        this.f10268l = i3;
        this.f10269m = COUIBaseListPopupWindow_12;
        this.f10270n = f2;
        this.f10271o = i4;
        this.f10272p = i5;
        this.f10273q = c2323j;
        this.f10274r = c2324k;
        this.f10276t = list3;
        this.f10277u = bVar;
        this.f10275s = c2315b;
        this.f10278v = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    EffectiveAnimationComposition m9092a() {
        return this.f10258b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    float m9094b() {
        return this.f10269m;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    float m9095c() {
        return this.f10270n / this.f10258b.m8802m();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    List<Keyframe<Float>> m9096d() {
        return this.f10276t;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public long m9097e() {
        return this.f10260d;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    String m9098f() {
        return this.f10259c;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    String m9099g() {
        return this.f10263g;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    int m9100h() {
        return this.f10271o;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    int m9101i() {
        return this.f10272p;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    List<Mask> m9102j() {
        return this.f10264h;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public PlatformImplementations.kt_3 m9103k() {
        return this.f10261e;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    IntrinsicsJvm.kt_4 m9104l() {
        return this.f10277u;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    long m9105m() {
        return this.f10262f;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    List<ContentModel> m9106n() {
        return this.f10257a;
    }

    /* renamed from: o */
    AnimatableTransform m9107o() {
        return this.f10265i;
    }

    /* renamed from: p */
    int m9108p() {
        return this.f10268l;
    }

    /* renamed from: q */
    int m9109q() {
        return this.f10267k;
    }

    /* renamed from: r */
    int m9110r() {
        return this.f10266j;
    }

    /* renamed from: s */
    AnimatableTextFrame m9111s() {
        return this.f10273q;
    }

    /* renamed from: t */
    AnimatableTextProperties m9112t() {
        return this.f10274r;
    }

    /* renamed from: u */
    AnimatableFloatValue m9113u() {
        return this.f10275s;
    }

    public String toString() {
        return m9093a("");
    }

    /* renamed from: v */
    public boolean m9114v() {
        return this.f10278v;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m9093a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(m9098f());
        sb.append("\OplusGLSurfaceView_11");
        Layer c2350dM8782a = this.f10258b.m8782a(m9105m());
        if (c2350dM8782a != null) {
            sb.append("\t\tParents: ");
            sb.append(c2350dM8782a.m9098f());
            Layer c2350dM8782a2 = this.f10258b.m8782a(c2350dM8782a.m9105m());
            while (c2350dM8782a2 != null) {
                sb.append("->");
                sb.append(c2350dM8782a2.m9098f());
                c2350dM8782a2 = this.f10258b.m8782a(c2350dM8782a2.m9105m());
            }
            sb.append(str);
            sb.append("\OplusGLSurfaceView_11");
        }
        if (!m9102j().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(m9102j().size());
            sb.append("\OplusGLSurfaceView_11");
        }
        if (m9110r() != 0 && m9109q() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%IntrinsicsJvm.kt_5 %X\OplusGLSurfaceView_11", Integer.valueOf(m9110r()), Integer.valueOf(m9109q()), Integer.valueOf(m9108p())));
        }
        if (!this.f10257a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\OplusGLSurfaceView_11");
            for (ContentModel interfaceC2330b : this.f10257a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(interfaceC2330b);
                sb.append("\OplusGLSurfaceView_11");
            }
        }
        return sb.toString();
    }
}
