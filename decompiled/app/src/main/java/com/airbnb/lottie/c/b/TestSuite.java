package com.airbnb.lottie.c_renamed.b_renamed;

/* compiled from: PolystarShape.java */
/* loaded from: classes.dex */
public class i_renamed implements com.airbnb.lottie.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f2085a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed f2086b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed f2087c;
    private final com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> d_renamed;
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed e_renamed;
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed f_renamed;
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed g_renamed;
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed h_renamed;
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed i_renamed;
    private final boolean j_renamed;

    /* compiled from: PolystarShape.java */
    public enum a_renamed {
        STAR(1),
        POLYGON(2);

        private final int value;

        a_renamed(int i_renamed) {
            this.value = i_renamed;
        }

        public static com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed forValue(int i_renamed) {
            for (com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed aVar : values()) {
                if (aVar.value == i_renamed) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public i_renamed(java.lang.String str, com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed aVar, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar, com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> mVar, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar2, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar3, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar4, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar5, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar6, boolean z_renamed) {
        this.f2085a = str;
        this.f2086b = aVar;
        this.f2087c = bVar;
        this.d_renamed = mVar;
        this.e_renamed = bVar2;
        this.f_renamed = bVar3;
        this.g_renamed = bVar4;
        this.h_renamed = bVar5;
        this.i_renamed = bVar6;
        this.j_renamed = z_renamed;
    }

    public java.lang.String a_renamed() {
        return this.f2085a;
    }

    public com.airbnb.lottie.c_renamed.b_renamed.i_renamed.a_renamed b_renamed() {
        return this.f2086b;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.b_renamed c_renamed() {
        return this.f2087c;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.m_renamed<android.graphics.PointF, android.graphics.PointF> d_renamed() {
        return this.d_renamed;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.b_renamed e_renamed() {
        return this.e_renamed;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.b_renamed f_renamed() {
        return this.f_renamed;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.b_renamed g_renamed() {
        return this.g_renamed;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.b_renamed h_renamed() {
        return this.h_renamed;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.b_renamed i_renamed() {
        return this.i_renamed;
    }

    public boolean j_renamed() {
        return this.j_renamed;
    }

    @Override // com.airbnb.lottie.c_renamed.b_renamed.b_renamed
    public com.airbnb.lottie.a_renamed.a_renamed.c_renamed a_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar) {
        return new com.airbnb.lottie.a_renamed.a_renamed.n_renamed(fVar, aVar, this);
    }
}
