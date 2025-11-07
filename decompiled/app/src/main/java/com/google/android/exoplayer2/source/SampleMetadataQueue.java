package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
final class SampleMetadataQueue {
    private static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    private static java.lang.String TAG = "SampleMetadataQueue";
    private int absoluteFirstIndex;
    private int capacity = 1000;
    private com.google.android.exoplayer2.extractor.TrackOutput.CryptoData[] cryptoDatas;
    private int[] flags;
    private com.google.android.exoplayer2.Format[] formats;
    private boolean isLastSampleQueued;
    private long largestDiscardedTimestampUs;
    private long largestQueuedTimestampUs;
    private int length;
    private long[] offsets;
    private int readPosition;
    private int relativeFirstIndex;
    private int[] sizes;
    private int[] sourceIds;
    private long[] timesUs;
    private com.google.android.exoplayer2.Format upstreamFormat;
    private boolean upstreamFormatRequired;
    private boolean upstreamKeyframeRequired;
    private int upstreamSourceId;

    public static final class SampleExtrasHolder {
        public com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;
    }

    public SampleMetadataQueue() {
        int i_renamed = this.capacity;
        this.sourceIds = new int[i_renamed];
        this.offsets = new long[i_renamed];
        this.timesUs = new long[i_renamed];
        this.flags = new int[i_renamed];
        this.sizes = new int[i_renamed];
        this.cryptoDatas = new com.google.android.exoplayer2.extractor.TrackOutput.CryptoData[i_renamed];
        this.formats = new com.google.android.exoplayer2.Format[i_renamed];
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        this.upstreamFormatRequired = true;
        this.upstreamKeyframeRequired = true;
    }

    public void reset(boolean z_renamed) {
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.upstreamKeyframeRequired = true;
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        this.isLastSampleQueued = false;
        if (z_renamed) {
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
        }
    }

    public int getWriteIndex() {
        return this.absoluteFirstIndex + this.length;
    }

    public long discardUpstreamSamples(int i_renamed) {
        int writeIndex = getWriteIndex() - i_renamed;
        boolean z_renamed = false;
        com.google.android.exoplayer2.util.Assertions.checkArgument(writeIndex >= 0 && writeIndex <= this.length - this.readPosition);
        this.length -= writeIndex;
        this.largestQueuedTimestampUs = java.lang.Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.length));
        if (writeIndex == 0 && this.isLastSampleQueued) {
            z_renamed = true;
        }
        this.isLastSampleQueued = z_renamed;
        int i2 = this.length;
        if (i2 == 0) {
            return 0L;
        }
        return this.offsets[getRelativeIndex(i2 - 1)] + this.sizes[r7];
    }

    public void sourceId(int i_renamed) {
        this.upstreamSourceId = i_renamed;
    }

    public int getFirstIndex() {
        return this.absoluteFirstIndex;
    }

    public int getReadIndex() {
        return this.absoluteFirstIndex + this.readPosition;
    }

    public int peekSourceId() {
        return hasNextSample() ? this.sourceIds[getRelativeIndex(this.readPosition)] : this.upstreamSourceId;
    }

    public synchronized boolean hasNextSample() {
        return this.readPosition != this.length;
    }

    public synchronized com.google.android.exoplayer2.Format getUpstreamFormat() {
        return this.upstreamFormatRequired ? null : this.upstreamFormat;
    }

    public synchronized long getLargestQueuedTimestampUs() {
        return this.largestQueuedTimestampUs;
    }

    public synchronized boolean isLastSampleQueued() {
        return this.isLastSampleQueued;
    }

    public synchronized long getFirstTimestampUs() {
        return this.length == 0 ? Long.MIN_VALUE : this.timesUs[this.relativeFirstIndex];
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long getNextKeyFramePositionUs(long r11) {
        /*
            r10 = this;
            java.lang.String r0 = com.google.android.exoplayer2.source.SampleMetadataQueue.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "pos:"
            r1.append(r2)
            r1.append(r11)
            java.lang.String r2 = ",largestQueuedTimestampUs:"
            r1.append(r2)
            long r2 = r10.largestQueuedTimestampUs
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.google.android.exoplayer2.util.Log.d_renamed(r0, r1)
            long r0 = r10.largestQueuedTimestampUs
            int r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3 = -1
            if (r0 < 0) goto L34
            boolean r10 = r10.isLastSampleQueued
            if (r10 == 0) goto L32
            goto L33
        L32:
            r1 = r3
        L33:
            return r1
        L34:
            int r0 = r10.length
            if (r0 != 0) goto L39
            return r3
        L39:
            int r0 = r10.relativeFirstIndex
            r5 = 0
            r6 = r0
            r0 = r5
        L3e:
            int r7 = r10.length
            if (r0 >= r7) goto L6f
            long[] r7 = r10.timesUs
            r8 = r7[r6]
            int r8 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r8 >= 0) goto L52
            int r6 = r6 + 1
            int r7 = r10.capacity
            if (r6 != r7) goto L6c
        L50:
            r6 = r5
            goto L6c
        L52:
            int[] r8 = r10.flags
            r9 = r8[r6]
            r9 = r9 & 1
            if (r9 == 0) goto L5d
            r1 = r7[r6]
            goto L70
        L5d:
            r7 = r8[r6]
            r8 = 536870912(0x20000000, float:1.0842022E-19)
            r7 = r7 & r8
            if (r7 == 0) goto L65
            goto L70
        L65:
            int r6 = r6 + 1
            int r7 = r10.capacity
            if (r6 != r7) goto L6c
            goto L50
        L6c:
            int r0 = r0 + 1
            goto L3e
        L6f:
            r1 = r3
        L70:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleMetadataQueue.getNextKeyFramePositionUs(long):long");
    }

    public synchronized void rewind() {
        this.readPosition = 0;
    }

    public synchronized int read(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z_renamed, boolean z2, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.source.SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder) {
        if (!hasNextSample()) {
            if (!z2 && !this.isLastSampleQueued) {
                if (this.upstreamFormat == null || (!z_renamed && this.upstreamFormat == format)) {
                    return -3;
                }
                formatHolder.format = this.upstreamFormat;
                return -5;
            }
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (!z_renamed && this.formats[relativeIndex] == format) {
            if (decoderInputBuffer.isFlagsOnly()) {
                return -3;
            }
            decoderInputBuffer.timeUs = this.timesUs[relativeIndex];
            decoderInputBuffer.setFlags(this.flags[relativeIndex]);
            sampleExtrasHolder.size = this.sizes[relativeIndex];
            sampleExtrasHolder.offset = this.offsets[relativeIndex];
            sampleExtrasHolder.cryptoData = this.cryptoDatas[relativeIndex];
            this.readPosition++;
            return -4;
        }
        formatHolder.format = this.formats[relativeIndex];
        return -5;
    }

    public synchronized int advanceTo(long j_renamed, boolean z_renamed, boolean z2) {
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample() && j_renamed >= this.timesUs[relativeIndex] && (j_renamed <= this.largestQueuedTimestampUs || z2)) {
            int iFindSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, j_renamed, z_renamed);
            if (iFindSampleBefore == -1) {
                return -1;
            }
            this.readPosition += iFindSampleBefore;
            return iFindSampleBefore;
        }
        return -1;
    }

    public synchronized int advanceToEnd() {
        int i_renamed;
        i_renamed = this.length - this.readPosition;
        this.readPosition = this.length;
        return i_renamed;
    }

    public synchronized boolean setReadPosition(int i_renamed) {
        if (this.absoluteFirstIndex > i_renamed || i_renamed > this.absoluteFirstIndex + this.length) {
            return false;
        }
        this.readPosition = i_renamed - this.absoluteFirstIndex;
        return true;
    }

    public synchronized long discardTo(long j_renamed, boolean z_renamed, boolean z2) {
        if (this.length != 0 && j_renamed >= this.timesUs[this.relativeFirstIndex]) {
            int iFindSampleBefore = findSampleBefore(this.relativeFirstIndex, (!z2 || this.readPosition == this.length) ? this.length : this.readPosition + 1, j_renamed, z_renamed);
            if (iFindSampleBefore == -1) {
                return -1L;
            }
            return discardSamples(iFindSampleBefore);
        }
        return -1L;
    }

    public synchronized long discardToRead() {
        if (this.readPosition == 0) {
            return -1L;
        }
        return discardSamples(this.readPosition);
    }

    public synchronized long discardToEnd() {
        if (this.length == 0) {
            return -1L;
        }
        return discardSamples(this.length);
    }

    public synchronized boolean format(com.google.android.exoplayer2.Format format) {
        if (format == null) {
            this.upstreamFormatRequired = true;
            return false;
        }
        this.upstreamFormatRequired = false;
        if (com.google.android.exoplayer2.util.Util.areEqual(format, this.upstreamFormat)) {
            return false;
        }
        this.upstreamFormat = format;
        return true;
    }

    public synchronized void commitSample(long j_renamed, int i_renamed, long j2, int i2, com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData) {
        if (this.upstreamKeyframeRequired) {
            if ((i_renamed & 1) == 0) {
                return;
            } else {
                this.upstreamKeyframeRequired = false;
            }
        }
        com.google.android.exoplayer2.util.Assertions.checkState(!this.upstreamFormatRequired);
        this.isLastSampleQueued = (536870912 & i_renamed) != 0;
        this.largestQueuedTimestampUs = java.lang.Math.max(this.largestQueuedTimestampUs, j_renamed);
        int relativeIndex = getRelativeIndex(this.length);
        this.timesUs[relativeIndex] = j_renamed;
        this.offsets[relativeIndex] = j2;
        this.sizes[relativeIndex] = i2;
        this.flags[relativeIndex] = i_renamed;
        this.cryptoDatas[relativeIndex] = cryptoData;
        this.formats[relativeIndex] = this.upstreamFormat;
        this.sourceIds[relativeIndex] = this.upstreamSourceId;
        this.length++;
        if (this.length == this.capacity) {
            int i3 = this.capacity + 1000;
            int[] iArr = new int[i3];
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            com.google.android.exoplayer2.extractor.TrackOutput.CryptoData[] cryptoDataArr = new com.google.android.exoplayer2.extractor.TrackOutput.CryptoData[i3];
            com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[i3];
            int i4 = this.capacity - this.relativeFirstIndex;
            java.lang.System.arraycopy(this.offsets, this.relativeFirstIndex, jArr, 0, i4);
            java.lang.System.arraycopy(this.timesUs, this.relativeFirstIndex, jArr2, 0, i4);
            java.lang.System.arraycopy(this.flags, this.relativeFirstIndex, iArr2, 0, i4);
            java.lang.System.arraycopy(this.sizes, this.relativeFirstIndex, iArr3, 0, i4);
            java.lang.System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, cryptoDataArr, 0, i4);
            java.lang.System.arraycopy(this.formats, this.relativeFirstIndex, formatArr, 0, i4);
            java.lang.System.arraycopy(this.sourceIds, this.relativeFirstIndex, iArr, 0, i4);
            int i5 = this.relativeFirstIndex;
            java.lang.System.arraycopy(this.offsets, 0, jArr, i4, i5);
            java.lang.System.arraycopy(this.timesUs, 0, jArr2, i4, i5);
            java.lang.System.arraycopy(this.flags, 0, iArr2, i4, i5);
            java.lang.System.arraycopy(this.sizes, 0, iArr3, i4, i5);
            java.lang.System.arraycopy(this.cryptoDatas, 0, cryptoDataArr, i4, i5);
            java.lang.System.arraycopy(this.formats, 0, formatArr, i4, i5);
            java.lang.System.arraycopy(this.sourceIds, 0, iArr, i4, i5);
            this.offsets = jArr;
            this.timesUs = jArr2;
            this.flags = iArr2;
            this.sizes = iArr3;
            this.cryptoDatas = cryptoDataArr;
            this.formats = formatArr;
            this.sourceIds = iArr;
            this.relativeFirstIndex = 0;
            this.length = this.capacity;
            this.capacity = i3;
        }
    }

    public synchronized boolean attemptSplice(long j_renamed) {
        if (this.length == 0) {
            return j_renamed > this.largestDiscardedTimestampUs;
        }
        if (java.lang.Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.readPosition)) >= j_renamed) {
            return false;
        }
        int i_renamed = this.length;
        int relativeIndex = getRelativeIndex(this.length - 1);
        while (i_renamed > this.readPosition && this.timesUs[relativeIndex] >= j_renamed) {
            i_renamed--;
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        discardUpstreamSamples(this.absoluteFirstIndex + i_renamed);
        return true;
    }

    private int findSampleBefore(int i_renamed, int i2, long j_renamed, boolean z_renamed) {
        int i3 = -1;
        int i4 = i_renamed;
        for (int i5 = 0; i5 < i2 && this.timesUs[i4] <= j_renamed; i5++) {
            if (!z_renamed || (this.flags[i4] & 1) != 0) {
                i3 = i5;
            }
            i4++;
            if (i4 == this.capacity) {
                i4 = 0;
            }
        }
        return i3;
    }

    private long discardSamples(int i_renamed) {
        this.largestDiscardedTimestampUs = java.lang.Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i_renamed));
        this.length -= i_renamed;
        this.absoluteFirstIndex += i_renamed;
        this.relativeFirstIndex += i_renamed;
        int i2 = this.relativeFirstIndex;
        int i3 = this.capacity;
        if (i2 >= i3) {
            this.relativeFirstIndex = i2 - i3;
        }
        this.readPosition -= i_renamed;
        if (this.readPosition < 0) {
            this.readPosition = 0;
        }
        if (this.length == 0) {
            int i4 = this.relativeFirstIndex;
            if (i4 == 0) {
                i4 = this.capacity;
            }
            return this.offsets[i4 - 1] + this.sizes[r5];
        }
        return this.offsets[this.relativeFirstIndex];
    }

    private long getLargestTimestamp(int i_renamed) {
        long jMax = Long.MIN_VALUE;
        if (i_renamed == 0) {
            return Long.MIN_VALUE;
        }
        int relativeIndex = getRelativeIndex(i_renamed - 1);
        for (int i2 = 0; i2 < i_renamed; i2++) {
            jMax = java.lang.Math.max(jMax, this.timesUs[relativeIndex]);
            if ((this.flags[relativeIndex] & 1) != 0) {
                break;
            }
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return jMax;
    }

    private int getRelativeIndex(int i_renamed) {
        int i2 = this.relativeFirstIndex + i_renamed;
        int i3 = this.capacity;
        return i2 < i3 ? i2 : i2 - i3;
    }
}
