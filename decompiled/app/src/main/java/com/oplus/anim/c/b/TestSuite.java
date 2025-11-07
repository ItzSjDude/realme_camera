package com.oplus.anim.c_renamed.b_renamed;

/* compiled from: PolystarShape.java */
/* loaded from: classes2.dex */
public class i_renamed implements com.oplus.anim.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f3583a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.b_renamed.i_renamed.a_renamed f3584b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed f3585c;
    private final com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> d_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed e_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed f_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed g_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed h_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed i_renamed;
    private final boolean j_renamed;

    public i_renamed(java.lang.String str, com.oplus.anim.c_renamed.b_renamed.i_renamed.a_renamed aVar, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar, com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVar, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar2, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar3, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar4, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar5, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar6, boolean z_renamed) {
        this.f3583a = str;
        this.f3584b = aVar;
        this.f3585c = bVar;
        this.d_renamed = mVar;
        this.e_renamed = bVar2;
        this.f_renamed = bVar3;
        this.g_renamed = bVar4;
        this.h_renamed = bVar5;
        this.i_renamed = bVar6;
        this.j_renamed = z_renamed;
    }

    public java.lang.String a_renamed() {
        return this.f3583a;
    }

    public com.oplus.anim.c_renamed.b_renamed.i_renamed.a_renamed b_renamed() {
        return this.f3584b;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed c_renamed() {
        return this.f3585c;
    }

    public com.oplus.anim.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> d_renamed() {
        return this.d_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed e_renamed() {
        return this.e_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed f_renamed() {
        return this.f_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed g_renamed() {
        return this.g_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed h_renamed() {
        return this.h_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed i_renamed() {
        return this.i_renamed;
    }

    public boolean j_renamed() {
        return this.j_renamed;
    }

    @Override // com.oplus.anim.c_renamed.b_renamed.b_renamed
    public com.oplus.anim.a_renamed.a_renamed.c_renamed a_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar) {
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("PolystarShape to RepeaterContent, layer = " + aVar);
        }
        return new com.oplus.anim.a_renamed.a_renamed.n_renamed(bVar, aVar, this);
    }

    /* compiled from: PolystarShape.java */
    public enum a_renamed {
        STAR(1),
        POLYGON(2);

        private final int value;

        a_renamed(int i_renamed) {
            this.value = i_renamed;
        }

        public static com.oplus.anim.c_renamed.b_renamed.i_renamed.a_renamed forValue(int i_renamed) {
            for (com.oplus.anim.c_renamed.b_renamed.i_renamed.a_renamed aVar : values()) {
                if (aVar.value == i_renamed) {
                    return aVar;
                }
            }
            return null;
        }
    }
}
