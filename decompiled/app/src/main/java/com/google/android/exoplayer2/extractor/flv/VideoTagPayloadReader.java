package com.google.android.exoplayer2.extractor.flv;

/* loaded from: classes.dex */
final class VideoTagPayloadReader extends com.google.android.exoplayer2.extractor.flv.TagPayloadReader {
    private static final int AVC_PACKET_TYPE_AVC_NALU = 1;
    private static final int AVC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    private static final int VIDEO_CODEC_AVC = 7;
    private static final int VIDEO_FRAME_KEYFRAME = 1;
    private static final int VIDEO_FRAME_VIDEO_INFO = 5;
    private int frameType;
    private boolean hasOutputFormat;
    private final com.google.android.exoplayer2.util.ParsableByteArray nalLength;
    private final com.google.android.exoplayer2.util.ParsableByteArray nalStartCode;
    private int nalUnitLengthFieldLength;

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void seek() {
    }

    public VideoTagPayloadReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
        super(trackOutput);
        this.nalStartCode = new com.google.android.exoplayer2.util.ParsableByteArray(com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE);
        this.nalLength = new com.google.android.exoplayer2.util.ParsableByteArray(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean parseHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.extractor.flv.TagPayloadReader.UnsupportedFormatException {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i_renamed = (unsignedByte >> 4) & 15;
        int i2 = unsignedByte & 15;
        if (i2 != 7) {
            throw new com.google.android.exoplayer2.extractor.flv.TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i2);
        }
        this.frameType = i_renamed;
        return i_renamed != 5;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void parsePayload(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed) throws com.google.android.exoplayer2.ParserException {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        long int24 = j_renamed + (parsableByteArray.readInt24() * 1000);
        if (unsignedByte == 0 && !this.hasOutputFormat) {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = new com.google.android.exoplayer2.util.ParsableByteArray(new byte[parsableByteArray.bytesLeft()]);
            parsableByteArray.readBytes(parsableByteArray2.data, 0, parsableByteArray.bytesLeft());
            com.google.android.exoplayer2.video.AvcConfig avcConfig = com.google.android.exoplayer2.video.AvcConfig.parse(parsableByteArray2);
            this.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
            this.output.format(com.google.android.exoplayer2.Format.createVideoSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264, null, -1, -1, avcConfig.width, avcConfig.height, -1.0f, avcConfig.initializationData, -1, avcConfig.pixelWidthAspectRatio, null));
            this.hasOutputFormat = true;
            return;
        }
        if (unsignedByte == 1 && this.hasOutputFormat) {
            byte[] bArr = this.nalLength.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i_renamed = 4 - this.nalUnitLengthFieldLength;
            int i2 = 0;
            while (parsableByteArray.bytesLeft() > 0) {
                parsableByteArray.readBytes(this.nalLength.data, i_renamed, this.nalUnitLengthFieldLength);
                this.nalLength.setPosition(0);
                int unsignedIntToInt = this.nalLength.readUnsignedIntToInt();
                this.nalStartCode.setPosition(0);
                this.output.sampleData(this.nalStartCode, 4);
                this.output.sampleData(parsableByteArray, unsignedIntToInt);
                i2 = i2 + 4 + unsignedIntToInt;
            }
            this.output.sampleMetadata(int24, this.frameType == 1 ? 1 : 0, i2, 0, null);
        }
    }
}
