package com.google.android.exoplayer2.extractor.wav;

/* loaded from: classes.dex */
final class WavHeaderReader {
    private static final java.lang.String TAG = "WavHeaderReader";

    public static com.google.android.exoplayer2.extractor.wav.WavHeader peek(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(extractorInput);
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(16);
        if (com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader.peek(extractorInput, parsableByteArray).id_renamed != com.google.android.exoplayer2.audio.WavUtil.RIFF_FOURCC) {
            return null;
        }
        extractorInput.peekFully(parsableByteArray.data, 0, 4);
        parsableByteArray.setPosition(0);
        int i_renamed = parsableByteArray.readInt();
        if (i_renamed != com.google.android.exoplayer2.audio.WavUtil.WAVE_FOURCC) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Unsupported RIFF format: " + i_renamed);
            return null;
        }
        com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader chunkHeaderPeek = com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader.peek(extractorInput, parsableByteArray);
        while (chunkHeaderPeek.id_renamed != com.google.android.exoplayer2.audio.WavUtil.FMT_FOURCC) {
            extractorInput.advancePeekPosition((int) chunkHeaderPeek.size);
            chunkHeaderPeek = com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader.peek(extractorInput, parsableByteArray);
        }
        com.google.android.exoplayer2.util.Assertions.checkState(chunkHeaderPeek.size >= 16);
        extractorInput.peekFully(parsableByteArray.data, 0, 16);
        parsableByteArray.setPosition(0);
        int littleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
        int littleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort();
        int littleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int littleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int littleEndianUnsignedShort3 = parsableByteArray.readLittleEndianUnsignedShort();
        int littleEndianUnsignedShort4 = parsableByteArray.readLittleEndianUnsignedShort();
        int i2 = (littleEndianUnsignedShort2 * littleEndianUnsignedShort4) / 8;
        if (littleEndianUnsignedShort3 != i2) {
            throw new com.google.android.exoplayer2.ParserException("Expected block alignment: " + i2 + "; got: " + littleEndianUnsignedShort3);
        }
        int encodingForType = com.google.android.exoplayer2.audio.WavUtil.getEncodingForType(littleEndianUnsignedShort, littleEndianUnsignedShort4);
        if (encodingForType == 0) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Unsupported WAV format: " + littleEndianUnsignedShort4 + " bit/sample, type " + littleEndianUnsignedShort);
            return null;
        }
        extractorInput.advancePeekPosition(((int) chunkHeaderPeek.size) - 16);
        return new com.google.android.exoplayer2.extractor.wav.WavHeader(littleEndianUnsignedShort2, littleEndianUnsignedIntToInt, littleEndianUnsignedIntToInt2, littleEndianUnsignedShort3, littleEndianUnsignedShort4, encodingForType);
    }

    public static void skipToData(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.wav.WavHeader wavHeader) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(extractorInput);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(wavHeader);
        extractorInput.resetPeekPosition();
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(8);
        com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader chunkHeaderPeek = com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader.peek(extractorInput, parsableByteArray);
        while (chunkHeaderPeek.id_renamed != com.google.android.exoplayer2.util.Util.getIntegerCodeForString("data")) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring unknown WAV chunk: " + chunkHeaderPeek.id_renamed);
            long j_renamed = chunkHeaderPeek.size + 8;
            if (chunkHeaderPeek.id_renamed == com.google.android.exoplayer2.util.Util.getIntegerCodeForString("RIFF")) {
                j_renamed = 12;
            }
            if (j_renamed > 2147483647L) {
                throw new com.google.android.exoplayer2.ParserException("Chunk is_renamed too large (~2GB+) to skip; id_renamed: " + chunkHeaderPeek.id_renamed);
            }
            extractorInput.skipFully((int) j_renamed);
            chunkHeaderPeek = com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader.peek(extractorInput, parsableByteArray);
        }
        extractorInput.skipFully(8);
        wavHeader.setDataBounds(extractorInput.getPosition(), chunkHeaderPeek.size);
    }

    private WavHeaderReader() {
    }

    private static final class ChunkHeader {
        public static final int SIZE_IN_BYTES = 8;
        public final int id_renamed;
        public final long size;

        private ChunkHeader(int i_renamed, long j_renamed) {
            this.id_renamed = i_renamed;
            this.size = j_renamed;
        }

        public static com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader peek(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws java.lang.InterruptedException, java.io.IOException {
            extractorInput.peekFully(parsableByteArray.data, 0, 8);
            parsableByteArray.setPosition(0);
            return new com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader(parsableByteArray.readInt(), parsableByteArray.readLittleEndianUnsignedInt());
        }
    }
}
