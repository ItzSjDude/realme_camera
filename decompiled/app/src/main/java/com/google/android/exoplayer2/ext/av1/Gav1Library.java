package com.google.android.exoplayer2.ext.av1;

import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.util.LibraryLoader;

/* loaded from: classes.dex */
public final class Gav1Library {
    private static final LibraryLoader LOADER;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.gav1");
        LOADER = new LibraryLoader("gav1JNI");
    }

    private Gav1Library() {
    }

    public static boolean isAvailable() {
        return LOADER.isAvailable();
    }
}
