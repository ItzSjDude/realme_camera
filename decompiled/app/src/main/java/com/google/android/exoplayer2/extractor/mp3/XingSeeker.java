package com.google.android.exoplayer2.extractor.mp3;

/* loaded from: classes.dex */
final class XingSeeker implements com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker {
    private static final java.lang.String TAG = "XingSeeker";
    private final long dataEndPosition;
    private final long dataSize;
    private final long dataStartPosition;
    private final long durationUs;
    private final long[] tableOfContents;
    private final int xingFrameSize;

    public static com.google.android.exoplayer2.extractor.mp3.XingSeeker create(long j_renamed, long j2, com.google.android.exoplayer2.extractor.MpegAudioHeader mpegAudioHeader, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int unsignedIntToInt;
        int i_renamed = mpegAudioHeader.samplesPerFrame;
        int i2 = mpegAudioHeader.sampleRate;
        int i3 = parsableByteArray.readInt();
        if ((i3 & 1) != 1 || (unsignedIntToInt = parsableByteArray.readUnsignedIntToInt()) == 0) {
            return null;
        }
        long jScaleLargeTimestamp = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(unsignedIntToInt, i_renamed * 1000000, i2);
        if ((i3 & 6) != 6) {
            return new com.google.android.exoplayer2.extractor.mp3.XingSeeker(j2, mpegAudioHeader.frameSize, jScaleLargeTimestamp);
        }
        long unsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[100];
        for (int i4 = 0; i4 < 100; i4++) {
            jArr[i4] = parsableByteArray.readUnsignedByte();
        }
        if (j_renamed != -1) {
            long j3 = j2 + unsignedIntToInt2;
            if (j_renamed != j3) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "XING data size mismatch: " + j_renamed + ", " + j3);
            }
        }
        return new com.google.android.exoplayer2.extractor.mp3.XingSeeker(j2, mpegAudioHeader.frameSize, jScaleLargeTimestamp, unsignedIntToInt2, jArr);
    }

    private XingSeeker(long j_renamed, int i_renamed, long j2) {
        this(j_renamed, i_renamed, j2, -1L, null);
    }

    private XingSeeker(long j_renamed, int i_renamed, long j2, long j3, long[] jArr) {
        this.dataStartPosition = j_renamed;
        this.xingFrameSize = i_renamed;
        this.durationUs = j2;
        this.tableOfContents = jArr;
        this.dataSize = j3;
        this.dataEndPosition = j3 != -1 ? j_renamed + j3 : -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.tableOfContents != null;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j_renamed) {
        if (!isSeekable()) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(0L, this.dataStartPosition + this.xingFrameSize));
        }
        long jConstrainValue = com.google.android.exoplayer2.util.Util.constrainValue(j_renamed, 0L, this.durationUs);
        double d_renamed = (jConstrainValue * 100.0d) / this.durationUs;
        double d2 = 0.0d;
        if (d_renamed > 0.0d) {
            if (d_renamed >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i_renamed = (int) d_renamed;
                double d3 = ((long[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.tableOfContents))[i_renamed];
                d2 = d3 + ((d_renamed - i_renamed) * ((i_renamed == 99 ? 256.0d : r3[i_renamed + 1]) - d3));
            }
        }
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(jConstrainValue, this.dataStartPosition + com.google.android.exoplayer2.util.Util.constrainValue(java.lang.Math.round((d2 / 256.0d) * this.dataSize), this.xingFrameSize, this.dataSize - 1)));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j_renamed) {
        long j2 = j_renamed - this.dataStartPosition;
        if (!isSeekable() || j2 <= this.xingFrameSize) {
            return 0L;
        }
        long[] jArr = (long[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.tableOfContents);
        double d_renamed = (j2 * 256.0d) / this.dataSize;
        int iBinarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(jArr, (long) d_renamed, true, true);
        long timeUsForTableIndex = getTimeUsForTableIndex(iBinarySearchFloor);
        long j3 = jArr[iBinarySearchFloor];
        int i_renamed = iBinarySearchFloor + 1;
        long timeUsForTableIndex2 = getTimeUsForTableIndex(i_renamed);
        return timeUsForTableIndex + java.lang.Math.round((j3 == (iBinarySearchFloor == 99 ? 256L : jArr[i_renamed]) ? 0.0d : (d_renamed - j3) / (r0 - j3)) * (timeUsForTableIndex2 - timeUsForTableIndex));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    private long getTimeUsForTableIndex(int i_renamed) {
        return (this.durationUs * i_renamed) / 100;
    }
}
