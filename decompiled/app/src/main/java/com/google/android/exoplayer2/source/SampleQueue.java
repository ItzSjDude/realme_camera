package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public class SampleQueue implements com.google.android.exoplayer2.extractor.TrackOutput {
    public static final int ADVANCE_FAILED = -1;
    private static final int INITIAL_SCRATCH_SIZE = 32;
    private final int allocationLength;
    private final com.google.android.exoplayer2.upstream.Allocator allocator;
    private com.google.android.exoplayer2.Format downstreamFormat;
    private com.google.android.exoplayer2.source.SampleQueue.AllocationNode firstAllocationNode;
    private com.google.android.exoplayer2.Format lastUnadjustedFormat;
    private boolean pendingFormatAdjustment;
    private boolean pendingSplice;
    private com.google.android.exoplayer2.source.SampleQueue.AllocationNode readAllocationNode;
    private long sampleOffsetUs;
    private long totalBytesWritten;
    private com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener upstreamFormatChangeListener;
    private com.google.android.exoplayer2.source.SampleQueue.AllocationNode writeAllocationNode;
    private final com.google.android.exoplayer2.source.SampleMetadataQueue metadataQueue = new com.google.android.exoplayer2.source.SampleMetadataQueue();
    private final com.google.android.exoplayer2.source.SampleMetadataQueue.SampleExtrasHolder extrasHolder = new com.google.android.exoplayer2.source.SampleMetadataQueue.SampleExtrasHolder();
    private final com.google.android.exoplayer2.util.ParsableByteArray scratch = new com.google.android.exoplayer2.util.ParsableByteArray(32);

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(com.google.android.exoplayer2.Format format);
    }

    public SampleQueue(com.google.android.exoplayer2.upstream.Allocator allocator) {
        this.allocator = allocator;
        this.allocationLength = allocator.getIndividualAllocationLength();
        this.firstAllocationNode = new com.google.android.exoplayer2.source.SampleQueue.AllocationNode(0L, this.allocationLength);
        com.google.android.exoplayer2.source.SampleQueue.AllocationNode allocationNode = this.firstAllocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z_renamed) {
        this.metadataQueue.reset(z_renamed);
        clearAllocationNodes(this.firstAllocationNode);
        this.firstAllocationNode = new com.google.android.exoplayer2.source.SampleQueue.AllocationNode(0L, this.allocationLength);
        com.google.android.exoplayer2.source.SampleQueue.AllocationNode allocationNode = this.firstAllocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
        this.totalBytesWritten = 0L;
        this.allocator.trim();
    }

    public void sourceId(int i_renamed) {
        this.metadataQueue.sourceId(i_renamed);
    }

    public void splice() {
        this.pendingSplice = true;
    }

    public int getWriteIndex() {
        return this.metadataQueue.getWriteIndex();
    }

    public long getNextKeyFramePositionUs(long j_renamed) {
        return this.metadataQueue.getNextKeyFramePositionUs(j_renamed);
    }

    public void discardUpstreamSamples(int i_renamed) {
        this.totalBytesWritten = this.metadataQueue.discardUpstreamSamples(i_renamed);
        long j_renamed = this.totalBytesWritten;
        if (j_renamed == 0 || j_renamed == this.firstAllocationNode.startPosition) {
            clearAllocationNodes(this.firstAllocationNode);
            this.firstAllocationNode = new com.google.android.exoplayer2.source.SampleQueue.AllocationNode(this.totalBytesWritten, this.allocationLength);
            com.google.android.exoplayer2.source.SampleQueue.AllocationNode allocationNode = this.firstAllocationNode;
            this.readAllocationNode = allocationNode;
            this.writeAllocationNode = allocationNode;
            return;
        }
        com.google.android.exoplayer2.source.SampleQueue.AllocationNode allocationNode2 = this.firstAllocationNode;
        while (this.totalBytesWritten > allocationNode2.endPosition) {
            allocationNode2 = allocationNode2.next;
        }
        com.google.android.exoplayer2.source.SampleQueue.AllocationNode allocationNode3 = allocationNode2.next;
        clearAllocationNodes(allocationNode3);
        allocationNode2.next = new com.google.android.exoplayer2.source.SampleQueue.AllocationNode(allocationNode2.endPosition, this.allocationLength);
        this.writeAllocationNode = this.totalBytesWritten == allocationNode2.endPosition ? allocationNode2.next : allocationNode2;
        if (this.readAllocationNode == allocationNode3) {
            this.readAllocationNode = allocationNode2.next;
        }
    }

    public boolean hasNextSample() {
        return this.metadataQueue.hasNextSample();
    }

    public int getFirstIndex() {
        return this.metadataQueue.getFirstIndex();
    }

    public int getReadIndex() {
        return this.metadataQueue.getReadIndex();
    }

    public int peekSourceId() {
        return this.metadataQueue.peekSourceId();
    }

    public com.google.android.exoplayer2.Format getUpstreamFormat() {
        return this.metadataQueue.getUpstreamFormat();
    }

    public long getLargestQueuedTimestampUs() {
        return this.metadataQueue.getLargestQueuedTimestampUs();
    }

    public boolean isLastSampleQueued() {
        return this.metadataQueue.isLastSampleQueued();
    }

    public long getFirstTimestampUs() {
        return this.metadataQueue.getFirstTimestampUs();
    }

    public void rewind() {
        this.metadataQueue.rewind();
        this.readAllocationNode = this.firstAllocationNode;
    }

    public void discardTo(long j_renamed, boolean z_renamed, boolean z2) {
        discardDownstreamTo(this.metadataQueue.discardTo(j_renamed, z_renamed, z2));
    }

    public void discardToRead() {
        discardDownstreamTo(this.metadataQueue.discardToRead());
    }

    public void discardToEnd() {
        discardDownstreamTo(this.metadataQueue.discardToEnd());
    }

    public int advanceToEnd() {
        return this.metadataQueue.advanceToEnd();
    }

    public int advanceTo(long j_renamed, boolean z_renamed, boolean z2) {
        return this.metadataQueue.advanceTo(j_renamed, z_renamed, z2);
    }

    public boolean setReadPosition(int i_renamed) {
        return this.metadataQueue.setReadPosition(i_renamed);
    }

    public int read(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z_renamed, boolean z2, long j_renamed) {
        int i_renamed = this.metadataQueue.read(formatHolder, decoderInputBuffer, z_renamed, z2, this.downstreamFormat, this.extrasHolder);
        if (i_renamed == -5) {
            this.downstreamFormat = formatHolder.format;
            return -5;
        }
        if (i_renamed != -4) {
            if (i_renamed == -3) {
                return -3;
            }
            throw new java.lang.IllegalStateException();
        }
        if (!decoderInputBuffer.isEndOfStream()) {
            if (decoderInputBuffer.timeUs < j_renamed) {
                decoderInputBuffer.addFlag(Integer.MIN_VALUE);
            }
            if (decoderInputBuffer.isEncrypted()) {
                readEncryptionData(decoderInputBuffer, this.extrasHolder);
            }
            decoderInputBuffer.ensureSpaceForWrite(this.extrasHolder.size);
            readData(this.extrasHolder.offset, decoderInputBuffer.data, this.extrasHolder.size);
        }
        return -4;
    }

    private void readEncryptionData(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, com.google.android.exoplayer2.source.SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder) {
        long j_renamed = sampleExtrasHolder.offset;
        int unsignedShort = 1;
        this.scratch.reset(1);
        readData(j_renamed, this.scratch.data, 1);
        long j2 = j_renamed + 1;
        byte b2 = this.scratch.data[0];
        boolean z_renamed = (b2 & 128) != 0;
        int i_renamed = b2 & 127;
        if (decoderInputBuffer.cryptoInfo.iv_renamed == null) {
            decoderInputBuffer.cryptoInfo.iv_renamed = new byte[16];
        }
        readData(j2, decoderInputBuffer.cryptoInfo.iv_renamed, i_renamed);
        long j3 = j2 + i_renamed;
        if (z_renamed) {
            this.scratch.reset(2);
            readData(j3, this.scratch.data, 2);
            j3 += 2;
            unsignedShort = this.scratch.readUnsignedShort();
        }
        int i2 = unsignedShort;
        int[] iArr = decoderInputBuffer.cryptoInfo.numBytesOfClearData;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = decoderInputBuffer.cryptoInfo.numBytesOfEncryptedData;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z_renamed) {
            int i3 = i2 * 6;
            this.scratch.reset(i3);
            readData(j3, this.scratch.data, i3);
            j3 += i3;
            this.scratch.setPosition(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = this.scratch.readUnsignedShort();
                iArr4[i4] = this.scratch.readUnsignedIntToInt();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder.size - ((int) (j3 - sampleExtrasHolder.offset));
        }
        com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData = sampleExtrasHolder.cryptoData;
        decoderInputBuffer.cryptoInfo.set(i2, iArr2, iArr4, cryptoData.encryptionKey, decoderInputBuffer.cryptoInfo.iv_renamed, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        int i5 = (int) (j3 - sampleExtrasHolder.offset);
        sampleExtrasHolder.offset += i5;
        sampleExtrasHolder.size -= i5;
    }

    private void readData(long j_renamed, java.nio.ByteBuffer byteBuffer, int i_renamed) {
        advanceReadTo(j_renamed);
        while (i_renamed > 0) {
            int iMin = java.lang.Math.min(i_renamed, (int) (this.readAllocationNode.endPosition - j_renamed));
            byteBuffer.put(this.readAllocationNode.allocation.data, this.readAllocationNode.translateOffset(j_renamed), iMin);
            i_renamed -= iMin;
            j_renamed += iMin;
            if (j_renamed == this.readAllocationNode.endPosition) {
                this.readAllocationNode = this.readAllocationNode.next;
            }
        }
    }

    private void readData(long j_renamed, byte[] bArr, int i_renamed) {
        advanceReadTo(j_renamed);
        long j2 = j_renamed;
        int i2 = i_renamed;
        while (i2 > 0) {
            int iMin = java.lang.Math.min(i2, (int) (this.readAllocationNode.endPosition - j2));
            java.lang.System.arraycopy(this.readAllocationNode.allocation.data, this.readAllocationNode.translateOffset(j2), bArr, i_renamed - i2, iMin);
            i2 -= iMin;
            j2 += iMin;
            if (j2 == this.readAllocationNode.endPosition) {
                this.readAllocationNode = this.readAllocationNode.next;
            }
        }
    }

    private void advanceReadTo(long j_renamed) {
        while (j_renamed >= this.readAllocationNode.endPosition) {
            this.readAllocationNode = this.readAllocationNode.next;
        }
    }

    private void discardDownstreamTo(long j_renamed) {
        if (j_renamed == -1) {
            return;
        }
        while (j_renamed >= this.firstAllocationNode.endPosition) {
            this.allocator.release(this.firstAllocationNode.allocation);
            this.firstAllocationNode = this.firstAllocationNode.clear();
        }
        if (this.readAllocationNode.startPosition < this.firstAllocationNode.startPosition) {
            this.readAllocationNode = this.firstAllocationNode;
        }
    }

    public void setUpstreamFormatChangeListener(com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public void setSampleOffsetUs(long j_renamed) {
        if (this.sampleOffsetUs != j_renamed) {
            this.sampleOffsetUs = j_renamed;
            this.pendingFormatAdjustment = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void format(com.google.android.exoplayer2.Format format) {
        com.google.android.exoplayer2.Format adjustedSampleFormat = getAdjustedSampleFormat(format, this.sampleOffsetUs);
        boolean z_renamed = this.metadataQueue.format(adjustedSampleFormat);
        this.lastUnadjustedFormat = format;
        this.pendingFormatAdjustment = false;
        com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener == null || !z_renamed) {
            return;
        }
        upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedSampleFormat);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int sampleData(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i_renamed, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        int i2 = extractorInput.read(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), preAppend(i_renamed));
        if (i2 != -1) {
            postAppend(i2);
            return i2;
        }
        if (z_renamed) {
            return -1;
        }
        throw new java.io.EOFException();
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
        while (i_renamed > 0) {
            int iPreAppend = preAppend(i_renamed);
            parsableByteArray.readBytes(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), iPreAppend);
            i_renamed -= iPreAppend;
            postAppend(iPreAppend);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j_renamed, int i_renamed, int i2, int i3, com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData) {
        if (this.pendingFormatAdjustment) {
            format(this.lastUnadjustedFormat);
        }
        long j2 = j_renamed + this.sampleOffsetUs;
        if (this.pendingSplice) {
            if ((i_renamed & 1) == 0 || !this.metadataQueue.attemptSplice(j2)) {
                return;
            } else {
                this.pendingSplice = false;
            }
        }
        this.metadataQueue.commitSample(j2, i_renamed, (this.totalBytesWritten - i2) - i3, i2, cryptoData);
    }

    private void clearAllocationNodes(com.google.android.exoplayer2.source.SampleQueue.AllocationNode allocationNode) {
        if (allocationNode.wasInitialized) {
            boolean z_renamed = this.writeAllocationNode.wasInitialized;
            com.google.android.exoplayer2.upstream.Allocation[] allocationArr = new com.google.android.exoplayer2.upstream.Allocation[(z_renamed ? 1 : 0) + (((int) (this.writeAllocationNode.startPosition - allocationNode.startPosition)) / this.allocationLength)];
            for (int i_renamed = 0; i_renamed < allocationArr.length; i_renamed++) {
                allocationArr[i_renamed] = allocationNode.allocation;
                allocationNode = allocationNode.clear();
            }
            this.allocator.release(allocationArr);
        }
    }

    private int preAppend(int i_renamed) {
        if (!this.writeAllocationNode.wasInitialized) {
            this.writeAllocationNode.initialize(this.allocator.allocate(), new com.google.android.exoplayer2.source.SampleQueue.AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return java.lang.Math.min(i_renamed, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
    }

    private void postAppend(int i_renamed) {
        this.totalBytesWritten += i_renamed;
        if (this.totalBytesWritten == this.writeAllocationNode.endPosition) {
            this.writeAllocationNode = this.writeAllocationNode.next;
        }
    }

    private static com.google.android.exoplayer2.Format getAdjustedSampleFormat(com.google.android.exoplayer2.Format format, long j_renamed) {
        if (format == null) {
            return null;
        }
        return (j_renamed == 0 || format.subsampleOffsetUs == Long.MAX_VALUE) ? format : format.copyWithSubsampleOffsetUs(format.subsampleOffsetUs + j_renamed);
    }

    private static final class AllocationNode {
        public com.google.android.exoplayer2.upstream.Allocation allocation;
        public final long endPosition;
        public com.google.android.exoplayer2.source.SampleQueue.AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long j_renamed, int i_renamed) {
            this.startPosition = j_renamed;
            this.endPosition = j_renamed + i_renamed;
        }

        public void initialize(com.google.android.exoplayer2.upstream.Allocation allocation, com.google.android.exoplayer2.source.SampleQueue.AllocationNode allocationNode) {
            this.allocation = allocation;
            this.next = allocationNode;
            this.wasInitialized = true;
        }

        public int translateOffset(long j_renamed) {
            return ((int) (j_renamed - this.startPosition)) + this.allocation.offset;
        }

        public com.google.android.exoplayer2.source.SampleQueue.AllocationNode clear() {
            this.allocation = null;
            com.google.android.exoplayer2.source.SampleQueue.AllocationNode allocationNode = this.next;
            this.next = null;
            return allocationNode;
        }
    }
}
