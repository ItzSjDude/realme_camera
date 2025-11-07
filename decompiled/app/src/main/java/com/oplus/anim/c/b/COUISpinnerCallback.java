package com.oplus.anim.c_renamed.b_renamed;

/* compiled from: ShapeStroke.java */
/* loaded from: classes2.dex */
public class p_renamed implements com.oplus.anim.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f3604a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed f3605b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.List<com.oplus.anim.c_renamed.a_renamed.b_renamed> f3606c;
    private final com.oplus.anim.c_renamed.a_renamed.a_renamed d_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.d_renamed e_renamed;
    private final com.oplus.anim.c_renamed.a_renamed.b_renamed f_renamed;
    private final com.oplus.anim.c_renamed.b_renamed.p_renamed.a_renamed g_renamed;
    private final com.oplus.anim.c_renamed.b_renamed.p_renamed.b_renamed h_renamed;
    private final float i_renamed;
    private final boolean j_renamed;

    public p_renamed(java.lang.String str, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar, java.util.List<com.oplus.anim.c_renamed.a_renamed.b_renamed> list, com.oplus.anim.c_renamed.a_renamed.a_renamed aVar, com.oplus.anim.c_renamed.a_renamed.d_renamed dVar, com.oplus.anim.c_renamed.a_renamed.b_renamed bVar2, com.oplus.anim.c_renamed.b_renamed.p_renamed.a_renamed aVar2, com.oplus.anim.c_renamed.b_renamed.p_renamed.b_renamed bVar3, float f_renamed, boolean z_renamed) {
        this.f3604a = str;
        this.f3605b = bVar;
        this.f3606c = list;
        this.d_renamed = aVar;
        this.e_renamed = dVar;
        this.f_renamed = bVar2;
        this.g_renamed = aVar2;
        this.h_renamed = bVar3;
        this.i_renamed = f_renamed;
        this.j_renamed = z_renamed;
    }

    @Override // com.oplus.anim.c_renamed.b_renamed.b_renamed
    public com.oplus.anim.a_renamed.a_renamed.c_renamed a_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar) {
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("ShapeStroke to StrokeContent, layer = " + aVar);
        }
        return new com.oplus.anim.a_renamed.a_renamed.r_renamed(bVar, aVar, this);
    }

    public java.lang.String a_renamed() {
        return this.f3604a;
    }

    public com.oplus.anim.c_renamed.a_renamed.a_renamed b_renamed() {
        return this.d_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.d_renamed c_renamed() {
        return this.e_renamed;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed d_renamed() {
        return this.f_renamed;
    }

    public java.util.List<com.oplus.anim.c_renamed.a_renamed.b_renamed> e_renamed() {
        return this.f3606c;
    }

    public com.oplus.anim.c_renamed.a_renamed.b_renamed f_renamed() {
        return this.f3605b;
    }

    public com.oplus.anim.c_renamed.b_renamed.p_renamed.a_renamed g_renamed() {
        return this.g_renamed;
    }

    public com.oplus.anim.c_renamed.b_renamed.p_renamed.b_renamed h_renamed() {
        return this.h_renamed;
    }

    public float i_renamed() {
        return this.i_renamed;
    }

    public boolean j_renamed() {
        return this.j_renamed;
    }

    /* compiled from: ShapeStroke.java */
    public enum a_renamed {
        BUTT,
        ROUND,
        UNKNOWN;

        public android.graphics.Paint.Cap toPaintCap() {
            int i_renamed = com.oplus.anim.c_renamed.b_renamed.p_renamed.SceneLoader_2.f3607a[ordinal()];
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
    /* renamed from: com.oplus.anim.c_renamed.b_renamed.p_renamed$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f3607a;

        /* renamed from: b_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f3608b = new int[com.oplus.anim.c_renamed.b_renamed.p_renamed.b_renamed.values().length];

        static {
            try {
                f3608b[com.oplus.anim.c_renamed.b_renamed.p_renamed.b_renamed.BEVEL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f3608b[com.oplus.anim.c_renamed.b_renamed.p_renamed.b_renamed.MITER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f3608b[com.oplus.anim.c_renamed.b_renamed.p_renamed.b_renamed.ROUND.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            f3607a = new int[com.oplus.anim.c_renamed.b_renamed.p_renamed.a_renamed.values().length];
            try {
                f3607a[com.oplus.anim.c_renamed.b_renamed.p_renamed.a_renamed.BUTT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                f3607a[com.oplus.anim.c_renamed.b_renamed.p_renamed.a_renamed.ROUND.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                f3607a[com.oplus.anim.c_renamed.b_renamed.p_renamed.a_renamed.UNKNOWN.ordinal()] = 3;
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
            int i_renamed = com.oplus.anim.c_renamed.b_renamed.p_renamed.SceneLoader_2.f3608b[ordinal()];
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
}
