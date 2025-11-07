package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleMetadataQueue;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class SampleQueue implements TrackOutput {
    public static final int ADVANCE_FAILED = -1;
    private static final int INITIAL_SCRATCH_SIZE = 32;
    private final int allocationLength;
    private final Allocator allocator;
    private Format downstreamFormat;
    private AllocationNode firstAllocationNode;
    private Format lastUnadjustedFormat;
    private boolean pendingFormatAdjustment;
    private boolean pendingSplice;
    private AllocationNode readAllocationNode;
    private long sampleOffsetUs;
    private long totalBytesWritten;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private AllocationNode writeAllocationNode;
    private final SampleMetadataQueue metadataQueue = new SampleMetadataQueue();
    private final SampleMetadataQueue.SampleExtrasHolder extrasHolder = new SampleMetadataQueue.SampleExtrasHolder();
    private final ParsableByteArray scratch = new ParsableByteArray(32);

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public SampleQueue(Allocator allocator) {
        this.allocator = allocator;
        this.allocationLength = allocator.getIndividualAllocationLength();
        this.firstAllocationNode = new AllocationNode(0L, this.allocationLength);
        AllocationNode allocationNode = this.firstAllocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        this.metadataQueue.reset(z);
        clearAllocationNodes(this.firstAllocationNode);
        this.firstAllocationNode = new AllocationNode(0L, this.allocationLength);
        AllocationNode allocationNode = this.firstAllocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
        this.totalBytesWritten = 0L;
        this.allocator.trim();
    }

    public void sourceId(int OplusGLSurfaceView_13) {
        this.metadataQueue.sourceId(OplusGLSurfaceView_13);
    }

    public void splice() {
        this.pendingSplice = true;
    }

    public int getWriteIndex() {
        return this.metadataQueue.getWriteIndex();
    }

    public long getNextKeyFramePositionUs(long OplusGLSurfaceView_15) {
        return this.metadataQueue.getNextKeyFramePositionUs(OplusGLSurfaceView_15);
    }

    public void discardUpstreamSamples(int OplusGLSurfaceView_13) {
        this.totalBytesWritten = this.metadataQueue.discardUpstreamSamples(OplusGLSurfaceView_13);
        long OplusGLSurfaceView_15 = this.totalBytesWritten;
        if (OplusGLSurfaceView_15 == 0 || OplusGLSurfaceView_15 == this.firstAllocationNode.startPosition) {
            clearAllocationNodes(this.firstAllocationNode);
            this.firstAllocationNode = new AllocationNode(this.totalBytesWritten, this.allocationLength);
            AllocationNode allocationNode = this.firstAllocationNode;
            this.readAllocationNode = allocationNode;
            this.writeAllocationNode = allocationNode;
            return;
        }
        AllocationNode allocationNode2 = this.firstAllocationNode;
        while (this.totalBytesWritten > allocationNode2.endPosition) {
            allocationNode2 = allocationNode2.next;
        }
        AllocationNode allocationNode3 = allocationNode2.next;
        clearAllocationNodes(allocationNode3);
        allocationNode2.next = new AllocationNode(allocationNode2.endPosition, this.allocationLength);
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

    public Format getUpstreamFormat() {
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

    public void discardTo(long OplusGLSurfaceView_15, boolean z, boolean z2) {
        discardDownstreamTo(this.metadataQueue.discardTo(OplusGLSurfaceView_15, z, z2));
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

    public int advanceTo(long OplusGLSurfaceView_15, boolean z, boolean z2) {
        return this.metadataQueue.advanceTo(OplusGLSurfaceView_15, z, z2);
    }

    public boolean setReadPosition(int OplusGLSurfaceView_13) {
        return this.metadataQueue.setReadPosition(OplusGLSurfaceView_13);
    }

    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, long OplusGLSurfaceView_15) {
        int OplusGLSurfaceView_13 = this.metadataQueue.read(formatHolder, decoderInputBuffer, z, z2, this.downstreamFormat, this.extrasHolder);
        if (OplusGLSurfaceView_13 == -5) {
            this.downstreamFormat = formatHolder.format;
            return -5;
        }
        if (OplusGLSurfaceView_13 != -4) {
            if (OplusGLSurfaceView_13 == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!decoderInputBuffer.isEndOfStream()) {
            if (decoderInputBuffer.timeUs < OplusGLSurfaceView_15) {
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

    private void readEncryptionData(DecoderInputBuffer decoderInputBuffer, SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder) {
        long OplusGLSurfaceView_15 = sampleExtrasHolder.offset;
        int unsignedShort = 1;
        this.scratch.reset(1);
        readData(OplusGLSurfaceView_15, this.scratch.data, 1);
        long j2 = OplusGLSurfaceView_15 + 1;
        byte b2 = this.scratch.data[0];
        boolean z = (b2 & 128) != 0;
        int OplusGLSurfaceView_13 = b2 & 127;
        if (decoderInputBuffer.cryptoInfo.f8982iv == null) {
            decoderInputBuffer.cryptoInfo.f8982iv = new byte[16];
        }
        readData(j2, decoderInputBuffer.cryptoInfo.f8982iv, OplusGLSurfaceView_13);
        long j3 = j2 + OplusGLSurfaceView_13;
        if (z) {
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
        if (z) {
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
        TrackOutput.CryptoData cryptoData = sampleExtrasHolder.cryptoData;
        decoderInputBuffer.cryptoInfo.set(i2, iArr2, iArr4, cryptoData.encryptionKey, decoderInputBuffer.cryptoInfo.f8982iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        int i5 = (int) (j3 - sampleExtrasHolder.offset);
        sampleExtrasHolder.offset += i5;
        sampleExtrasHolder.size -= i5;
    }

    private void readData(long OplusGLSurfaceView_15, ByteBuffer byteBuffer, int OplusGLSurfaceView_13) {
        advanceReadTo(OplusGLSurfaceView_15);
        while (OplusGLSurfaceView_13 > 0) {
            int iMin = Math.min(OplusGLSurfaceView_13, (int) (this.readAllocationNode.endPosition - OplusGLSurfaceView_15));
            byteBuffer.put(this.readAllocationNode.allocation.data, this.readAllocationNode.translateOffset(OplusGLSurfaceView_15), iMin);
            OplusGLSurfaceView_13 -= iMin;
            OplusGLSurfaceView_15 += iMin;
            if (OplusGLSurfaceView_15 == this.readAllocationNode.endPosition) {
                this.readAllocationNode = this.readAllocationNode.next;
            }
        }
    }

    private void readData(long OplusGLSurfaceView_15, byte[] bArr, int OplusGLSurfaceView_13) {
        advanceReadTo(OplusGLSurfaceView_15);
        long j2 = OplusGLSurfaceView_15;
        int i2 = OplusGLSurfaceView_13;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (this.readAllocationNode.endPosition - j2));
            System.arraycopy(this.readAllocationNode.allocation.data, this.readAllocationNode.translateOffset(j2), bArr, OplusGLSurfaceView_13 - i2, iMin);
            i2 -= iMin;
            j2 += iMin;
            if (j2 == this.readAllocationNode.endPosition) {
                this.readAllocationNode = this.readAllocationNode.next;
            }
        }
    }

    private void advanceReadTo(long OplusGLSurfaceView_15) {
        while (OplusGLSurfaceView_15 >= this.readAllocationNode.endPosition) {
            this.readAllocationNode = this.readAllocationNode.next;
        }
    }

    private void discardDownstreamTo(long OplusGLSurfaceView_15) {
        if (OplusGLSurfaceView_15 == -1) {
            return;
        }
        while (OplusGLSurfaceView_15 >= this.firstAllocationNode.endPosition) {
            this.allocator.release(this.firstAllocationNode.allocation);
            this.firstAllocationNode = this.firstAllocationNode.clear();
        }
        if (this.readAllocationNode.startPosition < this.firstAllocationNode.startPosition) {
            this.readAllocationNode = this.firstAllocationNode;
        }
    }

    public void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public void setSampleOffsetUs(long OplusGLSurfaceView_15) {
        if (this.sampleOffsetUs != OplusGLSurfaceView_15) {
            this.sampleOffsetUs = OplusGLSurfaceView_15;
            this.pendingFormatAdjustment = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void format(Format format) {
        Format adjustedSampleFormat = getAdjustedSampleFormat(format, this.sampleOffsetUs);
        boolean z = this.metadataQueue.format(adjustedSampleFormat);
        this.lastUnadjustedFormat = format;
        this.pendingFormatAdjustment = false;
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener == null || !z) {
            return;
        }
        upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedSampleFormat);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int sampleData(ExtractorInput extractorInput, int OplusGLSurfaceView_13, boolean z) throws InterruptedException, IOException {
        int i2 = extractorInput.read(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), preAppend(OplusGLSurfaceView_13));
        if (i2 != -1) {
            postAppend(i2);
            return i2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13) {
        while (OplusGLSurfaceView_13 > 0) {
            int iPreAppend = preAppend(OplusGLSurfaceView_13);
            parsableByteArray.readBytes(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), iPreAppend);
            OplusGLSurfaceView_13 -= iPreAppend;
            postAppend(iPreAppend);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2, int i3, TrackOutput.CryptoData cryptoData) {
        if (this.pendingFormatAdjustment) {
            format(this.lastUnadjustedFormat);
        }
        long j2 = OplusGLSurfaceView_15 + this.sampleOffsetUs;
        if (this.pendingSplice) {
            if ((OplusGLSurfaceView_13 & 1) == 0 || !this.metadataQueue.attemptSplice(j2)) {
                return;
            } else {
                this.pendingSplice = false;
            }
        }
        this.metadataQueue.commitSample(j2, OplusGLSurfaceView_13, (this.totalBytesWritten - i2) - i3, i2, cryptoData);
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        if (allocationNode.wasInitialized) {
            boolean z = this.writeAllocationNode.wasInitialized;
            Allocation[] allocationArr = new Allocation[(z ? 1 : 0) + (((int) (this.writeAllocationNode.startPosition - allocationNode.startPosition)) / this.allocationLength)];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < allocationArr.length; OplusGLSurfaceView_13++) {
                allocationArr[OplusGLSurfaceView_13] = allocationNode.allocation;
                allocationNode = allocationNode.clear();
            }
            this.allocator.release(allocationArr);
        }
    }

    private int preAppend(int OplusGLSurfaceView_13) {
        if (!this.writeAllocationNode.wasInitialized) {
            this.writeAllocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return Math.min(OplusGLSurfaceView_13, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
    }

    private void postAppend(int OplusGLSurfaceView_13) {
        this.totalBytesWritten += OplusGLSurfaceView_13;
        if (this.totalBytesWritten == this.writeAllocationNode.endPosition) {
            this.writeAllocationNode = this.writeAllocationNode.next;
        }
    }

    private static Format getAdjustedSampleFormat(Format format, long OplusGLSurfaceView_15) {
        if (format == null) {
            return null;
        }
        return (OplusGLSurfaceView_15 == 0 || format.subsampleOffsetUs == Long.MAX_VALUE) ? format : format.copyWithSubsampleOffsetUs(format.subsampleOffsetUs + OplusGLSurfaceView_15);
    }

    private static final class AllocationNode {
        public Allocation allocation;
        public final long endPosition;
        public AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
            this.startPosition = OplusGLSurfaceView_15;
            this.endPosition = OplusGLSurfaceView_15 + OplusGLSurfaceView_13;
        }

        public void initialize(Allocation allocation, AllocationNode allocationNode) {
            this.allocation = allocation;
            this.next = allocationNode;
            this.wasInitialized = true;
        }

        public int translateOffset(long OplusGLSurfaceView_15) {
            return ((int) (OplusGLSurfaceView_15 - this.startPosition)) + this.allocation.offset;
        }

        public AllocationNode clear() {
            this.allocation = null;
            AllocationNode allocationNode = this.next;
            this.next = null;
            return allocationNode;
        }
    }
}
