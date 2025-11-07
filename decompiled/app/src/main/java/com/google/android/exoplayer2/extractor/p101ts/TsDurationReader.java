package com.google.android.exoplayer2.extractor.p101ts;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes.dex */
final class TsDurationReader {
    private static final int TIMESTAMP_SEARCH_BYTES = 112800;
    private boolean isDurationRead;
    private boolean isFirstPcrValueRead;
    private boolean isLastPcrValueRead;
    private final TimestampAdjuster pcrTimestampAdjuster = new TimestampAdjuster(0);
    private long firstPcrValue = -9223372036854775807L;
    private long lastPcrValue = -9223372036854775807L;
    private long durationUs = -9223372036854775807L;
    private final ParsableByteArray packetBuffer = new ParsableByteArray();

    TsDurationReader() {
    }

    public boolean isDurationReadFinished() {
        return this.isDurationRead;
    }

    public int readDuration(ExtractorInput extractorInput, PositionHolder positionHolder, int OplusGLSurfaceView_13) throws InterruptedException, IOException {
        if (OplusGLSurfaceView_13 <= 0) {
            return finishReadDuration(extractorInput);
        }
        if (!this.isLastPcrValueRead) {
            return readLastPcrValue(extractorInput, positionHolder, OplusGLSurfaceView_13);
        }
        if (this.lastPcrValue == -9223372036854775807L) {
            return finishReadDuration(extractorInput);
        }
        if (!this.isFirstPcrValueRead) {
            return readFirstPcrValue(extractorInput, positionHolder, OplusGLSurfaceView_13);
        }
        long OplusGLSurfaceView_15 = this.firstPcrValue;
        if (OplusGLSurfaceView_15 == -9223372036854775807L) {
            return finishReadDuration(extractorInput);
        }
        this.durationUs = this.pcrTimestampAdjuster.adjustTsTimestamp(this.lastPcrValue) - this.pcrTimestampAdjuster.adjustTsTimestamp(OplusGLSurfaceView_15);
        return finishReadDuration(extractorInput);
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public TimestampAdjuster getPcrTimestampAdjuster() {
        return this.pcrTimestampAdjuster;
    }

    private int finishReadDuration(ExtractorInput extractorInput) {
        this.packetBuffer.reset(Util.EMPTY_BYTE_ARRAY);
        this.isDurationRead = true;
        extractorInput.resetPeekPosition();
        return 0;
    }

    private int readFirstPcrValue(ExtractorInput extractorInput, PositionHolder positionHolder, int OplusGLSurfaceView_13) throws InterruptedException, IOException {
        int iMin = (int) Math.min(112800L, extractorInput.getLength());
        long OplusGLSurfaceView_15 = 0;
        if (extractorInput.getPosition() != OplusGLSurfaceView_15) {
            positionHolder.position = OplusGLSurfaceView_15;
            return 1;
        }
        this.packetBuffer.reset(iMin);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.packetBuffer.data, 0, iMin);
        this.firstPcrValue = readFirstPcrValueFromBuffer(this.packetBuffer, OplusGLSurfaceView_13);
        this.isFirstPcrValueRead = true;
        return 0;
    }

    private long readFirstPcrValueFromBuffer(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13) {
        int iLimit = parsableByteArray.limit();
        for (int position = parsableByteArray.getPosition(); position < iLimit; position++) {
            if (parsableByteArray.data[position] == 71) {
                long pcrFromPacket = TsUtil.readPcrFromPacket(parsableByteArray, position, OplusGLSurfaceView_13);
                if (pcrFromPacket != -9223372036854775807L) {
                    return pcrFromPacket;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int readLastPcrValue(ExtractorInput extractorInput, PositionHolder positionHolder, int OplusGLSurfaceView_13) throws InterruptedException, IOException {
        long length = extractorInput.getLength();
        int iMin = (int) Math.min(112800L, length);
        long OplusGLSurfaceView_15 = length - iMin;
        if (extractorInput.getPosition() != OplusGLSurfaceView_15) {
            positionHolder.position = OplusGLSurfaceView_15;
            return 1;
        }
        this.packetBuffer.reset(iMin);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.packetBuffer.data, 0, iMin);
        this.lastPcrValue = readLastPcrValueFromBuffer(this.packetBuffer, OplusGLSurfaceView_13);
        this.isLastPcrValueRead = true;
        return 0;
    }

    private long readLastPcrValueFromBuffer(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13) {
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        while (true) {
            iLimit--;
            if (iLimit < position) {
                return -9223372036854775807L;
            }
            if (parsableByteArray.data[iLimit] == 71) {
                long pcrFromPacket = TsUtil.readPcrFromPacket(parsableByteArray, iLimit, OplusGLSurfaceView_13);
                if (pcrFromPacket != -9223372036854775807L) {
                    return pcrFromPacket;
                }
            }
        }
    }
}
