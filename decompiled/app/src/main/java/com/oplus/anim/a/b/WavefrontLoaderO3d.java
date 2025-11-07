package com.oplus.anim.a_renamed.b_renamed;

/* compiled from: TransformKeyframeAnimation.java */
/* loaded from: classes2.dex */
public class o_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Matrix f3510a = new android.graphics.Matrix();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.Matrix f3511b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.graphics.Matrix f3512c;
    private final android.graphics.Matrix d_renamed;
    private final float[] e_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> f_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<?, android.graphics.PointF> g_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.g_renamed.d_renamed, com.oplus.anim.g_renamed.d_renamed> h_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> i_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> j_renamed;
    private com.oplus.anim.a_renamed.b_renamed.c_renamed k_renamed;
    private com.oplus.anim.a_renamed.b_renamed.c_renamed l_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> m_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> n_renamed;

    public o_renamed(com.oplus.anim.c_renamed.a_renamed.l_renamed lVar) {
        this.f_renamed = lVar.a_renamed() == null ? null : lVar.a_renamed().a_renamed();
        this.g_renamed = lVar.b_renamed() == null ? null : lVar.b_renamed().a_renamed();
        this.h_renamed = lVar.c_renamed() == null ? null : lVar.c_renamed().a_renamed();
        this.i_renamed = lVar.d_renamed() == null ? null : lVar.d_renamed().a_renamed();
        this.k_renamed = lVar.h_renamed() == null ? null : (com.oplus.anim.a_renamed.b_renamed.c_renamed) lVar.h_renamed().a_renamed();
        if (this.k_renamed != null) {
            this.f3511b = new android.graphics.Matrix();
            this.f3512c = new android.graphics.Matrix();
            this.d_renamed = new android.graphics.Matrix();
            this.e_renamed = new float[9];
        } else {
            this.f3511b = null;
            this.f3512c = null;
            this.d_renamed = null;
            this.e_renamed = null;
        }
        this.l_renamed = lVar.i_renamed() == null ? null : (com.oplus.anim.a_renamed.b_renamed.c_renamed) lVar.i_renamed().a_renamed();
        if (lVar.e_renamed() != null) {
            this.j_renamed = lVar.e_renamed().a_renamed();
        }
        if (lVar.f_renamed() != null) {
            this.m_renamed = lVar.f_renamed().a_renamed();
        } else {
            this.m_renamed = null;
        }
        if (lVar.g_renamed() != null) {
            this.n_renamed = lVar.g_renamed().a_renamed();
        } else {
            this.n_renamed = null;
        }
    }

    public void a_renamed(com.oplus.anim.c_renamed.c_renamed.a_renamed aVar) {
        aVar.a_renamed(this.j_renamed);
        aVar.a_renamed(this.m_renamed);
        aVar.a_renamed(this.n_renamed);
        aVar.a_renamed(this.f_renamed);
        aVar.a_renamed(this.g_renamed);
        aVar.a_renamed(this.h_renamed);
        aVar.a_renamed(this.i_renamed);
        aVar.a_renamed(this.k_renamed);
        aVar.a_renamed(this.l_renamed);
    }

    public void a_renamed(com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2 interfaceC0077a) {
        com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar = this.j_renamed;
        if (aVar != null) {
            aVar.a_renamed(interfaceC0077a);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar2 = this.m_renamed;
        if (aVar2 != null) {
            aVar2.a_renamed(interfaceC0077a);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar3 = this.n_renamed;
        if (aVar3 != null) {
            aVar3.a_renamed(interfaceC0077a);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> aVar4 = this.f_renamed;
        if (aVar4 != null) {
            aVar4.a_renamed(interfaceC0077a);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, android.graphics.PointF> aVar5 = this.g_renamed;
        if (aVar5 != null) {
            aVar5.a_renamed(interfaceC0077a);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.g_renamed.d_renamed, com.oplus.anim.g_renamed.d_renamed> aVar6 = this.h_renamed;
        if (aVar6 != null) {
            aVar6.a_renamed(interfaceC0077a);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar7 = this.i_renamed;
        if (aVar7 != null) {
            aVar7.a_renamed(interfaceC0077a);
        }
        com.oplus.anim.a_renamed.b_renamed.c_renamed cVar = this.k_renamed;
        if (cVar != null) {
            cVar.a_renamed(interfaceC0077a);
        }
        com.oplus.anim.a_renamed.b_renamed.c_renamed cVar2 = this.l_renamed;
        if (cVar2 != null) {
            cVar2.a_renamed(interfaceC0077a);
        }
    }

    public void a_renamed(float f_renamed) {
        com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar = this.j_renamed;
        if (aVar != null) {
            aVar.a_renamed(f_renamed);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar2 = this.m_renamed;
        if (aVar2 != null) {
            aVar2.a_renamed(f_renamed);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar3 = this.n_renamed;
        if (aVar3 != null) {
            aVar3.a_renamed(f_renamed);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> aVar4 = this.f_renamed;
        if (aVar4 != null) {
            aVar4.a_renamed(f_renamed);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, android.graphics.PointF> aVar5 = this.g_renamed;
        if (aVar5 != null) {
            aVar5.a_renamed(f_renamed);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.g_renamed.d_renamed, com.oplus.anim.g_renamed.d_renamed> aVar6 = this.h_renamed;
        if (aVar6 != null) {
            aVar6.a_renamed(f_renamed);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar7 = this.i_renamed;
        if (aVar7 != null) {
            aVar7.a_renamed(f_renamed);
        }
        com.oplus.anim.a_renamed.b_renamed.c_renamed cVar = this.k_renamed;
        if (cVar != null) {
            cVar.a_renamed(f_renamed);
        }
        com.oplus.anim.a_renamed.b_renamed.c_renamed cVar2 = this.l_renamed;
        if (cVar2 != null) {
            cVar2.a_renamed(f_renamed);
        }
    }

    public com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Integer> a_renamed() {
        return this.j_renamed;
    }

    public com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> b_renamed() {
        return this.m_renamed;
    }

    public com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> c_renamed() {
        return this.n_renamed;
    }

    public android.graphics.Matrix d_renamed() {
        float fI_renamed;
        this.f3510a.reset();
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, android.graphics.PointF> aVar = this.g_renamed;
        if (aVar != null) {
            android.graphics.PointF pointFG = aVar.g_renamed();
            if (pointFG.x_renamed != 0.0f || pointFG.y_renamed != 0.0f) {
                this.f3510a.preTranslate(pointFG.x_renamed, pointFG.y_renamed);
            }
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar2 = this.i_renamed;
        if (aVar2 != null) {
            if (aVar2 instanceof com.oplus.anim.a_renamed.b_renamed.p_renamed) {
                fI_renamed = aVar2.g_renamed().floatValue();
            } else {
                fI_renamed = ((com.oplus.anim.a_renamed.b_renamed.c_renamed) aVar2).i_renamed();
            }
            if (fI_renamed != 0.0f) {
                this.f3510a.preRotate(fI_renamed);
            }
        }
        if (this.k_renamed != null) {
            float fCos = this.l_renamed == null ? 0.0f : (float) java.lang.Math.cos(java.lang.Math.toRadians((-r0.i_renamed()) + 90.0f));
            float fSin = this.l_renamed == null ? 1.0f : (float) java.lang.Math.sin(java.lang.Math.toRadians((-r4.i_renamed()) + 90.0f));
            float fTan = (float) java.lang.Math.tan(java.lang.Math.toRadians(this.k_renamed.i_renamed()));
            e_renamed();
            float[] fArr = this.e_renamed;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f_renamed = -fSin;
            fArr[3] = f_renamed;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f3511b.setValues(fArr);
            e_renamed();
            float[] fArr2 = this.e_renamed;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f3512c.setValues(fArr2);
            e_renamed();
            float[] fArr3 = this.e_renamed;
            fArr3[0] = fCos;
            fArr3[1] = f_renamed;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.d_renamed.setValues(fArr3);
            this.f3512c.preConcat(this.f3511b);
            this.d_renamed.preConcat(this.f3512c);
            this.f3510a.preConcat(this.d_renamed);
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.g_renamed.d_renamed, com.oplus.anim.g_renamed.d_renamed> aVar3 = this.h_renamed;
        if (aVar3 != null) {
            com.oplus.anim.g_renamed.d_renamed dVarG = aVar3.g_renamed();
            if (dVarG.a_renamed() != 1.0f || dVarG.b_renamed() != 1.0f) {
                this.f3510a.preScale(dVarG.a_renamed(), dVarG.b_renamed());
            }
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> aVar4 = this.f_renamed;
        if (aVar4 != null) {
            android.graphics.PointF pointFG2 = aVar4.g_renamed();
            if (pointFG2.x_renamed != 0.0f || pointFG2.y_renamed != 0.0f) {
                this.f3510a.preTranslate(-pointFG2.x_renamed, -pointFG2.y_renamed);
            }
        }
        return this.f3510a;
    }

    private void e_renamed() {
        for (int i_renamed = 0; i_renamed < 9; i_renamed++) {
            this.e_renamed[i_renamed] = 0.0f;
        }
    }

    public android.graphics.Matrix b_renamed(float f_renamed) {
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, android.graphics.PointF> aVar = this.g_renamed;
        android.graphics.PointF pointFG = aVar == null ? null : aVar.g_renamed();
        com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.g_renamed.d_renamed, com.oplus.anim.g_renamed.d_renamed> aVar2 = this.h_renamed;
        com.oplus.anim.g_renamed.d_renamed dVarG = aVar2 == null ? null : aVar2.g_renamed();
        this.f3510a.reset();
        if (pointFG != null) {
            this.f3510a.preTranslate(pointFG.x_renamed * f_renamed, pointFG.y_renamed * f_renamed);
        }
        if (dVarG != null) {
            double d_renamed = f_renamed;
            this.f3510a.preScale((float) java.lang.Math.pow(dVarG.a_renamed(), d_renamed), (float) java.lang.Math.pow(dVarG.b_renamed(), d_renamed));
        }
        com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar3 = this.i_renamed;
        if (aVar3 != null) {
            float fFloatValue = aVar3.g_renamed().floatValue();
            com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> aVar4 = this.f_renamed;
            android.graphics.PointF pointFG2 = aVar4 != null ? aVar4.g_renamed() : null;
            this.f3510a.preRotate(fFloatValue * f_renamed, pointFG2 == null ? 0.0f : pointFG2.x_renamed, pointFG2 != null ? pointFG2.y_renamed : 0.0f);
        }
        return this.f3510a;
    }

    public <T_renamed> boolean a_renamed(T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        com.oplus.anim.a_renamed.b_renamed.c_renamed cVar;
        com.oplus.anim.a_renamed.b_renamed.c_renamed cVar2;
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar;
        com.oplus.anim.a_renamed.b_renamed.a_renamed<?, java.lang.Float> aVar2;
        if (t_renamed == com.oplus.anim.d_renamed.e_renamed) {
            com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.PointF, android.graphics.PointF> aVar3 = this.f_renamed;
            if (aVar3 == null) {
                this.f_renamed = new com.oplus.anim.a_renamed.b_renamed.p_renamed(bVar, new android.graphics.PointF());
                return true;
            }
            aVar3.a_renamed((com.oplus.anim.g_renamed.b_renamed<android.graphics.PointF>) bVar);
            return true;
        }
        if (t_renamed == com.oplus.anim.d_renamed.f_renamed) {
            com.oplus.anim.a_renamed.b_renamed.a_renamed<?, android.graphics.PointF> aVar4 = this.g_renamed;
            if (aVar4 == null) {
                this.g_renamed = new com.oplus.anim.a_renamed.b_renamed.p_renamed(bVar, new android.graphics.PointF());
                return true;
            }
            aVar4.a_renamed((com.oplus.anim.g_renamed.b_renamed<android.graphics.PointF>) bVar);
            return true;
        }
        if (t_renamed == com.oplus.anim.d_renamed.i_renamed) {
            com.oplus.anim.a_renamed.b_renamed.a_renamed<com.oplus.anim.g_renamed.d_renamed, com.oplus.anim.g_renamed.d_renamed> aVar5 = this.h_renamed;
            if (aVar5 == null) {
                this.h_renamed = new com.oplus.anim.a_renamed.b_renamed.p_renamed(bVar, new com.oplus.anim.g_renamed.d_renamed());
                return true;
            }
            aVar5.a_renamed((com.oplus.anim.g_renamed.b_renamed<com.oplus.anim.g_renamed.d_renamed>) bVar);
            return true;
        }
        if (t_renamed == com.oplus.anim.d_renamed.j_renamed) {
            com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> aVar6 = this.i_renamed;
            if (aVar6 == null) {
                this.i_renamed = new com.oplus.anim.a_renamed.b_renamed.p_renamed(bVar, java.lang.Float.valueOf(0.0f));
                return true;
            }
            aVar6.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Float>) bVar);
            return true;
        }
        if (t_renamed == com.oplus.anim.d_renamed.f3643c) {
            com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> aVar7 = this.j_renamed;
            if (aVar7 == null) {
                this.j_renamed = new com.oplus.anim.a_renamed.b_renamed.p_renamed(bVar, 100);
                return true;
            }
            aVar7.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Integer>) bVar);
            return true;
        }
        if (t_renamed == com.oplus.anim.d_renamed.w_renamed && (aVar2 = this.m_renamed) != null) {
            if (aVar2 == null) {
                this.m_renamed = new com.oplus.anim.a_renamed.b_renamed.p_renamed(bVar, 100);
                return true;
            }
            aVar2.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Float>) bVar);
            return true;
        }
        if (t_renamed == com.oplus.anim.d_renamed.x_renamed && (aVar = this.n_renamed) != null) {
            if (aVar == null) {
                this.n_renamed = new com.oplus.anim.a_renamed.b_renamed.p_renamed(bVar, 100);
                return true;
            }
            aVar.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Float>) bVar);
            return true;
        }
        if (t_renamed == com.oplus.anim.d_renamed.k_renamed && (cVar2 = this.k_renamed) != null) {
            if (cVar2 == null) {
                this.k_renamed = new com.oplus.anim.a_renamed.b_renamed.c_renamed(java.util.Collections.singletonList(new com.oplus.anim.g_renamed.c_renamed(java.lang.Float.valueOf(0.0f))));
            }
            this.k_renamed.a_renamed(bVar);
            return true;
        }
        if (t_renamed != com.oplus.anim.d_renamed.l_renamed || (cVar = this.l_renamed) == null) {
            return false;
        }
        if (cVar == null) {
            this.l_renamed = new com.oplus.anim.a_renamed.b_renamed.c_renamed(java.util.Collections.singletonList(new com.oplus.anim.g_renamed.c_renamed(java.lang.Float.valueOf(0.0f))));
        }
        this.l_renamed.a_renamed(bVar);
        return true;
    }
}
