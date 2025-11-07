package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
final class TsDurationReader {
    private static final int TIMESTAMP_SEARCH_BYTES = 112800;
    private boolean isDurationRead;
    private boolean isFirstPcrValueRead;
    private boolean isLastPcrValueRead;
    private final com.google.android.exoplayer2.util.TimestampAdjuster pcrTimestampAdjuster = new com.google.android.exoplayer2.util.TimestampAdjuster(0);
    private long firstPcrValue = -9223372036854775807L;
    private long lastPcrValue = -9223372036854775807L;
    private long durationUs = -9223372036854775807L;
    private final com.google.android.exoplayer2.util.ParsableByteArray packetBuffer = new com.google.android.exoplayer2.util.ParsableByteArray();

    TsDurationReader() {
    }

    public boolean isDurationReadFinished() {
        return this.isDurationRead;
    }

    public int readDuration(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder, int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        if (i_renamed <= 0) {
            return finishReadDuration(extractorInput);
        }
        if (!this.isLastPcrValueRead) {
            return readLastPcrValue(extractorInput, positionHolder, i_renamed);
        }
        if (this.lastPcrValue == -9223372036854775807L) {
            return finishReadDuration(extractorInput);
        }
        if (!this.isFirstPcrValueRead) {
            return readFirstPcrValue(extractorInput, positionHolder, i_renamed);
        }
        long j_renamed = this.firstPcrValue;
        if (j_renamed == -9223372036854775807L) {
            return finishReadDuration(extractorInput);
        }
        this.durationUs = this.pcrTimestampAdjuster.adjustTsTimestamp(this.lastPcrValue) - this.pcrTimestampAdjuster.adjustTsTimestamp(j_renamed);
        return finishReadDuration(extractorInput);
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public com.google.android.exoplayer2.util.TimestampAdjuster getPcrTimestampAdjuster() {
        return this.pcrTimestampAdjuster;
    }

    private int finishReadDuration(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) {
        this.packetBuffer.reset(com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY);
        this.isDurationRead = true;
        extractorInput.resetPeekPosition();
        return 0;
    }

    private int readFirstPcrValue(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder, int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        int iMin = (int) java.lang.Math.min(112800L, extractorInput.getLength());
        long j_renamed = 0;
        if (extractorInput.getPosition() != j_renamed) {
            positionHolder.position = j_renamed;
            return 1;
        }
        this.packetBuffer.reset(iMin);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.packetBuffer.data, 0, iMin);
        this.firstPcrValue = readFirstPcrValueFromBuffer(this.packetBuffer, i_renamed);
        this.isFirstPcrValueRead = true;
        return 0;
    }

    private long readFirstPcrValueFromBuffer(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
        int iLimit = parsableByteArray.limit();
        for (int position = parsableByteArray.getPosition(); position < iLimit; position++) {
            if (parsableByteArray.data[position] == 71) {
                long pcrFromPacket = com.google.android.exoplayer2.extractor.ts.TsUtil.readPcrFromPacket(parsableByteArray, position, i_renamed);
                if (pcrFromPacket != -9223372036854775807L) {
                    return pcrFromPacket;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int readLastPcrValue(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder, int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        long length = extractorInput.getLength();
        int iMin = (int) java.lang.Math.min(112800L, length);
        long j_renamed = length - iMin;
        if (extractorInput.getPosition() != j_renamed) {
            positionHolder.position = j_renamed;
            return 1;
        }
        this.packetBuffer.reset(iMin);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.packetBuffer.data, 0, iMin);
        this.lastPcrValue = readLastPcrValueFromBuffer(this.packetBuffer, i_renamed);
        this.isLastPcrValueRead = true;
        return 0;
    }

    private long readLastPcrValueFromBuffer(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        while (true) {
            iLimit--;
            if (iLimit < position) {
                return -9223372036854775807L;
            }
            if (parsableByteArray.data[iLimit] == 71) {
                long pcrFromPacket = com.google.android.exoplayer2.extractor.ts.TsUtil.readPcrFromPacket(parsableByteArray, iLimit, i_renamed);
                if (pcrFromPacket != -9223372036854775807L) {
                    return pcrFromPacket;
                }
            }
        }
    }
}
