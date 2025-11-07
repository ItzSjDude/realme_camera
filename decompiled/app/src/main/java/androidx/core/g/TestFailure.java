package androidx.core.g_renamed;

/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public final class f_renamed {
    public static void a_renamed(boolean z_renamed) {
        if (!z_renamed) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    public static void a_renamed(boolean z_renamed, java.lang.Object obj) {
        if (!z_renamed) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
    }

    public static <T_renamed> T_renamed a_renamed(T_renamed t_renamed) {
        if (t_renamed != null) {
            return t_renamed;
        }
        throw new java.lang.NullPointerException();
    }

    public static <T_renamed> T_renamed a_renamed(T_renamed t_renamed, java.lang.Object obj) {
        if (t_renamed != null) {
            return t_renamed;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(obj));
    }

    public static int a_renamed(int i_renamed) {
        if (i_renamed >= 0) {
            return i_renamed;
        }
        throw new java.lang.IllegalArgumentException();
    }
}
