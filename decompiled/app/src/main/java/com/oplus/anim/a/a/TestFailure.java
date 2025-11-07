package com.oplus.anim.a_renamed.a_renamed;

/* compiled from: EllipseContent.java */
/* loaded from: classes2.dex */
public class f_renamed implements com.oplus.anim.a_renamed.a_renamed.k_renamed, com.oplus.anim.a_renamed.a_renamed.m_renamed, com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2 {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.String f3466b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.b_renamed f3467c;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<?, android.graphics.PointF> d_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<?, android.graphics.PointF> e_renamed;
    private final com.oplus.anim.c_renamed.b_renamed.a_renamed f_renamed;
    private boolean h_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Path f3465a = new android.graphics.Path();
    private com.oplus.anim.a_renamed.a_renamed.b_renamed g_renamed = new com.oplus.anim.a_renamed.a_renamed.b_renamed();

    public f_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar, com.oplus.anim.c_renamed.b_renamed.a_renamed aVar2) {
        this.f3466b = aVar2.a_renamed();
        this.f3467c = bVar;
        this.d_renamed = aVar2.c_renamed().a_renamed();
        this.e_renamed = aVar2.b_renamed().a_renamed();
        this.f_renamed = aVar2;
        aVar.a_renamed(this.d_renamed);
        aVar.a_renamed(this.e_renamed);
        this.d_renamed.a_renamed(this);
        this.e_renamed.a_renamed(this);
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2
    public void a_renamed() {
        c_renamed();
    }

    private void c_renamed() {
        this.h_renamed = false;
        this.f3467c.invalidateSelf();
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list, java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list2) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.oplus.anim.a_renamed.a_renamed.c_renamed cVar = list.get(i_renamed);
            if (cVar instanceof com.oplus.anim.a_renamed.a_renamed.s_renamed) {
                com.oplus.anim.a_renamed.a_renamed.s_renamed sVar = (com.oplus.anim.a_renamed.a_renamed.s_renamed) cVar;
                if (sVar.c_renamed() == com.oplus.anim.c_renamed.b_renamed.q_renamed.a_renamed.SIMULTANEOUSLY) {
                    this.g_renamed.a_renamed(sVar);
                    sVar.a_renamed(this);
                }
            }
        }
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f3466b;
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.m_renamed
    public android.graphics.Path e_renamed() {
        if (this.h_renamed) {
            return this.f3465a;
        }
        this.f3465a.reset();
        if (this.f_renamed.e_renamed()) {
            this.h_renamed = true;
            return this.f3465a;
        }
        android.graphics.PointF pointFG = this.d_renamed.g_renamed();
        float f_renamed = pointFG.x_renamed / 2.0f;
        float f2 = pointFG.y_renamed / 2.0f;
        float f3 = f_renamed * 0.55228f;
        float f4 = 0.55228f * f2;
        this.f3465a.reset();
        if (this.f_renamed.d_renamed()) {
            float f5 = -f2;
            this.f3465a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f_renamed;
            float f8 = 0.0f - f4;
            this.f3465a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.f3465a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.f3465a.cubicTo(f10, f2, f_renamed, f9, f_renamed, 0.0f);
            this.f3465a.cubicTo(f_renamed, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.f3465a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.f3465a.cubicTo(f12, f11, f_renamed, f13, f_renamed, 0.0f);
            float f14 = f4 + 0.0f;
            this.f3465a.cubicTo(f_renamed, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f_renamed;
            this.f3465a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.f3465a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        android.graphics.PointF pointFG2 = this.e_renamed.g_renamed();
        this.f3465a.offset(pointFG2.x_renamed, pointFG2.y_renamed);
        this.f3465a.close();
        this.g_renamed.a_renamed(this.f3465a);
        this.h_renamed = true;
        return this.f3465a;
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public void a_renamed(com.oplus.anim.c_renamed.f_renamed fVar, int i_renamed, java.util.List<com.oplus.anim.c_renamed.f_renamed> list, com.oplus.anim.c_renamed.f_renamed fVar2) {
        com.oplus.anim.f_renamed.e_renamed.a_renamed(fVar, i_renamed, list, fVar2, this);
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        if (t_renamed == com.oplus.anim.d_renamed.g_renamed) {
            this.d_renamed.a_renamed((com.oplus.anim.g_renamed.b_renamed<android.graphics.PointF>) bVar);
        } else if (t_renamed == com.oplus.anim.d_renamed.h_renamed) {
            this.e_renamed.a_renamed((com.oplus.anim.g_renamed.b_renamed<android.graphics.PointF>) bVar);
        }
    }
}
