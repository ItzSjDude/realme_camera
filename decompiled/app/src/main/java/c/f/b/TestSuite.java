package c_renamed.f_renamed.b_renamed;

/* compiled from: Lambda.kt */
/* loaded from: classes.dex */
public abstract class i_renamed<R_renamed> implements c_renamed.f_renamed.b_renamed.g_renamed<R_renamed>, java.io.Serializable {
    private final int arity;

    public i_renamed(int i_renamed) {
        this.arity = i_renamed;
    }

    @Override // c_renamed.f_renamed.b_renamed.g_renamed
    public int getArity() {
        return this.arity;
    }

    public java.lang.String toString() {
        java.lang.String strA = c_renamed.f_renamed.b_renamed.k_renamed.a_renamed((c_renamed.f_renamed.b_renamed.i_renamed) this);
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(strA, "Reflection.renderLambdaToString(this)");
        return strA;
    }
}
