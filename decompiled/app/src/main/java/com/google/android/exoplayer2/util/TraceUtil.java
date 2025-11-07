package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class TraceUtil {
    private TraceUtil() {
    }

    public static void beginSection(java.lang.String str) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 18) {
            beginSectionV18(str);
        }
    }

    public static void endSection() {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 18) {
            endSectionV18();
        }
    }

    @android.annotation.TargetApi(18)
    private static void beginSectionV18(java.lang.String str) {
        android.os.Trace.beginSection(str);
    }

    @android.annotation.TargetApi(18)
    private static void endSectionV18() {
        android.os.Trace.endSection();
    }
}
