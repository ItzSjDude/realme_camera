package com.oplus.anim.a_renamed.a_renamed;

/* compiled from: StrokeContent.java */
/* loaded from: classes2.dex */
public class r_renamed extends com.oplus.anim.a_renamed.a_renamed.a_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.c_renamed.a_renamed f3493b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.String f3494c;
    private final boolean d_renamed;
    private final com.oplus.anim.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> e_renamed;
    private com.oplus.anim.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> f_renamed;

    public r_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar, com.oplus.anim.c_renamed.b_renamed.p_renamed pVar) {
        super(bVar, aVar, pVar.g_renamed().toPaintCap(), pVar.h_renamed().toPaintJoin(), pVar.i_renamed(), pVar.c_renamed(), pVar.d_renamed(), pVar.e_renamed(), pVar.f_renamed());
        this.f3493b = aVar;
        this.f3494c = pVar.a_renamed();
        this.d_renamed = pVar.j_renamed();
        this.e_renamed = pVar.b_renamed().a_renamed();
        this.e_renamed.a_renamed(this);
        aVar.a_renamed(this.e_renamed);
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.a_renamed, com.oplus.anim.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        if (this.d_renamed) {
            return;
        }
        this.f3456a.setColor(((com.oplus.anim.a_renamed.b_renamed.b_renamed) this.e_renamed).i_renamed());
        if (this.f_renamed != null) {
            this.f3456a.setColorFilter(this.f_renamed.g_renamed());
        }
        super.a_renamed(canvas, matrix, i_renamed);
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.f3494c;
    }

    @Override // com.oplus.anim.a_renamed.a_renamed.a_renamed, com.oplus.anim.c_renamed.g_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        super.a_renamed((com.oplus.anim.a_renamed.a_renamed.r_renamed) t_renamed, (com.oplus.anim.g_renamed.b_renamed<com.oplus.anim.a_renamed.a_renamed.r_renamed>) bVar);
        if (t_renamed == com.oplus.anim.d_renamed.f3642b) {
            this.e_renamed.a_renamed((com.oplus.anim.g_renamed.b_renamed<java.lang.Integer>) bVar);
            return;
        }
        if (t_renamed == com.oplus.anim.d_renamed.z_renamed) {
            if (bVar == null) {
                this.f_renamed = null;
                return;
            }
            this.f_renamed = new com.oplus.anim.a_renamed.b_renamed.p_renamed(bVar);
            this.f_renamed.a_renamed(this);
            this.f3493b.a_renamed(this.e_renamed);
        }
    }
}
