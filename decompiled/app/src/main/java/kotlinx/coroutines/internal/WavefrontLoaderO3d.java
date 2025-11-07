package kotlinx.coroutines.internal;

/* compiled from: Atomic.kt */
/* loaded from: classes2.dex */
public abstract class o_renamed {
    public abstract kotlinx.coroutines.internal.c_renamed<?> b_renamed();

    public abstract java.lang.Object c_renamed(java.lang.Object obj);

    public java.lang.String toString() {
        return kotlinx.coroutines.ad_renamed.b_renamed(this) + '@' + kotlinx.coroutines.ad_renamed.a_renamed(this);
    }

    public final boolean a_renamed(kotlinx.coroutines.internal.o_renamed oVar) {
        kotlinx.coroutines.internal.c_renamed<?> cVarB;
        kotlinx.coroutines.internal.c_renamed<?> cVarB2 = b_renamed();
        return (cVarB2 == null || (cVarB = oVar.b_renamed()) == null || cVarB2.a_renamed() >= cVarB.a_renamed()) ? false : true;
    }
}
