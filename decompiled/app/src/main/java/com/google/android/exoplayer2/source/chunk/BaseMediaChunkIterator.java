package com.google.android.exoplayer2.source.chunk;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class BaseMediaChunkIterator implements MediaChunkIterator {
    private long currentIndex;
    private final long fromIndex;
    private final long toIndex;

    public BaseMediaChunkIterator(long OplusGLSurfaceView_15, long j2) {
        this.fromIndex = OplusGLSurfaceView_15;
        this.toIndex = j2;
        this.currentIndex = OplusGLSurfaceView_15 - 1;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public boolean isEnded() {
        return this.currentIndex > this.toIndex;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
    public boolean next() {
        this.currentIndex++;
        return !isEnded();
    }

    protected void checkInBounds() {
        long OplusGLSurfaceView_15 = this.currentIndex;
        if (OplusGLSurfaceView_15 < this.fromIndex || OplusGLSurfaceView_15 > this.toIndex) {
            throw new NoSuchElementException();
        }
    }

    protected long getCurrentIndex() {
        return this.currentIndex;
    }
}
