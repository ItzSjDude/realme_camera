package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes.dex */
final class OggPageHeader {
    public static final int EMPTY_PAGE_HEADER_SIZE = 27;
    public static final int MAX_PAGE_PAYLOAD = 65025;
    public static final int MAX_PAGE_SIZE = 65307;
    public static final int MAX_SEGMENT_COUNT = 255;
    private static final int TYPE_OGGS = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("OggS");
    public int bodySize;
    public long granulePosition;
    public int headerSize;
    public long pageChecksum;
    public int pageSegmentCount;
    public long pageSequenceNumber;
    public int revision;
    public long streamSerialNumber;
    public int type;
    public final int[] laces = new int[255];
    private final com.google.android.exoplayer2.util.ParsableByteArray scratch = new com.google.android.exoplayer2.util.ParsableByteArray(255);

    OggPageHeader() {
    }

    public void reset() {
        this.revision = 0;
        this.type = 0;
        this.granulePosition = 0L;
        this.streamSerialNumber = 0L;
        this.pageSequenceNumber = 0L;
        this.pageChecksum = 0L;
        this.pageSegmentCount = 0;
        this.headerSize = 0;
        this.bodySize = 0;
    }

    public boolean populate(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        this.scratch.reset();
        reset();
        if (!(extractorInput.getLength() == -1 || extractorInput.getLength() - extractorInput.getPeekPosition() >= 27) || !extractorInput.peekFully(this.scratch.data, 0, 27, true)) {
            if (z_renamed) {
                return false;
            }
            throw new java.io.EOFException();
        }
        if (this.scratch.readUnsignedInt() != TYPE_OGGS) {
            if (z_renamed) {
                return false;
            }
            throw new com.google.android.exoplayer2.ParserException("expected OggS capture pattern at_renamed begin of_renamed page");
        }
        this.revision = this.scratch.readUnsignedByte();
        if (this.revision != 0) {
            if (z_renamed) {
                return false;
            }
            throw new com.google.android.exoplayer2.ParserException("unsupported bit stream revision");
        }
        this.type = this.scratch.readUnsignedByte();
        this.granulePosition = this.scratch.readLittleEndianLong();
        this.streamSerialNumber = this.scratch.readLittleEndianUnsignedInt();
        this.pageSequenceNumber = this.scratch.readLittleEndianUnsignedInt();
        this.pageChecksum = this.scratch.readLittleEndianUnsignedInt();
        this.pageSegmentCount = this.scratch.readUnsignedByte();
        this.headerSize = this.pageSegmentCount + 27;
        this.scratch.reset();
        extractorInput.peekFully(this.scratch.data, 0, this.pageSegmentCount);
        for (int i_renamed = 0; i_renamed < this.pageSegmentCount; i_renamed++) {
            this.laces[i_renamed] = this.scratch.readUnsignedByte();
            this.bodySize += this.laces[i_renamed];
        }
        return true;
    }
}
