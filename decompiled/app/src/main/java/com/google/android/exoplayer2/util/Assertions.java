package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class Assertions {
    private Assertions() {
    }

    public static void checkArgument(boolean z_renamed) {
        if (!z_renamed) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z_renamed, java.lang.Object obj) {
        if (!z_renamed) {
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
        if (!z_renamed) {
            throw new java.lang.IllegalStateException();
        }
    }

    public static void checkState(boolean z_renamed, java.lang.Object obj) {
        if (!z_renamed) {
            throw new java.lang.IllegalStateException(java.lang.String.valueOf(obj));
        }
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static <T_renamed> T_renamed checkNotNull(T_renamed t_renamed) {
        if (t_renamed != null) {
            return t_renamed;
        }
        throw new java.lang.NullPointerException();
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static <T_renamed> T_renamed checkNotNull(T_renamed t_renamed, java.lang.Object obj) {
        if (t_renamed != null) {
            return t_renamed;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(obj));
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static java.lang.String checkNotEmpty(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException();
        }
        return str;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static java.lang.String checkNotEmpty(java.lang.String str, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
        return str;
    }

    public static void checkMainThread() {
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException("Not in_renamed applications main thread");
        }
    }
}
