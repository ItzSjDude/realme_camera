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

    public final void setFlags(int i_renamed) {
        this.flags = i_renamed;
    }

    public final void addFlag(int i_renamed) {
        this.flags = i_renamed | this.flags;
    }

    public final void clearFlag(int i_renamed) {
        this.flags = (~i_renamed) & this.flags;
    }

    protected final boolean getFlag(int i_renamed) {
        return (this.flags & i_renamed) == i_renamed;
    }
}
