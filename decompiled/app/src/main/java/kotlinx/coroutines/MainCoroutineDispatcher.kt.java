package kotlinx.coroutines;

/* compiled from: MainCoroutineDispatcher.kt */
/* loaded from: classes2.dex */
public abstract class bf_renamed extends kotlinx.coroutines.t_renamed {
    public abstract kotlinx.coroutines.bf_renamed a_renamed();

    @Override // kotlinx.coroutines.t_renamed
    public java.lang.String toString() {
        java.lang.String strB = b_renamed();
        if (strB != null) {
            return strB;
        }
        return kotlinx.coroutines.ad_renamed.b_renamed(this) + '@' + kotlinx.coroutines.ad_renamed.a_renamed(this);
    }

    protected final java.lang.String b_renamed() {
        kotlinx.coroutines.bf_renamed bfVarA;
        kotlinx.coroutines.bf_renamed bfVarB = kotlinx.coroutines.aj_renamed.b_renamed();
        kotlinx.coroutines.bf_renamed bfVar = this;
        if (bfVar == bfVarB) {
            return "Dispatchers.Main";
        }
        try {
            bfVarA = bfVarB.a_renamed();
        } catch (java.lang.UnsupportedOperationException unused) {
            bfVarA = null;
        }
        if (bfVar == bfVarA) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
