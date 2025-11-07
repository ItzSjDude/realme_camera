package com.airbnb.lottie.c_renamed.b_renamed;

/* compiled from: ShapeStroke.java */
/* loaded from: classes.dex */
public class p_renamed implements com.airbnb.lottie.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f2106a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed f2107b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.List<com.airbnb.lottie.c_renamed.a_renamed.b_renamed> f2108c;
    private final com.airbnb.lottie.c_renamed.a_renamed.a_renamed d_renamed;
    private final com.airbnb.lottie.c_renamed.a_renamed.d_renamed e_renamed;
    private final com.airbnb.lottie.c_renamed.a_renamed.b_renamed f_renamed;
    private final com.airbnb.lottie.c_renamed.b_renamed.p_renamed.a_renamed g_renamed;
    private final com.airbnb.lottie.c_renamed.b_renamed.p_renamed.b_renamed h_renamed;
    private final float i_renamed;
    private final boolean j_renamed;

    /* compiled from: ShapeStroke.java */
    public enum a_renamed {
        BUTT,
        ROUND,
        UNKNOWN;

        public android.graphics.Paint.Cap toPaintCap() {
            int i_renamed = com.airbnb.lottie.c_renamed.b_renamed.p_renamed.SceneLoader_2.f2109a[ordinal()];
            if (i_renamed == 1) {
                return android.graphics.Paint.Cap.BUTT;
            }
            if (i_renamed == 2) {
                return android.graphics.Paint.Cap.ROUND;
            }
            return android.graphics.Paint.Cap.SQUARE;
        }
    }

    /* compiled from: ShapeStroke.java */
    /* renamed from: com.airbnb.lottie.c_renamed.b_renamed.p_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f2109a;

        /* renamed from: b_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f2110b = new int[com.airbnb.lottie.c_renamed.b_renamed.p_renamed.b_renamed.values().length];

        static {
            try {
                f2110b[com.airbnb.lottie.c_renamed.b_renamed.p_renamed.b_renamed.BEVEL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f2110b[com.airbnb.lottie.c_renamed.b_renamed.p_renamed.b_renamed.MITER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f2110b[com.airbnb.lottie.c_renamed.b_renamed.p_renamed.b_renamed.ROUND.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            f2109a = new int[com.airbnb.lottie.c_renamed.b_renamed.p_renamed.a_renamed.values().length];
            try {
                f2109a[com.airbnb.lottie.c_renamed.b_renamed.p_renamed.a_renamed.BUTT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                f2109a[com.airbnb.lottie.c_renamed.b_renamed.p_renamed.a_renamed.ROUND.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                f2109a[com.airbnb.lottie.c_renamed.b_renamed.p_renamed.a_renamed.UNKNOWN.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: ShapeStroke.java */
    public enum b_renamed {
        MITER,
        ROUND,
        BEVEL;

        public android.graphics.Paint.Join toPaintJoin() {
            int i_renamed = com.airbnb.lottie.c_renamed.b_renamed.p_renamed.SceneLoader_2.f2110b[ordinal()];
            if (i_renamed == 1) {
                return android.graphics.Paint.Join.BEVEL;
            }
            if (i_renamed == 2) {
                return android.graphics.Paint.Join.MITER;
            }
            if (i_renamed != 3) {
                return null;
            }
            return android.graphics.Paint.Join.ROUND;
        }
    }

    public p_renamed(java.lang.String str, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar, java.util.List<com.airbnb.lottie.c_renamed.a_renamed.b_renamed> list, com.airbnb.lottie.c_renamed.a_renamed.a_renamed aVar, com.airbnb.lottie.c_renamed.a_renamed.d_renamed dVar, com.airbnb.lottie.c_renamed.a_renamed.b_renamed bVar2, com.airbnb.lottie.c_renamed.b_renamed.p_renamed.a_renamed aVar2, com.airbnb.lottie.c_renamed.b_renamed.p_renamed.b_renamed bVar3, float f_renamed, boolean z_renamed) {
        this.f2106a = str;
        this.f2107b = bVar;
        this.f2108c = list;
        this.d_renamed = aVar;
        this.e_renamed = dVar;
        this.f_renamed = bVar2;
        this.g_renamed = aVar2;
        this.h_renamed = bVar3;
        this.i_renamed = f_renamed;
        this.j_renamed = z_renamed;
    }

    @Override // com.airbnb.lottie.c_renamed.b_renamed.b_renamed
    public com.airbnb.lottie.a_renamed.a_renamed.c_renamed a_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar) {
        return new com.airbnb.lottie.a_renamed.a_renamed.r_renamed(fVar, aVar, this);
    }

    public java.lang.String a_renamed() {
        return this.f2106a;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.a_renamed b_renamed() {
        return this.d_renamed;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.d_renamed c_renamed() {
        return this.e_renamed;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.b_renamed d_renamed() {
        return this.f_renamed;
    }

    public java.util.List<com.airbnb.lottie.c_renamed.a_renamed.b_renamed> e_renamed() {
        return this.f2108c;
    }

    public com.airbnb.lottie.c_renamed.a_renamed.b_renamed f_renamed() {
        return this.f2107b;
    }

    public com.airbnb.lottie.c_renamed.b_renamed.p_renamed.a_renamed g_renamed() {
        return this.g_renamed;
    }

    public com.airbnb.lottie.c_renamed.b_renamed.p_renamed.b_renamed h_renamed() {
        return this.h_renamed;
    }

    public float i_renamed() {
        return this.i_renamed;
    }

    public boolean j_renamed() {
        return this.j_renamed;
    }
}
