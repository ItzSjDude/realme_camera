package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes.dex */
public abstract class BaseMediaChunkIterator implements com.google.android.exoplayer2.source.chunk.MediaChunkIterator {
    private long currentIndex;
    private final long fromIndex;
    private final long toIndex;

    public BaseMediaChunkIterator(long j_renamed, long j2) {
        this.fromIndex = j_renamed;
        this.toIndex = j2;
        this.currentIndex = j_renamed - 1;
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
        long j_renamed = this.currentIndex;
        if (j_renamed < this.fromIndex || j_renamed > this.toIndex) {
            throw new java.util.NoSuchElementException();
        }
    }

    protected long getCurrentIndex() {
        return this.currentIndex;
    }
}
