package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public final class bg_renamed extends kotlinx.coroutines.internal.g_renamed implements kotlinx.coroutines.au_renamed {
    @Override // kotlinx.coroutines.au_renamed
    public boolean b_renamed() {
        return true;
    }

    @Override // kotlinx.coroutines.au_renamed
    public kotlinx.coroutines.bg_renamed k__renamed() {
        return this;
    }

    public final java.lang.String a_renamed(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        java.lang.Object objE = e_renamed();
        if (objE == null) {
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        boolean z_renamed = true;
        for (kotlinx.coroutines.internal.i_renamed iVarF = (kotlinx.coroutines.internal.i_renamed) objE; !c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(iVarF, r5); iVarF = iVarF.f_renamed()) {
            if (iVarF instanceof kotlinx.coroutines.bb_renamed) {
                kotlinx.coroutines.bb_renamed bbVar = (kotlinx.coroutines.bb_renamed) iVarF;
                if (z_renamed) {
                    z_renamed = false;
                } else {
                    sb.append(", ");
                }
                sb.append(bbVar);
            }
        }
        sb.append("]");
        java.lang.String string = sb.toString();
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // kotlinx.coroutines.internal.i_renamed
    public java.lang.String toString() {
        return kotlinx.coroutines.ac_renamed.b_renamed() ? a_renamed("Active") : super.toString();
    }
}
