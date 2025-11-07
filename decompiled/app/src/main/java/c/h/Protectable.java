package c_renamed.h_renamed;

/* compiled from: Ranges.kt */
/* loaded from: classes.dex */
public final class c_renamed extends c_renamed.h_renamed.a_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final c_renamed.h_renamed.c_renamed.a_renamed f1920b = new c_renamed.h_renamed.c_renamed.a_renamed(null);

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final c_renamed.h_renamed.c_renamed f1921c = new c_renamed.h_renamed.c_renamed(1, 0);

    public c_renamed(int i_renamed, int i2) {
        super(i_renamed, i2, 1);
    }

    @Override // c_renamed.h_renamed.a_renamed
    public boolean e_renamed() {
        return a_renamed() > b_renamed();
    }

    @Override // c_renamed.h_renamed.a_renamed
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof c_renamed.h_renamed.c_renamed) {
            if (!e_renamed() || !((c_renamed.h_renamed.c_renamed) obj).e_renamed()) {
                c_renamed.h_renamed.c_renamed cVar = (c_renamed.h_renamed.c_renamed) obj;
                if (a_renamed() != cVar.a_renamed() || b_renamed() != cVar.b_renamed()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // c_renamed.h_renamed.a_renamed
    public int hashCode() {
        if (e_renamed()) {
            return -1;
        }
        return b_renamed() + (a_renamed() * 31);
    }

    @Override // c_renamed.h_renamed.a_renamed
    public java.lang.String toString() {
        return a_renamed() + ".." + b_renamed();
    }

    /* compiled from: Ranges.kt */
    public static final class a_renamed {
        private a_renamed() {
        }

        public /* synthetic */ a_renamed(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }
    }
}
