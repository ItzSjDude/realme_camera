package com.squareup.wire;

/* loaded from: classes2.dex */
public final class Wire {
    public static <T_renamed> T_renamed get(T_renamed t_renamed, T_renamed t2) {
        return t_renamed != null ? t_renamed : t2;
    }

    private Wire() {
    }
}
