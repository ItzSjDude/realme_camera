package com.google.android.exoplayer2.drm;

/* loaded from: classes.dex */
public class DecryptionException extends Exception {
    public final int errorCode;

    public DecryptionException(int OplusGLSurfaceView_13, String str) {
        super(str);
        this.errorCode = OplusGLSurfaceView_13;
    }
}
