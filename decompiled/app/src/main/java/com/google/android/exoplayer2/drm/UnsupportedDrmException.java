package com.google.android.exoplayer2.drm;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class UnsupportedDrmException extends Exception {
    public static final int REASON_INSTANTIATION_ERROR = 2;
    public static final int REASON_UNSUPPORTED_SCHEME = 1;
    public final int reason;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Reason {
    }

    public UnsupportedDrmException(int OplusGLSurfaceView_13) {
        this.reason = OplusGLSurfaceView_13;
    }

    public UnsupportedDrmException(int OplusGLSurfaceView_13, Exception exc) {
        super(exc);
        this.reason = OplusGLSurfaceView_13;
    }
}
