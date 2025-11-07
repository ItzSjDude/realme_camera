package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
final class PsBinarySearchSeeker extends com.google.android.exoplayer2.extractor.BinarySearchSeeker {
    private static final int MINIMUM_SEARCH_RANGE_BYTES = 1000;
    private static final long SEEK_TOLERANCE_US = 100000;
    private static final int TIMESTAMP_SEARCH_BYTES = 20000;

    public PsBinarySearchSeeker(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, long j_renamed, long j2) {
        super(new com.google.android.exoplayer2.extractor.BinarySearchSeeker.DefaultSeekTimestampConverter(), new com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker.PsScrSeeker(timestampAdjuster), j_renamed, 0L, j_renamed + 1, 0L, j2, 188L, 1000);
    }

    private static final class PsScrSeeker implements com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker {
        private final com.google.android.exoplayer2.util.ParsableByteArray packetBuffer;
        private final com.google.android.exoplayer2.util.TimestampAdjuster scrTimestampAdjuster;

        private PsScrSeeker(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
            this.scrTimestampAdjuster = timestampAdjuster;
            this.packetBuffer = new com.google.android.exoplayer2.util.ParsableByteArray();
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult searchForTimestamp(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j_renamed, com.google.android.exoplayer2.extractor.BinarySearchSeeker.OutputFrameHolder outputFrameHolder) throws java.lang.InterruptedException, java.io.IOException {
            long position = extractorInput.getPosition();
            int iMin = (int) java.lang.Math.min(20000L, extractorInput.getLength() - position);
            this.packetBuffer.reset(iMin);
            extractorInput.peekFully(this.packetBuffer.data, 0, iMin);
            return searchForScrValueInBuffer(this.packetBuffer, j_renamed, position);
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public void onSeekFinished() {
            this.packetBuffer.reset(com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY);
        }

        private com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult searchForScrValueInBuffer(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed, long j2) {
            int position = -1;
            int position2 = -1;
            long j3 = -9223372036854775807L;
            while (parsableByteArray.bytesLeft() >= 4) {
                if (com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray.data, parsableByteArray.getPosition()) != 442) {
                    parsableByteArray.skipBytes(1);
                } else {
                    parsableByteArray.skipBytes(4);
                    long scrValueFromPack = com.google.android.exoplayer2.extractor.ts.PsDurationReader.readScrValueFromPack(parsableByteArray);
                    if (scrValueFromPack != -9223372036854775807L) {
                        long jAdjustTsTimestamp = this.scrTimestampAdjuster.adjustTsTimestamp(scrValueFromPack);
                        if (jAdjustTsTimestamp > j_renamed) {
                            if (j3 == -9223372036854775807L) {
                                return com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.overestimatedResult(jAdjustTsTimestamp, j2);
                            }
                            return com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j2 + position2);
                        }
                        if (com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker.SEEK_TOLERANCE_US + jAdjustTsTimestamp > j_renamed) {
                            return com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j2 + parsableByteArray.getPosition());
                        }
                        position2 = parsableByteArray.getPosition();
                        j3 = jAdjustTsTimestamp;
                    }
                    skipToEndOfCurrentPack(parsableByteArray);
                    position = parsableByteArray.getPosition();
                }
            }
            if (j3 != -9223372036854775807L) {
                return com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j3, j2 + position);
            }
            return com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
        }

        private static void skipToEndOfCurrentPack(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
            int iPeekIntAtPosition;
            int iLimit = parsableByteArray.limit();
            if (parsableByteArray.bytesLeft() < 10) {
                parsableByteArray.setPosition(iLimit);
                return;
            }
            parsableByteArray.skipBytes(9);
            int unsignedByte = parsableByteArray.readUnsignedByte() & 7;
            if (parsableByteArray.bytesLeft() < unsignedByte) {
                parsableByteArray.setPosition(iLimit);
                return;
            }
            parsableByteArray.skipBytes(unsignedByte);
            if (parsableByteArray.bytesLeft() >= 4) {
                if (com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray.data, parsableByteArray.getPosition()) == 443) {
                    parsableByteArray.skipBytes(4);
                    int unsignedShort = parsableByteArray.readUnsignedShort();
                    if (parsableByteArray.bytesLeft() < unsignedShort) {
                        parsableByteArray.setPosition(iLimit);
                        return;
                    }
                    parsableByteArray.skipBytes(unsignedShort);
                }
                while (parsableByteArray.bytesLeft() >= 4 && (iPeekIntAtPosition = com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray.data, parsableByteArray.getPosition())) != 442 && iPeekIntAtPosition != 441 && (iPeekIntAtPosition >>> 8) == 1) {
                    parsableByteArray.skipBytes(4);
                    if (parsableByteArray.bytesLeft() < 2) {
                        parsableByteArray.setPosition(iLimit);
                        return;
                    }
                    parsableByteArray.setPosition(java.lang.Math.min(parsableByteArray.limit(), parsableByteArray.getPosition() + parsableByteArray.readUnsignedShort()));
                }
                return;
            }
            parsableByteArray.setPosition(iLimit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int peekIntAtPosition(byte[] bArr, int i_renamed) {
        return (bArr[i_renamed + 3] & 255) | ((bArr[i_renamed] & 255) << 24) | ((bArr[i_renamed + 1] & 255) << 16) | ((bArr[i_renamed + 2] & 255) << 8);
    }
}
