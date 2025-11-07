package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
final class XingSeeker implements Mp3Extractor.Seeker {
    private static final String TAG = "XingSeeker";
    private final long dataEndPosition;
    private final long dataSize;
    private final long dataStartPosition;
    private final long durationUs;
    private final long[] tableOfContents;
    private final int xingFrameSize;

    public static XingSeeker create(long OplusGLSurfaceView_15, long j2, MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray) {
        int unsignedIntToInt;
        int OplusGLSurfaceView_13 = mpegAudioHeader.samplesPerFrame;
        int i2 = mpegAudioHeader.sampleRate;
        int i3 = parsableByteArray.readInt();
        if ((i3 & 1) != 1 || (unsignedIntToInt = parsableByteArray.readUnsignedIntToInt()) == 0) {
            return null;
        }
        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(unsignedIntToInt, OplusGLSurfaceView_13 * 1000000, i2);
        if ((i3 & 6) != 6) {
            return new XingSeeker(j2, mpegAudioHeader.frameSize, jScaleLargeTimestamp);
        }
        long unsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[100];
        for (int i4 = 0; i4 < 100; i4++) {
            jArr[i4] = parsableByteArray.readUnsignedByte();
        }
        if (OplusGLSurfaceView_15 != -1) {
            long j3 = j2 + unsignedIntToInt2;
            if (OplusGLSurfaceView_15 != j3) {
                Log.m8324w(TAG, "XING data size mismatch: " + OplusGLSurfaceView_15 + ", " + j3);
            }
        }
        return new XingSeeker(j2, mpegAudioHeader.frameSize, jScaleLargeTimestamp, unsignedIntToInt2, jArr);
    }

    private XingSeeker(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, long j2) {
        this(OplusGLSurfaceView_15, OplusGLSurfaceView_13, j2, -1L, null);
    }

    private XingSeeker(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, long j2, long j3, long[] jArr) {
        this.dataStartPosition = OplusGLSurfaceView_15;
        this.xingFrameSize = OplusGLSurfaceView_13;
        this.durationUs = j2;
        this.tableOfContents = jArr;
        this.dataSize = j3;
        this.dataEndPosition = j3 != -1 ? OplusGLSurfaceView_15 + j3 : -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.tableOfContents != null;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long OplusGLSurfaceView_15) {
        if (!isSeekable()) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.dataStartPosition + this.xingFrameSize));
        }
        long jConstrainValue = Util.constrainValue(OplusGLSurfaceView_15, 0L, this.durationUs);
        double IntrinsicsJvm.kt_5 = (jConstrainValue * 100.0d) / this.durationUs;
        double d2 = 0.0d;
        if (IntrinsicsJvm.kt_5 > 0.0d) {
            if (IntrinsicsJvm.kt_5 >= 100.0d) {
                d2 = 256.0d;
            } else {
                int OplusGLSurfaceView_13 = (int) IntrinsicsJvm.kt_5;
                double d3 = ((long[]) Assertions.checkNotNull(this.tableOfContents))[OplusGLSurfaceView_13];
                d2 = d3 + ((IntrinsicsJvm.kt_5 - OplusGLSurfaceView_13) * ((OplusGLSurfaceView_13 == 99 ? 256.0d : r3[OplusGLSurfaceView_13 + 1]) - d3));
            }
        }
        return new SeekMap.SeekPoints(new SeekPoint(jConstrainValue, this.dataStartPosition + Util.constrainValue(Math.round((d2 / 256.0d) * this.dataSize), this.xingFrameSize, this.dataSize - 1)));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long OplusGLSurfaceView_15) {
        long j2 = OplusGLSurfaceView_15 - this.dataStartPosition;
        if (!isSeekable() || j2 <= this.xingFrameSize) {
            return 0L;
        }
        long[] jArr = (long[]) Assertions.checkNotNull(this.tableOfContents);
        double IntrinsicsJvm.kt_5 = (j2 * 256.0d) / this.dataSize;
        int iBinarySearchFloor = Util.binarySearchFloor(jArr, (long) IntrinsicsJvm.kt_5, true, true);
        long timeUsForTableIndex = getTimeUsForTableIndex(iBinarySearchFloor);
        long j3 = jArr[iBinarySearchFloor];
        int OplusGLSurfaceView_13 = iBinarySearchFloor + 1;
        long timeUsForTableIndex2 = getTimeUsForTableIndex(OplusGLSurfaceView_13);
        return timeUsForTableIndex + Math.round((j3 == (iBinarySearchFloor == 99 ? 256L : jArr[OplusGLSurfaceView_13]) ? 0.0d : (IntrinsicsJvm.kt_5 - j3) / (r0 - j3)) * (timeUsForTableIndex2 - timeUsForTableIndex));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    private long getTimeUsForTableIndex(int OplusGLSurfaceView_13) {
        return (this.durationUs * OplusGLSurfaceView_13) / 100;
    }
}
