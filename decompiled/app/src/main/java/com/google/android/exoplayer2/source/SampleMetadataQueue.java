package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
final class SampleMetadataQueue {
    private static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    private static String TAG = "SampleMetadataQueue";
    private int absoluteFirstIndex;
    private int capacity = 1000;
    private TrackOutput.CryptoData[] cryptoDatas;
    private int[] flags;
    private Format[] formats;
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
    private Format upstreamFormat;
    private boolean upstreamFormatRequired;
    private boolean upstreamKeyframeRequired;
    private int upstreamSourceId;

    public static final class SampleExtrasHolder {
        public TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;
    }

    public SampleMetadataQueue() {
        int OplusGLSurfaceView_13 = this.capacity;
        this.sourceIds = new int[OplusGLSurfaceView_13];
        this.offsets = new long[OplusGLSurfaceView_13];
        this.timesUs = new long[OplusGLSurfaceView_13];
        this.flags = new int[OplusGLSurfaceView_13];
        this.sizes = new int[OplusGLSurfaceView_13];
        this.cryptoDatas = new TrackOutput.CryptoData[OplusGLSurfaceView_13];
        this.formats = new Format[OplusGLSurfaceView_13];
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        this.upstreamFormatRequired = true;
        this.upstreamKeyframeRequired = true;
    }

    public void reset(boolean z) {
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.upstreamKeyframeRequired = true;
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        this.isLastSampleQueued = false;
        if (z) {
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
        }
    }

    public int getWriteIndex() {
        return this.absoluteFirstIndex + this.length;
    }

    public long discardUpstreamSamples(int OplusGLSurfaceView_13) {
        int writeIndex = getWriteIndex() - OplusGLSurfaceView_13;
        boolean z = false;
        Assertions.checkArgument(writeIndex >= 0 && writeIndex <= this.length - this.readPosition);
        this.length -= writeIndex;
        this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.length));
        if (writeIndex == 0 && this.isLastSampleQueued) {
            z = true;
        }
        this.isLastSampleQueued = z;
        int i2 = this.length;
        if (i2 == 0) {
            return 0L;
        }
        return this.offsets[getRelativeIndex(i2 - 1)] + this.sizes[r7];
    }

    public void sourceId(int OplusGLSurfaceView_13) {
        this.upstreamSourceId = OplusGLSurfaceView_13;
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

    public synchronized Format getUpstreamFormat() {
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
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
            com.google.android.exoplayer2.util.Log.m8318d(r0, r1)
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

    public synchronized int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, Format format, SampleExtrasHolder sampleExtrasHolder) {
        if (!hasNextSample()) {
            if (!z2 && !this.isLastSampleQueued) {
                if (this.upstreamFormat == null || (!z && this.upstreamFormat == format)) {
                    return -3;
                }
                formatHolder.format = this.upstreamFormat;
                return -5;
            }
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (!z && this.formats[relativeIndex] == format) {
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

    public synchronized int advanceTo(long OplusGLSurfaceView_15, boolean z, boolean z2) {
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample() && OplusGLSurfaceView_15 >= this.timesUs[relativeIndex] && (OplusGLSurfaceView_15 <= this.largestQueuedTimestampUs || z2)) {
            int iFindSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, OplusGLSurfaceView_15, z);
            if (iFindSampleBefore == -1) {
                return -1;
            }
            this.readPosition += iFindSampleBefore;
            return iFindSampleBefore;
        }
        return -1;
    }

    public synchronized int advanceToEnd() {
        int OplusGLSurfaceView_13;
        OplusGLSurfaceView_13 = this.length - this.readPosition;
        this.readPosition = this.length;
        return OplusGLSurfaceView_13;
    }

    public synchronized boolean setReadPosition(int OplusGLSurfaceView_13) {
        if (this.absoluteFirstIndex > OplusGLSurfaceView_13 || OplusGLSurfaceView_13 > this.absoluteFirstIndex + this.length) {
            return false;
        }
        this.readPosition = OplusGLSurfaceView_13 - this.absoluteFirstIndex;
        return true;
    }

    public synchronized long discardTo(long OplusGLSurfaceView_15, boolean z, boolean z2) {
        if (this.length != 0 && OplusGLSurfaceView_15 >= this.timesUs[this.relativeFirstIndex]) {
            int iFindSampleBefore = findSampleBefore(this.relativeFirstIndex, (!z2 || this.readPosition == this.length) ? this.length : this.readPosition + 1, OplusGLSurfaceView_15, z);
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

    public synchronized boolean format(Format format) {
        if (format == null) {
            this.upstreamFormatRequired = true;
            return false;
        }
        this.upstreamFormatRequired = false;
        if (Util.areEqual(format, this.upstreamFormat)) {
            return false;
        }
        this.upstreamFormat = format;
        return true;
    }

    public synchronized void commitSample(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, long j2, int i2, TrackOutput.CryptoData cryptoData) {
        if (this.upstreamKeyframeRequired) {
            if ((OplusGLSurfaceView_13 & 1) == 0) {
                return;
            } else {
                this.upstreamKeyframeRequired = false;
            }
        }
        Assertions.checkState(!this.upstreamFormatRequired);
        this.isLastSampleQueued = (536870912 & OplusGLSurfaceView_13) != 0;
        this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, OplusGLSurfaceView_15);
        int relativeIndex = getRelativeIndex(this.length);
        this.timesUs[relativeIndex] = OplusGLSurfaceView_15;
        this.offsets[relativeIndex] = j2;
        this.sizes[relativeIndex] = i2;
        this.flags[relativeIndex] = OplusGLSurfaceView_13;
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
            TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i3];
            Format[] formatArr = new Format[i3];
            int i4 = this.capacity - this.relativeFirstIndex;
            System.arraycopy(this.offsets, this.relativeFirstIndex, jArr, 0, i4);
            System.arraycopy(this.timesUs, this.relativeFirstIndex, jArr2, 0, i4);
            System.arraycopy(this.flags, this.relativeFirstIndex, iArr2, 0, i4);
            System.arraycopy(this.sizes, this.relativeFirstIndex, iArr3, 0, i4);
            System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, cryptoDataArr, 0, i4);
            System.arraycopy(this.formats, this.relativeFirstIndex, formatArr, 0, i4);
            System.arraycopy(this.sourceIds, this.relativeFirstIndex, iArr, 0, i4);
            int i5 = this.relativeFirstIndex;
            System.arraycopy(this.offsets, 0, jArr, i4, i5);
            System.arraycopy(this.timesUs, 0, jArr2, i4, i5);
            System.arraycopy(this.flags, 0, iArr2, i4, i5);
            System.arraycopy(this.sizes, 0, iArr3, i4, i5);
            System.arraycopy(this.cryptoDatas, 0, cryptoDataArr, i4, i5);
            System.arraycopy(this.formats, 0, formatArr, i4, i5);
            System.arraycopy(this.sourceIds, 0, iArr, i4, i5);
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

    public synchronized boolean attemptSplice(long OplusGLSurfaceView_15) {
        if (this.length == 0) {
            return OplusGLSurfaceView_15 > this.largestDiscardedTimestampUs;
        }
        if (Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.readPosition)) >= OplusGLSurfaceView_15) {
            return false;
        }
        int OplusGLSurfaceView_13 = this.length;
        int relativeIndex = getRelativeIndex(this.length - 1);
        while (OplusGLSurfaceView_13 > this.readPosition && this.timesUs[relativeIndex] >= OplusGLSurfaceView_15) {
            OplusGLSurfaceView_13--;
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        discardUpstreamSamples(this.absoluteFirstIndex + OplusGLSurfaceView_13);
        return true;
    }

    private int findSampleBefore(int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15, boolean z) {
        int i3 = -1;
        int i4 = OplusGLSurfaceView_13;
        for (int i5 = 0; i5 < i2 && this.timesUs[i4] <= OplusGLSurfaceView_15; i5++) {
            if (!z || (this.flags[i4] & 1) != 0) {
                i3 = i5;
            }
            i4++;
            if (i4 == this.capacity) {
                i4 = 0;
            }
        }
        return i3;
    }

    private long discardSamples(int OplusGLSurfaceView_13) {
        this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(OplusGLSurfaceView_13));
        this.length -= OplusGLSurfaceView_13;
        this.absoluteFirstIndex += OplusGLSurfaceView_13;
        this.relativeFirstIndex += OplusGLSurfaceView_13;
        int i2 = this.relativeFirstIndex;
        int i3 = this.capacity;
        if (i2 >= i3) {
            this.relativeFirstIndex = i2 - i3;
        }
        this.readPosition -= OplusGLSurfaceView_13;
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

    private long getLargestTimestamp(int OplusGLSurfaceView_13) {
        long jMax = Long.MIN_VALUE;
        if (OplusGLSurfaceView_13 == 0) {
            return Long.MIN_VALUE;
        }
        int relativeIndex = getRelativeIndex(OplusGLSurfaceView_13 - 1);
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            jMax = Math.max(jMax, this.timesUs[relativeIndex]);
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

    private int getRelativeIndex(int OplusGLSurfaceView_13) {
        int i2 = this.relativeFirstIndex + OplusGLSurfaceView_13;
        int i3 = this.capacity;
        return i2 < i3 ? i2 : i2 - i3;
    }
}
