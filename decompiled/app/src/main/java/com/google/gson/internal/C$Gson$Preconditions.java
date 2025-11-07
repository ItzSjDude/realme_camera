package com.google.gson.internal;

/* renamed from: com.google.gson.internal.$Gson$Preconditions, reason: invalid class name */
/* loaded from: classes.dex */
public final class C_renamed$Gson$Preconditions {
    private C_renamed$Gson$Preconditions() {
        throw new java.lang.UnsupportedOperationException();
    }

    public static <T_renamed> T_renamed checkNotNull(T_renamed t_renamed) {
        if (t_renamed != null) {
            return t_renamed;
        }
        throw new java.lang.NullPointerException();
    }

    public static void checkArgument(boolean z_renamed) {
        if (!z_renamed) {
            throw new java.lang.IllegalArgumentException();
        }
    }
}
