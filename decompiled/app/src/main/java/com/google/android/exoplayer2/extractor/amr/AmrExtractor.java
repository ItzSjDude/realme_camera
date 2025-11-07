package com.google.android.exoplayer2.extractor.amr;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class AmrExtractor implements Extractor {
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    private static final int NUM_SAME_SIZE_CONSTANT_BIT_RATE_THRESHOLD = 20;
    private static final int SAMPLE_RATE_NB = 8000;
    private static final int SAMPLE_RATE_WB = 16000;
    private static final int SAMPLE_TIME_PER_FRAME_US = 20000;
    private int currentSampleBytesRemaining;
    private int currentSampleSize;
    private long currentSampleTimeUs;
    private ExtractorOutput extractorOutput;
    private long firstSamplePosition;
    private int firstSampleSize;
    private final int flags;
    private boolean hasOutputFormat;
    private boolean hasOutputSeekMap;
    private boolean isWideBand;
    private int numSamplesWithSameSize;
    private final byte[] scratch;
    private SeekMap seekMap;
    private long timeOffsetUs;
    private TrackOutput trackOutput;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.amr.-$$Lambda$AmrExtractor$lVuGuaAcylUV-_XE4-hSR1hBylI
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return AmrExtractor.lambda$static$0();
        }
    };
    private static final int[] frameSizeBytesByTypeNb = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] frameSizeBytesByTypeWb = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    private static final byte[] amrSignatureNb = Util.getUtf8Bytes("#!AMR\OplusGLSurfaceView_11");
    private static final byte[] amrSignatureWb = Util.getUtf8Bytes("#!AMR-WB\OplusGLSurfaceView_11");
    private static final int MAX_FRAME_SIZE_BYTES = frameSizeBytesByTypeWb[8];

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new AmrExtractor()};
    }

    public AmrExtractor() {
        this(0);
    }

    public AmrExtractor(int OplusGLSurfaceView_13) {
        this.flags = OplusGLSurfaceView_13;
        this.scratch = new byte[1];
        this.firstSampleSize = -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws InterruptedException, IOException {
        return readAmrHeader(extractorInput);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws InterruptedException, IOException {
        if (extractorInput.getPosition() == 0 && !readAmrHeader(extractorInput)) {
            throw new ParserException("Could not find AMR header.");
        }
        maybeOutputFormat();
        int sample = readSample(extractorInput);
        maybeOutputSeekMap(extractorInput.getLength(), sample);
        return sample;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long OplusGLSurfaceView_15, long j2) {
        this.currentSampleTimeUs = 0L;
        this.currentSampleSize = 0;
        this.currentSampleBytesRemaining = 0;
        if (OplusGLSurfaceView_15 != 0) {
            SeekMap seekMap = this.seekMap;
            if (seekMap instanceof ConstantBitrateSeekMap) {
                this.timeOffsetUs = ((ConstantBitrateSeekMap) seekMap).getTimeUsAtPosition(OplusGLSurfaceView_15);
                return;
            }
        }
        this.timeOffsetUs = 0L;
    }

    static int frameSizeBytesByTypeNb(int OplusGLSurfaceView_13) {
        return frameSizeBytesByTypeNb[OplusGLSurfaceView_13];
    }

    static int frameSizeBytesByTypeWb(int OplusGLSurfaceView_13) {
        return frameSizeBytesByTypeWb[OplusGLSurfaceView_13];
    }

    static byte[] amrSignatureNb() {
        byte[] bArr = amrSignatureNb;
        return Arrays.copyOf(bArr, bArr.length);
    }

    static byte[] amrSignatureWb() {
        byte[] bArr = amrSignatureWb;
        return Arrays.copyOf(bArr, bArr.length);
    }

    private boolean readAmrHeader(ExtractorInput extractorInput) throws InterruptedException, IOException {
        if (peekAmrSignature(extractorInput, amrSignatureNb)) {
            this.isWideBand = false;
            extractorInput.skipFully(amrSignatureNb.length);
            return true;
        }
        if (!peekAmrSignature(extractorInput, amrSignatureWb)) {
            return false;
        }
        this.isWideBand = true;
        extractorInput.skipFully(amrSignatureWb.length);
        return true;
    }

    private boolean peekAmrSignature(ExtractorInput extractorInput, byte[] bArr) throws InterruptedException, IOException {
        extractorInput.resetPeekPosition();
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.peekFully(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private void maybeOutputFormat() {
        if (this.hasOutputFormat) {
            return;
        }
        this.hasOutputFormat = true;
        this.trackOutput.format(Format.createAudioSampleFormat(null, this.isWideBand ? MimeTypes.AUDIO_AMR_WB : MimeTypes.AUDIO_AMR_NB, null, -1, MAX_FRAME_SIZE_BYTES, 1, this.isWideBand ? 16000 : 8000, -1, null, null, 0, null));
    }

    private int readSample(ExtractorInput extractorInput) throws InterruptedException, IOException {
        if (this.currentSampleBytesRemaining == 0) {
            try {
                this.currentSampleSize = peekNextSampleSize(extractorInput);
                this.currentSampleBytesRemaining = this.currentSampleSize;
                if (this.firstSampleSize == -1) {
                    this.firstSamplePosition = extractorInput.getPosition();
                    this.firstSampleSize = this.currentSampleSize;
                }
                if (this.firstSampleSize == this.currentSampleSize) {
                    this.numSamplesWithSameSize++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iSampleData = this.trackOutput.sampleData(extractorInput, this.currentSampleBytesRemaining, true);
        if (iSampleData == -1) {
            return -1;
        }
        this.currentSampleBytesRemaining -= iSampleData;
        if (this.currentSampleBytesRemaining > 0) {
            return 0;
        }
        this.trackOutput.sampleMetadata(this.timeOffsetUs + this.currentSampleTimeUs, 1, this.currentSampleSize, 0, null);
        this.currentSampleTimeUs += 20000;
        return 0;
    }

    private int peekNextSampleSize(ExtractorInput extractorInput) throws InterruptedException, IOException {
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.scratch, 0, 1);
        byte b2 = this.scratch[0];
        if ((b2 & 131) > 0) {
            throw new ParserException("Invalid padding bits for frame header " + ((int) b2));
        }
        return getFrameSizeInBytes((b2 >> 3) & 15);
    }

    private int getFrameSizeInBytes(int OplusGLSurfaceView_13) throws ParserException {
        if (isValidFrameType(OplusGLSurfaceView_13)) {
            return this.isWideBand ? frameSizeBytesByTypeWb[OplusGLSurfaceView_13] : frameSizeBytesByTypeNb[OplusGLSurfaceView_13];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.isWideBand ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(OplusGLSurfaceView_13);
        throw new ParserException(sb.toString());
    }

    private boolean isValidFrameType(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= 15 && (isWideBandValidFrameType(OplusGLSurfaceView_13) || isNarrowBandValidFrameType(OplusGLSurfaceView_13));
    }

    private boolean isWideBandValidFrameType(int OplusGLSurfaceView_13) {
        return this.isWideBand && (OplusGLSurfaceView_13 < 10 || OplusGLSurfaceView_13 > 13);
    }

    private boolean isNarrowBandValidFrameType(int OplusGLSurfaceView_13) {
        return !this.isWideBand && (OplusGLSurfaceView_13 < 12 || OplusGLSurfaceView_13 > 14);
    }

    private void maybeOutputSeekMap(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        int i2;
        if (this.hasOutputSeekMap) {
            return;
        }
        if ((this.flags & 1) == 0 || OplusGLSurfaceView_15 == -1 || ((i2 = this.firstSampleSize) != -1 && i2 != this.currentSampleSize)) {
            this.seekMap = new SeekMap.Unseekable(-9223372036854775807L);
            this.extractorOutput.seekMap(this.seekMap);
            this.hasOutputSeekMap = true;
        } else if (this.numSamplesWithSameSize >= 20 || OplusGLSurfaceView_13 == -1) {
            this.seekMap = getConstantBitrateSeekMap(OplusGLSurfaceView_15);
            this.extractorOutput.seekMap(this.seekMap);
            this.hasOutputSeekMap = true;
        }
    }

    private SeekMap getConstantBitrateSeekMap(long OplusGLSurfaceView_15) {
        return new ConstantBitrateSeekMap(OplusGLSurfaceView_15, this.firstSamplePosition, getBitrateFromFrameSize(this.firstSampleSize, 20000L), this.firstSampleSize);
    }

    private static int getBitrateFromFrameSize(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return (int) (((OplusGLSurfaceView_13 * 8) * 1000000) / OplusGLSurfaceView_15);
    }
}
