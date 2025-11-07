package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.WavUtil;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes.dex */
final class WavHeaderReader {
    private static final String TAG = "WavHeaderReader";

    public static WavHeader peek(ExtractorInput extractorInput) throws InterruptedException, IOException {
        Assertions.checkNotNull(extractorInput);
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        if (ChunkHeader.peek(extractorInput, parsableByteArray).f8990id != WavUtil.RIFF_FOURCC) {
            return null;
        }
        extractorInput.peekFully(parsableByteArray.data, 0, 4);
        parsableByteArray.setPosition(0);
        int OplusGLSurfaceView_13 = parsableByteArray.readInt();
        if (OplusGLSurfaceView_13 != WavUtil.WAVE_FOURCC) {
            Log.m8320e(TAG, "Unsupported RIFF format: " + OplusGLSurfaceView_13);
            return null;
        }
        ChunkHeader chunkHeaderPeek = ChunkHeader.peek(extractorInput, parsableByteArray);
        while (chunkHeaderPeek.f8990id != WavUtil.FMT_FOURCC) {
            extractorInput.advancePeekPosition((int) chunkHeaderPeek.size);
            chunkHeaderPeek = ChunkHeader.peek(extractorInput, parsableByteArray);
        }
        Assertions.checkState(chunkHeaderPeek.size >= 16);
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
            throw new ParserException("Expected block alignment: " + i2 + "; got: " + littleEndianUnsignedShort3);
        }
        int encodingForType = WavUtil.getEncodingForType(littleEndianUnsignedShort, littleEndianUnsignedShort4);
        if (encodingForType == 0) {
            Log.m8320e(TAG, "Unsupported WAV format: " + littleEndianUnsignedShort4 + " bit/sample, type " + littleEndianUnsignedShort);
            return null;
        }
        extractorInput.advancePeekPosition(((int) chunkHeaderPeek.size) - 16);
        return new WavHeader(littleEndianUnsignedShort2, littleEndianUnsignedIntToInt, littleEndianUnsignedIntToInt2, littleEndianUnsignedShort3, littleEndianUnsignedShort4, encodingForType);
    }

    public static void skipToData(ExtractorInput extractorInput, WavHeader wavHeader) throws InterruptedException, IOException {
        Assertions.checkNotNull(extractorInput);
        Assertions.checkNotNull(wavHeader);
        extractorInput.resetPeekPosition();
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        ChunkHeader chunkHeaderPeek = ChunkHeader.peek(extractorInput, parsableByteArray);
        while (chunkHeaderPeek.f8990id != Util.getIntegerCodeForString("data")) {
            Log.m8324w(TAG, "Ignoring unknown WAV chunk: " + chunkHeaderPeek.f8990id);
            long OplusGLSurfaceView_15 = chunkHeaderPeek.size + 8;
            if (chunkHeaderPeek.f8990id == Util.getIntegerCodeForString("RIFF")) {
                OplusGLSurfaceView_15 = 12;
            }
            if (OplusGLSurfaceView_15 > 2147483647L) {
                throw new ParserException("Chunk is too large (~2GB+) to skip; id_renamed: " + chunkHeaderPeek.f8990id);
            }
            extractorInput.skipFully((int) OplusGLSurfaceView_15);
            chunkHeaderPeek = ChunkHeader.peek(extractorInput, parsableByteArray);
        }
        extractorInput.skipFully(8);
        wavHeader.setDataBounds(extractorInput.getPosition(), chunkHeaderPeek.size);
    }

    private WavHeaderReader() {
    }

    private static final class ChunkHeader {
        public static final int SIZE_IN_BYTES = 8;

        /* renamed from: id_renamed */
        public final int f8990id;
        public final long size;

        private ChunkHeader(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            this.f8990id = OplusGLSurfaceView_13;
            this.size = OplusGLSurfaceView_15;
        }

        public static ChunkHeader peek(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws InterruptedException, IOException {
            extractorInput.peekFully(parsableByteArray.data, 0, 8);
            parsableByteArray.setPosition(0);
            return new ChunkHeader(parsableByteArray.readInt(), parsableByteArray.readLittleEndianUnsignedInt());
        }
    }
}
