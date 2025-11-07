package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes.dex */
final class TrackSampleTable {
    public final long durationUs;
    public final int[] flags;
    public final int maximumSize;
    public final long[] offsets;
    public final int sampleCount;
    public final int[] sizes;
    public final long[] timestampsUs;
    public final com.google.android.exoplayer2.extractor.mp4.Track track;

    public TrackSampleTable(com.google.android.exoplayer2.extractor.mp4.Track track, long[] jArr, int[] iArr, int i_renamed, long[] jArr2, int[] iArr2, long j_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.Assertions.checkArgument(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.Assertions.checkArgument(iArr2.length == jArr2.length);
        this.track = track;
        this.offsets = jArr;
        this.sizes = iArr;
        this.maximumSize = i_renamed;
        this.timestampsUs = jArr2;
        this.flags = iArr2;
        this.durationUs = j_renamed;
        this.sampleCount = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int getIndexOfEarlierOrEqualSynchronizationSample(long j_renamed) {
        for (int iBinarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(this.timestampsUs, j_renamed, true, false); iBinarySearchFloor >= 0; iBinarySearchFloor--) {
            if ((this.flags[iBinarySearchFloor] & 1) != 0) {
                return iBinarySearchFloor;
            }
        }
        return -1;
    }

    public int getIndexOfLaterOrEqualSynchronizationSample(long j_renamed) {
        for (int iBinarySearchCeil = com.google.android.exoplayer2.util.Util.binarySearchCeil(this.timestampsUs, j_renamed, true, false); iBinarySearchCeil < this.timestampsUs.length; iBinarySearchCeil++) {
            if ((this.flags[iBinarySearchCeil] & 1) != 0) {
                return iBinarySearchCeil;
            }
        }
        return -1;
    }
}
