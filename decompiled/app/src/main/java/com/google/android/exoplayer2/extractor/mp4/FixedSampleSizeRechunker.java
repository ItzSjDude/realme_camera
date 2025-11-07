package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes.dex */
final class FixedSampleSizeRechunker {
    private static final int MAX_SAMPLE_SIZE = 8192;

    public static final class Results {
        public final long duration;
        public final int[] flags;
        public final int maximumSize;
        public final long[] offsets;
        public final int[] sizes;
        public final long[] timestamps;

        private Results(long[] jArr, int[] iArr, int i_renamed, long[] jArr2, int[] iArr2, long j_renamed) {
            this.offsets = jArr;
            this.sizes = iArr;
            this.maximumSize = i_renamed;
            this.timestamps = jArr2;
            this.flags = iArr2;
            this.duration = j_renamed;
        }
    }

    public static com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.Results rechunk(int i_renamed, long[] jArr, int[] iArr, long j_renamed) {
        int i2 = 8192 / i_renamed;
        int iCeilDivide = 0;
        for (int i3 : iArr) {
            iCeilDivide += com.google.android.exoplayer2.util.Util.ceilDivide(i3, i2);
        }
        long[] jArr2 = new long[iCeilDivide];
        int[] iArr2 = new int[iCeilDivide];
        long[] jArr3 = new long[iCeilDivide];
        int[] iArr3 = new int[iCeilDivide];
        int i4 = 0;
        int i5 = 0;
        int iMax = 0;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            long j2 = jArr[i6];
            while (i7 > 0) {
                int iMin = java.lang.Math.min(i2, i7);
                jArr2[i5] = j2;
                iArr2[i5] = i_renamed * iMin;
                iMax = java.lang.Math.max(iMax, iArr2[i5]);
                jArr3[i5] = i4 * j_renamed;
                iArr3[i5] = 1;
                j2 += iArr2[i5];
                i4 += iMin;
                i7 -= iMin;
                i5++;
            }
        }
        return new com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.Results(jArr2, iArr2, iMax, jArr3, iArr3, j_renamed * i4);
    }

    private FixedSampleSizeRechunker() {
    }
}
