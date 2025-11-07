package com.oplus.anim.c_renamed.b_renamed;

/* compiled from: MergePaths.java */
/* loaded from: classes2.dex */
public class h_renamed implements com.oplus.anim.c_renamed.b_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f3580a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.anim.c_renamed.b_renamed.h_renamed.a_renamed f3581b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final boolean f3582c;

    public h_renamed(java.lang.String str, com.oplus.anim.c_renamed.b_renamed.h_renamed.a_renamed aVar, boolean z_renamed) {
        this.f3580a = str;
        this.f3581b = aVar;
        this.f3582c = z_renamed;
    }

    public java.lang.String a_renamed() {
        return this.f3580a;
    }

    public com.oplus.anim.c_renamed.b_renamed.h_renamed.a_renamed b_renamed() {
        return this.f3581b;
    }

    public boolean c_renamed() {
        return this.f3582c;
    }

    @Override // com.oplus.anim.c_renamed.b_renamed.b_renamed
    public com.oplus.anim.a_renamed.a_renamed.c_renamed a_renamed(com.oplus.anim.b_renamed bVar, com.oplus.anim.c_renamed.c_renamed.a_renamed aVar) {
        if (!bVar.a_renamed()) {
            com.oplus.anim.k_renamed.b_renamed("Animation contains merge paths but they are disabled.");
            return null;
        }
        if (com.oplus.anim.f_renamed.f_renamed.d_renamed) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("MergePaths to MergePathsContent, layer = " + aVar);
        }
        return new com.oplus.anim.a_renamed.a_renamed.l_renamed(this);
    }

    public java.lang.String toString() {
        return "MergePaths{mode=" + this.f3581b + '}';
    }

    /* compiled from: MergePaths.java */
    public enum a_renamed {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static com.oplus.anim.c_renamed.b_renamed.h_renamed.a_renamed forId(int i_renamed) {
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
}
