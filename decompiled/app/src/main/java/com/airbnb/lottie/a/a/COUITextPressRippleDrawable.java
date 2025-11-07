package com.airbnb.lottie.a_renamed.a_renamed;

/* compiled from: StrokeContent.java */
/* loaded from: classes.dex */
public class r_renamed extends com.airbnb.lottie.a_renamed.a_renamed.a_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.c_renamed.a_renamed f2024c;
    private final java.lang.String d_renamed;
    private final boolean e_renamed;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed<java.lang.Integer, java.lang.Integer> f_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> g_renamed;

    public r_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar, com.airbnb.lottie.c_renamed.b_renamed.p_renamed pVar) {
        super(fVar, aVar, pVar.g_renamed().toPaintCap(), pVar.h_renamed().toPaintJoin(), pVar.i_renamed(), pVar.c_renamed(), pVar.d_renamed(), pVar.e_renamed(), pVar.f_renamed());
        this.f2024c = aVar;
        this.d_renamed = pVar.a_renamed();
        this.e_renamed = pVar.j_renamed();
        this.f_renamed = pVar.b_renamed().a_renamed();
        this.f_renamed.a_renamed(this);
        aVar.a_renamed(this.f_renamed);
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.a_renamed, com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        if (this.e_renamed) {
            return;
        }
        this.f1989b.setColor(((com.airbnb.lottie.a_renamed.b_renamed.b_renamed) this.f_renamed).i_renamed());
        if (this.g_renamed != null) {
            this.f1989b.setColorFilter(this.g_renamed.g_renamed());
        }
        super.a_renamed(canvas, matrix, i_renamed);
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.c_renamed
    public java.lang.String b_renamed() {
        return this.d_renamed;
    }

    @Override // com.airbnb.lottie.a_renamed.a_renamed.a_renamed, com.airbnb.lottie.c_renamed.f_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        super.a_renamed((com.airbnb.lottie.a_renamed.a_renamed.r_renamed) t_renamed, (com.airbnb.lottie.g_renamed.c_renamed<com.airbnb.lottie.a_renamed.a_renamed.r_renamed>) cVar);
        if (t_renamed == com.airbnb.lottie.k_renamed.f2278b) {
            this.f_renamed.a_renamed((com.airbnb.lottie.g_renamed.c_renamed<java.lang.Integer>) cVar);
            return;
        }
        if (t_renamed == com.airbnb.lottie.k_renamed.E_renamed) {
            com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> aVar = this.g_renamed;
            if (aVar != null) {
                this.f2024c.b_renamed(aVar);
            }
            if (cVar == null) {
                this.g_renamed = null;
                return;
            }
            this.g_renamed = new com.airbnb.lottie.a_renamed.b_renamed.p_renamed(cVar);
            this.g_renamed.a_renamed(this);
            this.f2024c.a_renamed(this.f_renamed);
        }
    }
}
