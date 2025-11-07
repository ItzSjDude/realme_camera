package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class H265Reader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    private static final int BLA_W_LP = 16;
    private static final int CRA_NUT = 21;
    private static final int PPS_NUT = 34;
    private static final int PREFIX_SEI_NUT = 39;
    private static final int RASL_R = 9;
    private static final int SPS_NUT = 33;
    private static final int SUFFIX_SEI_NUT = 40;
    private static final java.lang.String TAG = "H265Reader";
    private static final int VPS_NUT = 32;
    private java.lang.String formatId;
    private boolean hasOutputFormat;
    private com.google.android.exoplayer2.extractor.TrackOutput output;
    private long pesTimeUs;
    private com.google.android.exoplayer2.extractor.ts.H265Reader.SampleReader sampleReader;
    private final com.google.android.exoplayer2.extractor.ts.SeiReader seiReader;
    private long totalBytesWritten;
    private final boolean[] prefixFlags = new boolean[3];
    private final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer vps = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(32, 128);
    private final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer sps = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(33, 128);
    private final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer pps = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(34, 128);
    private final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer prefixSei = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(39, 128);
    private final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer suffixSei = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(40, 128);
    private final com.google.android.exoplayer2.util.ParsableByteArray seiWrapper = new com.google.android.exoplayer2.util.ParsableByteArray();

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    public H265Reader(com.google.android.exoplayer2.extractor.ts.SeiReader seiReader) {
        this.seiReader = seiReader;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        com.google.android.exoplayer2.util.NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.vps.reset();
        this.sps.reset();
        this.pps.reset();
        this.prefixSei.reset();
        this.suffixSei.reset();
        this.sampleReader.reset();
        this.totalBytesWritten = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.sampleReader = new com.google.android.exoplayer2.extractor.ts.H265Reader.SampleReader(this.output);
        this.seiReader.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j_renamed, int i_renamed) {
        this.pesTimeUs = j_renamed;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        while (parsableByteArray.bytesLeft() > 0) {
            int position = parsableByteArray.getPosition();
            int iLimit = parsableByteArray.limit();
            byte[] bArr = parsableByteArray.data;
            this.totalBytesWritten += parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
            while (position < iLimit) {
                int iFindNalUnit = com.google.android.exoplayer2.util.NalUnitUtil.findNalUnit(bArr, position, iLimit, this.prefixFlags);
                if (iFindNalUnit == iLimit) {
                    nalUnitData(bArr, position, iLimit);
                    return;
                }
                int h265NalUnitType = com.google.android.exoplayer2.util.NalUnitUtil.getH265NalUnitType(bArr, iFindNalUnit);
                int i_renamed = iFindNalUnit - position;
                if (i_renamed > 0) {
                    nalUnitData(bArr, position, iFindNalUnit);
                }
                int i2 = iLimit - iFindNalUnit;
                long j_renamed = this.totalBytesWritten - i2;
                endNalUnit(j_renamed, i2, i_renamed < 0 ? -i_renamed : 0, this.pesTimeUs);
                startNalUnit(j_renamed, i2, h265NalUnitType, this.pesTimeUs);
                position = iFindNalUnit + 3;
            }
        }
    }

    private void startNalUnit(long j_renamed, int i_renamed, int i2, long j2) {
        if (this.hasOutputFormat) {
            this.sampleReader.startNalUnit(j_renamed, i_renamed, i2, j2);
        } else {
            this.vps.startNalUnit(i2);
            this.sps.startNalUnit(i2);
            this.pps.startNalUnit(i2);
        }
        this.prefixSei.startNalUnit(i2);
        this.suffixSei.startNalUnit(i2);
    }

    private void nalUnitData(byte[] bArr, int i_renamed, int i2) {
        if (this.hasOutputFormat) {
            this.sampleReader.readNalUnitData(bArr, i_renamed, i2);
        } else {
            this.vps.appendToNalUnit(bArr, i_renamed, i2);
            this.sps.appendToNalUnit(bArr, i_renamed, i2);
            this.pps.appendToNalUnit(bArr, i_renamed, i2);
        }
        this.prefixSei.appendToNalUnit(bArr, i_renamed, i2);
        this.suffixSei.appendToNalUnit(bArr, i_renamed, i2);
    }

    private void endNalUnit(long j_renamed, int i_renamed, int i2, long j2) {
        if (this.hasOutputFormat) {
            this.sampleReader.endNalUnit(j_renamed, i_renamed);
        } else {
            this.vps.endNalUnit(i2);
            this.sps.endNalUnit(i2);
            this.pps.endNalUnit(i2);
            if (this.vps.isCompleted() && this.sps.isCompleted() && this.pps.isCompleted()) {
                this.output.format(parseMediaFormat(this.formatId, this.vps, this.sps, this.pps));
                this.hasOutputFormat = true;
            }
        }
        if (this.prefixSei.endNalUnit(i2)) {
            this.seiWrapper.reset(this.prefixSei.nalData, com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(this.prefixSei.nalData, this.prefixSei.nalLength));
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(j2, this.seiWrapper);
        }
        if (this.suffixSei.endNalUnit(i2)) {
            this.seiWrapper.reset(this.suffixSei.nalData, com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(this.suffixSei.nalData, this.suffixSei.nalLength));
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(j2, this.seiWrapper);
        }
    }

    private static com.google.android.exoplayer2.Format parseMediaFormat(java.lang.String str, com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer, com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer2, com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer nalUnitTargetBuffer3) {
        float f_renamed;
        byte[] bArr = new byte[nalUnitTargetBuffer.nalLength + nalUnitTargetBuffer2.nalLength + nalUnitTargetBuffer3.nalLength];
        java.lang.System.arraycopy(nalUnitTargetBuffer.nalData, 0, bArr, 0, nalUnitTargetBuffer.nalLength);
        java.lang.System.arraycopy(nalUnitTargetBuffer2.nalData, 0, bArr, nalUnitTargetBuffer.nalLength, nalUnitTargetBuffer2.nalLength);
        java.lang.System.arraycopy(nalUnitTargetBuffer3.nalData, 0, bArr, nalUnitTargetBuffer.nalLength + nalUnitTargetBuffer2.nalLength, nalUnitTargetBuffer3.nalLength);
        com.google.android.exoplayer2.util.ParsableNalUnitBitArray parsableNalUnitBitArray = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray(nalUnitTargetBuffer2.nalData, 0, nalUnitTargetBuffer2.nalLength);
        parsableNalUnitBitArray.skipBits(44);
        int bits = parsableNalUnitBitArray.readBits(3);
        parsableNalUnitBitArray.skipBit();
        parsableNalUnitBitArray.skipBits(88);
        parsableNalUnitBitArray.skipBits(8);
        int i_renamed = 0;
        for (int i2 = 0; i2 < bits; i2++) {
            if (parsableNalUnitBitArray.readBit()) {
                i_renamed += 89;
            }
            if (parsableNalUnitBitArray.readBit()) {
                i_renamed += 8;
            }
        }
        parsableNalUnitBitArray.skipBits(i_renamed);
        if (bits > 0) {
            parsableNalUnitBitArray.skipBits((8 - bits) * 2);
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (unsignedExpGolombCodedInt == 3) {
            parsableNalUnitBitArray.skipBit();
        }
        int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            int unsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            unsignedExpGolombCodedInt2 -= ((unsignedExpGolombCodedInt == 1 || unsignedExpGolombCodedInt == 2) ? 2 : 1) * (unsignedExpGolombCodedInt4 + unsignedExpGolombCodedInt5);
            unsignedExpGolombCodedInt3 -= (unsignedExpGolombCodedInt == 1 ? 2 : 1) * (unsignedExpGolombCodedInt6 + unsignedExpGolombCodedInt7);
        }
        int i3 = unsignedExpGolombCodedInt2;
        int i4 = unsignedExpGolombCodedInt3;
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int unsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        for (int i5 = parsableNalUnitBitArray.readBit() ? 0 : bits; i5 <= bits; i5++) {
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            skipScalingList(parsableNalUnitBitArray);
        }
        parsableNalUnitBitArray.skipBits(2);
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(8);
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
        }
        skipShortTermRefPicSets(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.readBit()) {
            for (int i6 = 0; i6 < parsableNalUnitBitArray.readUnsignedExpGolombCodedInt(); i6++) {
                parsableNalUnitBitArray.skipBits(unsignedExpGolombCodedInt8 + 4 + 1);
            }
        }
        parsableNalUnitBitArray.skipBits(2);
        float f2 = 1.0f;
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            int bits2 = parsableNalUnitBitArray.readBits(8);
            if (bits2 == 255) {
                int bits3 = parsableNalUnitBitArray.readBits(16);
                int bits4 = parsableNalUnitBitArray.readBits(16);
                if (bits3 != 0 && bits4 != 0) {
                    f2 = bits3 / bits4;
                }
            } else if (bits2 < com.google.android.exoplayer2.util.NalUnitUtil.ASPECT_RATIO_IDC_VALUES.length) {
                f_renamed = com.google.android.exoplayer2.util.NalUnitUtil.ASPECT_RATIO_IDC_VALUES[bits2];
            } else {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unexpected aspect_ratio_idc value: " + bits2);
            }
            f_renamed = f2;
        } else {
            f_renamed = f2;
        }
        return com.google.android.exoplayer2.Format.createVideoSampleFormat(str, com.google.android.exoplayer2.util.MimeTypes.VIDEO_H265, null, -1, -1, i3, i4, -1.0f, java.util.Collections.singletonList(bArr), -1, f_renamed, null);
    }

    private static void skipScalingList(com.google.android.exoplayer2.util.ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i_renamed = 0; i_renamed < 4; i_renamed++) {
            int i2 = 0;
            while (i2 < 6) {
                if (!parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                } else {
                    int iMin = java.lang.Math.min(64, 1 << ((i_renamed << 1) + 4));
                    if (i_renamed > 1) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                    for (int i3 = 0; i3 < iMin; i3++) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                }
                int i4 = 3;
                if (i_renamed != 3) {
                    i4 = 1;
                }
                i2 += i4;
            }
        }
    }

    private static void skipShortTermRefPicSets(com.google.android.exoplayer2.util.ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        boolean bit = false;
        int i_renamed = 0;
        for (int i2 = 0; i2 < unsignedExpGolombCodedInt; i2++) {
            if (i2 != 0) {
                bit = parsableNalUnitBitArray.readBit();
            }
            if (bit) {
                parsableNalUnitBitArray.skipBit();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                for (int i3 = 0; i3 <= i_renamed; i3++) {
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.skipBit();
                    }
                }
            } else {
                int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int i4 = unsignedExpGolombCodedInt2 + unsignedExpGolombCodedInt3;
                for (int i5 = 0; i5 < unsignedExpGolombCodedInt2; i5++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.skipBit();
                }
                for (int i6 = 0; i6 < unsignedExpGolombCodedInt3; i6++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.skipBit();
                }
                i_renamed = i4;
            }
        }
    }

    private static final class SampleReader {
        private static final int FIRST_SLICE_FLAG_OFFSET = 2;
        private boolean isFirstParameterSet;
        private boolean isFirstSlice;
        private boolean lookingForFirstSliceFlag;
        private int nalUnitBytesRead;
        private boolean nalUnitHasKeyframeData;
        private long nalUnitStartPosition;
        private long nalUnitTimeUs;
        private final com.google.android.exoplayer2.extractor.TrackOutput output;
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;
        private boolean writingParameterSets;

        public SampleReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
            this.output = trackOutput;
        }

        public void reset() {
            this.lookingForFirstSliceFlag = false;
            this.isFirstSlice = false;
            this.isFirstParameterSet = false;
            this.readingSample = false;
            this.writingParameterSets = false;
        }

        public void startNalUnit(long j_renamed, int i_renamed, int i2, long j2) {
            this.isFirstSlice = false;
            this.isFirstParameterSet = false;
            this.nalUnitTimeUs = j2;
            this.nalUnitBytesRead = 0;
            this.nalUnitStartPosition = j_renamed;
            boolean z_renamed = true;
            if (i2 >= 32) {
                if (!this.writingParameterSets && this.readingSample) {
                    outputSample(i_renamed);
                    this.readingSample = false;
                }
                if (i2 <= 34) {
                    this.isFirstParameterSet = !this.writingParameterSets;
                    this.writingParameterSets = true;
                }
            }
            this.nalUnitHasKeyframeData = i2 >= 16 && i2 <= 21;
            if (!this.nalUnitHasKeyframeData && i2 > 9) {
                z_renamed = false;
            }
            this.lookingForFirstSliceFlag = z_renamed;
        }

        public void readNalUnitData(byte[] bArr, int i_renamed, int i2) {
            if (this.lookingForFirstSliceFlag) {
                int i3 = this.nalUnitBytesRead;
                int i4 = (i_renamed + 2) - i3;
                if (i4 < i2) {
                    this.isFirstSlice = (bArr[i4] & 128) != 0;
                    this.lookingForFirstSliceFlag = false;
                } else {
                    this.nalUnitBytesRead = i3 + (i2 - i_renamed);
                }
            }
        }

        public void endNalUnit(long j_renamed, int i_renamed) {
            if (this.writingParameterSets && this.isFirstSlice) {
                this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
                this.writingParameterSets = false;
            } else if (this.isFirstParameterSet || this.isFirstSlice) {
                if (this.readingSample) {
                    outputSample(i_renamed + ((int) (j_renamed - this.nalUnitStartPosition)));
                }
                this.samplePosition = this.nalUnitStartPosition;
                this.sampleTimeUs = this.nalUnitTimeUs;
                this.readingSample = true;
                this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
            }
        }

        private void outputSample(int i_renamed) {
            boolean z_renamed = this.sampleIsKeyframe;
            this.output.sampleMetadata(this.sampleTimeUs, z_renamed ? 1 : 0, (int) (this.nalUnitStartPosition - this.samplePosition), i_renamed, null);
        }
    }
}
