package com.google.android.exoplayer2.extractor.mp3;

import android.util.Pair;
import com.google.android.exoplayer2.C1547C;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
final class MlltSeeker implements Mp3Extractor.Seeker {
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

    public static MlltSeeker create(long OplusGLSurfaceView_15, MlltFrame mlltFrame) {
        int length = mlltFrame.bytesDeviations.length;
        int OplusGLSurfaceView_13 = length + 1;
        long[] jArr = new long[OplusGLSurfaceView_13];
        long[] jArr2 = new long[OplusGLSurfaceView_13];
        jArr[0] = OplusGLSurfaceView_15;
        long j2 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            OplusGLSurfaceView_15 += mlltFrame.bytesBetweenReference + mlltFrame.bytesDeviations[i3];
            j2 += mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i3];
            jArr[i2] = OplusGLSurfaceView_15;
            jArr2[i2] = j2;
        }
        return new MlltSeeker(jArr, jArr2);
    }

    private MlltSeeker(long[] jArr, long[] jArr2) {
        this.referencePositions = jArr;
        this.referenceTimesMs = jArr2;
        this.durationUs = C1547C.msToUs(jArr2[jArr2.length - 1]);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long OplusGLSurfaceView_15) {
        Pair<Long, Long> pairLinearlyInterpolate = linearlyInterpolate(C1547C.usToMs(Util.constrainValue(OplusGLSurfaceView_15, 0L, this.durationUs)), this.referenceTimesMs, this.referencePositions);
        return new SeekMap.SeekPoints(new SeekPoint(C1547C.msToUs(((Long) pairLinearlyInterpolate.first).longValue()), ((Long) pairLinearlyInterpolate.second).longValue()));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long OplusGLSurfaceView_15) {
        return C1547C.msToUs(((Long) linearlyInterpolate(OplusGLSurfaceView_15, this.referencePositions, this.referenceTimesMs).second).longValue());
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    private static Pair<Long, Long> linearlyInterpolate(long OplusGLSurfaceView_15, long[] jArr, long[] jArr2) {
        int iBinarySearchFloor = Util.binarySearchFloor(jArr, OplusGLSurfaceView_15, true, true);
        long j2 = jArr[iBinarySearchFloor];
        long j3 = jArr2[iBinarySearchFloor];
        int OplusGLSurfaceView_13 = iBinarySearchFloor + 1;
        if (OplusGLSurfaceView_13 == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        return Pair.create(Long.valueOf(OplusGLSurfaceView_15), Long.valueOf(((long) ((jArr[OplusGLSurfaceView_13] == j2 ? 0.0d : (OplusGLSurfaceView_15 - j2) / (r6 - j2)) * (jArr2[OplusGLSurfaceView_13] - j3))) + j3));
    }
}
