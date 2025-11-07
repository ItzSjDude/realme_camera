package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class ExoPlaybackException extends java.lang.Exception {
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    private final java.lang.Throwable cause;
    public final int rendererIndex;
    public final int type;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public static com.google.android.exoplayer2.ExoPlaybackException createForSource(java.io.IOException iOException) {
        return new com.google.android.exoplayer2.ExoPlaybackException(0, iOException, -1);
    }

    public static com.google.android.exoplayer2.ExoPlaybackException createForRenderer(java.lang.Exception exc, int i_renamed) {
        return new com.google.android.exoplayer2.ExoPlaybackException(1, exc, i_renamed);
    }

    static com.google.android.exoplayer2.ExoPlaybackException createForUnexpected(java.lang.RuntimeException runtimeException) {
        return new com.google.android.exoplayer2.ExoPlaybackException(2, runtimeException, -1);
    }

    private ExoPlaybackException(int i_renamed, java.lang.Throwable th, int i2) {
        super(th);
        this.type = i_renamed;
        this.cause = th;
        this.rendererIndex = i2;
    }

    public java.io.IOException getSourceException() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.type == 0);
        return (java.io.IOException) this.cause;
    }

    public java.lang.Exception getRendererException() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.type == 1);
        return (java.lang.Exception) this.cause;
    }

    public java.lang.RuntimeException getUnexpectedException() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.type == 2);
        return (java.lang.RuntimeException) this.cause;
    }
}
