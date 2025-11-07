package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes.dex */
final class TrackFragment {
    public long atomPosition;
    public long auxiliaryDataPosition;
    public long dataPosition;
    public boolean definesEncryptionData;
    public com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues header;
    public long nextFragmentDecodeTime;
    public int[] sampleCompositionTimeOffsetTable;
    public int sampleCount;
    public long[] sampleDecodingTimeTable;
    public com.google.android.exoplayer2.util.ParsableByteArray sampleEncryptionData;
    public int sampleEncryptionDataLength;
    public boolean sampleEncryptionDataNeedsFill;
    public boolean[] sampleHasSubsampleEncryptionTable;
    public boolean[] sampleIsSyncFrameTable;
    public int[] sampleSizeTable;
    public com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox trackEncryptionBox;
    public int trunCount;
    public long[] trunDataPosition;
    public int[] trunLength;

    TrackFragment() {
    }

    public void reset() {
        this.trunCount = 0;
        this.nextFragmentDecodeTime = 0L;
        this.definesEncryptionData = false;
        this.sampleEncryptionDataNeedsFill = false;
        this.trackEncryptionBox = null;
    }

    public void initTables(int i_renamed, int i2) {
        this.trunCount = i_renamed;
        this.sampleCount = i2;
        int[] iArr = this.trunLength;
        if (iArr == null || iArr.length < i_renamed) {
            this.trunDataPosition = new long[i_renamed];
            this.trunLength = new int[i_renamed];
        }
        int[] iArr2 = this.sampleSizeTable;
        if (iArr2 == null || iArr2.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.sampleSizeTable = new int[i3];
            this.sampleCompositionTimeOffsetTable = new int[i3];
            this.sampleDecodingTimeTable = new long[i3];
            this.sampleIsSyncFrameTable = new boolean[i3];
            this.sampleHasSubsampleEncryptionTable = new boolean[i3];
        }
    }

    public void initEncryptionData(int i_renamed) {
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.sampleEncryptionData;
        if (parsableByteArray == null || parsableByteArray.limit() < i_renamed) {
            this.sampleEncryptionData = new com.google.android.exoplayer2.util.ParsableByteArray(i_renamed);
        }
        this.sampleEncryptionDataLength = i_renamed;
        this.definesEncryptionData = true;
        this.sampleEncryptionDataNeedsFill = true;
    }

    public void fillEncryptionData(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        extractorInput.readFully(this.sampleEncryptionData.data, 0, this.sampleEncryptionDataLength);
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public void fillEncryptionData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.readBytes(this.sampleEncryptionData.data, 0, this.sampleEncryptionDataLength);
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public long getSamplePresentationTime(int i_renamed) {
        return this.sampleDecodingTimeTable[i_renamed] + this.sampleCompositionTimeOffsetTable[i_renamed];
    }

    public boolean sampleHasSubsampleEncryptionTable(int i_renamed) {
        return this.definesEncryptionData && this.sampleHasSubsampleEncryptionTable[i_renamed];
    }
}
