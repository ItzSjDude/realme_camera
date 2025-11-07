package com.google.android.exoplayer2.metadata.scte35;

/* loaded from: classes.dex */
public final class SpliceInfoDecoder implements com.google.android.exoplayer2.metadata.MetadataDecoder {
    private static final int TYPE_PRIVATE_COMMAND = 255;
    private static final int TYPE_SPLICE_INSERT = 5;
    private static final int TYPE_SPLICE_NULL = 0;
    private static final int TYPE_SPLICE_SCHEDULE = 4;
    private static final int TYPE_TIME_SIGNAL = 6;
    private final com.google.android.exoplayer2.util.ParsableByteArray sectionData = new com.google.android.exoplayer2.util.ParsableByteArray();
    private final com.google.android.exoplayer2.util.ParsableBitArray sectionHeader = new com.google.android.exoplayer2.util.ParsableBitArray();
    private com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster;

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public com.google.android.exoplayer2.metadata.Metadata decode(com.google.android.exoplayer2.metadata.MetadataInputBuffer metadataInputBuffer) {
        if (this.timestampAdjuster == null || metadataInputBuffer.subsampleOffsetUs != this.timestampAdjuster.getTimestampOffsetUs()) {
            this.timestampAdjuster = new com.google.android.exoplayer2.util.TimestampAdjuster(metadataInputBuffer.timeUs);
            this.timestampAdjuster.adjustSampleTimestamp(metadataInputBuffer.timeUs - metadataInputBuffer.subsampleOffsetUs);
        }
        java.nio.ByteBuffer byteBuffer = metadataInputBuffer.data;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.sectionData.reset(bArrArray, iLimit);
        this.sectionHeader.reset(bArrArray, iLimit);
        this.sectionHeader.skipBits(39);
        long bits = (this.sectionHeader.readBits(1) << 32) | this.sectionHeader.readBits(32);
        this.sectionHeader.skipBits(20);
        int bits2 = this.sectionHeader.readBits(12);
        int bits3 = this.sectionHeader.readBits(8);
        com.google.android.exoplayer2.metadata.Metadata.Entry spliceNullCommand = null;
        this.sectionData.skipBytes(14);
        if (bits3 == 0) {
            spliceNullCommand = new com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand();
        } else if (bits3 == 255) {
            spliceNullCommand = com.google.android.exoplayer2.metadata.scte35.PrivateCommand.parseFromSection(this.sectionData, bits2, bits);
        } else if (bits3 == 4) {
            spliceNullCommand = com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.parseFromSection(this.sectionData);
        } else if (bits3 == 5) {
            spliceNullCommand = com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.parseFromSection(this.sectionData, bits, this.timestampAdjuster);
        } else if (bits3 == 6) {
            spliceNullCommand = com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand.parseFromSection(this.sectionData, bits, this.timestampAdjuster);
        }
        return spliceNullCommand == null ? new com.google.android.exoplayer2.metadata.Metadata(new com.google.android.exoplayer2.metadata.Metadata.Entry[0]) : new com.google.android.exoplayer2.metadata.Metadata(spliceNullCommand);
    }
}
