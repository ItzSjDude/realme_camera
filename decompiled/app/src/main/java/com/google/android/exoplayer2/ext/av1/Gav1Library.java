package com.google.android.exoplayer2.ext.av1;

/* loaded from: classes.dex */
public final class Gav1Library {
    private static final com.google.android.exoplayer2.util.LibraryLoader LOADER;

    static {
        com.google.android.exoplayer2.ExoPlayerLibraryInfo.registerModule("goog.exo.gav1");
        LOADER = new com.google.android.exoplayer2.util.LibraryLoader("gav1JNI");
    }

    private Gav1Library() {
    }

    public static boolean isAvailable() {
        return LOADER.isAvailable();
    }
}
