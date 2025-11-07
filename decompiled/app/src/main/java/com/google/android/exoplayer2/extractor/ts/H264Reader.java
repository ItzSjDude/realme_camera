package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class H264Reader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    private static final int NAL_UNIT_TYPE_PPS = 8;
    private static final int NAL_UNIT_TYPE_SEI = 6;
    private static final int NAL_UNIT_TYPE_SPS = 7;
    private final boolean allowNonIdrKeyframes;
    private final boolean detectAccessUnits;
    private java.lang.String formatId;
    private boolean hasOutputFormat;
    private com.google.android.exoplayer2.extractor.TrackOutput output;
    private long pesTimeUs;
    private boolean randomAccessIndicator;
    private com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader sampleReader;
    private final com.google.android.exoplayer2.extractor.ts.SeiReader seiReader;
    private long totalBytesWritten;
    private final boolean[] prefixFlags = new boolean[3];
    private final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer sps = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(7, 128);
    private final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer pps = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(8, 128);
    private final com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer sei = new com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer(6, 128);
    private final com.google.android.exoplayer2.util.ParsableByteArray seiWrapper = new com.google.android.exoplayer2.util.ParsableByteArray();

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    public H264Reader(com.google.android.exoplayer2.extractor.ts.SeiReader seiReader, boolean z_renamed, boolean z2) {
        this.seiReader = seiReader;
        this.allowNonIdrKeyframes = z_renamed;
        this.detectAccessUnits = z2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        com.google.android.exoplayer2.util.NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.sps.reset();
        this.pps.reset();
        this.sei.reset();
        this.sampleReader.reset();
        this.totalBytesWritten = 0L;
        this.randomAccessIndicator = false;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.sampleReader = new com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader(this.output, this.allowNonIdrKeyframes, this.detectAccessUnits);
        this.seiReader.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j_renamed, int i_renamed) {
        this.pesTimeUs = j_renamed;
        this.randomAccessIndicator |= (i_renamed & 2) != 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        byte[] bArr = parsableByteArray.data;
        this.totalBytesWritten += parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int iFindNalUnit = com.google.android.exoplayer2.util.NalUnitUtil.findNalUnit(bArr, position, iLimit, this.prefixFlags);
            if (iFindNalUnit == iLimit) {
                nalUnitData(bArr, position, iLimit);
                return;
            }
            int nalUnitType = com.google.android.exoplayer2.util.NalUnitUtil.getNalUnitType(bArr, iFindNalUnit);
            int i_renamed = iFindNalUnit - position;
            if (i_renamed > 0) {
                nalUnitData(bArr, position, iFindNalUnit);
            }
            int i2 = iLimit - iFindNalUnit;
            long j_renamed = this.totalBytesWritten - i2;
            endNalUnit(j_renamed, i2, i_renamed < 0 ? -i_renamed : 0, this.pesTimeUs);
            startNalUnit(j_renamed, nalUnitType, this.pesTimeUs);
            position = iFindNalUnit + 3;
        }
    }

    private void startNalUnit(long j_renamed, int i_renamed, long j2) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.startNalUnit(i_renamed);
            this.pps.startNalUnit(i_renamed);
        }
        this.sei.startNalUnit(i_renamed);
        this.sampleReader.startNalUnit(j_renamed, i_renamed, j2);
    }

    private void nalUnitData(byte[] bArr, int i_renamed, int i2) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.appendToNalUnit(bArr, i_renamed, i2);
            this.pps.appendToNalUnit(bArr, i_renamed, i2);
        }
        this.sei.appendToNalUnit(bArr, i_renamed, i2);
        this.sampleReader.appendToNalUnit(bArr, i_renamed, i2);
    }

    private void endNalUnit(long j_renamed, int i_renamed, int i2, long j2) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.endNalUnit(i2);
            this.pps.endNalUnit(i2);
            if (!this.hasOutputFormat) {
                if (this.sps.isCompleted() && this.pps.isCompleted()) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    arrayList.add(java.util.Arrays.copyOf(this.sps.nalData, this.sps.nalLength));
                    arrayList.add(java.util.Arrays.copyOf(this.pps.nalData, this.pps.nalLength));
                    com.google.android.exoplayer2.util.NalUnitUtil.SpsData spsNalUnit = com.google.android.exoplayer2.util.NalUnitUtil.parseSpsNalUnit(this.sps.nalData, 3, this.sps.nalLength);
                    com.google.android.exoplayer2.util.NalUnitUtil.PpsData ppsNalUnit = com.google.android.exoplayer2.util.NalUnitUtil.parsePpsNalUnit(this.pps.nalData, 3, this.pps.nalLength);
                    this.output.format(com.google.android.exoplayer2.Format.createVideoSampleFormat(this.formatId, com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264, com.google.android.exoplayer2.util.CodecSpecificDataUtil.buildAvcCodecString(spsNalUnit.profileIdc, spsNalUnit.constraintsFlagsAndReservedZero2Bits, spsNalUnit.levelIdc), -1, -1, spsNalUnit.width, spsNalUnit.height, -1.0f, arrayList, -1, spsNalUnit.pixelWidthAspectRatio, null));
                    this.hasOutputFormat = true;
                    this.sampleReader.putSps(spsNalUnit);
                    this.sampleReader.putPps(ppsNalUnit);
                    this.sps.reset();
                    this.pps.reset();
                }
            } else if (this.sps.isCompleted()) {
                this.sampleReader.putSps(com.google.android.exoplayer2.util.NalUnitUtil.parseSpsNalUnit(this.sps.nalData, 3, this.sps.nalLength));
                this.sps.reset();
            } else if (this.pps.isCompleted()) {
                this.sampleReader.putPps(com.google.android.exoplayer2.util.NalUnitUtil.parsePpsNalUnit(this.pps.nalData, 3, this.pps.nalLength));
                this.pps.reset();
            }
        }
        if (this.sei.endNalUnit(i2)) {
            this.seiWrapper.reset(this.sei.nalData, com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(this.sei.nalData, this.sei.nalLength));
            this.seiWrapper.setPosition(4);
            this.seiReader.consume(j2, this.seiWrapper);
        }
        if (this.sampleReader.endNalUnit(j_renamed, i_renamed, this.hasOutputFormat, this.randomAccessIndicator)) {
            this.randomAccessIndicator = false;
        }
    }

    private static final class SampleReader {
        private static final int DEFAULT_BUFFER_SIZE = 128;
        private static final int NAL_UNIT_TYPE_AUD = 9;
        private static final int NAL_UNIT_TYPE_IDR = 5;
        private static final int NAL_UNIT_TYPE_NON_IDR = 1;
        private static final int NAL_UNIT_TYPE_PARTITION_A = 2;
        private final boolean allowNonIdrKeyframes;
        private int bufferLength;
        private final boolean detectAccessUnits;
        private boolean isFilling;
        private long nalUnitStartPosition;
        private long nalUnitTimeUs;
        private int nalUnitType;
        private final com.google.android.exoplayer2.extractor.TrackOutput output;
        private com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData previousSliceHeader;
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;
        private com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData sliceHeader;
        private final android.util.SparseArray<com.google.android.exoplayer2.util.NalUnitUtil.SpsData> sps = new android.util.SparseArray<>();
        private final android.util.SparseArray<com.google.android.exoplayer2.util.NalUnitUtil.PpsData> pps = new android.util.SparseArray<>();
        private byte[] buffer = new byte[128];
        private final com.google.android.exoplayer2.util.ParsableNalUnitBitArray bitArray = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray(this.buffer, 0, 0);

        public SampleReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput, boolean z_renamed, boolean z2) {
            this.output = trackOutput;
            this.allowNonIdrKeyframes = z_renamed;
            this.detectAccessUnits = z2;
            this.previousSliceHeader = new com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData();
            this.sliceHeader = new com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData();
            reset();
        }

        public boolean needsSpsPps() {
            return this.detectAccessUnits;
        }

        public void putSps(com.google.android.exoplayer2.util.NalUnitUtil.SpsData spsData) {
            this.sps.append(spsData.seqParameterSetId, spsData);
        }

        public void putPps(com.google.android.exoplayer2.util.NalUnitUtil.PpsData ppsData) {
            this.pps.append(ppsData.picParameterSetId, ppsData);
        }

        public void reset() {
            this.isFilling = false;
            this.readingSample = false;
            this.sliceHeader.clear();
        }

        public void startNalUnit(long j_renamed, int i_renamed, long j2) {
            this.nalUnitType = i_renamed;
            this.nalUnitTimeUs = j2;
            this.nalUnitStartPosition = j_renamed;
            if (!this.allowNonIdrKeyframes || this.nalUnitType != 1) {
                if (!this.detectAccessUnits) {
                    return;
                }
                int i2 = this.nalUnitType;
                if (i2 != 5 && i2 != 1 && i2 != 2) {
                    return;
                }
            }
            com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData sliceHeaderData = this.previousSliceHeader;
            this.previousSliceHeader = this.sliceHeader;
            this.sliceHeader = sliceHeaderData;
            this.sliceHeader.clear();
            this.bufferLength = 0;
            this.isFilling = true;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:53:0x0101  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:54:0x0104  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:56:0x0108  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:60:0x011a  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:63:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:74:0x0154  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void appendToNalUnit(byte[] r24, int r25, int r26) {
            /*
                Method dump skipped, instructions count: 418
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.appendToNalUnit(byte[], int, int):void");
        }

        public boolean endNalUnit(long j_renamed, int i_renamed, boolean z_renamed, boolean z2) {
            boolean z3 = false;
            if (this.nalUnitType == 9 || (this.detectAccessUnits && this.sliceHeader.isFirstVclNalUnitOfPicture(this.previousSliceHeader))) {
                if (z_renamed && this.readingSample) {
                    outputSample(i_renamed + ((int) (j_renamed - this.nalUnitStartPosition)));
                }
                this.samplePosition = this.nalUnitStartPosition;
                this.sampleTimeUs = this.nalUnitTimeUs;
                this.sampleIsKeyframe = false;
                this.readingSample = true;
            }
            if (this.allowNonIdrKeyframes) {
                z2 = this.sliceHeader.isISlice();
            }
            boolean z4 = this.sampleIsKeyframe;
            int i2 = this.nalUnitType;
            if (i2 == 5 || (z2 && i2 == 1)) {
                z3 = true;
            }
            this.sampleIsKeyframe = z4 | z3;
            return this.sampleIsKeyframe;
        }

        private void outputSample(int i_renamed) {
            boolean z_renamed = this.sampleIsKeyframe;
            this.output.sampleMetadata(this.sampleTimeUs, z_renamed ? 1 : 0, (int) (this.nalUnitStartPosition - this.samplePosition), i_renamed, null);
        }

        private static final class SliceHeaderData {
            private static final int SLICE_TYPE_ALL_I = 7;
            private static final int SLICE_TYPE_I = 2;
            private boolean bottomFieldFlag;
            private boolean bottomFieldFlagPresent;
            private int deltaPicOrderCnt0;
            private int deltaPicOrderCnt1;
            private int deltaPicOrderCntBottom;
            private boolean fieldPicFlag;
            private int frameNum;
            private boolean hasSliceType;
            private boolean idrPicFlag;
            private int idrPicId;
            private boolean isComplete;
            private int nalRefIdc;
            private int picOrderCntLsb;
            private int picParameterSetId;
            private int sliceType;
            private com.google.android.exoplayer2.util.NalUnitUtil.SpsData spsData;

            private SliceHeaderData() {
            }

            public void clear() {
                this.hasSliceType = false;
                this.isComplete = false;
            }

            public void setSliceType(int i_renamed) {
                this.sliceType = i_renamed;
                this.hasSliceType = true;
            }

            public void setAll(com.google.android.exoplayer2.util.NalUnitUtil.SpsData spsData, int i_renamed, int i2, int i3, int i4, boolean z_renamed, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.spsData = spsData;
                this.nalRefIdc = i_renamed;
                this.sliceType = i2;
                this.frameNum = i3;
                this.picParameterSetId = i4;
                this.fieldPicFlag = z_renamed;
                this.bottomFieldFlagPresent = z2;
                this.bottomFieldFlag = z3;
                this.idrPicFlag = z4;
                this.idrPicId = i5;
                this.picOrderCntLsb = i6;
                this.deltaPicOrderCntBottom = i7;
                this.deltaPicOrderCnt0 = i8;
                this.deltaPicOrderCnt1 = i9;
                this.isComplete = true;
                this.hasSliceType = true;
            }

            public boolean isISlice() {
                int i_renamed;
                return this.hasSliceType && ((i_renamed = this.sliceType) == 7 || i_renamed == 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean isFirstVclNalUnitOfPicture(com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData sliceHeaderData) {
                boolean z_renamed;
                boolean z2;
                if (this.isComplete) {
                    if (!sliceHeaderData.isComplete || this.frameNum != sliceHeaderData.frameNum || this.picParameterSetId != sliceHeaderData.picParameterSetId || this.fieldPicFlag != sliceHeaderData.fieldPicFlag) {
                        return true;
                    }
                    if (this.bottomFieldFlagPresent && sliceHeaderData.bottomFieldFlagPresent && this.bottomFieldFlag != sliceHeaderData.bottomFieldFlag) {
                        return true;
                    }
                    int i_renamed = this.nalRefIdc;
                    int i2 = sliceHeaderData.nalRefIdc;
                    if (i_renamed != i2 && (i_renamed == 0 || i2 == 0)) {
                        return true;
                    }
                    if (this.spsData.picOrderCountType == 0 && sliceHeaderData.spsData.picOrderCountType == 0 && (this.picOrderCntLsb != sliceHeaderData.picOrderCntLsb || this.deltaPicOrderCntBottom != sliceHeaderData.deltaPicOrderCntBottom)) {
                        return true;
                    }
                    if ((this.spsData.picOrderCountType == 1 && sliceHeaderData.spsData.picOrderCountType == 1 && (this.deltaPicOrderCnt0 != sliceHeaderData.deltaPicOrderCnt0 || this.deltaPicOrderCnt1 != sliceHeaderData.deltaPicOrderCnt1)) || (z_renamed = this.idrPicFlag) != (z2 = sliceHeaderData.idrPicFlag)) {
                        return true;
                    }
                    if (z_renamed && z2 && this.idrPicId != sliceHeaderData.idrPicId) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
