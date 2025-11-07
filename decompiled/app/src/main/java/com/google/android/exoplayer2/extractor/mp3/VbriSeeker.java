package com.google.android.exoplayer2.extractor.mp3;

/* loaded from: classes.dex */
final class VbriSeeker implements com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker {
    private static final java.lang.String TAG = "VbriSeeker";
    private final long dataEndPosition;
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public static com.google.android.exoplayer2.extractor.mp3.VbriSeeker create(long j_renamed, long j2, com.google.android.exoplayer2.extractor.MpegAudioHeader mpegAudioHeader, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int unsignedByte;
        parsableByteArray.skipBytes(10);
        int i_renamed = parsableByteArray.readInt();
        if (i_renamed <= 0) {
            return null;
        }
        int i2 = mpegAudioHeader.sampleRate;
        long jScaleLargeTimestamp = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(i_renamed, 1000000 * (i2 >= 32000 ? 1152 : 576), i2);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        int unsignedShort3 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(2);
        long j3 = j2 + mpegAudioHeader.frameSize;
        long[] jArr = new long[unsignedShort];
        long[] jArr2 = new long[unsignedShort];
        int i3 = 0;
        long j4 = j2;
        while (i3 < unsignedShort) {
            int i4 = unsignedShort2;
            long j5 = j3;
            jArr[i3] = (i3 * jScaleLargeTimestamp) / unsignedShort;
            jArr2[i3] = java.lang.Math.max(j4, j5);
            if (unsignedShort3 == 1) {
                unsignedByte = parsableByteArray.readUnsignedByte();
            } else if (unsignedShort3 == 2) {
                unsignedByte = parsableByteArray.readUnsignedShort();
            } else if (unsignedShort3 == 3) {
                unsignedByte = parsableByteArray.readUnsignedInt24();
            } else {
                if (unsignedShort3 != 4) {
                    return null;
                }
                unsignedByte = parsableByteArray.readUnsignedIntToInt();
            }
            j4 += unsignedByte * i4;
            i3++;
            j3 = j5;
            unsignedShort2 = i4;
        }
        if (j_renamed != -1 && j_renamed != j4) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "VBRI data size mismatch: " + j_renamed + ", " + j4);
        }
        return new com.google.android.exoplayer2.extractor.mp3.VbriSeeker(jArr, jArr2, jScaleLargeTimestamp, j4);
    }

    private VbriSeeker(long[] jArr, long[] jArr2, long j_renamed, long j2) {
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j_renamed;
        this.dataEndPosition = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j_renamed) {
        int iBinarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(this.timesUs, j_renamed, true, true);
        com.google.android.exoplayer2.extractor.SeekPoint seekPoint = new com.google.android.exoplayer2.extractor.SeekPoint(this.timesUs[iBinarySearchFloor], this.positions[iBinarySearchFloor]);
        if (seekPoint.timeUs < j_renamed) {
            long[] jArr = this.timesUs;
            if (iBinarySearchFloor != jArr.length - 1) {
                int i_renamed = iBinarySearchFloor + 1;
                return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint, new com.google.android.exoplayer2.extractor.SeekPoint(jArr[i_renamed], this.positions[i_renamed]));
            }
        }
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint);
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j_renamed) {
        return this.timesUs[com.google.android.exoplayer2.util.Util.binarySearchFloor(this.positions, j_renamed, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getDataEndPosition() {
        return this.dataEndPosition;
    }
}
