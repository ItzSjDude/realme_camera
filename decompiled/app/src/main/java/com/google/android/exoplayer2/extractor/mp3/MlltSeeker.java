package com.google.android.exoplayer2.extractor.mp3;

/* loaded from: classes.dex */
final class MlltSeeker implements com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker {
    private final long durationUs;
    private final long[] referencePositions;
    private final long[] referenceTimesMs;

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getDataEndPosition() {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public static com.google.android.exoplayer2.extractor.mp3.MlltSeeker create(long j_renamed, com.google.android.exoplayer2.metadata.id3.MlltFrame mlltFrame) {
        int length = mlltFrame.bytesDeviations.length;
        int i_renamed = length + 1;
        long[] jArr = new long[i_renamed];
        long[] jArr2 = new long[i_renamed];
        jArr[0] = j_renamed;
        long j2 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j_renamed += mlltFrame.bytesBetweenReference + mlltFrame.bytesDeviations[i3];
            j2 += mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i3];
            jArr[i2] = j_renamed;
            jArr2[i2] = j2;
        }
        return new com.google.android.exoplayer2.extractor.mp3.MlltSeeker(jArr, jArr2);
    }

    private MlltSeeker(long[] jArr, long[] jArr2) {
        this.referencePositions = jArr;
        this.referenceTimesMs = jArr2;
        this.durationUs = com.google.android.exoplayer2.C_renamed.msToUs(jArr2[jArr2.length - 1]);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j_renamed) {
        android.util.Pair<java.lang.Long, java.lang.Long> pairLinearlyInterpolate = linearlyInterpolate(com.google.android.exoplayer2.C_renamed.usToMs(com.google.android.exoplayer2.util.Util.constrainValue(j_renamed, 0L, this.durationUs)), this.referenceTimesMs, this.referencePositions);
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(com.google.android.exoplayer2.C_renamed.msToUs(((java.lang.Long) pairLinearlyInterpolate.first).longValue()), ((java.lang.Long) pairLinearlyInterpolate.second).longValue()));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j_renamed) {
        return com.google.android.exoplayer2.C_renamed.msToUs(((java.lang.Long) linearlyInterpolate(j_renamed, this.referencePositions, this.referenceTimesMs).second).longValue());
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    private static android.util.Pair<java.lang.Long, java.lang.Long> linearlyInterpolate(long j_renamed, long[] jArr, long[] jArr2) {
        int iBinarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(jArr, j_renamed, true, true);
        long j2 = jArr[iBinarySearchFloor];
        long j3 = jArr2[iBinarySearchFloor];
        int i_renamed = iBinarySearchFloor + 1;
        if (i_renamed == jArr.length) {
            return android.util.Pair.create(java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3));
        }
        return android.util.Pair.create(java.lang.Long.valueOf(j_renamed), java.lang.Long.valueOf(((long) ((jArr[i_renamed] == j2 ? 0.0d : (j_renamed - j2) / (r6 - j2)) * (jArr2[i_renamed] - j3))) + j3));
    }
}
