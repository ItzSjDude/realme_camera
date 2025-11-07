package com.p078a.p079a;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Spring.java */
/* renamed from: com.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class Spring {

    /* renamed from: PlatformImplementations.kt_3 */
    private static int f5175a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SpringConfig f5176b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f5177c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final String f5178d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final PlatformImplementations.kt_3 f5179e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final PlatformImplementations.kt_3 f5180f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final PlatformImplementations.kt_3 f5181g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private double f5182h;

    /* renamed from: OplusGLSurfaceView_13 */
    private double f5183i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f5184j = true;

    /* renamed from: OplusGLSurfaceView_5 */
    private double f5185k = 0.005d;

    /* renamed from: OplusGLSurfaceView_14 */
    private double f5186l = 0.005d;

    /* renamed from: OplusGLSurfaceView_6 */
    private CopyOnWriteArraySet<SpringListener> f5187m = new CopyOnWriteArraySet<>();

    /* renamed from: OplusGLSurfaceView_11 */
    private double f5188n = 0.0d;

    /* renamed from: o */
    private final BaseSpringSystem f5189o;

    /* compiled from: Spring.java */
    /* renamed from: com.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        double f5190a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        double f5191b;

        private PlatformImplementations.kt_3() {
        }
    }

    Spring(BaseSpringSystem c1028b) {
        this.f5179e = new PlatformImplementations.kt_3();
        this.f5180f = new PlatformImplementations.kt_3();
        this.f5181g = new PlatformImplementations.kt_3();
        if (c1028b == null) {
            throw new IllegalArgumentException("Spring cannot be created outside of PlatformImplementations.kt_3 BaseSpringSystem");
        }
        this.f5189o = c1028b;
        StringBuilder sb = new StringBuilder();
        sb.append("spring:");
        int OplusGLSurfaceView_13 = f5175a;
        f5175a = OplusGLSurfaceView_13 + 1;
        sb.append(OplusGLSurfaceView_13);
        this.f5178d = sb.toString();
        m5472a(SpringConfig.f5192c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5475a() {
        this.f5187m.clear();
        this.f5189o.m5451b(this);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m5477b() {
        return this.f5178d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Spring m5472a(SpringConfig c1033g) {
        if (c1033g == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        this.f5176b = c1033g;
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Spring m5470a(double IntrinsicsJvm.kt_5) {
        return m5471a(IntrinsicsJvm.kt_5, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Spring m5471a(double IntrinsicsJvm.kt_5, boolean z) {
        this.f5182h = IntrinsicsJvm.kt_5;
        this.f5179e.f5190a = IntrinsicsJvm.kt_5;
        this.f5189o.m5447a(m5477b());
        Iterator<SpringListener> it = this.f5187m.iterator();
        while (it.hasNext()) {
            it.next().mo5464a(this);
        }
        if (z) {
            m5487j();
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public double m5478c() {
        return this.f5179e.f5190a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private double m5468a(PlatformImplementations.kt_3 aVar) {
        return Math.abs(this.f5183i - aVar.f5190a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Spring m5476b(double IntrinsicsJvm.kt_5) {
        if (this.f5183i == IntrinsicsJvm.kt_5 && m5486i()) {
            return this;
        }
        this.f5182h = m5478c();
        this.f5183i = IntrinsicsJvm.kt_5;
        this.f5189o.m5447a(m5477b());
        Iterator<SpringListener> it = this.f5187m.iterator();
        while (it.hasNext()) {
            it.next().mo5467d(this);
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public double m5480d() {
        return this.f5183i;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Spring m5479c(double IntrinsicsJvm.kt_5) {
        if (IntrinsicsJvm.kt_5 == this.f5179e.f5191b) {
            return this;
        }
        this.f5179e.f5191b = IntrinsicsJvm.kt_5;
        this.f5189o.m5447a(m5477b());
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public double m5482e() {
        return this.f5179e.f5191b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Spring m5474a(boolean z) {
        this.f5177c = z;
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m5483f() {
        return this.f5176b.f5194b > 0.0d && ((this.f5182h < this.f5183i && m5478c() > this.f5183i) || (this.f5182h > this.f5183i && m5478c() < this.f5183i));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void m5481d(double IntrinsicsJvm.kt_5) {
        double d2;
        boolean z;
        boolean zM5486i = m5486i();
        if (zM5486i && this.f5184j) {
            return;
        }
        this.f5188n += IntrinsicsJvm.kt_5 <= 0.064d ? IntrinsicsJvm.kt_5 : 0.064d;
        double d3 = this.f5176b.f5194b;
        double d4 = this.f5176b.f5193a;
        double d5 = this.f5179e.f5190a;
        double d6 = this.f5179e.f5191b;
        double d7 = this.f5181g.f5190a;
        double d8 = this.f5181g.f5191b;
        while (true) {
            d2 = this.f5188n;
            if (d2 < 0.001d) {
                break;
            }
            this.f5188n = d2 - 0.001d;
            if (this.f5188n < 0.001d) {
                PlatformImplementations.kt_3 aVar = this.f5180f;
                aVar.f5190a = d5;
                aVar.f5191b = d6;
            }
            double d9 = this.f5183i;
            double d10 = ((d9 - d7) * d3) - (d4 * d6);
            double d11 = d6 + (d10 * 0.001d * 0.5d);
            double d12 = ((d9 - (((d6 * 0.001d) * 0.5d) + d5)) * d3) - (d4 * d11);
            double d13 = d6 + (d12 * 0.001d * 0.5d);
            double d14 = ((d9 - (d5 + ((d11 * 0.001d) * 0.5d))) * d3) - (d4 * d13);
            double d15 = d5 + (d13 * 0.001d);
            double d16 = d6 + (d14 * 0.001d);
            d5 += (d6 + ((d11 + d13) * 2.0d) + d16) * 0.16666666666666666d * 0.001d;
            d6 += (d10 + ((d12 + d14) * 2.0d) + (((d9 - d15) * d3) - (d4 * d16))) * 0.16666666666666666d * 0.001d;
            d7 = d15;
            d8 = d16;
        }
        PlatformImplementations.kt_3 aVar2 = this.f5181g;
        aVar2.f5190a = d7;
        aVar2.f5191b = d8;
        PlatformImplementations.kt_3 aVar3 = this.f5179e;
        aVar3.f5190a = d5;
        aVar3.f5191b = d6;
        if (d2 > 0.0d) {
            m5469e(d2 / 0.001d);
        }
        if (m5486i() || (this.f5177c && m5483f())) {
            if (d3 > 0.0d) {
                double d17 = this.f5183i;
                this.f5182h = d17;
                this.f5179e.f5190a = d17;
            } else {
                this.f5183i = this.f5179e.f5190a;
                this.f5182h = this.f5183i;
            }
            m5479c(0.0d);
            zM5486i = true;
        }
        boolean z2 = false;
        if (this.f5184j) {
            this.f5184j = false;
            z = true;
        } else {
            z = false;
        }
        if (zM5486i) {
            this.f5184j = true;
            z2 = true;
        }
        Iterator<SpringListener> it = this.f5187m.iterator();
        while (it.hasNext()) {
            SpringListener next = it.next();
            if (z) {
                next.mo5466c(this);
            }
            next.mo5464a(this);
            if (z2) {
                next.mo5465b(this);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m5484g() {
        return (m5486i() && m5485h()) ? false : true;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m5485h() {
        return this.f5184j;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m5486i() {
        return Math.abs(this.f5179e.f5191b) <= this.f5185k && (m5468a(this.f5179e) <= this.f5186l || this.f5176b.f5194b == 0.0d);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public Spring m5487j() {
        this.f5183i = this.f5179e.f5190a;
        this.f5181g.f5190a = this.f5179e.f5190a;
        this.f5179e.f5191b = 0.0d;
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m5469e(double IntrinsicsJvm.kt_5) {
        PlatformImplementations.kt_3 aVar = this.f5179e;
        double d2 = 1.0d - IntrinsicsJvm.kt_5;
        aVar.f5190a = (aVar.f5190a * IntrinsicsJvm.kt_5) + (this.f5180f.f5190a * d2);
        PlatformImplementations.kt_3 aVar2 = this.f5179e;
        aVar2.f5191b = (aVar2.f5191b * IntrinsicsJvm.kt_5) + (this.f5180f.f5191b * d2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Spring m5473a(SpringListener interfaceC1034h) {
        if (interfaceC1034h == null) {
            throw new IllegalArgumentException("newListener is required");
        }
        this.f5187m.add(interfaceC1034h);
        return this;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public Spring m5488k() {
        this.f5187m.clear();
        return this;
    }
}
