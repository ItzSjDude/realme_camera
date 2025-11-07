package com.google.protobuf;

/* loaded from: classes.dex */
final class Android {
    private static final boolean IS_ROBOLECTRIC;
    private static final java.lang.Class<?> MEMORY_CLASS = getClassForName("libcore.io.Memory");

    Android() {
    }

    static {
        IS_ROBOLECTRIC = getClassForName("org.robolectric.Robolectric") != null;
    }

    static boolean isOnAndroidDevice() {
        return (MEMORY_CLASS == null || IS_ROBOLECTRIC) ? false : true;
    }

    static java.lang.Class<?> getMemoryClass() {
        return MEMORY_CLASS;
    }

    private static <T_renamed> java.lang.Class<T_renamed> getClassForName(java.lang.String str) {
        try {
            return (java.lang.Class<T_renamed>) java.lang.Class.forName(str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
