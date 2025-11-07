package com.google.android.exoplayer2.extractor.flv;

/* loaded from: classes.dex */
final class AudioTagPayloadReader extends com.google.android.exoplayer2.extractor.flv.TagPayloadReader {
    private static final int AAC_PACKET_TYPE_AAC_RAW = 1;
    private static final int AAC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    private static final int AUDIO_FORMAT_AAC = 10;
    private static final int AUDIO_FORMAT_ALAW = 7;
    private static final int AUDIO_FORMAT_MP3 = 2;
    private static final int AUDIO_FORMAT_ULAW = 8;
    private static final int[] AUDIO_SAMPLING_RATE_TABLE = {5512, 11025, 22050, 44100};
    private int audioFormat;
    private boolean hasOutputFormat;
    private boolean hasParsedAudioDataHeader;

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void seek() {
    }

    public AudioTagPayloadReader(com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
        super(trackOutput);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean parseHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.extractor.flv.TagPayloadReader.UnsupportedFormatException {
        if (!this.hasParsedAudioDataHeader) {
            int unsignedByte = parsableByteArray.readUnsignedByte();
            this.audioFormat = (unsignedByte >> 4) & 15;
            int i_renamed = this.audioFormat;
            if (i_renamed == 2) {
                this.output.format(com.google.android.exoplayer2.Format.createAudioSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.AUDIO_MPEG, null, -1, -1, 1, AUDIO_SAMPLING_RATE_TABLE[(unsignedByte >> 2) & 3], null, null, 0, null));
                this.hasOutputFormat = true;
            } else if (i_renamed == 7 || i_renamed == 8) {
                this.output.format(com.google.android.exoplayer2.Format.createAudioSampleFormat(null, this.audioFormat == 7 ? com.google.android.exoplayer2.util.MimeTypes.AUDIO_ALAW : com.google.android.exoplayer2.util.MimeTypes.AUDIO_MLAW, null, -1, -1, 1, 8000, (unsignedByte & 1) == 1 ? 2 : 3, null, null, 0, null));
                this.hasOutputFormat = true;
            } else if (i_renamed != 10) {
                throw new com.google.android.exoplayer2.extractor.flv.TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.audioFormat);
            }
            this.hasParsedAudioDataHeader = true;
        } else {
            parsableByteArray.skipBytes(1);
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void parsePayload(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed) throws com.google.android.exoplayer2.ParserException {
        if (this.audioFormat == 2) {
            int iBytesLeft = parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, iBytesLeft);
            this.output.sampleMetadata(j_renamed, 1, iBytesLeft, 0, null);
            return;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if (unsignedByte == 0 && !this.hasOutputFormat) {
            byte[] bArr = new byte[parsableByteArray.bytesLeft()];
            parsableByteArray.readBytes(bArr, 0, bArr.length);
            android.util.Pair<java.lang.Integer, java.lang.Integer> aacAudioSpecificConfig = com.google.android.exoplayer2.util.CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
            this.output.format(com.google.android.exoplayer2.Format.createAudioSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC, null, -1, -1, ((java.lang.Integer) aacAudioSpecificConfig.second).intValue(), ((java.lang.Integer) aacAudioSpecificConfig.first).intValue(), java.util.Collections.singletonList(bArr), null, 0, null));
            this.hasOutputFormat = true;
            return;
        }
        if (this.audioFormat != 10 || unsignedByte == 1) {
            int iBytesLeft2 = parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, iBytesLeft2);
            this.output.sampleMetadata(j_renamed, 1, iBytesLeft2, 0, null);
        }
    }
}
