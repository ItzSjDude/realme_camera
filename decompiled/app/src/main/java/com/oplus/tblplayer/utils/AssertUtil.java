package com.oplus.tblplayer.utils;

/* loaded from: classes2.dex */
public final class AssertUtil {
    public static final boolean ASSERTIONS_ENABLED = com.oplus.tblplayer.config.Globals.DEBUG;

    private AssertUtil() {
    }

    public static void checkArgument(boolean z_renamed) {
        if (ASSERTIONS_ENABLED && !z_renamed) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z_renamed, java.lang.Object obj) {
        if (ASSERTIONS_ENABLED && !z_renamed) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
    }

    public static int checkIndex(int i_renamed, int i2, int i3) {
        if (i_renamed < i2 || i_renamed >= i3) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return i_renamed;
    }

    public static void checkState(boolean z_renamed) {
        if (ASSERTIONS_ENABLED && !z_renamed) {
            throw new java.lang.IllegalStateException();
        }
    }

    public static void checkState(boolean z_renamed, java.lang.Object obj) {
        if (ASSERTIONS_ENABLED && !z_renamed) {
            throw new java.lang.IllegalStateException(java.lang.String.valueOf(obj));
        }
    }

    public static <T_renamed> T_renamed checkNotNull(T_renamed t_renamed) {
        if (ASSERTIONS_ENABLED && t_renamed == null) {
            throw new java.lang.NullPointerException();
        }
        return t_renamed;
    }

    public static <T_renamed> T_renamed checkNotNull(T_renamed t_renamed, java.lang.Object obj) {
        if (ASSERTIONS_ENABLED && t_renamed == null) {
            throw new java.lang.NullPointerException(java.lang.String.valueOf(obj));
        }
        return t_renamed;
    }

    public static java.lang.String checkNotEmpty(java.lang.String str) {
        if (ASSERTIONS_ENABLED && android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException();
        }
        return str;
    }

    public static java.lang.String checkNotEmpty(java.lang.String str, java.lang.Object obj) {
        if (ASSERTIONS_ENABLED && android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
        return str;
    }

    public static void checkMainThread() {
        if (ASSERTIONS_ENABLED && android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException("Not in_renamed applications main thread");
        }
    }
}
