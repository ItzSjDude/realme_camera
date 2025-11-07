package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes.dex */
final class VorbisReader extends com.google.android.exoplayer2.extractor.ogg.StreamReader {
    private com.google.android.exoplayer2.extractor.ogg.VorbisUtil.CommentHeader commentHeader;
    private int previousPacketBlockSize;
    private boolean seenFirstAudioPacket;
    private com.google.android.exoplayer2.extractor.ogg.VorbisUtil.VorbisIdHeader vorbisIdHeader;
    private com.google.android.exoplayer2.extractor.ogg.VorbisReader.VorbisSetup vorbisSetup;

    static int readBits(byte b2, int i_renamed, int i2) {
        return (b2 >> i2) & (255 >>> (8 - i_renamed));
    }

    VorbisReader() {
    }

    public static boolean verifyBitstreamType(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        try {
            return com.google.android.exoplayer2.extractor.ogg.VorbisUtil.verifyVorbisHeaderCapturePattern(1, parsableByteArray, true);
        } catch (com.google.android.exoplayer2.ParserException unused) {
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected void reset(boolean z_renamed) {
        super.reset(z_renamed);
        if (z_renamed) {
            this.vorbisSetup = null;
            this.vorbisIdHeader = null;
            this.commentHeader = null;
        }
        this.previousPacketBlockSize = 0;
        this.seenFirstAudioPacket = false;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected void onSeekEnd(long j_renamed) {
        super.onSeekEnd(j_renamed);
        this.seenFirstAudioPacket = j_renamed != 0;
        com.google.android.exoplayer2.extractor.ogg.VorbisUtil.VorbisIdHeader vorbisIdHeader = this.vorbisIdHeader;
        this.previousPacketBlockSize = vorbisIdHeader != null ? vorbisIdHeader.blockSize0 : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected long preparePayload(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if ((parsableByteArray.data[0] & 1) == 1) {
            return -1L;
        }
        int iDecodeBlockSize = decodeBlockSize(parsableByteArray.data[0], this.vorbisSetup);
        long j_renamed = this.seenFirstAudioPacket ? (this.previousPacketBlockSize + iDecodeBlockSize) / 4 : 0;
        appendNumberOfSamples(parsableByteArray, j_renamed);
        this.seenFirstAudioPacket = true;
        this.previousPacketBlockSize = iDecodeBlockSize;
        return j_renamed;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected boolean readHeaders(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed, com.google.android.exoplayer2.extractor.ogg.StreamReader.SetupData setupData) throws java.lang.InterruptedException, java.io.IOException {
        if (this.vorbisSetup != null) {
            return false;
        }
        this.vorbisSetup = readSetupHeaders(parsableByteArray);
        if (this.vorbisSetup == null) {
            return true;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(this.vorbisSetup.idHeader.data);
        arrayList.add(this.vorbisSetup.setupHeaderData);
        setupData.format = com.google.android.exoplayer2.Format.createAudioSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.AUDIO_VORBIS, null, this.vorbisSetup.idHeader.bitrateNominal, -1, this.vorbisSetup.idHeader.channels, (int) this.vorbisSetup.idHeader.sampleRate, arrayList, null, 0, null);
        return true;
    }

    com.google.android.exoplayer2.extractor.ogg.VorbisReader.VorbisSetup readSetupHeaders(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws java.io.IOException {
        if (this.vorbisIdHeader == null) {
            this.vorbisIdHeader = com.google.android.exoplayer2.extractor.ogg.VorbisUtil.readVorbisIdentificationHeader(parsableByteArray);
            return null;
        }
        if (this.commentHeader == null) {
            this.commentHeader = com.google.android.exoplayer2.extractor.ogg.VorbisUtil.readVorbisCommentHeader(parsableByteArray);
            return null;
        }
        byte[] bArr = new byte[parsableByteArray.limit()];
        java.lang.System.arraycopy(parsableByteArray.data, 0, bArr, 0, parsableByteArray.limit());
        return new com.google.android.exoplayer2.extractor.ogg.VorbisReader.VorbisSetup(this.vorbisIdHeader, this.commentHeader, bArr, com.google.android.exoplayer2.extractor.ogg.VorbisUtil.readVorbisModes(parsableByteArray, this.vorbisIdHeader.channels), com.google.android.exoplayer2.extractor.ogg.VorbisUtil.iLog(r5.length - 1));
    }

    static void appendNumberOfSamples(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed) {
        parsableByteArray.setLimit(parsableByteArray.limit() + 4);
        parsableByteArray.data[parsableByteArray.limit() - 4] = (byte) (j_renamed & 255);
        parsableByteArray.data[parsableByteArray.limit() - 3] = (byte) ((j_renamed >>> 8) & 255);
        parsableByteArray.data[parsableByteArray.limit() - 2] = (byte) ((j_renamed >>> 16) & 255);
        parsableByteArray.data[parsableByteArray.limit() - 1] = (byte) ((j_renamed >>> 24) & 255);
    }

    private static int decodeBlockSize(byte b2, com.google.android.exoplayer2.extractor.ogg.VorbisReader.VorbisSetup vorbisSetup) {
        if (!vorbisSetup.modes[readBits(b2, vorbisSetup.iLogModes, 1)].blockFlag) {
            return vorbisSetup.idHeader.blockSize0;
        }
        return vorbisSetup.idHeader.blockSize1;
    }

    static final class VorbisSetup {
        public final com.google.android.exoplayer2.extractor.ogg.VorbisUtil.CommentHeader commentHeader;
        public final int iLogModes;
        public final com.google.android.exoplayer2.extractor.ogg.VorbisUtil.VorbisIdHeader idHeader;
        public final com.google.android.exoplayer2.extractor.ogg.VorbisUtil.Mode[] modes;
        public final byte[] setupHeaderData;

        public VorbisSetup(com.google.android.exoplayer2.extractor.ogg.VorbisUtil.VorbisIdHeader vorbisIdHeader, com.google.android.exoplayer2.extractor.ogg.VorbisUtil.CommentHeader commentHeader, byte[] bArr, com.google.android.exoplayer2.extractor.ogg.VorbisUtil.Mode[] modeArr, int i_renamed) {
            this.idHeader = vorbisIdHeader;
            this.commentHeader = commentHeader;
            this.setupHeaderData = bArr;
            this.modes = modeArr;
            this.iLogModes = i_renamed;
        }
    }
}
