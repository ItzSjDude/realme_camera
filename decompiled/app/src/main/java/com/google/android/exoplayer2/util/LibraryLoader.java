package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class LibraryLoader {
    private boolean isAvailable;
    private boolean loadAttempted;
    private java.lang.String[] nativeLibraries;

    public LibraryLoader(java.lang.String... strArr) {
        this.nativeLibraries = strArr;
    }

    public synchronized void setLibraries(java.lang.String... strArr) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.loadAttempted, "Cannot set libraries after loading");
        this.nativeLibraries = strArr;
    }

    public synchronized boolean isAvailable() {
        if (this.loadAttempted) {
            return this.isAvailable;
        }
        this.loadAttempted = true;
        try {
            for (java.lang.String str : this.nativeLibraries) {
                java.lang.System.loadLibrary(str);
            }
            this.isAvailable = true;
        } catch (java.lang.UnsatisfiedLinkError unused) {
        }
        return this.isAvailable;
    }
}
