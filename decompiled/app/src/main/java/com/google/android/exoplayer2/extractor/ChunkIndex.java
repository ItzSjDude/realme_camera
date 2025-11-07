package com.google.android.exoplayer2.extractor;

/* loaded from: classes.dex */
public final class ChunkIndex implements com.google.android.exoplayer2.extractor.SeekMap {
    private final long durationUs;
    public final long[] durationsUs;
    public final int length;
    public final long[] offsets;
    public final int[] sizes;
    public final long[] timesUs;

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public ChunkIndex(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.sizes = iArr;
        this.offsets = jArr;
        this.durationsUs = jArr2;
        this.timesUs = jArr3;
        this.length = iArr.length;
        int i_renamed = this.length;
        if (i_renamed > 0) {
            this.durationUs = jArr2[i_renamed - 1] + jArr3[i_renamed - 1];
        } else {
            this.durationUs = 0L;
        }
    }

    public int getChunkIndex(long j_renamed) {
        return com.google.android.exoplayer2.util.Util.binarySearchFloor(this.timesUs, j_renamed, true, true);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j_renamed) {
        int chunkIndex = getChunkIndex(j_renamed);
        com.google.android.exoplayer2.extractor.SeekPoint seekPoint = new com.google.android.exoplayer2.extractor.SeekPoint(this.timesUs[chunkIndex], this.offsets[chunkIndex]);
        if (seekPoint.timeUs >= j_renamed || chunkIndex == this.length - 1) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint);
        }
        int i_renamed = chunkIndex + 1;
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint, new com.google.android.exoplayer2.extractor.SeekPoint(this.timesUs[i_renamed], this.offsets[i_renamed]));
    }

    public java.lang.String toString() {
        return "ChunkIndex(length=" + this.length + ", sizes=" + java.util.Arrays.toString(this.sizes) + ", offsets=" + java.util.Arrays.toString(this.offsets) + ", timeUs=" + java.util.Arrays.toString(this.timesUs) + ", durationsUs=" + java.util.Arrays.toString(this.durationsUs) + ")";
    }
}
