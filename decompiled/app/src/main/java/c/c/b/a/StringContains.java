package c_renamed.c_renamed.b_renamed.a_renamed;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes.dex */
public abstract class j_renamed extends c_renamed.c_renamed.b_renamed.a_renamed.c_renamed implements c_renamed.f_renamed.b_renamed.g_renamed<java.lang.Object> {
    private final int arity;

    @Override // c_renamed.f_renamed.b_renamed.g_renamed
    public int getArity() {
        return this.arity;
    }

    public j_renamed(int i_renamed, c_renamed.c_renamed.d_renamed<java.lang.Object> dVar) {
        super(dVar);
        this.arity = i_renamed;
    }

    public j_renamed(int i_renamed) {
        this(i_renamed, null);
    }

    @Override // c_renamed.c_renamed.b_renamed.a_renamed.a_renamed
    public java.lang.String toString() {
        if (getCompletion() == null) {
            java.lang.String strA = c_renamed.f_renamed.b_renamed.k_renamed.a_renamed(this);
            c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(strA, "Reflection.renderLambdaToString(this)");
            return strA;
        }
        return super.toString();
    }
}
