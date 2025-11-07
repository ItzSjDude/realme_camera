package com.airbnb.lottie.c_renamed.b_renamed;

/* compiled from: MergePaths.java */
/* loaded from: classes.dex */
public class h_renamed implements com.airbnb.lottie.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f2082a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.c_renamed.b_renamed.h_renamed.a_renamed f2083b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final boolean f2084c;

    /* compiled from: MergePaths.java */
    public enum a_renamed {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static com.airbnb.lottie.c_renamed.b_renamed.h_renamed.a_renamed forId(int i_renamed) {
            if (i_renamed == 1) {
                return MERGE;
            }
            if (i_renamed == 2) {
                return ADD;
            }
            if (i_renamed == 3) {
                return SUBTRACT;
            }
            if (i_renamed == 4) {
                return INTERSECT;
            }
            if (i_renamed == 5) {
                return EXCLUDE_INTERSECTIONS;
            }
            return MERGE;
        }
    }

    public h_renamed(java.lang.String str, com.airbnb.lottie.c_renamed.b_renamed.h_renamed.a_renamed aVar, boolean z_renamed) {
        this.f2082a = str;
        this.f2083b = aVar;
        this.f2084c = z_renamed;
    }

    public java.lang.String a_renamed() {
        return this.f2082a;
    }

    public com.airbnb.lottie.c_renamed.b_renamed.h_renamed.a_renamed b_renamed() {
        return this.f2083b;
    }

    public boolean c_renamed() {
        return this.f2084c;
    }

    @Override // com.airbnb.lottie.c_renamed.b_renamed.b_renamed
    public com.airbnb.lottie.a_renamed.a_renamed.c_renamed a_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.a_renamed aVar) {
        if (!fVar.a_renamed()) {
            com.airbnb.lottie.f_renamed.d_renamed.b_renamed("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new com.airbnb.lottie.a_renamed.a_renamed.l_renamed(this);
    }

    public java.lang.String toString() {
        return "MergePaths{mode=" + this.f2083b + '}';
    }
}
