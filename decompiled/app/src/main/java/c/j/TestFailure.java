package c_renamed.j_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* loaded from: classes.dex */
public class f_renamed extends c_renamed.j_renamed.e_renamed {

    /* JADX INFO: Add missing generic type declarations: [T_renamed] */
    /* compiled from: Sequences.kt */
    public static final class a_renamed<T_renamed> implements c_renamed.j_renamed.b_renamed<T_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ java.util.Iterator f1923a;

        public a_renamed(java.util.Iterator it) {
            this.f1923a = it;
        }

        @Override // c_renamed.j_renamed.b_renamed
        public java.util.Iterator<T_renamed> a_renamed() {
            return this.f1923a;
        }
    }

    public static final <T_renamed> c_renamed.j_renamed.b_renamed<T_renamed> a_renamed(java.util.Iterator<? extends T_renamed> it) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(it, "$this$asSequence");
        return c_renamed.j_renamed.c_renamed.a_renamed(new c_renamed.j_renamed.f_renamed.a_renamed(it));
    }

    public static final <T_renamed> c_renamed.j_renamed.b_renamed<T_renamed> a_renamed(c_renamed.j_renamed.b_renamed<? extends T_renamed> bVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(bVar, "$this$constrainOnce");
        return bVar instanceof c_renamed.j_renamed.a_renamed ? (c_renamed.j_renamed.a_renamed) bVar : new c_renamed.j_renamed.a_renamed(bVar);
    }
}
