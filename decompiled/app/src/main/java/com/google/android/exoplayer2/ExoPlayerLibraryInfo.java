package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class ExoPlayerLibraryInfo {
    public static final boolean ASSERTIONS_ENABLED = true;
    public static final boolean GL_ASSERTIONS_ENABLED = false;
    public static final java.lang.String TAG = "ExoPlayer";
    public static final boolean TRACE_ENABLED = true;
    public static final java.lang.String VERSION = "2.9.6";
    public static final int VERSION_INT = 2009006;
    public static final java.lang.String VERSION_SLASHY = "ExoPlayerLib/2.9.6";
    private static final java.util.HashSet<java.lang.String> registeredModules = new java.util.HashSet<>();
    private static java.lang.String registeredModulesString = "goog.exo.core";

    private ExoPlayerLibraryInfo() {
    }

    public static synchronized java.lang.String registeredModules() {
        return registeredModulesString;
    }

    public static synchronized void registerModule(java.lang.String str) {
        if (registeredModules.add(str)) {
            registeredModulesString += ", " + str;
        }
    }
}
