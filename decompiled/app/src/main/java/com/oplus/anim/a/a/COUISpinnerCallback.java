package com.oplus.anim.a_renamed.a_renamed;

/* compiled from: RepeaterContent.java */
/* loaded from: classes2.dex */
public class p_renamed implements com.oplus.anim.a_renamed.a_renamed.e_renamed, com.oplus.anim.a_renamed.a_renamed.j_renamed, com.oplus.anim.a_renamed.a_renamed.k_renamed, com.oplus.anim.a_renamed.a_renamed.m_renamed, com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2 {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Matrix f3487a = new android.graphics.Matrix();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.Path f3488b = new android.graphics.Path();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.b_renamed f3489c;
    private final com.oplus.anim.c_renamed.c_renamed.a_renamed d_renamed;
    private final java.lang.String e_renamed;
    private final boolean f_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> g_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Float, java.lang.Float> h_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.o_renamed i_renamed;
    private com.oplus.anim.a_renamed.a_renamed.d_renamed j_renamed;

    public p_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar, com.oplus.anim.c_renamed.b_renamed.k_renamed kVar) {
        this.f3489c = bVar;
        this.d_renamed = aVar;
        this.e_renamed = kVar.a_renamed();
        this.f_renamed = kVar.e_renamed();
        this.g_renamed = kVar.b_renamed().a_renamed();
        aVar.a_renamed(this.g_renamed);
        this.g_renamed.a_renamed(this);
        this.h_renamed = kVar.c_renamed().a_renamed();
        aVar.a_renamed(this.h_renamed);
        this.h_renamed.a_renamed(this);
        this.i_renamed = kVar.d_renamed().j_renamed();
        this.i_renamed.a_renamed(aVar);
        this.i_renamed.a_renamed(this);
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.j_renamed
    public void a_renamed(java.util.ListIterator<com.oplus.anim.a_renamed.a_renamed.c_renamed> listIterator) {
        if (this.j_renamed != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        java.util.Collections.reverse(arrayList);
        this.j_renamed = new com.oplus.anim.a_renamed.a_renamed.d_renamed(this.f3489c, this.d_renamed, "Repeater", this.f_renamed, arrayList, null);
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.e_renamed;
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public void a_renamed(java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list, java.util.List<com.oplus.anim.a_renamed.a_renamed.c_renamed> list2) {
        this.j_renamed.a_renamed(list, list2);
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.m_renamed
    public android.graphics.Path e_renamed() {
        android.graphics.Path pathE = this.j_renamed.e_renamed();
        this.f3488b.reset();
        float fFloatValue = this.g_renamed.g_renamed().floatValue();
        float fFloatValue2 = this.h_renamed.g_renamed().floatValue();
        for (int i_renamed = ((int) fFloatValue) - 1; i_renamed >= 0; i_renamed--) {
            this.f3487a.set(this.i_renamed.b_renamed(i_renamed + fFloatValue2));
            this.f3488b.addPath(pathE, this.f3487a);
        }
        return this.f3488b;
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        float fFloatValue = this.g_renamed.g_renamed().floatValue();
        float fFloatValue2 = this.h_renamed.g_renamed().floatValue();
        float fFloatValue3 = this.i_renamed.b_renamed().g_renamed().floatValue() / 100.0f;
        float fFloatValue4 = this.i_renamed.c_renamed().g_renamed().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.f3487a.set(matrix);
            float f_renamed = i2;
            this.f3487a.preConcat(this.i_renamed.b_renamed(f_renamed + fFloatValue2));
            this.j_renamed.a_renamed(canvas, this.f3487a, (int) (i_renamed * com.oplus.anim.f_renamed.e_renamed.a_renamed(fFloatValue3, fFloatValue4, f_renamed / fFloatValue)));
        }
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        this.j_renamed.a_renamed(rectF, matrix, z_renamed);
    }

    @Override // com.oplus.anim.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_2
    public void a_renamed() {
        this.f3489c.invalidateSelf();
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public void a_renamed(com.oplus.anim.c_renamed.f_renamed fVar, int i_renamed, java.util.List<com.oplus.anim.c_renamed.f_renamed> list, com.oplus.anim.c_renamed.f_renamed fVar2) {
        com.oplus.anim.f_renamed.e_renamed.a_renamed(fVar, i_renamed, list, fVar2, this);
    }

    @Override // com.oplus.anim.c_renamed.g_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        if (this.i_renamed.a_renamed(t_renamed, bVar)) {
            return;
        }
        if (t_renamed == com.oplus.anim.d_renamed.o_renamed) {
            this.g_renamed.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Float>) bVar);
        } else if (t_renamed == com.oplus.anim.d_renamed.p_renamed) {
            this.h_renamed.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Float>) bVar);
        }
    }
}
