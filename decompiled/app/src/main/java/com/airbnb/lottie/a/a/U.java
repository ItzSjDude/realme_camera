package com.airbnb.lottie.a_renamed.a_renamed;

/* compiled from: PolystarContent.java */
/* loaded from: classes.dex */
public class n_renamed implements com.airbnb.lottie.a_renamed.a_renamed.k_renamed, com.airbnb.lottie.a_renamed.a_renamed.m_renamed, com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4 {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.String f2012b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.f_renamed f2013c;
    private final com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed d_renamed;
    private final boolean e_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> f_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, android.graphics.PointF> g_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> h_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> i_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> j_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> k_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> l_renamed;
    private boolean n_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Path f2011a = new android.graphics.Path();
    private com.airbnb.lottie.a_renamed.a_renamed.b_renamed m_renamed = new com.airbnb.lottie.a_renamed.a_renamed.b_renamed();

    public n_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar, com.airbnb.lottie.c_renamed.b_renamed.i_renamed iVar) {
        this.f2013c = fVar;
        this.f2012b = iVar.a_renamed();
        this.d_renamed = iVar.b_renamed();
        this.e_renamed = iVar.j_renamed();
        this.f_renamed = iVar.c_renamed().a_renamed();
        this.g_renamed = iVar.d_renamed().a_renamed();
        this.h_renamed = iVar.e_renamed().a_renamed();
        this.j_renamed = iVar.g_renamed().a_renamed();
        this.l_renamed = iVar.i_renamed().a_renamed();
        if (this.d_renamed == com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed.STAR) {
            this.i_renamed = iVar.f_renamed().a_renamed();
            this.k_renamed = iVar.h_renamed().a_renamed();
        } else {
            this.i_renamed = null;
            this.k_renamed = null;
        }
        aVar.a_renamed(this.f_renamed);
        aVar.a_renamed(this.g_renamed);
        aVar.a_renamed(this.h_renamed);
        aVar.a_renamed(this.j_renamed);
        aVar.a_renamed(this.l_renamed);
        if (this.d_renamed == com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed.STAR) {
            aVar.a_renamed(this.i_renamed);
            aVar.a_renamed(this.k_renamed);
        }
        this.f_renamed.a_renamed(this);
        this.g_renamed.a_renamed(this);
        this.h_renamed.a_renamed(this);
        this.j_renamed.a_renamed(this);
        this.l_renamed.a_renamed(this);
        if (this.d_renamed == com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed.STAR) {
            this.i_renamed.a_renamed(this);
            this.k_renamed.a_renamed(this);
        }
    }

    @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4
    public void a_renamed() {
        c_renamed();
    }

    private void c_renamed() {
        this.n_renamed = false;
        this.f2013c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list, java.util.List<com.airbnb.lottie.a_renamed.a_renamed.c_renamed> list2) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.airbnb.lottie.a_renamed.a_renamed.c_renamed cVar = list.get(i_renamed);
            if (cVar instanceof com.airbnb.lottie.a_renamed.a_renamed.s_renamed) {
                com.airbnb.lottie.a_renamed.a_renamed.s_renamed sVar = (com.airbnb.lottie.a_renamed.a_renamed.s_renamed) cVar;
                if (sVar.c_renamed() == com.airbnb.lottie.c_renamed.b_renamed.q_renamed.a_renamed.SIMULTANEOUSLY) {
                    this.m_renamed.a_renamed(sVar);
                    sVar.a_renamed(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.m_renamed
    public android.graphics.Path e_renamed() {
        if (this.n_renamed) {
            return this.f2011a;
        }
        this.f2011a.reset();
        if (this.e_renamed) {
            this.n_renamed = true;
            return this.f2011a;
        }
        int i_renamed = com.airbnb.lottie.a_renamed.a_renamed.n_renamed.SceneLoader_2.f2014a[this.d_renamed.ordinal()];
        if (i_renamed == 1) {
            d_renamed();
        } else if (i_renamed == 2) {
            f_renamed();
        }
        this.f2011a.close();
        this.m_renamed.a_renamed(this.f2011a);
        this.n_renamed = true;
        return this.f2011a;
    }

    /* compiled from: PolystarContent.java */
    /* renamed from: com.airbnb.lottie.a_renamed.a_renamed.n_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f2014a = new int[com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed.values().length];

        static {
            try {
                f2014a[com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed.STAR.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f2014a[com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed.POLYGON.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f2012b;
    }

    private void d_renamed() {
        double d_renamed;
        int i_renamed;
        double d2;
        float fCos;
        float fSin;
        float f_renamed;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float fFloatValue = this.f_renamed.g_renamed().floatValue();
        double radians = java.lang.Math.toRadians((this.h_renamed == null ? 0.0d : r2.g_renamed().floatValue()) - 90.0d);
        double d3 = fFloatValue;
        float f11 = (float) (6.283185307179586d / d3);
        float f12 = f11 / 2.0f;
        float f13 = fFloatValue - ((int) fFloatValue);
        int i2 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (1.0f - f13) * f12;
        }
        float fFloatValue2 = this.j_renamed.g_renamed().floatValue();
        float fFloatValue3 = this.i_renamed.g_renamed().floatValue();
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar = this.k_renamed;
        float fFloatValue4 = aVar != null ? aVar.g_renamed().floatValue() / 100.0f : 0.0f;
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar2 = this.l_renamed;
        float fFloatValue5 = aVar2 != null ? aVar2.g_renamed().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f_renamed = ((fFloatValue2 - fFloatValue3) * f13) + fFloatValue3;
            i_renamed = i2;
            double d4 = f_renamed;
            d_renamed = d3;
            fCos = (float) (d4 * java.lang.Math.cos(radians));
            fSin = (float) (d4 * java.lang.Math.sin(radians));
            this.f2011a.moveTo(fCos, fSin);
            d2 = radians + ((f11 * f13) / 2.0f);
        } else {
            d_renamed = d3;
            i_renamed = i2;
            double d5 = fFloatValue2;
            float fCos2 = (float) (java.lang.Math.cos(radians) * d5);
            float fSin2 = (float) (d5 * java.lang.Math.sin(radians));
            this.f2011a.moveTo(fCos2, fSin2);
            d2 = radians + f12;
            fCos = fCos2;
            fSin = fSin2;
            f_renamed = 0.0f;
        }
        double dCeil = java.lang.Math.ceil(d_renamed) * 2.0d;
        boolean z_renamed = false;
        double d6 = d2;
        float f14 = f12;
        int i3 = 0;
        while (true) {
            double d7 = i3;
            if (d7 < dCeil) {
                float f15 = z_renamed ? fFloatValue2 : fFloatValue3;
                if (f_renamed == 0.0f || d7 != dCeil - 2.0d) {
                    f2 = f14;
                } else {
                    f2 = f14;
                    f14 = (f11 * f13) / 2.0f;
                }
                if (f_renamed == 0.0f || d7 != dCeil - 1.0d) {
                    f3 = f11;
                    f4 = fFloatValue3;
                    f5 = f15;
                    f6 = fFloatValue2;
                } else {
                    f3 = f11;
                    f6 = fFloatValue2;
                    f4 = fFloatValue3;
                    f5 = f_renamed;
                }
                double d8 = f5;
                float f16 = f14;
                float fCos3 = (float) (d8 * java.lang.Math.cos(d6));
                float fSin3 = (float) (d8 * java.lang.Math.sin(d6));
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    this.f2011a.lineTo(fCos3, fSin3);
                    f10 = fSin3;
                    f7 = fFloatValue4;
                    f8 = fFloatValue5;
                    f9 = f_renamed;
                } else {
                    f7 = fFloatValue4;
                    f8 = fFloatValue5;
                    double dAtan2 = (float) (java.lang.Math.atan2(fSin, fCos) - 1.5707963267948966d);
                    float fCos4 = (float) java.lang.Math.cos(dAtan2);
                    float fSin4 = (float) java.lang.Math.sin(dAtan2);
                    f9 = f_renamed;
                    f10 = fSin3;
                    float f17 = fCos;
                    double dAtan22 = (float) (java.lang.Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) java.lang.Math.cos(dAtan22);
                    float fSin5 = (float) java.lang.Math.sin(dAtan22);
                    float f18 = z_renamed ? f7 : f8;
                    float f19 = z_renamed ? f8 : f7;
                    float f20 = (z_renamed ? f4 : f6) * f18 * 0.47829f;
                    float f21 = fCos4 * f20;
                    float f22 = f20 * fSin4;
                    float f23 = (z_renamed ? f6 : f4) * f19 * 0.47829f;
                    float f24 = fCos5 * f23;
                    float f25 = f23 * fSin5;
                    if (i_renamed != 0) {
                        if (i3 == 0) {
                            f21 *= f13;
                            f22 *= f13;
                        } else if (d7 == dCeil - 1.0d) {
                            f24 *= f13;
                            f25 *= f13;
                        }
                    }
                    this.f2011a.cubicTo(f17 - f21, fSin - f22, fCos3 + f24, f10 + f25, fCos3, f10);
                }
                d6 += f16;
                z_renamed = !z_renamed;
                i3++;
                fCos = fCos3;
                f_renamed = f9;
                fFloatValue2 = f6;
                f11 = f3;
                f14 = f2;
                fFloatValue3 = f4;
                fFloatValue4 = f7;
                fFloatValue5 = f8;
                fSin = f10;
            } else {
                android.graphics.PointF pointFG = this.g_renamed.g_renamed();
                this.f2011a.offset(pointFG.x_renamed, pointFG.y_renamed);
                this.f2011a.close();
                return;
            }
        }
    }

    private void f_renamed() {
        double d_renamed;
        double d2;
        double d3;
        int i_renamed;
        int iFloor = (int) java.lang.Math.floor(this.f_renamed.g_renamed().floatValue());
        double radians = java.lang.Math.toRadians((this.h_renamed == null ? 0.0d : r2.g_renamed().floatValue()) - 90.0d);
        double d4 = iFloor;
        float fFloatValue = this.l_renamed.g_renamed().floatValue() / 100.0f;
        float fFloatValue2 = this.j_renamed.g_renamed().floatValue();
        double d5 = fFloatValue2;
        float fCos = (float) (java.lang.Math.cos(radians) * d5);
        float fSin = (float) (java.lang.Math.sin(radians) * d5);
        this.f2011a.moveTo(fCos, fSin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double dCeil = java.lang.Math.ceil(d4);
        int i2 = 0;
        while (i2 < dCeil) {
            float fCos2 = (float) (java.lang.Math.cos(d7) * d5);
            double d8 = dCeil;
            float fSin2 = (float) (d5 * java.lang.Math.sin(d7));
            if (fFloatValue != 0.0f) {
                d2 = d5;
                i_renamed = i2;
                d_renamed = d7;
                double dAtan2 = (float) (java.lang.Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) java.lang.Math.cos(dAtan2);
                float fSin3 = (float) java.lang.Math.sin(dAtan2);
                d3 = d6;
                double dAtan22 = (float) (java.lang.Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f_renamed = fFloatValue2 * fFloatValue * 0.25f;
                this.f2011a.cubicTo(fCos - (fCos3 * f_renamed), fSin - (fSin3 * f_renamed), fCos2 + (((float) java.lang.Math.cos(dAtan22)) * f_renamed), fSin2 + (f_renamed * ((float) java.lang.Math.sin(dAtan22))), fCos2, fSin2);
            } else {
                d_renamed = d7;
                d2 = d5;
                d3 = d6;
                i_renamed = i2;
                this.f2011a.lineTo(fCos2, fSin2);
            }
            d7 = d_renamed + d3;
            i2 = i_renamed + 1;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d8;
            d5 = d2;
            d6 = d3;
        }
        android.graphics.PointF pointFG = this.g_renamed.g_renamed();
        this.f2011a.offset(pointFG.x_renamed, pointFG.y_renamed);
        this.f2011a.close();
    }

    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public void a_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar, int i_renamed, java.util.List<com.airbnb.lottie.c_renamed.e_renamed> list, com.airbnb.lottie.c_renamed.e_renamed eVar2) {
        com.airbnb.lottie.f_renamed.g_renamed.a_renamed(eVar, i_renamed, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.c_renamed.f_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar;
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar2;
        if (t_renamed == com.airbnb.lottie.k_renamed.u_renamed) {
            this.f_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float>) cVar);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.v_renamed) {
            this.h_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float>) cVar);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.l_renamed) {
            this.g_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<android.graphics.PointF>) cVar);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.w_renamed && (aVar2 = this.i_renamed) != null) {
            aVar2.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float>) cVar);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.x_renamed) {
            this.j_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float>) cVar);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.y_renamed && (aVar = this.k_renamed) != null) {
            aVar.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float>) cVar);
        } else if (t_renamed == com.airbnb.lottie.k_renamed.z_renamed) {
            this.l_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Float>) cVar);
        }
    }
}
