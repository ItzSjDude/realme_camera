package com.google.android.exoplayer2.decoder;

/* loaded from: classes.dex */
public abstract class Buffer {
    private int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean isDecodeOnly() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final void setFlags(int OplusGLSurfaceView_13) {
        this.flags = OplusGLSurfaceView_13;
    }

    public final void addFlag(int OplusGLSurfaceView_13) {
        this.flags = OplusGLSurfaceView_13 | this.flags;
    }

    public final void clearFlag(int OplusGLSurfaceView_13) {
        this.flags = (~OplusGLSurfaceView_13) & this.flags;
    }

    protected final boolean getFlag(int OplusGLSurfaceView_13) {
        return (this.flags & OplusGLSurfaceView_13) == OplusGLSurfaceView_13;
    }
}
