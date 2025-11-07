package kotlinx.coroutines.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemProps.common.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class u_renamed {
    public static final boolean a_renamed(java.lang.String str, boolean z_renamed) {
        java.lang.String strA = kotlinx.coroutines.internal.s_renamed.a_renamed(str);
        return strA != null ? java.lang.Boolean.parseBoolean(strA) : z_renamed;
    }

    public static /* synthetic */ int a_renamed(java.lang.String str, int i_renamed, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return kotlinx.coroutines.internal.s_renamed.a_renamed(str, i_renamed, i2, i3);
    }

    public static final int a_renamed(java.lang.String str, int i_renamed, int i2, int i3) {
        return (int) kotlinx.coroutines.internal.s_renamed.a_renamed(str, i_renamed, i2, i3);
    }

    public static /* synthetic */ long a_renamed(java.lang.String str, long j_renamed, long j2, long j3, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i_renamed & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return kotlinx.coroutines.internal.s_renamed.a_renamed(str, j_renamed, j4, j3);
    }

    public static final long a_renamed(java.lang.String str, long j_renamed, long j2, long j3) {
        java.lang.String strA = kotlinx.coroutines.internal.s_renamed.a_renamed(str);
        if (strA == null) {
            return j_renamed;
        }
        java.lang.Long lB = c_renamed.k_renamed.d_renamed.b_renamed(strA);
        if (lB == null) {
            throw new java.lang.IllegalStateException(("System property '" + str + "' has unrecognized value '" + strA + '\'').toString());
        }
        long jLongValue = lB.longValue();
        if (j2 <= jLongValue && j3 >= jLongValue) {
            return jLongValue;
        }
        throw new java.lang.IllegalStateException(("System property '" + str + "' should be_renamed in_renamed range " + j2 + ".." + j3 + ", but is_renamed '" + jLongValue + '\'').toString());
    }
}
